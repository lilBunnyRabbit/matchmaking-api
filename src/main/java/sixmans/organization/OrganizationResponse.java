package sixmans.organization;

public class OrganizationResponse {
    private String id;

    public OrganizationResponse(Organization organization) {
        this.id = organization.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}