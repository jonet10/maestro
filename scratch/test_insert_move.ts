import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  console.log("Attempting insert into moves table...");
  const { data, error } = await supabase
    .from("moves")
    .insert([
      {
        room_id: "508279ae-2b16-48eb-95e0-12ffa6c10e36", // testing with current room
        player_id: "70e0109a-4d3c-41e9-8b00-c79f9553fec2",
        action_type: "START_ROUND",
        payload: {}
      }
    ]);

  if (error) {
    console.error("Insert error:", error);
  } else {
    console.log("Insert success:", data);
  }
}

test();
