import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { X, Trophy, Check, Edit2, Globe } from 'lucide-react';
import { Profile } from '../types';
import { supabase } from '../utils/supabaseClient';
import { COUNTRIES } from '../utils/countryData';
import { supportedLanguages, Language } from '../i18n/LanguageContext';
import { checkAvailabilityNow, DbAvailability } from '../utils/availabilityHelper';

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
  const [availabilities, setAvailabilities] = useState<DbAvailability[]>([]);
  const [loading, setLoading] = useState(true);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  
  const [currentUserId, setCurrentUserId] = useState<string | null>(null);
  const [isEditing, setIsEditing] = useState(false);
  const [editCountry, setEditCountry] = useState("");
  const [editLang, setEditLang] = useState<Language>("fr");
  const [editTimezone, setEditTimezone] = useState("");
  const [editInvites, setEditInvites] = useState(true);

  useEffect(() => {
    const fetchProfileData = async () => {
      if (!supabase) {
        setErrorMsg("Connexion impossible.");
        setLoading(false);
        return;
      }
      
      try {
        // Fetch Profile
        const { data: profData, error: profError } = await supabase
          .from('profiles')
          .select('*')
          .eq('id', playerId)
          .single();
        
        if (profError) {
          setErrorMsg("Joueur introuvable ou erreur réseau.");
        } else if (profData) {
          setProfile(profData);
          setEditCountry(profData.country_code || "");
          setEditLang((profData.preferred_language as Language) || "fr");
          setEditTimezone(profData.timezone || "");
          setEditInvites(profData.accept_game_invites !== false);
        }

        // Fetch user availabilities
        const { data: availData, error: availError } = await supabase
          .from('user_availabilities')
          .select('*')
          .eq('user_id', playerId);
        
        if (!availError && availData) {
          setAvailabilities(availData as DbAvailability[]);
        }

        // Fetch current logged in user ID
        const { data: { user } } = await supabase.auth.getUser();
        if (user) {
          setCurrentUserId(user.id);
        }

      } catch (err) {
        console.error("Error fetching profile details:", err);
      } finally {
        setLoading(false);
      }
    };

    fetchProfileData();
  }, [playerId]);

  const handleSaveChanges = async () => {
    if (!supabase) return;
    try {
      const { data, error } = await supabase
        .from('profiles')
        .update({
          country_code: editCountry,
          preferred_language: editLang,
          timezone: editTimezone,
          accept_game_invites: editInvites
        })
        .eq('id', playerId)
        .select()
        .single();

      if (error) throw error;
      if (data) {
        setProfile(data);
        setIsEditing(false);
      }
    } catch (err) {
      console.error("Error updating profile:", err);
      alert("Erreur lors de la mise à jour du profil.");
    }
  };

  const dispo = checkAvailabilityNow(availabilities);
  const userCountry = COUNTRIES.find(c => c.code === profile?.country_code);

  return (
    <AnimatePresence>
      <motion.div 
        className="fixed inset-0 z-[60] flex items-center justify-center p-4 bg-black/70 backdrop-blur-sm"
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        exit={{ opacity: 0 }}
        onClick={onClose}
      >
        <motion.div
          className="relative w-full max-w-sm bg-stone-900 border border-stone-800 rounded-2xl shadow-2xl overflow-hidden flex flex-col"
          initial={{ scale: 0.95, y: 20 }}
          animate={{ scale: 1, y: 0 }}
          exit={{ scale: 0.95, y: 20 }}
          onClick={(e) => e.stopPropagation()}
        >
          {/* Header */}
          <div className="flex justify-between items-center p-4 bg-stone-950 border-b border-stone-800">
            <h2 className="text-lg font-bold text-stone-100 tracking-wider">
              {isEditing ? "Modifier Préférences" : "Profil Joueur"}
            </h2>
            <button 
              onClick={onClose}
              className="p-1 text-stone-500 hover:text-white hover:bg-stone-800 rounded-full transition-colors cursor-pointer"
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
            ) : errorMsg ? (
              <div className="text-red-500 text-sm font-semibold py-4 text-center">{errorMsg}</div>
            ) : profile ? (
              <>
                <div className="w-20 h-20 bg-stone-800 rounded-full border-2 border-stone-700 flex items-center justify-center mb-3 shadow-inner overflow-hidden relative">
                  {profile.avatar_url ? (
                    <img src={profile.avatar_url} alt={profile.username} className="w-full h-full object-cover" />
                  ) : (
                    <span className="text-3xl font-bold text-stone-500">{profile.username.charAt(0).toUpperCase()}</span>
                  )}
                </div>
                
                <h3 className="text-xl font-bold text-white flex items-center gap-1.5">
                  {profile.username}
                  {!isEditing && profile.id === currentUserId && (
                    <button 
                      onClick={() => setIsEditing(true)}
                      className="p-1 text-amber-500 hover:text-amber-400 hover:bg-stone-800 rounded cursor-pointer"
                      title="Modifier les préférences"
                    >
                      <Edit2 className="w-3.5 h-3.5" />
                    </button>
                  )}
                </h3>

                {/* Edit Form */}
                {isEditing ? (
                  <div className="w-full space-y-3 mt-4 text-left">
                    <div>
                      <label className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Pays</label>
                      <select
                        value={editCountry}
                        onChange={(e) => {
                          setEditCountry(e.target.value);
                          const found = COUNTRIES.find(c => c.code === e.target.value);
                          if (found) {
                            setEditLang(found.defaultLang as any);
                            setEditTimezone(found.defaultTimezone);
                          }
                        }}
                        className="w-full bg-stone-950 border border-stone-800 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500 transition-all font-mono"
                      >
                        <option value="">Sélectionner...</option>
                        {COUNTRIES.map(c => (
                          <option key={c.code} value={c.code}>{c.flag} {c.name}</option>
                        ))}
                      </select>
                    </div>

                    <div>
                      <label className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Langue Préférée</label>
                      <select
                        value={editLang}
                        onChange={(e) => setEditLang(e.target.value as any)}
                        className="w-full bg-stone-950 border border-stone-800 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500 transition-all font-mono"
                      >
                        {supportedLanguages.map(l => (
                          <option key={l.code} value={l.code}>{l.flag} {l.name}</option>
                        ))}
                      </select>
                    </div>

                    <div>
                      <label className="text-[10px] text-stone-500 uppercase font-mono font-bold tracking-wider">Fuseau Horaire (IANA)</label>
                      <input
                        type="text"
                        value={editTimezone}
                        onChange={(e) => setEditTimezone(e.target.value)}
                        placeholder="America/Port-au-Prince"
                        className="w-full bg-stone-950 border border-stone-800 rounded-xl py-2 px-3 text-xs text-white focus:outline-none focus:border-amber-500 transition-all font-mono"
                      />
                    </div>

                    <div className="flex items-center justify-between p-2 bg-stone-950/60 border border-stone-800/60 rounded-xl">
                      <span className="text-xs font-bold text-stone-300">Invitations de jeu</span>
                      <input
                        type="checkbox"
                        checked={editInvites}
                        onChange={(e) => setEditInvites(e.target.checked)}
                        className="h-4 w-4 accent-amber-500 rounded cursor-pointer"
                      />
                    </div>

                    <div className="flex gap-2 pt-2">
                      <button
                        onClick={() => setIsEditing(false)}
                        className="w-1/2 py-2 rounded-xl text-xs font-bold bg-stone-800 hover:bg-stone-700 text-stone-300 transition-colors cursor-pointer text-center"
                      >
                        Annuler
                      </button>
                      <button
                        onClick={handleSaveChanges}
                        className="w-1/2 py-2 rounded-xl text-xs font-bold bg-amber-600 hover:bg-amber-500 text-stone-950 transition-colors cursor-pointer text-center"
                      >
                        Sauvegarder
                      </button>
                    </div>
                  </div>
                ) : (
                  <>
                    {/* Region / Dispo Badges */}
                    <div className="mt-2 flex flex-wrap gap-1.5 items-center justify-center">
                      {userCountry && (
                        <span className="px-2 py-0.5 bg-stone-800 text-[10px] text-stone-300 rounded-full font-mono flex items-center gap-1">
                          <span>{userCountry.flag}</span>
                          <span>{userCountry.name}</span>
                        </span>
                      )}
                      {profile.preferred_language && (
                        <span className="px-2 py-0.5 bg-stone-800 text-[10px] text-stone-300 rounded-full font-mono uppercase">
                          🗣️ {profile.preferred_language}
                        </span>
                      )}
                      <span className={`px-2 py-0.5 text-[10px] rounded-full font-mono flex items-center gap-1 ${
                        dispo.available 
                          ? 'bg-emerald-950/80 text-emerald-400 border border-emerald-500/20' 
                          : 'bg-stone-800 text-stone-400'
                      }`}>
                        <span className={`w-1.5 h-1.5 rounded-full ${dispo.available ? 'bg-emerald-400' : 'bg-stone-500'}`}></span>
                        <span>{dispo.text}</span>
                      </span>
                    </div>

                    <div className="w-full bg-stone-950/50 rounded-xl p-4 mt-5 border border-stone-800/50">
                      <div className="grid grid-cols-2 gap-4">
                        <div className="flex flex-col items-center justify-center p-2">
                          <Trophy className="w-5 h-5 text-amber-500 mb-1" />
                          <span className="text-lg font-bold text-stone-200">{profile.games_played}</span>
                          <span className="text-[9px] text-stone-500 uppercase tracking-widest">Parties</span>
                        </div>
                        <div className="flex flex-col items-center justify-center p-2 border-l border-stone-800">
                          <div className="text-emerald-500 font-bold text-lg mb-1">{profile.win_rate}%</div>
                          <span className="text-stone-200 font-bold text-sm">{profile.games_won}</span>
                          <span className="text-[9px] text-stone-500 uppercase tracking-widest">Victoires</span>
                        </div>
                      </div>
                    </div>

                    {/* Friend Request Actions */}
                    {isFriendRequest && (
                      <div className="w-full mt-5 space-y-2">
                        <button
                          onClick={onAcceptRequest}
                          className="w-full py-2.5 bg-emerald-600 hover:bg-emerald-500 text-white font-bold rounded-xl flex items-center justify-center gap-2 transition-colors shadow-lg cursor-pointer"
                        >
                          <Check className="w-4 h-4" /> Accepter
                        </button>
                        <button
                          onClick={onRejectRequest}
                          className="w-full py-2.5 bg-stone-800 hover:bg-red-900/40 hover:text-red-400 text-stone-400 font-bold rounded-xl flex items-center justify-center gap-2 transition-colors border border-stone-700 hover:border-red-900/50 cursor-pointer"
                        >
                          <X className="w-4 h-4" /> Refuser
                        </button>
                      </div>
                    )}
                  </>
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
