import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { Bell, UserPlus, Gamepad2, Info, X } from 'lucide-react';
import { Profile } from '../types';
import { Notification, fetchNotifications, markNotificationRead, respondToFriendRequest } from '../services/socialService';
import { supabase } from '../utils/supabaseClient';
import { PlayerProfileModal } from './PlayerProfileModal';

interface NotificationCenterProps {
  currentUser: Profile;
  onNavigateToRoom?: (roomId: string) => void;
}

export const NotificationCenter: React.FC<NotificationCenterProps> = ({ currentUser, onNavigateToRoom }) => {
  const [notifications, setNotifications] = useState<Notification[]>([]);
  const [isOpen, setIsOpen] = useState(false);
  const [selectedProfileId, setSelectedProfileId] = useState<string | null>(null);
  const [selectedNotifId, setSelectedNotifId] = useState<string | null>(null);

  const loadNotifications = async () => {
    const data = await fetchNotifications(currentUser.id);
    setNotifications(data);
  };

  useEffect(() => {
    loadNotifications();

    if (!supabase) return;

    // Realtime subscription for new notifications
    const channel = supabase
      .channel(`public:notifications:user_id=eq.${currentUser.id}`)
      .on(
        'postgres_changes',
        {
          event: 'INSERT',
          schema: 'public',
          table: 'notifications',
          filter: `user_id=eq.${currentUser.id}`
        },
        (payload) => {
          setNotifications(prev => [payload.new as Notification, ...prev]);
        }
      )
      .subscribe();

    return () => {
      supabase.removeChannel(channel);
    };
  }, [currentUser.id]);

  const handleMarkRead = async (notifId: string) => {
    await markNotificationRead(notifId);
    setNotifications(prev => prev.filter(n => n.id !== notifId));
  };

  const handleFriendRequestResponse = async (accept: boolean) => {
    if (!selectedProfileId || !selectedNotifId) return;
    const success = await respondToFriendRequest(currentUser.id, selectedProfileId, accept);
    if (success) {
      await handleMarkRead(selectedNotifId);
    }
    setSelectedProfileId(null);
    setSelectedNotifId(null);
    setIsOpen(false);
  };

  const renderIcon = (type: string) => {
    switch (type) {
      case 'friend_request':
      case 'friend_accept':
        return <UserPlus className="w-4 h-4 text-emerald-400" />;
      case 'invite':
        return <Gamepad2 className="w-4 h-4 text-amber-400" />;
      default:
        return <Info className="w-4 h-4 text-blue-400" />;
    }
  };

  const renderContent = (notif: Notification) => {
    switch (notif.type) {
      case 'friend_request':
        return "Nouvelle demande d'ami !";
      case 'friend_accept':
        return "Demande d'ami acceptée.";
      case 'invite':
        return "Vous avez été invité à jouer !";
      default:
        return notif.payload?.message || "Nouvelle notification";
    }
  };

  return (
    <div className="relative">
      <button 
        onClick={() => setIsOpen(!isOpen)}
        className="relative p-2 text-stone-400 hover:text-amber-500 transition-colors bg-stone-900/50 hover:bg-stone-800 rounded-full"
      >
        <Bell className="w-5 h-5" />
        {notifications.length > 0 && (
          <span className="absolute top-0 right-0 w-4 h-4 bg-red-500 text-white text-[10px] font-bold rounded-full flex items-center justify-center border-2 border-stone-900">
            {notifications.length}
          </span>
        )}
      </button>

      <AnimatePresence>
        {isOpen && (
          <motion.div
            initial={{ opacity: 0, y: 10, scale: 0.95 }}
            animate={{ opacity: 1, y: 0, scale: 1 }}
            exit={{ opacity: 0, y: 10, scale: 0.95 }}
            className="absolute right-0 mt-2 w-72 bg-stone-900 border border-stone-800 rounded-xl shadow-2xl overflow-hidden z-50 flex flex-col"
          >
            <div className="p-3 bg-stone-950 border-b border-stone-800 flex justify-between items-center">
              <span className="text-sm font-bold text-stone-200">Notifications</span>
              <button onClick={() => setIsOpen(false)} className="text-stone-500 hover:text-white">
                <X className="w-4 h-4" />
              </button>
            </div>
            
            <div className="max-h-80 overflow-y-auto custom-scrollbar flex flex-col">
              {notifications.length === 0 ? (
                <div className="p-6 text-center text-stone-500 text-sm">
                  Aucune notification.
                </div>
              ) : (
                notifications.map(notif => (
                  <div key={notif.id} className="p-3 border-b border-stone-800/50 hover:bg-stone-800/30 transition-colors group flex gap-3 items-start">
                    <div className="mt-0.5 p-1.5 rounded-full bg-stone-800 border border-stone-700">
                      {renderIcon(notif.type)}
                    </div>
                    <div className="flex-1 flex flex-col gap-1">
                      <button 
                        onClick={() => {
                          if (notif.type === 'friend_request' && notif.payload?.sender_id) {
                            setSelectedProfileId(notif.payload.sender_id);
                            setSelectedNotifId(notif.id);
                          }
                        }}
                        className={`text-sm text-stone-200 leading-tight text-left ${notif.type === 'friend_request' ? 'hover:text-amber-500 cursor-pointer' : 'cursor-default'}`}
                        disabled={notif.type !== 'friend_request'}
                      >
                        {renderContent(notif)}
                      </button>
                      <span className="text-[10px] text-stone-500 font-mono">
                        {new Date(notif.created_at).toLocaleDateString()}
                      </span>
                      
                      {/* Actions */}
                      {notif.type === 'invite' && onNavigateToRoom && notif.payload?.room_id && (
                        <button 
                          onClick={async () => {
                            if (supabase) {
                              await supabase.rpc("join_room", { p_room_id: notif.payload.room_id });
                            }
                            handleMarkRead(notif.id);
                            onNavigateToRoom(notif.payload.room_id);
                            setIsOpen(false);
                          }}
                          className="mt-1 self-start px-2 py-1 bg-amber-600 hover:bg-amber-500 text-stone-950 text-xs font-bold rounded"
                        >
                          Rejoindre
                        </button>
                      )}
                    </div>
                    <button 
                      onClick={() => handleMarkRead(notif.id)}
                      className="text-stone-600 hover:text-white opacity-0 group-hover:opacity-100 transition-opacity"
                      title="Marquer comme lu"
                    >
                      <X className="w-3 h-3" />
                    </button>
                  </div>
                ))
              )}
            </div>
          </motion.div>
        )}
      </AnimatePresence>

      {selectedProfileId && (
        <PlayerProfileModal
          playerId={selectedProfileId}
          onClose={() => {
            setSelectedProfileId(null);
            setSelectedNotifId(null);
          }}
          isFriendRequest={true}
          onAcceptRequest={() => handleFriendRequestResponse(true)}
          onRejectRequest={() => handleFriendRequestResponse(false)}
        />
      )}
    </div>
  );
};
