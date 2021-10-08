package lilbunnyrabbit.matchmaking.service.player;

import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getPlayer(String playerId) {
        Optional<Player> optionalGuild = playerRepository.findById(playerId);
        return optionalGuild.orElse(null);
    }

    @Override
    public Player createPlayer(String playerId) {
        Player player = new Player(playerId);
        playerRepository.save(player);
        return player;
    }
}
