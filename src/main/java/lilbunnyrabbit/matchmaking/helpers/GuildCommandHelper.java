package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DApplicationCommand;

import java.util.ArrayList;

public class GuildCommandHelper {

    public static class Type {
        public static final String TEST = "test";
        public static final String GUILD_INIT = "tmp_init_guild";
        public static final String REGISTER_PLAYER = "register";
        public static final String QUEUE_PLAYER = "queue";
        public static final String DEQUEUE_PLAYER = "dequeue";
    }

    public static DApplicationCommand Test() {
        final var options = new ArrayList<DApplicationCommand.Option>();

        return new DApplicationCommand(
                Type.TEST,
                "Test",
                options
        );
    }

    public static DApplicationCommand GuildInit() {
        return new DApplicationCommand(
                Type.GUILD_INIT,
                "Init Guild",
                new ArrayList<>()
        );
    }

    public static DApplicationCommand RegisterPlayer() {
        return new DApplicationCommand(
                Type.REGISTER_PLAYER,
                "Register Player",
                new ArrayList<>()
        );
    }

    public static DApplicationCommand QueuePlayer() {
        return new DApplicationCommand(
                Type.QUEUE_PLAYER,
                "Queue Player",
                new ArrayList<>()
        );
    }

    public static DApplicationCommand DequeuePlayer() {
        return new DApplicationCommand(
                Type.DEQUEUE_PLAYER,
                "Dequeue Player",
                new ArrayList<>()
        );
    }
}
