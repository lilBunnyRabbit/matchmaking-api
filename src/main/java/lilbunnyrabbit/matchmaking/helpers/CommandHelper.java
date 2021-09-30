package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.Embed;
import lilbunnyrabbit.matchmaking.model.discord.InteractionResponse;

public class CommandHelper {
    public static InteractionResponse NOT_DM_COMMAND = InteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(new InteractionResponse.Data("This command is not a DM command"));

    public static InteractionResponse Success(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.SUCCESS(title, description));
    }

    public static InteractionResponse Error(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.ERROR(title, description));
    }

    private static InteractionResponse GenericEmbedInteractionResponse(Embed embed) {
        return InteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(new InteractionResponse.Data(embed));
    }
}
