package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.request.InteractionRequest;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponse;

public interface DiscordActionService {
    InteractionResponse actionHandler(InteractionRequest interaction);
}
