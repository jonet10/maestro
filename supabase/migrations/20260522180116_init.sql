-- Enable UUID extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Define Enums
CREATE TYPE match_status AS ENUM ('waiting', 'in_progress', 'completed', 'cancelled');
CREATE TYPE match_type AS ENUM ('casual', 'ranked', 'league', 'tournament');
CREATE TYPE move_type AS ENUM ('play_tile', 'pass', 'draw');
CREATE TYPE player_rank AS ENUM ('Debitant', 'Mwayen', 'Avanse', 'Met', 'Gran Met', 'Dominolog');

-- 1. players
CREATE TABLE players (
    id UUID PRIMARY KEY REFERENCES auth.users(id) ON DELETE CASCADE,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(255) NOT NULL,
    avatar_url TEXT,
    elo_points INTEGER DEFAULT 1500,
    rank player_rank DEFAULT 'Debitant',
    timezone_slot INTEGER CHECK (timezone_slot >= 0 AND timezone_slot <= 23),
    total_matches INTEGER DEFAULT 0,
    wins INTEGER DEFAULT 0,
    losses INTEGER DEFAULT 0,
    capot_wins INTEGER DEFAULT 0,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW()
);

-- 2. leagues
CREATE TABLE leagues (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL,
    division INTEGER NOT NULL,
    timezone_slot INTEGER CHECK (timezone_slot >= 0 AND timezone_slot <= 23),
    season_number INTEGER NOT NULL,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 3. league_members
CREATE TABLE league_members (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    league_id UUID REFERENCES leagues(id) ON DELETE CASCADE,
    player_id UUID REFERENCES players(id) ON DELETE CASCADE,
    points INTEGER DEFAULT 0,
    wins INTEGER DEFAULT 0,
    losses INTEGER DEFAULT 0,
    capot_wins INTEGER DEFAULT 0,
    elo INTEGER DEFAULT 1500,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    UNIQUE(league_id, player_id)
);

-- 4. seasons
CREATE TABLE seasons (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    season_number INTEGER UNIQUE NOT NULL,
    start_date TIMESTAMPTZ NOT NULL,
    end_date TIMESTAMPTZ NOT NULL,
    is_active BOOLEAN DEFAULT false,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 5. matches
CREATE TABLE matches (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    player1_id UUID REFERENCES players(id) ON DELETE RESTRICT,
    player2_id UUID REFERENCES players(id) ON DELETE RESTRICT,
    winner_id UUID REFERENCES players(id) ON DELETE SET NULL,
    player1_score INTEGER DEFAULT 0,
    player2_score INTEGER DEFAULT 0,
    match_status match_status DEFAULT 'waiting',
    match_type match_type DEFAULT 'casual',
    league_id UUID REFERENCES leagues(id) ON DELETE SET NULL,
    started_at TIMESTAMPTZ,
    ended_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 6. game_states
CREATE TABLE game_states (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    match_id UUID REFERENCES matches(id) ON DELETE CASCADE UNIQUE,
    board_state JSONB DEFAULT '[]'::jsonb,
    player1_hand JSONB DEFAULT '[]'::jsonb,
    player2_hand JSONB DEFAULT '[]'::jsonb,
    boneyard JSONB DEFAULT '[]'::jsonb,
    current_turn UUID REFERENCES players(id) ON DELETE SET NULL,
    round_number INTEGER DEFAULT 1,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- 7. moves
CREATE TABLE moves (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    match_id UUID REFERENCES matches(id) ON DELETE CASCADE,
    player_id UUID REFERENCES players(id) ON DELETE SET NULL,
    move_type move_type NOT NULL,
    tile_played JSONB,
    side_played VARCHAR(10),
    created_at TIMESTAMPTZ DEFAULT NOW()
);

-- Recommended Indexes
CREATE INDEX idx_players_username ON players(username);
CREATE INDEX idx_players_elo ON players(elo_points DESC);
CREATE INDEX idx_matches_players ON matches(player1_id, player2_id);
CREATE INDEX idx_matches_status ON matches(match_status);
CREATE INDEX idx_moves_match_id ON moves(match_id);
CREATE INDEX idx_league_members_league_id ON league_members(league_id);
CREATE INDEX idx_league_members_player_id ON league_members(player_id);

-- SQL Functions
CREATE OR REPLACE FUNCTION calculate_rank(elo integer) 
RETURNS player_rank AS $$
BEGIN
    IF elo >= 4300 THEN RETURN 'Dominolog';
    ELSIF elo >= 3600 THEN RETURN 'Gran Met';
    ELSIF elo >= 3000 THEN RETURN 'Met';
    ELSIF elo >= 2500 THEN RETURN 'Avanse';
    ELSIF elo >= 2000 THEN RETURN 'Mwayen';
    ELSE RETURN 'Debitant';
    END IF;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

CREATE OR REPLACE FUNCTION update_player_rank()
RETURNS TRIGGER AS $$
BEGIN
    NEW.rank = calculate_rank(NEW.elo_points);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_player_rank
    BEFORE INSERT OR UPDATE OF elo_points ON players
    FOR EACH ROW
    EXECUTE FUNCTION update_player_rank();

-- Elo Calculation Function
CREATE OR REPLACE FUNCTION update_elo(winner_elo int, loser_elo int)
RETURNS TABLE (new_winner_elo int, new_loser_elo int) AS $$
DECLARE
    k_factor int := 32;
    expected_winner float;
    expected_loser float;
BEGIN
    expected_winner := 1.0 / (1.0 + power(10, (loser_elo - winner_elo) / 400.0));
    expected_loser := 1.0 / (1.0 + power(10, (winner_elo - loser_elo) / 400.0));
    
    new_winner_elo := winner_elo + round(k_factor * (1 - expected_winner));
    new_loser_elo := loser_elo + round(k_factor * (0 - expected_loser));
    
    RETURN QUERY SELECT new_winner_elo, new_loser_elo;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- Match Points Function
CREATE OR REPLACE FUNCTION calculate_match_points(
    is_winner boolean, 
    is_capot boolean
) RETURNS integer AS $$
BEGIN
    IF is_winner THEN
        IF is_capot THEN
            RETURN 3; -- 3 points for capot win
        ELSE
            RETURN 2; -- 2 points for normal win
        END IF;
    ELSE
        RETURN 1; -- 1 point for losing
    END IF;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- Trigger to set updated_at
CREATE OR REPLACE FUNCTION set_updated_at()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_players_updated_at
    BEFORE UPDATE ON players
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();

-- Enable RLS
ALTER TABLE players ENABLE ROW LEVEL SECURITY;
ALTER TABLE leagues ENABLE ROW LEVEL SECURITY;
ALTER TABLE league_members ENABLE ROW LEVEL SECURITY;
ALTER TABLE seasons ENABLE ROW LEVEL SECURITY;
ALTER TABLE matches ENABLE ROW LEVEL SECURITY;
ALTER TABLE game_states ENABLE ROW LEVEL SECURITY;
ALTER TABLE moves ENABLE ROW LEVEL SECURITY;

-- RLS Policies
-- Players: read all profiles, update own
CREATE POLICY "Players can read all profiles" ON players
    FOR SELECT USING (true);

CREATE POLICY "Users can update own profile" ON players
    FOR UPDATE USING (auth.uid() = id);

-- Matches: only authenticated users can create matches
CREATE POLICY "Anyone can read matches" ON matches
    FOR SELECT USING (true);

CREATE POLICY "Authenticated users can create matches" ON matches
    FOR INSERT WITH CHECK (auth.role() = 'authenticated');

CREATE POLICY "Participants can update matches" ON matches
    FOR UPDATE USING (auth.uid() = player1_id OR auth.uid() = player2_id);

-- Game States: only match participants can read/write game states
CREATE POLICY "Participants can read game states" ON game_states
    FOR SELECT USING (
        EXISTS (
            SELECT 1 FROM matches 
            WHERE matches.id = game_states.match_id 
            AND (matches.player1_id = auth.uid() OR matches.player2_id = auth.uid())
        )
    );

CREATE POLICY "Participants can insert game states" ON game_states
    FOR INSERT WITH CHECK (
        EXISTS (
            SELECT 1 FROM matches 
            WHERE matches.id = match_id 
            AND (matches.player1_id = auth.uid() OR matches.player2_id = auth.uid())
        )
    );

CREATE POLICY "Participants can update game states" ON game_states
    FOR UPDATE USING (
        EXISTS (
            SELECT 1 FROM matches 
            WHERE matches.id = game_states.match_id 
            AND (matches.player1_id = auth.uid() OR matches.player2_id = auth.uid())
        )
    );

-- Moves: participants can read and write
CREATE POLICY "Participants can read moves" ON moves
    FOR SELECT USING (
        EXISTS (
            SELECT 1 FROM matches 
            WHERE matches.id = moves.match_id 
            AND (matches.player1_id = auth.uid() OR matches.player2_id = auth.uid())
        )
    );

CREATE POLICY "Participants can insert moves" ON moves
    FOR INSERT WITH CHECK (
        auth.uid() = player_id AND
        EXISTS (
            SELECT 1 FROM matches 
            WHERE matches.id = match_id 
            AND (matches.player1_id = auth.uid() OR matches.player2_id = auth.uid())
        )
    );
