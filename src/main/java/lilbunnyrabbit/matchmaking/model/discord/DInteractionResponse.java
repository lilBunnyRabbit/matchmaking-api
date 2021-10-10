package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DInteractionResponse {

    public static final DInteractionResponse PONG = new DInteractionResponse(Type.PONG);
    public static final DInteractionResponse DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = new DInteractionResponse(Type.DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE);
    public static final DInteractionResponse DEFERRED_UPDATE_MESSAGE = new DInteractionResponse(Type.DEFERRED_UPDATE_MESSAGE);

    @NotEmpty
    private Integer type; // InteractionResponse.Type

    private DInteractionResponse.Data data;

    public DInteractionResponse() {
    }

    public DInteractionResponse(Integer type) {
        this.type = type;
    }

    public DInteractionResponse(Integer type, Data data) {
        this.type = type;
        this.data = data;
    }

    public static DInteractionResponse CHANNEL_MESSAGE_WITH_SOURCE(Data data) {
        return new DInteractionResponse(Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }

    public static DInteractionResponse UPDATE_MESSAGE(Data data) {
        return new DInteractionResponse(Type.UPDATE_MESSAGE, data);
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

        private List<DEmbed> embeds;

        @JsonProperty("allowed_mentions")
        private DAllowedMentions allowedMentions;

        private Integer flags;

        private List<DComponent> components;

        public Data() {
        }

        public Data(String content) {
            this.content = content;
        }

        public Data(List<DEmbed> embeds) {
            this.embeds = embeds;
        }

        public Data(DEmbed... embeds) {
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

        public List<DEmbed> getEmbeds() {
            return embeds;
        }

        public void setEmbeds(List<DEmbed> embeds) {
            this.embeds = embeds;
        }

        public void setEmbeds(DEmbed... embeds) {
            this.embeds = List.of(embeds);
        }

        public DAllowedMentions getAllowedMentions() {
            return allowedMentions;
        }

        public void setAllowedMentions(DAllowedMentions allowedMentions) {
            this.allowedMentions = allowedMentions;
        }

        public Integer getFlags() {
            return flags;
        }

        public void setFlags(Integer flags) {
            this.flags = flags;
        }

        public List<DComponent> getComponents() {
            return components;
        }

        public void setComponents(List<DComponent> components) {
            this.components = components;
        }

        public void setComponents(DComponent... components) {
            this.components = List.of(components);
        }

    }
}
