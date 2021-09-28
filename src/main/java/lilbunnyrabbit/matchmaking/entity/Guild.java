package lilbunnyrabbit.matchmaking.entity;

import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "GUILD")
public class Guild {

    @Id
    private String id;

    @CreatedDate
    private Date created = new Date();

    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY)
    Set<GuildPlayer> guildPlayers;

    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY)
    Set<Queue> queues;

    public Guild() {}
    public Guild(String id) {
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

    public Set<Queue> getQueues() {
        return queues;
    }

    public void setQueues(Set<Queue> queues) {
        this.queues = queues;
    }
}
