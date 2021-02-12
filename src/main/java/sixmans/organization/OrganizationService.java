package sixmans.organization;

import java.util.List;

public interface OrganizationService {
    Organization getOrganization(String id);
    List<Organization> listOrganizations();
    Organization createOrganization(OrganizationRequest organizationRequest);
}
