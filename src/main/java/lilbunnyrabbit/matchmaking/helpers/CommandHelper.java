package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.Embed;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponse;
import lilbunnyrabbit.matchmaking.model.response.InteractionResponseData;

public class CommandHelper {
    public static InteractionResponse NOT_DM_COMMAND = new InteractionResponse(
            InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE,
            new InteractionResponseData("This command is not a DM command")
    );

    public static InteractionResponse Success(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.SUCCESS(title, description));
    }

    public static InteractionResponse Error(String title, String description) {
        return GenericEmbedInteractionResponse(EmbedHelper.ERROR(title, description));
    }

    private static InteractionResponse GenericEmbedInteractionResponse(Embed embed) {
        InteractionResponseData responseData = new InteractionResponseData();
        responseData.setEmbed(embed);

        return new InteractionResponse(
                InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE,
                responseData
        );
    }
}
