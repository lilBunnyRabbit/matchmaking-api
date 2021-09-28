package lilbunnyrabbit.matchmaking.service.guildPlayer;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayerId;

public interface GuildPlayerService {
    GuildPlayer getGuildPlayer(String guildId, String playerId);
    GuildPlayer createGuildPlayer(Guild guild, Player player);
    void setGuildPlayerQueue(GuildPlayerId guildPlayerId, Queue queue);
}
