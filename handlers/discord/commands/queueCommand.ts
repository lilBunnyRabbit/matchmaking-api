import { CommandHandler } from "../applicationCommandHandler"
import { DiscordComponent } from "../objects/discord/Component"

export const queueCommand: CommandHandler = async (interaction) => {
  console.log("QueueCommand");
  
  return interaction.response.respond({
    embeds: [
      {
        title: "Match Queue",
        description: "3 players in the queue"
      }
    ],
    components: [
      DiscordComponent.ActionRow([
        DiscordComponent.Button.SUCCESS("queue", {
          label: "Join"
        }),
        DiscordComponent.Button.DANGER("leave", {
          label: "Leave"
        })
      ]),
    ]
  })
}