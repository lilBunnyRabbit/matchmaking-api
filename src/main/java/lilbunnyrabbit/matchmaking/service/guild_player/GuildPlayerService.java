package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;

public interface GuildPlayerService {
    GuildPlayer getGuildPlayer(String guildId, String playerId);

    GuildPlayer createGuildPlayer(Guild guild, Player player) throws GuildPlayerException;
}
