package lilbunnyrabbit.matchmaking.service.discord.command;

import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequest;
import lilbunnyrabbit.matchmaking.api.request.discord.InteractionRequestData;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponse;
import lilbunnyrabbit.matchmaking.api.response.discord.InteractionResponseData;
import lilbunnyrabbit.matchmaking.entity.Guild;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayer;
import lilbunnyrabbit.matchmaking.entity.Player;
import lilbunnyrabbit.matchmaking.entity.guildPlayer.GuildPlayerId;
import lilbunnyrabbit.matchmaking.repository.GuildPlayerRepository;
import lilbunnyrabbit.matchmaking.service.guild.GuildService;
import lilbunnyrabbit.matchmaking.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscordCommandServiceImpl  implements DiscordCommandService {

    @Autowired
    private GuildService guildService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GuildPlayerRepository guildPlayerRepository;

    public InteractionResponse commandHandler(InteractionRequest interaction) {
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

        Guild guild = guildService.createGuild("guild1");
        Player player = playerService.createPlayer("player1");
        guildPlayerRepository.save(new GuildPlayer(guild, player));

        Optional<GuildPlayer> guildPlayerOptional = guildPlayerRepository.findById(new GuildPlayerId(guild, player));
        guildPlayerOptional.ifPresent(guildPlayer -> System.out.println(guildPlayer.toString()));

//        String guildId = interaction.getGuildId();
//
//        if (guildId == null) {
//            Embed embed = new Embed();
//            embed.setColor(0xcc0000);
//            embed.setDescription("This command is only available in guilds!");
//            responseData.setEmbeds(List.of(embed));
//            return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, responseData);
//        }
//
//        Guild guild = guildService.getGuild(guildId);
//        Embed embed = new Embed();
//
//        if (guild == null) {
//            guild = guildService.createGuild(guildId);
//            embed.setColor(0x00cc00);
//            embed.setTitle("Guild created!");
//
//            Component.Button yayButton = new Component.Button(Component.Button.Style.PRIMARY, "yay");
//            yayButton.setLabel("Yay!");
//
//            Component.Button nayButton = new Component.Button(Component.Button.Style.DANGER, "nay");
//            nayButton.setLabel("Nay!");
//
//            responseData.setComponents(List.of(new Component.ActionRow(Arrays.asList(yayButton, nayButton))));
//        } else {
//            embed.setColor(0xcc5f86);
//            embed.setTitle("Guild exists!");
//        }
//
//        embed.setDescription(guild.getId());
//        responseData.setEmbeds(List.of(embed));



        return new InteractionResponse(InteractionResponse.Type.CHANNEL_MESSAGE_WITH_SOURCE, responseData);
    }
}
