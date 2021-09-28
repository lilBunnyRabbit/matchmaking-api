package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;

public interface DiscordCommandService {
    InteractionResponse commandHandler(InteractionRequest interaction);
}
