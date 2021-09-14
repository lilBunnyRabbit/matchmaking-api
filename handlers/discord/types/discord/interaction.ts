import { ApplicationCommand } from "./applicationCommand";

export namespace Interaction {
  export interface Structure {
    id: string;
    application_id: string;
    type: Request.Type;
    data?: ApplicationCommand.InteractionData.Structure;
    guild_id?: string;
    channel_id?: string;
    member?: any; // TODO: with Member object
    user?: any; // TODO: with User object
    token: string;
    version: number;
    message?: any; // TODO: with Message object
  }

  export namespace Request {
    export enum Type {
      PING = 1,
      APPLICATION_COMMAND = 2,
      MESSAGE_COMPONENT = 3
    }
  }

  export namespace Response {
    export interface Structure {
      type: Type;
      data?: ApplicationCommand.CallbackData.Structure
    }

    export enum Type {
      PONG = 1,
      CHANNEL_MESSAGE_WITH_SOURCE = 4,
      DEFERRED_CHANNEL_MESSAGE_WITH_SOURCE = 5,
      DEFERRED_UPDATE_MESSAGE = 6,
      UPDATE_MESSAGE = 7
    }
  }
}