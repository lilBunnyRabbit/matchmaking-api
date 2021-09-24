CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-------------------------------------------------------------------------------------------------------
-- Guild
-------------------------------------------------------------------------------------------------------
CREATE TABLE guild(
  id CHAR(32),

  PRIMARY KEY(id)
);

-------------------------------------------------------------------------------------------------------
-- Config
-------------------------------------------------------------------------------------------------------
CREATE TABLE elo(
  guild_id CHAR(32),
  k INT NOT NULL,
  exp_constant INT NOT NULL,
  derank_limit INT NOT NULL,
  default_sigma INT NOT NULL,
  default_rank INT NOT NULL,

  PRIMARY KEY(guild_id),
  FOREIGN KEY(guild_id) REFERENCES guild(id)
);

CREATE TABLE match_type(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  name CHAR(64) NOT NULL,
  team_count INT NOT NULL,
  team_player_count INT NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id)
);

CREATE TABLE rank_type(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  name CHAR(64) NOT NULL,
  mmr INT NOT NULL,
  role CHAR(32) NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id)
);

CREATE TABLE queue_type(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  match_type_id UUID NOT NULL,
  name CHAR(64) NOT NULL,
  channel CHAR(32) NOT NULL,
  min_rank UUID NOT NULL,
  max_rank UUID NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id),
  FOREIGN KEY(match_type_id) REFERENCES match_type(id),
  FOREIGN KEY(min_rank) REFERENCES rank_type(id),
  FOREIGN KEY(max_rank) REFERENCES rank_type(id)
);

CREATE TABLE credential_type(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  name CHAR(64) NOT NULL,
  length INT NOT NULL,
  
  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id)
);

-------------------------------------------------------------------------------------------------------
-- Team
-------------------------------------------------------------------------------------------------------
CREATE TABLE team(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  name CHAR(64) NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id)
);

-------------------------------------------------------------------------------------------------------
-- Player
-------------------------------------------------------------------------------------------------------
CREATE TABLE player(
  id CHAR(32),
  guild_id CHAR(32) NOT NULL,
  team_id UUID,
  time_created DATE NOT NULL,
  muted BOOL NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id),
  FOREIGN KEY(team_id) REFERENCES team(id)
);

CREATE TABLE player_stats(
  player_id CHAR(32),
  rank_type_id UUID NOT NULL,
  mmr INT NOT NULL,

  PRIMARY KEY(player_id),
  FOREIGN KEY(player_id) REFERENCES player(id),
  FOREIGN KEY(rank_type_id) REFERENCES rank_type(id)
);

-------------------------------------------------------------------------------------------------------
-- Queue
-------------------------------------------------------------------------------------------------------
CREATE TABLE queue(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  queue_type_id UUID NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id),
  FOREIGN KEY(queue_type_id) REFERENCES queue_type(id)
);

CREATE TABLE player_queue(
  player_id CHAR(32) NOT NULL,
  queue_id UUID NOT NULL,

  FOREIGN KEY(player_id) REFERENCES player(id),
  FOREIGN KEY(queue_id) REFERENCES queue(id)
);

-------------------------------------------------------------------------------------------------------
-- Match
-------------------------------------------------------------------------------------------------------
CREATE TABLE match(
  id UUID DEFAULT uuid_generate_v4 (),
  guild_id CHAR(32) NOT NULL,
  host CHAR(32) NOT NULL,
  color CHAR(16) NOT NULL,
  match_type_id UUID NOT NULL,
  creation_type CHAR(16) NOT NULL,
  status CHAR(16) NOT NULL,
  status_updated DATE NOT NULL,
  time_created DATE NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(guild_id) REFERENCES guild(id),
  FOREIGN KEY(host) REFERENCES player(id),
  FOREIGN KEY(match_type_id) REFERENCES match_type(id)
);

CREATE TABLE match_credentials(
  match_id UUID,
  name CHAR(64) NOT NULL,
  value CHAR(64) NOT NULL,

  PRIMARY KEY(match_id),
  FOREIGN KEY(match_id) REFERENCES match(id)
);

CREATE TABLE match_team(
  id BIGSERIAL,
  match_id UUID NOT NULL,
  voice_channel CHAR(32) NOT NULL,

  PRIMARY KEY(id),
  FOREIGN KEY(match_id) REFERENCES match(id)
);

CREATE TABLE match_player(
  player_id CHAR(32),
  match_id UUID NOT NULL,
  match_team_id BIGINT NOT NULL,

  PRIMARY KEY(player_id),
  FOREIGN KEY(player_id) REFERENCES player(id),
  FOREIGN KEY(match_id) REFERENCES match(id),
  FOREIGN KEY(match_team_id) REFERENCES match_team(id)
);

CREATE TABLE player_match(
  player_id CHAR(32) NOT NULL,
  match_id UUID NOT NULL,

  FOREIGN KEY(player_id) REFERENCES player(id),
  FOREIGN KEY(match_id) REFERENCES match(id)
);