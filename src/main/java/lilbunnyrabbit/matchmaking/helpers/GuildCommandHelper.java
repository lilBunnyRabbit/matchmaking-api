package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DiscordApplicationCommand;

import java.util.ArrayList;

public class GuildCommandHelper {

    public static class Type {
        public static final String TEST = "test";
        public static final String GUILD_INIT = "tmp_init_guild";
        public static final String REGISTER_PLAYER = "register";
        public static final String QUEUE_PLAYER = "queue";
        public static final String DEQUEUE_PLAYER = "dequeue";
    }

    public static DiscordApplicationCommand Test() {
        final var options = new ArrayList<DiscordApplicationCommand.Option>();

        return new DiscordApplicationCommand(
                Type.TEST,
                "Test",
                options
        );
    }

    public static DiscordApplicationCommand GuildInit() {
        return new DiscordApplicationCommand(
                Type.GUILD_INIT,
                "Init Guild",
                new ArrayList<>()
        );
    }

    public static DiscordApplicationCommand RegisterPlayer() {
        return new DiscordApplicationCommand(
                Type.REGISTER_PLAYER,
                "Register Player",
                new ArrayList<>()
        );
    }

    public static DiscordApplicationCommand QueuePlayer() {
        return new DiscordApplicationCommand(
                Type.QUEUE_PLAYER,
                "Queue Player",
                new ArrayList<>()
        );
    }

    public static DiscordApplicationCommand DequeuePlayer() {
        return new DiscordApplicationCommand(
                Type.DEQUEUE_PLAYER,
                "Dequeue Player",
                new ArrayList<>()
        );
    }
}
