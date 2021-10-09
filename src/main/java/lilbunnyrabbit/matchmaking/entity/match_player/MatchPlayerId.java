package lilbunnyrabbit.matchmaking.entity.match_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Match;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MatchPlayerId implements Serializable {
    @Column(name = "guild_id")
    private String guildId;

    @Column(name = "player_id")
    private String playerId;

    @Column(name = "match_id")
    private long matchId;

    public MatchPlayerId() {}

    public MatchPlayerId(GuildPlayer guildPlayer, Match match) {
        this.guildId = guildPlayer.getGuild().getId();
        this.playerId = guildPlayer.getId().getPlayerId();
        this.matchId = match.getId();
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

}
