package lilbunnyrabbit.matchmaking.entity.match_player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lilbunnyrabbit.matchmaking.entity.Match;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;

import javax.persistence.*;

@Entity
@Table(name = "MATCH_PLAYER")
public class MatchPlayer {
    @EmbeddedId
    private MatchPlayerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("matchId")
    @JoinColumn(name = "match_id", insertable = false, updatable = false)
    @JsonIgnore
    private Match match;

    public MatchPlayer(){}

    public MatchPlayer(GuildPlayer guildPlayer, Match match){
        this.id = new MatchPlayerId(guildPlayer, match);
    }

    public MatchPlayerId getId() {
        return id;
    }

    public void setId(MatchPlayerId id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
