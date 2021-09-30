package lilbunnyrabbit.matchmaking.service.discord.api;

import lilbunnyrabbit.matchmaking.model.discord.Channel;
import lilbunnyrabbit.matchmaking.model.discord.Invite;

public interface DiscordApiService {
    void printObjectAsJson(Object object);
    Channel createVoiceChannel(String guildId, Channel channel);
    Invite createChannelInvite(String channelId);
}
