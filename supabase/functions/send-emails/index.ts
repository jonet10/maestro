import { serve } from "https://deno.land/std@0.168.0/http/server.ts"
import { createClient } from "https://esm.sh/@supabase/supabase-js@2.39.3"

const corsHeaders = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Headers': 'authorization, x-client-info, apikey, content-type',
}

serve(async (req) => {
  // Handle CORS preflight requests
  if (req.method === 'OPTIONS') {
    return new Response('ok', { headers: corsHeaders })
  }

  try {
    const { subject, htmlContent, targetAudience } = await req.json()

    // Retrieve env vars
    const supabaseUrl = Deno.env.get('SUPABASE_URL')
    const supabaseServiceRoleKey = Deno.env.get('SUPABASE_SERVICE_ROLE_KEY')
    const resendApiKey = Deno.env.get('RESEND_API_KEY')

    if (!supabaseUrl || !supabaseServiceRoleKey || !resendApiKey) {
      throw new Error('Missing environment variables.')
    }

    // Initialize Supabase admin client
    const supabaseAdmin = createClient(supabaseUrl, supabaseServiceRoleKey)

    // Fetch user emails from auth.users (requires service role key)
    // For this example, we mock the retrieval since we don't have direct access to auth.users in standard edge functions without service role
    const { data: users, error: usersError } = await supabaseAdmin.auth.admin.listUsers()

    if (usersError) {
      throw new Error('Failed to fetch users: ' + usersError.message)
    }

    // Determine target emails
    // In a real production environment, you might filter based on `targetAudience` using join with `public.profiles`
    const emails = users.users.map(u => u.email).filter(Boolean) as string[]

    if (emails.length === 0) {
      return new Response(
        JSON.stringify({ message: "No users found.", sentCount: 0 }),
        { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 200 }
      )
    }

    // Send emails via Resend
    const res = await fetch('https://api.resend.com/emails/batch', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${resendApiKey}`
      },
      body: JSON.stringify(
        emails.map(email => ({
          from: 'Maestro Domino <contact@maestro-domino.com>',
          to: [email],
          subject: subject,
          html: htmlContent
        }))
      )
    })

    const resData = await res.json()

    if (!res.ok) {
      throw new Error(`Resend error: ${JSON.stringify(resData)}`)
    }

    return new Response(
      JSON.stringify({ success: true, sentCount: emails.length }),
      { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 200 }
    )
  } catch (error: any) {
    console.error("Error in send-emails edge function:", error)
    return new Response(
      JSON.stringify({ error: error.message }),
      { headers: { ...corsHeaders, 'Content-Type': 'application/json' }, status: 400 }
    )
  }
})
