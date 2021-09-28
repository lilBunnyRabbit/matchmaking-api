package lilbunnyrabbit.matchmaking.service.discord;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequestData;
import lilbunnyrabbit.matchmaking.api.response.discord.Component;
import lilbunnyrabbit.matchmaking.api.response.discord.Embed;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DiscordServiceImpl implements DiscordService {

    @Autowired
    private GuildService guildService;

    @Override
    public InteractionResponse handleInteraction(InteractionRequest interaction) {
        return switch (interaction.getType()) {
            case InteractionRequest.Type.PING -> new InteractionResponse(InteractionResponse.Type.PONG);
            case InteractionRequest.Type.APPLICATION_COMMAND -> this.commandHandler(interaction);
            case InteractionRequest.Type.MESSAGE_COMPONENT -> this.actionHandler(interaction);
            default -> null;
        };
    }

    private InteractionResponse commandHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
        if (data == null) return null;

        String commandName = data.getName();
        if (commandName == null) return null;

        return switch (commandName) {
            default -> this.exampleCommand(interaction);
        };
    }

    private InteractionResponse exampleCommand(InteractionRequest interaction) {
        InteractionResponseData responseData = new InteractionResponseData();

        String guildId = interaction.getGuildId();

        if (guildId == null) {
            Embed embed = new Embed();
            embed.setColor(0xcc0000);
            embed.setDescription("This command is only available in guilds!");
            responseData.setEmbeds(List.of(embed));
            return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, responseData);
        }

        Guild guild = guildService.getGuild(guildId);
        Embed embed = new Embed();

        if (guild == null) {
            guild = guildService.createGuild(guildId);
            embed.setColor(0x00cc00);
            embed.setTitle("Guild created!");

            Component.Button yayButton = new Component.Button(Component.Button.Style.PRIMARY, "yay");
            yayButton.setLabel("Yay!");

            Component.Button nayButton = new Component.Button(Component.Button.Style.DANGER, "nay");
            nayButton.setLabel("Nay!");

            responseData.setComponents(List.of(new Component.ActionRow(Arrays.asList(yayButton, nayButton))));
        } else {
            embed.setColor(0xcc5f86);
            embed.setTitle("Guild exists!");
        }

        embed.setDescription(guild.getId());
        responseData.setEmbeds(List.of(embed));

        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, responseData);
    }

    private InteractionResponse actionHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
        if (data == null) return null;

        String actionId = data.getCustomId();
        if (actionId == null) return null;

        return switch (actionId) {
            default -> this.exampleAction(interaction);
        };
    }

    private InteractionResponse exampleAction(InteractionRequest interaction) {
        InteractionResponseData data = new InteractionResponseData();
        data.setContent("Hello from message");

        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }
}
