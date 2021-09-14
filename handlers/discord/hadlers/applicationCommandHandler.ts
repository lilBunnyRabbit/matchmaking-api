import { InteractionHandler } from '../discordHandler';

export const applicationCommandHandler: InteractionHandler = async (interaction) => {
  console.log("applicationCommandHandler: ", interaction);

  return interaction.response.respond({
    content: "Hello"
  })

  // switch (interaction.data?.name) {
  //   default:
  //     break;
  // }
};