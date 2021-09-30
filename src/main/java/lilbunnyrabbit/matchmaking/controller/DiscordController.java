package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.model.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.validation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.model.discord.Interaction;
import lilbunnyrabbit.matchmaking.service.discord.action.DiscordActionService;
import lilbunnyrabbit.matchmaking.service.discord.command.DiscordCommandService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {
    private final DiscordCommandService discordCommandService;
    private final DiscordActionService discordActionService;

    public DiscordController(DiscordCommandService discordCommandService, DiscordActionService discordActionService) {
        this.discordCommandService = discordCommandService;
        this.discordActionService = discordActionService;
    }

    @PostMapping("/interaction")
    public InteractionResponse interaction(@ValidDiscordBody Interaction interaction) {
        return switch (interaction.getType()) {
            case Interaction.Type.PING -> InteractionResponse.PONG;
            case Interaction.Type.APPLICATION_COMMAND -> discordCommandService.commandHandler(interaction);
            case Interaction.Type.MESSAGE_COMPONENT -> discordActionService.actionHandler(interaction);
            default -> null;
        };
    }
}
