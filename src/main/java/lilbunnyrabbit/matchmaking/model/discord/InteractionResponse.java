package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InteractionResponse {
    public static final InteractionResponse PONG = new InteractionResponse(Type.PONG);
    public static final InteractionResponse DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = new InteractionResponse(Type.DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE);
    public static final InteractionResponse DEFERRED_UPDATE_MESSAGE = new InteractionResponse(Type.DEFERRED_UPDATE_MESSAGE);

    @NotEmpty
    private Integer type; // InteractionResponse.Type

    private InteractionResponse.Data data;

    public InteractionResponse() {
    }

    public InteractionResponse(Integer type) {
        this.type = type;
    }

    public InteractionResponse(Integer type, Data data) {
        this.type = type;
        this.data = data;
    }

    public static InteractionResponse CHANNEL_MESSAGE_WITH_SOURCE(Data data) {
        return new InteractionResponse(Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }

    public static InteractionResponse UPDATE_MESSAGE(Data data) {
        return new InteractionResponse(Type.UPDATE_MESSAGE, data);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static final class Type {

        public static final int PONG = 1;
        public static final int CHANNEL_MESSAGE_WITH_SOURCE = 4;
        public static final int DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = 5;
        public static final int DEFERRED_UPDATE_MESSAGE = 6;
        public static final int UPDATE_MESSAGE = 7;

        private Type() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Data {

        private Boolean tts;

        private String content;

        private List<Embed> embeds;

        @JsonProperty("allowed_mentions")
        private AllowedMentions allowedMentions;

        private Integer flags;

        private List<Component> components;

        public Data() {
        }

        public Data(String content) {
            this.content = content;
        }

        public Data(List<Embed> embeds) {
            this.embeds = embeds;
        }

        public Data(Embed... embeds) {
            this.embeds = List.of(embeds);
        }

        public Boolean getTts() {
            return tts;
        }

        public void setTts(Boolean tts) {
            this.tts = tts;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<Embed> getEmbeds() {
            return embeds;
        }

        public void setEmbeds(List<Embed> embeds) {
            this.embeds = embeds;
        }

        public void setEmbeds(Embed... embeds) {
            this.embeds = List.of(embeds);
        }

        public AllowedMentions getAllowedMentions() {
            return allowedMentions;
        }

        public void setAllowedMentions(AllowedMentions allowedMentions) {
            this.allowedMentions = allowedMentions;
        }

        public Integer getFlags() {
            return flags;
        }

        public void setFlags(Integer flags) {
            this.flags = flags;
        }

        public List<Component> getComponents() {
            return components;
        }

        public void setComponents(List<Component> components) {
            this.components = components;
        }

        public void setComponents(Component... components) {
            this.components = List.of(components);
        }

    }
}
