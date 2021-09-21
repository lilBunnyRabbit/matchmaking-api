export interface Guild {
  id: string; // Discord guild id
  players: Guild.Player[];
  matches: Guild.Match[];
  queues: Guild.Queue[];
  config: Guild.Config;
}

export namespace Guild {
  // Config
  export interface Config {
    elo: {
      k: number;
      exp_constant: number;
      derank_limit: number;
      default_sigma: number;
      default_rank: Player.Rank;
    },
    ranks: Player.Rank[];
    match_types: Guild.Match.Type[];
    queue_types: Guild.Queue.Type[];
    credentials: Guild.Match.Credential[];
  }
  
  // Player
  export interface Player {
    id: string; // Discord id
    guild: Guild;
    time_created: number;
    rank: {
      mmr: number;
      type: Player.Rank;
    };
    elo: {
      sigma: number;
      banned: boolean;
    };
    discord: {
      muted: boolean;
    };
    matches: Guild.Match[];
  }
  
  export namespace Player {
    export interface Rank {
      id: any; // some Rank id
      guild: Guild;
      mmr: number;
      name: string;
      role: string; // Discord role id
    }
  }

  // Match
  export interface Match {
    id: any; // some Match id
    guild: Guild;
    host: Player;
    time_created: number;
    color: string; // hex color
    type: Match.Type;
    creation_type?: Match.CreationType; // needs to be voted
    status: Match.Status;
    status_updated: number; // last time the status was updated
    players: Match.Player;
    credentials: {[key: string]: string | number}; // custom for server
    teams: {[key: Match.TeamId]: {
      voice_channel_id: string; // Discord vc id
      result: Match.Result;
    }}
  }

  // Match
  export namespace Match {
    export interface Type {
      id: any; // some Match id
      guild: Guild;
      team_players: number; // amount of players in the team
      teams: number; // amount of teams
      type: string; // ex. 1v1 // custom
    }
  
    export enum CreationType {
      RANDOM = 'random',
      BALANCED = 'balanced',
      CAPTAINS = 'captains'
    }
  
    export enum Status {
      TYPE_VOTE = 'type_vote',
      TEAM_CREATION = 'team_creation',
      LOBBY = 'lobby',
      IN_PROGRESS = 'in_progress',
      DONE = 'done'
    }
  
    export interface Player extends Omit<Guild.Player, 'guild' | 'time_created' | 'discord' | 'matches'> {
      team_id: TeamId;
      creation_vote?: CreationType; // team creation type vote
      match_vote?: Result; // lost or won
    }
  
    export type TeamId = string;
  
    export enum Result {
      WON = 'won',
      LOST = 'lost'
    }
  
    export interface Credential {
      name: string;
      length: number;
    }
  }
  
  // Queue
  export interface Queue {
    id: any;
    guild: Guild;
    time_created: number;
    type: Queue.Type;
    match_type: Guild.Match.Type;
    players: Guild.Player[];
  }

  export namespace Queue {
    export interface Type {
      min_rank: Guild.Player.Rank;
      max_rank: Guild.Player.Rank;
      channel: string; // Discord channel
    }
  }
}