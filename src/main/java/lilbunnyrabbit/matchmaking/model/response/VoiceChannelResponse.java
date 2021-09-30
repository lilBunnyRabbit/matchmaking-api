package lilbunnyrabbit.matchmaking.model.response;

import java.io.Serializable;

public class VoiceChannelResponse implements Serializable {
    private String id;
    // TODO

    public VoiceChannelResponse() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}