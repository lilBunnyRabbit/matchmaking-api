package lilbunnyrabbit.matchmaking.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.config.DiscordConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class DiscordBodyValidationConfiguration implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

    private final DiscordConfiguration discordConfiguration;

    public DiscordBodyValidationConfiguration(ObjectMapper objectMapper, DiscordConfiguration discordConfiguration) {
        this.objectMapper = objectMapper;
        this.discordConfiguration = discordConfiguration;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DiscordBodyValidationArgumentResolver(objectMapper, discordConfiguration));
    }
}