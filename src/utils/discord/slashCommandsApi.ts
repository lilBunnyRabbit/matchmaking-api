import fetch from "node-fetch";
import { ApplicationCommand } from "../../types/discord/applicationCommand";
import { SlashCommand, slashCommandsGuild } from "../../handlers/discord/slash-commands/slashCommands";

export function addGuildCommand(guildId: string, data: ApplicationCommand.Option) {
  console.log(JSON.stringify(data));
  
  fetch(`https://discord.com/api/v8/applications/${process.env.APPLICATION_ID}/guilds/${guildId}/commands`, {
    method: 'PATCH',
    body: JSON.stringify(data),
    headers: {
      'Authorization': `Bot ${process.env.BOT_TOKEN}`,
      'Content-Type': 'application/json'
    }
  }).then(res => res.json()).then(console.log).catch(console.error)
}

export function addAllCommandsToGuild(guildId: string) {
  (Object.keys(slashCommandsGuild) as SlashCommand.Guild[]).forEach((key) => {
    addGuildCommand(guildId, {
      name: key,
      ...slashCommandsGuild[key]
    });
  })
}

export function bulkOverrideGuildCommands(guildId: string) {
  fetch(`https://discord.com/api/v8/applications/${process.env.APPLICATION_ID}/guilds/${guildId}/commands`, {
    method: 'PUT',
    body: JSON.stringify((Object.keys(slashCommandsGuild) as SlashCommand.Guild[]).map((key) => ({
      name: key,
      ...slashCommandsGuild[key]
    }))),
    headers: {
      'Authorization': `Bot ${process.env.BOT_TOKEN}`,
      'Content-Type': 'application/json'
    }
  }).then(res => res.json()).then(console.log).catch(console.error)
}