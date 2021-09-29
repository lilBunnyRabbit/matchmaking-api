package lilbunnyrabbit.matchmaking.service.discord.api;

import lilbunnyrabbit.matchmaking.service.discord.api.request.VoiceChannelRequest;
import lilbunnyrabbit.matchmaking.service.discord.api.response.InviteResponse;
import lilbunnyrabbit.matchmaking.service.discord.api.response.VoiceChannelResponse;

public interface DiscordApiService {
    void printObjectAsJson(Object object);
    VoiceChannelResponse createVoiceChannel(String guildId, VoiceChannelRequest voiceChannelRequest);
    InviteResponse createChannelInvite(String channelId);
}
