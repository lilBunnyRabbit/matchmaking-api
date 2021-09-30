package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;

public interface DiscordCommandService {
    DiscordInteractionResponse commandHandler(DiscordInteraction interaction);
}
