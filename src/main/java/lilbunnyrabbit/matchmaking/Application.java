package lilbunnyrabbit.matchmaking;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.repository.PlayerRepository;
import lilbunnyrabbit.matchmaking.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner createUsers() {
        return (args) -> {
            Guild guild = new Guild("guild1");
            guildRepository.save(guild);

            Player player1 = new Player("player1");
            playerRepository.save(player1);

            Player player2 = new Player("player2");
            playerRepository.save(player2);

            // Create guildplayer
            GuildPlayer guildPlayer1 = new GuildPlayer(guild, player1);
            guild.addGuildPlayer(guildPlayer1);
            GuildPlayer guildPlayer2 = new GuildPlayer(guild, player2);
            guild.addGuildPlayer(guildPlayer2);
            guildRepository.save(guild);

            // Create queue
            Queue queue1 = new Queue();
            queue1.addPlayer(guildPlayer1);
            guild.addQueue(queue1);
            Queue queue2 = new Queue();
            queue2.addPlayer(guildPlayer2);
            guild.addQueue(queue2);
            guildRepository.save(guild);

            // Remove players from queue
            guild.getGuildPlayers()
                    .stream()
                    .filter(guildPlayer -> guildPlayer.getId().equals(guildPlayer1.getId()))
                    .findAny()
                    .ifPresent(guildPlayer -> guildPlayer.setQueue(null));
            guildRepository.save(guild);

            // Remove queue
            guild.getQueues().remove(guildPlayer2.getQueue());
            guildPlayer2.getQueue().getPlayers().forEach(guildPlayer -> guildPlayer.setQueue(null));
            guildRepository.save(guild);
        };
    }
}
