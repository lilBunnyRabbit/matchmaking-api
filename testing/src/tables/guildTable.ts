import { TableData } from "../tableTest";

export interface GuildTable {
  id: string;
}

export const guildTable: TableData<GuildTable> = {
  name: 'guild',
  properties: {
    id: {
      type: 'CHAR(32)'
    }
  },
  primaryKey: 'id'
}