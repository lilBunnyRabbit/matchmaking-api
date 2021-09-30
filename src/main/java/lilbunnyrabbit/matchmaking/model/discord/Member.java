package lilbunnyrabbit.matchmaking.model.discord;

import java.util.List;

public class Member {
    private User user;
    private String nick;
    private List<String> roles;
    private String joined_at;
    private String premium_since;
    private Boolean deaf;
    private Boolean mute;
    private Boolean pending;
    private String permissions;

    public static class Partial {
        private String nick;
        private List<String> roles;
        private String joined_at;
        private String premium_since;
        private Boolean pending;
        private String permissions;

        public Partial() {}

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

        public String getJoined_at() {
            return joined_at;
        }

        public void setJoined_at(String joined_at) {
            this.joined_at = joined_at;
        }

        public String getPremium_since() {
            return premium_since;
        }

        public void setPremium_since(String premium_since) {
            this.premium_since = premium_since;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(String joined_at) {
        this.joined_at = joined_at;
    }

    public String getPremium_since() {
        return premium_since;
    }

    public void setPremium_since(String premium_since) {
        this.premium_since = premium_since;
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
}
