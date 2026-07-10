import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile } from "../types";
import { 
  Trophy, Crown, Zap, ChevronLeft, RefreshCw, 
  Award, Star, ShieldAlert, Medal, Gamepad2, Settings
} from "lucide-react";

interface LeaderboardViewProps {
  onBack: () => void;
  onNavigateToLocalHistory?: () => void;
  onNavigate?: (screen: any) => void;
}

type SortField = "elo_rating" | "games_won" | "win_rate" | "tournaments_won";

export function LeaderboardView({ onBack, onNavigateToLocalHistory, onNavigate }: LeaderboardViewProps) {
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [profiles, setProfiles] = useState<Profile[]>([]);
  const [sortBy, setSortBy] = useState<SortField>("elo_rating");

  useEffect(() => {
    fetchLeaderboard();
  }, [sortBy]);

  const fetchLeaderboard = async () => {
    if (!supabase) return;
    setLoading(true);
    setErrorMsg(null);
    try {
      const { data, error } = await supabase
        .from("profiles")
        .select("*")
        .order(sortBy, { ascending: false })
        .limit(50);
      if (error) throw error;
      setProfiles(data || []);
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors du chargement du classement.");
    } finally {
      setLoading(false);
    }
  };

  const getSortIcon = (field: SortField) => {
    switch (field) {
      case "elo_rating": return <Crown className="text-amber-500" size={14} />;
      case "games_won": return <Trophy className="text-amber-500" size={14} />;
      case "win_rate": return <Zap className="text-amber-500" size={14} />;
      case "tournaments_won": return <Award className="text-amber-500" size={14} />;
    }
  };

  const getRankMedal = (index: number) => {
    if (index === 0) return <Medal className="text-amber-400" size={18} fill="currentColor" />; // Gold
    if (index === 1) return <Medal className="text-gray-400" size={18} fill="currentColor" />; // Silver
    if (index === 2) return <Medal className="text-amber-700" size={18} fill="currentColor" />; // Bronze
    return <span className="text-[10px] text-gray-500 font-mono font-bold w-4.5 text-center">{index + 1}</span>;
  };

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-200 overflow-hidden font-sans relative">
      {/* Background glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between shrink-0 z-10">
        <button onClick={onBack} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer font-semibold text-sm">
          <ChevronLeft size={20} /> Menu
        </button>
        <div className="flex items-center gap-2">
          <Trophy className="text-amber-500" size={18} />
          <span className="text-xs font-black text-amber-500 uppercase tracking-widest font-mono">Classement Global</span>
        </div>
        <div className="flex items-center gap-2">
          {onNavigateToLocalHistory && (
            <button 
              onClick={onNavigateToLocalHistory} 
              className="text-amber-500/70 hover:text-amber-500 hover:bg-amber-500/10 px-2 py-1 rounded text-[10px] font-bold uppercase tracking-wider border border-amber-500/20 active:scale-95 transition-all cursor-pointer"
            >
              Historique
            </button>
          )}
          <button onClick={fetchLeaderboard} className="text-gray-500 hover:text-amber-500 p-1.5 cursor-pointer">
            <RefreshCw size={16} className={loading ? "animate-spin" : ""} />
          </button>
        </div>
      </header>

      {/* Filter Tabs */}
      <nav className="flex border-b border-gray-900 bg-[#080808]/80 backdrop-blur z-10 shrink-0 overflow-x-auto no-scrollbar">
        {[
          { id: "elo_rating", label: "ELO" },
          { id: "games_won", label: "Victoires" },
          { id: "win_rate", label: "% Victoires" },
          { id: "tournaments_won", label: "Tournois" }
        ].map((tab) => (
          <button
            key={tab.id}
            onClick={() => setSortBy(tab.id as SortField)}
            className={`flex-1 py-3 text-[10px] font-black uppercase tracking-wider transition-all border-b-2 cursor-pointer
              ${sortBy === tab.id 
                ? "border-amber-500 text-amber-500 bg-amber-500/5" 
                : "border-transparent text-gray-500 hover:text-gray-300 hover:bg-white/[0.01]"
              }`}
          >
            {tab.label}
          </button>
        ))}
      </nav>

      {/* Error display */}
      {errorMsg && (
        <div className="p-3 m-4 bg-red-950/40 border border-red-500/30 text-red-400 text-xs rounded-xl flex items-start gap-2 shadow-md shrink-0">
          <ShieldAlert size={16} className="shrink-0 mt-0.5" />
          <span>{errorMsg}</span>
        </div>
      )}

      {/* Leaderboard Table List */}
      <div className="flex-1 overflow-y-auto px-4 py-3 z-10 no-scrollbar pb-8">
        {loading ? (
          <div className="flex items-center justify-center py-12 gap-2 text-gray-400 text-sm">
            <RefreshCw className="animate-spin text-amber-500" size={18} />
            <span>Chargement des scores...</span>
          </div>
        ) : (
          <div className="space-y-2">
            {profiles.map((player, index) => {
              const displayVal = 
                sortBy === "elo_rating" ? `${player.elo_rating || 1000} ELO` :
                sortBy === "games_won" ? `${player.games_won} Victoires` :
                sortBy === "win_rate" ? `${player.win_rate}% Ratio` :
                `${player.tournaments_won || 0} Championnats`;

              return (
                <div 
                  key={player.id} 
                  className="flex items-center justify-between p-3.5 bg-gradient-to-r from-[#121212] to-[#0c0c0c] border border-gray-900 rounded-xl hover:border-amber-500/10 shadow-sm"
                >
                  <div className="flex items-center gap-3.5 min-w-0">
                    <div className="flex items-center justify-center w-6 shrink-0">
                      {getRankMedal(index)}
                    </div>
                    <div className="min-w-0">
                      <h4 className="font-extrabold text-xs text-white truncate">{player.username}</h4>
                      <p className="text-[9px] text-gray-500 font-mono mt-0.5">
                        {player.games_won}V - {player.games_lost}D ({player.win_rate}%)
                      </p>
                    </div>
                  </div>

                  <div className="flex items-center gap-1.5 shrink-0 pl-2">
                    {getSortIcon(sortBy)}
                    <span className="text-[11px] font-black text-amber-500 font-mono">{displayVal}</span>
                  </div>
                </div>
              );
            })}
            
            {profiles.length === 0 && (
              <p className="text-center text-xs text-gray-500 py-12">Aucun joueur enregistré dans cette catégorie.</p>
            )}
          </div>
        )}
      </div>

      {/* Bottom Nav */}
      {onNavigate && (
        <div className="h-16 shrink-0 bg-[#0c0c0c] border-t border-gray-800/80 flex justify-around items-center mt-auto z-10">
          <button onClick={() => onNavigate("home")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
            <Gamepad2 size={20} />
            <span className="text-[10px] font-medium tracking-wider">Play</span>
          </button>
          <button onClick={() => onNavigate("leaderboard")} className="flex flex-col items-center justify-center w-1/3 text-amber-500 gap-1 cursor-pointer">
            <Trophy size={20} />
            <span className="text-[10px] font-bold tracking-wider">Scores</span>
          </button>
          <button onClick={() => onNavigate("settings")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
            <Settings size={20} />
            <span className="text-[10px] font-medium tracking-wider">Settings</span>
          </button>
        </div>
      )}
    </div>
  );
}
