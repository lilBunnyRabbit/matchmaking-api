package lilbunnyrabbit.matchmaking.entity.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GuildPlayerId implements Serializable {
    @Column(name = "guildId")
    private String guildId;

    @Column(name = "playerId")
    private String playerId;

    public GuildPlayerId() {}

    public GuildPlayerId(Guild guild, Player player) {
        this.guildId = guild.getId();
        this.playerId = player.getId();
    }

    public GuildPlayerId(String guildId, String playerId) {
        this.guildId = guildId;
        this.playerId = playerId;
    }

// TODO: Include?
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(guildId + playerId);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        GuildPlayerId that = (GuildPlayerId) o;
//        return Objects.equals(guildId, that.guildId) && Objects.equals(playerId, that.playerId);
//    }

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