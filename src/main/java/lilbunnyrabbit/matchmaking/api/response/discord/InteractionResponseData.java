package lilbunnyrabbit.matchmaking.api.response.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InteractionResponseData {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean tts;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Embed> embeds;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("allowed_mentions")
    private AllowedMentions allowedMentions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer flags;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Component> components;


    public InteractionResponseData() {}
    public InteractionResponseData(String content) {
        this.content = content;
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

    public void setEmbed(Embed embed) {
        this.embeds = List.of(embed);
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

    public void setComponent(Component component) {
        this.components = List.of(component);
    }
}
