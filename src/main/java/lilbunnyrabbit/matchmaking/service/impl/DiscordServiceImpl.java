package lilbunnyrabbit.matchmaking.service.impl;

import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.service.DiscordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscordServiceImpl implements DiscordService {
    @Autowired
    private GuildRepository guildRepository;

    @Override
    public String handleInteraction(DiscordInteractionRequest discordInteractionRequest) {
        Optional<Guild> optionalGuild = guildRepository.findById(discordInteractionRequest.getId());
        if (optionalGuild.isPresent()) {
            Guild guild = optionalGuild.get();

            return "Guild exists: " + guild.getId();
        } else {
            Guild guild = new Guild(discordInteractionRequest.getId());
            guildRepository.save(guild);

            return "Guild created: " + guild.getId();
        }
    }
}
