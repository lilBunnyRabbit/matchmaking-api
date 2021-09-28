package lilbunnyrabbit.matchmaking.service.guild;

import lilbunnyrabbit.matchmaking.entity.Guild;

public interface GuildService {
    Guild getGuild(String guildId);
    Guild createGuild(String guildId);
}
