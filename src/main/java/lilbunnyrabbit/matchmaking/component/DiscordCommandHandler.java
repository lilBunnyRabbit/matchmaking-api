package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.helpers.ResponseHelper;
import lilbunnyrabbit.matchmaking.helpers.GuildCommandHelper;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteraction;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInteractionResponse;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.stereotype.Component;

@Component
public class DiscordCommandHandler {

    private final GuildService guildService;

    public DiscordCommandHandler(GuildService guildService) {
        this.guildService = guildService;
    }

    public DiscordInteractionResponse handle(DiscordInteraction interaction) {
        DiscordInteraction.Data data = interaction.getData();
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

    private DiscordInteractionResponse guildInit(DiscordInteraction interaction) {
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

    private DiscordInteractionResponse registerPlayer(DiscordInteraction interaction) {
        // TODO
        return ResponseHelper.Success("registerPlayer", null);
    }

    private DiscordInteractionResponse queuePlayer(DiscordInteraction interaction) {
        // TODO
        return ResponseHelper.Success("queuePlayer", null);
    }

    private DiscordInteractionResponse dequeuePlayer(DiscordInteraction interaction) {
        // TODO
        return ResponseHelper.Success("dequeuePlayer", null);
    }
}
