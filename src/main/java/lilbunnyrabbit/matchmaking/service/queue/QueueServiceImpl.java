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
    private QueueRepository queueRepository;

    @Autowired
    private GuildRepository guildRepository;

    @Autowired
    private GuildPlayerRepository guildPlayerRepository;

    @Autowired
    private GuildPlayerService guildPlayerService;

    @Autowired
    private DiscordApiService discordApiService;

    @Override
    public Queue getQueue(long queueId) {
        Optional<Queue> optionalQueue = queueRepository.findById(queueId);
        return optionalQueue.orElse(null);
    }

    @Override
    public List<Queue> getQueueByGuild(Guild guild, Queue.Status status) {
        Optional<List<Queue>> optionalQueueList;
        if (status == null) {
            optionalQueueList = queueRepository.findByGuild(guild);
        } else {
            optionalQueueList = queueRepository.findByGuildAndStatus(guild, status);
        }

        return optionalQueueList.orElse(null);
    }

    @Override
    public Queue createQueue(Guild guild) {
        return this.createQueue(guild, null);
    }

    @Override
    public Queue createQueue(Guild guild, Consumer<Queue> callback) {
        Queue queue = new Queue(guild);
        if (callback != null) callback.accept(queue);
        queueRepository.save(queue);

        Set<Queue> queues = guild.getQueues();
        if (queues == null) queues = new HashSet<>();

        queues.add(queue);
        guild.setQueues(queues);
        guildRepository.save(guild);

        return queue;
    }

    @Override
    public void deleteQueue(Queue queue) {
        queue.setGuild(null);
        queue.setPlayers(null);
        queueRepository.save(queue);

        queueRepository.deleteById(queue.getId());

        queue.getPlayers().forEach((guildPlayer -> {
            guildPlayer.setQueue(null);
            guildPlayerRepository.save(guildPlayer);
        }));

        Guild guild = queue.getGuild();
        guild.getQueues().remove(queue);
        guildRepository.save(guild);
    }

    @Override
    public Queue updateQueue(long queueId, Consumer<Queue> callback) throws QueueException {
        Queue queue = this.getQueue(queueId);
        if (queue == null) {
            throw new QueueException(QueueException.Issue.QUEUE_NOT_EXISTS);
        }

        if (callback != null) callback.accept(queue);
        queueRepository.save(queue);
        return queue;
    }

    @Override
    public Queue addPlayerToQueue(GuildPlayer guildPlayer) throws QueueException {
        Guild guild = guildPlayer.getGuild();
        List<Queue> queues = this.getQueueByGuild(guildPlayer.getGuild(), Queue.Status.WAITING);
        Queue queue = queues.size() == 0 ? null : queues.get(0);

        if (queue == null) {
            queue = this.createQueue(guild, (queueCallback) -> {
                Set<GuildPlayer> players = new HashSet<>();
                players.add(guildPlayer);
                queueCallback.setPlayers(players);
            });

            DiscordChannel lobbyChannelRequest = DiscordChannel.GUILD_VOICE(queue.getId() + " - Lobby");
            lobbyChannelRequest.setParentId(guild.getCategoryId());

            DiscordChannel lobbyChannel = discordApiService.createChannel(guild.getId(), lobbyChannelRequest);

            if (lobbyChannel == null) {
                throw new QueueException(QueueException.Issue.FAILED_CREATE_LOBBY_VC);
            }

            queue = this.updateQueue(queue.getId(), (queueCallback) -> {
                queueCallback.setLobbyChannel(lobbyChannel.getId());
            });
        } else {
            queue = this.updateQueue(queue.getId(), (queueCallback) -> {
                Set<GuildPlayer> players = new HashSet<>();
                players.add(guildPlayer);
                queueCallback.setPlayers(players);
            });
        }

        guildPlayer.setQueue(queue);
        guildPlayerRepository.save(guildPlayer);

        return queue;
    }

    @Override
    public Queue removePlayerFromQueue(GuildPlayer guildPlayer) throws QueueException {
        Queue queue = guildPlayer.getQueue();

        boolean isRemoved = queue.getPlayers().remove(guildPlayer);
        if (!isRemoved) {
            throw new QueueException(QueueException.Issue.PLAYER_NOT_IN_QUEUE);
        }

        if (queue.getPlayers().isEmpty()) {
            this.deleteQueue(queue);
            return null;
        } else {
            queueRepository.save(queue);
        }

        return queue;
    }
}
