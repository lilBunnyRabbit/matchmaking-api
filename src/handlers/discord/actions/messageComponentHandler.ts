import { DiscordResponse } from "../../../objects/discord/Response";
import { InteractionHandler } from "../discordHandler";

export const messageComponentHandler: InteractionHandler = async (interaction) => {
  console.log("messageComponentHandler: ", interaction);

  return DiscordResponse.edit({
    content: `The time is now ${new Date().toTimeString()}`
  })
};
