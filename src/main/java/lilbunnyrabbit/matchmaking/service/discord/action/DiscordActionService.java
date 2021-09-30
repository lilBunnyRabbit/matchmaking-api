package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;

public interface DiscordActionService {
    DiscordInteractionResponse actionHandler(DiscordInteraction interaction);
}
