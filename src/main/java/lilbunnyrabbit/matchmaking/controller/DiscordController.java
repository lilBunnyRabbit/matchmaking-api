package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.component.DiscordActionHandler;
import lilbunnyrabbit.matchmaking.component.DiscordCommandHandler;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.validation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {

    final DiscordCommandHandler discordCommandHandler;

    final DiscordActionHandler discordActionHandler;

    public DiscordController(DiscordCommandHandler discordCommandHandler, DiscordActionHandler discordActionHandler) {
        this.discordCommandHandler = discordCommandHandler;
        this.discordActionHandler = discordActionHandler;
    }

    @PostMapping("/interaction")
    public DiscordInteractionResponse interaction(@ValidDiscordBody DiscordInteraction interaction) {
        return switch (interaction.getType()) {
            case DiscordInteraction.Type.PING -> DiscordInteractionResponse.PONG;
            case DiscordInteraction.Type.APPLICATION_COMMAND -> discordCommandHandler.handle(interaction);
            case DiscordInteraction.Type.MESSAGE_COMPONENT -> discordActionHandler.handle(interaction);
            default -> null;
        };
    }
}
