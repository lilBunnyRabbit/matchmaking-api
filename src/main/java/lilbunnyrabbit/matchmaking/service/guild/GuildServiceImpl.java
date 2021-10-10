package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.component.DApi;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.model.discord.DChannel;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Consumer;

@Service
@Transactional
public class GuildServiceImpl implements GuildService {

    private final GuildRepository guildRepository;

    private final DApi discordApi;

    public GuildServiceImpl(GuildRepository guildRepository, DApi discordApi) {
        this.guildRepository = guildRepository;
        this.discordApi = discordApi;
    }

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
            throw new GuildException(GuildException.Code.GUILD_EXIST);
        }

        DChannel category = discordApi.createChannel(guildId, DChannel.GUILD_CATEGORY("Matchmaking"));
        if (category == null) {
            throw new GuildException(GuildException.Code.FAILED_CREATE_CATEGORY);
        }

        guild = this.createGuild(guildId, (guildCallback) -> {
            guildCallback.setCategoryId(category.getId());
        });

        return guild;
    }
}
