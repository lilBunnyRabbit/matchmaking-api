package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Interaction {

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

    private Member member;

    private User user;

    @NotEmpty
    private String token;

    @NotEmpty
    private Integer version;

    private Message message;

    public Interaction() {
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
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

        private Interaction.ResolvedData resolved;

        private List<ApplicationCommand.InteractionData.Option> options;

        @JsonProperty("custom_id")
        private String customId;

        @JsonProperty("component_type")
        private Integer componentType;

        private List<Component.SelectMenu.Option> values;

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

        public List<ApplicationCommand.InteractionData.Option> getOptions() {
            return options;
        }

        public void setOptions(List<ApplicationCommand.InteractionData.Option> options) {
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

        public List<Component.SelectMenu.Option> getValues() {
            return values;
        }

        public void setValues(List<Component.SelectMenu.Option> values) {
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

        private List<User> users; // Todo: User

        private List<Member.Partial> members; // Todo: Partial member

        private List<Role> roles; // Todo: Role;

        private List<Channel.Partial> channels; // Todo: Partial Channel

        private List<Message.Partial> messages; // Todo: Partial Messages

        public ResolvedData() {
        }

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public List<Member.Partial> getMembers() {
            return members;
        }

        public void setMembers(List<Member.Partial> members) {
            this.members = members;
        }

        public List<Role> getRoles() {
            return roles;
        }

        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }

        public List<Channel.Partial> getChannels() {
            return channels;
        }

        public void setChannels(List<Channel.Partial> channels) {
            this.channels = channels;
        }

        public List<Message.Partial> getMessages() {
            return messages;
        }

        public void setMessages(List<Message.Partial> messages) {
            this.messages = messages;
        }
    }
}
