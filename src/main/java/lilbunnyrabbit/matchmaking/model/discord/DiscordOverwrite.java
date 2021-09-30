package lilbunnyrabbit.matchmaking.model.discord;

import javax.validation.constraints.NotEmpty;

public class DiscordOverwrite {

    @NotEmpty
    private String id;

    @NotEmpty
    private Type type;

    @NotEmpty
    private String allow;

    @NotEmpty
    private String deny;

    public DiscordOverwrite() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    public static enum Type {
        ROLE,
        MEMBER
    }
}
