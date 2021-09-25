package lilbunnyrabbit.matchmaking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guild")
public class Guild {
    @Id
    private String id;

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
}
