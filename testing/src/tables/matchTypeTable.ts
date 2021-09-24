import { TableData } from "../tableTest";
import { guildTable } from "./guildTable";

export interface MatchTypeTable {
  id: number;
  guild_id: string;
  name: string;
  team_count: number;
  team_player_count: number;
}

export const matchTypeTable: TableData<MatchTypeTable> = {
  name: 'match_type',
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
    },
    team_count: {
      type: 'INT',
      notNull: true
    },
    team_player_count: {
      type: 'INT',
      notNull: true
    }
  },
  primaryKey: 'id'
}