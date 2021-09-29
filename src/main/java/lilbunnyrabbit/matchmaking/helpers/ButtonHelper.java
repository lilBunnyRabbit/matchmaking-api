package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.api.response.discord.Component;

public class ButtonHelper {
    public static Component.Button LOBBY(String url) {
        Component.Button button = new Component.Button(Component.Button.Style.LINK);
        button.setLabel("Lobby");
        button.setUrl(url);
        return button;
    }

    public static Component.Button JOIN_QUEUE() {
        Component.Button button = new Component.Button(Component.Button.Style.SUCCESS);
        button.setCustomId("join-queue");
        button.setLabel("Join");
        return button;
    }

    public static Component.Button LEAVE_QUEUE() {
        Component.Button button = new Component.Button(Component.Button.Style.DANGER);
        button.setCustomId("leave-queue");
        button.setLabel("Leave");
        return button;
    }
}
