package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;

public interface DiscordActionService {
    InteractionResponse actionHandler(InteractionRequest interaction);
}
