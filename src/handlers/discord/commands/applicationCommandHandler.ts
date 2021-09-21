import { registerCommand } from './normal/registerCommand';
import { InteractionHandler } from '../discordHandler';
import { DiscordResponse } from '../../../objects/discord/Response';
import { SlashCommand } from '../slash-commands/slashCommands';
import { queueCommand } from './normal/queueCommand';

export type CommandHandler = InteractionHandler;

export const applicationCommandHandler: InteractionHandler = async (interaction) => {
  // console.log("applicationCommandHandler: ", interaction);
  console.log(interaction.data?.name);

  switch (interaction.data?.name) {
    case SlashCommand.Guild.QUEUE:
      return queueCommand(interaction);
    case SlashCommand.Guild.REGISTER:
      return registerCommand(interaction);
    default:
      return DiscordResponse.INVALID;
  }
};