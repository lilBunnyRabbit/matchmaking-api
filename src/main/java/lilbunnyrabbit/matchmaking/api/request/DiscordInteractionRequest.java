package lilbunnyrabbit.matchmaking.api.request;

public class DiscordInteractionRequest {
    private String id;
    private String application_id;
    private Integer type;
    // ...

    public DiscordInteractionRequest() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
