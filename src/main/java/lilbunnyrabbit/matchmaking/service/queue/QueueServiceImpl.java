package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;
import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.repository.QueueRepository;
import lilbunnyrabbit.matchmaking.service.discord.api.DiscordApiService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
@Transactional
public class QueueServiceImpl implements QueueService {

    @Autowired
    private GuildRepository guildRepository;

    @Autowired
    private GuildPlayerRepository guildPlayerRepository;

    @Override
    public Queue createQueue(Guild guild, Set<GuildPlayer> guildPlayers) {
        Queue queue = new Queue();
        if (guildPlayers != null) {
            guildPlayers.forEach(queue::addPlayer);
        }

        guild.addQueue(queue);
        guildRepository.save(guild);
        return queue;
    }

    @Override
    public void deleteQueue(Queue queue) {
        queue.getPlayers().forEach(queue::removePlayer);
        Guild guild = queue.getGuild();
        guild.getQueues().remove(queue);
        guildRepository.save(guild);
    }

    @Override
    public Queue removePlayerFromQueue(GuildPlayer guildPlayer) throws QueueException {
        Queue queue = guildPlayer.getQueue();
        if (queue == null) {
            throw new QueueException(QueueException.Issue.PLAYER_NOT_IN_QUEUE);
        }
        queue.removePlayer(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return queue;
    }

    @Override
    public Queue addPlayerToQueue(GuildPlayer guildPlayer, Queue queue) throws QueueException {
        if (guildPlayer.getQueue() != null) {
            throw new QueueException(QueueException.Issue.PLAYER_IN_QUEUE);
        }
        queue.addPlayer(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return queue;
    }
}
