package lilbunnyrabbit.matchmaking.service.discord.action;

import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.model.discord.DiscordMember;
import lilbunnyrabbit.matchmaking.model.discord.DiscordUser;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscordActionServiceImpl implements DiscordActionService {

    @Autowired
    private GuildService guildService;

    public DiscordInteractionResponse actionHandler(DiscordInteraction interaction) {
        DiscordInteraction.Data data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            default -> this.exampleAction(interaction);
        };
    }

    private DiscordInteractionResponse exampleAction(DiscordInteraction interaction) {
        DiscordInteractionResponse.Data responseData = new DiscordInteractionResponse.Data();
        DiscordMember member = interaction.getMember();

        responseData.setContent("Hello from message");
        if (member != null) {
            DiscordUser user = member.getUser();
            if (user != null) {
                responseData.setContent("<@" + user.getId() + "> thank you for pressing that button...");
            }
        }

        return DiscordInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(responseData);
    }
}
