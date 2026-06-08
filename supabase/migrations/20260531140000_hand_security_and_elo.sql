-- Migration: Hand security + match history + ELO updates
-- 1. Separate player_hands table so opponent cannot see your hand
-- 2. Add match_history tracking
-- 3. Add ELO update function integration

-- 1. Player hands (each player sees only their own hand)
CREATE TABLE player_hands (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    match_id UUID REFERENCES matches(id) ON DELETE CASCADE NOT NULL,
    player_id UUID REFERENCES players(id) ON DELETE CASCADE NOT NULL,
    hand JSONB DEFAULT '[]'::jsonb,
    created_at TIMESTAMPTZ DEFAULT NOW(),
    updated_at TIMESTAMPTZ DEFAULT NOW(),
    UNIQUE(match_id, player_id)
);

ALTER TABLE player_hands ENABLE ROW LEVEL SECURITY;

-- Each player can only read their own hand
CREATE POLICY "Player can read own hand" ON player_hands
    FOR SELECT USING (auth.uid() = player_id);

-- Edge function with service_role can insert/update (no RLS bypass needed for service_role)
CREATE POLICY "System can manage hands" ON player_hands
    FOR ALL USING (auth.role() = 'service_role');

CREATE INDEX idx_player_hands_match ON player_hands(match_id);
CREATE INDEX idx_player_hands_player ON player_hands(player_id);

-- 2. Enable RLS on players INSERT (users can create their own profile)
CREATE POLICY "Users can insert own profile" ON players
    FOR INSERT WITH CHECK (auth.uid() = id);

-- 3. Allow INSERT on leagues for authenticated users
CREATE POLICY "Authenticated users can view leagues" ON leagues
    FOR SELECT USING (true);

CREATE POLICY "Authenticated users can join leagues" ON league_members
    FOR INSERT WITH CHECK (auth.role() = 'authenticated');

-- 4. Notifications table for future use
CREATE TABLE notifications (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    player_id UUID REFERENCES players(id) ON DELETE CASCADE NOT NULL,
    title TEXT NOT NULL,
    body TEXT,
    type VARCHAR(50) DEFAULT 'info',
    read BOOLEAN DEFAULT false,
    metadata JSONB DEFAULT '{}'::jsonb,
    created_at TIMESTAMPTZ DEFAULT NOW()
);

ALTER TABLE notifications ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Player can read own notifications" ON notifications
    FOR SELECT USING (auth.uid() = player_id);

CREATE POLICY "Player can update own notifications" ON notifications
    FOR UPDATE USING (auth.uid() = player_id);

CREATE INDEX idx_notifications_player ON notifications(player_id, read, created_at DESC);

-- 5. Function to update ELO after match completion
CREATE OR REPLACE FUNCTION update_match_elo()
RETURNS TRIGGER AS $$
DECLARE
    winner_elo int;
    loser_elo int;
    new_winner_elo int;
    new_loser_elo int;
BEGIN
    IF NEW.match_status = 'completed' AND OLD.match_status != 'completed' AND NEW.winner_id IS NOT NULL THEN
        -- Get current ELOs
        SELECT elo_points INTO winner_elo FROM players WHERE id = NEW.winner_id;
        
        IF NEW.winner_id = NEW.player1_id THEN
            SELECT elo_points INTO loser_elo FROM players WHERE id = NEW.player2_id;
        ELSE
            SELECT elo_points INTO loser_elo FROM players WHERE id = NEW.player1_id;
        END IF;

        -- Calculate new ELOs
        SELECT new_winner_elo, new_loser_elo INTO new_winner_elo, new_loser_elo
        FROM update_elo(winner_elo, loser_elo);

        -- Update winner
        UPDATE players SET 
            elo_points = new_winner_elo,
            wins = wins + 1,
            total_matches = total_matches + 1
        WHERE id = NEW.winner_id;

        -- Update loser
        IF NEW.winner_id = NEW.player1_id THEN
            UPDATE players SET 
                elo_points = new_loser_elo,
                losses = losses + 1,
                total_matches = total_matches + 1
            WHERE id = NEW.player2_id;
        ELSE
            UPDATE players SET 
                elo_points = new_loser_elo,
                losses = losses + 1,
                total_matches = total_matches + 1
            WHERE id = NEW.player1_id;
        END IF;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

CREATE TRIGGER trigger_update_match_elo
    AFTER UPDATE OF match_status ON matches
    FOR EACH ROW
    WHEN (NEW.match_status = 'completed' AND OLD.match_status != 'completed')
    EXECUTE FUNCTION update_match_elo();

-- 6. Updated player_hands trigger for updated_at
CREATE TRIGGER update_player_hands_updated_at
    BEFORE UPDATE ON player_hands
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at();
