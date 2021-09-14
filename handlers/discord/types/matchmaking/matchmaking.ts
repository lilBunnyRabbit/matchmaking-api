namespace Guild {
  export interface Structure {
    id: string; // Discord guild id
    players: Player[];
    matches: Match[];
    queues: Queue[];
    config: Config;
  }

  export interface Config {
    elo: {
      k: number;
      exp_constant: number;
      derank_limit: number;
      default_sigma: number;
      default_rank: Guild.Rank;
    },
    ranks: Guild.Rank[];
    match_types: Guild.MatchType[];
    queue_types: Guild.QueueType[];
  }

  export interface Player {
    id: string; // Discord id
    guild: Guild.Structure;
    time_created: number;
    rank: {
      mmr: number;
      type: Rank;
    };
    elo: {
      sigma: number;
      banned: boolean;
    };
    discord: {
      muted: boolean;
    };
    matches: Match[];
  }
  
  export interface Rank {
    id: any; // some Rank id
    guild: Guild.Structure;
    mmr: number;
    name: string;
    role: string; // Discord role id
  }

  // Match
  export interface Match {
    id: any; // some Match id
    guild: Guild.Structure;
    host: Player;
    time_created: number;
    color: string; // hex color
    type: MatchType;
    creation_type?: MatchCreationType; // needs to be voted
    status: MatchStatus;
    status_updated: number; // last time the status was updated
    players: MatchPlayer;
    credentials: {[key: string]: string | number}; // custom for server
    teams: {[key: MatchTeamId]: {
      voice_channel_id: string; // Discord vc id
      result: MatchResult;
    }}
  }
  
  export interface MatchType {
    id: any; // some Match id
    guild: Guild.Structure;
    team_players: number; // amount of players in the team
    teams: number; // amount of teams
    type: string; // ex. 1v1 // custom
  }

  export enum MatchCreationType {
    RANDOM = 'random',
    BALANCED = 'balanced',
    CAPTAINS = 'captains'
  }

  export enum MatchStatus {
    TYPE_VOTE = 'type_vote',
    TEAM_CREATION = 'team_creation',
    LOBBY = 'lobby',
    IN_PROGRESS = 'in_progress',
    DONE = 'done'
  }

  export interface MatchPlayer extends Omit<Player, 'guild' | 'time_created' | 'discord' | 'matches'> {
    team_id: MatchTeamId;
    creation_vote?: MatchCreationType; // team creation type vote
    match_vote?: MatchResult; // lost or won
  }

  export type MatchTeamId = string;

  export enum MatchResult {
    WON = 'won',
    LOST = 'lost'
  }

  // Queue
  export interface Queue {
    id: any;
    guild: Guild.Structure;
    time_created: number;
    type: QueueType;
    match_type: MatchType;
    players: Player[];
  }
  
  export interface QueueType {
    min_rank: Rank;
    max_rank: Rank;
    channel: string; // Discord channel
  }
}

