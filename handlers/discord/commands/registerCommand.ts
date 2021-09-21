import { CommandHandler } from "../applicationCommandHandler";

export const registerCommand: CommandHandler = async (interaction) => {
  return interaction.response.respond({
    content: "Hello"
  })
}