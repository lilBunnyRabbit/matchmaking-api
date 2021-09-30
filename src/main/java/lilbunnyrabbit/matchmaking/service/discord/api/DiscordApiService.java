package lilbunnyrabbit.matchmaking.service.discord.api;

import lilbunnyrabbit.matchmaking.model.request.VoiceChannelRequest;
import lilbunnyrabbit.matchmaking.model.response.InviteResponse;
import lilbunnyrabbit.matchmaking.model.response.VoiceChannelResponse;

public interface DiscordApiService {
    void printObjectAsJson(Object object);
    VoiceChannelResponse createVoiceChannel(String guildId, VoiceChannelRequest voiceChannelRequest);
    InviteResponse createChannelInvite(String channelId);
}
