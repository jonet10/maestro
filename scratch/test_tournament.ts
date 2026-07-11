import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  // Let's find an upcoming tournament
  const { data: tournaments } = await supabase
    .from("tournaments")
    .select("*")
    .eq("status", "upcoming")
    .limit(1);

  if (!tournaments || tournaments.length === 0) {
    console.log("No upcoming tournament found to test.");
    return;
  }

  const t = tournaments[0];
  console.log(`Found tournament: "${t.name}" (ID: ${t.id}), max_participants: ${t.max_participants}`);

  // Call start_tournament
  const { error } = await supabase.rpc("start_tournament", {
    p_tournament_id: t.id
  });

  if (error) {
    console.log("RPC Error returned:", error.message, "Code:", error.code);
  } else {
    console.log("RPC started successfully.");
  }
}

test();
