package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.discord.Interaction;
import lilbunnyrabbit.matchmaking.model.discord.InteractionResponse;

public interface DiscordActionService {
    InteractionResponse actionHandler(Interaction interaction);
}
