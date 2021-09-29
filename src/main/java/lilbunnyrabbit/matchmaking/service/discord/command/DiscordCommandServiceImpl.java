package lilbunnyrabbit.matchmaking.service.discord.command;

import com.fasterxml.jackson.core.JsonProcessingException;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequestData;
import lilbunnyrabbit.matchmaking.api.request.discord.Member;
import lilbunnyrabbit.matchmaking.api.request.discord.User;
import lilbunnyrabbit.matchmaking.api.response.discord.Component;
import lilbunnyrabbit.matchmaking.api.response.discord.Embed;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.Queue;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.helpers.ButtonHelper;
import lilbunnyrabbit.matchmaking.helpers.CommandHelper;
import lilbunnyrabbit.matchmaking.helpers.EmbedHelper;
import lilbunnyrabbit.matchmaking.service.discord.api.DiscordApiService;
import lilbunnyrabbit.matchmaking.service.discord.api.request.VoiceChannelRequest;
import lilbunnyrabbit.matchmaking.service.discord.api.response.InviteResponse;
import lilbunnyrabbit.matchmaking.service.discord.api.response.VoiceChannelResponse;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.guildPlayer.GuildPlayerService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import lilbunnyrabbit.matchmaking.service.queue.QueueService;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiscordCommandServiceImpl  implements DiscordCommandService {

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

    public InteractionResponse commandHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
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


    private InteractionResponse guildInitCommand(InteractionRequest interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) {
            return CommandHelper.NOT_DM_COMMAND;
        }

        Guild guild = guildService.createGuild(guildId);

        if (guild == null) {
            return CommandHelper.Error("Failed to init guild", null);
        } else {
            return CommandHelper.Success("Guild init", "ID: " + guildId);
        }
    }

    private InteractionResponse registerCommand(InteractionRequest interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) return CommandHelper.NOT_DM_COMMAND;

        Member member = interaction.getMember();
        if (member == null) return CommandHelper.Error("Missing data", "Member");

        User user = member.getUser();
        if (user == null) return CommandHelper.Error("Missing data", "User");

        String playerId = user.getId();
        if (playerId == null) return CommandHelper.Error("Missing data", "User Id");

        Guild guild = guildService.getGuild(guildId);
        if (guild == null) return CommandHelper.Error("Invalid server", "This server is currently not supported!");

        StringBuilder responseMessage = new StringBuilder();

        Player player = playerService.getPlayer(playerId);
        if (player == null) {
            player = playerService.createPlayer(playerId);
            responseMessage.append("- Created Player\n");
        }

        GuildPlayer guildPlayer = guildPlayerService.getGuildPlayer(guildId, playerId);
        if (guildPlayer == null) {
            guildPlayerService.createGuildPlayer(guild, player);
            responseMessage.append("- Created Guild Player\n");
        }

        if (responseMessage.isEmpty()) {
            return CommandHelper.Error("Player already exists", null);
        } else {
            return CommandHelper.Success("Player registered", responseMessage.toString());
        }
    }

    private InteractionResponse queueCommand(InteractionRequest interaction) {
        String guildId = interaction.getGuildId();
        if (guildId == null) return CommandHelper.NOT_DM_COMMAND;

        Member member = interaction.getMember();
        if (member == null) return CommandHelper.Error("Missing data", "Member");

        User user = member.getUser();
        if (user == null) return CommandHelper.Error("Missing data", "User");

        String playerId = user.getId();
        if (playerId == null) return CommandHelper.Error("Missing data", "User Id");

        Guild guild = guildService.getGuild(guildId);
        if (guild == null) return CommandHelper.Error("Invalid server", "This server is currently not supported!");

        GuildPlayer guildPlayer = guildPlayerService.getGuildPlayer(guildId, playerId);
        if (guildPlayer == null) return CommandHelper.Error("Not registered", "You need to register first before you can start or join a queue");
        if (guildPlayer.getQueue() != null) return CommandHelper.Error("Already in a queue", null);

        Set<GuildPlayer> players = new HashSet<>();
        players.add(guildPlayer);

        // TODO: Check if there is an open queue

        Queue queue = queueService.createQueueWithPlayers(guild, players);

        VoiceChannelResponse voiceChannelResponse = discordApiService.createVoiceChannel(guildId, new VoiceChannelRequest("VC - " + queue.getId()));
        if (voiceChannelResponse == null) {
            // TODO: undo the whole thing
            return CommandHelper.Error("Failed to create queue VC", null);
        }

        InteractionResponseData responseData = new InteractionResponseData();

        InviteResponse inviteResponse = discordApiService.createChannelInvite(voiceChannelResponse.getId());
        String channelLink = inviteResponse == null ? null : inviteResponse.createLink();

        if (channelLink != null) {
            responseData.setComponent(new Component.ActionRow(
                    ButtonHelper.JOIN_QUEUE(),
                    ButtonHelper.LEAVE_QUEUE(),
                    ButtonHelper.LOBBY(channelLink)
            ));
        }

        responseData.setEmbed(EmbedHelper.QUEUE_STARTED(queue.getId()));

        return new InteractionResponse(
                InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE,
                responseData
        );
    }
}
