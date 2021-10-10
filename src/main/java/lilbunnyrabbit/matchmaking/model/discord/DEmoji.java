package lilbunnyrabbit.matchmaking.model.discord;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DEmoji {

    @NotEmpty
    private String id;

    @NotEmpty
    private String name;

    private List<String> roles;

    private DUser user;

    @JsonProperty("require_colons")
    private Boolean requiredColons;

    private Boolean managed;

    private Boolean animated;

    private Boolean available;

    public DEmoji() {
    }

    public DEmoji(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public DEmoji(String name) {
        this.name = name;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setRoles(String... roles) {
        this.roles = List.of(roles);
    }

    public DUser getUser() {
        return user;
    }

    public void setUser(DUser user) {
        this.user = user;
    }

    public Boolean getRequiredColons() {
        return requiredColons;
    }

    public void setRequiredColons(Boolean requiredColons) {
        this.requiredColons = requiredColons;
    }

    public Boolean getManaged() {
        return managed;
    }

    public void setManaged(Boolean managed) {
        this.managed = managed;
    }

    public Boolean getAnimated() {
        return animated;
    }

    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Partial {

        @NotEmpty
        private String id;

        @NotEmpty
        private String name;

        private Boolean animated;

        public Partial() {
        }

        public Partial(String id, String name, Boolean animated) {
            this.id = id;
            this.name = name;
            this.animated = animated;
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

        public Boolean getAnimated() {
            return animated;
        }

        public void setAnimated(Boolean animated) {
            this.animated = animated;
        }
    }
}
