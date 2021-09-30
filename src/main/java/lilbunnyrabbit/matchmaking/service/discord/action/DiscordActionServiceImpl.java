package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.discord.Interaction;
import lilbunnyrabbit.matchmaking.model.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.model.discord.Member;
import lilbunnyrabbit.matchmaking.model.discord.User;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscordActionServiceImpl implements DiscordActionService {

    @Autowired
    private GuildService guildService;

    public InteractionResponse actionHandler(Interaction interaction) {
        Interaction.Data data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            default -> this.exampleAction(interaction);
        };
    }

    private InteractionResponse exampleAction(Interaction interaction) {
        InteractionResponse.Data responseData = new InteractionResponse.Data();
        Member member = interaction.getMember();

        responseData.setContent("Hello from message");
        if (member != null) {
            User user = member.getUser();
            if (user != null) {
                responseData.setContent("<@" + user.getId() + "> thank you for pressing that button...");
            }
        }

        return InteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(responseData);
    }
}
