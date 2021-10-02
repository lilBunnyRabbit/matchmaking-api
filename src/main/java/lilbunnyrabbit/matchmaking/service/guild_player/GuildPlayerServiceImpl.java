package lilbunnyrabbit.matchmaking.service.guild_player;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayerId;
import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;
import lilbunnyrabbit.matchmaking.exception.service.PlayerException;
import lilbunnyrabbit.matchmaking.exception.service.QueueException;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
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
    private GuildPlayerRepository guildPlayerRepository;

    @Autowired
    private GuildService guildService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private QueueService queueService;

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
    public GuildPlayer createGuildPlayer(Guild guild, Player player, Consumer<GuildPlayer> callback) {
        GuildPlayer guildPlayer = new GuildPlayer(guild, player);
        if (callback != null) callback.accept(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return guildPlayer;
    }

    @Override
    public GuildPlayer updateGuildPlayer(String guildId, String playerId, Consumer<GuildPlayer> callback) throws GuildPlayerException {
        GuildPlayer guildPlayer = this.getGuildPlayer(guildId, playerId);
        if (guildPlayer == null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_PLAYER_NOT_EXISTS);
        }

        if (callback != null) callback.accept(guildPlayer);
        guildPlayerRepository.save(guildPlayer);
        return guildPlayer;
    }

    @Override
    public void registerGuildPlayer(String guildId, String playerId) throws GuildPlayerException {
        if (this.getGuildPlayer(guildId, playerId) != null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_PLAYER_EXISTS);
        }

        System.out.println("registerGuildPlayer " + guildId + " " + playerId);
        Guild guild = guildService.getGuild(guildId);
        if (guild == null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_NOT_EXISTS);
        }

        if (playerService.getPlayer(playerId) == null) {
            Player player = playerService.createPlayer(playerId);

            GuildPlayer guildPlayer = this.createGuildPlayer(guild, player);
            try {
                 playerService.updatePlayer(playerId, (playerCallback) -> {
                    Set<GuildPlayer> guildPlayers = playerCallback.getGuildPlayers();
                    if (guildPlayers == null) guildPlayers = new HashSet<>();
                    guildPlayers.add(guildPlayer);
                });
            } catch (PlayerException e) {
                e.printStackTrace();
                throw new GuildPlayerException(GuildPlayerException.Issue.INTERNAL);
            }

        } else {
            try {
                playerService.updatePlayer(playerId, (playerCallback) -> {
                    GuildPlayer guildPlayer = this.createGuildPlayer(guild, playerCallback);
                    Set<GuildPlayer> guildPlayers = new HashSet<>();
                    guildPlayers.add(guildPlayer);
                    playerCallback.setGuildPlayers(guildPlayers);
                });
            } catch (PlayerException playerException) {
                playerException.printStackTrace();
                throw new GuildPlayerException(GuildPlayerException.Issue.INTERNAL);
            }
        }
    }

    @Override
    public Queue queueGuildPlayer(String guildId, String playerId) throws GuildPlayerException {
        GuildPlayer guildPlayer = this.getGuildPlayer(guildId, playerId);
        if (guildPlayer == null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_PLAYER_NOT_EXISTS);
        }

        if (guildPlayer.getQueue() != null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.IN_QUEUE);
        }

        try {
            return queueService.addPlayerToQueue(guildPlayer);
        } catch (QueueException queueException) {
            queueException.printStackTrace();
            throw new GuildPlayerException(GuildPlayerException.Issue.FAILED_JOIN_QUEUE);
        }
    }

    @Override
    public Queue dequeueGuildPlayer(String guildId, String playerId) throws GuildPlayerException {
        GuildPlayer guildPlayer = this.getGuildPlayer(guildId, playerId);
        if (guildPlayer == null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.GUILD_PLAYER_NOT_EXISTS);
        }

        if (guildPlayer.getQueue() == null) {
            throw new GuildPlayerException(GuildPlayerException.Issue.NOT_IN_QUEUE);
        }


        try {
            return queueService.removePlayerFromQueue(guildPlayer);
        } catch (QueueException queueException) {
            queueException.printStackTrace();
            throw new GuildPlayerException(GuildPlayerException.Issue.FAILED_LEAVE_QUEUE);
        }
    }
}
