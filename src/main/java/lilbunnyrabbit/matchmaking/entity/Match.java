package lilbunnyrabbit.matchmaking.entity;

import lilbunnyrabbit.matchmaking.entity.match_player.MatchPlayer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Set<MatchPlayer> players = new HashSet<>();

    private Date created = new Date();

    private Date statusUpdated = new Date();

    private Status status = Status.IN_PROGRESS;

    private Type type = Type.NORMAL;

    public enum Status {
        IN_PROGRESS,
        FINISHED
    }

    public enum Type {
        NORMAL
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<MatchPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(Set<MatchPlayer> players) {
        this.players = players;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getStatusUpdated() {
        return statusUpdated;
    }

    public void setStatusUpdated(Date statusUpdated) {
        this.statusUpdated = statusUpdated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addPlayer(MatchPlayer matchPlayer){
        this.players.add(matchPlayer);
        matchPlayer.setMatch(this);
    }
}
