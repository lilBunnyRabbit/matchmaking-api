package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordSticker {

    @NotEmpty
    private String id;

    @JsonProperty("pack_id")
    private String packId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String tags;

    @NotEmpty
    private String asset;

    @NotEmpty
    private Integer type; // Sticker.Type

    @NotEmpty
    @JsonProperty("format_type")
    private Integer formatType; // Sticker.FormatType

    private Boolean available;

    @JsonProperty("guild_id")
    private String guildId;

    private DiscordUser user;

    @JsonProperty("sort_value")
    private Integer sortValue;

    public DiscordSticker() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFormatType() {
        return formatType;
    }

    public void setFormatType(Integer formatType) {
        this.formatType = formatType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public DiscordUser getUser() {
        return user;
    }

    public void setUser(DiscordUser user) {
        this.user = user;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public static final class Type {

        public static final int STANDARD = 1;
        public static final int GUILD = 2;

        private Type() {
        }
    }

    public static final class FormatType {

        public static final int PNG = 1;
        public static final int APNG = 2;
        public static final int LOTTIE = 2;

        private FormatType() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Item {

        @NotEmpty
        private String id;

        @NotEmpty
        private String name;

        @NotEmpty
        @JsonProperty("format_type")
        private Integer formatType; // Sticker.FormatType

        public Item() {
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

        public Integer getFormatType() {
            return formatType;
        }

        public void setFormatType(Integer formatType) {
            this.formatType = formatType;
        }
    }
}
