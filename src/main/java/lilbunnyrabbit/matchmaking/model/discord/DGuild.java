package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DGuild {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    private String splash;

    private String banner;

    @NotEmpty
    private String description;

    private String icon;

    @NotEmpty
    private List<String> features; // Todo: GuildFeature

    @NotEmpty
    @JsonProperty("verification_level")
    private Integer verificationLevel;

    @JsonProperty("vanity_url_code")
    private String vanityUrlCode;

    // Todo: Other fields


    public DGuild() {
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

    public String getSplash() {
        return splash;
    }

    public void setSplash(String splash) {
        this.splash = splash;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Integer getVerificationLevel() {
        return verificationLevel;
    }

    public void setVerificationLevel(Integer verificationLevel) {
        this.verificationLevel = verificationLevel;
    }

    public String getVanityUrlCode() {
        return vanityUrlCode;
    }

    public void setVanityUrlCode(String vanityUrlCode) {
        this.vanityUrlCode = vanityUrlCode;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Partial {

        @NotEmpty
        private String id;

        @NotEmpty
        private String name;

        private String splash;

        private String banner;

        @NotEmpty
        private String description;

        private String icon;

        @NotEmpty
        private List<String> features; // Todo: GuildFeature

        @NotEmpty
        @JsonProperty("verification_level")
        private Integer verificationLevel;

        @JsonProperty("vanity_url_code")
        private String vanityUrlCode;

        public Partial() {
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

        public String getSplash() {
            return splash;
        }

        public void setSplash(String splash) {
            this.splash = splash;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<String> getFeatures() {
            return features;
        }

        public void setFeatures(List<String> features) {
            this.features = features;
        }

        public Integer getVerificationLevel() {
            return verificationLevel;
        }

        public void setVerificationLevel(Integer verificationLevel) {
            this.verificationLevel = verificationLevel;
        }

        public String getVanityUrlCode() {
            return vanityUrlCode;
        }

        public void setVanityUrlCode(String vanityUrlCode) {
            this.vanityUrlCode = vanityUrlCode;
        }
    }
}
