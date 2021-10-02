package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;

import java.util.Set;
import java.util.function.Consumer;

public interface GuildService {
    Guild getGuild(String guildId);

    Guild createGuild(String guildId);

    Guild createGuild(String guildId, Consumer<Guild> callback);

    Guild guildInit(String guildId) throws GuildException;

    GuildPlayer createGuildPlayer(Guild guild, Player player) throws GuildException;

    Queue createQueue(Guild guild, Set<GuildPlayer> guildPlayers);
}
