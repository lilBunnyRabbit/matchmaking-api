package sixmans.organization;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    List<Organization> findAll();
    Optional<Organization> findById(String id);
}