package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;

import java.util.Set;

public interface QueueService {
    Queue getQueue(long queueId);
    Queue createQueue(Guild guild);
    Queue createQueueWithPlayers(Guild guild, Set<GuildPlayer> players);
}
