package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
public class GuildServiceImpl implements GuildService {

    @Autowired
    private GuildRepository guildRepository;

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
    public Guild updateGuild(String guildId, Consumer<Guild> callback) throws GuildException {
        Guild guild = this.getGuild(guildId);
        if (guild == null) {
            throw new GuildException(GuildException.Issue.GUILD_NOT_EXISTS);
        }

        if (callback != null) callback.accept(guild);
        guildRepository.save(guild);
        return guild;
    }
}
