package sixmans.organization;

public class OrganizationRequest {
    private String id;

    public OrganizationRequest() {}  
    public OrganizationRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
