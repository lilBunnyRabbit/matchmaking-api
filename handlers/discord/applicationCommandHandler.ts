import { queueCommand } from './commands/queueCommand';
import { registerCommand } from './commands/registerCommand';
import { InteractionHandler } from './discordHandler';
import { DiscordComponent } from './objects/discord/Component';
import { DiscordResponse } from './objects/discord/Response';
import { SlashCommand, slashCommandsGuild } from './slash-commands/slashCommands';
import { Component } from './types/discord/component';

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