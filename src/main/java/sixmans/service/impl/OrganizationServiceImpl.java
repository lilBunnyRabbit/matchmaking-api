package sixmans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sixmans.api.exceptions.UniversalError;
import sixmans.api.request.OrganizationRequest;
import sixmans.entity.Organization;
import sixmans.repository.OrganizationRepository;
import sixmans.service.OrganizationService;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganization(String id) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        if (optionalOrganization.isPresent()) {
            Organization organization = optionalOrganization.get();
            return organization;
        }
        throw new UniversalError("Organization not found");
    }

    @Override
    public List<Organization> listOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization createOrganization(OrganizationRequest organizationRequest) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(organizationRequest.getId());
        if (optionalOrganization.isPresent()) throw new UniversalError("Organization with that id already exists!");

        Organization organization = new Organization(organizationRequest);
        organizationRepository.save(organization);
        
        return organization;
    }
}
