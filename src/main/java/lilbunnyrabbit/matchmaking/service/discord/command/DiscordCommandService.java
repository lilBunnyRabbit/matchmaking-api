package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.model.request.InteractionRequest;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponse;

public interface DiscordCommandService {
    InteractionResponse commandHandler(InteractionRequest interaction);
}
