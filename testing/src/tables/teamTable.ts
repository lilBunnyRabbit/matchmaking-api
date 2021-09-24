import { TableData } from "../tableTest";
import { guildTable } from "./guildTable";

export interface TeamTable {
  id: number;
  guild_id: string;
  name: string;
}

export const teamTable: TableData<TeamTable> = {
  name: 'team',
  properties: {
    id: {
      type: 'BIGSERIAL'
    },
    guild_id: {
      type: guildTable.properties.id.type,
      notNull: true,
      reference: guildTable
    },
    name: {
      type: 'CHAR(64)',
      notNull: true
    }
  },
  primaryKey: 'id'
}