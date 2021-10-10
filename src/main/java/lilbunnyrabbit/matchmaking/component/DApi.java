package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.config.DConfiguration;
import lilbunnyrabbit.matchmaking.model.discord.DApplicationCommand;
import lilbunnyrabbit.matchmaking.model.discord.DChannel;
import lilbunnyrabbit.matchmaking.model.discord.DInvite;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class DApi {
    public final String BASE_URL = "https://discord.com/api/v8";

    private final RestTemplate restTemplate;

    private final DConfiguration discordConfiguration;

    public DApi(RestTemplateBuilder restTemplateBuilder, DConfiguration discordConfiguration) {
        this.restTemplate = restTemplateBuilder.build();
        this.discordConfiguration = discordConfiguration;
    }

    // Url
    public String GUILD_URL(String guildId) {
        return this.BASE_URL + "/guilds/" + guildId;
    }

    public String GUILD_CHANNELS_URL(String guildId) {
        return this.GUILD_URL(guildId) + "/channels";
    }

    public String CHANNEL_URL(String channelId) {
        return this.BASE_URL + "/channels/" + channelId;
    }

    public String CHANNEL_INVITE_URL(String channelId) {
        return this.CHANNEL_URL(channelId) + "/invites";
    }

    public String APPLICATION_URL() {
        return BASE_URL + "/applications/" + discordConfiguration.getApplicationId();
    }

    public String GLOBAL_COMMANDS_URL() {
        return this.APPLICATION_URL() + "/commands";
    }

    public String GLOBAL_COMMAND_URL(String commandId) {
        return this.GLOBAL_COMMANDS_URL() + "/" + commandId;
    }

    public String GUILD_COMMANDS_URL(String guildId) {
        return this.APPLICATION_URL() + "/guilds/" + guildId + "/commands";
    }

    public String GUILD_COMMAND_URL(String guildId, String commandId) {
        return this.GUILD_COMMANDS_URL(guildId) + "/" + commandId;
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
    public DChannel createChannel(String guildId, DChannel channel) {
        String url = this.GUILD_CHANNELS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DChannel> entity = new HttpEntity<>(channel, headers);
        return restTemplate.postForObject(url, entity, DChannel.class);
    }

    public DInvite createChannelInvite(String channelId) { // Todo: with params
        String url = this.CHANNEL_INVITE_URL(channelId);
        HttpEntity<Void> entity = new HttpEntity<>(this.getJsonHeaders());
        return restTemplate.postForObject(url, entity, DInvite.class);
    }

    // Slash Commands
    public DApplicationCommand[] getGlobalCommands() {
        String url = this.GLOBAL_COMMANDS_URL();
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<DApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, DApplicationCommand[].class);
        return response.getBody();
    }

    public DApplicationCommand[] getGuildCommands(String guildId) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<DApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, DApplicationCommand[].class);
        return response.getBody();
    }

    public DApplicationCommand[] overwriteGuildCommands(String guildId, DApplicationCommand[] commands) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DApplicationCommand[]> entity = new HttpEntity<>(commands, headers);
        ResponseEntity<DApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.PUT, entity, DApplicationCommand[].class);
        return response.getBody();
    }

    public DApplicationCommand createGuildCommand(String guildId, DApplicationCommand command) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DApplicationCommand> entity = new HttpEntity<>(command, headers);
        return restTemplate.postForObject(url, entity, DApplicationCommand.class);
    }
}
