package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
