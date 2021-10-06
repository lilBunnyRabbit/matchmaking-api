package lilbunnyrabbit.matchmaking.service.queue;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;

import java.util.Set;

public interface QueueService {

    Queue createQueue(Guild guild, Set<GuildPlayer> guildPlayers);

    void deleteQueue(Queue queue);

    Queue removePlayerFromQueue(GuildPlayer guildPlayer) throws QueueException;

    Queue addPlayerToQueue(GuildPlayer guildPlayer, Queue queue) throws QueueException;
}
