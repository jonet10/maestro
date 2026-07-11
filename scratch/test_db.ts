import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const url = process.env.VITE_SUPABASE_URL || "";
const anonKey = process.env.VITE_SUPABASE_ANON_KEY || "";

const supabase = createClient(url, anonKey);

async function test() {
  const { data, error } = await supabase
    .from("profiles")
    .select("*")
    .limit(1);

  if (error) {
    console.error("Error querying profiles:", error);
  } else {
    console.log("Profiles sample:", data);
  }
}

test();
