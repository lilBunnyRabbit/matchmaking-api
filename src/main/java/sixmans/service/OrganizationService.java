package sixmans.service;

import java.util.List;

import sixmans.api.request.OrganizationRequest;
import sixmans.entity.Organization;

public interface OrganizationService {
    Organization getOrganization(String id);
    List<Organization> listOrganizations();
    Organization createOrganization(OrganizationRequest organizationRequest);
}
