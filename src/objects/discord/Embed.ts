import { Embed } from "../../types/discord/embed";

export class DiscordEmbed {
  constructor(private data: Embed.Structure) { }

  public toJson(): Embed.Structure {
    return this.data;
  }
}