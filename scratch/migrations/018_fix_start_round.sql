-- Fix START_ROUND trigger jsonb concatenation bug

CREATE OR REPLACE FUNCTION public.handle_move_insert()
RETURNS TRIGGER AS $$
DECLARE
  r_row public.rooms%ROWTYPE;
  p_hand_row public.room_hands%ROWTYPE;
  o_hand_row public.room_hands%ROWTYPE;
  p_id UUID := NEW.player_id;
  o_id UUID;
  g_state JSONB;
  placed_tiles JSONB;
  open_ends JSONB;
  boneyard JSONB;
  p_hand JSONB;
  o_hand JSONB;
  p_hand_len INT;
  o_hand_len INT;
  b_count INT;
  new_placed_tile JSONB;
  action_type TEXT := NEW.action_type;
  payload JSONB := NEW.payload;
  tile JSONB;
  side TEXT;
  rotation JSONB;
  sum_ends INT;
  points INT := 0;
  cur_player UUID;
  round_winner_id UUID;
  round_score INT := 0;
  reveal_phase TEXT := 'none';
  reveal_data JSONB := NULL;
  next_round_starter UUID;
  target_score INT;
  creator_score INT;
  opponent_score INT;
  deck JSONB;
  idx INT;
  drawn_tile JSONB;
  i INT;
  p_can_play BOOLEAN;
  o_can_play BOOLEAN;
  p_pips INT;
  o_pips INT;
  tie_explain TEXT := '';
  next_turn UUID;
BEGIN
  -- Permettre la mutation de room via le trigger système
  PERFORM set_config('app.game_mutation_authorized', 'true', true);

  -- 1. Verrouiller la room pour éviter les spams de clics
  SELECT * INTO r_row FROM public.rooms WHERE id = NEW.room_id FOR UPDATE;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Salon introuvable.';
  END IF;

  target_score := r_row.target_score;
  IF p_id = r_row.creator_id THEN
    o_id := r_row.opponent_id;
  ELSE
    o_id := r_row.creator_id;
  END IF;

  -- 2. Démarrage de manche
  IF action_type = 'START_ROUND' THEN
    IF r_row.status = 'finished' THEN
      RAISE EXCEPTION 'La partie est terminée.';
    END IF;
    IF p_id <> r_row.creator_id THEN
      RAISE EXCEPTION 'Seul le créateur peut démarrer la manche.';
    END IF;
    IF r_row.opponent_id IS NULL THEN
      RAISE EXCEPTION 'Impossible de démarrer sans adversaire.';
    END IF;

    deck := public.generate_shuffled_deck();

    p_hand := '[]'::jsonb;
    o_hand := '[]'::jsonb;
    boneyard := '[]'::jsonb;

    FOR i IN 0..6 LOOP
      p_hand := p_hand || jsonb_build_array(deck->i);
      o_hand := o_hand || jsonb_build_array(deck->(i+7));
    END LOOP;

    FOR i IN 14..27 LOOP
      boneyard := boneyard || jsonb_build_array(deck->i);
    END LOOP;

    next_round_starter := (r_row.game_state->>'nextRoundStarter')::uuid;
    IF next_round_starter IS NULL THEN
      cur_player := public.determine_starting_player(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
    ELSE
      cur_player := next_round_starter;
    END IF;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.creator_id, p_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = EXCLUDED.hand;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.opponent_id, o_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = EXCLUDED.hand;

    INSERT INTO public.room_boneyard (room_id, tiles)
    VALUES (NEW.room_id, boneyard)
    ON CONFLICT (room_id) DO UPDATE SET tiles = EXCLUDED.tiles;

    g_state := jsonb_build_object(
      'placedTiles', '[]'::jsonb,
      'boneyard_count', 14,
      'currentPlayer', cur_player,
      'score_creator', COALESCE((r_row.game_state->>'score_creator')::int, 0),
      'score_opponent', COALESCE((r_row.game_state->>'score_opponent')::int, 0),
      'round', COALESCE((r_row.game_state->>'round')::int, 0) + 1,
      'matchStatus', 'ongoing',
      'revealPhase', 'none',
      'revealData', NULL,
      'nextRoundStarter', NULL
    );

    UPDATE public.rooms
    SET status = 'active', game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;

    RETURN NEW;
  END IF;

  -- 3. Vérification de statut actif pour les autres coups
  IF r_row.status <> 'active' THEN
    RAISE EXCEPTION 'Le salon est inactif.';
  END IF;

  g_state := r_row.game_state;
  cur_player := (g_state->>'currentPlayer')::uuid;
  placed_tiles := g_state->'placedTiles';
  b_count := (g_state->>'boneyard_count')::int;
  creator_score := COALESCE((g_state->>'score_creator')::int, 0);
  opponent_score := COALESCE((g_state->>'score_opponent')::int, 0);

  IF p_id <> cur_player THEN
    RAISE EXCEPTION 'Ce n''est pas votre tour.';
  END IF;

  SELECT * INTO p_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = p_id FOR UPDATE;
  SELECT * INTO o_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = o_id FOR UPDATE;
  
  p_hand := p_hand_row.hand;
  o_hand := o_hand_row.hand;
  p_hand_len := jsonb_array_length(p_hand);
  o_hand_len := jsonb_array_length(o_hand);

  -- 4. PLAY_TILE
  IF action_type = 'PLAY_TILE' THEN
    tile := payload->'tile';
    side := payload->>'side';
    
    IF tile IS NULL OR side IS NULL THEN
      RAISE EXCEPTION 'Tuile ou côté manquant.';
    END IF;

    IF NOT public.player_has_tile(p_hand, tile) THEN
      RAISE EXCEPTION 'Vous ne possédez pas cette tuile.';
    END IF;

    open_ends := public.get_open_ends(placed_tiles);
    IF NOT public.is_valid_play(tile, side, open_ends) AND jsonb_array_length(placed_tiles) > 0 THEN
      RAISE EXCEPTION 'Coup invalide.';
    END IF;

    rotation := public.calculate_tile_rotation(tile, side, placed_tiles);
    
    new_placed_tile := jsonb_build_object(
      'tile', tile,
      'playedBy', p_id,
      'side', side,
      'rotation', rotation
    );

    IF jsonb_array_length(placed_tiles) = 0 THEN
      placed_tiles := jsonb_build_array(new_placed_tile);
    ELSE
      IF side IN ('left', 'top') THEN
        placed_tiles := new_placed_tile || placed_tiles;
      ELSE
        placed_tiles := placed_tiles || new_placed_tile;
      END IF;
    END IF;

    p_hand := public.remove_tile_from_hand(p_hand, tile);
    p_hand_len := p_hand_len - 1;

    sum_ends := public.calculate_board_score(placed_tiles);
    IF sum_ends % 5 = 0 THEN
      points := sum_ends;
    END IF;

    IF p_id = r_row.creator_id THEN
      creator_score := creator_score + points;
    ELSE
      opponent_score := opponent_score + points;
    END IF;

    -- Victoire ?
    IF p_hand_len = 0 THEN
      round_winner_id := p_id;
      reveal_phase := 'score';
      round_score := public.round_to_nearest_five(public.calculate_remaining_pips(o_hand));
      
      IF p_id = r_row.creator_id THEN
        creator_score := creator_score + round_score;
      ELSE
        opponent_score := opponent_score + round_score;
      END IF;

      reveal_data := jsonb_build_object(
        'winner_id', p_id,
        'reason', 'domino',
        'points_gained', round_score,
        'creator_hand', p_hand,
        'opponent_hand', o_hand
      );
    ELSE
      -- Blocage ?
      p_can_play := public.can_play(p_hand, public.get_open_ends(placed_tiles));
      o_can_play := public.can_play(o_hand, public.get_open_ends(placed_tiles));
      
      IF b_count = 0 AND NOT p_can_play AND NOT o_can_play THEN
        reveal_phase := 'score';
        p_pips := public.calculate_remaining_pips(p_hand);
        o_pips := public.calculate_remaining_pips(o_hand);
        
        IF p_pips < o_pips THEN
          round_winner_id := r_row.creator_id;
          round_score := public.round_to_nearest_five(o_pips);
          creator_score := creator_score + round_score;
          tie_explain := '';
        ELSIF o_pips < p_pips THEN
          round_winner_id := r_row.opponent_id;
          round_score := public.round_to_nearest_five(p_pips);
          opponent_score := opponent_score + round_score;
          tie_explain := '';
        ELSE
          round_winner_id := public.determine_tiebreaker_winner(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
          IF round_winner_id = r_row.creator_id THEN
            round_score := public.round_to_nearest_five(o_pips);
            creator_score := creator_score + round_score;
          ELSE
            round_score := public.round_to_nearest_five(p_pips);
            opponent_score := opponent_score + round_score;
          END IF;
          tie_explain := 'Égalité de points ! Le joueur avec le domino le plus fort l''emporte.';
        END IF;

        reveal_data := jsonb_build_object(
          'winner_id', round_winner_id,
          'reason', 'blocked',
          'points_gained', round_score,
          'creator_hand', p_hand,
          'opponent_hand', o_hand,
          'tieBreakExplained', tie_explain
        );
      END IF;
    END IF;

    IF reveal_phase = 'none' THEN
      cur_player := o_id;
    END IF;

  -- 5. DRAW_TILE
  ELSIF action_type = 'DRAW_TILE' THEN
    IF b_count = 0 THEN
      RAISE EXCEPTION 'Pioche vide.';
    END IF;
    IF public.can_play(p_hand, public.get_open_ends(placed_tiles)) THEN
      RAISE EXCEPTION 'Vous pouvez jouer, vous ne pouvez pas piocher.';
    END IF;

    SELECT tiles INTO boneyard FROM public.room_boneyard WHERE room_id = NEW.room_id FOR UPDATE;
    idx := floor(random() * jsonb_array_length(boneyard))::int;
    drawn_tile := boneyard->idx;
    boneyard := boneyard - idx;
    b_count := b_count - 1;

    p_hand := p_hand || jsonb_build_array(drawn_tile);
    p_hand_len := p_hand_len + 1;

    UPDATE public.room_boneyard SET tiles = boneyard WHERE room_id = NEW.room_id;

    NEW.payload := jsonb_build_object('drawn_tile', drawn_tile);

    -- Si le joueur ne peut toujours pas jouer et la pioche n'est pas vide, c'est encore à lui de piocher.
    -- S'il ne peut pas jouer et pioche vide, il passera au prochain coup.
    -- S'il peut jouer, c'est toujours à son tour.
    -- Donc le tour ne change pas après une pioche simple.

  -- 6. PASS
  ELSIF action_type = 'PASS' THEN
    IF public.can_play(p_hand, public.get_open_ends(placed_tiles)) THEN
      RAISE EXCEPTION 'Vous avez une tuile jouable.';
    END IF;
    IF b_count > 0 THEN
      RAISE EXCEPTION 'Vous devez piocher.';
    END IF;

    o_can_play := public.can_play(o_hand, public.get_open_ends(placed_tiles));
    IF NOT o_can_play THEN
      -- Blocage total
      reveal_phase := 'score';
      p_pips := public.calculate_remaining_pips(p_hand);
      o_pips := public.calculate_remaining_pips(o_hand);
      
      IF p_pips < o_pips THEN
        round_winner_id := r_row.creator_id;
        round_score := public.round_to_nearest_five(o_pips);
        creator_score := creator_score + round_score;
      ELSIF o_pips < p_pips THEN
        round_winner_id := r_row.opponent_id;
        round_score := public.round_to_nearest_five(p_pips);
        opponent_score := opponent_score + round_score;
      ELSE
        round_winner_id := public.determine_tiebreaker_winner(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
        IF round_winner_id = r_row.creator_id THEN
          round_score := public.round_to_nearest_five(o_pips);
          creator_score := creator_score + round_score;
        ELSE
          round_score := public.round_to_nearest_five(p_pips);
          opponent_score := opponent_score + round_score;
        END IF;
        tie_explain := 'Égalité de points ! Le joueur avec le domino le plus fort l''emporte.';
      END IF;

      reveal_data := jsonb_build_object(
        'winner_id', round_winner_id,
        'reason', 'blocked',
        'points_gained', round_score,
        'creator_hand', p_hand,
        'opponent_hand', o_hand,
        'tieBreakExplained', tie_explain
      );
    ELSE
      cur_player := o_id;
    END IF;

  ELSE
    RAISE EXCEPTION 'Action non reconnue.';
  END IF;

  -- 7. Sauvegarde et Fin
  UPDATE public.room_hands SET hand = p_hand WHERE room_id = NEW.room_id AND player_id = p_id;
  UPDATE public.room_hands SET hand = o_hand WHERE room_id = NEW.room_id AND player_id = o_id;

  g_state := jsonb_build_object(
    'placedTiles', placed_tiles,
    'boneyard_count', b_count,
    'currentPlayer', cur_player,
    'score_creator', creator_score,
    'score_opponent', opponent_score,
    'round', COALESCE((r_row.game_state->>'round')::int, 1),
    'matchStatus', r_row.game_state->>'matchStatus',
    'revealPhase', reveal_phase,
    'revealData', reveal_data,
    'nextRoundStarter', (r_row.game_state->>'nextRoundStarter')
  );

  IF reveal_phase = 'score' THEN
    IF creator_score >= target_score OR opponent_score >= target_score THEN
      g_state := g_state || jsonb_build_object('matchStatus', 'finished');
      UPDATE public.rooms
      SET status = 'finished',
          game_state = g_state,
          winner_id = CASE WHEN creator_score >= target_score THEN r_row.creator_id ELSE r_row.opponent_id END,
          updated_at = NOW()
      WHERE id = NEW.room_id;
    ELSE
      g_state := g_state || jsonb_build_object(
        'nextRoundStarter', CASE WHEN round_winner_id = r_row.creator_id THEN r_row.opponent_id ELSE r_row.creator_id END
      );
      UPDATE public.rooms
      SET game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;
    END IF;

    INSERT INTO public.room_events (room_id, player_id, event_type)
    VALUES (NEW.room_id, p_id, 'ROUND_BLOCKED');
  ELSE
    g_state := g_state || jsonb_build_object(
      'currentPlayer', cur_player
    );

    UPDATE public.rooms
    SET game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;
