package lilbunnyrabbit.matchmaking;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Match;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.repository.PlayerRepository;
import lilbunnyrabbit.matchmaking.repository.QueueRepository;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import lilbunnyrabbit.matchmaking.service.match.MatchService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import lilbunnyrabbit.matchmaking.service.queue.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class Application {

    @Autowired
    GuildRepository guildRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GuildPlayerRepository guildPlayerRepository;

    @Autowired
    QueueRepository queueRepository;

    @Autowired
    GuildService guildService;

    @Autowired
    PlayerService playerService;

    @Autowired
    QueueService queueService;

    @Autowired
    GuildPlayerService guildPlayerService;

    @Autowired
    MatchService matchService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createUsers() {
        return (args) -> {
            Guild guild = guildService.createGuild("guild1");

            Player player1 = playerService.createPlayer("player1");
            Player player2 = playerService.createPlayer("player2");

            // Create guildplayer
            GuildPlayer guildPlayer1 = guildPlayerService.createGuildPlayer(guild, player1);
            GuildPlayer guildPlayer2 = guildPlayerService.createGuildPlayer(guild, player2);

            Match match = matchService.createMatch();
            matchService.addPLayers(match, new HashSet<>(Arrays.asList(guildPlayer1, guildPlayer2)));

            // Create queue
            Queue queue1 = queueService.createQueue(guild, Set.of(guildPlayer1));
            Queue queue2 = queueService.createQueue(guild, Set.of(guildPlayer2));
            guildRepository.save(guild);

            // Remove players from queue
            queueService.removePlayerFromQueue(guildPlayer1);

            // Remove queue
            queueService.deleteQueue(guildPlayer2.getQueue());
        };
    }
}
