package lilbunnyrabbit.matchmaking.helpers;

import lilbunnyrabbit.matchmaking.component.DActionHandler;
import lilbunnyrabbit.matchmaking.model.discord.DComponent;

public class ButtonHelper {

    public static DComponent.Button LOBBY(String url) {
        DComponent.Button button = new DComponent.Button(DComponent.Button.Style.LINK);
        button.setLabel("Lobby");
        button.setUrl(url);
        return button;
    }

    public static DComponent.Button JOIN_QUEUE() {
        DComponent.Button button = new DComponent.Button(DComponent.Button.Style.SUCCESS);
        button.setCustomId(DActionHandler.Action.JOIN_QUEUE_BUTTON);
        button.setLabel("Join");
        return button;
    }

    public static DComponent.Button LEAVE_QUEUE() {
        DComponent.Button button = new DComponent.Button(DComponent.Button.Style.DANGER);
        button.setCustomId(DActionHandler.Action.LEAVE_QUEUE_BUTTON);
        button.setLabel("Leave");
        return button;
    }
}
