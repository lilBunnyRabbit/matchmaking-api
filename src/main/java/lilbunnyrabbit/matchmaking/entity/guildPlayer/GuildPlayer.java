package lilbunnyrabbit.matchmaking.entity.guildPlayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;

import javax.persistence.*;

@Entity
@Table(name = "GUILD_PLAYER")
public class GuildPlayer {

    @EmbeddedId
    GuildPlayerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("guildId")
    @JoinColumn(name = "guild_id")
    @JsonIgnore
    private Guild guild;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;

    public GuildPlayer() {}
    public GuildPlayer(Guild guild, Player player) {
        this.id = new GuildPlayerId(guild, player);
        this.guild = guild;
        this.player = player;
    }

    public GuildPlayerId getId() {
        return id;
    }

    public void setId(GuildPlayerId id) {
        this.id = id;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}