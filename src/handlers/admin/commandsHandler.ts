import {
  APIGatewayEvent,
  Context,
  Callback,
  APIGatewayProxyResult
} from 'aws-lambda';
import { bulkOverrideGuildCommands } from '../../utils/discord/slashCommandsApi';

export type Handler = (
  event: APIGatewayEvent,
  context: Context,
  callback: Callback<APIGatewayProxyResult | void>
) => Promise<APIGatewayProxyResult | void> | APIGatewayProxyResult | void;

export const commands: Handler = async (event, context, callback) => {
  const body: any = event;
  const guildId: string = body?.guild_id;
  console.log("Body: ", body, guildId);
  if (!body || !guildId) return;

  bulkOverrideGuildCommands(guildId);
};