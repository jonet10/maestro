import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { X, Trophy, Check, UserPlus } from 'lucide-react';
import { Profile } from '../types';
import { supabase } from '../utils/supabaseClient';

interface PlayerProfileModalProps {
  playerId: string;
  onClose: () => void;
  isFriendRequest?: boolean;
  onAcceptRequest?: () => void;
  onRejectRequest?: () => void;
}

export const PlayerProfileModal: React.FC<PlayerProfileModalProps> = ({ 
  playerId, 
  onClose,
  isFriendRequest,
  onAcceptRequest,
  onRejectRequest
}) => {
  const [profile, setProfile] = useState<Profile | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchProfile = async () => {
      const { data, error } = await supabase
        .from('profiles')
        .select('*')
        .eq('id', playerId)
        .single();
      
      if (!error && data) {
        setProfile(data);
      }
      setLoading(false);
    };

    fetchProfile();
  }, [playerId]);

  return (
    <AnimatePresence>
      <motion.div 
        className="fixed inset-0 z-[60] flex items-center justify-center p-4 bg-black/60 backdrop-blur-sm"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        exit={{ opacity: 0 }}
        onClick={onClose}
      >
        <motion.div
          className="relative w-full max-w-sm bg-stone-900 border-2 border-stone-800 rounded-2xl shadow-2xl overflow-hidden flex flex-col"
          initial={{ scale: 0.95, y: 20 }}
          animate={{ scale: 1, y: 0 }}
          exit={{ scale: 0.95, y: 20 }}
          onClick={(e) => e.stopPropagation()}
        >
          {/* Header */}
          <div className="flex justify-between items-center p-4 bg-stone-950 border-b border-stone-800">
            <h2 className="text-xl font-bold text-stone-100 font-display tracking-wider">
              Profil du Joueur
            </h2>
            <button 
              onClick={onClose}
              className="p-1 text-stone-500 hover:text-white hover:bg-stone-800 rounded-full transition-colors"
            >
              <X className="w-5 h-5" />
            </button>
          </div>

          {/* Content */}
          <div className="p-6 flex flex-col items-center">
            {loading ? (
              <div className="py-8">
                <div className="w-8 h-8 border-2 border-amber-500 border-t-transparent rounded-full animate-spin"></div>
              </div>
            ) : profile ? (
              <>
                <div className="w-24 h-24 bg-stone-800 rounded-full border-4 border-stone-700 flex items-center justify-center mb-4 shadow-inner overflow-hidden relative">
                  {profile.avatar_url ? (
                    <img src={profile.avatar_url} alt={profile.username} className="w-full h-full object-cover" />
                  ) : (
                    <span className="text-4xl font-bold text-stone-500">{profile.username.charAt(0).toUpperCase()}</span>
                  )}
                </div>
                
                <h3 className="text-2xl font-bold text-white mb-1">{profile.username}</h3>
                
                <div className="w-full bg-stone-950/50 rounded-xl p-4 mt-6 border border-stone-800/50">
                  <div className="grid grid-cols-2 gap-4">
                    <div className="flex flex-col items-center justify-center p-2">
                      <Trophy className="w-6 h-6 text-amber-500 mb-1" />
                      <span className="text-xl font-bold text-stone-200">{profile.games_played}</span>
                      <span className="text-[10px] text-stone-500 uppercase tracking-widest">Parties</span>
                    </div>
                    <div className="flex flex-col items-center justify-center p-2 border-l border-stone-800">
                      <div className="text-emerald-500 font-bold text-xl mb-1">{profile.win_rate}%</div>
                      <span className="text-stone-200 font-bold">{profile.games_won}</span>
                      <span className="text-[10px] text-stone-500 uppercase tracking-widest">Victoires</span>
                    </div>
                  </div>
                </div>

                {/* Friend Request Actions */}
                {isFriendRequest && (
                  <div className="w-full mt-6 space-y-2">
                    <button
                      onClick={onAcceptRequest}
                      className="w-full py-3 bg-emerald-600 hover:bg-emerald-500 text-white font-bold rounded-xl flex items-center justify-center gap-2 transition-colors shadow-lg"
                    >
                      <Check className="w-5 h-5" /> Accepter
                    </button>
                    <button
                      onClick={onRejectRequest}
                      className="w-full py-3 bg-stone-800 hover:bg-red-900/40 hover:text-red-400 text-stone-400 font-bold rounded-xl flex items-center justify-center gap-2 transition-colors border border-stone-700 hover:border-red-900/50"
                    >
                      <X className="w-5 h-5" /> Refuser
                    </button>
                  </div>
                )}
              </>
            ) : (
              <div className="text-stone-500">Joueur introuvable</div>
            )}
          </div>
        </motion.div>
      </motion.div>
    </AnimatePresence>
  );
};
