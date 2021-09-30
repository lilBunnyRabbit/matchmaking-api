package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordApplicationCommand {

    @NotEmpty
    private String id;

    private Integer type; // Type

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("guild_id")
    private String guildId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private List<DiscordApplicationCommand.Option> options;

    @JsonProperty("default_permission")
    private Boolean defaultPermission;

    @NotEmpty
    private String version;

    public DiscordApplicationCommand() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Boolean getDefaultPermission() {
        return defaultPermission;
    }

    public void setDefaultPermission(Boolean defaultPermission) {
        this.defaultPermission = defaultPermission;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static final class Type {

        public static final int CHAT_INPUT = 1;
        public static final int USER = 2;
        public static final int MESSAGE = 3;

        private Type() {
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Option {

        @NotEmpty
        private Integer type; // Option.Type

        @NotEmpty
        private String name;

        @NotEmpty
        private String description;

        private Boolean required;

        private List<DiscordApplicationCommand.Option.Choice> choices;

        private List<DiscordApplicationCommand.Option> options;

        @JsonProperty("channel_types")
        private List<Integer> channelTypes; // Channel.Type

        public Option() {
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
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

        public Boolean getRequired() {
            return required;
        }

        public void setRequired(Boolean required) {
            this.required = required;
        }

        public List<Choice> getChoices() {
            return choices;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        public List<Integer> getChannelTypes() {
            return channelTypes;
        }

        public void setChannelTypes(List<Integer> channelTypes) {
            this.channelTypes = channelTypes;
        }

        public static final class Type {

            public static final int SUB_COMMAND = 1;
            public static final int SUB_COMMAND_GROUP = 2;
            public static final int STRING = 3;
            public static final int INTEGER = 4;
            public static final int BOOLEAN = 5;
            public static final int USER = 6;
            public static final int CHANNEL = 7;
            public static final int ROLE = 8;
            public static final int MENTIONABLE = 9;
            public static final int NUMBER = 10;

            private Type() {
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private static class Choice {

            @NotEmpty
            private String name;

            @NotEmpty
            private Object value;

            public Choice() {
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getValue() {
                return value;
            }

            public void setValue(Object value) {
                this.value = value;
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class InteractionData {

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Option {

            @NotEmpty
            private String name;

            @NotEmpty
            private Integer type; // ApplicationCommand.Option.Type

            private Integer value; // ApplicationCommand.Option.Type

            private List<DiscordApplicationCommand.InteractionData.Option> options;

            public Option() {
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getType() {
                return type;
            }

            public void setType(Integer type) {
                this.type = type;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }

            public List<Option> getOptions() {
                return options;
            }

            public void setOptions(List<Option> options) {
                this.options = options;
            }
        }
    }
}
