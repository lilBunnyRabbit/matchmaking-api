package lilbunnyrabbit.matchmaking.repository;

import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GuildPlayerRepository extends CrudRepository<GuildPlayer, Long> {
    List<GuildPlayer> findAll();
    Optional<GuildPlayer> findById(GuildPlayerId id);
}