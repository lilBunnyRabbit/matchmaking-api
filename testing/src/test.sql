INSERT INTO guild(id) VALUES 
('11111111'),
('22222222'),
('33333333');

-- INSERT INTO elo(guild_id, k, exp_constant, derank_limit, default_sigma, default_rank) VALUES 
-- ('11111111', 1, 2, 3, 4, 5), 
-- ('22222222', 6, 7, 8, 9, 10), 
-- ('33333333', 11, 12, 13, 14, 15);

-- INSERT INTO match_type(guild_id, name, team_count, team_player_count) VALUES
-- ('11111111', 'first', 2, 3),
-- ('11111111', 'second', 2, 2),
-- ('11111111', 'third', 4, 2);

-- INSERT INTO team(guild_id, name) VALUES
-- ('11111111', 'cloud9'),
-- ('11111111', 'banana');

-- INSERT INTO player(id, guild_id, team_id, time_created, muted) VALUES
-- ('1', '11111111', NULL, 123, false),
-- ('2', '11111111', 1, 123, false),
-- ('3', '22222222', NULL, 123, true);