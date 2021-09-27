package lilbunnyrabbit.matchmaking.service;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;

public interface DiscordService {
    InteractionResponse handleInteraction(InteractionRequest discordInteractionRequest);
}
