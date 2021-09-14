import { AllowedMentions } from "./allowedMentions";
import { Component } from "./component";
import { Embed } from "./embed";

export namespace ApplicationCommand {
  export interface Structure {
    id: string;
    application_id: string;
    guild_id?: string;
    name: string;
    description: string;
    options: Option[];
    default_permission?: boolean;
  }

  export interface Option {
    type: OptionType;
    name: string;
    description: string;
    required?: boolean;
    choices?: OptionChoice[]; // max 25
    options?: Option[];
  }

  export enum OptionType {
    SUB_COMMAND = 1,
    SUB_COMMAND_GROUP = 2,
    STRING = 3,
    INTEGER = 4,
    BOOLEAN = 5,
    USER = 6,
    CHANNEL = 7,
    ROLE = 8,
    MENTIONABLE = 9
  }

  export interface OptionChoice {
    name: string;
    value: string | number;
  }

  export namespace Permissions {
    export interface GuildStructure {
      id: string;
      application_id: string;
      guild_id: string;
      permissions: Structure[];
    }

    export interface Structure {
      id: string;
      type: Type;
      permission: boolean;
    }

    export enum Type {
      ROLE = 1,
      USER = 2
    }
  }

  export namespace InteractionData {
    export interface Structure {
      id: string;
      name: string;
      resolved?: Resolved;
      options?: Option[];
      custom_id: string;
      component_type: Component.Type;
    }

    export interface Resolved {
      users?: any[]; // TODO: with User object
      members?: any[]; // TODO: with Member object
      roles?: any[]; // TODO: with Role object
      channels?: any[]; // TODO: with Channel object
    }

    export interface Option {
      name: string;
      type: ApplicationCommand.OptionType;
      value?: ApplicationCommand.OptionType;
      options?: Option;
    }
  }

  export namespace CallbackData {
    export interface Structure {
      tts?: boolean;
      content?: string;
      embeds?: Embed.Structure[];
      allowed_mentions?: AllowedMentions.Structure;
      flags?: Flags;
      components?: Component.Structure[];
    }

    export interface APIStructure extends Omit<CallbackData.Structure, 'flags'> {
      file?: {
        name: string;
        path: string;
      };
      payload_json?: ApplicationCommand.CallbackData.Structure;
      message_reference?: any; // TODO: with Message Reference object
      sticker_ids?: string[]; // max 3
    }

    export enum Flags {
      EPHEMERAL1 = 1, // EPHEMERAL 1 << 6
      EPHEMERAL2 = 2, 
      EPHEMERAL3 = 3,
      EPHEMERAL4 = 4, 
      EPHEMERAL5 = 5,
      EPHEMERAL6 = 6
    }
  }
}