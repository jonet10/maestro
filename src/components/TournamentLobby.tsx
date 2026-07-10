import React, { useState, useEffect } from "react";
import { supabase } from "../utils/supabaseClient";
import { Profile, Tournament, TournamentMatch } from "../types";
import { 
  Trophy, Users, Gamepad2, Crown, ChevronLeft, 
  RefreshCw, CheckCircle, ShieldAlert, Award, Star, ArrowRight
} from "lucide-react";

interface TournamentLobbyProps {
  currentUser: Profile;
  onNavigateToRoom: (roomId: string) => void;
  onBack: () => void;
}

export function TournamentLobby({ currentUser, onNavigateToRoom, onBack }: TournamentLobbyProps) {
  const [loading, setLoading] = useState(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [successMsg, setSuccessMsg] = useState<string | null>(null);

  const [tournaments, setTournaments] = useState<Tournament[]>([]);
  const [selectedTournament, setSelectedTournament] = useState<Tournament | null>(null);
  const [participants, setParticipants] = useState<Profile[]>([]);
  const [matches, setMatches] = useState<TournamentMatch[]>([]);
  const [isRegistered, setIsRegistered] = useState(false);

  useEffect(() => {
    fetchTournaments();
  }, []);

  useEffect(() => {
    if (selectedTournament) {
      fetchTournamentDetails(selectedTournament.id);
    }
  }, [selectedTournament]);

  const fetchTournaments = async () => {
    if (!supabase) return;
    setLoading(true);
    setErrorMsg(null);
    try {
      const { data, error } = await supabase
        .from("tournaments")
        .select("*, winner:profiles!winner_id(*)")
        .order("created_at", { ascending: false });
      if (error) throw error;
      setTournaments(data || []);
      
      // Keep selected tournament updated if open
      if (selectedTournament && data) {
        const updated = data.find(t => t.id === selectedTournament.id);
        if (updated) setSelectedTournament(updated);
      }
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur de chargement des tournois.");
    } finally {
      setLoading(false);
    }
  };

  const fetchTournamentDetails = async (tournamentId: string) => {
    if (!supabase) return;
    try {
      // 1. Fetch participants
      const { data: parts, error: pErr } = await supabase
        .from("tournament_participants")
        .select("*, profile:profiles(*)")
        .eq("tournament_id", tournamentId);
      if (pErr) throw pErr;
      
      const pList = (parts || []).map(p => p.profile).filter(Boolean) as Profile[];
      setParticipants(pList);
      setIsRegistered(pList.some(p => p.id === currentUser.id));

      // 2. Fetch matches
      const { data: mtch, error: mErr } = await supabase
        .from("tournament_matches")
        .select("*, player1:profiles!player1_id(*), player2:profiles!player2_id(*), room:rooms(*)")
        .eq("tournament_id", tournamentId)
        .order("round_number", { ascending: true })
        .order("match_index", { ascending: true });
      if (mErr) throw mErr;
      setMatches(mtch || []);
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur de chargement des détails du tournoi.");
    }
  };

  const handleRegister = async () => {
    if (!supabase || !selectedTournament) return;
    setErrorMsg(null);
    setSuccessMsg(null);
    setLoading(true);
    try {
      const { error } = await supabase.rpc("register_to_tournament", {
        p_tournament_id: selectedTournament.id
      });
      if (error) throw error;
      setSuccessMsg("Inscription réussie ! Préparez-vous pour le tournoi.");
      await fetchTournamentDetails(selectedTournament.id);
      await fetchTournaments();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors de l'inscription.");
    } finally {
      setLoading(false);
    }
  };

  const handleUnregister = async () => {
    if (!supabase || !selectedTournament) return;
    setErrorMsg(null);
    setSuccessMsg(null);
    setLoading(true);
    try {
      const { error } = await supabase.rpc("unregister_from_tournament", {
        p_tournament_id: selectedTournament.id
      });
      if (error) throw error;
      setSuccessMsg("Vous vous êtes désinscrit du tournoi.");
      await fetchTournamentDetails(selectedTournament.id);
      await fetchTournaments();
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur lors de la désinscription.");
    } finally {
      setLoading(false);
    }
  };

  // Group matches by round
  const roundsMap: { [key: number]: TournamentMatch[] } = {};
  matches.forEach(m => {
    if (!roundsMap[m.round_number]) {
      roundsMap[m.round_number] = [];
    }
    roundsMap[m.round_number].push(m);
  });

  const roundNumbers = Object.keys(roundsMap).map(Number).sort((a, b) => a - b);

  // Check if current user has an active match to play
  const myActiveMatch = matches.find(m => 
    (m.player1_id === currentUser.id || m.player2_id === currentUser.id) &&
    m.status !== "finished" &&
    m.room_id !== null
  );

  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-200 overflow-hidden font-sans relative">
      {/* Background glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Header */}
      <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between shrink-0 z-10">
        <button 
          onClick={selectedTournament ? () => setSelectedTournament(null) : onBack} 
          className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer font-semibold text-sm"
        >
          <ChevronLeft size={20} /> {selectedTournament ? "Championnats" : "Retour"}
        </button>
        <div className="flex items-center gap-2">
          <Trophy className="text-amber-500" size={18} />
          <span className="text-sm font-black text-amber-500 uppercase tracking-widest font-mono">
            {selectedTournament ? "Bracket du Tournoi" : "Championnats Domino"}
          </span>
        </div>
        <button onClick={fetchTournaments} className="text-gray-500 hover:text-amber-500 p-1">
          <RefreshCw size={16} />
        </button>
      </header>

      {/* Feedback banners */}
      <div className="px-4 pt-4 shrink-0 z-10">
        {errorMsg && (
          <div className="p-3 bg-red-950/40 border border-red-500/30 text-red-400 text-xs rounded-xl flex items-start gap-2 shadow-md">
            <ShieldAlert size={16} className="shrink-0 mt-0.5" />
            <span>{errorMsg}</span>
          </div>
        )}
        {successMsg && (
          <div className="p-3 bg-emerald-950/40 border border-emerald-500/30 text-emerald-400 text-xs rounded-xl flex items-start gap-2 shadow-md">
            <CheckCircle size={16} className="shrink-0 mt-0.5" />
            <span>{successMsg}</span>
          </div>
        )}
      </div>

      {/* Main Content scroll window */}
      <div className="flex-1 overflow-y-auto p-4 z-10 no-scrollbar pb-8">
        
        {/* LIST VIEW : All tournaments */}
        {!selectedTournament && (
          <div className="space-y-4">
            <div className="text-center space-y-1 py-4">
              <h2 className="text-2xl font-black text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">
                Championnats Officiels
              </h2>
              <p className="text-xs text-gray-400">
                Rejoignez des brackets compétitifs et devenez le Champion Maestro !
              </p>
            </div>

            <div className="space-y-3">
              {tournaments.map((tour) => (
                <div 
                  key={tour.id} 
                  onClick={() => setSelectedTournament(tour)}
                  className="bg-gradient-to-br from-[#121212] to-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-3 hover:border-amber-500/30 active:scale-98 transition-all cursor-pointer shadow-md"
                >
                  <div className="flex justify-between items-start">
                    <div>
                      <h4 className="font-extrabold text-sm text-white">{tour.name}</h4>
                      <p className="text-[10px] text-gray-500 mt-1 font-mono">
                        Objectif : {tour.target_score} pts • {tour.max_participants} Joueurs
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

                  <div className="flex justify-between items-center text-[11px] font-semibold text-amber-500 pt-1">
                    {tour.status === "finished" && tour.winner ? (
                      <span className="flex items-center gap-1"><Crown size={12} /> Champion : {tour.winner.username}</span>
                    ) : (
                      <span className="text-gray-500">Cliquez pour voir les brackets</span>
                    )}
                    <ChevronLeft size={16} className="rotate-180 text-gray-600" />
                  </div>
                </div>
              ))}

              {tournaments.length === 0 && (
                <p className="text-center text-xs text-gray-500 py-12">Aucun tournoi planifié pour le moment.</p>
              )}
            </div>
          </div>
        )}

        {/* DETAILS VIEW : Selected tournament brackets & registration */}
        {selectedTournament && (
          <div className="space-y-6">
            
            {/* Quick Summary Card */}
            <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4 space-y-4">
              <div className="flex justify-between items-start">
                <div>
                  <h3 className="font-extrabold text-base text-white">{selectedTournament.name}</h3>
                  <p className="text-[10px] text-gray-500 mt-0.5">
                    Matchs en {selectedTournament.target_score} pts • Capacité : {selectedTournament.max_participants} joueurs
                  </p>
                </div>
                {selectedTournament.status === "finished" && selectedTournament.winner && (
                  <div className="flex items-center gap-1 text-xs text-amber-500 font-bold bg-amber-500/5 border border-amber-500/20 px-2.5 py-0.5 rounded-lg">
                    <Crown size={12} />
                    <span>Champion : {selectedTournament.winner.username}</span>
                  </div>
                )}
              </div>

              {/* Registration triggers */}
              {selectedTournament.status === "upcoming" && (
                <div className="flex gap-4 items-center justify-between pt-2 border-t border-gray-950">
                  <div className="space-y-0.5">
                    <span className="text-[9px] text-gray-500 uppercase font-mono font-bold tracking-wider">Inscriptions</span>
                    <p className="text-xs font-black text-white">{participants.length} / {selectedTournament.max_participants} inscrits</p>
                  </div>
                  {isRegistered ? (
                    <button
                      onClick={handleUnregister}
                      className="px-4 py-2 bg-red-950/20 border border-red-500/30 text-red-400 hover:bg-red-500/10 rounded-xl text-xs font-bold uppercase tracking-wider transition-all cursor-pointer"
                    >
                      Se Désinscrire
                    </button>
                  ) : (
                    <button
                      onClick={handleRegister}
                      disabled={participants.length >= selectedTournament.max_participants}
                      className="px-5 py-2.5 bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-md rounded-xl text-xs font-bold uppercase tracking-wider hover:brightness-110 active:scale-98 transition-all disabled:opacity-50 disabled:cursor-not-allowed cursor-pointer"
                    >
                      S'inscrire
                    </button>
                  )}
                </div>
              )}
            </div>

            {/* Play fixture CTA banner */}
            {myActiveMatch && (
              <div className="bg-gradient-to-r from-red-600/30 to-amber-600/20 border border-red-500/40 rounded-2xl p-4 flex flex-col sm:flex-row justify-between items-center gap-3 shadow-lg shadow-red-950/20">
                <div className="space-y-0.5 text-center sm:text-left">
                  <span className="text-[9px] text-red-400 font-black uppercase tracking-widest font-mono">Manche Actuelle</span>
                  <h4 className="text-sm font-black text-white">Votre match de tournoi est prêt !</h4>
                  <p className="text-[10px] text-gray-300">Affrontez votre adversaire dans le salon dédié.</p>
                </div>
                <button
                  onClick={() => onNavigateToRoom(myActiveMatch.room_id!)}
                  className="flex items-center gap-1.5 bg-gradient-to-b from-amber-400 to-amber-600 text-black px-4 py-2.5 rounded-xl text-xs font-bold uppercase tracking-wider transition-all cursor-pointer shadow"
                >
                  <span>Jouer mon match</span>
                  <ArrowRight size={14} />
                </button>
              </div>
            )}

            {/* Tournament Bracket Tree (Round columns side-by-side) */}
            {selectedTournament.status !== "upcoming" && (
              <div className="space-y-4">
                <div className="flex items-center gap-1.5 pl-1">
                  <Award size={16} className="text-amber-500" />
                  <h3 className="text-xs font-black uppercase tracking-widest text-gray-400 font-mono">Arbre des Brackets</h3>
                </div>

                <div className="flex gap-4 overflow-x-auto pb-4 no-scrollbar items-start">
                  {roundNumbers.map((roundNum) => {
                    const roundMatches = roundsMap[roundNum];
                    // Name rounds nicely
                    let roundName = `Tour ${roundNum}`;
                    if (roundMatches.length === 1) roundName = "Finale";
                    else if (roundMatches.length === 2) roundName = "Demi-Finales";
                    else if (roundMatches.length === 4) roundName = "Quarts de finale";

                    return (
                      <div key={roundNum} className="flex-1 min-w-[210px] space-y-4">
                        <div className="bg-[#111] border border-white/[0.03] py-2 px-3 rounded-xl text-center">
                          <span className="text-[9px] text-amber-500 font-black uppercase tracking-widest font-mono">
                            {roundName}
                          </span>
                        </div>

                        {/* Fixtures vertical stack */}
                        <div className="space-y-4 flex flex-col justify-around h-full">
                          {roundMatches.map((match) => {
                            const isP1Winner = match.winner_id === match.player1_id && match.status === "finished";
                            const isP2Winner = match.winner_id === match.player2_id && match.status === "finished";
                            const isMyFixture = match.player1_id === currentUser.id || match.player2_id === currentUser.id;

                            return (
                              <div 
                                key={match.id} 
                                className={`bg-[#0c0c0c] border rounded-2xl p-3 space-y-2 shadow relative
                                  ${isMyFixture 
                                    ? "border-amber-500/50 shadow-amber-950/20" 
                                    : "border-gray-900"
                                  }`}
                              >
                                <span className="absolute top-1.5 right-2 text-[8px] font-mono text-gray-600 uppercase">Match {match.match_index + 1}</span>

                                {/* Player 1 Row */}
                                <div className="flex items-center justify-between text-xs">
                                  <div className="flex items-center gap-1.5 truncate pr-2">
                                    {isP1Winner && <Crown size={12} className="text-amber-500 shrink-0" />}
                                    <span className={`font-semibold truncate ${isP1Winner ? "text-white font-bold" : "text-gray-400"}`}>
                                      {match.player1?.username || "A Déterminer"}
                                    </span>
                                  </div>
                                  <span className="text-[10px] font-bold text-gray-500 font-mono">
                                    {match.status === "finished" && isP1Winner ? "Qualifié" : ""}
                                  </span>
                                </div>

                                {/* Divider line */}
                                <div className="h-[1px] w-full bg-gray-950" />

                                {/* Player 2 Row */}
                                <div className="flex items-center justify-between text-xs">
                                  <div className="flex items-center gap-1.5 truncate pr-2">
                                    {isP2Winner && <Crown size={12} className="text-amber-500 shrink-0" />}
                                    <span className={`font-semibold truncate ${isP2Winner ? "text-white font-bold" : "text-gray-400"}`}>
                                      {match.player2?.username || "A Déterminer"}
                                    </span>
                                  </div>
                                  <span className="text-[10px] font-bold text-gray-500 font-mono">
                                    {match.status === "finished" && isP2Winner ? "Qualifié" : ""}
                                  </span>
                                </div>

                                {/* Status footer */}
                                <div className="flex justify-between items-center text-[9px] text-gray-500 font-mono pt-1.5 border-t border-white/[0.01]">
                                  <span className={`uppercase font-bold 
                                    ${match.status === "ongoing" 
                                      ? "text-amber-500 animate-pulse" 
                                      : match.status === "finished" 
                                        ? "text-gray-600" 
                                        : "text-gray-500"
                                    }`}
                                  >
                                    {match.status === "ongoing" ? "En Cours" : match.status === "finished" ? "Terminé" : "Programmé"}
                                  </span>
                                  {match.status === "ongoing" && match.room && (
                                    <span className="text-[8px] bg-red-500/10 text-red-400 border border-red-500/20 px-1 rounded">Live</span>
                                  )}
                                </div>
                              </div>
                            );
                          })}
                        </div>
                      </div>
                    );
                  })}
                </div>
              </div>
            )}

            {/* Participants Register list (when upcoming) */}
            {selectedTournament.status === "upcoming" && (
              <div className="space-y-3">
                <div className="flex items-center gap-1.5 pl-1">
                  <Users size={16} className="text-gray-400" />
                  <h3 className="text-xs font-black uppercase tracking-widest text-gray-400 font-mono">Inscrits ({participants.length})</h3>
                </div>

                <div className="bg-[#0c0c0c] border border-gray-900 rounded-2xl p-4">
                  <div className="grid grid-cols-2 gap-3">
                    {participants.map((player) => (
                      <div key={player.id} className="flex items-center gap-2 text-xs py-1.5">
                        <span className="text-amber-500"><Star size={12} fill="currentColor" /></span>
                        <span className="font-semibold text-gray-300 truncate">{player.username}</span>
                      </div>
                    ))}
                    {participants.length === 0 && (
                      <div className="col-span-2 text-center text-xs text-gray-500 py-4">Aucun joueur inscrit. Soyez le premier !</div>
                    )}
                  </div>
                </div>
              </div>
            )}

          </div>
        )}

      </div>
    </div>
  );
}
