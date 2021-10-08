package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.component.DiscordActionHandler;
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
        button.setCustomId(DiscordActionHandler.Action.JOIN_QUEUE_BUTTON);
        button.setLabel("Join");
        return button;
    }

    public static DiscordComponent.Button LEAVE_QUEUE() {
        DiscordComponent.Button button = new DiscordComponent.Button(DiscordComponent.Button.Style.DANGER);
        button.setCustomId(DiscordActionHandler.Action.LEAVE_QUEUE_BUTTON);
        button.setLabel("Leave");
        return button;
    }
}
