import { TableData } from "../tableTest";
import { guildTable } from "./guildTable";

export interface EloTable {
  guild_id: string;
  k: number;
  exp_constant: number;
  derank_limit: number;
  default_sigma: number;
  default_rank: number;
}

export const eloTable: TableData<EloTable> = {
  name: 'elo',
  properties: {
    guild_id: {
      type: guildTable.properties.id.type,
      reference: guildTable
    },
    k: {
      type: 'INT',
      notNull: true
    },
    exp_constant: {
      type: 'INT',
      notNull: true
    },
    derank_limit: {
      type: 'INT',
      notNull: true
    },
    default_sigma: {
      type: 'INT',
      notNull: true
    },
    default_rank: {
      type: 'INT',
      notNull: true
    },
  },
  primaryKey: 'guild_id'
}

