import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import { Users, UserPlus, UserX, Check, X, Clock, Gamepad2 } from 'lucide-react';
import { Profile } from '../types';
import { Friend, fetchFriends, sendFriendRequest, respondToFriendRequest, removeFriend, searchUsers, fetchSuggestedUsers, sendGameInvite } from '../services/socialService';
import { supabase } from '../utils/supabaseClient';

interface FriendsListProps {
  currentUser: Profile;
  onNavigateToGame?: (roomId: string) => void;
}

export const FriendsList: React.FC<FriendsListProps> = ({ currentUser, onNavigateToGame }) => {
  const [friends, setFriends] = useState<Friend[]>([]);
  const [suggestedUsers, setSuggestedUsers] = useState<Profile[]>([]);
  const [searchUsername, setSearchUsername] = useState('');
  const [searchResults, setSearchResults] = useState<Profile[]>([]);
  const [isSearching, setIsSearching] = useState(false);
  const [loading, setLoading] = useState(true);
  const [feedback, setFeedback] = useState<{ message: string; type: 'success' | 'error' } | null>(null);
  const mountedRef = useRef(true);

  useEffect(() => {
    mountedRef.current = true;
    return () => {
      mountedRef.current = false;
    };
  }, []);

  const loadFriends = async () => {
    setLoading(true);
    const [data, suggestions] = await Promise.all([
      fetchFriends(currentUser.id),
      fetchSuggestedUsers(currentUser.id, 5)
    ]);
    if (!mountedRef.current) return;
    setFriends(data);
    setSuggestedUsers(suggestions.filter(s => !data.some(f => f.id === s.id)));
    setLoading(false);
  };

  useEffect(() => {
    loadFriends();
  }, [currentUser.id]);

  useEffect(() => {
    let isCurrent = true;
    const delayDebounceFn = setTimeout(async () => {
      if (searchUsername.length >= 2) {
        setIsSearching(true);
        const results = await searchUsers(searchUsername, currentUser.id);
        if (!isCurrent || !mountedRef.current) return;
        setSearchResults(results);
        setIsSearching(false);
      } else {
        setSearchResults([]);
      }
    }, 400);

    return () => {
      isCurrent = false;
      clearTimeout(delayDebounceFn);
    };
  }, [searchUsername, currentUser.id]);

  const handleSendRequest = async (targetUsername: string) => {
    const result = await sendFriendRequest(currentUser.id, targetUsername);
    if (!mountedRef.current) return;
    if (result.success) {
      setFeedback({ message: result.message, type: 'success' });
      loadFriends();
    } else {
      setFeedback({ message: result.message, type: 'error' });
    }
    setTimeout(() => {
      if (mountedRef.current) setFeedback(null);
    }, 3000);
  };

  const handleAddFriend = async (e?: React.FormEvent, targetUsername?: string) => {
    if (e) e.preventDefault();
    const usernameToAdd = targetUsername || searchUsername.trim();
    if (!usernameToAdd) return;
    setSearchResults([]);
    setSearchUsername('');
    await handleSendRequest(usernameToAdd);
  };

  const handleRespond = async (friendId: string, accept: boolean) => {
    const success = await respondToFriendRequest(currentUser.id, friendId, accept);
    if (!mountedRef.current) return;
    if (success) {
      loadFriends();
    }
  };

  const handleRemove = async (friendId: string) => {
    if (window.confirm("Voulez-vous vraiment retirer cet ami ?")) {
      const success = await removeFriend(currentUser.id, friendId);
      if (!mountedRef.current) return;
      if (success) {
        loadFriends();
      }
    }
  };

  const handleInviteToGame = async (friendId: string, friendName: string) => {
    if (!supabase || !onNavigateToGame) return;
    try {
      const roomName = `Match vs ${friendName}`;
      const { data: roomId, error } = await supabase.rpc("create_room", {
        room_name: roomName,
        target_score: 100,
        deal_option: 'auto',
        visibility: 'private',
      });

      if (error) throw error;
      if (!roomId) throw new Error("Le salon n'a pas pu être créé.");
      
      await sendGameInvite(currentUser.id, friendId, roomId);
      localStorage.setItem("active_online_room_id", roomId);
      onNavigateToGame(roomId);
    } catch (err) {
      console.error("Failed to invite to game", err);
      if (mountedRef.current) {
        setFeedback({ message: "Erreur lors de la création du match.", type: 'error' });
        setTimeout(() => {
          if (mountedRef.current) setFeedback(null);
        }, 3000);
      }
    }
  };

  const acceptedFriends = friends.filter(f => f.status === 'accepted');
  const pendingRequests = friends.filter(f => f.status === 'pending');

  return (
    <div className="bg-[#140804] border border-[#3a1506] rounded-2xl p-4 flex flex-col gap-4 max-h-[400px]">
      <div className="flex items-center gap-2 text-amber-500 font-serif pb-2 border-b border-[#3a1506]">
        <Users className="w-5 h-5" />
        <h3 className="font-bold">Amis ({acceptedFriends.length})</h3>
      </div>

      <form onSubmit={handleAddFriend} className="flex gap-2 relative">
        <div className="flex-1 relative">
          <input
            type="text"
            value={searchUsername}
            onChange={(e) => setSearchUsername(e.target.value)}
            placeholder="Rechercher un joueur..."
            className="w-full bg-black/50 border border-[#3a1506] rounded-lg px-3 py-2 text-sm text-stone-200 outline-none focus:border-amber-500"
          />
          {searchResults.length > 0 && (
            <div className="absolute top-full left-0 right-0 mt-1 bg-stone-900 border border-[#3a1506] rounded-lg shadow-xl z-50 overflow-hidden">
              {searchResults.map(user => (
                <div 
                  key={user.id} 
                  onClick={() => handleAddFriend(undefined, user.username)}
                  className="flex items-center gap-3 p-3 border-b border-[#3a1506] hover:bg-stone-800 cursor-pointer transition-colors"
                >
                  <div className="w-8 h-8 rounded-full bg-stone-800 flex items-center justify-center text-amber-500 font-bold shrink-0">
                    {user.username.charAt(0).toUpperCase()}
                  </div>
                  <span className="text-sm font-semibold text-stone-300 flex-1">{user.username}</span>
                  <UserPlus className="w-4 h-4 text-amber-600" />
                </div>
              ))}
            </div>
          )}
          {isSearching && (
            <div className="absolute right-3 top-1/2 -translate-y-1/2 text-amber-700">
              <span className="w-4 h-4 block border-2 border-amber-700 border-t-amber-400 rounded-full animate-spin"></span>
            </div>
          )}
        </div>
        <button
          type="submit"
          className="bg-[#3a1506] hover:bg-amber-900 text-amber-500 p-2 rounded-lg transition-colors shrink-0"
        >
          <UserPlus className="w-5 h-5" />
        </button>
      </form>

      {feedback && (
        <div className={`text-xs px-3 py-2 rounded-md ${feedback.type === 'success' ? 'bg-emerald-900/30 text-emerald-400' : 'bg-red-900/30 text-red-400'}`}>
          {feedback.message}
        </div>
      )}

      <div className="flex-1 overflow-y-auto pr-2 custom-scrollbar flex flex-col gap-3">
        {loading ? (
          <div className="text-center text-stone-500 text-sm py-4">Chargement...</div>
        ) : (
          <>
            {pendingRequests.length > 0 && (
              <div className="flex flex-col gap-2 mb-2">
                <span className="text-xs font-bold text-stone-500 uppercase">Demandes en attente</span>
                {pendingRequests.map(friend => (
                  <div key={friend.id} className="flex items-center justify-between bg-black/40 p-2 rounded-lg border border-stone-800">
                    <div className="flex items-center gap-2">
                      <div className="w-8 h-8 rounded-full bg-stone-800 flex items-center justify-center text-stone-400 font-bold">
                        {friend.username.charAt(0).toUpperCase()}
                      </div>
                      <span className="text-sm font-medium text-stone-300">{friend.username}</span>
                    </div>
                    {friend.isIncomingRequest ? (
                      <div className="flex gap-1">
                        <button onClick={() => handleRespond(friend.id, true)} className="p-1.5 bg-emerald-900/40 text-emerald-500 hover:bg-emerald-800/60 rounded-md">
                          <Check className="w-4 h-4" />
                        </button>
                        <button onClick={() => handleRespond(friend.id, false)} className="p-1.5 bg-red-900/40 text-red-500 hover:bg-red-800/60 rounded-md">
                          <X className="w-4 h-4" />
                        </button>
                      </div>
                    ) : (
                      <span className="text-xs text-stone-500 flex items-center gap-1">
                        <Clock className="w-3 h-3" /> Envoyée
                      </span>
                    )}
                  </div>
                ))}
              </div>
            )}

            <div className="flex flex-col gap-2">
              <span className="text-xs font-bold text-stone-500 uppercase">Vos amis</span>
              {acceptedFriends.length === 0 ? (
                <div className="text-center text-stone-600 text-sm py-4">Aucun ami pour le moment.</div>
              ) : (
                acceptedFriends.map(friend => (
                  <div key={friend.id} className="flex items-center justify-between bg-black/40 p-2 rounded-lg border border-stone-800 group hover:border-[#3a1506] transition-colors">
                    <div className="flex items-center gap-2">
                      <div className="w-8 h-8 rounded-full bg-stone-800 flex items-center justify-center text-stone-400 font-bold relative">
                        {friend.username.charAt(0).toUpperCase()}
                        {/* Placeholder for online status, defaults to offline right now */}
                        <div className="absolute bottom-0 right-0 w-2.5 h-2.5 bg-stone-500 rounded-full border border-[#140804]"></div>
                      </div>
                      <span className="text-sm font-medium text-stone-300">{friend.username}</span>
                    </div>
                    
                    <div className="flex items-center gap-1 opacity-0 group-hover:opacity-100 transition-all">
                      <button 
                        onClick={() => handleInviteToGame(friend.id, friend.username)}
                        className="p-1.5 text-stone-600 hover:text-amber-500 hover:bg-amber-950/30 rounded-md"
                        title="Inviter à jouer"
                      >
                        <Gamepad2 className="w-4 h-4" />
                      </button>
                      <button 
                        onClick={() => handleRemove(friend.id)}
                        className="p-1.5 text-stone-600 hover:text-red-500 hover:bg-red-950/30 rounded-md"
                        title="Retirer cet ami"
                      >
                        <UserX className="w-4 h-4" />
                      </button>
                    </div>
                  </div>
                ))
              )}
            </div>

            {/* Suggestions Section */}
            {suggestedUsers.length > 0 && searchUsername.length === 0 && (
              <div className="mt-4">
                <h4 className="text-[10px] font-bold text-stone-500 uppercase tracking-wider mb-2">Joueurs suggérés</h4>
                <div className="flex flex-col gap-2">
                  {suggestedUsers.map(user => (
                    <div key={user.id} className="bg-stone-900/50 p-2 rounded-lg flex items-center justify-between border border-[#3a1506]/30">
                      <div className="flex items-center gap-3">
                        <div className="w-8 h-8 rounded-full bg-stone-800 flex items-center justify-center text-amber-500 font-bold">
                          {user.username.charAt(0).toUpperCase()}
                        </div>
                        <span className="text-sm font-semibold text-stone-300">{user.username}</span>
                      </div>
                      <button
                        onClick={() => handleAddFriend(undefined, user.username)}
                        className="p-2 bg-amber-900/20 text-amber-500 hover:bg-amber-900/40 rounded-lg transition-colors"
                        title="Ajouter"
                      >
                        <UserPlus className="w-4 h-4" />
                      </button>
                    </div>
                  ))}
                </div>
              </div>
            )}
          </>
        )}
      </div>
    </div>
  );
};
