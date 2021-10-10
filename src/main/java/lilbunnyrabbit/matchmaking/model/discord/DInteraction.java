package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DInteraction {

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

    private DMember member;

    private DUser user;

    @NotEmpty
    private String token;

    @NotEmpty
    private Integer version;

    private DMessage message;

    public DInteraction() {
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

    public DMember getMember() {
        return member;
    }

    public void setMember(DMember member) {
        this.member = member;
    }

    public DUser getUser() {
        return user;
    }

    public void setUser(DUser user) {
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

    public DMessage getMessage() {
        return message;
    }

    public void setMessage(DMessage message) {
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

        private DInteraction.ResolvedData resolved;

        private List<DApplicationCommand.InteractionData.Option> options;

        @JsonProperty("custom_id")
        private String customId;

        @JsonProperty("component_type")
        private Integer componentType;

        private List<DComponent.SelectMenu.Option> values;

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

        public List<DApplicationCommand.InteractionData.Option> getOptions() {
            return options;
        }

        public void setOptions(List<DApplicationCommand.InteractionData.Option> options) {
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

        public List<DComponent.SelectMenu.Option> getValues() {
            return values;
        }

        public void setValues(List<DComponent.SelectMenu.Option> values) {
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

        private List<DUser> users; // Todo: User

        private List<DMember.Partial> members; // Todo: Partial member

        private List<DRole> roles; // Todo: Role;

        private List<DChannel.Partial> channels; // Todo: Partial Channel

        private List<DMessage.Partial> messages; // Todo: Partial Messages

        public ResolvedData() {
        }

        public List<DUser> getUsers() {
            return users;
        }

        public void setUsers(List<DUser> users) {
            this.users = users;
        }

        public List<DMember.Partial> getMembers() {
            return members;
        }

        public void setMembers(List<DMember.Partial> members) {
            this.members = members;
        }

        public List<DRole> getRoles() {
            return roles;
        }

        public void setRoles(List<DRole> roles) {
            this.roles = roles;
        }

        public List<DChannel.Partial> getChannels() {
            return channels;
        }

        public void setChannels(List<DChannel.Partial> channels) {
            this.channels = channels;
        }

        public List<DMessage.Partial> getMessages() {
            return messages;
        }

        public void setMessages(List<DMessage.Partial> messages) {
            this.messages = messages;
        }
    }
}
