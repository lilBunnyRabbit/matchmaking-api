package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequestData;
import lilbunnyrabbit.matchmaking.api.request.discord.Member;
import lilbunnyrabbit.matchmaking.api.request.discord.User;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscordActionServiceImpl implements DiscordActionService {

    @Autowired
    private GuildService guildService;

    public InteractionResponse actionHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            default -> this.exampleAction(interaction);
        };
    }

    private InteractionResponse exampleAction(InteractionRequest interaction) {
        InteractionResponseData data = new InteractionResponseData();
        Member member = interaction.getMember();

        data.setContent("Hello from message");
        if (member != null) {
            User user = member.getUser();
            if (user != null) {
                data.setContent("<@" + user.getId() + "> thank you for pressing that button...");
            }
        }

        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }
}
