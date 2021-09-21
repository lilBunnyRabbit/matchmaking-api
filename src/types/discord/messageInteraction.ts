import { Interaction } from "./interaction";

export namespace MessageInteraction {
  export interface Structure {
    id: string;
    type: Interaction.Response.Type;
    name: string;
    user: any; // TODO: with User object
  }
}