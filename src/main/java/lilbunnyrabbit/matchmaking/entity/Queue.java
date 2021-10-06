package lilbunnyrabbit.matchmaking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "QUEUE")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    @JsonIgnore
    private Guild guild;

    @CreatedDate
    private Date created = new Date();

    private Status status = Status.WAITING;

    @OneToMany(mappedBy = "queue", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    Set<GuildPlayer> players = new HashSet<>();

    @Column(name="lobby_channel")
    private String lobbyChannel;

    // TODO: private QueueType queueType;

    public Queue() {}
    public Queue(Guild guild) {
        this.guild = guild;
    }

    public enum Status {
        WAITING,
        DONE
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<GuildPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<GuildPlayer> players) {
        this.players = players;
    }

    public void addPlayer(GuildPlayer guildPlayer) {
        this.players.add(guildPlayer);
        guildPlayer.setQueue(this);
    }

    public void removePlayer(GuildPlayer guildPlayer) {
        this.players.remove(guildPlayer);
        guildPlayer.setQueue(null);
    }

    public String getLobbyChannel() {
        return lobbyChannel;
    }

    public void setLobbyChannel(String lobbyChannel) {
        this.lobbyChannel = lobbyChannel;
    }
}
