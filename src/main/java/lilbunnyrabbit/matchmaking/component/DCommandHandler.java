package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.helpers.ResponseHelper;
import lilbunnyrabbit.matchmaking.helpers.GuildCommandHelper;
import lilbunnyrabbit.matchmaking.model.discord.DInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DInteractionResponse;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.stereotype.Component;

@Component
public class DCommandHandler {

    private final GuildService guildService;

    public DCommandHandler(GuildService guildService) {
        this.guildService = guildService;
    }

    public DInteractionResponse handle(DInteraction interaction) {
        DInteraction.Data data = interaction.getData();
        if (data == null) return null;

        String commandName = data.getName();
        if (commandName == null) return null;

        return switch (commandName) {
            case GuildCommandHelper.Type.GUILD_INIT -> this.guildInit(interaction);
            case GuildCommandHelper.Type.REGISTER_PLAYER -> this.registerPlayer(interaction);
            case GuildCommandHelper.Type.QUEUE_PLAYER -> this.queuePlayer(interaction);
            case GuildCommandHelper.Type.DEQUEUE_PLAYER -> this.dequeuePlayer(interaction);
            default -> null;
        };
    }

    private DInteractionResponse guildInit(DInteraction interaction) {
        // TODO

        /* Temporary */ {
            String guildId = interaction.getGuildId();
            if (guildId == null) {
                return ResponseHelper.Error("Missing guild", null);
            }

            try {
                Guild guild = guildService.guildInit(guildId);

                return ResponseHelper.Success("Guild Created", "ID: " + guild.getId());
            } catch (GuildException guildException) {
                guildException.printStackTrace();
                return switch (guildException.getCode()) {
                    case GUILD_EXIST -> ResponseHelper.Error("Guild exists", null);
                    case FAILED_CREATE_CATEGORY -> ResponseHelper.Error("Failed to create category", null);
                    default -> ResponseHelper.Error("Failed to create guild", null);
                };
            }
        }
    }

    private DInteractionResponse registerPlayer(DInteraction interaction) {
        // TODO
        return ResponseHelper.Success("registerPlayer", null);
    }

    private DInteractionResponse queuePlayer(DInteraction interaction) {
        // TODO
        return ResponseHelper.Success("queuePlayer", null);
    }

    private DInteractionResponse dequeuePlayer(DInteraction interaction) {
        // TODO
        return ResponseHelper.Success("dequeuePlayer", null);
    }
}
