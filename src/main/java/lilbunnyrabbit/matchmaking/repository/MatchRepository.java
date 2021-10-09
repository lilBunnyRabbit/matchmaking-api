package lilbunnyrabbit.matchmaking.repository;

import lilbunnyrabbit.matchmaking.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {

}
