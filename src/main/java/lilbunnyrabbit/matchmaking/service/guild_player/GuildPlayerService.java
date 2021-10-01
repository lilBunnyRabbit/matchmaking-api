package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;

import java.util.function.Consumer;

public interface GuildPlayerService {
    GuildPlayer getGuildPlayer(String guildId, String playerId);

    GuildPlayer createGuildPlayer(Guild guild, Player player);

    GuildPlayer createGuildPlayer(Guild guild, Player player, Consumer<GuildPlayer> callback);

    GuildPlayer updateGuildPlayer(String guildId, String playerId, Consumer<GuildPlayer> callback) throws GuildPlayerException;

    void registerGuildPlayer(String guildId, String playerId) throws GuildPlayerException;

    Queue queueGuildPlayer(String guildId, String playerId) throws GuildPlayerException;
}
