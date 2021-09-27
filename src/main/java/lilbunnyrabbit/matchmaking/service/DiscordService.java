package lilbunnyrabbit.matchmaking.service;

import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.DiscordInteractionResponse;

public interface DiscordService {
    DiscordInteractionResponse handleInteraction(DiscordInteractionRequest discordInteractionRequest);
}
