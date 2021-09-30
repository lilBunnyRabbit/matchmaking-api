package lilbunnyrabbit.matchmaking.model.discord;

import java.io.Serializable;

public class DiscordInvite implements Serializable {
    private String code;
    // TODO


    public DiscordInvite() {}

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
