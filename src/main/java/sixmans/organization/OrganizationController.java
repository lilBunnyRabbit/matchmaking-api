package sixmans.organization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("")
    public String home() {
        return "Welcome to organization controller";
    }

    @GetMapping("get/{id}")
    public Organization getOrganization(@PathVariable String id) {
        return organizationService.getOrganization(id);
    }

    @PostMapping("create")
    public Organization createOrganization(@RequestBody @Valid OrganizationRequest organizationRequest) {
        return organizationService.createOrganization(organizationRequest);
    }

    @GetMapping("list")
    public List<Organization> listOrganizations() {
        return organizationService.listOrganizations();
    }
}
