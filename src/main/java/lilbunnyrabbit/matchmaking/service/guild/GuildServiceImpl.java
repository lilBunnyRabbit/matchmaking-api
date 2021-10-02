package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.model.discord.DiscordChannel;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.service.discord.api.DiscordApiService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@Service
@Transactional
public class GuildServiceImpl implements GuildService {

    @Autowired
    private GuildRepository guildRepository;

    @Autowired
    private DiscordApiService discordApiService;

    @Autowired
    PlayerService playerService;

    @Autowired
    GuildPlayerService guildPlayerService;

    @Override
    public Guild getGuild(String guildId) {
        Optional<Guild> optionalGuild = guildRepository.findById(guildId);
        return optionalGuild.orElse(null);
    }

    @Override
    public Guild createGuild(String guildId) {
        Guild guild = new Guild(guildId);
        guildRepository.save(guild);
        return guild;
    }

    @Override
    public Guild createGuild(String guildId, Consumer<Guild> callback) {
        Guild guild = new Guild(guildId);
        if (callback != null) callback.accept(guild);
        guildRepository.save(guild);
        return guild;
    }

    @Override
    public Guild guildInit(String guildId) throws GuildException {
        Guild guild = this.getGuild(guildId);
        if (guild != null) {
            throw new GuildException(GuildException.Issue.GUILD_EXIST);
        }

        DiscordChannel category = discordApiService.createChannel(guildId, DiscordChannel.GUILD_CATEGORY("Matchmaking"));
        if (category == null) {
            throw new GuildException(GuildException.Issue.FAILED_CREATE_CATEGORY);
        }

        guild = this.createGuild(guildId, (guildCallback) -> {
            guildCallback.setCategoryId(category.getId());
        });

        return guild;
    }


    @Override
    public GuildPlayer createGuildPlayer(Guild guild, Player player) throws GuildException {
        if (guild.getGuildPlayers().stream().anyMatch(guildPlayer -> guildPlayer.getPlayer().equals(player))) {
            throw new GuildException(GuildException.Issue.GUILD_PLAYER_EXIST);
        }

        GuildPlayer guildPlayer = new GuildPlayer(guild, player);
        guild.addGuildPlayer(guildPlayer);
        guildRepository.save(guild);
        return guildPlayer;
    }

    @Override
    public Queue createQueue(Guild guild, Set<GuildPlayer> guildPlayers) {
        Queue queue = new Queue();
        if (guildPlayers != null) guildPlayers.forEach(queue::addPlayer);
        guild.addQueue(queue);
        guildRepository.save(guild);
        return queue;
    }
}
