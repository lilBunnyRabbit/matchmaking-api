package lilbunnyrabbit.matchmaking.entity.guild_player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;

import javax.persistence.*;

@Entity
@Table(name = "GUILD_PLAYER")
public class GuildPlayer {

    @EmbeddedId
    GuildPlayerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("guildId")
    @JoinColumn(name = "guildId")
    @JsonIgnore
    private Guild guild;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "playerId")
    @JsonIgnore
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "queueId")
    @JsonIgnore
    private Queue queue;

    private Integer mmr;

    // Todo: private Team team;
    // Todo: private RankType rankType;

    public GuildPlayer() {}
    public GuildPlayer(Guild guild, Player player) {
        this.id = new GuildPlayerId(guild, player);
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