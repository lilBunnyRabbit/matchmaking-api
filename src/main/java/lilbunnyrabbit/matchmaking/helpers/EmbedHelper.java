package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DiscordEmbed;

public class EmbedHelper {
    public static DiscordEmbed SUCCESS(String title, String description) {
        DiscordEmbed embed = new DiscordEmbed();
        embed.setColor(0x00cc00);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static DiscordEmbed ERROR(String title, String description) {
        DiscordEmbed embed = new DiscordEmbed();
        embed.setColor(0xcc0000);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static DiscordEmbed QUEUE_STARTED(long queueId) {
        DiscordEmbed embed = new DiscordEmbed();
        embed.setColor(0xcccc00);
        embed.setTitle("Queue started!");
        embed.setDescription("Queue ID: " + queueId);
        return embed;
    }
}
