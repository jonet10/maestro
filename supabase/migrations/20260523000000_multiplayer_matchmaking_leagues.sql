-- Create enums
CREATE TYPE queue_status AS ENUM ('searching', 'matched', 'timeout');
CREATE TYPE queue_match_type AS ENUM ('Liga', 'Kopa', 'LDC', 'Diamond', 'Pro', 'Battle');

ALTER TABLE leagues ADD COLUMN IF NOT EXISTS tier TEXT DEFAULT 'Open';
ALTER TABLE leagues ADD COLUMN IF NOT EXISTS season_id UUID;

-- Create league_players table
CREATE TABLE IF NOT EXISTS league_players (
    league_id UUID REFERENCES leagues(id) ON DELETE CASCADE,
    player_id UUID REFERENCES players(id) ON DELETE CASCADE,
    points INTEGER DEFAULT 0 NOT NULL,
    wins INTEGER DEFAULT 0 NOT NULL,
    losses INTEGER DEFAULT 0 NOT NULL,
    rank INTEGER DEFAULT 0 NOT NULL,
    PRIMARY KEY (league_id, player_id)
);

-- Create matchmaking_queue table
CREATE TABLE IF NOT EXISTS matchmaking_queue (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    player_id UUID REFERENCES players(id) ON DELETE CASCADE NOT NULL,
    elo INTEGER NOT NULL,
    league_id UUID REFERENCES leagues(id) ON DELETE SET NULL,
    division TEXT,
    match_type queue_match_type NOT NULL,
    joined_at TIMESTAMP WITH TIME ZONE DEFAULT timezone('utc'::text, now()) NOT NULL,
    status queue_status DEFAULT 'searching' NOT NULL
);

-- Enable RLS
ALTER TABLE leagues ENABLE ROW LEVEL SECURITY;
ALTER TABLE league_players ENABLE ROW LEVEL SECURITY;
ALTER TABLE matchmaking_queue ENABLE ROW LEVEL SECURITY;

-- RLS Policies for matchmaking_queue
CREATE POLICY IF NOT EXISTS "Players can insert themselves into queue"
    ON matchmaking_queue FOR INSERT
    WITH CHECK (auth.uid() = player_id);

CREATE POLICY IF NOT EXISTS "Players can read their own queue status"
    ON matchmaking_queue FOR SELECT
    USING (auth.uid() = player_id);

CREATE POLICY IF NOT EXISTS "Players can delete themselves from queue (cancel)"
    ON matchmaking_queue FOR DELETE
    USING (auth.uid() = player_id);

CREATE POLICY IF NOT EXISTS "Edge functions can read/write matchmaking queue"
    ON matchmaking_queue FOR ALL
    USING (auth.role() = 'service_role')
    WITH CHECK (auth.role() = 'service_role');
    
-- RLS Policies for leagues and league_players
CREATE POLICY IF NOT EXISTS "Anyone can read leagues"
    ON leagues FOR SELECT
    USING (true);

CREATE POLICY IF NOT EXISTS "Anyone can read league players"
    ON league_players FOR SELECT
    USING (true);

-- Ensure edge functions and service role can write
CREATE POLICY IF NOT EXISTS "Service role can manage leagues"
    ON leagues FOR ALL USING (auth.role() = 'service_role') WITH CHECK (auth.role() = 'service_role');

CREATE POLICY IF NOT EXISTS "Service role can manage league_players"
    ON league_players FOR ALL USING (auth.role() = 'service_role') WITH CHECK (auth.role() = 'service_role');
