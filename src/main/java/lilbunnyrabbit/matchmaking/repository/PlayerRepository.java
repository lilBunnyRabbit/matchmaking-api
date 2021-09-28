package lilbunnyrabbit.matchmaking.repository;

import lilbunnyrabbit.matchmaking.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAll();
    Optional<Player> findById(String id);
}