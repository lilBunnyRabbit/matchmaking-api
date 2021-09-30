package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.validation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
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
    public DiscordInteractionResponse interaction(@ValidDiscordBody DiscordInteraction interaction) {
        return switch (interaction.getType()) {
            case DiscordInteraction.Type.PING -> DiscordInteractionResponse.PONG;
            case DiscordInteraction.Type.APPLICATION_COMMAND -> discordCommandService.commandHandler(interaction);
            case DiscordInteraction.Type.MESSAGE_COMPONENT -> discordActionService.actionHandler(interaction);
            default -> null;
        };
    }
}
