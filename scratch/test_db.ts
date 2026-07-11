import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  const { data, error } = await supabase.rpc("get_policies", {}); // wait, RPC get_policies might not exist, so let's try reading pg_policies via standard select if exposed, or let's try a write to system_settings to see the error details
  
  // Let's test a write to system_settings
  const { data: updateData, error: updateError } = await supabase
    .from("system_settings")
    .upsert({ key: "gameplay_config", value: { test: true } });

  console.log("Upsert result:", updateData, "Error:", updateError);
}

test();
