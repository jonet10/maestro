-- Add competition_type to tournaments table
ALTER TABLE tournaments ADD COLUMN competition_type TEXT DEFAULT 'liga';

-- Optional: add a check constraint
ALTER TABLE tournaments ADD CONSTRAINT check_competition_type CHECK (competition_type IN ('liga', 'copa', 'ligue_des_champions', 'complet'));
