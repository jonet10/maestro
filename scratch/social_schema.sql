-- ========================================================
-- MAESTRO DOMINO : SOCIAL PLATFORM MIGRATION SCRIPT
-- ========================================================

-- 1. EXTENSIONS
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 2. UPDATE PROFILES TABLE
ALTER TABLE public.profiles 
ADD COLUMN IF NOT EXISTS onboarding_completed BOOLEAN DEFAULT FALSE,
ADD COLUMN IF NOT EXISTS availability JSONB DEFAULT '{}'::jsonb,
ADD COLUMN IF NOT EXISTS elo_rating INT DEFAULT 1200,
ADD COLUMN IF NOT EXISTS league_id UUID;

-- 3. CREATE NEW TABLES

-- Friendships (Drop first to avoid old schema conflicts)
DROP TABLE IF EXISTS public.friendships CASCADE;
CREATE TABLE public.friendships (
    user_id1 UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
    user_id2 UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
    status TEXT NOT NULL DEFAULT 'pending', -- 'pending', 'accepted', 'blocked'
    action_user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
    PRIMARY KEY (user_id1, user_id2),
    CONSTRAINT check_status CHECK (status IN ('pending', 'accepted', 'blocked'))
);
-- Ensure user_id1 is always the smaller UUID to prevent duplicates like (A,B) and (B,A)
ALTER TABLE public.friendships ADD CONSTRAINT enforce_user_id_order CHECK (user_id1 < user_id2);

-- Invitations
DROP TABLE IF EXISTS public.invitations CASCADE;
CREATE TABLE public.invitations (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    sender_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    receiver_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE, -- NULL means public link
    room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE,
    status TEXT NOT NULL DEFAULT 'pending', -- 'pending', 'accepted', 'expired'
    expires_at TIMESTAMP WITH TIME ZONE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
    CONSTRAINT check_invite_status CHECK (status IN ('pending', 'accepted', 'expired'))
);

-- Chat Messages
DROP TABLE IF EXISTS public.chat_messages CASCADE;
CREATE TABLE public.chat_messages (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE,
    sender_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    message_text TEXT NOT NULL,
    is_quick_message BOOLEAN DEFAULT FALSE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- Advanced Match History (v2)
DROP TABLE IF EXISTS public.match_history_v2 CASCADE;
CREATE TABLE public.match_history_v2 (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    room_id UUID REFERENCES public.rooms(id) ON DELETE SET NULL,
    player1_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    player2_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
    winner_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
    score_p1 INT DEFAULT 0,
    score_p2 INT DEFAULT 0,
    duration_seconds INT,
    game_mode TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- Notifications (Drop first to avoid column mismatch with old schema)
DROP TABLE IF EXISTS public.notifications CASCADE;
CREATE TABLE public.notifications (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    type TEXT NOT NULL, -- 'friend_request', 'invite', 'system'
    payload JSONB DEFAULT '{}'::jsonb NOT NULL,
    is_read BOOLEAN DEFAULT FALSE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- Ranking History
CREATE TABLE IF NOT EXISTS public.ranking_history (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
    match_id UUID REFERENCES public.match_history_v2(id) ON DELETE SET NULL,
    elo_change INT NOT NULL,
    new_elo INT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- 4. ROW LEVEL SECURITY (RLS)
ALTER TABLE public.friendships ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.invitations ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.chat_messages ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.match_history_v2 ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.notifications ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.ranking_history ENABLE ROW LEVEL SECURITY;

-- Friendships Policies (Users can see friendships where they are either user_id1 or user_id2)
CREATE POLICY "Users can view their own friendships" ON public.friendships 
FOR SELECT USING (auth.uid() = user_id1 OR auth.uid() = user_id2);

CREATE POLICY "Users can insert their own friendships" ON public.friendships 
FOR INSERT WITH CHECK (auth.uid() = action_user_id AND (auth.uid() = user_id1 OR auth.uid() = user_id2));

CREATE POLICY "Users can update their own friendships" ON public.friendships 
FOR UPDATE USING (auth.uid() = user_id1 OR auth.uid() = user_id2) 
WITH CHECK (auth.uid() = action_user_id);

CREATE POLICY "Users can delete their own friendships" ON public.friendships 
FOR DELETE USING (auth.uid() = user_id1 OR auth.uid() = user_id2);

-- Invitations Policies
CREATE POLICY "Users can view invites they sent or received" ON public.invitations 
FOR SELECT USING (auth.uid() = sender_id OR auth.uid() = receiver_id OR receiver_id IS NULL);

CREATE POLICY "Users can create invites" ON public.invitations 
FOR INSERT WITH CHECK (auth.uid() = sender_id);

CREATE POLICY "Users can update their own invites" ON public.invitations 
FOR UPDATE USING (auth.uid() = sender_id OR auth.uid() = receiver_id);

-- Chat Messages Policies (Only visible to users in the same room)
CREATE POLICY "Users can view messages in their rooms" ON public.chat_messages 
FOR SELECT USING (
  EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id AND (r.creator_id = auth.uid() OR r.opponent_id = auth.uid())
  )
);

CREATE POLICY "Users can send messages in their rooms" ON public.chat_messages 
FOR INSERT WITH CHECK (
  auth.uid() = sender_id AND 
  EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id AND (r.creator_id = auth.uid() OR r.opponent_id = auth.uid())
  )
);

-- Match History v2 Policies
CREATE POLICY "Anyone can view match history" ON public.match_history_v2 
FOR SELECT USING (true);
CREATE POLICY "System can insert match history" ON public.match_history_v2 
FOR INSERT WITH CHECK (true); -- Should be restricted to triggers/system ideally, but left open for now

-- Notifications Policies
CREATE POLICY "Users can view their own notifications" ON public.notifications 
FOR SELECT USING (auth.uid() = user_id);

CREATE POLICY "Anyone can create notifications (for invites/friends)" ON public.notifications 
FOR INSERT WITH CHECK (true);

CREATE POLICY "Users can update their own notifications (mark read)" ON public.notifications 
FOR UPDATE USING (auth.uid() = user_id);

-- Ranking History Policies
CREATE POLICY "Anyone can view ranking history" ON public.ranking_history 
FOR SELECT USING (true);

-- ========================================================
-- 5. AUTOMATION (TRIGGERS)
-- ========================================================

-- Trigger to record finished matches into match_history_v2 and update ELO
CREATE OR REPLACE FUNCTION public.handle_room_finish()
RETURNS TRIGGER AS $$
DECLARE
    elo_change_p1 INT := 0;
    elo_change_p2 INT := 0;
    p1_elo INT;
    p2_elo INT;
    new_match_id UUID;
    p1_score INT;
    p2_score INT;
BEGIN
    IF NEW.status = 'finished' AND OLD.status != 'finished' THEN
        -- Get current scores from game_state
        p1_score := (NEW.game_state->>'score_creator')::INT;
        p2_score := (NEW.game_state->>'score_opponent')::INT;
        
        -- Insert into match_history_v2
        INSERT INTO public.match_history_v2 (room_id, player1_id, player2_id, winner_id, score_p1, score_p2, game_mode)
        VALUES (NEW.id, NEW.creator_id, NEW.opponent_id, NEW.winner_id, p1_score, p2_score, NEW.game_state->>'mode')
        RETURNING id INTO new_match_id;

        -- Very Basic Elo calculation (Assume K=32, simple win/loss for now)
        IF NEW.opponent_id IS NOT NULL THEN
            SELECT elo_rating INTO p1_elo FROM public.profiles WHERE id = NEW.creator_id;
            SELECT elo_rating INTO p2_elo FROM public.profiles WHERE id = NEW.opponent_id;
            
            -- Simplified Elo Logic (Can be expanded later)
            IF NEW.winner_id = NEW.creator_id THEN
                elo_change_p1 := 16;
                elo_change_p2 := -16;
            ELSIF NEW.winner_id = NEW.opponent_id THEN
                elo_change_p1 := -16;
                elo_change_p2 := 16;
            END IF;

            IF elo_change_p1 != 0 THEN
                UPDATE public.profiles SET elo_rating = elo_rating + elo_change_p1, games_played = games_played + 1 WHERE id = NEW.creator_id;
                UPDATE public.profiles SET elo_rating = elo_rating + elo_change_p2, games_played = games_played + 1 WHERE id = NEW.opponent_id;
                
                INSERT INTO public.ranking_history (player_id, match_id, elo_change, new_elo)
                VALUES (NEW.creator_id, new_match_id, elo_change_p1, p1_elo + elo_change_p1),
                       (NEW.opponent_id, new_match_id, elo_change_p2, p2_elo + elo_change_p2);
            END IF;
        END IF;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

DROP TRIGGER IF EXISTS on_room_finish ON public.rooms;
CREATE TRIGGER on_room_finish
  AFTER UPDATE ON public.rooms
  FOR EACH ROW EXECUTE FUNCTION public.handle_room_finish();
 
NOTIFY pgrst, 'reload schema';

