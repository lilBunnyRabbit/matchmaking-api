package lilbunnyrabbit.matchmaking.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DiscordInteractionResponseData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    public DiscordInteractionResponseData() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
