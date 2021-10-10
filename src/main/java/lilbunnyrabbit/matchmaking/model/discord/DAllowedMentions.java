package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DAllowedMentions {

    @NotEmpty
    private List<String> parse;

    @NotEmpty
    private List<String> roles;

    @NotEmpty
    private List<String> users;

    @NotEmpty
    @JsonProperty("replied_user")
    private Boolean repliedUser;

    public DAllowedMentions() {
    }

    public DAllowedMentions(List<String> parse, List<String> roles, List<String> users, Boolean replied_user) {
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
