package lilbunnyrabbit.matchmaking.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.config.DConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class DBodyValidationConfiguration implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    private final DConfiguration discordConfiguration;

    public DBodyValidationConfiguration(ObjectMapper objectMapper, DConfiguration discordConfiguration) {
        this.objectMapper = objectMapper;
        this.discordConfiguration = discordConfiguration;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DBodyValidationArgumentResolver(objectMapper, discordConfiguration));
    }
}