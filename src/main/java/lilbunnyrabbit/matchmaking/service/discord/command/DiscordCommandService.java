package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.model.discord.Interaction;
import lilbunnyrabbit.matchmaking.model.discord.InteractionResponse;

public interface DiscordCommandService {
    InteractionResponse commandHandler(Interaction interaction);
}
