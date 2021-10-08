package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;

import java.util.function.Consumer;

public interface GuildService {

    Guild getGuild(String guildId);

    Guild createGuild(String guildId);

    Guild createGuild(String guildId, Consumer<Guild> callback);

    Guild guildInit(String guildId) throws GuildException;
}
