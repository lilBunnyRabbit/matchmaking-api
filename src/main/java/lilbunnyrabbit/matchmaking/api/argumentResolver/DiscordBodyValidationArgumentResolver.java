package lilbunnyrabbit.matchmaking.api.argumentResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

public class DiscordBodyValidationArgumentResolver implements HandlerMethodArgumentResolver {
    private final ObjectMapper objectMapper;

    public DiscordBodyValidationArgumentResolver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
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
        if (httpServletRequest == null) throw new Exception("Bad request");

        String signature = httpServletRequest.getHeader("X-Signature-Ed25519");
        String timestamp = httpServletRequest.getHeader("X-Signature-Timestamp");
        String jsonPayload = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);

        System.out.println("X-Signature-Ed25519: " + signature);
        System.out.println("X-Signature-Timestamp: " + timestamp);
        System.out.println("rawBody: " + jsonPayload);

        // TODO: Verify request

        return objectMapper.treeToValue(objectMapper.readTree(jsonPayload), methodParameter.getParameterType());
    }
}