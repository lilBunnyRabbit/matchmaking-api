package lilbunnyrabbit.matchmaking.api.argumentResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.api.configuration.DiscordConfiguration;
import lilbunnyrabbit.matchmaking.api.response.exception.InvalidRequestSignatureException;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.core.MethodParameter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.Security;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class DiscordBodyValidationArgumentResolver implements HandlerMethodArgumentResolver {
    private final boolean validate = true;
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

        String rawBody = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);

        if (this.validate) {
            String signature = httpServletRequest.getHeader("X-Signature-Ed25519");
            String timestamp = httpServletRequest.getHeader("X-Signature-Timestamp");

            if (signature == null || timestamp == null) throw new InvalidRequestSignatureException();

            /* Verify */ {
                final var provider = new BouncyCastleProvider();
                Security.addProvider(provider);
                final var byteKey = Hex.decode(discordConfiguration.getPublicKey());
                final var pki = new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), byteKey);
                final var pkSpec = new X509EncodedKeySpec(pki.getEncoded());
                final var kf = KeyFactory.getInstance("ed25519", provider);
                final var pubKey = kf.generatePublic(pkSpec);
                final var signedData = Signature.getInstance("ed25519", provider);
                signedData.initVerify(pubKey);
                signedData.update(timestamp.getBytes());
                signedData.update(rawBody.getBytes());
                if (!signedData.verify(Hex.decode(signature))) throw new InvalidRequestSignatureException();
            }
        }

        return objectMapper.treeToValue(objectMapper.readTree(rawBody), methodParameter.getParameterType());
    }
}