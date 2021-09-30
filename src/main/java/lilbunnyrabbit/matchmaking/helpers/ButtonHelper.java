package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.model.discord.DiscordComponent;

public class ButtonHelper {
    public static DiscordComponent.Button LOBBY(String url) {
        DiscordComponent.Button button = new DiscordComponent.Button(DiscordComponent.Button.Style.LINK);
        button.setLabel("Lobby");
        button.setUrl(url);
        return button;
    }

    public static DiscordComponent.Button JOIN_QUEUE() {
        DiscordComponent.Button button = new DiscordComponent.Button(DiscordComponent.Button.Style.SUCCESS);
        button.setCustomId("join-queue");
        button.setLabel("Join");
        return button;
    }

    public static DiscordComponent.Button LEAVE_QUEUE() {
        DiscordComponent.Button button = new DiscordComponent.Button(DiscordComponent.Button.Style.DANGER);
        button.setCustomId("leave-queue");
        button.setLabel("Leave");
        return button;
    }
}
