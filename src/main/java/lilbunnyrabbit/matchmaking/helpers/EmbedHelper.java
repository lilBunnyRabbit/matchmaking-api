package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.model.discord.DEmbed;

public class EmbedHelper {

    public static DEmbed SUCCESS(String title, String description) {
        DEmbed embed = new DEmbed();
        embed.setColor(0x00cc00);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static DEmbed ERROR(String title, String description) {
        DEmbed embed = new DEmbed();
        embed.setColor(0xcc0000);
        if (title != null) embed.setTitle(title);
        if (description != null) embed.setDescription(description);
        return embed;
    }

    public static DEmbed QUEUE_STARTED(Queue queue) {
        DEmbed embed = new DEmbed();
        embed.setColor(0xcccc00);
        embed.setTitle("Queue started!");
        embed.setDescription("Queue ID: " + queue.getId());
        return embed;
    }

    public static DEmbed QUEUE(Queue queue) {
        DEmbed embed = new DEmbed();
        embed.setColor(0xcccc00);
        embed.setTitle("Queue");
        embed.setDescription(queue.getPlayers().size() + " players");
        return embed;
    }
}
