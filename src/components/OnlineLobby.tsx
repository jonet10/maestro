import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile, OnlineRoom } from "../types";
import { Plus, Search, Lock, Globe, Users, LogOut, Trophy, Gamepad2, RefreshCw, Key, ChevronRight, X } from "lucide-react";

interface OnlineLobbyProps {
  currentUser: any;
  onSignOut: () => void;
  onNavigateToGame: (roomId: string) => void;
  onNavigateToStats: () => void;
  onBack: () => void;
}

export function OnlineLobby({ currentUser, onSignOut, onNavigateToGame, onNavigateToStats, onBack }: OnlineLobbyProps) {
  const [profile, setProfile] = useState<Profile | null>(null);
  const [rooms, setRooms] = useState<OnlineRoom[]>([]);
  const [showCreateModal, setShowCreateModal] = useState(false);
  
  // Create room states
  const [newRoomName, setNewRoomName] = useState("");
  const [newTargetScore, setNewTargetScore] = useState<50 | 100 | 150 | 200>(100);
  const [newDealOption, setNewDealOption] = useState<"auto" | "manual">("auto");
  const [newVisibility, setNewVisibility] = useState<"public" | "private">("public");
  
  // Join private states
  const [privateCode, setPrivateCode] = useState("");
  const [loading, setLoading] = useState(false);
  const [lobbyError, setLobbyError] = useState<string | null>(null);

  const fetchProfileAndRooms = async () => {
    if (!supabase || !currentUser) return;
    setLoading(true);
    setLobbyError(null);

    try {
      // 1. Fetch Profile
      const { data: profData, error: profError } = await supabase
        .from("profiles")
        .select("*")
        .eq("id", currentUser.id)
        .single();

      if (profError) {
        console.error("Error fetching profile:", profError);
      } else {
        setProfile(profData);
      }

      // 2. Fetch Open/Active Rooms
      const { data: roomsData, error: roomsError } = await supabase
        .from("rooms")
        .select(`
          *,
          creator:creator_id ( username, win_rate ),
          opponent:opponent_id ( username, win_rate )
        `)
        .eq("status", "waiting")
        .eq("visibility", "public")
        .order("created_at", { ascending: false });

      if (roomsError) {
        setLobbyError("Erreur lors de la récupération des salons.");
        console.error("Rooms fetch error:", roomsError);
      } else {
        setRooms(roomsData || []);
      }
    } catch (err: any) {
      setLobbyError(err.message || "Une erreur est survenue.");
    } finally {
      setLoading(false);
    }
  };

  // Run on mount
  useEffect(() => {
    fetchProfileAndRooms();

    if (!supabase) return;

    // Realtime channel subscription for changes to the rooms table
    const roomsChannel = supabase
      .channel("lobby_rooms_changes")
      .on(
        "postgres_changes",
        { event: "*", schema: "public", table: "rooms" },
        () => {
          // Re-fetch rooms list when any room is created, joined or changed
          fetchProfileAndRooms();
        }
      )
      .subscribe();

    return () => {
      supabase.removeChannel(roomsChannel);
    };
  }, [currentUser]);

  const handleCreateRoom = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase || !currentUser) return;
    
    const name = newRoomName.trim() || `${profile?.username || "Joueur"}'s Room`;
    setLoading(true);
    setLobbyError(null);

    try {
      const { data: roomId, error } = await supabase.rpc("create_room", {
        room_name: name,
        target_score: newTargetScore,
        deal_option: newDealOption,
        visibility: newVisibility,
      });

      if (error) {
        setLobbyError(error.message);
      } else if (roomId) {
        setShowCreateModal(false);
        // Save room ID locally for reconnect recovery
        localStorage.setItem("active_online_room_id", roomId);
        onNavigateToGame(roomId);
      }
    } catch (err: any) {
      setLobbyError(err.message || "Impossible de créer le salon.");
    } finally {
      setLoading(false);
    }
  };

  const handleJoinRoom = async (roomId: string) => {
    if (!supabase) return;
    setLoading(true);
    setLobbyError(null);

    try {
      const { error } = await supabase.rpc("join_room", {
        p_room_id: roomId,
      });

      if (error) {
        setLobbyError(error.message);
      } else {
        localStorage.setItem("active_online_room_id", roomId);
        onNavigateToGame(roomId);
      }
    } catch (err: any) {
      setLobbyError(err.message || "Impossible de rejoindre le salon.");
    } finally {
      setLoading(false);
    }
  };

  const handleJoinPrivateRoom = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!supabase) return;
    if (privateCode.length !== 6) {
      setLobbyError("Le code doit contenir exactement 6 caractères.");
      return;
    }
    setLoading(true);
    setLobbyError(null);

    try {
      const { data: roomId, error } = await supabase.rpc("join_room_by_code", {
        p_room_code: privateCode.trim().toUpperCase(),
      });

      if (error) {
        setLobbyError(error.message);
      } else if (roomId) {
        localStorage.setItem("active_online_room_id", roomId);
        onNavigateToGame(roomId);
      }
    } catch (err: any) {
      setLobbyError(err.message || "Erreur de connexion.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-200 overflow-hidden font-sans relative">
      {/* Background glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between shrink-0 z-10">
        <button onClick={onBack} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer">
          <ChevronRight size={20} className="rotate-180" /> Quitter Lobby
        </button>
        <h2 className="text-base font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">
          Multijoueur En Ligne
        </h2>
        <button onClick={onSignOut} className="p-1.5 text-gray-400 hover:text-red-400 cursor-pointer rounded-lg hover:bg-red-500/5 border border-transparent hover:border-red-500/10 transition-all">
          <LogOut size={18} />
        </button>
      </header>

      {/* Main Content Area */}
      <div className="flex-1 overflow-y-auto p-4 space-y-4 no-scrollbar z-10 pb-8">
        
        {/* Lobby error feedback banner */}
        {lobbyError && (
          <div className="p-3 bg-red-950/40 border border-red-500/30 text-red-400 text-xs rounded-xl flex items-center justify-between shadow-md">
            <span>{lobbyError}</span>
            <button onClick={() => setLobbyError(null)} className="text-gray-500 hover:text-white">
              <X size={14} />
            </button>
          </div>
        )}

        {/* Profile Stats Summary Header Card */}
        {profile && (
          <div className="bg-gradient-to-r from-[#16130d] to-[#0c0c0c] border border-amber-500/15 rounded-2xl p-4 flex justify-between items-center shadow-md">
            <div className="space-y-1">
              <span className="text-[10px] text-amber-500 font-black uppercase tracking-widest font-mono">Bienvenue</span>
              <h3 className="text-lg font-black text-white">{profile.username}</h3>
              <button 
                onClick={onNavigateToStats}
                className="text-[10px] text-gray-400 hover:text-amber-400 font-semibold flex items-center gap-1 mt-1 cursor-pointer"
              >
                <Trophy size={12} className="text-amber-500" />
                Voir les statistiques complètes
              </button>
            </div>
            <div className="text-right">
              <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Taux Victoires</span>
              <span className="text-3xl font-black text-emerald-400 font-mono">{profile.win_rate}%</span>
            </div>
          </div>
        )}

        {/* Lobby Actions */}
        <div className="grid grid-cols-2 gap-3">
          <button
            onClick={() => setShowCreateModal(true)}
            className="flex flex-col items-center justify-center gap-2 p-5 bg-[#121212] border border-gray-800/80 hover:border-amber-500/30 rounded-2xl text-center active:scale-98 transition-all cursor-pointer group shadow-sm"
          >
            <div className="p-3 rounded-full bg-amber-500/10 text-amber-500 group-hover:scale-105 transition-all">
              <Plus size={20} />
            </div>
            <span className="text-xs font-bold text-white uppercase tracking-wider font-mono">Créer Salon</span>
          </button>

          <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 flex flex-col justify-center space-y-2.5 shadow-sm">
            <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Rejoindre Code Privé</label>
            <form onSubmit={handleJoinPrivateRoom} className="flex gap-2">
              <input
                type="text"
                maxLength={6}
                value={privateCode}
                onChange={(e) => setPrivateCode(e.target.value.toUpperCase())}
                placeholder="A7K9X2"
                className="w-full bg-[#181818] border border-gray-800 rounded-lg px-2.5 py-1.5 text-center text-sm font-mono text-white placeholder-gray-700 uppercase focus:outline-none focus:border-amber-500/60"
              />
              <button
                type="submit"
                className="p-2 bg-gradient-to-b from-amber-400 to-amber-600 text-black rounded-lg hover:brightness-105 active:scale-95 transition-all cursor-pointer"
              >
                <Key size={16} />
              </button>
            </form>
          </div>
        </div>

        {/* Rooms List Section Header */}
        <div className="flex justify-between items-center pt-2">
          <h4 className="text-[10px] uppercase font-mono font-bold tracking-wider text-gray-500 pl-1 flex items-center gap-1.5">
            <Globe size={12} className="text-gray-500" />
            Salons Publics Disponibles
          </h4>
          <button 
            onClick={fetchProfileAndRooms}
            disabled={loading}
            className="text-gray-500 hover:text-white p-1 cursor-pointer flex items-center gap-1 text-[9px] uppercase font-mono"
          >
            <RefreshCw size={11} className={loading ? "animate-spin" : ""} /> Actualiser
          </button>
        </div>

        {/* Rooms List */}
        {rooms.length === 0 ? (
          <div className="text-center text-xs text-gray-500 py-16 bg-[#121212]/50 border border-gray-850 rounded-2xl space-y-2">
            <Gamepad2 size={24} className="mx-auto text-gray-700" />
            <p>Aucun salon public disponible en ce moment.</p>
            <p className="text-[10px] text-gray-600">Créez-en un pour inviter un joueur !</p>
          </div>
        ) : (
          <div className="space-y-2.5">
            {rooms.map((room) => {
              const isCreator = currentUser && room.creator_id === currentUser.id;
              
              return (
                <div 
                  key={room.id}
                  className="bg-[#121212] border border-gray-800/80 rounded-xl p-4 flex justify-between items-center shadow-sm hover:border-gray-800 transition-all"
                >
                  <div className="space-y-1 min-w-0 pr-3">
                    <div className="flex items-center gap-2">
                      <span className="text-sm font-bold text-white truncate block">{room.name}</span>
                      <span className="text-[9px] px-1.5 py-0.5 rounded bg-amber-500/10 text-amber-500 border border-amber-500/20 font-black uppercase tracking-wider shrink-0">
                        {room.target_score} pts
                      </span>
                    </div>
                    
                    <div className="flex items-center gap-2 text-[10px] text-gray-500 font-mono">
                      <span>Créateur : {room.creator?.username || "Inconnu"} ({room.creator?.win_rate || 0}% WR)</span>
                      <span>•</span>
                      <span className="flex items-center gap-0.5">
                        <Users size={11} /> 1/2
                      </span>
                      <span>•</span>
                      <span className="uppercase text-[9px] px-1 bg-gray-900 border border-gray-800 rounded font-semibold text-gray-400">
                        {room.deal_option === "auto" ? "Auto" : "Manuel"}
                      </span>
                    </div>
                  </div>
                  
                  <button
                    disabled={isCreator || loading}
                    onClick={() => handleJoinRoom(room.id)}
                    className={`flex items-center gap-1 px-4 py-2 rounded-lg font-bold text-xs uppercase tracking-widest cursor-pointer active:scale-95 transition-all
                      ${isCreator 
                        ? "bg-gray-800 text-gray-500 border border-gray-700 cursor-not-allowed opacity-50" 
                        : "bg-gradient-to-b from-amber-400 to-amber-600 text-black hover:brightness-105 shadow-sm"
                      }
                    `}
                  >
                    <span>{isCreator ? "Votre salon" : "Rejoindre"}</span>
                    {!isCreator && <ChevronRight size={14} />}
                  </button>
                </div>
              );
            })}
          </div>
        )}
      </div>

      {/* Create Room Modal */}
      {showCreateModal && (
        <div className="absolute inset-0 z-50 bg-black/85 flex items-center justify-center p-4 backdrop-blur-md">
          <div className="bg-[#121212] border border-gray-800 rounded-2xl p-6 w-full max-w-[340px] space-y-4 shadow-2xl relative">
            <button 
              onClick={() => setShowCreateModal(false)}
              className="absolute right-4 top-4 text-gray-500 hover:text-white cursor-pointer"
            >
              <X size={20} />
            </button>

            <div className="text-center space-y-1">
              <h3 className="text-lg font-black text-white uppercase tracking-wider">Créer un Salon</h3>
              <p className="text-xs text-gray-500">Configurez votre salon de jeu multijoueur</p>
            </div>

            <form onSubmit={handleCreateRoom} className="space-y-4">
              {/* Room Name */}
              <div className="space-y-1">
                <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Nom du Salon</label>
                <input
                  type="text"
                  required
                  maxLength={18}
                  value={newRoomName}
                  onChange={(e) => setNewRoomName(e.target.value)}
                  placeholder={`${profile?.username || "Salon"}'s game`}
                  className="w-full bg-[#181818] border border-gray-850 rounded-xl px-3.5 py-2.5 text-sm text-white focus:outline-none focus:border-amber-500/50"
                />
              </div>

              {/* Target Score */}
              <div className="space-y-1">
                <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Score Cible</label>
                <div className="grid grid-cols-4 gap-1.5 bg-[#181818] p-1 rounded-xl">
                  {([50, 100, 150, 200] as const).map((val) => (
                    <button
                      key={val}
                      type="button"
                      onClick={() => setNewTargetScore(val)}
                      className={`py-1.5 text-xs font-bold rounded-lg transition-all cursor-pointer ${
                        newTargetScore === val ? "bg-gray-800 text-amber-500 shadow-sm" : "text-gray-400 hover:text-white"
                      }`}
                    >
                      {val}
                    </button>
                  ))}
                </div>
              </div>

              {/* Deal option */}
              <div className="space-y-1">
                <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Distribution des Tuiles</label>
                <div className="grid grid-cols-2 gap-1.5 bg-[#181818] p-1 rounded-xl">
                  <button
                    type="button"
                    onClick={() => setNewDealOption("auto")}
                    className={`py-1.5 text-xs font-bold rounded-lg transition-all cursor-pointer ${
                      newDealOption === "auto" ? "bg-gray-800 text-amber-500 shadow-sm" : "text-gray-400 hover:text-white"
                    }`}
                  >
                    Auto
                  </button>
                  <button
                    type="button"
                    onClick={() => setNewDealOption("manual")}
                    className={`py-1.5 text-xs font-bold rounded-lg transition-all cursor-pointer ${
                      newDealOption === "manual" ? "bg-gray-800 text-amber-500 shadow-sm" : "text-gray-400 hover:text-white"
                    }`}
                  >
                    Manuelle
                  </button>
                </div>
              </div>

              {/* Visibility option */}
              <div className="space-y-1">
                <label className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Visibilité</label>
                <div className="grid grid-cols-2 gap-1.5 bg-[#181818] p-1 rounded-xl">
                  <button
                    type="button"
                    onClick={() => setNewVisibility("public")}
                    className={`py-1.5 text-xs font-bold rounded-lg transition-all cursor-pointer flex items-center justify-center gap-1 ${
                      newVisibility === "public" ? "bg-gray-800 text-amber-500 shadow-sm" : "text-gray-400 hover:text-white"
                    }`}
                  >
                    <Globe size={12} />
                    <span>Publique</span>
                  </button>
                  <button
                    type="button"
                    onClick={() => setNewVisibility("private")}
                    className={`py-1.5 text-xs font-bold rounded-lg transition-all cursor-pointer flex items-center justify-center gap-1 ${
                      newVisibility === "private" ? "bg-gray-800 text-amber-500 shadow-sm" : "text-gray-400 hover:text-white"
                    }`}
                  >
                    <Lock size={12} />
                    <span>Privée</span>
                  </button>
                </div>
              </div>

              {/* Action Button */}
              <button
                type="submit"
                disabled={loading}
                className="w-full py-3 bg-gradient-to-b from-amber-400 to-amber-600 text-black font-bold uppercase tracking-wider rounded-xl hover:brightness-105 active:scale-95 transition-all cursor-pointer text-xs mt-2"
              >
                {loading ? "Création du salon..." : "Lancer le salon"}
              </button>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
