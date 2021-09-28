package lilbunnyrabbit.matchmaking.service.player;

import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

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
