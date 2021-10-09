package lilbunnyrabbit.matchmaking.entity;

import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GUILD")
public class Guild {

    @Id
    private String id;

    @Column(name="category_id")
    private String categoryId;

    @CreatedDate
    private Date created = new Date();

    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL )
    private Set<GuildPlayer> guildPlayers = new HashSet<>();

    @OneToMany(mappedBy = "guild", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL )
    private Set<Queue> queues = new HashSet<>();

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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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
        guildPlayer.setGuild(this);
    }

    public Set<Queue> getQueues() {
        return queues;
    }

    public void setQueues(Set<Queue> queues) {
        this.queues = queues;
    }

    public void addQueue(Queue queue) {
        this.queues.add(queue);
        queue.setGuild(this);
    }
}
