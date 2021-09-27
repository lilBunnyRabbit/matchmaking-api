package lilbunnyrabbit.matchmaking.api.request.discord;

import javax.validation.constraints.NotEmpty;

public class InteractionRequest {
    @NotEmpty private String id;
    @NotEmpty private String application_id;
    @NotEmpty private Integer type;
    @NotEmpty private String token;
    @NotEmpty private Integer version;
    private String guild_id;
    private String channel_id;
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
        return application_id;
    }

    public void setApplicationId(String application_id) {
        this.application_id = application_id;
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
        return guild_id;
    }

    public void setGuildId(String guild_id) {
        this.guild_id = guild_id;
    }

    public String getChannelId() {
        return channel_id;
    }

    public void setChannelId(String channel_id) {
        this.channel_id = channel_id;
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
