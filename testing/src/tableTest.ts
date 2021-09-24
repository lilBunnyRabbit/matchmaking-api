import { CREATE_TABLE, DROP_TABLE, getClient, INSERT_INTO } from './dbApi';
import { eloTable } from './tables/eloTable';
import { guildTable } from './tables/guildTable';
import { matchTypeTable } from './tables/matchTypeTable';
import { playerTable } from './tables/playerTable';
import { teamTable } from './tables/teamTable';
import fs from 'fs';

export interface TableDataProperty {
  type: string;
  notNull?: boolean;
  reference?: TableData<any>;
}

export interface TableData<T> {
  name: Tables;
  properties: {[key in keyof T]: TableDataProperty};
  primaryKey?: keyof T;
  extra?: string[];
}

export const tables = {
  guild: guildTable,
  elo: eloTable,
  match_type: matchTypeTable,
  player: playerTable,
  team: teamTable
}

export type Tables = keyof typeof tables;

const guildId: string = '5555';

const query = [
  DROP_TABLE(tables.match_type),
  DROP_TABLE(tables.player),
  DROP_TABLE(tables.elo),
  DROP_TABLE(tables.team),
  DROP_TABLE(tables.guild),

  CREATE_TABLE(tables.guild),
  CREATE_TABLE(tables.elo),
  CREATE_TABLE(tables.match_type),
  CREATE_TABLE(tables.team),
  CREATE_TABLE(tables.player),

  INSERT_INTO(tables.guild, { id: guildId }),
  INSERT_INTO(tables.elo, { guild_id: guildId, k: 1, exp_constant: 2, derank_limit: 3, default_sigma: 4, default_rank: 5 }),
];

export async function tableTest() {
  const client = getClient();
  
  console.log(await client.query(fs.readFileSync('./src/dropTables.sql').toString()));
  console.log(await client.query(fs.readFileSync('./src/createTables.sql').toString()));
  console.log(await client.query(fs.readFileSync('./src/test.sql').toString()));
}