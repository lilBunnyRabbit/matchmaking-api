package lilbunnyrabbit.matchmaking.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.annotation.DiscordBodyValidationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class DiscordBodyValidationConfiguration implements WebMvcConfigurer {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DiscordConfiguration discordConfiguration;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new DiscordBodyValidationArgumentResolver(objectMapper, discordConfiguration));
    }
}