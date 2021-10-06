package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
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
}
