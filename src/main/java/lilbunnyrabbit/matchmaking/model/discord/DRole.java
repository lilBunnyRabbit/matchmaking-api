package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DRole {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private Integer color;

    @NotEmpty
    private Boolean hoist;

    private String icon;

    @JsonProperty("unicode_emoji")
    private String unicodeEmoji;

    @NotEmpty
    private Integer position;

    @NotEmpty
    private String permissions;

    @NotEmpty
    private Boolean managed;

    @NotEmpty
    private Boolean mentionable;

    private DRole.Tag tags;

    public DRole() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Boolean getHoist() {
        return hoist;
    }

    public void setHoist(Boolean hoist) {
        this.hoist = hoist;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUnicodeEmoji() {
        return unicodeEmoji;
    }

    public void setUnicodeEmoji(String unicodeEmoji) {
        this.unicodeEmoji = unicodeEmoji;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Boolean getManaged() {
        return managed;
    }

    public void setManaged(Boolean managed) {
        this.managed = managed;
    }

    public Boolean getMentionable() {
        return mentionable;
    }

    public void setMentionable(Boolean mentionable) {
        this.mentionable = mentionable;
    }

    public DRole.Tag getTags() {
        return tags;
    }

    public void setTags(DRole.Tag tags) {
        this.tags = tags;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class Tag {

        @JsonProperty("bot_id")
        private String botId;

        @JsonProperty("integration_id")
        private String integrationId;

        @JsonProperty("premium_subscriber")
        private Boolean premiumSubscriber;

        public Tag() {
        }

        public String getBotId() {
            return botId;
        }

        public void setBotId(String botId) {
            this.botId = botId;
        }

        public String getIntegrationId() {
            return integrationId;
        }

        public void setIntegrationId(String integrationId) {
            this.integrationId = integrationId;
        }

        public Boolean getPremiumSubscriber() {
            return premiumSubscriber;
        }

        public void setPremiumSubscriber(Boolean premiumSubscriber) {
            this.premiumSubscriber = premiumSubscriber;
        }
    }
}
