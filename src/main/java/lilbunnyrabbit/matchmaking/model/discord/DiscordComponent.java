package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DiscordComponent {

    @NotEmpty
    protected Integer type; // Component.Type

    public DiscordComponent() {
    }

    public DiscordComponent(Integer type) {
        this.type = type;
    }

    public static final class Type {

        public static final int ACTION_ROW = 1;
        public static final int BUTTON = 2;
        public static final int SELECT_MENU = 3;

        private Type() {
        }
    }

    public static class ActionRow extends DiscordComponent {

        @NotEmpty
        private List<DiscordComponent> components;

        public ActionRow() {
            this.type = Type.ACTION_ROW;
        }

        public ActionRow(List<DiscordComponent> components) {
            this.type = Type.ACTION_ROW;
            this.components = components;
        }

        public ActionRow(DiscordComponent... component) {
            this.type = Type.ACTION_ROW;
            this.components = List.of(component);
        }

        public List<DiscordComponent> getComponents() {
            return components;
        }

        public void setComponents(List<DiscordComponent> components) {
            this.components = components;
        }
    }

    public static class Button extends DiscordComponent {

        @NotEmpty
        private Integer style;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String label;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private DiscordEmoji.Partial emoji;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("custom_id")
        private String customId;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String url;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String disabled;

        public Button() {
            this.type = Type.BUTTON;
        }

        public Button(Integer style) {
            this.type = Type.BUTTON;
            this.style = style;
        }

        public static final class Style {
            public static final int PRIMARY = 1;
            public static final int SECONDARY = 2;
            public static final int SUCCESS = 3;
            public static final int DANGER = 4;
            public static final int LINK = 5;

            private Style() {
            }
        }

        public Integer getStyle() {
            return style;
        }

        public void setStyle(Integer style) {
            this.style = style;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public DiscordEmoji.Partial getEmoji() {
            return emoji;
        }

        public void setEmoji(DiscordEmoji.Partial emoji) {
            this.emoji = emoji;
        }

        public String getCustomId() {
            return customId;
        }

        public void setCustomId(String customId) {
            this.customId = customId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDisabled() {
            return disabled;
        }

        public void setDisabled(String disabled) {
            this.disabled = disabled;
        }
    }

    public static class SelectMenu extends DiscordComponent {

        @NotEmpty
        @JsonProperty("custom_id")
        private String customId;

        @NotEmpty
        private List<Option> options;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String placeholder;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("min_values")
        private Integer minValues;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("max_values")
        private Integer maxValues;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean disabled;

        public SelectMenu() {
            this.type = Type.SELECT_MENU;
        }

        public SelectMenu(String customId, List<Option> options) {
            this.type = Type.SELECT_MENU;
            this.customId = customId;
            this.options = options;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public static class Option {

            @NotEmpty
            private String label;

            @NotEmpty
            private String value;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            private String description;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            private DiscordEmoji.Partial emoji;

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonProperty("default")
            private Boolean isDefault;

            public Option() {
            }

            public Option(String label, String value) {
                this.label = label;
                this.value = value;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public DiscordEmoji.Partial getEmoji() {
                return emoji;
            }

            public void setEmoji(DiscordEmoji.Partial emoji) {
                this.emoji = emoji;
            }

            public Boolean getDefault() {
                return isDefault;
            }

            public void setDefault(Boolean aDefault) {
                isDefault = aDefault;
            }
        }

        public String getCustomId() {
            return customId;
        }

        public void setCustomId(String customId) {
            this.customId = customId;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

        public Integer getMinValues() {
            return minValues;
        }

        public void setMinValues(Integer minValues) {
            this.minValues = minValues;
        }

        public Integer getMaxValues() {
            return maxValues;
        }

        public void setMaxValues(Integer maxValues) {
            this.maxValues = maxValues;
        }

        public Boolean getDisabled() {
            return disabled;
        }

        public void setDisabled(Boolean disabled) {
            this.disabled = disabled;
        }
    }
}
