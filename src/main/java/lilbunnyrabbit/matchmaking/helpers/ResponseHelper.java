package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DEmbed;
import lilbunnyrabbit.matchmaking.model.discord.DInteractionResponse;

public class ResponseHelper {

    public static DInteractionResponse NOT_DM_COMMAND = DInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(
            new DInteractionResponse.Data("This command is not a DM command")
    );

    public static DInteractionResponse Success(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.SUCCESS(title, description));
    }

    public static DInteractionResponse Error(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.ERROR(title, description));
    }

    private static DInteractionResponse GenericEmbedInteractionResponse(DEmbed embed) {
        return DInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(new DInteractionResponse.Data(embed));
    }
}
