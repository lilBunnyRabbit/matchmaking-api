package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;
import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.repository.QueueRepository;
import lilbunnyrabbit.matchmaking.service.discord.api.DiscordApiService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;

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
        Queue queue = new Queue(guild);
        queueRepository.save(queue);
        return queue;
    }

    @Override
    public Queue createQueue(Guild guild, Consumer<Queue> callback) {
        Queue queue = new Queue(guild);
        if (callback != null) callback.accept(queue);
        queueRepository.save(queue);
        return queue;
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

        Queue finalQueue;
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

            finalQueue = this.updateQueue(queue.getId(), (queueCallback) -> {
                queueCallback.setLobbyChannel(lobbyChannel.getId());
            });
        } else {
            finalQueue = this.updateQueue(queue.getId(), (queueCallback) -> {
                Set<GuildPlayer> players = new HashSet<>();
                players.add(guildPlayer);
                queueCallback.setPlayers(players);
            });
        }

        GuildPlayerId guildPlayerId = guildPlayer.getId();
        try {
            guildPlayerService.updateGuildPlayer(guildPlayerId.getGuildId(), guildPlayerId.getPlayerId(), (guildPlayerCallback -> {
                guildPlayerCallback.setQueue(finalQueue);
            }));

            return finalQueue;
        } catch (GuildPlayerException e) {
            e.printStackTrace();
            throw new QueueException(QueueException.Issue.FAILED_SAVE_QUEUE_TO_PLAYER);
        }
    }
}
