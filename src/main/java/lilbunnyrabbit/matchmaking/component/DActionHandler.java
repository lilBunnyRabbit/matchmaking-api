package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.helpers.ResponseHelper;
import lilbunnyrabbit.matchmaking.model.discord.DInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DInteractionResponse;
import org.springframework.stereotype.Component;

@Component
public class DActionHandler {

    public DActionHandler() {
    }

    public static class Action {
        public static final String JOIN_QUEUE_BUTTON = "join-queue-button";
        public static final String LEAVE_QUEUE_BUTTON = "leave-queue-button";
    }

    public DInteractionResponse handle(DInteraction interaction) {
        DInteraction.Data data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            case Action.JOIN_QUEUE_BUTTON -> this.joinQueueButton(interaction);
            case Action.LEAVE_QUEUE_BUTTON -> this.leaveQueueButton(interaction);
            default -> null;
        };
    }

    private DInteractionResponse joinQueueButton(DInteraction interaction) {
        // TODO
        return ResponseHelper.Success("joinQueueButton", null);
    }

    private DInteractionResponse leaveQueueButton(DInteraction interaction) {
        // TODO
        return ResponseHelper.Success("leaveQueueButton", null);
    }
}
