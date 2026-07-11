import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  const roomId = "508279ae-2b16-48eb-95e0-12ffa6c10e36";
  const creatorId = "70e0109a-4d3c-41e9-8b00-c79f9553fec2";

  console.log(`Calling force_start_round for room ${roomId}...`);
  const { data, error } = await supabase.rpc("force_start_round", {
    p_room_id: roomId,
    p_player_id: creatorId
  });

  if (error) {
    console.error("RPC error:", error);
  } else {
    console.log("RPC result:", data);
  }
}

test();
