package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;

public interface GuildPlayerService {
    GuildPlayer getGuildPlayer(String guildId, String playerId);
    GuildPlayer createGuildPlayer(Guild guild, Player player);
    void setGuildPlayerQueue(GuildPlayerId guildPlayerId, Queue queue);
}
