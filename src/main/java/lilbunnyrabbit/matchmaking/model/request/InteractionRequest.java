package lilbunnyrabbit.matchmaking.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lilbunnyrabbit.matchmaking.model.discord.Member;
import lilbunnyrabbit.matchmaking.model.discord.Message;
import lilbunnyrabbit.matchmaking.model.discord.User;

import javax.validation.constraints.NotEmpty;

public class InteractionRequest {
    @NotEmpty private String id;
    @JsonProperty("application_id")
    @NotEmpty private String applicationId;
    @NotEmpty private Integer type;
    @NotEmpty private String token;
    @NotEmpty private Integer version;
    @JsonProperty("guild_id")
    private String guildId;
    @JsonProperty("channel_id")
    private String channelId;
    private InteractionRequestData data;
    private User user;
    private Member member;
    private Message message;

    public InteractionRequest() {}

    public static final class Type {
        public static final int PING = 1;
        public static final int APPLICATION_COMMAND = 2;
        public static final int MESSAGE_COMPONENT = 3;

        private Type() {}
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

    public InteractionRequestData getData() {
        return data;
    }

    public void setData(InteractionRequestData data) {
        this.data = data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
