package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.api.response.discord.Embed;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;

public class CommandHelper {
    public static InteractionResponse NOT_DM_COMMAND = new InteractionResponse(
            InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE,
            new InteractionResponseData("This command is not a DM command")
    );

    public static InteractionResponse Error(String title, String message) {
        return GenericEmbedInteractionResponse(title, message, 0xcc0000);
    }

    public static InteractionResponse Success(String title, String message) {
        return GenericEmbedInteractionResponse(title, message, 0x00cc00);
    }

    private static InteractionResponse GenericEmbedInteractionResponse(String title, String message, int color) {
        Embed embed = new Embed();
        embed.setColor(color);

        if (title != null && !title.isBlank()) embed.setTitle(title);
        if (message != null && !message.isBlank()) embed.setDescription(message);

        InteractionResponseData responseData = new InteractionResponseData();
        responseData.setEmbed(embed);

        return new InteractionResponse(
                InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE,
                responseData
        );
    }
}
