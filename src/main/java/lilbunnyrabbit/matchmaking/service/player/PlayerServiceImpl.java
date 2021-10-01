package lilbunnyrabbit.matchmaking.service.player;

import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.exception.service.PlayerException;
import lilbunnyrabbit.matchmaking.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

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

    @Override
    public Player createPlayer(String playerId, Consumer<Player> callback) {
        Player player = new Player(playerId);
        if (callback != null) callback.accept(player);
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(String playerId, Consumer<Player> callback) throws PlayerException {
        Player player = this.getPlayer(playerId);
        if (player == null) {
            throw new PlayerException(PlayerException.Issue.PLAYER_NOT_EXISTS);
        }

        if (callback != null) callback.accept(player);
        playerRepository.save(player);
        return player;
    }
}
