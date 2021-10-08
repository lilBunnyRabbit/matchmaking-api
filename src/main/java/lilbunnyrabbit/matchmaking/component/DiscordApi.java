package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.config.DiscordConfiguration;
import lilbunnyrabbit.matchmaking.helpers.DiscordApiHelper;
import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInvite;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class DiscordApi {
    public final String BASE_URL = "https://discord.com/api/v8";

    private final RestTemplate restTemplate;

    private final DiscordConfiguration discordConfiguration;

    public DiscordApi(RestTemplateBuilder restTemplateBuilder, DiscordConfiguration discordConfiguration) {
        this.restTemplate = restTemplateBuilder.build();
        this.discordConfiguration = discordConfiguration;
    }

    // Url
    private String GUILD_URL(String guildId) {
        return this.BASE_URL + "/guilds/" + guildId;
    }

    private String GUILD_CHANNELS_URL(String guildId) {
        return this.GUILD_URL(guildId) + "/channels";
    }

    private String CHANNEL_URL(String channelId) {
        return this.BASE_URL + "/channels/" + channelId;
    }

    private String CHANNEL_INVITE_URL(String channelId) {
        return this.CHANNEL_URL(channelId) + "/invites";
    }

    // Helpers
    private HttpHeaders getJsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bot " + discordConfiguration.getBotToken());
        return headers;
    }

    // Requests
    public DiscordChannel createChannel(String guildId, DiscordChannel channel) {
        String url = this.GUILD_CHANNELS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DiscordChannel> entity = new HttpEntity<>(channel, headers);

        DiscordApiHelper.printRequest("POST", url, entity);

        return this.restTemplate.postForObject(url, entity, DiscordChannel.class);
    }

    public DiscordInvite createChannelInvite(String channelId) { // Todo: with params
        String url = this.CHANNEL_INVITE_URL(channelId);
        HttpEntity<String> entity = new HttpEntity<>("{}", this.getJsonHeaders());

        DiscordApiHelper.printRequest("POST", url, entity);

        return this.restTemplate.postForObject(url, entity, DiscordInvite.class);
    }
}
