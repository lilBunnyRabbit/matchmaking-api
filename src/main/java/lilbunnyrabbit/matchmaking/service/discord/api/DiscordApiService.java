package lilbunnyrabbit.matchmaking.service.discord.api;

import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInvite;

public interface DiscordApiService {
    void printObjectAsJson(Object object);
    DiscordChannel createVoiceChannel(String guildId, DiscordChannel channel);
    DiscordInvite createChannelInvite(String channelId);
}
