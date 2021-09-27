package lilbunnyrabbit.matchmaking.api.request.discord;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class InteractionRequestData {
    @NotEmpty private String id;
    @NotEmpty private String name;
    @NotEmpty private String custom_id;
    @NotEmpty private Integer component_type;
    private InteractionRequestDataResolved resolved;
    private List<InteractionRequestDataOption> options;

    public InteractionRequestData() {}

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

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public Integer getComponent_type() {
        return component_type;
    }

    public void setComponent_type(Integer component_type) {
        this.component_type = component_type;
    }

    public InteractionRequestDataResolved getResolved() {
        return resolved;
    }

    public void setResolved(InteractionRequestDataResolved resolved) {
        this.resolved = resolved;
    }

    public List<InteractionRequestDataOption> getOptions() {
        return options;
    }

    public void setOptions(List<InteractionRequestDataOption> options) {
        this.options = options;
    }
}
