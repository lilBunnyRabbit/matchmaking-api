import {
  APIGatewayEvent,
  Context,
  Callback,
  APIGatewayProxyResult
} from 'aws-lambda';
import { Interaction } from './types/discord/interaction';
import { safelyParseJson, validDiscordRequest } from "./utils/discordUtils";
import { applicationCommandHandler } from './hadlers/applicationCommandHandler';
import { messageComponentHandler } from './hadlers/messageComponentHandler';
import { DiscordResponse } from './objects/discord/Response';
import { DiscordInteraction } from './objects/discord/Interaction';

export type Handler = (
  event: APIGatewayEvent,
  context: Context,
  callback: Callback<APIGatewayProxyResult | void>
) => Promise<APIGatewayProxyResult | void> | APIGatewayProxyResult | void;

export type InteractionHandler = (
  interaction: DiscordInteraction
) => Promise<APIGatewayProxyResult | void> | APIGatewayProxyResult | void;

export const interaction: Handler = async (event, context, callback) => {
  if (!event.body) return DiscordResponse.ERROR;
  if (!validDiscordRequest(event)) return DiscordResponse.INVALID;

  const body = safelyParseJson<Interaction.Structure>(event.body);
  if (!body) return DiscordResponse.ERROR;

  const interaction = new DiscordInteraction(body, { event, context, callback });

  switch (interaction.type) {
    case Interaction.Request.Type.PING: {
      return DiscordResponse.PONG;
    }

    case Interaction.Request.Type.APPLICATION_COMMAND: {
      return applicationCommandHandler(interaction);
    }

    case Interaction.Request.Type.MESSAGE_COMPONENT: {
      return messageComponentHandler(interaction);
    }

    default: {
      return DiscordResponse.ERROR;
    }
  }
};

export const commands: Handler = async (event, context, callback) => {
  console.log(event.body);
};