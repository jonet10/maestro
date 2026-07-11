import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  // 1. Fetch active rooms
  const { data: activeRooms, error: roomError } = await supabase
    .from("rooms")
    .select("*")
    .eq("status", "active")
    .order("updated_at", { ascending: false });

  if (roomError) {
    console.error("Error fetching rooms:", roomError);
    return;
  }

  if (!activeRooms || activeRooms.length === 0) {
    console.log("No active rooms found.");
    return;
  }

  const room = activeRooms[0];
  console.log(`\n=== ACTIVE ROOM ===`);
  console.log(`ID: ${room.id}`);
  console.log(`Name: ${room.name}`);
  console.log(`Creator ID: ${room.creator_id}`);
  console.log(`Opponent ID: ${room.opponent_id}`);
  console.log(`Game State:`, JSON.stringify(room.game_state, null, 2));

  // 2. Fetch hands for this room
  const { data: hands, error: handsError } = await supabase
    .from("room_hands")
    .select("*")
    .eq("room_id", room.id);

  if (handsError) {
    console.error("Error fetching room_hands:", handsError);
  } else {
    console.log(`\n=== ROOM HANDS (${hands?.length || 0} rows) ===`);
    hands?.forEach(h => {
      console.log(`Player ID: ${h.player_id}`);
      console.log(`Hand:`, JSON.stringify(h.hand));
    });
  }

  // 3. Fetch moves for this room
  const { data: moves, error: movesError } = await supabase
    .from("moves")
    .select("*")
    .eq("room_id", room.id)
    .order("created_at", { ascending: true });

  if (movesError) {
    console.error("Error fetching moves:", movesError);
  } else {
    console.log(`\n=== MOVES COUNT: ${moves?.length || 0} ===`);
    moves?.forEach((m, idx) => {
      console.log(`[Move ${idx + 1}] User: ${m.player_id}, Action: ${m.action_type}, Payload:`, JSON.stringify(m.payload));
    });
  }
}

test();
