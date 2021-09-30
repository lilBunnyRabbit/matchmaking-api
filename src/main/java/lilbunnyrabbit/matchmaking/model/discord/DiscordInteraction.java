package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DiscordInteraction {

    @NotEmpty
    private String id;

    @NotEmpty
    @JsonProperty("application_id")
    private String applicationId;

    @NotEmpty
    private Integer type; // Interaction.Type

    private Data data;

    @JsonProperty("guild_id")
    private String guildId;

    @JsonProperty("channel_id")
    private String channelId;

    private DiscordMember member;

    private DiscordUser user;

    @NotEmpty
    private String token;

    @NotEmpty
    private Integer version;

    private DiscordMessage message;

    public DiscordInteraction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public DiscordMember getMember() {
        return member;
    }

    public void setMember(DiscordMember member) {
        this.member = member;
    }

    public DiscordUser getUser() {
        return user;
    }

    public void setUser(DiscordUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public DiscordMessage getMessage() {
        return message;
    }

    public void setMessage(DiscordMessage message) {
        this.message = message;
    }

    public static final class Type {

        public static final int PING = 1;
        public static final int APPLICATION_COMMAND = 2;
        public static final int MESSAGE_COMPONENT = 3;

        private Type() {
        }
    }

    public static class Data {

        @NotEmpty
        private String id;

        @NotEmpty
        private String name;

        @NotEmpty
        private Integer type; // ApplicationCommand.Type

        private DiscordInteraction.ResolvedData resolved;

        private List<DiscordApplicationCommand.InteractionData.Option> options;

        @JsonProperty("custom_id")
        private String customId;

        @JsonProperty("component_type")
        private Integer componentType;

        private List<DiscordComponent.SelectMenu.Option> values;

        @JsonProperty("target_id")
        private String targetId;

        public Data() {
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

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public ResolvedData getResolved() {
            return resolved;
        }

        public void setResolved(ResolvedData resolved) {
            this.resolved = resolved;
        }

        public List<DiscordApplicationCommand.InteractionData.Option> getOptions() {
            return options;
        }

        public void setOptions(List<DiscordApplicationCommand.InteractionData.Option> options) {
            this.options = options;
        }

        public String getCustomId() {
            return customId;
        }

        public void setCustomId(String customId) {
            this.customId = customId;
        }

        public Integer getComponentType() {
            return componentType;
        }

        public void setComponentType(Integer componentType) {
            this.componentType = componentType;
        }

        public List<DiscordComponent.SelectMenu.Option> getValues() {
            return values;
        }

        public void setValues(List<DiscordComponent.SelectMenu.Option> values) {
            this.values = values;
        }

        public String getTargetId() {
            return targetId;
        }

        public void setTargetId(String targetId) {
            this.targetId = targetId;
        }
    }

    public static class ResolvedData {

        private List<DiscordUser> users; // Todo: User

        private List<DiscordMember.Partial> members; // Todo: Partial member

        private List<DiscordRole> roles; // Todo: Role;

        private List<DiscordChannel.Partial> channels; // Todo: Partial Channel

        private List<DiscordMessage.Partial> messages; // Todo: Partial Messages

        public ResolvedData() {
        }

        public List<DiscordUser> getUsers() {
            return users;
        }

        public void setUsers(List<DiscordUser> users) {
            this.users = users;
        }

        public List<DiscordMember.Partial> getMembers() {
            return members;
        }

        public void setMembers(List<DiscordMember.Partial> members) {
            this.members = members;
        }

        public List<DiscordRole> getRoles() {
            return roles;
        }

        public void setRoles(List<DiscordRole> roles) {
            this.roles = roles;
        }

        public List<DiscordChannel.Partial> getChannels() {
            return channels;
        }

        public void setChannels(List<DiscordChannel.Partial> channels) {
            this.channels = channels;
        }

        public List<DiscordMessage.Partial> getMessages() {
            return messages;
        }

        public void setMessages(List<DiscordMessage.Partial> messages) {
            this.messages = messages;
        }
    }
}
