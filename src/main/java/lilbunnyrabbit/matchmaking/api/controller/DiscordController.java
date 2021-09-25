package lilbunnyrabbit.matchmaking.api.controller;

import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;
import lilbunnyrabbit.matchmaking.service.DiscordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {
    private final DiscordService discordService;

    public DiscordController(DiscordService discordService) {
        this.discordService = discordService;
    }

    @PostMapping("")
    public String interaction(@RequestBody DiscordInteractionRequest discordInteractionRequest) {
        return discordService.handleInteraction(discordInteractionRequest);
    }
}
