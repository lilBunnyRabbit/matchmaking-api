package lilbunnyrabbit.matchmaking.service.discord.api.response;

import java.io.Serializable;

public class InviteResponse implements Serializable {
    private String code;
    // TODO


    public InviteResponse() {}

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
