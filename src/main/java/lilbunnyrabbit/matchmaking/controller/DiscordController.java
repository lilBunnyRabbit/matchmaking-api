package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.annotation.ValidDiscordBody;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.service.discord.DiscordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discord")
public class DiscordController {
    private final DiscordService discordService;

    public DiscordController(DiscordService discordService) {
        this.discordService = discordService;
    }

    @PostMapping("/interaction")
    public InteractionResponse interaction(@ValidDiscordBody InteractionRequest discordInteractionRequest) {
        return discordService.handleInteraction(discordInteractionRequest);
    }
}
