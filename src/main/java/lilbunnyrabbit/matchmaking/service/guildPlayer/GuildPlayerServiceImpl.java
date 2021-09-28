package lilbunnyrabbit.matchmaking.service.guildPlayer;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayerId;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuildPlayerServiceImpl implements GuildPlayerService {

    @Autowired
    private GuildPlayerRepository guildPlayerRepository;

    @Override
    public GuildPlayer getGuildPlayer(String guildId, String playerId) {
        Optional<GuildPlayer> optionalGuildPlayer = guildPlayerRepository.findById(new GuildPlayerId(guildId, playerId));
        return optionalGuildPlayer.orElse(null);
    }

    @Override
    public GuildPlayer createGuildPlayer(Guild guild, Player player) {
        GuildPlayer guildPlayer = new GuildPlayer(guild, player);
        guildPlayerRepository.save(guildPlayer);
        return guildPlayer;
    }

    @Override
    public void setGuildPlayerQueue(GuildPlayerId guildPlayerId, Queue queue) {
        Optional<GuildPlayer> optionalGuildPlayer = guildPlayerRepository.findById(guildPlayerId);
        if (optionalGuildPlayer.isPresent()) {
            GuildPlayer guildPlayer = optionalGuildPlayer.get();
            guildPlayer.setQueue(queue);
            guildPlayerRepository.save(guildPlayer);
        }
    }
}
