package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.request.InteractionRequest;
import lilbunnyrabbit.matchmaking.model.request.InteractionRequestData;
import lilbunnyrabbit.matchmaking.model.discord.Member;
import lilbunnyrabbit.matchmaking.model.discord.User;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponse;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponseData;
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
