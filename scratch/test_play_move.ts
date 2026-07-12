import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  const roomId = "508279ae-2b16-48eb-95e0-12ffa6c10e36";
  const creatorId = "70e0109a-4d3c-41e9-8b00-c79f9553fec2";

  // 1. Fetch hand of creator
  const { data: handRow } = await supabase
    .from("room_hands")
    .select("hand")
    .eq("room_id", roomId)
    .eq("player_id", creatorId)
    .single();

  if (!handRow || !handRow.hand || handRow.hand.length === 0) {
    console.log("No tiles in hand or room_hands not found.");
    return;
  }

  const hand = handRow.hand;
  const tileToPlay = hand[0];
  console.log(`Creator hand:`, JSON.stringify(hand));
  console.log(`Attempting to play tile:`, JSON.stringify(tileToPlay));

  // 2. Insert PLAY_TILE move
  const { data, error } = await supabase
    .from("moves")
    .insert([
      {
        room_id: roomId,
        player_id: creatorId,
        action_type: "PLAY_TILE",
        payload: {
          tile: tileToPlay,
          side: "start"
        }
      }
    ]);

  if (error) {
    console.error("Insert error:", error);
  } else {
    console.log("Insert success:", data);
  }
}

test();
