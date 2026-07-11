import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  console.log("Checking tables via REST API requests...");
  
  const tables = ["profiles", "rooms", "room_hands", "moves", "tournaments", "notifications"];
  
  for (const table of tables) {
    const { data, error } = await supabase
      .from(table)
      .select("*")
      .limit(1);

    if (error) {
      console.log(`Table "${table}": Error - ${error.code} (${error.message})`);
    } else {
      console.log(`Table "${table}": Success! Found ${data.length} rows.`);
    }
  }
}

test();
