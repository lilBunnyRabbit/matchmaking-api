package lilbunnyrabbit.matchmaking.api.request.discord;

public class User {
    private String id;
    private String username;
    private String discriminator;
    private String avatar;
    private Boolean bot;
    private Boolean system;
    private Boolean mfa_enabled;
    private String banner;
    private Integer accent_color;
    private String locale;
    private Boolean verified;
    private String email;
    private Integer flags;
    private Integer premium_type;
    private Integer public_flags;

    public User() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getBot() {
        return bot;
    }

    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public Boolean getMfaEnabled() {
        return mfa_enabled;
    }

    public void setMfaEnabled(Boolean mfa_enabled) {
        this.mfa_enabled = mfa_enabled;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getAccentColor() {
        return accent_color;
    }

    public void setAccentColor(Integer accent_color) {
        this.accent_color = accent_color;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public Integer getPremiumType() {
        return premium_type;
    }

    public void setPremiumType(Integer premium_type) {
        this.premium_type = premium_type;
    }

    public Integer getPublicFlags() {
        return public_flags;
    }

    public void setPublicFlags(Integer public_flags) {
        this.public_flags = public_flags;
    }
}
