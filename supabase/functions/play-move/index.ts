import { serve } from 'https://deno.land/std@0.177.0/http/server.ts';
import { createClient } from 'https://esm.sh/@supabase/supabase-js@2.38.4';
import { dominoEngine } from '../_shared/engine/dominoEngine.ts';
import { EngineAction, EngineGameState } from '../_shared/engine/types.ts';

const corsHeaders = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Headers': 'authorization, x-client-info, apikey, content-type',
};

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
      return new Response(JSON.stringify({ error: 'Unauthorized' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 401 });
    }

    const { matchId, action } = await req.json() as { matchId: string, action: EngineAction };

    if (!matchId || !action) {
      return new Response(JSON.stringify({ error: 'Bad Request' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 400 });
    }

    if (action.playerId !== user.id) {
       return new Response(JSON.stringify({ error: 'Cannot play for another player' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 403 });
    }

    const supabaseAdmin = createClient(
      Deno.env.get('SUPABASE_URL') ?? '',
      Deno.env.get('SUPABASE_SERVICE_ROLE_KEY') ?? ''
    );

    const { data: gameStateRow, error: stateError } = await supabaseAdmin
      .from('game_states')
      .select('*')
      .eq('match_id', matchId)
      .single();

    if (stateError || !gameStateRow) {
      return new Response(JSON.stringify({ error: 'Game not found' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 404 });
    }

    const currentState = gameStateRow as unknown as EngineGameState;

    if (currentState.match_status === 'completed' || currentState.match_status === 'cancelled') {
        return new Response(JSON.stringify({ error: 'Game is already over' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 400 });
    }

    if (currentState.current_turn !== user.id) {
        return new Response(JSON.stringify({ error: 'Not your turn' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 400 });
    }

    const nextState = dominoEngine(currentState, action);

    if (nextState === currentState) {
      return new Response(JSON.stringify({ error: 'Invalid move' }), { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 400 });
    }

    const updatePayload = {
      board_state: nextState.board_state,
      player1_hand: nextState.player1_hand,
      player2_hand: nextState.player2_hand,
      boneyard: nextState.boneyard,
      current_turn: nextState.current_turn,
      round_number: nextState.round_number,
      player1_score: nextState.player1_score,
      player2_score: nextState.player2_score,
      match_status: nextState.match_status,
      game_mode: nextState.game_mode,
      target_score: nextState.target_score,
      last_player_id: nextState.last_player_id,
      last_action_timestamp: nextState.last_action_timestamp,
      consecutive_passes: nextState.consecutive_passes,
      updated_at: new Date().toISOString()
    };

    const { error: updateError } = await supabaseAdmin
      .from('game_states')
      .update(updatePayload)
      .eq('match_id', matchId);

    if (updateError) throw updateError;

    // Update player_hands securely (each player reads only their own hand via RLS)
    await supabaseAdmin.from('player_hands').upsert({
      match_id: matchId,
      player_id: nextState.player1_id,
      hand: nextState.player1_hand,
    }, { onConflict: 'match_id,player_id' });

    await supabaseAdmin.from('player_hands').upsert({
      match_id: matchId,
      player_id: nextState.player2_id,
      hand: nextState.player2_hand,
    }, { onConflict: 'match_id,player_id' });

    if (nextState.match_status === 'completed') {
       let winnerId = null;
       if (nextState.player1_score > nextState.player2_score) winnerId = nextState.player1_id;
       else if (nextState.player2_score > nextState.player1_score) winnerId = nextState.player2_id;

       await supabaseAdmin.from('matches').update({
           match_status: 'completed',
           player1_score: nextState.player1_score,
           player2_score: nextState.player2_score,
           winner_id: winnerId,
           ended_at: new Date().toISOString()
       }).eq('id', matchId);
    }

    return new Response(JSON.stringify({ success: true, state: nextState }), {
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
