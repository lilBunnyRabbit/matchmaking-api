package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class QueueServiceImpl implements QueueService {

    private final GuildRepository guildRepository;

    private final GuildPlayerRepository guildPlayerRepository;

    public QueueServiceImpl(GuildRepository guildRepository, GuildPlayerRepository guildPlayerRepository) {
        this.guildRepository = guildRepository;
        this.guildPlayerRepository = guildPlayerRepository;
    }

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
            throw new QueueException(QueueException.Code.PLAYER_NOT_IN_QUEUE);
        }
        queue.removePlayer(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return queue;
    }

    @Override
    public Queue addPlayerToQueue(GuildPlayer guildPlayer, Queue queue) throws QueueException {
        if (guildPlayer.getQueue() != null) {
            throw new QueueException(QueueException.Code.PLAYER_IN_QUEUE);
        }
        queue.addPlayer(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return queue;
    }
}
