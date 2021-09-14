import { APIGatewayProxyResult } from 'aws-lambda';
import { ApplicationCommand } from '../../types/discord/applicationCommand';
import { Interaction } from '../../types/discord/interaction';

const proxyResult = (
  statusCode: number,
  type: Interaction.Response.Type,
  data?: ApplicationCommand.CallbackData.Structure
): APIGatewayProxyResult => ({
  statusCode,
  body: JSON.stringify({ type, data })
});

const staticResponses = {
  // ACK a Ping
  PONG: {
    statusCode: 200,
    body: `{"type":${Interaction.Response.Type.PONG}}`
  } as APIGatewayProxyResult,

  // ACK an interaction and edit a response later, the user sees a loading state
  LOADING: {
    statusCode: 200,
    body: `{"type":${Interaction.Response.Type.DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE}}`
  } as APIGatewayProxyResult,

  // for components, ACK an interaction and edit the original message later; the user does not see a loading state
  LOADING_COMPONENT: {
    statusCode: 200,
    body: `{"type":${Interaction.Response.Type.DEFERRED_UPDATE_MESSAGE}}`
  } as APIGatewayProxyResult,

  INVALID: {
    statusCode: 401,
    body: 'invalid request signature'
  } as APIGatewayProxyResult,

  ERROR: {
    statusCode: 400,
    body: 'Error'
  } as APIGatewayProxyResult
};

const dynamicResponses = {
  // respond to an interaction with a message
  respond: (data?: ApplicationCommand.CallbackData.Structure) => (
    proxyResult(200, Interaction.Response.Type.CHANNEL_MESSAGE_WITH_SOURCE, data)
  ),

  // for components, edit the message the component was attached to
  edit: (data?: ApplicationCommand.CallbackData.Structure) => (
    proxyResult(200, Interaction.Response.Type.UPDATE_MESSAGE, data)
  )
};

export const DiscordResponse = {
  ...staticResponses,
  ...dynamicResponses
};