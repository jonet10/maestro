import { supabase } from '../utils/supabaseClient';

export interface ChatMessage {
  id: string;
  room_id: string;
  sender_id: string;
  message_text: string;
  is_quick_message: boolean;
  created_at: string;
  sender?: {
    username: string;
    avatar_url: string | null;
  };
}

export const PREDEFINED_QUICK_MESSAGES = [
  "Bien joué !",
  "Oups...",
  "À toi !",
  "Bonne partie !",
  "Dommage !",
  "Wow !"
];

/**
 * Fetch messages for a specific room
 */
export const fetchChatMessages = async (roomId: string): Promise<ChatMessage[]> => {
  const { data, error } = await supabase
    .from('chat_messages')
    .select(`
      id,
      room_id,
      sender_id,
      message_text,
      is_quick_message,
      created_at,
      sender:sender_id (
        username,
        avatar_url
      )
    `)
    .eq('room_id', roomId)
    .order('created_at', { ascending: true });

  if (error) {
    console.error('Error fetching chat messages:', error);
    return [];
  }

  // Transform standard Supabase join into simpler object if needed
  return data.map(msg => ({
    ...msg,
    sender: msg.sender ? {
      username: (msg.sender as any).username,
      avatar_url: (msg.sender as any).avatar_url
    } : undefined
  })) as ChatMessage[];
};

/**
 * Send a chat message
 */
export const sendChatMessage = async (
  roomId: string,
  senderId: string,
  messageText: string,
  isQuickMessage: boolean = false
): Promise<boolean> => {
  const { error } = await supabase
    .from('chat_messages')
    .insert({
      room_id: roomId,
      sender_id: senderId,
      message_text: messageText,
      is_quick_message: isQuickMessage
    });

  if (error) {
    console.error('Error sending message:', error);
    return false;
  }
  
  return true;
};
