package lilbunnyrabbit.matchmaking.service.guildPlayer;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;

public interface GuildPlayerService {
    GuildPlayer getGuildPlayer(String guildId, String playerId);
    GuildPlayer createGuildPlayer(Guild guild, Player player);
}
