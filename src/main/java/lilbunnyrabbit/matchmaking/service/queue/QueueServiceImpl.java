package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.repository.QueueRepository;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private GuildPlayerService guildPlayerService;

    @Override
    public Queue getQueue(long queueId) {
        Optional<Queue> optionalQueue = queueRepository.findById(queueId);
        return optionalQueue.orElse(null);
    }

    @Override
    public Queue createQueue(Guild guild) {
        Queue queue = new Queue(guild);
        queueRepository.save(queue);
        return queue;
    }

    @Override
    public Queue createQueueWithPlayers(Guild guild, Set<GuildPlayer> players) {
        Queue queue = new Queue(guild);
        queue.setPlayers(players);
        queueRepository.save(queue);

        players.forEach((guildPlayer) -> guildPlayerService.setGuildPlayerQueue(guildPlayer.getId(), queue));
        return queue;
    }
}
