package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DiscordEmbed;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;

public class CommandHelper {
    public static DiscordInteractionResponse NOT_DM_COMMAND = DiscordInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(
            new DiscordInteractionResponse.Data("This command is not a DM command")
    );

    public static DiscordInteractionResponse Success(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.SUCCESS(title, description));
    }

    public static DiscordInteractionResponse Error(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.ERROR(title, description));
    }

    private static DiscordInteractionResponse GenericEmbedInteractionResponse(DiscordEmbed embed) {
        return DiscordInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(new DiscordInteractionResponse.Data(embed));
    }
}
