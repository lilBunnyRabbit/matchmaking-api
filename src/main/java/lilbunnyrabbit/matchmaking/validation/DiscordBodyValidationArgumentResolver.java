package lilbunnyrabbit.matchmaking.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.config.DiscordConfiguration;
import lilbunnyrabbit.matchmaking.exception.InvalidRequestSignatureException;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.MethodParameter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

public class DiscordBodyValidationArgumentResolver implements HandlerMethodArgumentResolver {

    private final ObjectMapper objectMapper;

    private final DiscordConfiguration discordConfiguration;

    public DiscordBodyValidationArgumentResolver(ObjectMapper objectMapper, DiscordConfiguration discordConfiguration) {
        this.objectMapper = objectMapper;
        this.discordConfiguration = discordConfiguration;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(ValidDiscordBody.class) != null;
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            ModelAndViewContainer modelAndViewContainer,
            NativeWebRequest nativeWebRequest,
            WebDataBinderFactory webDataBinderFactory
    ) throws Exception {
        HttpServletRequest httpServletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        if (httpServletRequest == null) throw new Error("httpServletRequest doesn't exist");

        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);

        // TODO: temporary
        System.out.println("body: " + new JSONObject(body).toString(4));

        String signature = httpServletRequest.getHeader("X-Signature-Ed25519");
        String timestamp = httpServletRequest.getHeader("X-Signature-Timestamp");

        if (signature == null || timestamp == null || !this.verifyBody(body, signature, timestamp)) {
            throw new InvalidRequestSignatureException();
        }

        return objectMapper.treeToValue(objectMapper.readTree(body), methodParameter.getParameterType());
    }

    private boolean verifyBody(String body, String signature, String timestamp) throws Exception {
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
        byte[] keyBytes = Hex.decode(discordConfiguration.getPublicKey());
        SubjectPublicKeyInfo publicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), keyBytes);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyInfo.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("ed25519", provider);
        Signature signatureInstance = Signature.getInstance("ed25519", provider);
        signatureInstance.initVerify(keyFactory.generatePublic(publicKeySpec));
        signatureInstance.update(timestamp.getBytes());
        signatureInstance.update(body.getBytes());
        return signatureInstance.verify(Hex.decode(signature));
    }
}