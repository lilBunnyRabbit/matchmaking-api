package lilbunnyrabbit.matchmaking.api.controller;

import lilbunnyrabbit.matchmaking.api.argumentResolver.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.service.DiscordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {
    private final DiscordService discordService;

    public DiscordController(DiscordService discordService) {
        this.discordService = discordService;
    }

    @PostMapping("/interaction")
    public DiscordInteractionResponse interaction(@ValidDiscordBody DiscordInteractionRequest discordInteractionRequest) {
        System.out.println("DiscordInteractionRequest ID: " + discordInteractionRequest.getId());
        return discordService.handleInteraction(discordInteractionRequest);
    }
}
