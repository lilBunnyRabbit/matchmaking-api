package lilbunnyrabbit.matchmaking.service.impl;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
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
    public InteractionResponse handleInteraction(InteractionRequest interactionRequest) {
        if (interactionRequest.getType() == InteractionRequest.Type.PING) {
            return new InteractionResponse(InteractionResponse.Type.PONG);
        }

        InteractionResponse response = new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE);
        InteractionResponseData responseData = new InteractionResponseData();

        List<Embed> embeds = new ArrayList<>();
        Embed embed = new Embed();
        embed.setTitle("Hello");
        Embed.Footer footer = new Embed.Footer("Hello footer");
        embed.setFooter(footer);
        embeds.add(embed);
        responseData.setEmbeds(embeds);

        Component.ActionRow actionRow = new Component.ActionRow();
        List<Component> buttons = new ArrayList<>();
        Component.Button helloButton = new Component.Button(Component.Button.Style.PRIMARY, "hello_button");
        helloButton.setLabel("Hello");
        buttons.add(helloButton);

        Component.Button byeButton = new Component.Button(Component.Button.Style.DANGER, "bye_button");
        byeButton.setLabel("Bye");
        buttons.add(byeButton);
        actionRow.setComponents(buttons);
        responseData.setComponents(List.of(actionRow));
        response.setData(responseData);

        Optional<Guild> optionalGuild = guildRepository.findById(interactionRequest.getId());
        Guild guild;

        if (optionalGuild.isPresent()) {
            guild = optionalGuild.get();
            responseData.setContent("Guild exists: " + guild.getId());
        } else {
            guild = new Guild(interactionRequest.getId());
            guildRepository.save(guild);
            responseData.setContent("Guild created: " + guild.getId());
        }
        return response;
    }
}
