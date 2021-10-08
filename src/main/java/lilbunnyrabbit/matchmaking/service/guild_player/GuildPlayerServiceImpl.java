package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class GuildPlayerServiceImpl implements GuildPlayerService {

    private final GuildPlayerRepository guildPlayerRepository;

    private final GuildRepository guildRepository;

    public GuildPlayerServiceImpl(GuildPlayerRepository guildPlayerRepository, GuildRepository guildRepository) {
        this.guildPlayerRepository = guildPlayerRepository;
        this.guildRepository = guildRepository;
    }

    @Override
    public GuildPlayer getGuildPlayer(String guildId, String playerId) {
        Optional<GuildPlayer> optionalGuildPlayer = guildPlayerRepository.findById(new GuildPlayerId(guildId, playerId));
        return optionalGuildPlayer.orElse(null);
    }

    @Override
    public GuildPlayer createGuildPlayer(Guild guild, Player player) throws GuildPlayerException {
        if (guild.getGuildPlayers().stream().anyMatch(guildPlayer -> guildPlayer.getPlayer().equals(player))) {
            throw new GuildPlayerException(GuildPlayerException.Code.GUILD_PLAYER_EXISTS);
        }

        GuildPlayer guildPlayer = new GuildPlayer(guild, player);
        guild.addGuildPlayer(guildPlayer);
        guildRepository.save(guild);
        return guildPlayer;
    }
}
