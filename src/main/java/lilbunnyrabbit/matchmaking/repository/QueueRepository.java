package lilbunnyrabbit.matchmaking.repository;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QueueRepository extends CrudRepository<Queue, Long> {

    List<Queue> findAll();

    Optional<Queue> findById(long id);

    void deleteById(long id);

    Optional<List<Queue>> findByGuild(Guild guild);

    Optional<List<Queue>> findByGuildAndStatus(Guild guild, Queue.Status status);
}