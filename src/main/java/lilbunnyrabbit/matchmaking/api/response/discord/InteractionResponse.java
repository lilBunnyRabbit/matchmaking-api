package lilbunnyrabbit.matchmaking.api.response.discord;

import com.fasterxml.jackson.annotation.JsonInclude;

public class InteractionResponse {
    private int type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private InteractionResponseData data;

    public InteractionResponse() {}
    public InteractionResponse(int type) {
        this.type = type;
    }
    public InteractionResponse(int type, InteractionResponseData data) {
        this.type = type;
        this.data = data;
    }

    public static final class Type {
        public static final int PONG = 1;
        public static final int CHANNEL_MESSAGE_WITH_SOURCE = 4;
        public static final int DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = 5;
        public static final int DEFERRED_UPDATE_MESSAGE = 6;
        public static final int UPDATE_MESSAGE = 7;

        private Type() {}
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public InteractionResponseData getData() {
        return data;
    }

    public void setData(InteractionResponseData data) {
        this.data = data;
    }
}