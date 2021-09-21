import { ApplicationCommand } from "../../../types/discord/applicationCommand";

export namespace SlashCommand {
  export enum Global {}

  export enum Guild {
    REGISTER = 'register',
    QUEUE = 'queue'
  }
}

export const slashCommandsGuild: {
  [key in SlashCommand.Guild]: Omit<ApplicationCommand.Option, 'name'>
} = {
  [SlashCommand.Guild.REGISTER]: {
    description: 'Register guild'
  },
  [SlashCommand.Guild.QUEUE]: {
    description: 'Queue for a match'
  }
}

export const slashCommandsGlobal: {
  [key in SlashCommand.Global]: Omit<ApplicationCommand.Option, 'name'>
} = {}
