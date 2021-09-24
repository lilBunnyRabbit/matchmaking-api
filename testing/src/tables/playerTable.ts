import { TableData } from "../tableTest";
import { guildTable } from "./guildTable";
import { teamTable } from "./teamTable";

export interface PlayerTable {
  id: string;
  guild_id: string;
  time_created: number;
  muted: boolean;
  team_id: number | null;
}

export const playerTable: TableData<PlayerTable> = {
  name: 'player',
  properties: {
    id: {
      type: 'CHAR(32)'
    },
    guild_id: {
      type: guildTable.properties.id.type,
      notNull: true,
      reference: guildTable
    },
    team_id: {
      type: teamTable.properties.id.type,
      reference: teamTable
    },
    time_created: {
      type: 'BIGINT',
      notNull: true
    },
    muted: {
      type: 'BOOL',
      notNull: true
    },
  },
  primaryKey: 'id'
}