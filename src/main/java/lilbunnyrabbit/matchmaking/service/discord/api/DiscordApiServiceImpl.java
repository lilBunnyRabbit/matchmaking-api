package lilbunnyrabbit.matchmaking.service.discord.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lilbunnyrabbit.matchmaking.configuration.DiscordConfiguration;
import lilbunnyrabbit.matchmaking.service.discord.api.request.VoiceChannelRequest;
import lilbunnyrabbit.matchmaking.service.discord.api.response.InviteResponse;
import lilbunnyrabbit.matchmaking.service.discord.api.response.VoiceChannelResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class DiscordApiServiceImpl implements DiscordApiService {
    public final String BASE_URL = "https://discord.com/api/v8";

    private final RestTemplate restTemplate;
    private final DiscordConfiguration discordConfiguration;

    public DiscordApiServiceImpl(RestTemplateBuilder restTemplateBuilder, DiscordConfiguration discordConfiguration) {
        this.restTemplate = restTemplateBuilder.build();
        this.discordConfiguration = discordConfiguration;
    }

    // Helpers
    public void printObjectAsJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(object);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public <T> void printRequest(String type, String url, HttpEntity<T> httpEntity) {
        System.out.println(type.toUpperCase() + " " + url);
        System.out.print("- Headers: ");
        System.out.println(httpEntity.getHeaders());
        System.out.print("- Body: ");
        this.printObjectAsJson(httpEntity.getBody());
    }

    // Headers helpers
    private HttpHeaders getJsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bot " + discordConfiguration.getBotToken());
        return headers;
    }

    // Path helpers
    private String getGuildPath(String guildId) {
        return this.BASE_URL + "/guilds/" + guildId;
    }

    private String getChannelPath(String channelId) {
        return this.BASE_URL + "/channels/" + channelId;
    }

    public VoiceChannelResponse createVoiceChannel(String guildId, VoiceChannelRequest voiceChannelRequest) {
        String url = this.getGuildPath(guildId) + "/channels";
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<VoiceChannelRequest> entity = new HttpEntity<>(voiceChannelRequest, headers);

        this.printRequest("POST", url, entity);

        return this.restTemplate.postForObject(url, entity, VoiceChannelResponse.class);
    }

    @Override
    public InviteResponse createChannelInvite(String channelId) { // Todo: with params
        String url = this.getChannelPath(channelId) + "/invites";
        HttpEntity<String> entity = new HttpEntity<>("{}", this.getJsonHeaders());

        this.printRequest("POST", url, entity);

        return this.restTemplate.postForObject(url, entity, InviteResponse.class);
    }
}
