package lilbunnyrabbit.matchmaking.service.player;

import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.exception.service.PlayerException;

import java.util.function.Consumer;

public interface PlayerService {
    Player getPlayer(String playerId);

    Player createPlayer(String playerId);

    Player createPlayer(String playerId, Consumer<Player> callback);

    Player updatePlayer(String playerId, Consumer<Player> callback) throws PlayerException;
}
