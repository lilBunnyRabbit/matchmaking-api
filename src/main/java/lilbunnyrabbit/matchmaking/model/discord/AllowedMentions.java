package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllowedMentions {
    private List<String> parse;
    private List<String> roles;
    private List<String> users;
    @JsonProperty("replied_user")
    private Boolean repliedUser;

    public AllowedMentions() {}
    public AllowedMentions(List<String> parse, List<String> roles, List<String> users, Boolean replied_user) {
        this.parse = parse;
        this.roles = roles;
        this.users = users;
        this.repliedUser = replied_user;
    }

    public List<String> getParse() {
        return parse;
    }

    public void setParse(List<String> parse) {
        this.parse = parse;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public Boolean getRepliedUser() {
        return repliedUser;
    }

    public void setRepliedUser(Boolean repliedUser) {
        this.repliedUser = repliedUser;
    }
}
