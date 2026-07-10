import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile } from "../types";
import { ChevronLeft, Trophy, Gamepad2, Award, Calendar, RefreshCw, Crown, Zap } from "lucide-react";

interface ProfileStatsProps {
  currentUser: any;
  onBack: () => void;
}

export function ProfileStats({ currentUser, onBack }: ProfileStatsProps) {
  const [profile, setProfile] = useState<Profile | null>(null);
  const [unlockedAchievements, setUnlockedAchievements] = useState<any[]>([]);
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);

  const fetchStats = async () => {
    if (!supabase || !currentUser) return;
    setLoading(true);
    setErrorMsg(null);
    try {
      // 1. Fetch profile
      const { data, error } = await supabase
        .from("profiles")
        .select("*")
        .eq("id", currentUser.id)
        .single();

      if (error) {
        setErrorMsg("Impossible de charger les statistiques.");
        console.error(error);
      } else {
        setProfile(data);
      }

      // 2. Fetch unlocked achievements
      const { data: achData } = await supabase
        .from("user_achievements")
        .select("*, achievement:achievements(*)")
        .eq("player_id", currentUser.id);
      
      setUnlockedAchievements(achData || []);
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchStats();
  }, [currentUser]);

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-250 overflow-hidden font-sans relative">
      {/* Background glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between z-10 shrink-0">
        <button onClick={onBack} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer">
          <ChevronLeft size={20} /> Retour
        </button>
        <h2 className="text-base font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">
          Statistiques de Profil
        </h2>
        <button 
          onClick={fetchStats}
          disabled={loading}
          className="text-gray-500 hover:text-white p-1.5 cursor-pointer rounded-lg hover:bg-zinc-800/20"
        >
          <RefreshCw size={16} className={loading ? "animate-spin" : ""} />
        </button>
      </header>

      {/* Content */}
      <div className="flex-1 overflow-y-auto p-6 space-y-6 z-10 no-scrollbar pb-8">
        {errorMsg && (
          <div className="p-3.5 bg-red-950/40 border border-red-500/20 text-red-400 text-xs rounded-xl shadow-inner text-center font-mono">
            {errorMsg}
          </div>
        )}

        {profile ? (
          <div className="space-y-6">
            {/* User Profile Card */}
            <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-6 text-center space-y-3 relative shadow-md">
              <div className="w-16 h-16 rounded-full bg-gradient-to-tr from-amber-400 to-yellow-600 mx-auto flex items-center justify-center text-3xl font-black text-black shadow-lg">
                {profile.username.substring(0, 1).toUpperCase()}
              </div>
              <div className="space-y-1">
                <h3 className="text-xl font-black text-white">{profile.username}</h3>
                <div className="flex items-center justify-center gap-1 text-gray-500 text-[10px] uppercase font-mono">
                  <Calendar size={11} />
                  <span>Inscrit le {new Date(profile.created_at).toLocaleDateString()}</span>
                </div>
                <div className="flex items-center justify-center gap-1.5 text-xs text-amber-500 font-bold font-mono pt-1">
                  <Crown size={12} />
                  <span>{profile.elo_rating || 1000} ELO</span>
                  {profile.role && profile.role !== "player" && (
                    <span className="ml-1 bg-red-500/10 text-red-500 text-[8px] font-black uppercase tracking-wider px-1.5 py-0.5 rounded font-mono border border-red-500/20">
                      {profile.role}
                    </span>
                  )}
                </div>
              </div>
            </div>

            {/* Elo Rating Prominent Box */}
            <div className="bg-gradient-to-r from-amber-600/20 to-amber-900/20 border border-amber-500/30 rounded-2xl p-5 flex flex-col items-center justify-center space-y-2 shadow-[0_0_15px_rgba(245,158,11,0.1)]">
              <span className="text-[10px] text-amber-500 uppercase font-mono font-bold tracking-widest flex items-center gap-1">
                <Crown size={12} />
                Score Elo Global
                <Crown size={12} />
              </span>
              <span className="text-5xl font-black text-amber-400 font-serif tracking-tight drop-shadow-[0_0_10px_rgba(245,158,11,0.5)]">
                {profile.elo_rating || 1000}
              </span>
            </div>

            {/* Grid of Stats (6 boxes) */}
            <div className="grid grid-cols-2 gap-4">
              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-blue-500/10 text-blue-400 mx-auto mb-1">
                  <Gamepad2 size={18} />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Parties Jouées</span>
                <span className="block text-3xl font-black text-white font-mono">{profile.games_played}</span>
              </div>

              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-emerald-500/10 text-emerald-400 mx-auto mb-1">
                  <Award size={18} />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Taux de Victoire</span>
                <span className="block text-3xl font-black text-emerald-400 font-mono">{profile.win_rate}%</span>
              </div>

              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-green-500/10 text-green-450 mx-auto mb-1">
                  <Trophy size={18} />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Victoires</span>
                <span className="block text-3xl font-black text-green-400 font-mono">{profile.games_won}</span>
              </div>

              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-red-500/10 text-red-400 mx-auto mb-1">
                  <Award size={18} className="rotate-180" />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Défaites</span>
                <span className="block text-3xl font-black text-red-400 font-mono">{profile.games_lost}</span>
              </div>

              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-amber-500/10 text-amber-400 mx-auto mb-1">
                  <Trophy size={18} />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Tournois Gagnés</span>
                <span className="block text-3xl font-black text-amber-400 font-mono">{profile.tournaments_won || 0}</span>
              </div>

              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center space-y-1 shadow-sm">
                <div className="p-2 w-max rounded-xl bg-orange-500/10 text-orange-405 mx-auto mb-1">
                  <Zap size={18} />
                </div>
                <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Série (Max)</span>
                <span className="block text-xl font-black text-orange-400 font-mono mt-1">{profile.current_streak || 0} ({profile.max_streak || 0})</span>
              </div>
            </div>

            {/* Premium Win-Loss Ratio Visual bar */}
            {profile.games_played > 0 && (
              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4.5 space-y-2.5 shadow-sm">
                <div className="flex justify-between text-[9px] uppercase font-mono font-bold text-gray-500 tracking-wider">
                  <span>ratio victoires / défaites</span>
                  <span>{profile.games_won}V - {profile.games_lost}D</span>
                </div>
                <div className="w-full bg-red-500/20 h-2.5 rounded-full overflow-hidden flex border border-red-500/10">
                  <div 
                    className="h-full bg-gradient-to-r from-emerald-500 to-green-500 rounded-full" 
                    style={{ width: `${(profile.games_won / profile.games_played) * 100}%` }}
                  />
                </div>
              </div>
            )}

            {/* Achievements Section */}
            <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-5 space-y-4 shadow-sm">
              <div className="flex items-center gap-1.5 border-b border-gray-900 pb-3">
                <Award className="text-amber-500" size={16} />
                <h4 className="text-xs font-black uppercase tracking-widest text-white">Succès Débloqués ({unlockedAchievements.length})</h4>
              </div>
              <div className="space-y-3">
                {unlockedAchievements.map((ua) => {
                  const ach = ua.achievement;
                  return (
                    <div key={ua.achievement_id} className="flex gap-3 items-center text-xs p-2.5 bg-[#0e0e0e] border border-white/[0.01] rounded-xl">
                      <div className="p-2 bg-amber-500/10 text-amber-500 rounded-lg">
                        <Award size={16} />
                      </div>
                      <div className="min-w-0">
                        <h5 className="font-bold text-white">{ach?.title || ua.achievement_id}</h5>
                        <p className="text-[10px] text-gray-500 mt-0.5">{ach?.description || "Description non disponible"}</p>
                      </div>
                    </div>
                  );
                })}
                {unlockedAchievements.length === 0 && (
                  <p className="text-center text-xs text-gray-500 py-2">Aucun succès débloqué pour le moment. Jouez pour déverrouiller des récompenses !</p>
                )}
              </div>
            </div>
          </div>
        ) : (
          <div className="text-center py-20 text-xs text-gray-500">
            {loading ? "Chargement des données..." : "Aucune donnée disponible."}
          </div>
        )}
      </div>
    </div>
  );
}
