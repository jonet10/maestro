import { createClient } from "@supabase/supabase-js";
import dotenv from "dotenv";

dotenv.config();

const SUPABASE_URL = process.env.VITE_SUPABASE_URL;
const SUPABASE_ANON_KEY = process.env.VITE_SUPABASE_ANON_KEY;

if (!SUPABASE_URL || !SUPABASE_ANON_KEY) {
  console.error("Missing Supabase credentials in .env");
  process.exit(1);
}

const supabase = createClient(SUPABASE_URL, SUPABASE_ANON_KEY);

async function main() {
  const email = "admin@maestro.com";
  const password = "@#2026Maestro@";

  console.log("Signing up super admin...");
  const { data, error } = await supabase.auth.signUp({
    email,
    password,
    options: {
      data: {
        username: "SuperAdmin"
      }
    }
  });

  if (error) {
    console.error("Error signing up:", error.message);
    if (error.message.includes("User already registered")) {
      console.log("User already exists. Logging in to get ID...");
      const { data: signInData, error: signInError } = await supabase.auth.signInWithPassword({
        email,
        password
      });
      if (signInError) {
        console.error("Could not sign in either:", signInError.message);
        return;
      }
      await updateRole(signInData.user.id);
    }
  } else {
    console.log("Signup success.");
    if (data.user) {
      await updateRole(data.user.id);
    }
  }
}

async function updateRole(userId: string) {
  console.log("Updating profile role to 'super-admin' for user ID:", userId);
  
  // Create profile if not exists
  const { error: insertError } = await supabase.from('profiles').upsert({
    id: userId,
    username: 'SuperAdmin',
    role: 'super-admin',
    elo_rating: 1000,
    games_won: 0,
    games_lost: 0,
    win_rate: 0
  });

  if (insertError) {
    console.error("Error updating profile:", insertError);
  } else {
    console.log("Role successfully set to super-admin!");
  }
}

main();
