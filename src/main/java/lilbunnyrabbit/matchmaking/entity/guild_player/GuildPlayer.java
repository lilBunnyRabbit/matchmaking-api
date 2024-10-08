package lilbunnyrabbit.matchmaking.entity.guild_player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "GUILD_PLAYER")
public class GuildPlayer {

    @EmbeddedId
    private GuildPlayerId id;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "queue_id")
    @JsonIgnore
    private Queue queue;

    private Integer mmr;

    // Todo: private Team team;
    // Todo: private RankType rankType;

    public GuildPlayer() {}
    public GuildPlayer(Guild guild, Player player) {
        this.id = new GuildPlayerId(guild, player); // TODO ?
        this.guild = guild;
        this.player = player;
    }

    @Override
    public String toString() {
        return "<@" + this.id.getPlayerId() + ">";
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

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Integer getMmr() {
        return mmr;
    }

    public void setMmr(Integer mmr) {
        this.mmr = mmr;
    }
}