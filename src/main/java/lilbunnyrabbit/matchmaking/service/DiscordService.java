package lilbunnyrabbit.matchmaking.service;

import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;

public interface DiscordService {
    String handleInteraction(DiscordInteractionRequest discordInteractionRequest);
}
