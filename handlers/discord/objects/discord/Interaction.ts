import {
  APIGatewayEvent,
  Context,
  Callback,
  APIGatewayProxyResult
} from 'aws-lambda';
import fs from 'fs';
import FormData from 'form-data';
import { BodyInit, HeaderInit } from 'node-fetch';
import { DiscordResponse } from './Response';
import { Interaction } from '../../types/discord/interaction';
import { ApplicationCommand } from '../../types/discord/applicationCommand';
import { InteractionAPI } from '../../utils/discordApi';

export class DiscordInteraction implements Interaction.Structure {
  // Interaction.Structure
  readonly id: Interaction.Structure['id'];
  readonly application_id: Interaction.Structure['application_id'];
  readonly type: Interaction.Structure['type'];
  readonly data: Interaction.Structure['data'];
  readonly guild_id: Interaction.Structure['guild_id'];
  readonly channel_id: Interaction.Structure['channel_id'];
  readonly member: Interaction.Structure['member'];
  readonly user: Interaction.Structure['user'];
  readonly token: Interaction.Structure['token'];
  readonly version: Interaction.Structure['version'];
  readonly message: Interaction.Structure['message'];

  // Lambda
  readonly lambda: {
    event: APIGatewayEvent;
    context: Context;
    callback: Callback<APIGatewayProxyResult | void>;
  }

  // Misc
  readonly response = DiscordResponse;

  constructor(data: Interaction.Structure, lambda: DiscordInteraction['lambda']) {
    // Interaction.Structure
    this.id = data.id;
    this.application_id = data.application_id;
    this.type = data.type;
    this.data = data.data;
    this.guild_id = data.guild_id;
    this.channel_id = data.channel_id;
    this.member = data.member;
    this.user = data.user;
    this.token = data.token;
    this.version = data.version;
    this.message = data.message;

    // Lambda
    this.lambda = lambda;
  }

  // API
  private async generateBodyAndHeaders(responseData: ApplicationCommand.CallbackData.APIStructure): Promise<{ body: BodyInit, headers: HeaderInit }> {
    if (responseData.file) {
      const body = new FormData();
      body.append('file', await fs.promises.readFile(responseData.file.path), {
        filename: responseData.file.name
      });

      if (responseData.payload_json) {
        body.append('payload_json', JSON.stringify(responseData.payload_json));
      } else {
        // TODO: handle the rest
      }

      return {
        body,
        headers: {}
      };
    }

    delete responseData.file;
    delete responseData.payload_json;

    return {
      body: JSON.stringify(responseData),
      headers: {
        'Content-Type': 'application/json'
      }
    };
  }

  public async respondToInteraction(responseData: ApplicationCommand.CallbackData.APIStructure) {
    const { body, headers } = await this.generateBodyAndHeaders(responseData);
    return InteractionAPI.respond(this.id, this.token, headers, body);
  }

  public async editResponse(responseData: ApplicationCommand.CallbackData.APIStructure) {
    const { body, headers } = await this.generateBodyAndHeaders(responseData);
    return InteractionAPI.editInitial(this.application_id, this.token, headers, body);
  }

  public async deleteResponse() {
    return InteractionAPI.deleteInitial(this.application_id, this.token);
  }

  public async followupResponse(responseData: ApplicationCommand.CallbackData.APIStructure) {
    const { body, headers } = await this.generateBodyAndHeaders(responseData);
    return InteractionAPI.followup(this.application_id, this.token, headers, body);
  }

  public async editMessage(responseData: ApplicationCommand.CallbackData.APIStructure) {
    if (!this.message) return;
    
    const { body, headers } = await this.generateBodyAndHeaders(responseData);
    return InteractionAPI.edit(this.application_id, this.token, this.message.id, headers, body);
  }

  // Lambda
  public callback(response: APIGatewayProxyResult) {
    this.lambda.callback(null, response);
  }
}

class InteractionAPIObject {
  
}