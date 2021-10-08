package lilbunnyrabbit.matchmaking.repository;

import lilbunnyrabbit.matchmaking.entity.Guild;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuildRepository extends CrudRepository<Guild, Long> {

    List<Guild> findAll();

    Optional<Guild> findById(String id);
}