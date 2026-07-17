import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile, Tournament, OnlineRoom, AdminLog } from "../types";
import { 
  Users, Trophy, Eye, FileText, BarChart3, Ban, ShieldCheck, 
  Plus, Play, RefreshCw, X, ChevronLeft, ShieldAlert, Sparkles,
  Search, Crown, Activity, Gamepad2, ArrowRight, Mail, Settings, Globe
} from "lucide-react";
import { EmailingAdminTab } from "./EmailingAdminTab";
import { COUNTRIES } from "../utils/countryData";
import { supportedLanguages } from "../i18n/LanguageContext";

interface AdminDashboardProps {
  currentUser: Profile;
  onBack: () => void;
}

type TabType = "overview" | "players" | "championships" | "live-rooms" | "logs" | "emailing" | "i18n" | "settings";

export function AdminDashboard({ currentUser, onBack }: AdminDashboardProps) {
  const [activeTab, setActiveTab] = useState<TabType>("overview");
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [successMsg, setSuccessMsg] = useState<string | null>(null);

  // Settings tab states
  const [defaultMatchMode, setDefaultMatchMode] = useState<"single" | "first_to" | "fixed">("first_to");
  const [defaultTargetScore, setDefaultTargetScore] = useState(100);
  const [defaultTargetManches, setDefaultTargetManches] = useState(3);
  const [allowCustomMatchRules, setAllowCustomMatchRules] = useState(true);
  const [turnTimer, setTurnTimer] = useState(15);
  const [autoPlay, setAutoPlay] = useState(false);
  const [animationsConfig, setAnimationsConfig] = useState({
    pass: true,
    score: true,
    victory: true,
    roundEnd: true,
    matchEnd: true
  });

  // States for data
  const [profiles, setProfiles] = useState<Profile[]>([]);
  const [tournaments, setTournaments] = useState<Tournament[]>([]);
  const [liveRooms, setLiveRooms] = useState<OnlineRoom[]>([]);
  const [adminLogs, setAdminLogs] = useState<AdminLog[]>([]);

  // i18n states
  const [enabledLanguages, setEnabledLanguages] = useState<string[]>(["fr", "ht", "en", "es", "pt"]);
  const [countryStats, setCountryStats] = useState<Record<string, number>>({});
  const [languageStats, setLanguageStats] = useState<Record<string, number>>({});
  const [peakRegistrationHours, setPeakRegistrationHours] = useState<number[]>(Array(24).fill(0));
  const [availabilityStats, setAvailabilityStats] = useState<Record<string, number>>({});

  // Search/Filter states
  const [playerSearch, setPlayerSearch] = useState("");
  const [newTName, setNewTName] = useState("");
  const [newTSize, setNewTSize] = useState<2 | 4 | 8 | 16 | 32>(8);
  const [newTScore, setNewTScore] = useState<100 | 150 | 200 | 250 | 300 | 350 | 500>(100);
  const [newTType, setNewTType] = useState<"liga" | "copa" | "ligue_des_champions" | "complet">("liga");

  // Stats / Overview counts
  const [totalPlayersCount, setTotalPlayersCount] = useState(0);
  const [activeRoomsCount, setActiveRoomsCount] = useState(0);
  const [activeTournamentsCount, setActiveTournamentsCount] = useState(0);
  const [avgElo, setAvgElo] = useState(1000);

  useEffect(() => {
    fetchData();
  }, [activeTab]);

  const fetchData = async () => {
    if (!supabase) return;
    setLoading(true);
    setErrorMsg(null);
    try {
      if (activeTab === "overview") {
        // Fetch players count
        const { count: pCount } = await supabase.from("profiles").select("*", { count: "exact", head: true });
        setTotalPlayersCount(pCount || 0);

        // Fetch active rooms count
        const { count: rCount } = await supabase.from("rooms").select("*", { count: "exact", head: true }).eq("status", "active");
        setActiveRoomsCount(rCount || 0);

        // Fetch active tournaments count
        const { count: tCount } = await supabase.from("tournaments").select("*", { count: "exact", head: true }).eq("status", "active");
        setActiveTournamentsCount(tCount || 0);

        // Fetch average ELO
        const { data: eloData } = await supabase.from("profiles").select("elo_rating");
        if (eloData && eloData.length > 0) {
          const sum = eloData.reduce((acc, curr) => acc + (curr.elo_rating || 1000), 0);
          setAvgElo(Math.round(sum / eloData.length));
        }

        // Fetch recent logs
        const { data: logs } = await supabase
          .from("admin_logs")
          .select("*, admin:profiles!admin_id(*)")
          .order("created_at", { ascending: false })
          .limit(5);
        setAdminLogs(logs || []);
      } 
      
      else if (activeTab === "players") {
        const { data: users, error } = await supabase
          .from("profiles")
          .select("*")
          .order("elo_rating", { ascending: false });
        if (error) throw error;
        setProfiles(users || []);
      } 
      
      else if (activeTab === "championships") {
        const { data: tours, error } = await supabase
          .from("tournaments")
          .select("*, winner:profiles!winner_id(*)")
          .order("created_at", { ascending: false });
        if (error) throw error;
        setTournaments(tours || []);
      } 
      
      else if (activeTab === "live-rooms") {
        const { data: rooms, error } = await supabase
          .from("rooms")
          .select("*, creator:profiles!creator_id(*), opponent:profiles!opponent_id(*)")
          .eq("status", "active")
          .order("created_at", { ascending: false });
        if (error) throw error;
        setLiveRooms(rooms || []);
      } 
      
      else if (activeTab === "logs") {
        const { data: logs, error } = await supabase
          .from("admin_logs")
          .select("*, admin:profiles!admin_id(*)")
          .order("created_at", { ascending: false })
          .limit(50);
        setAdminLogs(logs || []);
      }
      else if (activeTab === "i18n") {
        const { data: langData } = await supabase
          .from("system_settings")
          .select("value")
          .eq("key", "enabled_languages")
          .maybeSingle();
        if (langData && langData.value) {
          setEnabledLanguages(langData.value);
        }

        const { data: profilesData } = await supabase
          .from("profiles")
          .select("country_code, preferred_language, created_at");
        
        if (profilesData) {
          const countryCounts: Record<string, number> = {};
          const langCounts: Record<string, number> = {};
          const hourCounts: number[] = Array(24).fill(0);

          profilesData.forEach(p => {
            if (p.country_code) {
              countryCounts[p.country_code] = (countryCounts[p.country_code] || 0) + 1;
            }
            if (p.preferred_language) {
              langCounts[p.preferred_language] = (langCounts[p.preferred_language] || 0) + 1;
            }
            if (p.created_at) {
              const hour = new Date(p.created_at).getHours();
              hourCounts[hour]++;
            }
          });

          setCountryStats(countryCounts);
          setLanguageStats(langCounts);
          setPeakRegistrationHours(hourCounts);
        }

        const { data: availData } = await supabase
          .from("user_availabilities")
          .select("user_id, start_time, end_time");
        if (availData) {
          const availSlotsCounts: Record<string, number> = {};
          const seen = new Set<string>();
          availData.forEach(av => {
            const key = `${av.user_id}-${av.start_time}`;
            if (!seen.has(key)) {
              seen.add(key);
              const timeLabel = `${av.start_time.substring(0, 5)}`;
              availSlotsCounts[timeLabel] = (availSlotsCounts[timeLabel] || 0) + 1;
            }
          });
          setAvailabilityStats(availSlotsCounts);
        }
      }
      else if (activeTab === "settings") {
        const { data, error } = await supabase
          .from("system_settings")
          .select("value")
          .eq("key", "gameplay_config")
          .maybeSingle();
        if (error && error.code !== "PGRST116") throw error;
        if (data && data.value) {
          const config = data.value;
          setDefaultMatchMode(config.default_match_mode || "first_to");
          setDefaultTargetScore(config.default_target_score || 100);
          setDefaultTargetManches(config.default_target_manches || 3);
          setAllowCustomMatchRules(config.allow_custom_match_rules !== false);
          setTurnTimer(config.turn_timer || 15);
          setAutoPlay(!!config.auto_play);
          if (config.animations) {
            setAnimationsConfig(config.animations);
          }
        }
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur de chargement des données.");
    } finally {
      setLoading(false);
    }
  };

  const handleBanToggle = async (player: Profile) => {
    if (!supabase) return;
    setErrorMsg(null);
    setSuccessMsg(null);
    const newBanStatus = !player.is_banned;
    const reason = newBanStatus 
      ? `Banni par l'administrateur ${currentUser.username}` 
      : `Débanni par l'administrateur ${currentUser.username}`;
      
    try {
      const { error } = await supabase.rpc("admin_set_banned", {
        p_player_id: player.id,
        p_banned: newBanStatus,
        p_reason: reason
      });
      if (error) throw error;
      setSuccessMsg(`Statut de ${player.username} mis à jour avec succès.`);
      fetchData();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors de la mise à jour du joueur.");
    }
  };

  const handleRoleChange = async (player: Profile, newRole: "player" | "admin" | "super-admin") => {
    if (!supabase) return;
    if (currentUser.role !== "super-admin") {
      setErrorMsg("Seul un Super-Admin peut modifier les rôles.");
      return;
    }
    setErrorMsg(null);
    setSuccessMsg(null);
    try {
      const { error } = await supabase.rpc("admin_update_role", {
        p_player_id: player.id,
        p_role: newRole
      });
      if (error) throw error;
      setSuccessMsg(`Rôle de ${player.username} mis à jour en ${newRole}.`);
      fetchData();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors de la modification du rôle.");
    }
  };

  const handleCreateTournament = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase || !newTName.trim()) return;
    setErrorMsg(null);
    setSuccessMsg(null);
    setLoading(true);
    try {
      const { error } = await supabase.from("tournaments").insert([
        {
          name: newTName.trim(),
          max_participants: newTSize,
          target_score: newTScore,
          competition_type: newTType,
          status: "upcoming"
        }
      ]);
      if (error) throw error;
      
      // Log custom creation
      await supabase.from("admin_logs").insert([
        {
          admin_id: currentUser.id,
          action: "CREATE_TOURNAMENT",
          target_type: "tournament",
          details: `Tournoi "${newTName}" créé. Participants Max : ${newTSize}, Score : ${newTScore}`
        }
      ]);

      setSuccessMsg(`Le championnat "${newTName}" a été créé avec succès !`);
      setNewTName("");
      fetchData();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur de création du tournoi.");
    } finally {
      setLoading(false);
    }
  };

  const handleStartTournament = async (tournamentId: string, name: string) => {
    if (!supabase) return;
    setErrorMsg(null);
    setSuccessMsg(null);
    setLoading(true);
    try {
      const { error } = await supabase.rpc("start_tournament", {
        p_tournament_id: tournamentId
      });
      if (error) throw error;
      setSuccessMsg(`Le tournoi "${name}" a démarré ! Les matchs du premier tour ont été générés.`);
      fetchData();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors du démarrage du tournoi.");
    } finally {
      setLoading(false);
    }
  };

  const handleSaveSettings = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) return;
    setLoading(true);
    setErrorMsg(null);
    setSuccessMsg(null);
    try {
      const payload = {
        default_match_mode: defaultMatchMode,
        default_target_score: defaultTargetScore,
        default_target_manches: defaultTargetManches,
        allow_custom_match_rules: allowCustomMatchRules,
        turn_timer: turnTimer,
        auto_play: autoPlay,
        animations: animationsConfig
      };

      const { error } = await supabase
        .from("system_settings")
        .upsert({
          key: "gameplay_config",
          value: payload,
          updated_by: currentUser.id,
          updated_at: new Date().toISOString()
        });

      if (error) throw error;

      // Log settings update
      await supabase.from("admin_logs").insert([
        {
          admin_id: currentUser.id,
          action: "UPDATE_SYSTEM_SETTINGS",
          target_type: "system_settings",
          details: `Configuration du gameplay mise à jour par l'admin.`
        }
      ]);

      setSuccessMsg("Configuration globale sauvegardée avec succès !");
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors de la sauvegarde.");
    } finally {
      setLoading(false);
    }
  };

  const filteredProfiles = profiles.filter(p => 
    p.username.toLowerCase().includes(playerSearch.toLowerCase())
  );

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-200 overflow-hidden font-sans relative">
      {/* Background decoration */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/3 bg-red-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between shrink-0 z-10">
        <button onClick={onBack} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer font-semibold text-sm">
          <ChevronLeft size={20} /> Retour
        </button>
        <div className="flex items-center gap-2">
          <Crown className="text-red-500" size={18} />
          <span className="text-sm font-black text-red-500 uppercase tracking-widest font-mono">Super Admin Dashboard</span>
        </div>
        <div className="w-10"></div>
      </header>

      {/* Navigation Tabs */}
      <nav className="flex items-center gap-1 overflow-x-auto no-scrollbar p-2 bg-[#0c0c0c] border-b border-gray-900 shrink-0">
        {[
          { id: "overview", label: "Vue d'ensemble", icon: <BarChart3 size={14} /> },
          { id: "players", label: "Joueurs", icon: <Users size={14} /> },
          { id: "championships", label: "Tournois", icon: <Trophy size={14} /> },
          { id: "live-rooms", label: "Salons Live", icon: <Activity size={14} /> },
          { id: "emailing", label: "Emailing", icon: <Mail size={14} /> },
          { id: "logs", label: "Logs", icon: <FileText size={14} /> },
          { id: "i18n", label: "Internationalisation", icon: <Globe size={14} /> },
          ...(currentUser.role === "super-admin" ? [{ id: "settings", label: "Configuration", icon: <Settings size={14} /> }] : [])
        ].map(tab => (
          <button
            key={tab.id}
            onClick={() => {
              setActiveTab(tab.id as TabType);
              setErrorMsg(null);
              setSuccessMsg(null);
            }}
            className={`flex items-center gap-2 px-4 py-2 rounded-lg text-xs font-bold uppercase tracking-wider transition-all whitespace-nowrap
              ${activeTab === tab.id 
                ? "bg-amber-500 text-stone-950 shadow-[0_0_15px_rgba(245,158,11,0.3)]" 
                : "text-gray-500 hover:text-gray-300 hover:bg-white/5"
              }`}
          >
            {tab.icon}
            {tab.label}
          </button>
        ))}
      </nav>

      {/* Feedback Alerts */}
      <div className="px-4 pt-4 shrink-0 z-10">
        {errorMsg && (
          <div className="p-3 bg-red-950/40 border border-red-500/30 text-red-400 text-xs rounded-xl flex items-start gap-2 shadow-md">
            <ShieldAlert size={16} className="shrink-0 mt-0.5" />
            <span>{errorMsg}</span>
          </div>
        )}
        {successMsg && (
          <div className="p-3 bg-emerald-950/40 border border-emerald-500/30 text-emerald-400 text-xs rounded-xl flex items-start gap-2 shadow-md">
            <ShieldCheck size={16} className="shrink-0 mt-0.5" />
            <span>{successMsg}</span>
          </div>
        )}
      </div>

      {/* Content Area */}
      <div className="flex-1 overflow-y-auto p-4 z-10 no-scrollbar">
        {loading && (
          <div className="flex items-center justify-center py-12 gap-2 text-gray-400 text-sm">
            <RefreshCw className="animate-spin text-red-500" size={18} />
            <span>Chargement des données...</span>
          </div>
        )}

        {!loading && (
          <>
            {/* 1. OVERVIEW TAB */}
            {activeTab === "overview" && (
              <div className="space-y-6">
                {/* Stats Grid */}
                <div className="grid grid-cols-2 gap-4">
                  {[
                    { label: "Total Joueurs", val: totalPlayersCount, desc: "Profils enregistrés", icon: Users, color: "from-blue-500/20 to-blue-600/5" },
                    { label: "Salons Actifs", val: activeRoomsCount, desc: "Parties 1v1 en cours", icon: Gamepad2, color: "from-emerald-500/20 to-emerald-600/5" },
                    { label: "Tournois Actifs", val: activeTournamentsCount, desc: "Championnats lancés", icon: Trophy, color: "from-red-500/20 to-red-600/5" },
                    { label: "Classement Moyen", val: `${avgElo} ELO`, desc: "Niveau moyen global", icon: Crown, color: "from-amber-500/20 to-amber-600/5" }
                  ].map((stat, idx) => {
                    const Icon = stat.icon;
                    return (
                      <div key={idx} className={`bg-gradient-to-br ${stat.color} border border-white/[0.04] p-4 rounded-2xl flex flex-col justify-between shadow-md`}>
                        <div className="flex justify-between items-start">
                          <span className="text-[10px] text-gray-400 font-bold uppercase tracking-wider font-mono">{stat.label}</span>
                          <Icon size={16} className="text-gray-400" />
                        </div>
                        <div className="mt-4">
                          <h4 className="text-2xl font-black text-white">{stat.val}</h4>
                          <p className="text-[10px] text-gray-500 mt-1">{stat.desc}</p>
                        </div>
                      </div>
                    );
                  })}
                </div>

                {/* Recent Logs Section */}
                <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-4">
                  <div className="flex items-center gap-1.5 border-b border-gray-900 pb-3">
                    <Activity size={16} className="text-red-500" />
                    <h3 className="text-xs font-black uppercase tracking-widest text-white">Activité Administrative Récente</h3>
                  </div>
                  <div className="space-y-3">
                    {adminLogs.slice(0, 5).map((log) => (
                      <div key={log.id} className="text-xs flex flex-col gap-1 pb-3 border-b border-gray-950 last:border-0 last:pb-0">
                        <div className="flex justify-between text-gray-500 text-[10px] font-mono">
                          <span>Admin: {log.admin?.username || "Système"}</span>
                          <span>{new Date(log.created_at).toLocaleString()}</span>
                        </div>
                        <p className="text-gray-300"><strong className="text-red-400">{log.action}</strong> - {log.details}</p>
                      </div>
                    ))}
                    {adminLogs.length === 0 && (
                      <p className="text-center text-xs text-gray-500 py-4">Aucune activité journalisée.</p>
                    )}
                  </div>
                </div>
              </div>
            )}

            {/* 2. PLAYERS TAB */}
            {activeTab === "players" && (
              <div className="space-y-4">
                {/* Search Bar */}
                <div className="relative">
                  <Search className="absolute left-3.5 top-3 text-gray-500" size={16} />
                  <input
                    type="text"
                    value={playerSearch}
                    onChange={(e) => setPlayerSearch(e.target.value)}
                    placeholder="Rechercher un joueur..."
                    className="w-full bg-[#0c0c0c] border border-gray-800 rounded-xl py-2.5 pl-10 pr-4 text-xs text-white placeholder-gray-600 focus:outline-none focus:border-red-500/60 transition-all font-mono"
                  />
                </div>

                {/* Player List */}
                <div className="space-y-3">
                  {filteredProfiles.map((player) => (
                    <div key={player.id} className={`p-4 rounded-2xl border transition-all flex flex-col gap-3
                      ${player.is_banned 
                        ? "bg-red-950/10 border-red-950/60 opacity-70" 
                        : "bg-[#0c0c0c] border-gray-900"
                      }`}
                    >
                      <div className="flex justify-between items-start">
                        <div>
                          <div className="flex items-center gap-1.5">
                            <h4 className="font-bold text-sm text-white">{player.username}</h4>
                            {player.role !== "player" && (
                              <span className="bg-red-500/10 border border-red-500/20 text-red-500 text-[9px] font-black uppercase px-1.5 py-0.5 rounded font-mono">
                                {player.role}
                              </span>
                            )}
                          </div>
                          <p className="text-[10px] text-gray-500 font-mono mt-0.5">ID: {player.id.substring(0, 8)}...</p>
                        </div>
                        <div className="text-right">
                          <span className="text-xs font-black text-amber-500 font-mono">{player.elo_rating || 1000} ELO</span>
                          <p className="text-[9px] text-gray-400 mt-0.5">{player.games_won}V - {player.games_lost}D ({player.win_rate}%)</p>
                        </div>
                      </div>

                      {/* Administrative Actions */}
                      <div className="flex gap-2 pt-2 border-t border-gray-950 justify-end">
                        {/* Ban / Unban Toggle */}
                        <button
                          onClick={() => handleBanToggle(player)}
                          disabled={player.id === currentUser.id}
                          className={`flex items-center gap-1 px-3 py-1.5 rounded-lg text-[10px] font-bold uppercase tracking-wider transition-all cursor-pointer border
                            ${player.is_banned 
                              ? "bg-emerald-500/10 border-emerald-500/20 text-emerald-400 hover:bg-emerald-500/20" 
                              : "bg-red-500/10 border-red-500/20 text-red-400 hover:bg-red-500/20 disabled:opacity-50 disabled:cursor-not-allowed"
                            }`}
                        >
                          {player.is_banned ? (
                            <>
                              <ShieldCheck size={12} />
                              <span>Débannir</span>
                            </>
                          ) : (
                            <>
                              <Ban size={12} />
                              <span>Bannir</span>
                            </>
                          )}
                        </button>

                        {/* Promote / Demote (Super Admin Only) */}
                        {currentUser.role === "super-admin" && player.id !== currentUser.id && (
                          <div className="flex gap-1">
                            {player.role === "player" ? (
                              <button
                                onClick={() => handleRoleChange(player, "admin")}
                                className="bg-gray-800 border border-gray-700 text-gray-300 hover:text-white px-2.5 py-1.5 rounded-lg text-[10px] font-bold uppercase tracking-wider transition-all cursor-pointer"
                              >
                                Promouvoir Admin
                              </button>
                            ) : (
                              <button
                                onClick={() => handleRoleChange(player, "player")}
                                className="bg-gray-800 border border-gray-700 text-gray-400 hover:text-white px-2.5 py-1.5 rounded-lg text-[10px] font-bold uppercase tracking-wider transition-all cursor-pointer"
                              >
                                Dégrader
                              </button>
                            )}
                          </div>
                        )}
                      </div>
                    </div>
                  ))}
                  {filteredProfiles.length === 0 && (
                    <p className="text-center text-xs text-gray-500 py-8">Aucun joueur correspondant.</p>
                  )}
                </div>
              </div>
            )}

            {/* 3. CHAMPIONSHIPS TAB */}
            {activeTab === "championships" && (
              <div className="space-y-6">
                {/* Create Tournament Form */}
                <form onSubmit={handleCreateTournament} className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-4">
                  <div className="flex items-center gap-1.5 border-b border-gray-900 pb-3">
                    <Plus size={16} className="text-red-500" />
                    <h3 className="text-xs font-black uppercase tracking-widest text-white font-mono">Créer un Championnat</h3>
                  </div>

                  <div className="space-y-3">
                    {/* Name */}
                    <div className="space-y-1">
                      <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider">Nom du Tournoi</label>
                      <input
                        type="text"
                        required
                        value={newTName}
                        onChange={(e) => setNewTName(e.target.value)}
                        placeholder="ex: Maestro Summer Cup"
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3.5 text-xs text-white placeholder-gray-600 focus:outline-none focus:border-red-500/60 transition-all font-mono"
                      />
                    </div>

                    {/* Size and target score */}
                    <div className="grid grid-cols-2 gap-3">
                      <div className="space-y-1">
                        <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider">Participants</label>
                        <select
                          value={newTSize}
                          onChange={(e) => setNewTSize(Number(e.target.value) as any)}
                          className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                        >
                          <option value={2}>2 Joueurs</option>
                          <option value={4}>4 Joueurs</option>
                          <option value={8}>8 Joueurs</option>
                          <option value={16}>16 Joueurs</option>
                          <option value={32}>32 Joueurs</option>
                        </select>
                      </div>

                      <div className="space-y-1">
                        <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider">Score Cible</label>
                        <select
                          value={newTScore}
                          onChange={(e) => setNewTScore(Number(e.target.value) as any)}
                          className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                        >
                          <option value={100}>100 points</option>
                          <option value={150}>150 points</option>
                          <option value={200}>200 points</option>
                          <option value={250}>250 points</option>
                          <option value={300}>300 points</option>
                          <option value={350}>350 points</option>
                          <option value={500}>500 points</option>
                        </select>
                      </div>
                      
                      <div className="space-y-1">
                        <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider">Format</label>
                        <select
                          value={newTType}
                          onChange={(e) => setNewTType(e.target.value as any)}
                          className="w-full bg-[#121212] border border-gray-800 rounded-xl py-2.5 px-3 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                        >
                          <option value="liga">Liga</option>
                          <option value="copa">Copa</option>
                          <option value="ligue_des_champions">Ligue des Champions</option>
                          <option value="complet">Mode Complet</option>
                        </select>
                      </div>
                    </div>

                    <button
                      type="submit"
                      className="w-full py-3 bg-gradient-to-r from-red-600 to-red-700 text-white rounded-xl font-bold text-xs uppercase tracking-wider shadow-lg hover:brightness-110 active:scale-98 transition-all cursor-pointer"
                    >
                      Ajouter le Tournoi
                    </button>
                  </div>
                </form>

                {/* Tournaments List */}
                <div className="space-y-4">
                  <h3 className="text-xs font-black uppercase tracking-widest text-gray-400 font-mono pl-1">Liste des Championnats</h3>
                  
                  {tournaments.map((tour) => (
                    <div key={tour.id} className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-3">
                      <div className="flex justify-between items-start">
                        <div>
                          <h4 className="font-bold text-sm text-white">{tour.name}</h4>
                          <p className="text-[10px] text-gray-500 mt-0.5">
                            {tour.max_participants} Joueurs - Objectif {tour.target_score} pts
                          </p>
                        </div>
                        <span className={`text-[9px] font-black uppercase font-mono px-2 py-0.5 rounded border
                          ${tour.status === "upcoming" 
                            ? "bg-blue-500/10 border-blue-500/25 text-blue-400" 
                            : tour.status === "active" 
                              ? "bg-amber-500/10 border-amber-500/25 text-amber-400" 
                              : "bg-gray-500/10 border-gray-500/25 text-gray-400"
                          }`}
                        >
                          {tour.status === "upcoming" ? "Inscriptions" : tour.status === "active" ? "En Cours" : "Terminé"}
                        </span>
                      </div>

                      {/* Tournament controls */}
                      <div className="flex gap-2 pt-2 border-t border-gray-950 justify-between items-center">
                        {tour.status === "finished" && tour.winner && (
                          <div className="flex items-center gap-1.5 text-xs text-amber-500 font-bold">
                            <Crown size={14} />
                            <span>Vainqueur : {tour.winner.username}</span>
                          </div>
                        )}
                        <div />
                        
                        {tour.status === "upcoming" && (
                          <button
                            onClick={() => handleStartTournament(tour.id, tour.name)}
                            className="flex items-center gap-1 bg-red-600 hover:bg-red-700 text-white px-4 py-2 rounded-xl text-[10px] font-bold uppercase tracking-wider transition-all cursor-pointer shadow-md"
                          >
                            <Play size={12} fill="currentColor" />
                            <span>Lancer le Tournoi</span>
                          </button>
                        )}
                      </div>
                    </div>
                  ))}

                  {tournaments.length === 0 && (
                    <p className="text-center text-xs text-gray-500 py-8">Aucun tournoi planifié.</p>
                  )}
                </div>
              </div>
            )}

            {/* 4. LIVE ROOMS TAB */}
            {activeTab === "live-rooms" && (
              <div className="space-y-4">
                <div className="flex items-center justify-between pl-1">
                  <h3 className="text-xs font-black uppercase tracking-widest text-gray-400 font-mono">Salons en Cours de Lecture</h3>
                  <button onClick={fetchData} className="text-gray-500 hover:text-white p-1">
                    <RefreshCw size={14} />
                  </button>
                </div>

                <div className="space-y-3">
                  {liveRooms.map((room) => {
                    const gameState = room.game_state;
                    const isTournament = room.name.includes("Tournoi");
                    return (
                      <div key={room.id} className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-3">
                        <div className="flex justify-between items-start">
                          <div>
                            <div className="flex items-center gap-1.5">
                              <h4 className="font-bold text-xs text-white">{room.name}</h4>
                              {isTournament && (
                                <span className="bg-red-500/10 border border-red-500/20 text-red-400 text-[8px] font-black uppercase px-1 rounded font-mono">
                                  Tournoi
                                </span>
                              )}
                            </div>
                            <p className="text-[10px] text-gray-500 font-mono mt-0.5">ID: {room.id.substring(0, 8)}...</p>
                          </div>
                          <span className="text-[9px] font-mono bg-emerald-500/10 border border-emerald-500/20 text-emerald-400 px-1.5 py-0.5 rounded uppercase">
                            En Ligne
                          </span>
                        </div>

                        {/* Live Score indicators */}
                        <div className="grid grid-cols-3 bg-[#111] border border-white/[0.02] rounded-xl p-2 text-center text-xs font-mono">
                          <div className="space-y-0.5">
                            <p className="text-[9px] text-gray-500 font-bold truncate">{room.creator?.username || "Créateur"}</p>
                            <p className="text-sm font-black text-white">{gameState?.score_creator ?? 0}</p>
                          </div>
                          <div className="flex items-center justify-center text-gray-600 font-black text-[10px]">
                            VS
                          </div>
                          <div className="space-y-0.5">
                            <p className="text-[9px] text-gray-500 font-bold truncate">{room.opponent?.username || "En attente..."}</p>
                            <p className="text-sm font-black text-white">{gameState?.score_opponent ?? 0}</p>
                          </div>
                        </div>

                        <div className="flex justify-between items-center text-[10px] text-gray-500 pt-1">
                          <span>Manche : {gameState?.round ?? 0}</span>
                          <span>Objectif : {room.target_score} pts</span>
                        </div>
                      </div>
                    );
                  })}

                  {liveRooms.length === 0 && (
                    <div className="text-center py-12 text-gray-500 text-xs">
                      <Gamepad2 className="mx-auto mb-2 text-gray-600" size={24} />
                      <p>Aucune partie en cours de lecture en ce moment.</p>
                    </div>
                  )}
                </div>
              </div>
            )}

            {/* 5. LOGS TAB */}
            {activeTab === "logs" && (
              <div className="space-y-4">
                <h3 className="text-xs font-black uppercase tracking-widest text-gray-400 font-mono pl-1">Historique des Logs Admin</h3>
                
                <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-4">
                  {adminLogs.map((log) => (
                    <div key={log.id} className="text-xs flex flex-col gap-1 pb-3 border-b border-gray-950 last:border-0 last:pb-0">
                      <div className="flex justify-between text-gray-500 text-[10px] font-mono">
                        <span>Admin: {log.admin?.username || "Système"}</span>
                        <span>{new Date(log.created_at).toLocaleString()}</span>
                      </div>
                      <div className="flex gap-2 items-center mt-0.5">
                        <span className="bg-red-500/10 text-red-400 text-[9px] font-black uppercase px-1.5 py-0.5 rounded font-mono shrink-0">
                          {log.action}
                        </span>
                        <span className="text-gray-400 text-[10px] font-mono font-bold uppercase">Cible: {log.target_type} ({log.target_id || "N/A"})</span>
                      </div>
                      <p className="text-gray-300 mt-1">{log.details}</p>
                    </div>
                  ))}

                  {adminLogs.length === 0 && (
                    <p className="text-center text-xs text-gray-500 py-8 font-mono">Aucun log enregistré.</p>
                  )}
                </div>
              </div>
            )}

            {/* 5B. INTERNATIONALISATION TAB */}
            {activeTab === "i18n" && (
              <div className="space-y-6">
                {/* Administrative language controls */}
                <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-4">
                  <div className="flex items-center gap-1.5 border-b border-gray-900 pb-3">
                    <Globe className="text-amber-500" size={16} />
                    <h3 className="text-xs font-black uppercase tracking-widest text-white font-mono">Langues de la Plateforme</h3>
                  </div>
                  
                  <p className="text-[10px] text-gray-500 font-mono">Sélectionnez les langues disponibles pour les utilisateurs :</p>
                  
                  <div className="grid grid-cols-2 md:grid-cols-5 gap-3 pt-2">
                    {supportedLanguages.map(l => {
                      const isEnabled = enabledLanguages.includes(l.code);
                      return (
                        <button
                          key={l.code}
                          type="button"
                          onClick={async () => {
                            const next = isEnabled
                              ? enabledLanguages.filter(code => code !== l.code)
                              : [...enabledLanguages, l.code];
                            if (next.length > 0) {
                              if (!supabase) return;
                              setErrorMsg(null);
                              setSuccessMsg(null);
                              try {
                                const { error } = await supabase
                                  .from("system_settings")
                                  .upsert({
                                    key: "enabled_languages",
                                    value: next,
                                    description: "Liste des langues activées sur la plateforme"
                                  });
                                if (error) throw error;
                                setEnabledLanguages(next);
                                setSuccessMsg("Configuration des langues mise à jour avec succès.");
                              } catch (err: any) {
                                setErrorMsg(err.message || "Erreur lors de la mise à jour des langues.");
                              }
                            }
                          }}
                          className={`p-3 rounded-xl border text-left flex items-center justify-between transition-all cursor-pointer ${
                            isEnabled
                              ? "bg-amber-500/10 border-amber-500 text-white"
                              : "bg-[#121212] border-gray-850 text-gray-500 hover:border-gray-700"
                          }`}
                        >
                          <span className="text-xs font-bold">{l.flag} {l.name}</span>
                          <input
                            type="checkbox"
                            checked={isEnabled}
                            readOnly
                            className="h-3.5 w-3.5 accent-amber-500 cursor-pointer pointer-events-none"
                          />
                        </button>
                      );
                    })}
                  </div>
                </div>

                {/* Stats country & languages */}
                <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                  {/* Countries statistics */}
                  <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-4">
                    <h4 className="text-xs font-black uppercase tracking-widest text-amber-500 font-mono">Utilisateurs par Pays</h4>
                    <div className="space-y-2 max-h-60 overflow-y-auto no-scrollbar pt-2">
                      {COUNTRIES.map(c => {
                        const count = countryStats[c.code] || 0;
                        return (
                          <div key={c.code} className="flex items-center justify-between p-2 bg-[#121212] rounded-xl border border-gray-850">
                            <span className="text-xs font-bold text-white flex items-center gap-2">
                              <span className="text-lg">{c.flag}</span>
                              <span>{c.name}</span>
                            </span>
                            <span className="text-xs font-mono font-bold text-amber-500">{count} joueurs</span>
                          </div>
                        );
                      })}
                    </div>
                  </div>

                  {/* Languages statistics */}
                  <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-4">
                    <h4 className="text-xs font-black uppercase tracking-widest text-amber-500 font-mono">Utilisateurs par Langue</h4>
                    <div className="space-y-2 max-h-60 overflow-y-auto no-scrollbar pt-2">
                      {supportedLanguages.map(l => {
                        const count = languageStats[l.code] || 0;
                        return (
                          <div key={l.code} className="flex items-center justify-between p-2 bg-[#121212] rounded-xl border border-gray-850">
                            <span className="text-xs font-bold text-white flex items-center gap-2">
                              <span className="text-lg">{l.flag}</span>
                              <span>{l.name}</span>
                            </span>
                            <span className="text-xs font-mono font-bold text-amber-500">{count} joueurs</span>
                          </div>
                        );
                      })}
                    </div>
                  </div>
                </div>

                {/* Connexions / Peak Hours & Availabilities statistics */}
                <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                  {/* Availability slots statistics */}
                  <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-4">
                    <h4 className="text-xs font-black uppercase tracking-widest text-amber-500 font-mono">Créneaux de Disponibilité Populaires</h4>
                    <div className="space-y-2 max-h-60 overflow-y-auto no-scrollbar pt-2">
                      {Object.keys(availabilityStats).length > 0 ? (
                        Object.entries(availabilityStats)
                          .sort((a, b) => b[1] - a[1])
                          .map(([slot, count]) => (
                            <div key={slot} className="flex items-center justify-between p-2 bg-[#121212] rounded-xl border border-gray-850">
                              <span className="text-xs font-bold text-stone-300 font-mono">⏰ {slot}</span>
                              <span className="text-xs font-mono font-bold text-amber-500">{count} votes</span>
                            </div>
                          ))
                      ) : (
                        <p className="text-center text-xs text-gray-500 py-4 font-mono">Aucun créneau sélectionné.</p>
                      )}
                    </div>
                  </div>

                  {/* Peak registration hours statistics */}
                  <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-4">
                    <h4 className="text-xs font-black uppercase tracking-widest text-amber-500 font-mono">Heures de Pointe Inscriptions</h4>
                    <div className="space-y-2 max-h-60 overflow-y-auto no-scrollbar pt-2">
                      {peakRegistrationHours.some(c => c > 0) ? (
                        peakRegistrationHours
                          .map((count, hour) => ({ hour, count }))
                          .sort((a, b) => b.count - a.count)
                          .filter(x => x.count > 0)
                          .slice(0, 6)
                          .map(item => (
                            <div key={item.hour} className="flex items-center justify-between p-2 bg-[#121212] rounded-xl border border-gray-850">
                              <span className="text-xs font-bold text-stone-300 font-mono">🕒 {item.hour}h - {item.hour + 1}h</span>
                              <span className="text-xs font-mono font-bold text-amber-500">{item.count} inscrits</span>
                            </div>
                          ))
                      ) : (
                        <p className="text-center text-xs text-gray-500 py-4 font-mono">Aucune inscription enregistrée.</p>
                      )}
                    </div>
                  </div>
                </div>
              </div>
            )}

            {/* 6. SETTINGS TAB */}
            {activeTab === "settings" && currentUser.role === "super-admin" && (
              <form onSubmit={handleSaveSettings} className="space-y-6">
                <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-6 space-y-6">
                  <div className="flex items-center gap-1.5 border-b border-gray-900 pb-3">
                    <Settings className="text-red-500" size={16} />
                    <h3 className="text-xs font-black uppercase tracking-widest text-white font-mono">Configuration Globale</h3>
                  </div>

                  <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                    {/* Default Match Mode */}
                    <div className="space-y-2">
                      <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Mode de Match par Défaut</label>
                      <select
                        value={defaultMatchMode}
                        onChange={(e) => setDefaultMatchMode(e.target.value as any)}
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 px-4 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                      >
                        <option value="single">Partie Unique (1 Manche)</option>
                        <option value="first_to">Premier à X Manches (First To)</option>
                        <option value="fixed">Nombre Fixe de Manches (Fixed)</option>
                      </select>
                    </div>

                    {/* Default Target Score */}
                    <div className="space-y-2">
                      <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Score Cible par Défaut</label>
                      <input
                        type="number"
                        required
                        value={defaultTargetScore}
                        onChange={(e) => setDefaultTargetScore(Number(e.target.value))}
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 px-4 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                      />
                    </div>

                    {/* Default Target Manches */}
                    {defaultMatchMode !== "single" && (
                      <div className="space-y-2">
                        <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">
                          {defaultMatchMode === "first_to" ? "Manches gagnantes par défaut" : "Nombre de manches par défaut"}
                        </label>
                        <input
                          type="number"
                          required
                          value={defaultTargetManches}
                          onChange={(e) => setDefaultTargetManches(Number(e.target.value))}
                          className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 px-4 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                        />
                      </div>
                    )}

                    {/* Turn Timer Duration */}
                    <div className="space-y-2">
                      <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Temps par Tour (secondes)</label>
                      <select
                        value={turnTimer}
                        onChange={(e) => setTurnTimer(Number(e.target.value))}
                        className="w-full bg-[#121212] border border-gray-800 rounded-xl py-3 px-4 text-xs text-white focus:outline-none focus:border-red-500/60 transition-all font-mono"
                      >
                        {[5, 10, 15, 20, 30, 60].map(val => (
                          <option key={val} value={val}>{val} secondes</option>
                        ))}
                      </select>
                    </div>

                    {/* Allow Custom Match Rules */}
                    <div className="flex items-center justify-between p-3 bg-[#121212] border border-gray-800/60 rounded-xl md:col-span-2">
                      <div className="space-y-0.5">
                        <label className="text-xs font-bold text-white">Autoriser les règles personnalisées</label>
                        <p className="text-[9px] text-gray-500">Permet aux joueurs d'écraser ces règles par défaut dans le lobby.</p>
                      </div>
                      <input
                        type="checkbox"
                        checked={allowCustomMatchRules}
                        onChange={(e) => setAllowCustomMatchRules(e.target.checked)}
                        className="h-4 w-4 accent-amber-500 rounded cursor-pointer"
                      />
                    </div>

                    {/* Autoplay Toggle */}
                    <div className="flex items-center justify-between p-3 bg-[#121212] border border-gray-800/60 rounded-xl md:col-span-2">
                      <div className="space-y-0.5">
                        <label className="text-xs font-bold text-white">Jeu Automatique (Auto Play)</label>
                        <p className="text-[9px] text-gray-500">Force l'IA ou les actions automatiques de secours si activé.</p>
                      </div>
                      <input
                        type="checkbox"
                        checked={autoPlay}
                        onChange={(e) => setAutoPlay(e.target.checked)}
                        className="h-4 w-4 accent-amber-500 rounded cursor-pointer"
                      />
                    </div>
                  </div>

                  {/* Animations settings */}
                  <div className="border-t border-gray-900 pt-5 space-y-4">
                    <h4 className="text-[10px] text-gray-400 uppercase font-mono font-bold tracking-wider">Animations Actives</h4>
                    <div className="grid grid-cols-2 sm:grid-cols-3 gap-3">
                      {[
                        { key: "pass", label: "Passe" },
                        { key: "score", label: "Score" },
                        { key: "victory", label: "Victoire" },
                        { key: "roundEnd", label: "Fin de Manche" },
                        { key: "matchEnd", label: "Fin de Série" }
                      ].map(anim => (
                        <div key={anim.key} className="flex items-center justify-between p-2.5 bg-[#121212] border border-gray-850 rounded-xl">
                          <span className="text-[10px] text-gray-300 font-medium">{anim.label}</span>
                          <input
                            type="checkbox"
                            checked={(animationsConfig as any)[anim.key] !== false}
                            onChange={(e) => setAnimationsConfig(prev => ({ ...prev, [anim.key]: e.target.checked }))}
                            className="h-3.5 w-3.5 accent-amber-500 rounded cursor-pointer"
                          />
                        </div>
                      ))}
                    </div>
                  </div>

                  <button
                    type="submit"
                    disabled={loading}
                    className="w-full py-4 bg-gradient-to-r from-amber-500 to-amber-600 text-stone-950 font-bold uppercase tracking-wider rounded-xl hover:brightness-105 active:scale-98 transition-all cursor-pointer text-xs"
                  >
                    {loading ? "Sauvegarde..." : "Sauvegarder la Configuration"}
                  </button>
                </div>
              </form>
            )}
          </>
        )}
      </div>
    </div>
  );
}
