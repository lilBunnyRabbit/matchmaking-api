package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.component.DActionHandler;
import lilbunnyrabbit.matchmaking.component.DCommandHandler;
import lilbunnyrabbit.matchmaking.model.discord.DInteractionResponse;
import lilbunnyrabbit.matchmaking.validation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.model.discord.DInteraction;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {

    final DCommandHandler discordCommandHandler;

    final DActionHandler discordActionHandler;

    public DiscordController(DCommandHandler discordCommandHandler, DActionHandler discordActionHandler) {
        this.discordCommandHandler = discordCommandHandler;
        this.discordActionHandler = discordActionHandler;
    }

    @PostMapping("/interaction")
    public DInteractionResponse interaction(@ValidDiscordBody DInteraction interaction) {
        return switch (interaction.getType()) {
            case DInteraction.Type.PING -> DInteractionResponse.PONG;
            case DInteraction.Type.APPLICATION_COMMAND -> discordCommandHandler.handle(interaction);
            case DInteraction.Type.MESSAGE_COMPONENT -> discordActionHandler.handle(interaction);
            default -> null;
        };
    }
}
