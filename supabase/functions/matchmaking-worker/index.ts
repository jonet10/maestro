import { serve } from 'https://deno.land/std@0.177.0/http/server.ts';
import { createClient } from 'https://esm.sh/@supabase/supabase-js@2.38.4';
import { initializeGame } from '../_shared/engine/gameInitializer.ts';

const corsHeaders = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Headers': 'authorization, x-client-info, apikey, content-type',
};

type QueueMatchType = 'Liga' | 'Kopa' | 'LDC' | 'Diamond' | 'Pro' | 'Battle';

serve(async (req) => {
  if (req.method === 'OPTIONS') {
    return new Response('ok', { headers: corsHeaders });
  }

  try {
    const supabaseClient = createClient(
      Deno.env.get('SUPABASE_URL') ?? '',
      Deno.env.get('SUPABASE_ANON_KEY') ?? '',
      { global: { headers: { Authorization: req.headers.get('Authorization')! } } }
    );

    const { data: { user }, error: userError } = await supabaseClient.auth.getUser();
    if (userError || !user) {
      return new Response(JSON.stringify({ error: 'Unauthorized' }), {
        headers: { ...corsHeaders, 'Content-Type': 'application/json' },
        status: 401,
      });
    }

    const body = await req.json().catch(() => ({}));
    const matchType = (body?.matchType ?? 'Liga') as QueueMatchType;
    const gameMode = body?.gameMode ?? 'fives';

    const supabaseAdmin = createClient(
      Deno.env.get('SUPABASE_URL') ?? '',
      Deno.env.get('SUPABASE_SERVICE_ROLE_KEY') ?? ''
    );

    const { data: me, error: meError } = await supabaseAdmin
      .from('players')
      .select('id, elo_points')
      .eq('id', user.id)
      .single();
    if (meError || !me) {
      return new Response(JSON.stringify({ error: 'Player profile not found' }), {
        headers: { ...corsHeaders, 'Content-Type': 'application/json' },
        status: 400,
      });
    }

    // Reuse an existing active match if one already exists for this user.
    const { data: existingMatch } = await supabaseAdmin
      .from('matches')
      .select('id, player1_id, player2_id')
      .or(`player1_id.eq.${user.id},player2_id.eq.${user.id}`)
      .in('match_status', ['waiting', 'in_progress'])
      .order('created_at', { ascending: false })
      .limit(1)
      .maybeSingle();

    if (existingMatch) {
      const opponentId = existingMatch.player1_id === user.id ? existingMatch.player2_id : existingMatch.player1_id;
      return new Response(JSON.stringify({
        status: 'matched',
        matchId: existingMatch.id,
        opponentId,
      }), {
        headers: { ...corsHeaders, 'Content-Type': 'application/json' },
      });
    }

    // Ensure the player is present in queue as searching.
    const { data: existingQueue } = await supabaseAdmin
      .from('matchmaking_queue')
      .select('id, status')
      .eq('player_id', user.id)
      .order('joined_at', { ascending: false })
      .limit(1)
      .maybeSingle();

    if (!existingQueue || existingQueue.status !== 'searching') {
      await supabaseAdmin.from('matchmaking_queue').insert({
        player_id: user.id,
        elo: me.elo_points,
        match_type: matchType,
        status: 'searching',
      });
    }

    const { data: myQueueRow } = await supabaseAdmin
      .from('matchmaking_queue')
      .select('id')
      .eq('player_id', user.id)
      .eq('status', 'searching')
      .order('joined_at', { ascending: true })
      .limit(1)
      .maybeSingle();

    if (!myQueueRow) {
      return new Response(JSON.stringify({ status: 'searching' }), {
        headers: { ...corsHeaders, 'Content-Type': 'application/json' },
      });
    }

    // Pick oldest compatible opponent.
    const { data: opponentQueueRow } = await supabaseAdmin
      .from('matchmaking_queue')
      .select('id, player_id')
      .eq('status', 'searching')
      .eq('match_type', matchType)
      .neq('player_id', user.id)
      .order('joined_at', { ascending: true })
      .limit(1)
      .maybeSingle();

    if (!opponentQueueRow) {
      return new Response(JSON.stringify({ status: 'searching' }), {
        headers: { ...corsHeaders, 'Content-Type': 'application/json' },
      });
    }

    const now = new Date().toISOString();
    await supabaseAdmin
      .from('matchmaking_queue')
      .update({ status: 'matched' })
      .in('id', [myQueueRow.id, opponentQueueRow.id]);

    const { data: matchRow, error: matchError } = await supabaseAdmin
      .from('matches')
      .insert({
        player1_id: user.id,
        player2_id: opponentQueueRow.player_id,
        match_status: 'in_progress',
        match_type: 'ranked',
        started_at: now,
      })
      .select('id')
      .single();

    if (matchError || !matchRow) {
      throw matchError ?? new Error('Failed to create match');
    }

    const initialState = initializeGame(matchRow.id, user.id, opponentQueueRow.player_id, undefined, gameMode);

    const { error: gameStateError } = await supabaseAdmin.from('game_states').insert({
      match_id: matchRow.id,
      board_state: initialState.board_state,
      player1_id: initialState.player1_id,
      player2_id: initialState.player2_id,
      player1_hand: initialState.player1_hand,
      player2_hand: initialState.player2_hand,
      boneyard: initialState.boneyard,
      current_turn: initialState.current_turn,
      round_number: initialState.round_number,
      player1_score: initialState.player1_score,
      player2_score: initialState.player2_score,
      match_status: initialState.match_status,
      last_action_timestamp: initialState.last_action_timestamp,
      consecutive_passes: initialState.consecutive_passes,
      updated_at: now,
      game_mode: initialState.game_mode,
      target_score: initialState.target_score,
      last_player_id: initialState.last_player_id,
    });
    if (gameStateError) throw gameStateError;

    return new Response(JSON.stringify({
      status: 'matched',
      matchId: matchRow.id,
      opponentId: opponentQueueRow.player_id,
    }), {
      headers: { ...corsHeaders, 'Content-Type': 'application/json' },
    });
  } catch (err: any) {
    console.error(err);
    return new Response(JSON.stringify({ error: err.message }), {
      headers: { ...corsHeaders, 'Content-Type': 'application/json' },
      status: 500,
    });
  }
});
