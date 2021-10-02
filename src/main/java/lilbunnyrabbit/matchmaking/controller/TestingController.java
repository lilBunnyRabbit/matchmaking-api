package lilbunnyrabbit.matchmaking.controller;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class TestingController {

    private GuildService guildService;
    private PlayerService playerService;
    private GuildPlayerService guildPlayerService;

    public TestingController(GuildService guildService, PlayerService playerService, GuildPlayerService guildPlayerService) {
        this.guildService = guildService;
        this.playerService = playerService;
        this.guildPlayerService = guildPlayerService;
    }

    @GetMapping("/guild/{id}")
    public Guild guildById(@PathVariable("id") String id) {
        return guildService.getGuild(id);
    }

    @GetMapping("/player/{id}")
    public Player playerById(@PathVariable("id") String id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("/guild/{guildId}/player/{playerId}")
    public GuildPlayer playerById(@PathVariable("guildId") String guildId, @PathVariable("playerId") String playerId) {
        return guildPlayerService.getGuildPlayer(guildId, playerId);
    }
}