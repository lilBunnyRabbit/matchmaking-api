package lilbunnyrabbit.matchmaking.api.request.discord;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class InteractionRequestData {
    @NotEmpty private String id;
    @NotEmpty private String name;

    @JsonProperty("custom_id")
    @NotEmpty private String customId;

    @JsonProperty("component_type")
    @NotEmpty private Integer componentType;

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

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public Integer getComponentType() {
        return componentType;
    }

    public void setComponentType(Integer componentType) {
        this.componentType = componentType;
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
