package lilbunnyrabbit.matchmaking.service.match;

import lilbunnyrabbit.matchmaking.entity.Match;
import lilbunnyrabbit.matchmaking.entity.match_player.MatchPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.MatchException;
import lilbunnyrabbit.matchmaking.repository.MatchRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class MatchServiceImpl implements MatchService{

    private final MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match createMatch(){
        Match match = new Match();
        matchRepository.save(match);

        return match;
    }

    @Override
    public void addPLayers(Match match, Set<GuildPlayer> guildPlayers) throws MatchException {
        if(guildPlayers == null || guildPlayers.size() == 0){
            throw new MatchException(MatchException.Code.NOT_ENOUGH_PLAYERS);
        }

        guildPlayers.forEach(guildPlayer -> match.addPlayer(new MatchPlayer(guildPlayer, match)));
        matchRepository.save(match);
    }
}
