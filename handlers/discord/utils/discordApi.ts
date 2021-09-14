import fetch, { BodyInit, HeaderInit } from 'node-fetch';

const DISCORD_URL = "https://discord.com/api/v8";

export const InteractionAPI = {
  // Respond to an Interaction
  // POST /interactions/<interaction_id>/<interaction_token>/callback
  respond: async (interactionId: string, interactionToken: string, headers: HeaderInit, body: BodyInit) => (
    fetch(DISCORD_URL + `/interactions/${interactionId}/${interactionToken}/callback`, {
      method: 'POST', headers, body
    })
  ),

  // Edit your initial response to an Interaction
  // PATCH /webhooks/<application_id>/<interaction_token>/messages/@original
  editInitial: async (applicationId: string, interactionToken: string, headers: HeaderInit, body: BodyInit) => (
    fetch(DISCORD_URL + `/webhooks/${applicationId}/${interactionToken}/messages/@original`, {
      method: 'PATCH', headers, body
    })
  ),

  // Delete your initial response to an Interaction
  // DELETE /webhooks/<application_id>/<interaction_token>/messages/@original
  deleteInitial: async (applicationId: string, interactionToken: string) => (
    fetch(DISCORD_URL + `/webhooks/${applicationId}/${interactionToken}/messages/@original`, {
      method: 'DELETE'
    })
  ),

  // Send a new followup message
  // POST /webhooks/<application_id>/<interaction_token>
  followup: async (applicationId: string, interactionToken: string, headers: HeaderInit, body: BodyInit) => (
    fetch(DISCORD_URL + `/webhooks/${applicationId}/${interactionToken}`, {
      method: 'POST', headers, body
    })
  ),

  // Edit a message sent with that token
  // PATCH /webhooks/<application_id>/<interaction_token>/messages/<message_id>
  edit: async (applicationId: string, interactionToken: string, messageId: string, headers: HeaderInit, body: BodyInit) => (
    fetch(DISCORD_URL + `/webhooks/${applicationId}/${interactionToken}/messages/${messageId}`, {
      method: 'PATCH', headers, body
    })
  )
}