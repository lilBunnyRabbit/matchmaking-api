package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordInteractionResponse {
    public static final DiscordInteractionResponse PONG = new DiscordInteractionResponse(Type.PONG);
    public static final DiscordInteractionResponse DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = new DiscordInteractionResponse(Type.DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE);
    public static final DiscordInteractionResponse DEFERRED_UPDATE_MESSAGE = new DiscordInteractionResponse(Type.DEFERRED_UPDATE_MESSAGE);

    @NotEmpty
    private Integer type; // InteractionResponse.Type

    private DiscordInteractionResponse.Data data;

    public DiscordInteractionResponse() {
    }

    public DiscordInteractionResponse(Integer type) {
        this.type = type;
    }

    public DiscordInteractionResponse(Integer type, Data data) {
        this.type = type;
        this.data = data;
    }

    public static DiscordInteractionResponse CHANNEL_MESSAGE_WITH_SOURCE(Data data) {
        return new DiscordInteractionResponse(Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }

    public static DiscordInteractionResponse UPDATE_MESSAGE(Data data) {
        return new DiscordInteractionResponse(Type.UPDATE_MESSAGE, data);
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

        private List<DiscordEmbed> embeds;

        @JsonProperty("allowed_mentions")
        private DiscordAllowedMentions allowedMentions;

        private Integer flags;

        private List<DiscordComponent> components;

        public Data() {
        }

        public Data(String content) {
            this.content = content;
        }

        public Data(List<DiscordEmbed> embeds) {
            this.embeds = embeds;
        }

        public Data(DiscordEmbed... embeds) {
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

        public List<DiscordEmbed> getEmbeds() {
            return embeds;
        }

        public void setEmbeds(List<DiscordEmbed> embeds) {
            this.embeds = embeds;
        }

        public void setEmbeds(DiscordEmbed... embeds) {
            this.embeds = List.of(embeds);
        }

        public DiscordAllowedMentions getAllowedMentions() {
            return allowedMentions;
        }

        public void setAllowedMentions(DiscordAllowedMentions allowedMentions) {
            this.allowedMentions = allowedMentions;
        }

        public Integer getFlags() {
            return flags;
        }

        public void setFlags(Integer flags) {
            this.flags = flags;
        }

        public List<DiscordComponent> getComponents() {
            return components;
        }

        public void setComponents(List<DiscordComponent> components) {
            this.components = components;
        }

        public void setComponents(DiscordComponent... components) {
            this.components = List.of(components);
        }

    }
}
