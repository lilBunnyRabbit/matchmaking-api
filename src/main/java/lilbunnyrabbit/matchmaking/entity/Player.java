package lilbunnyrabbit.matchmaking.entity;

import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    private String id;

    @CreatedDate
    private Date created = new Date();

    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    Set<GuildPlayer> guildPlayers = new HashSet<>();

    public Player() {}
    public Player(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<GuildPlayer> getGuildPlayers() {
        return guildPlayers;
    }

    public void setGuildPlayers(Set<GuildPlayer> guildPlayers) {
        this.guildPlayers = guildPlayers;
    }

    public void addGuildPlayer(GuildPlayer guildPlayer) {
        this.guildPlayers.add(guildPlayer);
        guildPlayer.setPlayer(this);
    }
}
