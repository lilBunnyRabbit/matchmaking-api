package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;
import lilbunnyrabbit.matchmaking.exception.service.PlayerException;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import lilbunnyrabbit.matchmaking.service.queue.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Consumer;

@Service
@Transactional
public class GuildPlayerServiceImpl implements GuildPlayerService {

    @Autowired
    GuildPlayerRepository guildPlayerRepository;

    @Autowired
    GuildRepository guildRepository;

    @Override
    public GuildPlayer getGuildPlayer(String guildId, String playerId) {
        Optional<GuildPlayer> optionalGuildPlayer = guildPlayerRepository.findById(new GuildPlayerId(guildId, playerId));
        return optionalGuildPlayer.orElse(null);
    }

    @Override
    public GuildPlayer createGuildPlayer(Guild guild, Player player) throws GuildPlayerException {
        if (guild.getGuildPlayers().stream().anyMatch(guildPlayer -> guildPlayer.getPlayer().equals(player))) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_PLAYER_EXISTS);
        }

        GuildPlayer guildPlayer = new GuildPlayer(guild, player);
        guild.addGuildPlayer(guildPlayer);
        guildRepository.save(guild);
        return guildPlayer;
    }
}
