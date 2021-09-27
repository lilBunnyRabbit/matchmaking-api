package lilbunnyrabbit.matchmaking.api.request.discord;

import java.util.Map;

public class InteractionRequestDataResolved {
    private Map<String, User> users;
    private Map<String, Member.Partial> members;
    private Map<String, Role> roles;
    private Map<String, Channel.Partial> channels;
    private Map<String, Message.Partial> messages;

    public InteractionRequestDataResolved() {}

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<String, Member.Partial> getMembers() {
        return members;
    }

    public void setMembers(Map<String, Member.Partial> members) {
        this.members = members;
    }

    public Map<String, Role> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Role> roles) {
        this.roles = roles;
    }

    public Map<String, Channel.Partial> getChannels() {
        return channels;
    }

    public void setChannels(Map<String, Channel.Partial> channels) {
        this.channels = channels;
    }

    public Map<String, Message.Partial> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, Message.Partial> messages) {
        this.messages = messages;
    }
}
