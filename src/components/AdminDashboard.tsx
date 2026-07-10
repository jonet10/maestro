import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile, Tournament, OnlineRoom, AdminLog } from "../types";
import { 
  Users, Trophy, Eye, FileText, BarChart3, Ban, ShieldCheck, 
  Plus, Play, RefreshCw, X, ChevronLeft, ShieldAlert, Sparkles,
  Search, Crown, Activity, Gamepad2, ArrowRight, Mail
} from "lucide-react";
import { EmailingAdminTab } from "./EmailingAdminTab";

interface AdminDashboardProps {
  currentUser: Profile;
  onBack: () => void;
}

type TabType = "overview" | "players" | "championships" | "live-rooms" | "logs" | "emailing";

export function AdminDashboard({ currentUser, onBack }: AdminDashboardProps) {
  const [activeTab, setActiveTab] = useState<TabType>("overview");
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [successMsg, setSuccessMsg] = useState<string | null>(null);

  // States for data
  const [profiles, setProfiles] = useState<Profile[]>([]);
  const [tournaments, setTournaments] = useState<Tournament[]>([]);
  const [liveRooms, setLiveRooms] = useState<OnlineRoom[]>([]);
  const [adminLogs, setAdminLogs] = useState<AdminLog[]>([]);

  // Search/Filter states
  const [playerSearch, setPlayerSearch] = useState("");
  const [newTName, setNewTName] = useState("");
  const [newTSize, setNewTSize] = useState<4 | 8 | 16 | 32>(8);
  const [newTScore, setNewTScore] = useState<50 | 100 | 150 | 200>(100);

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
        if (error) throw error;
        setAdminLogs(logs || []);
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
          { id: "logs", label: "Logs", icon: <FileText size={14} /> }
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
                          <option value={50}>50 points</option>
                          <option value={100}>100 points</option>
                          <option value={150}>150 points</option>
                          <option value={200}>200 points</option>
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
          </>
        )}
      </div>
    </div>
  );
}
