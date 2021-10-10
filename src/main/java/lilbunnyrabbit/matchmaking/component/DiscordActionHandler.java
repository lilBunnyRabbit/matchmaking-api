package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.helpers.ResponseHelper;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;
import org.springframework.stereotype.Component;

@Component
public class DiscordActionHandler {

    public DiscordActionHandler() {
    }

    public static class Action {
        public static final String JOIN_QUEUE_BUTTON = "join-queue-button";
        public static final String LEAVE_QUEUE_BUTTON = "leave-queue-button";
    }

    public DiscordInteractionResponse handle(DiscordInteraction interaction) {
        DiscordInteraction.Data data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            case Action.JOIN_QUEUE_BUTTON -> this.joinQueueButton(interaction);
            case Action.LEAVE_QUEUE_BUTTON -> this.leaveQueueButton(interaction);
            default -> null;
        };
    }

    private DiscordInteractionResponse joinQueueButton(DiscordInteraction interaction) {
        // TODO
        return ResponseHelper.Success("joinQueueButton", null);
    }

    private DiscordInteractionResponse leaveQueueButton(DiscordInteraction interaction) {
        // TODO
        return ResponseHelper.Success("leaveQueueButton", null);
    }
}
