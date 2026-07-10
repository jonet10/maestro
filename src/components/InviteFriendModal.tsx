import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { X, UserPlus, Link as LinkIcon, CheckCircle2 } from 'lucide-react';
import { Friend, fetchFriends, sendGameInvite } from '../services/socialService';

interface InviteFriendModalProps {
  currentUserId: string;
  roomId: string;
  roomCode: string;
  onClose: () => void;
}

export const InviteFriendModal: React.FC<InviteFriendModalProps> = ({ currentUserId, roomId, roomCode, onClose }) => {
  const [friends, setFriends] = useState<Friend[]>([]);
  const [loading, setLoading] = useState(true);
  const [copied, setCopied] = useState(false);
  const [invitedMap, setInvitedMap] = useState<Record<string, boolean>>({});

  useEffect(() => {
    const loadFriends = async () => {
      const data = await fetchFriends(currentUserId);
      setFriends(data.filter(f => f.status === 'accepted'));
      setLoading(false);
    };
    loadFriends();
  }, [currentUserId]);

  const handleInvite = async (friendId: string) => {
    if (invitedMap[friendId]) return;
    
    setInvitedMap(prev => ({ ...prev, [friendId]: true }));
    const success = await sendGameInvite(currentUserId, friendId, roomId);
    if (!success) {
      setInvitedMap(prev => ({ ...prev, [friendId]: false }));
      alert("Erreur lors de l'envoi de l'invitation.");
    }
  };

  const handleCopyLink = () => {
    const inviteLink = `${window.location.origin}/?invite=${roomId}`;
    navigator.clipboard.writeText(inviteLink).then(() => {
      setCopied(true);
      setTimeout(() => setCopied(false), 2000);
    });
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-black/80 backdrop-blur-sm">
      <motion.div
        initial={{ opacity: 0, scale: 0.95 }}
        animate={{ opacity: 1, scale: 1 }}
        exit={{ opacity: 0, scale: 0.95 }}
        className="bg-stone-900 border border-stone-800 rounded-2xl w-full max-w-sm overflow-hidden flex flex-col shadow-2xl relative"
      >
        <div className="p-4 border-b border-stone-800 flex justify-between items-center bg-stone-950">
          <h3 className="font-bold text-amber-500 flex items-center gap-2">
            <UserPlus size={18} />
            Inviter un ami
          </h3>
          <button onClick={onClose} className="text-stone-500 hover:text-white transition-colors">
            <X size={20} />
          </button>
        </div>

        <div className="p-4 flex flex-col gap-4">
          <div className="bg-black/50 p-3 rounded-lg border border-stone-800 flex items-center justify-between">
            <div className="flex flex-col">
              <span className="text-[10px] text-stone-500 uppercase font-bold tracking-wider">Code Privé</span>
              <span className="text-lg font-mono font-black text-white">{roomCode}</span>
            </div>
            <button
              onClick={handleCopyLink}
              className={`px-3 py-2 rounded-lg text-xs font-bold uppercase transition-all flex items-center gap-2 ${
                copied 
                  ? 'bg-emerald-600 text-white' 
                  : 'bg-stone-800 text-stone-300 hover:bg-stone-700 hover:text-white border border-stone-700'
              }`}
            >
              {copied ? <CheckCircle2 size={14} /> : <LinkIcon size={14} />}
              {copied ? 'Copié' : 'Copier le lien'}
            </button>
          </div>

          <div className="flex flex-col gap-2">
            <span className="text-xs font-bold text-stone-500 uppercase tracking-wider">Vos amis</span>
            
            <div className="flex flex-col gap-2 max-h-48 overflow-y-auto custom-scrollbar">
              {loading ? (
                <div className="text-center py-4 text-stone-500 text-sm">Chargement...</div>
              ) : friends.length === 0 ? (
                <div className="text-center py-4 text-stone-600 text-sm">Vous n'avez pas encore d'amis ajoutés.</div>
              ) : (
                friends.map(friend => (
                  <div key={friend.id} className="flex items-center justify-between bg-stone-950/50 p-2 rounded-lg border border-stone-800">
                    <div className="flex items-center gap-2">
                      <div className="w-8 h-8 rounded-full bg-stone-800 flex items-center justify-center text-stone-400 font-bold text-sm">
                        {friend.username.charAt(0).toUpperCase()}
                      </div>
                      <span className="text-sm font-medium text-stone-300">{friend.username}</span>
                    </div>
                    <button
                      onClick={() => handleInvite(friend.id)}
                      disabled={invitedMap[friend.id]}
                      className={`px-3 py-1.5 rounded-md text-xs font-bold transition-all ${
                        invitedMap[friend.id]
                          ? 'bg-stone-800 text-stone-500 cursor-not-allowed'
                          : 'bg-amber-600/20 text-amber-500 hover:bg-amber-600/40 border border-amber-600/30'
                      }`}
                    >
                      {invitedMap[friend.id] ? 'Envoyé' : 'Inviter'}
                    </button>
                  </div>
                ))
              )}
            </div>
          </div>
        </div>
      </motion.div>
    </div>
  );
};
