package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.exception.service.GuildPlayerException;
import lilbunnyrabbit.matchmaking.helpers.ButtonHelper;
import lilbunnyrabbit.matchmaking.model.discord.*;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guild_player.GuildPlayer;
import lilbunnyrabbit.matchmaking.helpers.CommandHelper;
import lilbunnyrabbit.matchmaking.helpers.EmbedHelper;
import lilbunnyrabbit.matchmaking.service.discord.api.DiscordApiService;
import lilbunnyrabbit.matchmaking.model.discord.DiscordInvite;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.guild_player.GuildPlayerService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import lilbunnyrabbit.matchmaking.service.queue.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DiscordCommandServiceImpl implements DiscordCommandService {

    @Autowired
    private GuildService guildService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GuildPlayerService guildPlayerService;

    @Autowired
    private QueueService queueService;

    @Autowired
    private DiscordApiService discordApiService;

    public DiscordInteractionResponse commandHandler(DiscordInteraction interaction) {
        DiscordInteraction.Data data = interaction.getData();
        if (data == null) return null;

        String commandName = data.getName();
        if (commandName == null) return null;

        return switch (commandName) {
            case "tmp_init_guild" -> this.guildInitCommand(interaction);
            case "register" -> this.registerCommand(interaction);
            case "queue" -> this.queueCommand(interaction);
            default -> null;
        };
    }

    private DiscordInteractionResponse guildInitCommand(DiscordInteraction interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) return CommandHelper.NOT_DM_COMMAND;

        DiscordChannel category = discordApiService.createChannel(guildId, DiscordChannel.GUILD_CATEGORY("Matchmaking"));

        if (category == null) return  CommandHelper.Error("Failed to create Matchmaking category", null);

        Guild guild = guildService.createGuild(guildId, (guildCallback) -> {
            guildCallback.setCategoryId(category.getId());
        });

        if (guild == null) {
            return CommandHelper.Error("Failed to init guild", null);
        } else {
            return CommandHelper.Success("Guild init", "ID: " + guildId);
        }
    }

    private DiscordInteractionResponse registerCommand(DiscordInteraction interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) return CommandHelper.NOT_DM_COMMAND;

        DiscordMember member = interaction.getMember();
        if (member == null) return CommandHelper.Error("Missing data", "Member");

        DiscordUser user = member.getUser();
        if (user == null) return CommandHelper.Error("Missing data", "User");

        String playerId = user.getId();
        if (playerId == null) return CommandHelper.Error("Missing data", "User Id");

        try {
            guildPlayerService.registerGuildPlayer(guildId, playerId);
        } catch (GuildPlayerException guildPlayerException) {
            guildPlayerException.printStackTrace();

            return switch (guildPlayerException.getIssue()) {
                case GUILD_NOT_EXISTS -> CommandHelper.Error("Invalid server", "This server is currently not supported!");
                case GUILD_PLAYER_EXISTS -> CommandHelper.Error("Player already exists", null);
                default -> CommandHelper.Error("Internal Error!", null);
            };
        }

        return CommandHelper.Success("Player registered", null);
    }

    private DiscordInteractionResponse queueCommand(DiscordInteraction interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) return CommandHelper.NOT_DM_COMMAND;

        DiscordMember member = interaction.getMember();
        if (member == null) return CommandHelper.Error("Missing data", "Member");

        DiscordUser user = member.getUser();
        if (user == null) return CommandHelper.Error("Missing data", "User");

        String playerId = user.getId();
        if (playerId == null) return CommandHelper.Error("Missing data", "User Id");

        Guild guild = guildService.getGuild(guildId);
        if (guild == null) return CommandHelper.Error("Invalid server", "This server is currently not supported!");

        Queue queue;
        try {
            queue = guildPlayerService.queueGuildPlayer(guildId, playerId);
        } catch (GuildPlayerException guildPlayerException) {
            guildPlayerException.printStackTrace();

            return switch (guildPlayerException.getIssue()) {
                case GUILD_PLAYER_NOT_EXISTS -> CommandHelper.Error("Not registered", "You need to register first before you can start or join a queue");
                case IN_QUEUE -> CommandHelper.Error("Already in a queue", null);
                default -> CommandHelper.Error("Internal Error!", null);
            };
        }

        DiscordInteractionResponse.Data responseData = new DiscordInteractionResponse.Data(
                EmbedHelper.QUEUE(queue)
        );

        DiscordInvite invite = discordApiService.createChannelInvite(queue.getLobbyChannel());
        String channelLink = invite == null ? null : invite.createLink();

        if (channelLink != null) {
            responseData.setComponents(new DiscordComponent.ActionRow(
                    ButtonHelper.JOIN_QUEUE(),
                    ButtonHelper.LEAVE_QUEUE(),
                    ButtonHelper.LOBBY(channelLink)
            ));
        }

        return DiscordInteractionResponse.CHANNEL_MESSAGE_WITH_SOURCE(responseData);
    }
}
