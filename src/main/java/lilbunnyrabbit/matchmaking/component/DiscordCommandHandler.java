package lilbunnyrabbit.matchmaking.component;

import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.exception.service.GuildException;
import lilbunnyrabbit.matchmaking.helpers.CommandHelper;
import lilbunnyrabbit.matchmaking.helpers.DiscordGuildCommand;
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
            case DiscordGuildCommand.Type.GUILD_INIT -> this.guildInit(interaction);
            case DiscordGuildCommand.Type.REGISTER_PLAYER -> this.registerPlayer(interaction);
            case DiscordGuildCommand.Type.QUEUE_PLAYER -> this.queuePlayer(interaction);
            case DiscordGuildCommand.Type.DEQUEUE_PLAYER -> this.dequeuePlayer(interaction);
            default -> null;
        };
    }

    private DiscordInteractionResponse guildInit(DiscordInteraction interaction) {
        // TODO

        /* Temporary */ {
            String guildId = interaction.getGuildId();
            if (guildId == null) {
                return CommandHelper.Error("Missing guild", null);
            }

            try {
                Guild guild = guildService.guildInit(guildId);

                return CommandHelper.Success("Guild Created", "ID: " + guild.getId());
            } catch (GuildException guildException) {
                guildException.printStackTrace();
                return switch (guildException.getCode()) {
                    case GUILD_EXIST -> CommandHelper.Error("Guild exists", null);
                    case FAILED_CREATE_CATEGORY -> CommandHelper.Error("Failed to create category", null);
                    default -> CommandHelper.Error("Failed to create guild", null);
                };
            }
        }
    }

    private DiscordInteractionResponse registerPlayer(DiscordInteraction interaction) {
        // TODO
        return CommandHelper.Success("registerPlayer", null);
    }

    private DiscordInteractionResponse queuePlayer(DiscordInteraction interaction) {
        // TODO
        return CommandHelper.Success("queuePlayer", null);
    }

    private DiscordInteractionResponse dequeuePlayer(DiscordInteraction interaction) {
        // TODO
        return CommandHelper.Success("dequeuePlayer", null);
    }
}
