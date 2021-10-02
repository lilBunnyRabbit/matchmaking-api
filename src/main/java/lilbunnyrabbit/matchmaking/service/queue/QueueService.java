package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public interface QueueService {
    Queue getQueue(long queueId);

    List<Queue> getQueueByGuild(Guild guild, Queue.Status status);

    Queue createQueue(Guild guild);

    Queue createQueue(Guild guild, Consumer<Queue> callback);

    void deleteQueue(Queue queue);

    Queue updateQueue(long queueId, Consumer<Queue> callback) throws QueueException;

    Queue addPlayerToQueue(GuildPlayer guildPlayer) throws QueueException;

    Queue removePlayerFromQueue(GuildPlayer guildPlayer) throws QueueException;
}
