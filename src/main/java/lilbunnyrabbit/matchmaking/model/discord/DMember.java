package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMember {

    private DUser user;

    private String nick;

    @NotEmpty
    private String avatar;

    @NotEmpty
    private List<String> roles;

    @NotEmpty
    @JsonProperty("joined_at")
    private String joinedAt;

    @JsonProperty("premium_since")
    private String premiumSince;

    @NotEmpty
    private Boolean deaf;

    @NotEmpty
    private Boolean mute;

    private Boolean pending;

    private String permissions;

    public DMember() {
    }

    public DUser getUser() {
        return user;
    }

    public void setUser(DUser user) {
        this.user = user;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(String joinedAt) {
        this.joinedAt = joinedAt;
    }

    public String getPremiumSince() {
        return premiumSince;
    }

    public void setPremiumSince(String premiumSince) {
        this.premiumSince = premiumSince;
    }

    public Boolean getDeaf() {
        return deaf;
    }

    public void setDeaf(Boolean deaf) {
        this.deaf = deaf;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Partial {

        private String nick;

        @NotEmpty
        private List<String> roles;

        @NotEmpty
        @JsonProperty("joined_at")
        private String joinedAt;

        @JsonProperty("premium_since")
        private String premiumSince;

        private Boolean pending;

        private String permissions;

        public Partial() {
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public String getJoinedAt() {
            return joinedAt;
        }

        public void setJoinedAt(String joinedAt) {
            this.joinedAt = joinedAt;
        }

        public String getPremiumSince() {
            return premiumSince;
        }

        public void setPremiumSince(String premiumSince) {
            this.premiumSince = premiumSince;
        }

        public Boolean getPending() {
            return pending;
        }

        public void setPending(Boolean pending) {
            this.pending = pending;
        }

        public String getPermissions() {
            return permissions;
        }

        public void setPermissions(String permissions) {
            this.permissions = permissions;
        }
    }
}
