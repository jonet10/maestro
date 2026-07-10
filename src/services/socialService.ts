import { supabase } from '../utils/supabaseClient';
import { Profile } from '../types';

export interface Friend {
  id: string;
  username: string;
  avatar_url: string | null;
  status: 'pending' | 'accepted' | 'blocked';
  isIncomingRequest: boolean;
}

export interface Notification {
  id: string;
  type: string;
  payload: any;
  is_read: boolean;
  created_at: string;
}

/**
 * Search users by username
 */
export const searchUsers = async (query: string, currentUserId: string): Promise<Profile[]> => {
  if (!query || query.length < 2) return [];
  
  const { data, error } = await supabase
    .from('profiles')
    .select('*')
    .ilike('username', `%${query}%`)
    .neq('id', currentUserId)
    .limit(5);

  if (error) {
    console.error('Error searching users:', error);
    return [];
  }
  return data as Profile[];
};

/**
 * Fetch a few registered users to suggest as friends
 */
export const fetchSuggestedUsers = async (currentUserId: string, limit = 5): Promise<Profile[]> => {
  // Fetch users excluding current user
  // In a real app, you'd exclude existing friends via an RPC or subquery
  // Here we'll just fetch recent users
  const { data, error } = await supabase
    .from('profiles')
    .select('*')
    .neq('id', currentUserId)
    .order('created_at', { ascending: false })
    .limit(limit);

  if (error) {
    console.error('Error fetching suggested users:', error);
    return [];
  }
  return data as Profile[];
};

/**
 * Fetch all friends and pending requests for the current user.
 */
export const fetchFriends = async (userId: string): Promise<Friend[]> => {
  const { data, error } = await supabase
    .from('friendships')
    .select(`
      user_id1,
      user_id2,
      status,
      action_user_id
    `)
    .or(`user_id1.eq.${userId},user_id2.eq.${userId}`);

  if (error) {
    console.error('Error fetching friends:', error);
    return [];
  }

  // We need to fetch the profiles for the other users
  const friendIds = data.map(f => f.user_id1 === userId ? f.user_id2 : f.user_id1);
  
  if (friendIds.length === 0) return [];

  const { data: profiles, error: profilesError } = await supabase
    .from('profiles')
    .select('id, username, avatar_url')
    .in('id', friendIds);

  if (profilesError) {
    console.error('Error fetching friend profiles:', profilesError);
    return [];
  }

  const profileMap = new Map(profiles.map(p => [p.id, p]));

  return data.map(f => {
    const friendId = f.user_id1 === userId ? f.user_id2 : f.user_id1;
    const profile = profileMap.get(friendId);
    
    return {
      id: friendId,
      username: profile?.username || 'Utilisateur inconnu',
      avatar_url: profile?.avatar_url || null,
      status: f.status as 'pending' | 'accepted' | 'blocked',
      isIncomingRequest: f.status === 'pending' && f.action_user_id !== userId
    };
  });
};

/**
 * Send a friend request.
 */
export const sendFriendRequest = async (currentUserId: string, targetUsername: string): Promise<{ success: boolean; message: string }> => {
  // First find the target user by username
  const { data: targetProfile, error: findError } = await supabase
    .from('profiles')
    .select('id')
    .eq('username', targetUsername)
    .single();

  if (findError || !targetProfile) {
    return { success: false, message: "Utilisateur introuvable." };
  }

  if (targetProfile.id === currentUserId) {
    return { success: false, message: "Vous ne pouvez pas vous ajouter vous-même." };
  }

  const user_id1 = currentUserId < targetProfile.id ? currentUserId : targetProfile.id;
  const user_id2 = currentUserId < targetProfile.id ? targetProfile.id : currentUserId;

  const { error } = await supabase
    .from('friendships')
    .insert({
      user_id1,
      user_id2,
      status: 'pending',
      action_user_id: currentUserId
    });

  if (error) {
    if (error.code === '23505') {
      return { success: false, message: "Une demande existe déjà ou vous êtes déjà amis." };
    }
    return { success: false, message: "Erreur lors de l'envoi de la demande." };
  }
  
  // Create a notification for the target user
  await supabase.from('notifications').insert({
    user_id: targetProfile.id,
    type: 'friend_request',
    payload: { sender_id: currentUserId }
  });

  return { success: true, message: "Demande envoyée !" };
};

/**
 * Respond to a friend request (accept or reject/cancel)
 */
export const respondToFriendRequest = async (currentUserId: string, friendId: string, accept: boolean): Promise<boolean> => {
  const user_id1 = currentUserId < friendId ? currentUserId : friendId;
  const user_id2 = currentUserId < friendId ? friendId : currentUserId;

  if (accept) {
    const { error } = await supabase
      .from('friendships')
      .update({ 
        status: 'accepted', 
        updated_at: new Date().toISOString(),
        action_user_id: currentUserId 
      })
      .eq('user_id1', user_id1)
      .eq('user_id2', user_id2);
      
    if (error) {
      console.error('Error accepting friend request:', error);
      return false;
    }
    
    // Notify the other user
    await supabase.from('notifications').insert({
      user_id: friendId,
      type: 'friend_accept',
      payload: { sender_id: currentUserId }
    });
    
    return true;
  } else {
    // Delete the request
    const { error } = await supabase
      .from('friendships')
      .delete()
      .eq('user_id1', user_id1)
      .eq('user_id2', user_id2);
      
    return !error;
  }
};

/**
 * Remove a friend
 */
export const removeFriend = async (currentUserId: string, friendId: string): Promise<boolean> => {
  const user_id1 = currentUserId < friendId ? currentUserId : friendId;
  const user_id2 = currentUserId < friendId ? friendId : currentUserId;

  const { error } = await supabase
    .from('friendships')
    .delete()
    .eq('user_id1', user_id1)
    .eq('user_id2', user_id2);
    
  return !error;
};

/**
 * Fetch unread notifications
 */
export const fetchNotifications = async (userId: string): Promise<Notification[]> => {
  const { data, error } = await supabase
    .from('notifications')
    .select('*')
    .eq('user_id', userId)
    .eq('is_read', false)
    .order('created_at', { ascending: false });

  if (error) return [];
  return data as Notification[];
};

/**
 * Mark a notification as read
 */
export const markNotificationRead = async (notificationId: string): Promise<boolean> => {
  const { error } = await supabase
    .from('notifications')
    .update({ is_read: true })
    .eq('id', notificationId);
    
  return !error;
};

/**
 * Send a game invitation
 */
export const sendGameInvite = async (senderId: string, receiverId: string, roomId: string): Promise<boolean> => {
  // Create invitation record (optional, useful for history)
  const { error: inviteError } = await supabase
    .from('invitations')
    .insert({
      sender_id: senderId,
      receiver_id: receiverId,
      room_id: roomId,
      status: 'pending',
      expires_at: new Date(Date.now() + 1000 * 60 * 60).toISOString() // 1 hour expiry
    });

  if (inviteError) {
    console.error("Invite error:", inviteError);
    return false;
  }

  // Send real-time notification
  const { error: notifError } = await supabase
    .from('notifications')
    .insert({
      user_id: receiverId,
      type: 'invite',
      payload: { sender_id: senderId, room_id: roomId, message: "Je t'invite à jouer une partie !" }
    });

  return !notifError;
};
