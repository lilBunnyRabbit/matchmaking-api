package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscordUser {

    @NotEmpty
    private String id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String discriminator;

    private String avatar;

    private Boolean bot;

    private Boolean system;

    @JsonProperty("mfa_enabled")
    private Boolean mfaEnabled;

    private String banner;

    @JsonProperty("accent_color")
    private Integer accentColor;

    private String locale;

    private Boolean verified;

    private String email;

    private Integer flags;

    @JsonProperty("premium_type")
    private Integer premiumType;

    @JsonProperty("public_flags")
    private Integer publicFlags;

    public DiscordUser() {
    }

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
        return mfaEnabled;
    }

    public void setMfaEnabled(Boolean mfaEnabled) {
        this.mfaEnabled = mfaEnabled;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Integer getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(Integer accentColor) {
        this.accentColor = accentColor;
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
        return premiumType;
    }

    public void setPremiumType(Integer premiumType) {
        this.premiumType = premiumType;
    }

    public Integer getPublicFlags() {
        return publicFlags;
    }

    public void setPublicFlags(Integer publicFlags) {
        this.publicFlags = publicFlags;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Mention extends DiscordUser {

        private DiscordMember.Partial member;

        public Mention() {
        }

        public DiscordMember.Partial getMember() {
            return member;
        }

        public void setMember(DiscordMember.Partial member) {
            this.member = member;
        }
    }
}
