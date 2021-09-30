package lilbunnyrabbit.matchmaking.model.discord;

import java.io.Serializable;

public class Invite implements Serializable {
    private String code;
    // TODO


    public Invite() {}

    public String createLink() {
        if (this.code == null) return null;
        return "https://discord.gg/" + this.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
