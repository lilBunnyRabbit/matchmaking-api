package lilbunnyrabbit.matchmaking.service.impl;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequestData;
import lilbunnyrabbit.matchmaking.api.response.discord.Component;
import lilbunnyrabbit.matchmaking.api.response.discord.Embed;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.repository.GuildRepository;
import lilbunnyrabbit.matchmaking.service.DiscordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DiscordServiceImpl implements DiscordService {
    @Autowired
    private GuildRepository guildRepository;

    @Override
    public InteractionResponse handleInteraction(InteractionRequest interaction) {
        return switch (interaction.getType()) {
            case InteractionRequest.Type.PING -> new InteractionResponse(InteractionResponse.Type.PONG);
            case InteractionRequest.Type.APPLICATION_COMMAND -> this.commandHandler(interaction);
            case InteractionRequest.Type.MESSAGE_COMPONENT -> this.actionHandler(interaction);
            default -> null;
        };
    }

    public InteractionResponse commandHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
        if (data == null) return null;

        String commandName = data.getName();
        if (commandName == null) return null;

        return switch (commandName) {
            default -> this.exampleCommand(interaction);
        };
    }

    public InteractionResponse exampleCommand(InteractionRequest interaction) {
        InteractionResponseData responseData = new InteractionResponseData();

        String guildId = interaction.getGuildId();
        System.out.println("Guild ID: " + guildId);
        if (guildId == null) {
            Embed embed = new Embed();
            embed.setColor(0xcc0000);
            embed.setDescription("This command is only available in guilds!");
            responseData.setEmbeds(List.of(embed));
        } else {
            Optional<Guild> optionalGuild = guildRepository.findById(guildId);
            Guild guild;
            Embed embed = new Embed();

            if (optionalGuild.isPresent()) {
                guild = optionalGuild.get();
                embed.setColor(0xcc5f86);
                embed.setTitle("Guild exists!");
            } else {
                guild = new Guild(interaction.getGuildId());
                guildRepository.save(guild);
                embed.setColor(0x00cc00);
                embed.setTitle("Guild created!");

                Component.Button yayButton = new Component.Button(Component.Button.Style.PRIMARY, "yay");
                yayButton.setLabel("Yay!");

                Component.Button nayButton = new Component.Button(Component.Button.Style.DANGER, "nay");
                nayButton.setLabel("Nay!");

                responseData.setComponents(List.of(new Component.ActionRow(Arrays.asList(yayButton, nayButton))));
            }

            embed.setDescription(guild.getId());
            responseData.setEmbeds(List.of(embed));
        }

        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, responseData);
    }

    public InteractionResponse actionHandler(InteractionRequest interaction) {
        InteractionRequestData data = interaction.getData();
        if (data == null) return null;

        String actionName = data.getName();
        if (actionName == null) return null;

        return switch (actionName) {
            default -> this.exampleAction(interaction);
        };
    }

    public InteractionResponse exampleAction(InteractionRequest interaction) {
        InteractionResponseData data = new InteractionResponseData();
        data.setContent("Hello from message");

        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, data);
    }
}
