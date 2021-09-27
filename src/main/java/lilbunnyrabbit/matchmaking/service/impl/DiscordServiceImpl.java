package lilbunnyrabbit.matchmaking.service.impl;

import lilbunnyrabbit.matchmaking.api.request.DiscordInteractionRequest;
import lilbunnyrabbit.matchmaking.api.response.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.DiscordInteractionResponseData;
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
    public DiscordInteractionResponse handleInteraction(DiscordInteractionRequest discordInteractionRequest) {
        if (discordInteractionRequest.getType() == 1) {
            DiscordInteractionResponse response = new DiscordInteractionResponse();
            response.setType(1);
            return response;
        }

        DiscordInteractionResponse response = new DiscordInteractionResponse();
        DiscordInteractionResponseData responseData = new DiscordInteractionResponseData();
        response.setType(4);
        response.setData(responseData);

        Optional<Guild> optionalGuild = guildRepository.findById(discordInteractionRequest.getId());
        Guild guild;

        if (optionalGuild.isPresent()) {
            guild = optionalGuild.get();
            responseData.setContent("Guild exists: " + guild.getId());
        } else {
            guild = new Guild(discordInteractionRequest.getId());
            guildRepository.save(guild);
            responseData.setContent("Guild created: " + guild.getId());
        }
        return response;
    }
}
