package lilbunnyrabbit.matchmaking.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DiscordInteractionResponse {
    private int type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private DiscordInteractionResponseData data;

    public DiscordInteractionResponse() {}

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DiscordInteractionResponseData getData() {
        return data;
    }

    public void setData(DiscordInteractionResponseData data) {
        this.data = data;
    }
}