package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.config.DiscordConfiguration;
import lilbunnyrabbit.matchmaking.model.discord.DiscordApplicationCommand;
import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInvite;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
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
    public DiscordChannel createChannel(String guildId, DiscordChannel channel) {
        String url = this.GUILD_CHANNELS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DiscordChannel> entity = new HttpEntity<>(channel, headers);
        return restTemplate.postForObject(url, entity, DiscordChannel.class);
    }

    public DiscordInvite createChannelInvite(String channelId) { // Todo: with params
        String url = this.CHANNEL_INVITE_URL(channelId);
        HttpEntity<Void> entity = new HttpEntity<>(this.getJsonHeaders());
        return restTemplate.postForObject(url, entity, DiscordInvite.class);
    }

    // Slash Commands
    public DiscordApplicationCommand[] getGlobalCommands() {
        String url = this.GLOBAL_COMMANDS_URL();
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<DiscordApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, DiscordApplicationCommand[].class);
        return response.getBody();
    }

    public DiscordApplicationCommand[] getGuildCommands(String guildId) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<DiscordApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, DiscordApplicationCommand[].class);
        return response.getBody();
    }

    public DiscordApplicationCommand[] overwriteGuildCommands(String guildId, DiscordApplicationCommand[] commands) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DiscordApplicationCommand[]> entity = new HttpEntity<>(commands, headers);
        ResponseEntity<DiscordApplicationCommand[]> response = restTemplate.exchange(url, HttpMethod.PUT, entity, DiscordApplicationCommand[].class);
        return response.getBody();
    }

    public DiscordApplicationCommand createGuildCommand(String guildId, DiscordApplicationCommand command) {
        String url = this.GUILD_COMMANDS_URL(guildId);
        HttpHeaders headers = this.getJsonHeaders();
        HttpEntity<DiscordApplicationCommand> entity = new HttpEntity<>(command, headers);
        return restTemplate.postForObject(url, entity, DiscordApplicationCommand.class);
    }
}
