import { Pool, QueryConfig } from "pg";
import { TableData } from "./tableTest";

let globalPool: Pool | undefined;

export function getClient() {
  if (!globalPool) globalPool = new Pool({
    user: 'lbr',
    host: 'localhost',
    database: 'matchmaking',
    password: '1234',
    port: 54320
  });

  return globalPool;
}

export function CREATE_TABLE<T>(table: TableData<T>): string {
  const data: string[] = [];
  for (const key in table.properties) {
    if (Object.prototype.hasOwnProperty.call(table.properties, key)) {
      let prop = `${key} ${table.properties[key].type}`;
      if (table.properties[key].notNull) prop += ` NOT NULL`;
      if (table.properties[key].reference) prop += ` REFERENCES ${table.properties[key].reference?.name}(${String(table.properties[key].reference?.primaryKey)})`;
      data.push(prop);
    }
  }

  if (table.primaryKey) {
    data.push(`PRIMARY KEY (${table.primaryKey})`);
  }

  if (table.extra) {
    data.push(...table.extra);
  }

  return `CREATE TABLE ${table.name}(${data.join(',')});`
}

export function DROP_TABLE<T>(table: TableData<T>): string {
  return `DROP TABLE IF EXISTS ${table.name};`
}

export function INSERT_INTO<T>(table: TableData<T>, data: Partial<T> | Array<Partial<T>>): string {
  if (!Array.isArray(data)) data = [data];
  if (data.length < 1) return '';

  const keys: string[] = Object.keys(data[0]);
  const values: string[] = data.map((d: any) => {
    return `(${keys.map((key) => {
      if (Object.prototype.hasOwnProperty.call(d, key)) {
        if (typeof d[key] === 'string') return `'${d[key]}'`;
        if (d[key] === null) return 'NULL'; 
        return d[key];
      } else {
        throw new Error(`Misssing key '${key}' on insert`);
      }
    }).join(', ')})`;
  });

  return `INSERT INTO ${table.name}(${keys.join(',')}) VALUES ${values.join(', ')};`;
}