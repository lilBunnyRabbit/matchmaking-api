package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.api.response.discord.Embed;

public class EmbedHelper {
    public static Embed SUCCESS(String title, String description) {
        Embed embed = new Embed();
        embed.setColor(0x00cc00);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static Embed ERROR(String title, String description) {
        Embed embed = new Embed();
        embed.setColor(0xcc0000);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static Embed QUEUE_STARTED(long queueId) {
        Embed embed = new Embed();
        embed.setColor(0xcccc00);
        embed.setTitle("Queue started!");
        embed.setDescription("Queue ID: " + queueId);
        return embed;
    }
}
