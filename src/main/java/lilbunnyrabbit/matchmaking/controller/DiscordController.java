package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.validation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.model.request.InteractionRequest;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponse;
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
    public InteractionResponse interaction(@ValidDiscordBody InteractionRequest discordInteractionRequest) {
        return switch (discordInteractionRequest.getType()) {
            case InteractionRequest.Type.PING -> new InteractionResponse(InteractionResponse.Type.PONG);
            case InteractionRequest.Type.APPLICATION_COMMAND -> discordCommandService.commandHandler(discordInteractionRequest);
            case InteractionRequest.Type.MESSAGE_COMPONENT -> discordActionService.actionHandler(discordInteractionRequest);
            default -> null;
        };
    }
}
