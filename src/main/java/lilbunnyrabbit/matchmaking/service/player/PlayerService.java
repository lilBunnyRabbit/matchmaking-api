package lilbunnyrabbit.matchmaking.service.player;

import lilbunnyrabbit.matchmaking.entity.Player;

public interface PlayerService {
    Player getPlayer(String playerId);

    Player createPlayer(String playerId);
}
