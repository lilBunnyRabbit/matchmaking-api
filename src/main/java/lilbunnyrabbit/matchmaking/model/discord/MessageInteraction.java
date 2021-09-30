package lilbunnyrabbit.matchmaking.model.discord;

import javax.validation.constraints.NotEmpty;

public class MessageInteraction {

    @NotEmpty
    private String id;

    @NotEmpty
    private Integer type; // Interaction.Type

    @NotEmpty
    private String name;

    @NotEmpty
    private User user;

    public MessageInteraction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
