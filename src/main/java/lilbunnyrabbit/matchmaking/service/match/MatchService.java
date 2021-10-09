package lilbunnyrabbit.matchmaking.service.match;

import lilbunnyrabbit.matchmaking.entity.Match;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.MatchException;

import java.util.Set;

public interface MatchService {
    Match createMatch();

    void addPLayers(Match match, Set<GuildPlayer> guildPlayers) throws MatchException;
}
