/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React, { useState, useEffect, useRef } from "react";
import confetti from "canvas-confetti";
import { motion, AnimatePresence } from "motion/react";
import { 
  Tile, 
  PlacedTile, 
  Player, 
  GameLog, 
  GameMode, 
  Difficulty, 
  MatchStatus, 
  DominoGameState,
  AppScreen,
  AdminConfig,
  MatchHistoryEntry,
  Profile,
  GameHistoryEvent
} from "./types";
import { 
  dealDominoes, 
  getOpenEnds, 
  evaluatePlayability, 
  getPlayedTileRotation, 
  hasPlayableTile, 
  sumHandPips, 
  createLog, 
  generateId,
  shuffleTiles,
  generateDoubleSixSet,
  // 2D Branching functions
  getOpenEnds2D,
  evaluatePlayability2D,
  getPlayedTileRotation2D,
  hasPlayableTile2D,
  computeTileLayouts
} from "./utils/dominoLogic";
import { analyzeGameState } from "./utils/analysisEngine";
import { getBestMoveForHand } from "./utils/aiStrategy";
import { supabase } from "./utils/supabaseClient";
import * as ScoreEngine from "./utils/scoreEngine";
import { playTilePlacementSound } from "./utils/audioEngine";

// --- Engine Modules ---
import { GAME_CONFIG } from "./engine/config/GameConfig";
import { GameStateMachine } from "./engine/core/GameStateMachine";
import { EventQueue } from "./engine/core/EventQueue";
import { determineFirstPlayer } from "./engine/rules/FirstPlayerRule";
import { resolveBlockedGame, checkBlockedStatus } from "./engine/rules/BlockedGameRule";
import { calculateRoundScore } from "./engine/rules/ScoreRule";
import { MatchManager, MatchState } from "./engine/core/MatchManager";
// ----------------------
import { GameBoard } from "./components/GameBoard";
import { HandView } from "./components/HandView";
import { ControlPanel } from "./components/ControlPanel";
import { AnalysisPanel } from "./components/AnalysisPanel";
import { HomeMenu } from "./components/HomeMenu";
import { DominoTile } from "./components/DominoTile";
import { BoneyardView } from "./components/BoneyardView";
import { OpponentHand } from "./components/OpponentHand";
import { AuthPortal } from "./components/AuthPortal";
import { OnlineLobby } from "./components/OnlineLobby";
import { OnlineGame } from "./components/OnlineGame";
import { ProfileStats } from "./components/ProfileStats";
import { AdminDashboard } from "./components/AdminDashboard";
import { TournamentLobby } from "./components/TournamentLobby";
import { LeaderboardView } from "./components/LeaderboardView";
import { InstallPrompt } from "./components/InstallPrompt";
import { OnboardingWizard } from "./components/OnboardingWizard";
import { 
  Sparkles, 
  BookOpen, 
  Volume2, 
  HelpCircle, 
  CheckCircle2, 
  Crown, 
  ArrowRight,
  Info,
  ChevronLeft,
  MoreVertical,
  Gamepad2,
  Trophy,
  Settings,
  Share2,
  RotateCcw,
  X
} from "lucide-react";

import { LanguageProvider, useTranslation } from "./i18n/LanguageContext";

const SHOW_DEBUG_FPS = false;

export default function App() {
  return (
    <LanguageProvider>
      <MainApp />
    </LanguageProvider>
  );
}

function MainApp() {
  const { t, language, setLanguage } = useTranslation();
  // 1. Core States
  const [currentScreen, setCurrentScreen] = useState<AppScreen>("auth");
  const [gameMode, setGameMode] = useState<GameMode>("all-fives");
  const [difficulty, setDifficulty] = useState<Difficulty>("medium");
  const [matchStatus, setMatchStatus] = useState<MatchStatus>("not-started");
  const [round, setRound] = useState<number>(1);
  const [winner, setWinner] = useState<"user" | "ai" | "draw" | null>(null);
  const [currentUser, setCurrentUser] = useState<any>(null);
  const [userProfile, setUserProfile] = useState<Profile | null>(null);
  const [activeOnlineRoomId, setActiveOnlineRoomId] = useState<string | null>(null);
  const [authInitialView, setAuthInitialView] = useState<"login" | "register" | "forgot" | "reset-password">("login");

  // Reveal Phase states (Feature 5)
  const [revealPhase, setRevealPhase] = useState<"none" | "revealing" | "scoring">("none");
  const [revealData, setRevealData] = useState<{
    result: "user" | "ai" | "blocked";
    finalBoard: PlacedTile[];
    userHand: Tile[];
    aiHand: Tile[];
    userPipsSum: number;
    aiPipsSum: number;
    roundWinner: "user" | "ai" | "draw";
    tieBreakExplained?: string;
    winningTileId?: string | null;
  } | null>(null);

  // Initial deal options and performance refs (Feature 1 & 2)
  const [dealOption, setDealOption] = useState<"manual" | "auto">("auto");
  const dragRafRef = useRef<number | null>(null);

  // Drag & Drop performance tracking refs
  const dragStartPointerRef = useRef<{ x: number; y: number } | null>(null);
  const dragStartOffsetRef = useRef<{ x: number; y: number } | null>(null);
  const latestPointerPosRef = useRef<{ x: number; y: number } | null>(null);
  const dragActiveRef = useRef<boolean>(false);
  const activeDragTileRef = useRef<Tile | null>(null);
  const draggedHappenedRef = useRef<boolean>(false);
  const hoveredSlotSideRef = useRef<"left" | "right" | "top" | "bottom" | null>(null);
  const hoveredSlotIsVerticalRef = useRef<boolean>(true);
  const snappedTileValuesRef = useRef<Tile | null>(null);
  const floatingTileRef = useRef<HTMLDivElement | null>(null);
  const matchEndPendingRef = useRef<boolean>(false);

  const [scoreUser, setScoreUser] = useState<number>(0);
  const [scoreAi, setScoreAi] = useState<number>(0);
  const [consecutivePasses, setConsecutivePasses] = useState<number>(0);

  const [placedTiles, setPlacedTiles] = useState<PlacedTile[]>([]);
  const [userHand, setUserHand] = useState<Tile[]>([]);
  const [aiHand, setAiHand] = useState<Tile[]>([]);
  const [boneyard, setBoneyard] = useState<Tile[]>([]);

  const [currentPlayer, setCurrentPlayer] = useState<"user" | "ai">("user");
  const isProcessingPlayRef = useRef(false); // CRITICAL FIX: Prevent double-click race condition
  const scoreCommittedRef = useRef<boolean>(false);
  const [selectedTile, setSelectedTile] = useState<Tile | null>(null);
  const [logs, setLogs] = useState<GameLog[]>([]);
  const [showAnalysis, setShowAnalysis] = useState<boolean>(true);
  const [aiThinking, setAiThinking] = useState<boolean>(false);
  const [showRulebook, setShowRulebook] = useState<boolean>(false);

  // 1b. Flycops, Admin & Custom settings states
  const [gameType, setGameType] = useState<"individual" | "team">("individual");
  const [adminConfig, setAdminConfig] = useState<AdminConfig>({
    defaultTarget: 100,
    allowCustomTarget: true,
    enabledTargets: { 50: true, 100: true, 150: true, 200: true }
  });

  // Scores visuels (chronomètre / animation progressive)
  const [visualScoreUser, setVisualScoreUser] = useState<number>(0);
  const [visualScoreAi, setVisualScoreAi] = useState<number>(0);
  const [roundsWonUser, setRoundsWonUser] = useState<number>(0);
  const [roundsWonAi, setRoundsWonAi] = useState<number>(0);

  const [tallyAnimation, setTallyAnimation] = useState<{
    active: boolean;
    winner: "user" | "ai" | "draw";
    pipCounter: number;
    roundPoints: number;
    phase: "pip_counting" | "rounding" | "score_incrementing" | "done";
    currentVisualScoreUser: number;
    currentVisualScoreAi: number;
    targetVisualScoreUser: number;
    targetVisualScoreAi: number;
  }>({
    active: false,
    winner: "draw",
    pipCounter: 0,
    roundPoints: 0,
    phase: "done",
    currentVisualScoreUser: 0,
    currentVisualScoreAi: 0,
    targetVisualScoreUser: 0,
    targetVisualScoreAi: 0
  });
  const [targetScore, setTargetScore] = useState<number>(100);
  const [matchMode, setMatchMode] = useState<"single" | "first_to" | "fixed">("first_to");
  const [targetManches, setTargetManches] = useState<number>(3); // default to Best of 5 (3 wins)
  const [roundsHistory, setRoundsHistory] = useState<any[]>([]);
  const [mancheWinner, setMancheWinner] = useState<"user" | "ai" | null>(null);
  const [mancheCountdown, setMancheCountdown] = useState<number | null>(null);
  const [matchState, setMatchState] = useState<MatchState | null>(null);
  const matchManagerRef = useRef<MatchManager | null>(null);
  const [matchHistory, setMatchHistory] = useState<MatchHistoryEntry[]>([]);
  const [matchWinner, setMatchWinner] = useState<"user" | "ai" | null>(null);
  const [matchCountdown, setMatchCountdown] = useState<number | null>(null);
  const [lastPointsUser, setLastPointsUser] = useState<number | null>(null);
  const [lastPointsAi, setLastPointsAi] = useState<number | null>(null);
  const [centerToast, setCenterToast] = useState<{ winner: "user" | "ai" | "draw"; points: number } | null>(null);
  const [centerScorePopup, setCenterScorePopup] = useState<{ points: number; gridX: number; gridY: number } | null>(null);
  const [isSimulatingReconnection, setIsSimulatingReconnection] = useState<boolean>(false);
  const [isDealing, setIsDealing] = useState<boolean>(false);
  const [nextRoundStarter, setNextRoundStarter] = useState<"user" | "ai" | null>(null);
  // When the board is empty and a player has the heaviest double, they MUST play that specific tile first.
  const [openingForcedTile, setOpeningForcedTile] = useState<Tile | null>(null);

  // Logique de journalisation d'événements interne
  const [internalLogs, setInternalLogs] = useState<GameHistoryEvent[]>([]);
  const [sequenceCounter, setSequenceCounter] = useState<number>(1);

  // Séquence "Passe" pilotée par le moteur
  const [noPlayState, setNoPlayState] = useState<{
    active: boolean;
    player: "user" | "ai";
    step: "idle" | "show_hand" | "await_user_draw" | "draw" | "pass_toast";
    drawnTile: Tile | null;
  }>({
    active: false,
    player: "user",
    step: "idle",
    drawnTile: null
  });

  const logInternalEvent = (type: GameHistoryEvent["type"], player: GameHistoryEvent["player"], details: any = {}) => {
    const newEvent: GameHistoryEvent = {
      eventId: generateId(),
      sequenceNumber: sequenceCounter,
      timestamp: new Date().toISOString(),
      type,
      player,
      details
    };
    setSequenceCounter(prev => prev + 1);
    setInternalLogs(prev => [...prev, newEvent]);
    
    if (import.meta.env.DEV) {
      console.log(`[GAME EVENT #${newEvent.sequenceNumber}] ${newEvent.type.toUpperCase()} by ${newEvent.player}:`, newEvent.details);
    }
  };

  const triggerAutoplayForUser = () => {
    if (currentPlayer !== "user" || matchStatus !== "ongoing" || isDealing || !!matchWinner || matchEndPendingRef.current) return;

    logInternalEvent("autoplay", "user", { reason: "timeout" });

    // Try to find the best move
    const bestMove = getBestMoveForHand(userHand, placedTiles, gameMode, difficulty);
    if (bestMove) {
      playTileForUser(bestMove.tile, bestMove.side as any);
      return;
    }

    // No plays available. Draw from boneyard if we can.
    if ((gameMode === "draw" || gameMode === "all-fives") && boneyard.length > 0) {
      let currentBoneyard = [...boneyard];
      let currentHand = [...userHand];
      let drawnTile: Tile | null = null;
      let playableOption: any = null;

      while (currentBoneyard.length > 0 && !playableOption) {
        drawnTile = currentBoneyard[0];
        currentBoneyard.shift();
        currentHand.push(drawnTile);
        logInternalEvent("draw", "user", { tile: drawnTile, auto: true });

        // Check if this newly drawn tile is playable
        const ends2D = getOpenEnds2D(placedTiles);
        const playability = evaluatePlayability2D(drawnTile, ends2D);
        const isPlayable = playability.left || playability.right || playability.top || playability.bottom || placedTiles.length === 0;
        
        if (isPlayable) {
          if (placedTiles.length === 0) {
            playableOption = { tile: drawnTile, side: "left" };
          } else {
            if (playability.left) playableOption = { tile: drawnTile, side: "left" };
            else if (playability.right) playableOption = { tile: drawnTile, side: "right" };
            else if (playability.top) playableOption = { tile: drawnTile, side: "top" };
            else if (playability.bottom) playableOption = { tile: drawnTile, side: "bottom" };
          }
        }
      }

      setBoneyard(currentBoneyard);
      setUserHand(currentHand);

      if (playableOption) {
        setLogs(prev => [
          createLog("user", `Auto-play drew and played [${playableOption.tile[0]}|${playableOption.tile[1]}].`, "play"),
          ...prev
        ]);
        playTileForUser(playableOption.tile, playableOption.side);
      } else {
        // Boneyard empty, must pass
        logInternalEvent("pass", "user", { auto: true });
        setLogs(prev => [
          createLog("user", `Auto-play drew from boneyard but had no plays and passed.`, "pass"),
          ...prev
        ]);
        const blocked = checkAndTriggerBlockedRound(placedTiles, currentHand, aiHand);
        if (!blocked) {
          setCurrentPlayer("ai");
        }
      }
    } else {
      // Boneyard empty or block mode, must pass immediately
      logInternalEvent("pass", "user", { auto: true });
      setLogs(prev => [
        createLog("user", `Auto-play had no plays and passed.`, "pass"),
        ...prev
      ]);
      const blocked = checkAndTriggerBlockedRound(placedTiles, userHand, aiHand);
      if (!blocked) {
        setCurrentPlayer("ai");
      }
    }
  };

  // Turn timer state (Chronomètre par tour)
  const [turnTimeLeft, setTurnTimeLeft] = useState<number>(GAME_CONFIG.turnTimerDuration);

  useEffect(() => {
    if (turnTimeLeft === 0 && currentPlayer === "user" && matchStatus === "ongoing" && !isDealing && !matchWinner) {
      triggerAutoplayForUser();
    }
  }, [turnTimeLeft, currentPlayer, matchStatus, isDealing, matchWinner]);

  // Turn timer effect
  useEffect(() => {
    if (matchStatus !== "ongoing" || isDealing || !!matchWinner || noPlayState.active) {
      return;
    }

    setTurnTimeLeft(GAME_CONFIG.turnTimerDuration);

    const interval = setInterval(() => {
      setTurnTimeLeft((prev) => {
        if (prev <= 1) {
          logInternalEvent("timeout", "user");
          return 0; // Will trigger automatic play in Step 3
        }
        return prev - 1;
      });
    }, 1000);

    return () => clearInterval(interval);
  }, [currentPlayer, matchStatus, isDealing, matchWinner, noPlayState.active]);

  // Effect to detect when player has no plays and start sequence
  useEffect(() => {
    if (matchStatus !== "ongoing" || isDealing || !!matchWinner || noPlayState.active) return;

    if (currentPlayer === "user") {
      const ends2D = getOpenEnds2D(placedTiles);
      const canPlay = hasPlayableTile2D(userHand, ends2D) || (placedTiles.length === 0 && userHand.length > 0);
      if (!canPlay) {
        setNoPlayState({
          active: true,
          player: "user",
          step: "show_hand",
          drawnTile: null
        });
      }
    } else {
      const aiEnds2D = getOpenEnds2D(placedTiles);
      const aiCanPlay = hasPlayableTile2D(aiHand, aiEnds2D) || placedTiles.length === 0;
      if (!aiCanPlay) {
        setNoPlayState({
          active: true,
          player: "ai",
          step: "show_hand",
          drawnTile: null
        });
      }
    }
  }, [currentPlayer, userHand, aiHand, placedTiles, matchStatus, isDealing, matchWinner, noPlayState.active]);

  // State machine transitions for NoPlaySequence
  useEffect(() => {
    if (!noPlayState.active) return;

    const { player, step } = noPlayState;

    if (step === "show_hand") {
      const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.noPlayHandShow;
      const timer = setTimeout(() => {
        if (boneyard.length > 0 && (gameMode === "draw" || gameMode === "all-fives")) {
          if (player === "user") {
            setNoPlayState(prev => ({ ...prev, step: "await_user_draw", drawnTile: null }));
          } else {
            setNoPlayState(prev => ({ ...prev, step: "draw", drawnTile: null }));
          }
        } else {
          setNoPlayState(prev => ({ ...prev, step: "pass_toast", drawnTile: null }));
        }
      }, delay);
      return () => clearTimeout(timer);
    }

    if (step === "draw") {
      if (noPlayState.drawnTile === null) {
        if (boneyard.length === 0) {
          setNoPlayState(prev => ({ ...prev, step: "pass_toast", drawnTile: null }));
          return;
        }

        const drawnTile = boneyard[0];
        const nextBoneyard = boneyard.slice(1);
        
        let nextHand: Tile[];
        if (player === "user") {
          nextHand = [...userHand, drawnTile];
          setUserHand(nextHand);
          logInternalEvent("draw", "user", { tile: drawnTile });
          setLogs(prev => [
            createLog("user", `You drew [${drawnTile[0]}|${drawnTile[1]}] from boneyard.`, "draw"),
            ...prev
          ]);
        } else {
          nextHand = [...aiHand, drawnTile];
          setAiHand(nextHand);
          logInternalEvent("draw", "ai", { tile: drawnTile });
          setLogs(prev => [
            createLog("ai", `Tactical AI has no plays and draws a tile.`, "draw"),
            ...prev
          ]);
        }
        setBoneyard(nextBoneyard);

        setNoPlayState(prev => ({ ...prev, drawnTile }));
        return;
      }

      const drawnTile = noPlayState.drawnTile;
      const ends2D = getOpenEnds2D(placedTiles);
      const playability = evaluatePlayability2D(drawnTile, ends2D);
      const isPlayable = playability.left || playability.right || playability.top || playability.bottom || placedTiles.length === 0;

      const delay = GAME_CONFIG.disableAnimations ? 0 : 1500;
      const timer = setTimeout(() => {
        if (isPlayable) {
          setNoPlayState({ active: false, player, step: "idle", drawnTile: null });
          if (player === "user") {
            setSelectedTile(drawnTile);
          }
        } else {
          if (boneyard.length > 0) {
            if (player === "user") {
              setNoPlayState(prev => ({ ...prev, step: "await_user_draw", drawnTile: null }));
            } else {
              setNoPlayState(prev => ({ ...prev, step: "draw", drawnTile: null }));
            }
          } else {
            setNoPlayState(prev => ({ ...prev, step: "pass_toast", drawnTile: null }));
          }
        }
      }, delay);
      return () => clearTimeout(timer);
    }

    if (step === "pass_toast") {
      const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.noPlayPassToast;
      const timer = setTimeout(() => {
        logInternalEvent("pass", player);
        if (player === "user") {
          setLogs(prev => [createLog("user", "You had no plays and passed your turn.", "pass"), ...prev]);
          const blocked = checkAndTriggerBlockedRound(placedTiles, userHand, aiHand);
          if (!blocked) {
            setCurrentPlayer("ai");
          }
        } else {
          setLogs(prev => [createLog("ai", "Tactical AI has no options and passes turn.", "pass"), ...prev]);
          const blocked = checkAndTriggerBlockedRound(placedTiles, userHand, aiHand);
          if (!blocked) {
            setCurrentPlayer("user");
          }
        }
        setNoPlayState({ active: false, player, step: "idle", drawnTile: null });
      }, delay);
      return () => clearTimeout(timer);
    }
  }, [noPlayState, boneyard, userHand, aiHand, placedTiles, gameMode]);

  // Synchronisation progressive des scores visuels (Fives plays & catch-up)
  useEffect(() => {
    if (tallyAnimation.active) return; // Let tallyAnimation drive it

    if (GAME_CONFIG.disableAnimations) {
      setVisualScoreUser(scoreUser);
      setVisualScoreAi(scoreAi);
      return;
    }

    const timer = setTimeout(() => {
      if (visualScoreUser < scoreUser) {
        if (scoreUser - visualScoreUser > 50) {
          setVisualScoreUser(scoreUser); // jump on large differences (e.g. load game)
        } else {
          setVisualScoreUser(prev => Math.min(scoreUser, prev + 5));
        }
      } else if (visualScoreUser > scoreUser) {
        setVisualScoreUser(scoreUser); // jump on decrease
      }

      if (visualScoreAi < scoreAi) {
        if (scoreAi - visualScoreAi > 50) {
          setVisualScoreAi(scoreAi);
        } else {
          setVisualScoreAi(prev => Math.min(scoreAi, prev + 5));
        }
      } else if (visualScoreAi > scoreAi) {
        setVisualScoreAi(scoreAi);
      }
    }, 150);

    return () => clearTimeout(timer);
  }, [scoreUser, scoreAi, visualScoreUser, visualScoreAi, tallyAnimation.active]);

  // Moteur de transition de l'animation de décompte progressif des points
  useEffect(() => {
    if (!tallyAnimation.active) return;

    const { phase, pipCounter, roundPoints, winner, currentVisualScoreUser, currentVisualScoreAi, targetVisualScoreUser, targetVisualScoreAi } = tallyAnimation;

    if (phase === "pip_counting") {
      const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.scoreCountTick;
      const timer = setTimeout(() => {
        if (pipCounter > 0) {
          setTallyAnimation(prev => ({
            ...prev,
            pipCounter: prev.pipCounter - 1,
            roundPoints: prev.roundPoints + 1
          }));
        } else {
          setTallyAnimation(prev => ({
            ...prev,
            phase: "rounding"
          }));
        }
      }, delay);
      return () => clearTimeout(timer);
    }

    if (phase === "rounding") {
      const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.scoreRoundingReveal;
      const timer = setTimeout(() => {
        const rounded = ScoreEngine.roundToNearestFive(roundPoints);
        setTallyAnimation(prev => ({
          ...prev,
          roundPoints: rounded,
          phase: "score_incrementing"
        }));
      }, delay);
      return () => clearTimeout(timer);
    }

    if (phase === "score_incrementing") {
      const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.scoreWinnerIncrement;
      const timer = setTimeout(() => {
        let nextUser = currentVisualScoreUser;
        let nextAi = currentVisualScoreAi;
        let finished = true;

        if (winner === "user" && currentVisualScoreUser < targetVisualScoreUser) {
          nextUser = Math.min(targetVisualScoreUser, currentVisualScoreUser + 5);
          setVisualScoreUser(nextUser);
          finished = nextUser === targetVisualScoreUser;
        } else if (winner === "ai" && currentVisualScoreAi < targetVisualScoreAi) {
          nextAi = Math.min(targetVisualScoreAi, currentVisualScoreAi + 5);
          setVisualScoreAi(nextAi);
          finished = nextAi === targetVisualScoreAi;
        }

        if (finished) {
          setTallyAnimation(prev => ({
            ...prev,
            currentVisualScoreUser: nextUser,
            currentVisualScoreAi: nextAi,
            phase: "done"
          }));
        } else {
          setTallyAnimation(prev => ({
            ...prev,
            currentVisualScoreUser: nextUser,
            currentVisualScoreAi: nextAi
          }));
        }
      }, delay);
      return () => clearTimeout(timer);
    }

    if (phase === "done") {
      setTallyAnimation(prev => ({ ...prev, active: false }));
    }
  }, [tallyAnimation]);

  // Drag and drop pointer-based state (Feature 1)
  const [draggedTile, setDraggedTile] = useState<Tile | null>(null);
  const [dragPosition, setDragPosition] = useState<{ x: number; y: number } | null>(null);
  const [dragStartOffset, setDragStartOffset] = useState<{ x: number; y: number } | null>(null);
  const [hoveredSlotSide, setHoveredSlotSide] = useState<"left" | "right" | "top" | "bottom" | null>(null);
  const [hoveredSlotIsVertical, setHoveredSlotIsVertical] = useState<boolean>(true);
  const [snappedTileValues, setSnappedTileValues] = useState<Tile | null>(null);

  const [deviceId] = useState<string>(() => {
    let devId = localStorage.getItem("maestro_domino_device_id");
    if (!devId) {
      devId = Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15);
      localStorage.setItem("maestro_domino_device_id", devId);
    }
    return devId;
  });

  const fetchUserProfile = async (userId: string) => {
    if (!supabase) return;
    try {
      const { data, error } = await supabase
        .from("profiles")
        .select("*")
        .eq("id", userId)
        .single();
      
      if (error) {
        if (error.code === 'PGRST116') {
          console.log("Profile not found in public.profiles. Attempting client-side auto-creation...");
          const usernameMeta = currentUser?.user_metadata?.username || `User_${userId.substring(0, 8)}`;
          const avatarMeta = currentUser?.user_metadata?.avatar_url || null;
          const availabilityMeta = currentUser?.user_metadata?.availability || null;
          const onboardingCompletedMeta = availabilityMeta ? true : false;
          
          const { data: insertedData, error: insertError } = await supabase
            .from("profiles")
            .insert([{
              id: userId,
              username: usernameMeta,
              avatar_url: avatarMeta,
              role: "player",
              is_banned: false,
              elo_rating: 1000,
              games_played: 0,
              games_won: 0,
              games_lost: 0,
              win_rate: 0,
              tournaments_won: 0,
              current_streak: 0,
              max_streak: 0,
              availability: availabilityMeta,
              onboarding_completed: onboardingCompletedMeta
            }])
            .select()
            .single();

          if (insertError) {
            console.error("Failed to auto-create user profile:", insertError);
            return;
          }
          
          if (insertedData) {
            setUserProfile(insertedData);
          }
          return;
        }
        console.error("Error fetching user profile:", error);
        return;
      }
      
      if (data) {
        if (data.is_banned) {
          alert("Votre compte a été banni de la plateforme par un administrateur.");
          await supabase.auth.signOut();
          setCurrentUser(null);
          setUserProfile(null);
          setCurrentScreen("home");
          return;
        }

        // Force onboarding if any mandatory field is missing
        const isLegacyIncomplete = !data.country_code || !data.preferred_language || !data.timezone || data.onboarding_completed !== true;
        if (isLegacyIncomplete) {
          setUserProfile({
            ...data,
            onboarding_completed: false
          });
        } else {
          setUserProfile(data);
        }
      }
    } catch (err) {
      console.error("Failed to fetch user profile:", err);
    }
  };

  useEffect(() => {
    if (currentUser) {
      fetchUserProfile(currentUser.id);
      
      const pendingRoom = localStorage.getItem("pending_invite_room");
      if (pendingRoom) {
        localStorage.removeItem("pending_invite_room");
        setActiveOnlineRoomId(pendingRoom);
        setCurrentScreen("online-game");
      }
    } else {
      setUserProfile(null);
    }
  }, [currentUser]);

  useEffect(() => {
    if (currentUser && (currentScreen === "home" || currentScreen === "admin-dashboard" || currentScreen === "tournament-lobby")) {
      fetchUserProfile(currentUser.id);
    }
  }, [currentScreen]);

  const fetchHistoryFromSupabase = async (currentDeviceId: string) => {
    if (!supabase) return;

    try {
      const { data, error } = await supabase
        .from("match_history")
        .select("*")
        .eq("device_id", currentDeviceId)
        .order("created_at", { ascending: false });

      if (error) {
        console.error("Error fetching match history from Supabase:", error);
        return;
      }

      if (data && data.length > 0) {
        const formattedHistory: MatchHistoryEntry[] = data.map((d: any) => ({
          id: d.id,
          date: d.created_at_str || new Date(d.created_at).toLocaleString(),
          gameType: d.game_type,
          targetScore: d.target_score,
          scoreUser: d.score_user,
          scoreAi: d.score_ai,
          winner: d.winner
        }));
        setMatchHistory(formattedHistory);
        localStorage.setItem("maestro_domino_history", JSON.stringify(formattedHistory));
      }
    } catch (err) {
      console.error("Failed to connect to Supabase database:", err);
    }
  };

  const saveMatchToSupabase = async (entry: MatchHistoryEntry, currentDeviceId: string) => {
    if (!supabase) return;

    try {
      const { error } = await supabase
        .from("match_history")
        .insert([{
          id: entry.id,
          created_at_str: entry.date,
          device_id: currentDeviceId,
          game_type: entry.gameType,
          target_score: entry.targetScore,
          score_user: entry.scoreUser,
          score_ai: entry.scoreAi,
          winner: entry.winner
        }]);

      if (error) {
        console.error("Error saving match to Supabase:", error);
      } else {
        console.log("Match successfully saved to Supabase cloud database.");
      }
    } catch (err) {
      console.error("Network error saving match to Supabase:", err);
    }
  };

  const triggerPointsFlash = (player: "user" | "ai", pts: number, roundWinner?: "user" | "ai" | "draw") => {
    if (player === "user") {
      setLastPointsUser(pts > 0 ? pts : null);
      if (pts > 0) setTimeout(() => setLastPointsUser(null), 2200);
    } else {
      setLastPointsAi(pts > 0 ? pts : null);
      if (pts > 0) setTimeout(() => setLastPointsAi(null), 2200);
    }
    // Central toast — always shown when a round ends
    if (roundWinner !== undefined) {
      setCenterToast({ winner: roundWinner, points: pts });
      setTimeout(() => setCenterToast(null), 3500);
    }
  };

  // Monitor Supabase Auth & Active Online Room Recovery
  useEffect(() => {
    if (!supabase) return;

    // 1. Check current session
    supabase.auth.getSession().then(({ data: { session } }) => {
      setCurrentUser(session?.user ?? null);
      if (session?.user) {
        const savedRoomId = localStorage.getItem("active_online_room_id");
        if (savedRoomId) {
          setActiveOnlineRoomId(savedRoomId);
          // Check if room is active/waiting in db
          supabase.from("rooms").select("status").eq("id", savedRoomId).single().then(({ data }) => {
            if (data && (data.status === "active" || data.status === "waiting")) {
              setCurrentScreen("online-game");
            } else {
              localStorage.removeItem("active_online_room_id");
              setCurrentScreen("home");
            }
          });
        } else {
          setCurrentScreen("home");
        }
      } else {
        setCurrentScreen("auth");
      }
    });

    // 2. Listen to auth state changes
    const { data: { subscription } } = supabase.auth.onAuthStateChange((event, session) => {
      setCurrentUser(session?.user ?? null);
      if (session?.user) {
        setCurrentScreen((prev) => (prev === "auth" ? "home" : prev));
      } else {
        setCurrentScreen("auth");
        setActiveOnlineRoomId(null);
        localStorage.removeItem("active_online_room_id");
      }
      if (event === "PASSWORD_RECOVERY") {
        setAuthInitialView("reset-password");
        setCurrentScreen("auth");
      }
    });

    return () => subscription.unsubscribe();
  }, []);

  // Load data on mount
  useEffect(() => {
    const savedConfig = localStorage.getItem("maestro_domino_admin_config");
    if (savedConfig) {
      try {
        const parsed = JSON.parse(savedConfig);
        setAdminConfig(parsed);
        setTargetScore(parsed.defaultTarget ?? 100);
      } catch (e) {
        console.error(e);
      }
    }

    const fetchSystemSettings = async () => {
      if (!supabase) return;
      try {
        const { data, error } = await supabase
          .from("system_settings")
          .select("value")
          .eq("key", "gameplay_config")
          .maybeSingle();
        if (data && data.value) {
          const config = data.value;
          if (!config.allow_custom_match_rules) {
            setMatchMode(config.default_match_mode || "first_to");
            setTargetScore(config.default_target_score || 100);
            setTargetManches(config.default_target_manches || 3);
          } else {
            const hasLocalState = localStorage.getItem("maestro_domino_state");
            if (!hasLocalState) {
              setMatchMode(config.default_match_mode || "first_to");
              setTargetScore(config.default_target_score || 100);
              setTargetManches(config.default_target_manches || 3);
            }
          }
        }
      } catch (err) {
        console.error("Error fetching system settings:", err);
      }
    };
    fetchSystemSettings();

    let settingsSubscription: any = null;
    if (supabase) {
      settingsSubscription = supabase
        .channel("system-settings-changes")
        .on(
          "postgres_changes",
          { event: "*", schema: "public", table: "system_settings", filter: "key=eq.gameplay_config" },
          (payload: any) => {
            if (payload.new && (payload.new as any).value) {
              const config = (payload.new as any).value;
              if (!config.allow_custom_match_rules) {
                setMatchMode(config.default_match_mode || "first_to");
                setTargetScore(config.default_target_score || 100);
                setTargetManches(config.default_target_manches || 3);
              }
            }
          }
        )
        .subscribe();
    }
    const savedHistory = localStorage.getItem("maestro_domino_history");
    if (savedHistory) {
      try {
        setMatchHistory(JSON.parse(savedHistory));
      } catch (e) {
        console.error(e);
      }
    }

    const savedDealOption = localStorage.getItem("maestro_domino_deal_option");
    if (savedDealOption === "manual" || savedDealOption === "auto") {
      setDealOption(savedDealOption);
    }

    // Trigger Supabase fetch
    let devId = localStorage.getItem("maestro_domino_device_id");
    if (devId) {
      fetchHistoryFromSupabase(devId);
    }

    // Handle URL parameters for invitations
    const params = new URLSearchParams(window.location.search);
    const inviteRoomId = params.get("invite");
    if (inviteRoomId) {
      localStorage.setItem("pending_invite_room", inviteRoomId);
      window.history.replaceState({}, document.title, window.location.pathname);
    }

    const savedState = localStorage.getItem("maestro_domino_state");
    if (savedState) {
      try {
        const parsed = JSON.parse(savedState);
        setScoreUser(parsed.scoreUser ?? 0);
        setScoreAi(parsed.scoreAi ?? 0);
        setRoundsWonUser(parsed.roundsWonUser ?? 0);
        setRoundsWonAi(parsed.roundsWonAi ?? 0);
        setUserHand(parsed.userHand ?? []);
        setAiHand(parsed.aiHand ?? []);
        setBoneyard(parsed.boneyard ?? []);
        setPlacedTiles(parsed.placedTiles ?? []);
        setCurrentPlayer(parsed.currentPlayer ?? "user");
        setMatchStatus(parsed.matchStatus ?? "not-started");
        setRound(parsed.round ?? 1);
        setWinner(parsed.winner ?? null);
        setTargetScore(parsed.targetScore ?? 100);
        setGameType("individual");
        setGameMode("all-fives");
        setMatchWinner(parsed.matchWinner ?? null);
        setIsDealing(parsed.isDealing ?? false);
        setNextRoundStarter(parsed.nextRoundStarter ?? null);

        const modeVal = parsed.matchMode ?? "first_to";
        const targetVal = parsed.targetManches ?? 3;
        const historyVal = parsed.roundsHistory ?? [];
        setMatchMode(modeVal);
        setTargetManches(targetVal);
        setRoundsHistory(historyVal);

        const players = [
          { id: "user", name: "Jean François" },
          { id: "ai", name: "Bot Op" }
        ];
        const settings = {
          targetManches: targetVal,
          targetScorePerManche: parsed.targetScore ?? 100,
          gameMode: "all-fives",
          matchMode: modeVal
        };
        const manager = new MatchManager(players, settings);
        manager.getMatchState().roundsWon["user"] = parsed.roundsWonUser ?? 0;
        manager.getMatchState().roundsWon["ai"] = parsed.roundsWonAi ?? 0;
        manager.getMatchState().roundsHistory = historyVal;
        matchManagerRef.current = manager;
        setMatchState(manager.getMatchState());

        manager.subscribe("ROUND_COMPLETED", ({ roundResult, matchState: nextState }) => {
          setMatchState(nextState);
          setRoundsWonUser(nextState.roundsWon["user"] || 0);
          setRoundsWonAi(nextState.roundsWon["ai"] || 0);
          setRoundsHistory(nextState.roundsHistory);
        });

        // Feature 5 recovery helper: if we loaded in "revealing" state, resolve scoring immediately to prevent soft lock.
        const savedStatus = parsed.matchStatus ?? "not-started";
        if (savedStatus === "revealing") {
          let result: "user" | "ai" | "blocked" = "blocked";
          if ((parsed.userHand ?? []).length === 0) result = "user";
          else if ((parsed.aiHand ?? []).length === 0) result = "ai";
          
          const userPipsSum = ScoreEngine.calculateRemainingTiles(parsed.userHand ?? []);
          const aiPipsSum = ScoreEngine.calculateRemainingTiles(parsed.aiHand ?? []);

          let roundWinner: "user" | "ai" | "draw" = "draw";
          let scoreGained = 0;
          let endMessage = "";
          let tieBreakExplained = "";

          if (result === "user") {
            roundWinner = "user";
            const exactPips = aiPipsSum;
            scoreGained = ScoreEngine.roundToNearestFive(exactPips);
            setScoreUser((parsed.scoreUser ?? 0) + scoreGained);
            endMessage = `🎉 Domino! You cleared your hand. You win Round ${parsed.round ?? 1} and score ${scoreGained} points (opp. hand pips: ${exactPips} rounded to nearest 5) from AI's remaining hand.`;
          } else if (result === "ai") {
            roundWinner = "ai";
            const exactPips = userPipsSum;
            scoreGained = ScoreEngine.roundToNearestFive(exactPips);
            setScoreAi((parsed.scoreAi ?? 0) + scoreGained);
            endMessage = `🤖 AI declared Domino! You lose Round ${parsed.round ?? 1}. AI scores ${scoreGained} points (your hand pips: ${exactPips} rounded to nearest 5) from your remaining hand.`;
          } else {
            // Blocked Game tie-breaker
            let userPipsVal = userPipsSum;
            let aiPipsVal = aiPipsSum;
            if (userPipsVal < aiPipsVal) {
              roundWinner = "user";
              const exactDiff = aiPipsVal - userPipsVal;
              scoreGained = ScoreEngine.roundToNearestFive(exactDiff);
              setScoreUser((parsed.scoreUser ?? 0) + scoreGained);
              endMessage = `⚠️ Game Blocked! You have fewer hand pips (${userPipsVal} vs ${aiPipsVal}). You win Round ${parsed.round ?? 1} and get ${scoreGained} points (difference: ${exactDiff} rounded to nearest 5)!`;
              tieBreakExplained = `You have fewer remaining hand pips (${userPipsVal} vs ${aiPipsVal}).`;
            } else if (aiPipsVal < userPipsVal) {
              roundWinner = "ai";
              const exactDiff = userPipsVal - aiPipsVal;
              scoreGained = ScoreEngine.roundToNearestFive(exactDiff);
              setScoreAi((parsed.scoreAi ?? 0) + scoreGained);
              endMessage = `⚠️ Game Blocked! AI has fewer hand pips (${aiPipsVal} vs ${userPipsVal}). AI wins Round ${parsed.round ?? 1} and gets ${scoreGained} points (difference: ${exactDiff} rounded to nearest 5).`;
              tieBreakExplained = `AI has fewer remaining hand pips (${aiPipsVal} vs ${userPipsVal}).`;
            } else {
              // Ties
              let highestDoubleUser = -1;
              let highestDoubleAi = -1;
              (parsed.userHand ?? []).forEach((t: Tile) => {
                if (t[0] === t[1] && t[0] > highestDoubleUser) highestDoubleUser = t[0];
              });
              (parsed.aiHand ?? []).forEach((t: Tile) => {
                if (t[0] === t[1] && t[0] > highestDoubleAi) highestDoubleAi = t[0];
              });

              if (highestDoubleUser !== -1 || highestDoubleAi !== -1) {
                if (highestDoubleUser > highestDoubleAi) {
                  roundWinner = "user";
                  tieBreakExplained = `Equal pips (${userPipsVal} each). Tie-breaker: You hold the highest double [${highestDoubleUser}|${highestDoubleUser}] vs AI's ${highestDoubleAi !== -1 ? `[${highestDoubleAi}|${highestDoubleAi}]` : "none"}.`;
                } else {
                  roundWinner = "ai";
                  tieBreakExplained = `Equal pips (${userPipsVal} each). Tie-breaker: AI holds the highest double [${highestDoubleAi}|${highestDoubleAi}] vs your ${highestDoubleUser !== -1 ? `[${highestDoubleUser}|${highestDoubleUser}]` : "none"}.`;
                }
              } else {
                let heaviestUser = -1;
                let heaviestAi = -1;
                (parsed.userHand ?? []).forEach((t: Tile) => { if (t[0] + t[1] > heaviestUser) heaviestUser = t[0] + t[1]; });
                (parsed.aiHand ?? []).forEach((t: Tile) => { if (t[0] + t[1] > heaviestAi) heaviestAi = t[0] + t[1]; });

                if (heaviestUser > heaviestAi) {
                  roundWinner = "user";
                  const userHeaviestDomino = (parsed.userHand ?? []).find((t: Tile) => t[0] + t[1] === heaviestUser);
                  tieBreakExplained = `Equal pips (${userPipsVal} each) & no doubles. Tie-breaker: You hold the heaviest single domino [${userHeaviestDomino?.[0]}|${userHeaviestDomino?.[1]}] (${heaviestUser} pips) vs AI's ${heaviestAi} pips.`;
                } else if (heaviestAi > heaviestUser) {
                  roundWinner = "ai";
                  const aiHeaviestDomino = (parsed.aiHand ?? []).find((t: Tile) => t[0] + t[1] === heaviestAi);
                  tieBreakExplained = `Equal pips (${userPipsVal} each) & no doubles. Tie-breaker: AI holds the heaviest single domino [${aiHeaviestDomino?.[0]}|${aiHeaviestDomino?.[1]}] (${heaviestAi} pips) vs your ${heaviestUser} pips.`;
                } else {
                  let maxUser = -1;
                  let maxAi = -1;
                  (parsed.userHand ?? []).forEach((t: Tile) => { const m = Math.max(t[0], t[1]); if (m > maxUser) maxUser = m; });
                  (parsed.aiHand ?? []).forEach((t: Tile) => { const m = Math.max(t[0], t[1]); if (m > maxAi) maxAi = m; });
                  if (maxUser > maxAi) {
                    roundWinner = "user";
                    const userMaxDomino = (parsed.userHand ?? []).find((t: Tile) => Math.max(t[0], t[1]) === maxUser);
                    tieBreakExplained = `Equal pips (${userPipsVal} each), same heaviest domino sum & no doubles. Tie-breaker: You hold the domino with the highest single pip ${maxUser} [${userMaxDomino?.[0]}|${userMaxDomino?.[1]}].`;
                  } else {
                    roundWinner = "ai";
                    const aiMaxDomino = (parsed.aiHand ?? []).find((t: Tile) => Math.max(t[0], t[1]) === maxAi);
                    tieBreakExplained = `Equal pips (${userPipsVal} each), same heaviest domino sum & no doubles. Tie-breaker: AI holds the domino with the highest single pip ${maxAi} [${aiMaxDomino?.[0]}|${aiMaxDomino?.[1]}].`;
                  }
                }
              }
              scoreGained = 0;
              endMessage = `⚠️ Game Blocked! Equal pips (${userPipsVal} pips each). Tie-breaker resolved: ${roundWinner === "user" ? "You hold the highest double/domino and win" : "AI holds the highest double/domino and wins"} Round ${parsed.round ?? 1}. No points awarded.`;
            }
          }

          setWinner(roundWinner);
          setMatchStatus(result === "blocked" ? "blocked" : "domino");
          setRevealPhase("scoring");
          setLogs(prev => [
            {
              id: Math.random().toString(),
              timestamp: new Date().toLocaleTimeString(),
              player: "system",
              message: endMessage,
              type: "win" as const
            },
            ...prev
          ]);
          setRound((parsed.round ?? 1) + 1);

          setRevealData({
            result,
            finalBoard: parsed.placedTiles ?? [],
            userHand: [...(parsed.userHand ?? [])],
            aiHand: [...(parsed.aiHand ?? [])],
            userPipsSum,
            aiPipsSum,
            roundWinner,
            tieBreakExplained,
            winningTileId: result !== "blocked" && (parsed.placedTiles ?? []).length > 0
              ? parsed.placedTiles[(parsed.placedTiles ?? []).length - 1].id
              : null
          });
        }
      } catch (e) {
        console.error("Failed to load domino state:", e);
      }
    }

    return () => {
      if (settingsSubscription) {
        settingsSubscription.unsubscribe();
      }
    };
  }, []);

  // Cleanup RAF on unmount
  useEffect(() => {
    return () => {
      if (dragRafRef.current) {
        cancelAnimationFrame(dragRafRef.current);
      }
    };
  }, []);

  // Auto-save game state on change
  useEffect(() => {
    if (matchStatus === "not-started" && !matchWinner) {
      localStorage.removeItem("maestro_domino_state");
      return;
    }
    const state = {
      scoreUser,
      scoreAi,
      userHand,
      aiHand,
      boneyard,
      placedTiles,
      currentPlayer,
      matchStatus,
      round,
      winner,
      targetScore,
      gameType,
      gameMode,
      matchWinner,
      isDealing,
      nextRoundStarter,
      roundsWonUser,
      roundsWonAi,
      matchMode,
      targetManches,
      roundsHistory
    };
    localStorage.setItem("maestro_domino_state", JSON.stringify(state));
  }, [scoreUser, scoreAi, userHand, aiHand, boneyard, placedTiles, currentPlayer, matchStatus, round, winner, targetScore, gameType, gameMode, matchWinner, isDealing, nextRoundStarter, roundsWonUser, roundsWonAi, matchMode, targetManches, roundsHistory]);

  // Start the next round of the match (next manche)
  const handleStartNextManche = () => {
    const prevRoundWinner = winner;
    setScoreUser(0);
    setScoreAi(0);
    setRound(1);
    setMancheWinner(null);
    setWinner(null);
    setRevealPhase("none");
    setRevealData(null);
    
    let resolvedNextStarter: "user" | "ai" | null = null;
    if (prevRoundWinner === "user" || prevRoundWinner === "ai") {
      resolvedNextStarter = prevRoundWinner;
      setNextRoundStarter(prevRoundWinner);
    } else {
      setNextRoundStarter(null);
    }
    
    matchEndPendingRef.current = false;

    if (dealOption === "auto") {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      const uHand = fullSet.slice(0, 7);
      const aHand = fullSet.slice(7, 14);
      const remainingBoneyard = fullSet.slice(14);

      setPlacedTiles([]);
      setUserHand(uHand);
      setAiHand(aHand);
      setBoneyard(remainingBoneyard);
      setSelectedTile(null);
      setIsDealing(false);
      setCurrentScreen("game");
      setMatchStatus("ongoing");

      determineStarterAndInitRound(uHand, aHand, resolvedNextStarter, 1);
    } else {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      setPlacedTiles([]);
      setUserHand([]);
      setAiHand([]);
      setBoneyard(fullSet);
      setSelectedTile(null);
      setIsDealing(true);
      setMatchStatus("ongoing");
      setCurrentPlayer("user");
    }
  };

  // Match winner detection check (Round/Manche end detector)
  useEffect(() => {
    if (matchStatus === "ongoing" || matchStatus === "domino" || matchStatus === "blocked") {
      if (matchEndPendingRef.current) return;

      const handleVictory = (winnerSide: "user" | "ai") => {
        matchEndPendingRef.current = true;
        
        // Delay the round end pop-up by 3.5 seconds so the round end UI can be seen
        setTimeout(() => {
          if (!matchManagerRef.current) return;
          
          matchManagerRef.current.commitRound(winnerSide, { user: scoreUser, ai: scoreAi });
          const state = matchManagerRef.current.getMatchState();

          if (state.isMatchFinished) {
            setMatchWinner(winnerSide);
            setMatchStatus("not-started");
            const newEntry: MatchHistoryEntry = {
              id: generateId(),
              date: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'}),
              gameType,
              targetScore,
              scoreUser, 
              scoreAi,
              winner: winnerSide
            };
            setMatchHistory(prev => {
              const nextHistory = [newEntry, ...prev];
              localStorage.setItem("maestro_domino_history", JSON.stringify(nextHistory));
              return nextHistory;
            });
            saveMatchToSupabase(newEntry, deviceId);
          } else {
            setMancheWinner(winnerSide);
            setMatchStatus("not-started");
          }
        }, 3500);
      };

      if (ScoreEngine.checkVictory(scoreUser, targetScore) && !matchWinner) {
        handleVictory("user");
      } else if (ScoreEngine.checkVictory(scoreAi, targetScore) && !matchWinner) {
        handleVictory("ai");
      }
    }
  }, [scoreUser, scoreAi, targetScore, matchStatus, matchWinner, gameType, deviceId]);

  // Automatically start the next round after 4s when a hand ends (if target score not reached)
  useEffect(() => {
    if (winner && !matchWinner && !tallyAnimation.active) {
      // Check if this round ending also triggers the end of a manche
      const isMancheEnded = ScoreEngine.checkVictory(scoreUser, targetScore) || ScoreEngine.checkVictory(scoreAi, targetScore);
      if (isMancheEnded) return;

      const timer = setTimeout(() => {
        ScoreEngine.startNextRound(handleStartGame);
      }, 4000);
      return () => clearTimeout(timer);
    }
  }, [winner, matchWinner, tallyAnimation.active, scoreUser, scoreAi, targetScore]);

  // Match countdown timer (Solo mode)
  useEffect(() => {
    if (matchWinner) {
      setMatchCountdown(10);
    } else {
      setMatchCountdown(null);
    }
  }, [matchWinner]);

  useEffect(() => {
    if (matchCountdown === null) return;
    if (matchCountdown <= 0) {
      handleStartNewGame();
      setMatchCountdown(null);
      return;
    }

    const timer = setTimeout(() => {
      setMatchCountdown(prev => (prev !== null ? prev - 1 : null));
    }, 1000);

    return () => clearTimeout(timer);
  }, [matchCountdown]);

  // Manche countdown timer (Solo mode)
  useEffect(() => {
    if (mancheWinner && !matchWinner) {
      setMancheCountdown(10);
    } else {
      setMancheCountdown(null);
    }
  }, [mancheWinner, matchWinner]);

  useEffect(() => {
    if (mancheCountdown === null) return;
    if (mancheCountdown <= 0) {
      handleStartNextManche();
      setMancheCountdown(null);
      return;
    }

    const timer = setTimeout(() => {
      setMancheCountdown(prev => (prev !== null ? prev - 1 : null));
    }, 1000);

    return () => clearTimeout(timer);
  }, [mancheCountdown]);

  // Trigger fireworks confetti when the user wins the match
  useEffect(() => {
    if (matchWinner === "user") {
      const duration = 3000;
      const animationEnd = Date.now() + duration;
      const defaults = { startVelocity: 30, spread: 360, ticks: 60, zIndex: 999999 };

      const randomInRange = (min: number, max: number) => Math.random() * (max - min) + min;

      const interval: any = setInterval(function() {
        const timeLeft = animationEnd - Date.now();

        if (timeLeft <= 0) {
          return clearInterval(interval);
        }

        const particleCount = 50 * (timeLeft / duration);
        // since particles fall down, start a bit higher than random
        confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.1, 0.3), y: Math.random() - 0.2 } }));
        confetti(Object.assign({}, defaults, { particleCount, origin: { x: randomInRange(0.7, 0.9), y: Math.random() - 0.2 } }));
      }, 250);
    }
  }, [matchWinner]);

  // 2. Derive Open Ends & Live General Strategy Metrics
  const openEnds2D = getOpenEnds2D(placedTiles);
  const openEnds = getOpenEnds(placedTiles);
  const [openLeft, openRight] = openEnds;

  // Run the analysis engine for the user
  const currentAnalysis = analyzeGameState(userHand, placedTiles, boneyard.length, gameMode, openingForcedTile);
  
  // Check if player has playable tiles in hand
  const userCanPlay = hasPlayableTile2D(userHand, openEnds2D) || (placedTiles.length === 0 && userHand.length > 0);

  // 3. Negotiate Turn / Deal Hand
  // Helper to determine starting player based on previous round winner or heaviest double/domino
  const determineStarterAndInitRound = (
    uHand: Tile[],
    aHand: Tile[],
    nextStarter: "user" | "ai" | null,
    currentRoundNum: number
  ) => {
    const initialLogs: GameLog[] = [];
    initialLogs.push(createLog("system", `Dealing complete! Round ${currentRoundNum} starts.`, "system"));

    const ruleResult = determineFirstPlayer(uHand, aHand, nextStarter);

    // If a specific tile (heaviest double) was determined, that player MUST play it first
    const forcedTile = ruleResult.tile; // non-null only when a double exists and determines the starter
    setOpeningForcedTile(forcedTile);

    initialLogs.push(createLog(
      ruleResult.starter,
      forcedTile
        ? `${ruleResult.starter === "user" ? "You start" : "AI starts"} — must play [${forcedTile[0]}|${forcedTile[1]}] first (${ruleResult.reason})`
        : `${ruleResult.starter === "user" ? "You start" : "AI starts"} (${ruleResult.reason})`,
      "system"
    ));

    setLogs(prev => [...initialLogs, ...prev]);
    setCurrentPlayer(ruleResult.starter);
  };

  const handleStartGame = () => {
    const prevRoundWinner = winner;
    setWinner(null);
    setRevealPhase("none");
    setRevealData(null);
    
    let resolvedNextStarter: "user" | "ai" | null = null;
    if (prevRoundWinner === "user" || prevRoundWinner === "ai") {
      resolvedNextStarter = prevRoundWinner;
      setNextRoundStarter(prevRoundWinner);
    } else {
      setNextRoundStarter(null);
    }

    if (dealOption === "auto") {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      const uHand = fullSet.slice(0, 7);
      const aHand = fullSet.slice(7, 14);
      const remainingBoneyard = fullSet.slice(14);

      setPlacedTiles([]);
      setUserHand(uHand);
      setAiHand(aHand);
      setBoneyard(remainingBoneyard);
      setSelectedTile(null);
      setIsDealing(false);
      setCurrentScreen("game");
      setMatchStatus("ongoing");

      determineStarterAndInitRound(uHand, aHand, resolvedNextStarter, round);
    } else {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      setPlacedTiles([]);
      setUserHand([]);
      setAiHand([]);
      setBoneyard(fullSet);
      setSelectedTile(null);
      setIsDealing(true);
      setCurrentScreen("game");
      setCurrentPlayer("user");
      setMatchStatus("ongoing");

      setLogs([
        createLog("system", `New Round ${round}: Draw 7 starting tiles. You draw first!`, "system")
      ]);
    }
  };

  const handleContinueGame = () => {
    setCurrentScreen("game");
  };

  // Helper function to handle playing a specific tile on a side
  const playTileForUser = (tile: Tile, side: "left" | "right" | "top" | "bottom") => {
    if (currentPlayer !== "user" || matchStatus !== "ongoing" || isProcessingPlayRef.current || matchEndPendingRef.current) return;
    isProcessingPlayRef.current = true;

    const playSide = (placedTiles.length === 0) ? "start" : side;
    logInternalEvent("play", "user", { tile, side: playSide });

    // Enforce opening forced tile rule: if the board is empty and a forced tile exists,
    // only that specific tile may be played as the first move.
    if (playSide === "start" && openingForcedTile !== null) {
      if (!(tile[0] === openingForcedTile[0] && tile[1] === openingForcedTile[1])) {
        setLogs(prev => [
          createLog("system", `Mouvement interdit : Vous devez obligatoirement jouer [${openingForcedTile[0]}|${openingForcedTile[1]}] pour commencer.`, "system"),
          ...prev
        ]);
        isProcessingPlayRef.current = false;
        return; // Block the play
      }
    }

    if (playSide !== "start") {
      const playability = evaluatePlayability2D(tile, openEnds2D);
      if (!playability[side]) {
        isProcessingPlayRef.current = false;
        return;
      }
    }

    // Clear the opening forced tile constraint after the first move
    if (playSide === "start") {
      setOpeningForcedTile(null);
    }

    // Remove tile from player hand
    const nextHand = userHand.filter(
      t => !(t[0] === tile[0] && t[1] === tile[1])
    );
    setUserHand(nextHand);

    // Get connection properties & rotation
    const rotation = getPlayedTileRotation2D(tile, playSide, openEnds2D);
    const newPlaced: PlacedTile = {
      id: generateId(),
      tile,
      connectedAs: rotation,
      isDouble: tile[0] === tile[1],
      playedAt: playSide,
    };

    const nextPlacedTiles = [...placedTiles, newPlaced];

    setPlacedTiles(nextPlacedTiles);
    setConsecutivePasses(0);
    playTilePlacementSound();
    setSelectedTile(null);

    // Log action
    const sideMessage = playSide === "start" ? "" : ` on the ${playSide}`;
    let message = `You played [${tile[0]}|${tile[1]}]${sideMessage}.`;
    
    // Check All-Fives Scoring
    let roundPoints = 0;
    if (gameMode === "all-fives") {
      const sum = ScoreEngine.calculateBoardScore(nextPlacedTiles);
      const points = ScoreEngine.calculateMultipleOfFive(sum);
      
      // Debug output
      ScoreEngine.printScoreDebug(nextPlacedTiles, sum, points);

      if (points > 0) {
        roundPoints = points;
        setScoreUser(prev => ScoreEngine.addPlayerScore(prev, points));
        triggerPointsFlash("user", points);
        message += ` 🎯 Scores ${points} Fives points! (Ends sum: ${sum})`;

        // Trigger center board popup
        const nextLayouts = computeTileLayouts(nextPlacedTiles);
        const lastTileLay = nextLayouts[newPlaced.id];
        if (lastTileLay) {
          setCenterScorePopup({
            points,
            gridX: lastTileLay.gridX,
            gridY: lastTileLay.gridY
          });
          setTimeout(() => setCenterScorePopup(null), 1500);
        }
      }
    }
    setLogs(prev => [createLog("user", message, roundPoints > 0 ? "score" : "play"), ...prev]);

    // Check Domino (Round Ends - Win)
    if (nextHand.length === 0) {
      handleRoundEnd("user", nextPlacedTiles, [], aiHand);
      isProcessingPlayRef.current = false;
      return;
    }

    // Check Block state across remaining hands, or handover turn
    const blocked = checkAndTriggerBlockedRound(nextPlacedTiles, nextHand, aiHand);
    if (!blocked) {
      setCurrentPlayer("ai");
    }
    
    // Release lock at the end of the synchronous execution
    isProcessingPlayRef.current = false;
  };

  // 4. Action: Player plays a tile (with 2D branching)
  const handlePlayTile = (side: "left" | "right" | "top" | "bottom") => {
    if (!selectedTile) return;
    playTileForUser(selectedTile, side);
  };

  const updateDragVisuals = () => {
    if (!dragStartPointerRef.current || !latestPointerPosRef.current) {
      dragRafRef.current = null;
      return;
    }

    const { x: startX, y: startY } = dragStartPointerRef.current;
    const { x: curX, y: curY } = latestPointerPosRef.current;

    // Check activation threshold (8px — comfortable for touch & mouse)
    if (!dragActiveRef.current) {
      const dx = curX - startX;
      const dy = curY - startY;
      const dist = Math.sqrt(dx * dx + dy * dy);
      if (dist >= 8) {
        dragActiveRef.current = true;
        setDraggedTile(activeDragTileRef.current);
        setSelectedTile(activeDragTileRef.current);
        // CRITICAL FIX: set dragStartOffset state so floating tile becomes visible
        setDragStartOffset(dragStartOffsetRef.current);
      }
    }

    if (dragActiveRef.current && floatingTileRef.current && dragStartOffsetRef.current) {
      // Center the floating tile under the pointer (better UX, especially on mobile)
      const TILE_W = 44;
      const TILE_H = 88;
      const rawLeft = curX - TILE_W / 2;
      const rawTop  = curY - TILE_H / 2 - 10; // slightly above finger so target is visible

      // Find closest slot
      const slots = document.querySelectorAll("[data-slot-side]");
      let closestSlot: Element | null = null;
      let minDistance = Infinity;
      let closestRect: DOMRect | null = null;

      slots.forEach(slot => {
        const rect = slot.getBoundingClientRect();
        const cx = rect.left + rect.width / 2;
        const cy = rect.top + rect.height / 2;
        const dx = curX - cx;
        const dy = curY - cy;
        const dist = Math.sqrt(dx * dx + dy * dy);
        if (dist < minDistance) {
          minDistance = dist;
          closestSlot = slot;
          closestRect = rect;
        }
      });

      // Magnetic Snapping with Hysteresis — larger zone for easier placement
      const snapThreshold = 160;
      const hysteresis = 15;
      let finalLeft = rawLeft;
      let finalTop = rawTop;
      let nextHoverSide: "left" | "right" | "top" | "bottom" | null = null;
      let nextHoverIsVertical = true;
      let nextSnappedTileValues: Tile | null = null;

      const currentHoveredSide = hoveredSlotSideRef.current;
      
      // Find current hovered slot distance if it exists
      let currentHoveredDist = Infinity;
      let currentHoveredSlotElem: Element | null = null;
      let currentHoveredRect: DOMRect | null = null;

      if (currentHoveredSide) {
        currentHoveredSlotElem = document.querySelector(`[data-slot-side="${currentHoveredSide}"]`);
        if (currentHoveredSlotElem) {
          currentHoveredRect = currentHoveredSlotElem.getBoundingClientRect();
          const cx = currentHoveredRect.left + currentHoveredRect.width / 2;
          const cy = currentHoveredRect.top + currentHoveredRect.height / 2;
          const dx = curX - cx;
          const dy = curY - cy;
          currentHoveredDist = Math.sqrt(dx * dx + dy * dy);
        }
      }

      // Decide if we should snap or switch target
      let targetSlotElem: Element | null = null;
      let targetRect: DOMRect | null = null;
      let targetDist = Infinity;

      if (closestSlot && minDistance < snapThreshold) {
        const closestSide = closestSlot.getAttribute("data-slot-side") as "left" | "right" | "top" | "bottom";
        
        if (currentHoveredSide && closestSide !== currentHoveredSide) {
          // Compare with hysteresis
          if (minDistance < currentHoveredDist - hysteresis) {
            // Switch target
            targetSlotElem = closestSlot;
            targetRect = closestRect;
            targetDist = minDistance;
          } else if (currentHoveredDist < snapThreshold) {
            // Keep current target
            targetSlotElem = currentHoveredSlotElem;
            targetRect = currentHoveredRect;
            targetDist = currentHoveredDist;
          }
        } else {
          // No current target, or closest is the same as current
          targetSlotElem = closestSlot;
          targetRect = closestRect;
          targetDist = minDistance;
        }
      } else if (currentHoveredSide && currentHoveredDist < snapThreshold) {
        // Keep current target if it's still within snap zone
        targetSlotElem = currentHoveredSlotElem;
        targetRect = currentHoveredRect;
        targetDist = currentHoveredDist;
      }

      if (targetSlotElem && targetRect && targetDist < snapThreshold) {
        const side = targetSlotElem.getAttribute("data-slot-side") as "left" | "right" | "top" | "bottom";
        nextHoverSide = side;

        const isVert = targetSlotElem.getAttribute("data-slot-vertical") === "true";
        nextHoverIsVertical = isVert;

        const val1Str = targetSlotElem.getAttribute("data-slot-val1");
        const val2Str = targetSlotElem.getAttribute("data-slot-val2");
        if (val1Str !== null && val2Str !== null) {
          nextSnappedTileValues = [parseInt(val1Str, 10), parseInt(val2Str, 10)];
        }

        const cx = targetRect.left + targetRect.width / 2;
        const cy = targetRect.top + targetRect.height / 2;

        const currentTileW = isVert ? 44 : 88;
        const currentTileH = isVert ? 88 : 44;

        const snapLeft = cx - currentTileW / 2;
        const snapTop  = cy - currentTileH / 2;

        // 98% pull — very strong, crisp magnetic snap
        const snapStrength = 0.98;
        finalLeft = rawLeft + (snapLeft - rawLeft) * snapStrength;
        finalTop  = rawTop  + (snapTop  - rawTop)  * snapStrength;
      }

      // Update ref and React state
      hoveredSlotSideRef.current = nextHoverSide;
      setHoveredSlotSide(prev => {
        if (prev !== nextHoverSide) return nextHoverSide;
        return prev;
      });

      hoveredSlotIsVerticalRef.current = nextHoverIsVertical;
      setHoveredSlotIsVertical(nextHoverIsVertical);

      snappedTileValuesRef.current = nextSnappedTileValues;
      setSnappedTileValues(nextSnappedTileValues);

      // Update position directly in the DOM
      floatingTileRef.current.style.left = `${finalLeft}px`;
      floatingTileRef.current.style.top = `${finalTop}px`;
    }

    if (dragStartPointerRef.current) {
      dragRafRef.current = requestAnimationFrame(updateDragVisuals);
    } else {
      dragRafRef.current = null;
    }
  };

  // ─── Drag helpers (global window listeners — bulletproof across all browsers) ───

  const cancelDrag = () => {
    if (dragRafRef.current) {
      cancelAnimationFrame(dragRafRef.current);
      dragRafRef.current = null;
    }
    dragStartPointerRef.current = null;
    latestPointerPosRef.current = null;
    dragStartOffsetRef.current = null;
    activeDragTileRef.current = null;
    dragActiveRef.current = false;
    hoveredSlotSideRef.current = null;
    hoveredSlotIsVerticalRef.current = true;
    snappedTileValuesRef.current = null;
    setDraggedTile(null);
    setDragStartOffset(null);
    setHoveredSlotSide(null);
    setHoveredSlotIsVertical(true);
    setSnappedTileValues(null);
  };

  // Global drag listeners — hybrid Pointer + Touch for maximum mobile compatibility
  const globalPointerMoveRef = useRef<((e: PointerEvent) => void) | null>(null);
  const globalPointerUpRef   = useRef<((e: PointerEvent) => void) | null>(null);
  const globalTouchMoveRef   = useRef<((e: TouchEvent) => void) | null>(null);
  const globalTouchEndRef    = useRef<((e: TouchEvent) => void) | null>(null);

  const removeAllGlobalListeners = () => {
    if (globalPointerMoveRef.current) { window.removeEventListener('pointermove', globalPointerMoveRef.current); globalPointerMoveRef.current = null; }
    if (globalPointerUpRef.current)   { window.removeEventListener('pointerup',   globalPointerUpRef.current);   globalPointerUpRef.current   = null; }
    if (globalTouchMoveRef.current)   { window.removeEventListener('touchmove',   globalTouchMoveRef.current);   globalTouchMoveRef.current   = null; }
    if (globalTouchEndRef.current)    { window.removeEventListener('touchend',     globalTouchEndRef.current);    globalTouchEndRef.current    = null; }
  };

  const playTileForUserRef = useRef(playTileForUser);
  useEffect(() => {
    playTileForUserRef.current = playTileForUser;
  }, [playTileForUser]);

  const attachGlobalListeners = (tile: Tile) => {
    removeAllGlobalListeners();

    // ─── Pointer events (mouse + stylus) ───
    const onPointerMove = (e: PointerEvent) => {
      if (dragStartPointerRef.current === null) return;
      latestPointerPosRef.current = { x: e.clientX, y: e.clientY };
      if (!dragRafRef.current) dragRafRef.current = requestAnimationFrame(updateDragVisuals);
    };

    const onPointerUp = (_e: PointerEvent) => {
      if (dragStartPointerRef.current === null) return;
      if (dragRafRef.current) { cancelAnimationFrame(dragRafRef.current); dragRafRef.current = null; }
      const finalSide     = hoveredSlotSideRef.current;
      const wasActiveDrag = dragActiveRef.current;
      cancelDrag();
      removeAllGlobalListeners();
      if (wasActiveDrag) {
        draggedHappenedRef.current = true;
        if (finalSide) { playTileForUserRef.current(tile, finalSide); setSelectedTile(null); }
      }
    };

    // ─── Touch events (finger) ───
    const onTouchMove = (e: TouchEvent) => {
      if (dragStartPointerRef.current === null) return;
      const t = e.touches[0];
      if (!t) return;

      const startX = dragStartPointerRef.current.x;
      const startY = dragStartPointerRef.current.y;
      const dx = Math.abs(t.clientX - startX);
      const dy = Math.abs(t.clientY - startY);

      // Disambiguate scroll vs drag
      if (!dragActiveRef.current) {
        // If user moves horizontally more than vertically, it's a scroll.
        if (dx > dy && dx > 5) {
          cancelDrag();
          removeAllGlobalListeners();
          return; // Abort drag, let browser scroll natively
        }
      }

      // If we determined it's a vertical movement, or drag is already active, prevent scroll
      if (dy > dx || dragActiveRef.current) {
        if (e.cancelable) e.preventDefault();
      }

      latestPointerPosRef.current = { x: t.clientX, y: t.clientY };
      if (!dragRafRef.current) dragRafRef.current = requestAnimationFrame(updateDragVisuals);
    };

    const onTouchEnd = (_e: TouchEvent) => {
      if (dragStartPointerRef.current === null) return;
      if (dragRafRef.current) { cancelAnimationFrame(dragRafRef.current); dragRafRef.current = null; }
      const finalSide     = hoveredSlotSideRef.current;
      const wasActiveDrag = dragActiveRef.current;
      cancelDrag();
      removeAllGlobalListeners();
      if (wasActiveDrag) {
        draggedHappenedRef.current = true;
        if (finalSide) { playTileForUserRef.current(tile, finalSide); setSelectedTile(null); }
      }
    };

    globalPointerMoveRef.current = onPointerMove;
    globalPointerUpRef.current   = onPointerUp;
    globalTouchMoveRef.current   = onTouchMove;
    globalTouchEndRef.current    = onTouchEnd;

    window.addEventListener('pointermove', onPointerMove, { passive: true });
    window.addEventListener('pointerup',   onPointerUp);
    // passive:false is MANDATORY on touchmove — otherwise preventDefault() is silently ignored
    window.addEventListener('touchmove',   onTouchMove,  { passive: false });
    window.addEventListener('touchend',    onTouchEnd);
  };

  // Pointer event drag handlers (Feature 1)
  const handlePointerDown = (e: React.PointerEvent<HTMLButtonElement>, tile: Tile) => {
    if (currentPlayer !== "user" || matchStatus !== "ongoing" || isDealing || matchWinner || matchEndPendingRef.current) return;

    // Check playability of the tile
    const isPlayable = showAnalysis 
      ? (currentAnalysis.recommendations.find(r => (r.tile[0] === tile[0] && r.tile[1] === tile[1]) || (r.tile[1] === tile[0] && r.tile[0] === tile[1]))?.isPlayable ?? true) 
      : true;
    if (!isPlayable) return;

    e.preventDefault(); // Prevent scroll on mobile during drag

    const rect = e.currentTarget.getBoundingClientRect();
    dragStartPointerRef.current = { x: e.clientX, y: e.clientY };
    latestPointerPosRef.current = { x: e.clientX, y: e.clientY };
    dragStartOffsetRef.current = {
      x: e.clientX - rect.left,
      y: e.clientY - rect.top
    };
    activeDragTileRef.current = tile;
    dragActiveRef.current = false;
    draggedHappenedRef.current = false;
    hoveredSlotSideRef.current = null;
    hoveredSlotIsVerticalRef.current = true;
    snappedTileValuesRef.current = null;
    // Reset floating tile state (hidden until movement threshold)
    setDraggedTile(null);
    setDragStartOffset(null);
    setHoveredSlotSide(null);
    setHoveredSlotIsVertical(true);
    setSnappedTileValues(null);

    if (dragRafRef.current) {
      cancelAnimationFrame(dragRafRef.current);
    }
    dragRafRef.current = requestAnimationFrame(updateDragVisuals);

    // Attach global listeners so drag works even when pointer leaves the tile
    attachGlobalListeners(tile);
  };

  // These are kept for compatibility (pointer capture fallback), but real work is done by global listeners
  const handlePointerMove = (_e: React.PointerEvent<HTMLButtonElement>, _tile: Tile) => {};

  const handlePointerUp = (_e: React.PointerEvent<HTMLButtonElement>, _tile: Tile) => {};

  // Handles system interruptions (e.g. incoming call on mobile)
  const handlePointerCancel = (_e: React.PointerEvent<HTMLButtonElement>, _tile: Tile) => {
    removeAllGlobalListeners();
    cancelDrag();
  };

  // Action: Select tile and auto-play if there's only one valid option
  const selectUserTile = (tile: Tile) => {
    if (currentPlayer !== "user" || matchStatus !== "ongoing" || matchEndPendingRef.current) return;
    
    // Toggle selection off if already selected
    if (selectedTile && selectedTile[0] === tile[0] && selectedTile[1] === tile[1]) {
      setSelectedTile(null);
      return;
    }

    if (placedTiles.length === 0) {
      // Game start: select the tile and show starting position
      setSelectedTile(tile);
      return;
    }

    // Check playability options
    const playability = evaluatePlayability2D(tile, openEnds2D);
    const validSides: ("left" | "right" | "top" | "bottom")[] = [];
    if (playability.left) validSides.push("left");
    if (playability.right) validSides.push("right");
    if (playability.top) validSides.push("top");
    if (playability.bottom) validSides.push("bottom");

    if (validSides.length >= 1) {
      setSelectedTile(tile);
    }
  };

  // 5. Action: Player draws a tile
  const handleUserDraw = (drawIndex?: number) => {
    const isNoPlayDraw = noPlayState.active && noPlayState.step === "await_user_draw";
    if (!isNoPlayDraw) {
      if (currentPlayer !== "user" || boneyard.length === 0 || userCanPlay || matchStatus !== "ongoing" || matchEndPendingRef.current) return;
    } else {
      if (boneyard.length === 0) return;
    }

    // Use specific index if provided (from BoneyardView click), otherwise default to 0
    const idx = drawIndex !== undefined ? drawIndex : 0;
    const drawnTile = boneyard[idx];
    
    // Remove the drawn tile
    const nextBoneyard = [...boneyard];
    nextBoneyard.splice(idx, 1);
    
    const nextHand = [...userHand, drawnTile];

    setBoneyard(nextBoneyard);
    setUserHand(nextHand);
    setConsecutivePasses(0);
    logInternalEvent("draw", "user", { tile: drawnTile });

    setLogs(prev => [
      createLog("user", `You drew [${drawnTile[0]}|${drawnTile[1]}] from boneyard.`, "draw"),
      ...prev
    ]);

    const playability = evaluatePlayability2D(drawnTile, openEnds2D);
    const isPlayable = playability.left || playability.right || playability.top || playability.bottom || placedTiles.length === 0;

    if (isNoPlayDraw) {
      if (isPlayable) {
        setNoPlayState(prev => ({
          ...prev,
          step: "draw",
          drawnTile
        }));
      } else {
        setNoPlayState(prev => ({
          ...prev,
          step: "await_user_draw",
          drawnTile: null
        }));
      }
    } else {
      if (isPlayable) {
        setSelectedTile(drawnTile);
      } else {
        setSelectedTile(null);
      }
    }
  };

  // 5b. Action: Player draws a starting tile during initial manual draw phase
  const handleInitialDraw = (idx: number) => {
    if (!isDealing || currentPlayer !== "user" || boneyard.length === 0) return;

    const drawnTile = boneyard[idx];
    const nextBoneyard = [...boneyard];
    nextBoneyard.splice(idx, 1);
    const nextHand = [...userHand, drawnTile];

    setBoneyard(nextBoneyard);
    setUserHand(nextHand);

    setLogs(prev => [
      createLog("user", `You drew [${drawnTile[0]}|${drawnTile[1]}] as a starting tile.`, "draw"),
      ...prev
    ]);

    setCurrentPlayer("ai");
  };

  // 6. Action: Player passes
  const handleUserPass = () => {
    if (currentPlayer !== "user" || userCanPlay || matchStatus !== "ongoing" || matchEndPendingRef.current) return;
    if ((gameMode === "draw" || gameMode === "all-fives") && boneyard.length > 0) return; // Must draw if tiles left!

    logInternalEvent("pass", "user");
    setLogs(prev => [createLog("user", "You had no plays and passed your turn.", "pass"), ...prev]);
    
    const nextPasses = consecutivePasses + 1;
    setConsecutivePasses(nextPasses);
    
    // Safe block check first
    const blocked = checkAndTriggerBlockedRound(placedTiles, userHand, aiHand, nextPasses);
    if (!blocked) {
      setCurrentPlayer("ai");
    }
  };

  // 6b. Initial Manual Deal AI Loop (Feature 3)
  useEffect(() => {
    if (!isDealing || matchStatus !== "ongoing" || currentPlayer !== "ai") return;

    setAiThinking(true);

    const timer = setTimeout(() => {
      setAiThinking(false);
      if (boneyard.length === 0) return;

      const randomIdx = Math.floor(Math.random() * boneyard.length);
      const drawnTile = boneyard[randomIdx];

      const nextBoneyard = [...boneyard];
      nextBoneyard.splice(randomIdx, 1);
      const nextAiHand = [...aiHand, drawnTile];

      setBoneyard(nextBoneyard);
      setAiHand(nextAiHand);

      setLogs(prev => [
        createLog("ai", "AI drew a starting tile.", "draw"),
        ...prev
      ]);

      if (userHand.length === 7 && nextAiHand.length === 7) {
        setIsDealing(false);
        determineStarterAndInitRound(userHand, nextAiHand, nextRoundStarter, round);
      } else {
        setCurrentPlayer("user");
      }
    }, 800);

    return () => clearTimeout(timer);
  }, [isDealing, currentPlayer, boneyard, userHand, aiHand, matchStatus, round, nextRoundStarter]);

  // 7. Tactical AI Action Loop (triggers when currentPlayer is 'ai')
  useEffect(() => {
    if (currentPlayer !== "ai" || matchStatus !== "ongoing" || isDealing || noPlayState.active) return;

    setAiThinking(true);

    const timer = setTimeout(() => {
      if (matchEndPendingRef.current) {
        setAiThinking(false);
        return;
      }
      setAiThinking(false);

      const aiEnds2D = getOpenEnds2D(placedTiles);
      
      const bestMove = getBestMoveForHand(aiHand, placedTiles, gameMode, difficulty);

      // AI DRAW LOOP if no options
      if (!bestMove) {
        if ((gameMode === "draw" || gameMode === "all-fives") && boneyard.length > 0) {
          // AI draws a tile
          const drawnTile = boneyard[0];
          const nextBoneyard = boneyard.slice(1);
          const nextAiHand = [...aiHand, drawnTile];

          setBoneyard(nextBoneyard);
          setAiHand(nextAiHand);
          setConsecutivePasses(0);
          logInternalEvent("draw", "ai", { tile: drawnTile });
          setLogs(prev => [
            createLog("ai", `Tactical AI has no plays and draws a tile.`, "draw"),
            ...prev
          ]);
          // This loop is re-evaluated recursively because currentPlayer remains AI and we change AI state!
          return;
        } else {
          // AI must pass
          logInternalEvent("pass", "ai");
          setLogs(prev => [createLog("ai", `Tactical AI has no options and passes turn.`, "pass"), ...prev]);
          
          const nextPasses = consecutivePasses + 1;
          setConsecutivePasses(nextPasses);

          const blocked = checkAndTriggerBlockedRound(placedTiles, userHand, aiHand, nextPasses);
          if (!blocked) {
            setCurrentPlayer("user");
          }
          return;
        }
      }

      // Execute AI play
      const { tile, side } = bestMove;
      const nextAiHand = aiHand.filter(t => !(t[0] === tile[0] && t[1] === tile[1]));
      setAiHand(nextAiHand);

      const playSide = side;
      const rotation = getPlayedTileRotation2D(tile, playSide, aiEnds2D);
      const newPlaced: PlacedTile = {
        id: generateId(),
        tile,
        connectedAs: rotation,
        isDouble: tile[0] === tile[1],
        playedAt: playSide,
      };

      const nextPlacedTiles = [...placedTiles, newPlaced];
      setPlacedTiles(nextPlacedTiles);
      playTilePlacementSound();
      logInternalEvent("play", "ai", { tile, side: playSide });

      // Log AI Action
      const sideText = playSide === "start" ? "" : ` on the ${playSide}`;
      let message = `AI played [${tile[0]}|${tile[1]}]${sideText}.`;
      
      // Calculate All Fives Score
      let roundPoints = 0;
      if (gameMode === "all-fives") {
        const sum = ScoreEngine.calculateBoardScore(nextPlacedTiles);
        const points = ScoreEngine.calculateMultipleOfFive(sum);

        // Debug output
        ScoreEngine.printScoreDebug(nextPlacedTiles, sum, points);

        if (points > 0) {
          roundPoints = points;
          setScoreAi(prev => ScoreEngine.addPlayerScore(prev, points));
          triggerPointsFlash("ai", points);
          message += ` 🎯 Scores ${points} Fives points! (Ends sum: ${sum})`;

          // Trigger center board popup
          const nextLayouts = computeTileLayouts(nextPlacedTiles);
          const lastTileLay = nextLayouts[newPlaced.id];
          if (lastTileLay) {
            setCenterScorePopup({
              points,
              gridX: lastTileLay.gridX,
              gridY: lastTileLay.gridY
            });
            setTimeout(() => setCenterScorePopup(null), 1500);
          }
        }
      }
      setLogs(prev => [createLog("ai", message, roundPoints > 0 ? "score" : "play"), ...prev]);

      // Check Domino
      if (nextAiHand.length === 0) {
        handleRoundEnd("ai", nextPlacedTiles, userHand, []);
        return;
      }

      // Check Block state across remaining hands, or handover turn
      setConsecutivePasses(0);
      const blocked = checkAndTriggerBlockedRound(nextPlacedTiles, userHand, nextAiHand, 0);
      if (!blocked) {
        setCurrentPlayer("user");
      }

    }, 1200);

    return () => clearTimeout(timer);
  }, [currentPlayer, aiHand.length, placedTiles.length, consecutivePasses, noPlayState.active]);



  // 8. Tally Scores & Finalize Round End
  // Helper for Feature 5 - Commit scores and switch to scoring mode
  const calculateAndCommitScores = (
    result: "user" | "ai" | "blocked",
    finalBoard: PlacedTile[],
    uHand: Tile[],
    aHand: Tile[]
  ) => {
    // Check ref to prevent double execution
    if (scoreCommittedRef.current) return;
    scoreCommittedRef.current = true;

    let roundWinner: "user" | "ai" | "draw" = "draw";
    let scoreGained = 0;
    let endMessage = "";

    const userPipsSum = ScoreEngine.calculateRemainingTiles(uHand);
    const aiPipsSum = ScoreEngine.calculateRemainingTiles(aHand);

    if (result === "user") {
      roundWinner = "user";
      setRoundsWonUser(prev => prev + 1);
      const exactPips = aiPipsSum;
      scoreGained = ScoreEngine.roundToNearestFive(exactPips);
      setScoreUser(prev => ScoreEngine.addPlayerScore(prev, scoreGained));
      triggerPointsFlash("user", scoreGained, "user");
      endMessage = `🎉 Domino! You cleared your hand. You win Round ${round} and score ${scoreGained} points (opp. hand pips: ${exactPips} rounded to nearest 5) from AI's remaining hand.`;
    } else if (result === "ai") {
      roundWinner = "ai";
      setRoundsWonAi(prev => prev + 1);
      const exactPips = userPipsSum;
      scoreGained = ScoreEngine.roundToNearestFive(exactPips);
      setScoreAi(prev => ScoreEngine.addPlayerScore(prev, scoreGained));
      triggerPointsFlash("ai", scoreGained, "ai");
      endMessage = `🤖 AI declared Domino! You lose Round ${round}. AI scores ${scoreGained} points (your hand pips: ${exactPips} rounded to nearest 5) from your remaining hand.`;
    } else {
      // Bloqué / Blocked: Player with lowest total in their hand wins Round, scores difference!
      const blockedResult = resolveBlockedGame(uHand, aHand);
      roundWinner = blockedResult.winner;
      endMessage = blockedResult.reason;

      if (roundWinner === "user") {
        setRoundsWonUser(prev => prev + 1);
        const exactDiff = aiPipsSum - userPipsSum;
        scoreGained = ScoreEngine.roundToNearestFive(exactDiff);
        setScoreUser(prev => ScoreEngine.addPlayerScore(prev, scoreGained));
        triggerPointsFlash("user", scoreGained, "user");
        endMessage = `⚠️ Game Blocked! You win Round ${round} and get ${scoreGained} points (difference: ${exactDiff} rounded to nearest 5)!`;
      } else if (roundWinner === "ai") {
        setRoundsWonAi(prev => prev + 1);
        const exactDiff = userPipsSum - aiPipsSum;
        scoreGained = ScoreEngine.roundToNearestFive(exactDiff);
        setScoreAi(prev => ScoreEngine.addPlayerScore(prev, scoreGained));
        triggerPointsFlash("ai", scoreGained, "ai");
        endMessage = `⚠️ Game Blocked! AI wins Round ${round} and gets ${scoreGained} points (difference: ${exactDiff} rounded to nearest 5).`;
      } else {
        // Tie-break with no points
        scoreGained = 0;
        setCenterToast({ winner: roundWinner, points: 0 });
        setTimeout(() => setCenterToast(null), 3500);
      }
    }

    const targetUser = roundWinner === "user" ? ScoreEngine.addPlayerScore(scoreUser, scoreGained) : scoreUser;
    const targetAi = roundWinner === "ai" ? ScoreEngine.addPlayerScore(scoreAi, scoreGained) : scoreAi;

    setVisualScoreUser(targetUser);
    setVisualScoreAi(targetAi);

    logInternalEvent("score_tally", (roundWinner as string) === "draw" ? "system" : (roundWinner as "user" | "ai"), { scoreGained, result });
    setWinner(roundWinner);
    setRevealPhase("scoring");
    setLogs(prev => [
      createLog("system", endMessage, "win"),
      createLog("system", `User Pips Left: ${userPipsSum} | AI Pips Left: ${aiPipsSum}`, "system"),
      ...prev
    ]);
    
    // Increment Round counter for potential re-deals
    setRound(prev => prev + 1);

    // Set match status at the end
    setMatchStatus(result === "blocked" ? "blocked" : "domino");
  };

  // 8. Tally Scores & Finalize Round End
  const handleRoundEnd = (
    result: "user" | "ai" | "blocked",
    finalBoard: PlacedTile[],
    uHand: Tile[],
    aHand: Tile[]
  ) => {
    if (matchStatus !== "ongoing") return;

    setSelectedTile(null);
    setMatchStatus("revealing");
    setRevealPhase("revealing");
    scoreCommittedRef.current = false;

    const userPipsSum = ScoreEngine.calculateRemainingTiles(uHand);
    const aiPipsSum = ScoreEngine.calculateRemainingTiles(aHand);

    let roundWinner: "user" | "ai" | "draw" = "draw";
    let tieBreakExplained = "";

    if (result === "user") {
      roundWinner = "user";
    } else if (result === "ai") {
      roundWinner = "ai";
    } else {
      // Bloqué / Blocked
      const blockedResult = resolveBlockedGame(uHand, aHand);
      roundWinner = blockedResult.winner;
      tieBreakExplained = blockedResult.reason;
    }

    logInternalEvent("round_end", result === "blocked" ? "system" : result, { winner: roundWinner, result, userPipsLeft: userPipsSum, aiPipsLeft: aiPipsSum });

    const winningTileId = result !== "blocked" && finalBoard.length > 0
      ? finalBoard[finalBoard.length - 1].id
      : null;

    setRevealData({
      result,
      finalBoard,
      userHand: [...uHand],
      aiHand: [...aHand],
      userPipsSum,
      aiPipsSum,
      roundWinner,
      tieBreakExplained,
      winningTileId
    });

    const delay = GAME_CONFIG.disableAnimations ? 0 : GAME_CONFIG.durations.roundEndDominoHighlight;
    setTimeout(() => {
      calculateAndCommitScores(result, finalBoard, uHand, aHand);
    }, delay);
  };

  // Helper to safely verify blocked round criteria and trigger resolution if met
  const checkAndTriggerBlockedRound = (
    currentBoard: PlacedTile[],
    uHand: Tile[],
    aHand: Tile[],
    cPasses: number = consecutivePasses
  ): boolean => {
    if (matchStatus !== "ongoing") return false;

    const ends = getOpenEnds2D(currentBoard);
    const uPlayable = hasPlayableTile2D(uHand, ends) || (currentBoard.length === 0 && uHand.length > 0);
    const aPlayable = hasPlayableTile2D(aHand, ends) || (currentBoard.length === 0 && aHand.length > 0);

    const blocked = checkBlockedStatus(boneyard.length, cPasses, uPlayable, aPlayable);
    if (blocked) {
      setConsecutivePasses(0);
      handleRoundEnd("blocked", currentBoard, uHand, aHand);
      return true;
    }
    return false;
  };


  // Reset total match score trackers
  const handleResetScores = () => {
    setScoreUser(0);
    setScoreAi(0);
    setRoundsWonUser(0);
    setRoundsWonAi(0);
    setRoundsHistory([]);
    setMancheWinner(null);
    setMancheCountdown(null);
    setMatchState(null);
    matchManagerRef.current = null;
    setRound(1);
    setMatchStatus("not-started");
    setWinner(null);
    setRevealPhase("none");
    setRevealData(null);
    setPlacedTiles([]);
    setUserHand([]);
    setAiHand([]);
    setMatchWinner(null);
    setLogs([createLog("system", "Scores reset! Play a fresh duel.", "system")]);
    localStorage.removeItem("maestro_domino_state");
    setCurrentScreen("home");
  };

  // Start a brand new match with reset scores
  const handleStartNewGame = () => {
    const players = [
      { id: "user", name: "Jean François" },
      { id: "ai", name: "Bot Op" }
    ];
    const settings = {
      targetManches,
      targetScorePerManche: targetScore,
      gameMode,
      matchMode
    };
    
    const manager = new MatchManager(players, settings);
    matchManagerRef.current = manager;
    setMatchState(manager.getMatchState());

    // Bind event subscriptions
    manager.subscribe("ROUND_COMPLETED", ({ roundResult, matchState: nextState }) => {
      setMatchState(nextState);
      setRoundsWonUser(nextState.roundsWon["user"] || 0);
      setRoundsWonAi(nextState.roundsWon["ai"] || 0);
      setRoundsHistory(nextState.roundsHistory);
    });

    manager.subscribe("MATCH_COMPLETED", (finalState) => {
      setMatchState(finalState);
    });

    setScoreUser(0);
    setScoreAi(0);
    setRoundsWonUser(0);
    setRoundsWonAi(0);
    setConsecutivePasses(0);
    setRoundsHistory([]);
    setMancheWinner(null);
    setMancheCountdown(null);
    setRound(1);
    setMatchWinner(null);
    setWinner(null);
    setRevealPhase("none");
    setRevealData(null);
    setNextRoundStarter(null);
    matchEndPendingRef.current = false;
    localStorage.removeItem("maestro_domino_state");

    if (dealOption === "auto") {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      const uHand = fullSet.slice(0, 7);
      const aHand = fullSet.slice(7, 14);
      const remainingBoneyard = fullSet.slice(14);

      setPlacedTiles([]);
      setUserHand(uHand);
      setAiHand(aHand);
      setBoneyard(remainingBoneyard);
      setSelectedTile(null);
      setIsDealing(false);
      setCurrentScreen("game");
      setMatchStatus("ongoing");

      determineStarterAndInitRound(uHand, aHand, null, 1);
    } else {
      const fullSet = shuffleTiles(generateDoubleSixSet());
      setPlacedTiles([]);
      setUserHand([]);
      setAiHand([]);
      setBoneyard(fullSet);
      setSelectedTile(null);
      setIsDealing(true);
      setCurrentScreen("game");
      setCurrentPlayer("user");
      setMatchStatus("ongoing");

      setLogs([
        createLog("system", "New Match started! Draw 7 starting tiles. You draw first!", "system")
      ]);
    }
  };

  return (
    <div className="min-h-screen bg-[#050505] flex items-center justify-center font-sans select-none antialiased">
      {/* Mobile Wrapper with dark mahogany wood frame */}
      <div className="w-full max-w-md h-[100dvh] sm:h-[850px] sm:rounded-[40px] bg-[#0c0c0c] text-[#eaeaea] shadow-2xl relative overflow-hidden flex flex-col border-0 sm:border-[10px] border-[#250d03] sm:shadow-[0_0_30px_rgba(0,0,0,0.85),inset_0_0_10px_rgba(0,0,0,0.6)]">
        
        {currentScreen === "home" && (
          <HomeMenu 
            onStartNewGame={handleStartNewGame} 
            onNavigate={(screen) => {
              if (screen === "scores") {
                setCurrentScreen("leaderboard");
              } else {
                setCurrentScreen(screen);
              }
            }} 
            canContinue={matchStatus !== "not-started"}
            onContinueGame={handleContinueGame}
            onPlayOnline={() => {
              setAuthInitialView("login");
              setCurrentScreen(currentUser ? "online-lobby" : "auth");
            }}
            onPlayTournaments={() => {
              if (currentUser) {
                setCurrentScreen("tournament-lobby");
              } else {
                setAuthInitialView("login");
                setCurrentScreen("auth");
              }
            }}
            currentUser={userProfile}
            isAdmin={userProfile?.role === "admin" || userProfile?.role === "super-admin"}
            onNavigateToAdmin={() => {
              if (userProfile?.role === "admin" || userProfile?.role === "super-admin") {
                setCurrentScreen("admin-dashboard");
              }
            }}
            onSignOut={async () => {
              if (supabase) {
                await supabase.auth.signOut();
                setCurrentScreen("auth");
              }
            }}
            onNavigateToGame={(roomId) => {
              setActiveOnlineRoomId(roomId);
              setCurrentScreen("online-game");
            }}
          />
        )}

        {currentScreen === "auth" && (
          <AuthPortal 
            initialView={authInitialView}
            onAuthSuccess={() => setCurrentScreen("home")}
          />
        )}

        {currentScreen === "online-lobby" && (
          <OnlineLobby 
            currentUser={currentUser}
            onSignOut={async () => {
              if (supabase) {
                await supabase.auth.signOut();
                setCurrentScreen("home");
              }
            }}
            onNavigateToGame={(roomId) => {
              setActiveOnlineRoomId(roomId);
              setCurrentScreen("online-game");
            }}
            onNavigateToStats={() => setCurrentScreen("profile-stats")}
            onBack={() => setCurrentScreen("home")}
          />
        )}

        {currentScreen === "online-game" && activeOnlineRoomId && (
          <OnlineGame 
            roomId={activeOnlineRoomId}
            currentUser={currentUser}
            onBackToLobby={() => {
              localStorage.removeItem("active_online_room_id");
              setActiveOnlineRoomId(null);
              setCurrentScreen("online-lobby");
            }}
            onNavigateToGame={(newRoomId) => {
              setActiveOnlineRoomId(newRoomId);
            }}
          />
        )}

        {currentScreen === "profile-stats" && (
          <ProfileStats 
            currentUser={currentUser}
            onBack={() => setCurrentScreen("online-lobby")}
          />
        )}

        {currentScreen === "admin-dashboard" && userProfile && (
          <AdminDashboard 
            currentUser={userProfile}
            onBack={() => setCurrentScreen("home")}
          />
        )}

        {currentScreen === "tournament-lobby" && userProfile && (
          <TournamentLobby 
            currentUser={userProfile}
            onNavigateToRoom={(roomId) => {
              setActiveOnlineRoomId(roomId);
              setCurrentScreen("online-game");
            }}
            onBack={() => setCurrentScreen("home")}
          />
        )}

        {currentScreen === "leaderboard" && (
          <LeaderboardView 
            onBack={() => setCurrentScreen("home")}
            onNavigateToLocalHistory={() => setCurrentScreen("scores")}
            onNavigate={setCurrentScreen}
          />
        )}

        {currentScreen === "game" && (
          <div className="flex flex-col h-full bg-[#1e0a02]">
            {/* Top Bar (Header Restructured to Split 50/50 mahogany with gold divider line & Turn glow) */}
            <header className="relative grid grid-cols-2 bg-gradient-to-b from-[#3a1506] to-[#1e0a02] border-b border-[#d4af37]/35 shadow-lg shrink-0 overflow-hidden font-sans">
              {/* User Side (Left) */}
              <div className="flex items-center gap-3 p-2.5 pl-4 relative border-r border-[#d4af37]/25">
                {/* Avatar with turn highlight glow */}
                <div className={`w-11 h-11 rounded overflow-hidden shadow bg-[#1e0a02] flex items-center justify-center shrink-0 transition-all duration-300
                  ${currentPlayer === "user" 
                    ? "ring-2 ring-amber-400 shadow-[0_0_12px_rgba(212,175,55,0.85)] scale-105" 
                    : "border border-[#d4af37]/30"
                  }
                `}>
                  <span className="text-2xl">😎</span>
                </div>
                {/* Name and Score */}
                <div className="flex flex-col min-w-0">
                  <span className="text-amber-400 text-[10px] font-black tracking-wider uppercase truncate">
                    {gameType === "team" ? "Équipe Rouge" : "maestro10"}
                  </span>
                  <div className="flex items-center gap-1.5 mt-0.5 relative">
                    <span className="text-amber-400 text-2xl font-black font-mono leading-none">{visualScoreUser} <span className="text-sm font-bold opacity-85">({roundsWonUser})</span></span>
                    {/* Floating +pts badge for user */}
                    <AnimatePresence>
                      {lastPointsUser !== null && (
                        <motion.span
                          key={`flash-user-${lastPointsUser}-${Date.now()}`}
                          initial={{ opacity: 0, y: 0, scale: 0.7 }}
                          animate={{ opacity: 1, y: -22, scale: 1.1 }}
                          exit={{ opacity: 0, y: -38, scale: 0.8 }}
                          transition={{ duration: 0.5, ease: "easeOut" }}
                          className="absolute left-0 -top-1 text-emerald-400 text-sm font-black font-mono pointer-events-none z-20 drop-shadow-[0_2px_4px_rgba(0,0,0,0.9)]"
                        >
                          +{lastPointsUser}
                        </motion.span>
                      )}
                    </AnimatePresence>
                  </div>
                </div>
              </div>

              {/* Opponent Side (Right) */}
              <div className="flex items-center justify-end gap-3 p-2.5 pr-4 pl-4 relative bg-black/10">
                {/* Name and Score */}
                <div className="flex flex-col items-end min-w-0 text-right">
                  <span className="text-zinc-355 text-[10px] font-black tracking-wider uppercase truncate">
                    {gameType === "team" ? "Équipe Bleue" : "bot_op"}
                  </span>
                  <div className="flex items-center gap-1.5 mt-0.5 relative justify-end">
                    <span className="text-white text-2xl font-black font-mono leading-none">{visualScoreAi} <span className="text-sm font-bold opacity-85">({roundsWonAi})</span></span>
                    {/* Floating +pts badge for AI */}
                    <AnimatePresence>
                      {lastPointsAi !== null && (
                        <motion.span
                          key={`flash-ai-${lastPointsAi}-${Date.now()}`}
                          initial={{ opacity: 0, y: 0, scale: 0.7 }}
                          animate={{ opacity: 1, y: -22, scale: 1.1 }}
                          exit={{ opacity: 0, y: -38, scale: 0.8 }}
                          transition={{ duration: 0.5, ease: "easeOut" }}
                          className="absolute right-0 -top-1 text-red-400 text-sm font-black font-mono pointer-events-none z-20 drop-shadow-[0_2px_4px_rgba(0,0,0,0.9)]"
                        >
                          +{lastPointsAi}
                        </motion.span>
                      )}
                    </AnimatePresence>
                  </div>
                </div>
                {/* Avatar & Action Menu with turn highlight glow */}
                <div className="flex items-center gap-1 shrink-0">
                  <div className={`w-11 h-11 rounded overflow-hidden shadow bg-[#1e0a02] flex items-center justify-center transition-all duration-300
                    ${currentPlayer === "ai" 
                      ? "ring-2 ring-amber-400 shadow-[0_0_12px_rgba(212,175,55,0.85)] scale-105" 
                      : "border border-zinc-700/50"
                    }
                  `}>
                    <span className="text-2xl">🤖</span>
                  </div>
                  <button 
                    onClick={() => setCurrentScreen("home")}
                    className="p-1 text-white hover:text-amber-400 cursor-pointer"
                  >
                    <MoreVertical size={18} />
                  </button>
                </div>
              </div>

              {/* FIVES TO X Objective Row with White text and soft shadow directly under players */}
              <div className="col-span-2 text-center pb-2 pt-1 border-t border-[#d4af37]/15">
                <span className="text-white text-[11px] font-black tracking-[0.2em] uppercase drop-shadow-[0_1.5px_2px_rgba(0,0,0,0.85)]">
                  {gameMode === "all-fives" ? `FIVES to ${targetScore}` : "BLOCK/DRAW"}
                </span>
              </div>

              {/* Gold Divider vertical Accent */}
              <div className="absolute top-0 bottom-[28px] left-1/2 -translate-x-1/2 w-[1px] bg-gradient-to-b from-[#d4af37] via-[#d4af37]/45 to-transparent pointer-events-none" />

              {/* Turn timer badge */}
              {matchStatus === "ongoing" && !matchWinner && !isDealing && (
                <div className="absolute top-[18px] left-1/2 -translate-x-1/2 z-20 flex items-center justify-center pointer-events-none">
                  <div className="w-8 h-8 rounded-full bg-zinc-950/95 border border-amber-400/80 flex items-center justify-center text-amber-400 font-mono font-bold text-xs shadow-lg shadow-black/85 animate-pulse">
                    {turnTimeLeft}s
                  </div>
                </div>
              )}
            </header>

            {/* Dual Score Progress Bar */}
            <div className="w-full bg-zinc-950 h-1 flex border-b border-white/5 shrink-0">
              <div 
                className="bg-gradient-to-r from-red-500 to-amber-500 transition-all duration-500 shrink-0" 
                style={{ width: `${Math.min(100, (visualScoreUser / targetScore) * 100)}%` }}
              />
              <div className="flex-1 bg-transparent" />
              <div 
                className="bg-gradient-to-l from-blue-500 to-amber-400 transition-all duration-500 shrink-0" 
                style={{ width: `${Math.min(100, (visualScoreAi / targetScore) * 100)}%` }}
              />
            </div>

            {/* Board Area */}
            <div className="flex-1 flex flex-col min-h-0 relative overflow-hidden bg-gradient-to-b from-[#1b4d22] to-[#113516] shadow-[inset_0_0_80px_rgba(0,0,0,0.55)]">
              
              {/* FPS & Mode indicators (Top right absolute) */}
              {SHOW_DEBUG_FPS && (
                <div className="absolute right-2 top-8 z-10 flex gap-2 pointer-events-none">
                  <span className="bg-[#111] text-red-500 text-[9px] font-bold font-mono px-2 py-0.5 rounded shadow">37 FPS</span>
                </div>
              )}

              {/* Opponent Hand (Top Center) */}
              <OpponentHand 
                count={aiHand.length} 
                revealedTiles={(matchStatus === "domino" || matchStatus === "blocked" || winner !== null || matchStatus === "revealing" || revealPhase === "revealing") ? aiHand : undefined}
              />

              {/* Round End State Popup Overlay */}

              {/* ── No Play / Pass Sequence Overlays ─────────── */}
              <AnimatePresence>
                {noPlayState.active && noPlayState.step === "show_hand" && (
                  <motion.div
                    initial={{ opacity: 0, y: noPlayState.player === "ai" ? -10 : 10, scale: 0.9 }}
                    animate={{ opacity: 1, y: 0, scale: 1 }}
                    exit={{ opacity: 0, scale: 0.8 }}
                    className={`absolute inset-x-0 z-45 flex justify-center pointer-events-none ${noPlayState.player === "ai" ? "top-32" : "bottom-48"}`}
                  >
                    <div className="px-5 py-2 bg-red-950/90 border border-red-500/50 rounded-full shadow-lg backdrop-blur-sm">
                      <span className="text-red-500 font-sans font-black uppercase tracking-[0.3em] text-sm">
                        Pass
                      </span>
                    </div>
                  </motion.div>
                )}

                {noPlayState.active && noPlayState.step === "pass_toast" && (
                  <motion.div
                    initial={{ opacity: 0, y: noPlayState.player === "ai" ? -20 : 20, scale: 0.9 }}
                    animate={{ opacity: 1, y: 0, scale: 1 }}
                    exit={{ opacity: 0, scale: 0.8 }}
                    transition={{ type: "spring", stiffness: 400, damping: 25 }}
                    className={`absolute inset-x-0 z-50 flex justify-center pointer-events-none ${noPlayState.player === "ai" ? "top-32" : "bottom-48"}`}
                  >
                    <div className="bg-gradient-to-r from-amber-950/95 to-[#3a1506]/95 border border-amber-500/30 px-8 py-4 rounded-2xl shadow-xl flex flex-col items-center gap-1">
                      <span className="text-amber-400 font-sans font-black uppercase text-xs tracking-[0.2em]">
                        {noPlayState.player === "user" ? "Vous passez votre tour" : "L'IA passe son tour"}
                      </span>
                    </div>
                  </motion.div>
                )}
              </AnimatePresence>



              {/* ── Center round-end toast (replaces popup) ─────────── */}
              <AnimatePresence>
                {centerToast && !tallyAnimation.active && (
                  <motion.div
                    key={`toast-${round}`}
                    initial={{ opacity: 0, y: 60, scale: 0.85 }}
                    animate={{ opacity: 1, y: 0,  scale: 1 }}
                    exit={{ opacity: 0, y: -30, scale: 0.9 }}
                    transition={{ type: "spring", stiffness: 380, damping: 28 }}
                    className="absolute inset-x-0 top-1/2 -translate-y-1/2 z-50 flex justify-center pointer-events-none"
                  >
                    <div
                      className="flex flex-col items-center gap-1.5 px-8 py-4 rounded-2xl shadow-2xl"
                      style={{
                        background: centerToast.winner === "user"
                          ? "linear-gradient(135deg, rgba(16,42,16,0.97) 0%, rgba(5,20,5,0.97) 100%)"
                          : centerToast.winner === "ai"
                          ? "linear-gradient(135deg, rgba(42,10,10,0.97) 0%, rgba(20,5,5,0.97) 100%)"
                          : "linear-gradient(135deg, rgba(28,24,10,0.97) 0%, rgba(12,10,3,0.97) 100%)",
                        border: `1px solid ${
                          centerToast.winner === "user" ? "rgba(52,211,153,0.4)"
                          : centerToast.winner === "ai" ? "rgba(239,68,68,0.4)"
                          : "rgba(212,175,55,0.4)"
                        }`,
                        boxShadow: centerToast.winner === "user"
                          ? "0 0 40px rgba(52,211,153,0.25), 0 20px 40px rgba(0,0,0,0.7)"
                          : centerToast.winner === "ai"
                          ? "0 0 40px rgba(239,68,68,0.25), 0 20px 40px rgba(0,0,0,0.7)"
                          : "0 0 40px rgba(212,175,55,0.25), 0 20px 40px rgba(0,0,0,0.7)",
                      }}
                    >
                      {/* Icon */}
                      <span className="text-3xl leading-none">
                        {centerToast.winner === "user" ? "🏆" : centerToast.winner === "ai" ? "🤖" : "🤝"}
                      </span>

                      {/* Label */}
                      <span
                        className="text-sm font-black uppercase tracking-widest"
                        style={{
                          color: centerToast.winner === "user" ? "#34d399"
                            : centerToast.winner === "ai" ? "#f87171"
                            : "#fbbf24",
                        }}
                      >
                        {centerToast.winner === "user" ? "Round Gagné !" : centerToast.winner === "ai" ? "Round Perdu" : "Égalité"}
                      </span>

                      {/* Points */}
                      {centerToast.points > 0 && (
                        <motion.span
                          initial={{ scale: 0.5, opacity: 0 }}
                          animate={{ scale: 1, opacity: 1 }}
                          transition={{ delay: 0.15, type: "spring", stiffness: 500, damping: 20 }}
                          className="text-2xl font-black font-mono"
                          style={{
                            color: centerToast.winner === "user" ? "#6ee7b7" : "#fca5a5",
                            textShadow: "0 0 12px currentColor",
                          }}
                        >
                          {centerToast.winner === "user" ? "+" : "+"}{centerToast.points} pts
                        </motion.span>
                      )}
                    </div>
                  </motion.div>
                )}
              </AnimatePresence>

              {/* Match or Manche Winner Popup Overlay */}
              {(matchWinner || mancheWinner) && (() => {
                const isMatchEnd = matchWinner !== null;
                const activeWinner = matchWinner || mancheWinner;
                const isUserWinner = activeWinner === "user";
                const username = gameType === "team" ? "Équipe Rouge" : (userProfile?.username || "maestro10");
                const opponentName = gameType === "team" ? "Équipe Bleue" : "bot_op";

                // Share message (only for Match winner)
                const shareMessage = `🏆 Maestro Domino : ${isUserWinner ? "Victoire !" : "Défaite"} 🀰\n🎯 Score du Match : ${roundsWonUser} - ${roundsWonAi}\nRejoignez-moi sur maestro-sooty.vercel.app`;

                const handleShareClick = async () => {
                  if (navigator.share) {
                    try {
                      await navigator.share({
                        title: "Maestro Domino",
                        text: shareMessage,
                        url: "https://maestro-sooty.vercel.app/"
                      });
                    } catch (err) {
                      console.error("Error sharing:", err);
                    }
                  } else {
                    try {
                      await navigator.clipboard.writeText(shareMessage);
                      alert("Score copié dans le presse-papiers ! 📋");
                    } catch (err) {
                      console.error("Failed to copy:", err);
                    }
                  }
                };

                return (
                  <div className="absolute inset-0 z-55 flex flex-col items-center justify-center bg-black/75 backdrop-blur-sm p-4 animate-fade-in font-sans">
                    <div className="relative w-full max-w-[310px] flex flex-col items-center">
                      
                      {/* Shield Container */}
                      <div 
                        className="relative w-full bg-gradient-to-b from-stone-200 via-stone-300 to-stone-400 p-[3px] shadow-[0_20px_45px_rgba(0,0,0,0.85)] rounded-t-[2.2rem]"
                        style={{ 
                          clipPath: "polygon(0 0, 100% 0, 100% 82%, 50% 100%, 0 82%)"
                        }}
                      >
                        <div 
                          className="w-full bg-[#faf9f6] p-[1.5px] rounded-t-[2.1rem] overflow-hidden"
                          style={{ clipPath: "polygon(0 0, 100% 0, 100% 82%, 50% 100%, 0 82%)" }}
                        >
                          <div 
                            className="w-full bg-gradient-to-b from-[#faf9f6] to-[#f4f1ea] border-2 border-[#d4af37]/65 px-3 pt-14 pb-12 flex flex-col items-center justify-between min-h-[340px]"
                            style={{ 
                              clipPath: "polygon(0 0, 100% 0, 100% 82%, 50% 100%, 0 82%)",
                              borderRadius: "2.0rem 2.0rem 0 0"
                            }}
                          >
                            {/* Score summary text */}
                            <span className="text-stone-700 font-sans font-extrabold text-[10px] uppercase tracking-wider mb-4 mt-2">
                              {isMatchEnd ? (
                                isUserWinner 
                                  ? `Vous remportez le Match ${roundsWonUser} manches à ${roundsWonAi}`
                                  : `Vous perdez le Match ${roundsWonAi} manches à ${roundsWonUser}`
                              ) : (
                                `Manche terminée — Score : ${scoreUser} - ${scoreAi}`
                              )}
                            </span>

                            {/* Matchup section */}
                            <div className="flex items-center justify-between w-full px-1 relative my-2">
                              {/* User column */}
                              <div className="flex flex-col items-center flex-1">
                                <div className="relative w-[84px] h-[84px] rounded-xl overflow-hidden border-2 border-stone-800 bg-[#3a1506] shadow-md flex items-center justify-center shrink-0">
                                  <span className="text-4xl select-none">😎</span>
                                  {isUserWinner && (
                                    <div className="absolute bottom-0 left-0 right-0 py-0.5 bg-gradient-to-b from-red-500 to-red-600 text-white text-[8px] font-black uppercase tracking-widest text-center border-t border-red-400">
                                      WINNER
                                    </div>
                                  )}
                                </div>
                                <span className="text-stone-600 text-[9px] font-black tracking-wider uppercase truncate max-w-[80px] mt-2">
                                  {username}
                                </span>
                                <span className="text-[#d95d1e] text-3xl font-sans font-black tracking-tighter mt-1">
                                  {isMatchEnd ? `${roundsWonUser} m.` : `${scoreUser} pts`}
                                </span>
                              </div>

                              {/* VS Badge */}
                              <div className="absolute left-1/2 top-[42px] -translate-x-1/2 -translate-y-1/2 z-10 flex items-center justify-center">
                                <span className="text-amber-500 font-sans font-black italic text-sm px-2 py-0.5 bg-amber-100/90 border border-amber-300/80 rounded shadow-sm rotate-[-12deg] tracking-wider">
                                  vs
                                </span>
                              </div>

                              {/* Opponent column */}
                              <div className="flex flex-col items-center flex-1">
                                <div className="relative w-[84px] h-[84px] rounded-xl overflow-hidden border-2 border-stone-850 bg-[#1e0a02] shadow-md flex items-center justify-center shrink-0">
                                  <span className="text-4xl select-none">🤖</span>
                                  {!isUserWinner && (
                                    <div className="absolute bottom-0 left-0 right-0 py-0.5 bg-gradient-to-b from-red-500 to-red-600 text-white text-[8px] font-black uppercase tracking-widest text-center border-t border-red-400">
                                      WINNER
                                    </div>
                                  )}
                                </div>
                                <span className="text-stone-600 text-[9px] font-black tracking-wider uppercase truncate max-w-[80px] mt-2">
                                  {opponentName}
                                </span>
                                <span className="text-stone-800 text-3xl font-sans font-black tracking-tighter mt-1">
                                  {isMatchEnd ? `${roundsWonAi} m.` : `${scoreAi} pts`}
                                </span>
                              </div>
                            </div>

                            {/* Share button nested inside the V shape of the shield */}
                            {isMatchEnd ? (
                              <button 
                                onClick={handleShareClick}
                                className="w-9 h-9 rounded-full bg-stone-700 hover:bg-stone-600 flex items-center justify-center text-white cursor-pointer active:scale-95 transition-all shadow-md mt-4 relative z-20"
                              >
                                <Share2 size={14} />
                              </button>
                            ) : (
                              <div className="text-[10px] text-stone-500 font-bold uppercase tracking-wider mt-4">
                                Match : {roundsWonUser} - {roundsWonAi}
                              </div>
                            )}
                          </div>
                        </div>
                      </div>

                      {/* Floating Top Banner (arched overlay) */}
                      <div 
                        className={`absolute -top-7 left-1/2 -translate-x-1/2 w-[92%] py-3 shadow-[0_8px_16px_rgba(0,0,0,0.55)] text-center rounded-xl rotate-[-2deg] border-t-4 border-b-4 ${
                          isUserWinner 
                            ? "bg-gradient-to-r from-red-600 via-red-500 to-red-600 border-amber-400" 
                            : "bg-gradient-to-r from-stone-800 via-stone-700 to-stone-800 border-stone-500"
                        }`}
                      >
                        <span 
                          className="text-white font-sans font-black italic tracking-widest text-xl uppercase select-none"
                          style={{
                            textShadow: "1px 2px 3px rgba(0,0,0,0.85)",
                            WebkitTextStroke: "0.5px rgba(255,255,255,0.15)"
                          }}
                        >
                          {isMatchEnd ? (isUserWinner ? "VICTOIRE !" : "DÉFAITE") : "MANCHE GAGNÉE !"}
                        </span>
                      </div>

                      {/* Action Buttons Section */}
                      <div className="flex flex-col items-center mt-5 w-full space-y-3.5">
                        {(!isMatchEnd && mancheCountdown !== null) ? (
                          <div className="flex flex-col items-center gap-2">
                            <div className="text-center font-bold text-[10px] text-amber-400 uppercase tracking-[0.25em] animate-pulse">
                              Manche suivante dans
                              <div className="text-3xl font-black font-mono mt-1 text-white">{mancheCountdown}</div>
                            </div>
                            <button
                              onClick={handleResetScores}
                              className="mt-2.5 flex items-center justify-center gap-1.5 py-2.5 px-6 bg-stone-600 hover:bg-stone-500 text-white font-bold tracking-widest uppercase rounded-xl border-b-4 border-stone-850 active:scale-95 active:border-b-0 transition-all cursor-pointer shadow-md text-[9px]"
                            >
                              <X size={12} /> Quitter
                            </button>
                          </div>
                        ) : (isMatchEnd && matchCountdown !== null) ? (
                          <div className="flex flex-col items-center gap-2">
                            <div className="text-center font-bold text-[10px] text-amber-400 uppercase tracking-[0.25em] animate-pulse">
                              Nouveau match dans
                              <div className="text-3xl font-black font-mono mt-1 text-white">{matchCountdown}</div>
                            </div>
                            <button
                              onClick={handleResetScores}
                              className="mt-2.5 flex items-center justify-center gap-1.5 py-2.5 px-6 bg-stone-600 hover:bg-stone-500 text-white font-bold tracking-widest uppercase rounded-xl border-b-4 border-stone-850 active:scale-95 active:border-b-0 transition-all cursor-pointer shadow-md text-[9px]"
                            >
                              <X size={12} /> Quitter
                            </button>
                          </div>
                        ) : (
                          <button
                            onClick={handleResetScores}
                            className="flex items-center justify-center gap-1.5 py-3.5 bg-stone-600 text-white font-bold tracking-widest uppercase rounded-xl border-b-4 border-stone-800 hover:bg-stone-500 active:scale-95 active:border-b-0 transition-all cursor-pointer shadow-md text-[10px] w-full max-w-[280px]"
                          >
                            <X size={13} /> Quitter
                          </button>
                        )}
                      </div>
                    </div>
                  </div>
                );
              })()}

              {/* Game Board */}
              <div className="flex-1 relative w-full pb-8 min-h-0">
                 <GameBoard 
                   placedTiles={placedTiles}
                   selectedTile={selectedTile}
                   onPlayTile={handlePlayTile}
                   currentPlayer={currentPlayer}
                   onDropTile={playTileForUser}
                   scorePopup={centerScorePopup}
                   hoveredSlotSide={hoveredSlotSide}
                   highlightedTileId={revealData?.winningTileId}
                 />
              </div>

              {/* Floating Pass Button (Overlay near bottom of game board) */}
              {currentPlayer === "user" && !userCanPlay && (!(gameMode === "draw" || gameMode === "all-fives") || boneyard.length === 0) && matchStatus === "ongoing" && !matchWinner && !noPlayState.active && !matchEndPendingRef.current && (
                <div className="absolute bottom-14 right-4 z-30">
                  <button
                    onClick={handleUserPass}
                    className="px-4 py-2.5 bg-red-600 hover:bg-red-700 text-white font-bold text-xs uppercase tracking-widest rounded-xl shadow-lg border border-red-500 animate-pulse cursor-pointer transition-all active:scale-95"
                  >
                    Pass
                  </button>
                </div>
              )}

              {/* Thin Info Bar - Sombre & Épuré containing only Board and Boneyard */}
              <div className="absolute bottom-0 w-full bg-zinc-950 border-t border-white/5 text-center py-2.5 z-20 flex justify-center items-center">
                 <span className="text-white text-[11px] font-black uppercase tracking-[0.15em] flex gap-4">
                   <span>Board {placedTiles.length > 0 ? ScoreEngine.calculateBoardScore(placedTiles) : 0}</span>
                   <span className="text-white/20">|</span>
                   <span>Boneyard {boneyard.length}</span>
                 </span>
              </div>
            </div>

            {/* Bottom Player Hand Area */}
            <div 
              className={`relative bg-[url('https://www.transparenttextures.com/patterns/wood-pattern.png')] bg-[#5a2e12] border-t-4 border-[#3e1a06] py-3 px-2 h-[120px] flex items-center overflow-x-auto no-scrollbar shadow-[inset_0_8px_15px_rgba(0,0,0,0.7)] shrink-0 ${userHand.length > 5 ? "justify-start" : "justify-center"}`}
              style={{ justifyContent: "safe center", backgroundBlendMode: "multiply" }}
            >
                <div className="flex gap-0.5 sm:gap-1">
                  <AnimatePresence mode="popLayout">
                    {[...userHand].sort((a, b) => {
                      const sumA = a[0] + a[1];
                      const sumB = b[0] + b[1];
                      if (sumA !== sumB) return sumB - sumA;
                      return Math.max(b[0], b[1]) - Math.max(a[0], a[1]);
                    }).map(tile => {
                       const isPlayable = showAnalysis 
                         ? (currentAnalysis.recommendations.find(r => (r.tile[0] === tile[0] && r.tile[1] === tile[1]) || (r.tile[1] === tile[0] && r.tile[0] === tile[1]))?.isPlayable ?? true) 
                         : true;
                       const isDragging = draggedTile !== null && draggedTile[0] === tile[0] && draggedTile[1] === tile[1];

                       return (
                         <motion.div
                           key={`${tile[0]}-${tile[1]}`}
                           layout
                           initial={{ opacity: 0, scale: 0.8, y: 15 }}
                           animate={{ 
                             opacity: isDragging ? 0 : 1, 
                             scale: isDragging ? 0.9 : 1,
                             y: 0 
                           }}
                           exit={{ opacity: 0, scale: 0.8, y: 15 }}
                           transition={{ type: "spring", stiffness: 350, damping: 28 }}
                           className="relative shrink-0 overflow-visible"
                           ref={(node) => {
                              if (!node) return;
                              // Native non-passive touchstart
                              const onNativeTouch = (ev: TouchEvent) => {
                                if (currentPlayer !== "user" || matchStatus !== "ongoing" || isDealing || !!matchWinner || matchEndPendingRef.current) return;
                                // We DO NOT preventDefault here to allow native horizontal scroll to start.
                                const t = ev.touches[0];
                                if (!t) return;
                                const rect = (ev.currentTarget as HTMLElement).getBoundingClientRect();
                                dragStartPointerRef.current = { x: t.clientX, y: t.clientY };
                                latestPointerPosRef.current = { x: t.clientX, y: t.clientY };
                                dragStartOffsetRef.current  = { x: t.clientX - rect.left, y: t.clientY - rect.top };
                                activeDragTileRef.current   = tile;
                                dragActiveRef.current       = false;
                                draggedHappenedRef.current  = false;
                                hoveredSlotSideRef.current  = null;
                                hoveredSlotIsVerticalRef.current = true;
                                snappedTileValuesRef.current = null;
                                setDraggedTile(null);
                                setDragStartOffset(null);
                                setHoveredSlotSide(null);
                                setHoveredSlotIsVertical(true);
                                setSnappedTileValues(null);
                                if (dragRafRef.current) cancelAnimationFrame(dragRafRef.current);
                                dragRafRef.current = requestAnimationFrame(updateDragVisuals);
                                attachGlobalListeners(tile);
                              };
                              // Remove previous listener to avoid duplicates, then re-add
                              node.removeEventListener('touchstart', onNativeTouch as EventListener);
                              node.addEventListener('touchstart', onNativeTouch as EventListener, { passive: false });
                            }}
                         >
                           <DominoTile 
                             tile={tile} 
                             isVertical={true} 
                             onClick={() => {
                               if (draggedHappenedRef.current) {
                                 draggedHappenedRef.current = false;
                                 return;
                               }
                               selectUserTile(tile);
                             }}
                             onPointerDown={(e) => handlePointerDown(e, tile)}
                             onPointerMove={(e) => handlePointerMove(e, tile)}
                             onPointerUp={(e) => handlePointerUp(e, tile)}
                             onPointerCancel={(e) => handlePointerCancel(e, tile)}
                             draggable={false}
                             highlighted={selectedTile !== null && selectedTile[0] === tile[0] && selectedTile[1] === tile[1]}
                             disabled={currentPlayer !== "user" || matchStatus !== "ongoing" || (!isPlayable && showAnalysis) || !!matchWinner || isDealing}
                           />
                         </motion.div>
                       );
                    })}
                  </AnimatePresence>
                </div>
            </div>
            
            {/* Draw from Boneyard Overlay */}
            {currentPlayer === "user" && boneyard.length > 0 && matchStatus === "ongoing" && (gameMode === "draw" || gameMode === "all-fives") && !matchWinner && !isDealing && ((!userCanPlay && !noPlayState.active) || (noPlayState.active && noPlayState.step === "await_user_draw")) && (
              <BoneyardView 
                boneyard={boneyard} 
                onDrawTile={handleUserDraw} 
              />
            )}

            {/* Initial manual draw deal phase overlay (Feature 3) */}
            {isDealing && (
              <BoneyardView
                boneyard={boneyard}
                onDrawTile={handleInitialDraw}
                isDealingMode={true}
                disabled={currentPlayer !== "user"}
                title={currentPlayer === "user" ? "Initial Deal" : "AI Turn to Draw"}
                subtitle={
                  currentPlayer === "user"
                    ? `Draw domino ${userHand.length + 1} of 7`
                    : `AI is drawing domino ${aiHand.length + 1} of 7`
                }
              />
            )}

            {/* Floating drag tile — always mounted so ref is always valid */}
            <div
              ref={floatingTileRef}
              className="fixed pointer-events-none z-[9999]"
              style={{
                left: `-9999px`,
                top: `-9999px`,
                // Use display:none when not dragging so it stays off-screen cleanly
                display: (draggedTile && dragStartOffset) ? "block" : "none",
                transform: hoveredSlotSide
                  ? "rotate(0deg) scale(1.15)"          // snapped: flat + bigger
                  : "rotate(-6deg) scale(1.1)",         // free: slight tilt
                filter: hoveredSlotSide
                  ? "drop-shadow(0 0 20px rgba(251,191,36,0.95)) drop-shadow(0 8px 10px rgba(0,0,0,0.5))"
                  : "drop-shadow(0 16px 12px rgba(0,0,0,0.55))",
                transition: "transform 0.12s ease, filter 0.12s ease",
                willChange: "left, top, transform",
              }}
            >
              {draggedTile && (
                <DominoTile
                  tile={snappedTileValues || draggedTile}
                  isVertical={hoveredSlotSide ? hoveredSlotIsVertical : true}
                  size="md"
                />
              )}
            </div>

          </div>
        )}

        {currentScreen === "scores" && (
          <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-250 overflow-hidden font-sans">
            <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between">
              <button onClick={() => setCurrentScreen("home")} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer">
                <ChevronLeft size={20} /> Back
              </button>
              <h2 className="text-base font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">Match History</h2>
              <div className="w-10"></div>
            </header>

            <div className="flex-1 overflow-y-auto p-4 space-y-4 no-scrollbar">
              {/* Stats Cards */}
              <div className="grid grid-cols-2 gap-3">
                <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center">
                  <span className="text-[10px] text-gray-500 uppercase font-mono tracking-wider font-bold">Matches Played</span>
                  <span className="block text-3xl font-black text-white mt-1.5">{matchHistory.length}</span>
                </div>
                <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 text-center">
                  <span className="text-[10px] text-gray-500 uppercase font-mono tracking-wider font-bold">Win Rate</span>
                  <span className="block text-3xl font-black text-emerald-400 mt-1.5">
                    {matchHistory.length > 0 
                      ? Math.round((matchHistory.filter(h => h.winner === "user").length / matchHistory.length) * 100) 
                      : 0}%
                  </span>
                </div>
              </div>

              {/* Match Logs List */}
              <h3 className="text-[10px] uppercase font-mono font-bold tracking-wider text-gray-500 pl-1">Recent Matches</h3>
              {matchHistory.length === 0 ? (
                <div className="text-center text-xs text-gray-500 py-12 bg-[#121212]/50 border border-gray-850 rounded-2xl">
                  No completed matches yet.<br />Play a game to start logging scores!
                </div>
              ) : (
                <div className="space-y-2">
                  {matchHistory.map((entry) => (
                    <div key={entry.id} className="bg-[#121212] border border-gray-800/80 rounded-xl p-3.5 flex justify-between items-center shadow-sm">
                      <div className="space-y-1">
                        <div className="flex items-center gap-2">
                          <span className={`text-[9px] px-2 py-0.5 rounded font-black uppercase tracking-wider ${
                            entry.winner === "user" ? "bg-emerald-500/10 text-emerald-400 border border-emerald-500/20" : "bg-red-500/10 text-red-400 border border-red-500/20"
                          }`}>
                            {entry.winner === "user" ? "Win" : "Loss"}
                          </span>
                          <span className="text-[9px] uppercase font-mono tracking-wider text-gray-400">{entry.gameType === "team" ? "Team Play" : "1v1 Duel"}</span>
                        </div>
                        <span className="text-[10px] text-gray-500 block font-mono">{entry.date}</span>
                      </div>
                      <div className="text-right space-y-0.5">
                        <span className="font-mono font-bold text-sm text-white">{entry.scoreUser} - {entry.scoreAi}</span>
                        <span className="block text-[9px] text-gray-500">Goal: {entry.targetScore} pts</span>
                      </div>
                    </div>
                  ))}
                </div>
              )}
            </div>

            {/* Bottom Nav spacer */}
            <div className="h-16 shrink-0 bg-[#0c0c0c] border-t border-gray-800/80 flex justify-around items-center mt-auto">
              <button onClick={() => setCurrentScreen("home")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
                <Gamepad2 size={20} />
                <span className="text-[10px] font-medium tracking-wider">Play</span>
              </button>
              <button onClick={() => setCurrentScreen("leaderboard")} className="flex flex-col items-center justify-center w-1/3 text-amber-500 gap-1 cursor-pointer">
                <Trophy size={20} />
                <span className="text-[10px] font-bold tracking-wider">Scores</span>
              </button>
              <button onClick={() => setCurrentScreen("settings")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
                <Settings size={20} />
                <span className="text-[10px] font-medium tracking-wider">Settings</span>
              </button>
            </div>
          </div>
        )}

        {currentScreen === "settings" && (
          <div className="flex flex-col h-full bg-[#0a0a0a] text-gray-200 overflow-hidden font-sans">
            <header className="p-4 border-b border-gray-800 bg-[#0c0c0c] flex items-center justify-between">
              <button onClick={() => setCurrentScreen("home")} className="text-gray-400 hover:text-white flex items-center gap-1 cursor-pointer">
                <ChevronLeft size={20} /> Back
              </button>
              <h2 className="text-base font-extrabold text-transparent bg-clip-text bg-gradient-to-r from-amber-400 to-yellow-600">Settings</h2>
              <div className="w-10"></div>
            </header>

            <div className="flex-1 overflow-y-auto p-4 space-y-5 no-scrollbar pb-8">
              {/* 1. LOBBY CONFIGURATION */}
              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 space-y-4">
                <h3 className="text-xs uppercase text-amber-500 font-bold tracking-wider font-mono">Lobby settings</h3>
                
                {/* Game Format Selection */}
                <div className="space-y-2">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Game Format</label>
                  <div className="flex bg-[#181818] p-1 rounded-xl">
                    <div
                      className="w-full py-2 text-xs font-bold rounded-lg text-center bg-gray-800 text-amber-500 shadow-sm"
                    >
                      Individual (1v1)
                    </div>
                  </div>
                </div>

                {/* Rules Mode Selection */}
                <div className="space-y-2">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Rules Mode</label>
                  <div className="flex bg-[#181818] p-1 rounded-xl">
                    <div
                      className="w-full py-2 text-xs font-bold rounded-lg text-center bg-gray-800 text-amber-500 shadow-sm"
                    >
                      Fives (Flycops)
                    </div>
                  </div>
                </div>

                {/* Target Score Selection */}
                <div className="space-y-2">
                  <div className="flex justify-between items-center">
                    <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Victory Target</label>
                    {!adminConfig.allowCustomTarget && (
                      <span className="text-[9px] text-amber-600/80 font-bold uppercase tracking-wider font-mono flex items-center gap-0.5">🔒 Lock by Admin</span>
                    )}
                  </div>
                  {adminConfig.allowCustomTarget ? (
                    <div className="grid grid-cols-4 gap-1 bg-[#181818] p-1 rounded-xl">
                      {([50, 100, 150, 200] as number[]).map(val => {
                        const isEnabled = adminConfig.enabledTargets[val as 50 | 100 | 150 | 200];
                        return (
                          <button
                            key={val}
                            disabled={!isEnabled}
                            onClick={() => setTargetScore(val)}
                            className={`py-2 text-xs font-semibold rounded-lg transition-all cursor-pointer ${
                              !isEnabled 
                                ? "text-gray-700 cursor-not-allowed opacity-25" 
                                : targetScore === val 
                                  ? "bg-gray-800 text-amber-500 font-bold shadow-sm" 
                                  : "text-gray-400 hover:text-gray-250 hover:bg-gray-800/10"
                            }`}
                          >
                            {val} pts
                          </button>
                        );
                      })}
                    </div>
                  ) : (
                    <div className="py-2.5 px-3 bg-gray-900 border border-gray-850 text-center rounded-xl text-xs font-semibold text-gray-400 font-mono">
                      {adminConfig.defaultTarget} pts
                    </div>
                  )}
                </div>

                {/* Match Mode Selection */}
                <div className="space-y-2 pt-2 border-t border-gray-800/35">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Mode du Match</label>
                  <div className="grid grid-cols-3 gap-1 bg-[#181818] p-1 rounded-xl">
                    {(["single", "first_to", "fixed"] as const).map(mode => {
                      const labels = { single: "Unique", first_to: "Premier à", fixed: "Nombre Fixe" };
                      return (
                        <button
                          key={mode}
                          onClick={() => {
                            setMatchMode(mode);
                            if (mode === "single") setTargetManches(1);
                            else if (mode === "first_to") setTargetManches(3); // default first to 3 wins (BO5)
                            else if (mode === "fixed") setTargetManches(4); // default 4 rounds
                          }}
                          className={`py-2 text-[10px] font-semibold rounded-lg transition-all cursor-pointer ${
                            matchMode === mode 
                              ? "bg-gray-800 text-amber-500 font-bold shadow-sm" 
                              : "text-gray-400 hover:text-gray-250 hover:bg-gray-800/10"
                          }`}
                        >
                          {labels[mode]}
                        </button>
                      );
                    })}
                  </div>
                </div>

                {/* Match Target Manches Selection */}
                {matchMode !== "single" && (
                  <div className="space-y-2 pt-2 border-t border-gray-800/35">
                    <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">
                      {matchMode === "first_to" ? "Manches pour gagner" : "Nombre de manches à jouer"}
                    </label>
                    <div className="grid grid-cols-5 gap-1 bg-[#181818] p-1 rounded-xl">
                      {(matchMode === "first_to" ? [2, 3, 5, 7] : [3, 4, 5, 6, 10]).map(val => {
                        return (
                          <button
                            key={val}
                            onClick={() => setTargetManches(val)}
                            className={`py-2 text-[10px] font-semibold rounded-lg transition-all cursor-pointer ${
                              targetManches === val 
                                ? "bg-gray-800 text-amber-500 font-bold shadow-sm" 
                                : "text-gray-400 hover:text-gray-250 hover:bg-gray-800/10"
                            }`}
                          >
                            {val}
                          </button>
                        );
                      })}
                    </div>
                  </div>
                )}

                {/* Dealing Method Selection (Feature 1) */}
                <div className="space-y-2 pt-2 border-t border-gray-800/35">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Dealing Method</label>
                  <div className="grid grid-cols-2 gap-1 bg-[#181818] p-1 rounded-xl">
                    <button
                      onClick={() => {
                        setDealOption("manual");
                        localStorage.setItem("maestro_domino_deal_option", "manual");
                      }}
                      className={`py-2 text-xs font-semibold rounded-lg transition-all cursor-pointer ${dealOption === "manual" ? "bg-gray-800 text-amber-500 font-bold shadow-sm" : "text-gray-400 hover:text-gray-200"}`}
                    >
                      Manual Draw
                    </button>
                    <button
                      onClick={() => {
                        setDealOption("auto");
                        localStorage.setItem("maestro_domino_deal_option", "auto");
                      }}
                      className={`py-2 text-xs font-semibold rounded-lg transition-all cursor-pointer ${dealOption === "auto" ? "bg-gray-800 text-amber-500 font-bold shadow-sm" : "text-gray-400 hover:text-gray-200"}`}
                    >
                      Automatic Deal
                    </button>
                  </div>
                </div>
              </div>

              {/* 2. ADMIN CONFIGURATION SECTION */}
              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 space-y-4">
                <div className="flex items-center gap-2">
                  <span className="h-1.5 w-1.5 rounded-full bg-red-500 animate-pulse"></span>
                  <h3 className="text-xs uppercase text-red-500 font-bold tracking-wider font-mono">Admin Control Panel</h3>
                </div>

                {/* Default Target Score Option */}
                <div className="space-y-2">
                  <label className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider">Default Game Target</label>
                  <div className="grid grid-cols-4 gap-1 bg-[#181818] p-1 rounded-xl">
                    {([50, 100, 150, 200] as number[]).map(val => (
                      <button
                        key={val}
                        onClick={() => {
                          const nextConfig = { ...adminConfig, defaultTarget: val as 50 | 100 | 150 | 200 };
                          setAdminConfig(nextConfig);
                          localStorage.setItem("maestro_domino_admin_config", JSON.stringify(nextConfig));
                          if (!adminConfig.allowCustomTarget) {
                            setTargetScore(val);
                          }
                        }}
                        className={`py-2 text-xs font-semibold rounded-lg transition-all cursor-pointer ${adminConfig.defaultTarget === val ? "bg-gray-800 text-red-400 font-bold shadow-sm" : "text-gray-400 hover:text-gray-200"}`}
                      >
                        {val} pts
                      </button>
                    ))}
                  </div>
                </div>

                {/* Allow Customize Toggle */}
                <div className="flex justify-between items-center py-1 border-t border-gray-800/30 pt-3">
                  <span className="text-xs text-gray-300 font-semibold">Allow Custom Targets in Lobby</span>
                  <button
                    onClick={() => {
                      const nextConfig = { ...adminConfig, allowCustomTarget: !adminConfig.allowCustomTarget };
                      setAdminConfig(nextConfig);
                      localStorage.setItem("maestro_domino_admin_config", JSON.stringify(nextConfig));
                      if (!nextConfig.allowCustomTarget) {
                        setTargetScore(nextConfig.defaultTarget);
                      }
                    }}
                    className={`px-3 py-1.5 text-[10px] font-black uppercase tracking-wider rounded-lg transition-all cursor-pointer ${
                      adminConfig.allowCustomTarget 
                        ? "bg-emerald-500/10 text-emerald-400 border border-emerald-500/30" 
                        : "bg-red-500/10 text-red-400 border border-red-500/30"
                    }`}
                  >
                    {adminConfig.allowCustomTarget ? "Allowed" : "Restricted"}
                  </button>
                </div>

                {/* Enable / Disable Targets */}
                <div className="space-y-2 pt-2 border-t border-gray-800/30">
                  <span className="text-[10px] text-gray-500 uppercase font-mono font-bold tracking-wider block">Allowed Victory Limits</span>
                  <div className="grid grid-cols-2 gap-2">
                    {([50, 100, 150, 200] as number[]).map(val => {
                      const isEnabled = adminConfig.enabledTargets[val as 50 | 100 | 150 | 200];
                      return (
                        <button
                          key={val}
                          onClick={() => {
                            const nextTargets = { ...adminConfig.enabledTargets, [val]: !isEnabled };
                            if (!Object.values(nextTargets).some(v => v)) return; // prevent zero enabled targets
                            const nextConfig = { ...adminConfig, enabledTargets: nextTargets };
                            setAdminConfig(nextConfig);
                            localStorage.setItem("maestro_domino_admin_config", JSON.stringify(nextConfig));
                          }}
                          className={`py-2 px-3 text-[11px] font-bold rounded-lg border text-center transition-all cursor-pointer ${
                            isEnabled 
                              ? "bg-gray-900 border-red-500/30 text-red-450" 
                              : "bg-[#181818] border-gray-800 text-gray-500"
                          }`}
                        >
                          {val} pts : {isEnabled ? "ON" : "OFF"}
                        </button>
                      );
                    })}
                  </div>
                </div>
              </div>

              {/* 3. SIMULATION & DISCONNECTS */}
              <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 space-y-3">
                <h3 className="text-xs uppercase text-gray-400 font-bold tracking-wider font-mono">Sync & Reconnect Simulation</h3>
                <p className="text-[10px] text-gray-500 leading-normal font-sans">
                  Refresh active games. Clicking this will reload the board state from local storage, simulating player reconnection without double scoring.
                </p>
                <button
                  disabled={isSimulatingReconnection || matchStatus === "not-started"}
                  onClick={() => {
                    setIsSimulatingReconnection(true);
                    setTimeout(() => {
                      setIsSimulatingReconnection(false);
                      const saved = localStorage.getItem("maestro_domino_state");
                      if (saved) {
                        const parsed = JSON.parse(saved);
                        setScoreUser(parsed.scoreUser);
                        setScoreAi(parsed.scoreAi);
                        setUserHand(parsed.userHand);
                        setAiHand(parsed.aiHand);
                        setBoneyard(parsed.boneyard);
                        setPlacedTiles(parsed.placedTiles);
                        setCurrentPlayer(parsed.currentPlayer);
                        setMatchStatus(parsed.matchStatus);
                        setRound(parsed.round);
                        setWinner(parsed.winner);
                        setTargetScore(parsed.targetScore);
                        setGameType(parsed.gameType);
                        setGameMode(parsed.gameMode ?? "all-fives");
                        setMatchWinner(parsed.matchWinner);
                        
                        setLogs(prev => [
                          createLog("system", "🔄 Network re-established. Board state synchronized successfully from localStorage!", "system"),
                          ...prev
                        ]);
                      }
                    }, 1000);
                  }}
                  className={`w-full py-3 rounded-xl font-bold text-xs uppercase tracking-wider border transition-all ${
                    matchStatus === "not-started"
                      ? "text-gray-600 border-gray-850 bg-gray-900 cursor-not-allowed opacity-50"
                      : "bg-[#161a22] border-blue-500/30 text-blue-400 hover:bg-[#1f2633] active:scale-95 cursor-pointer"
                  }`}
                >
                  {isSimulatingReconnection ? "Syncing Board State..." : "🔄 Simulate Reconnection"}
                </button>
              </div>

              {/* 3. PROFILE & PREFERENCES */}
              {userProfile && (
                <div className="bg-[#121212] border border-gray-800/80 rounded-2xl p-4 space-y-4">
                  <h3 className="text-xs uppercase text-amber-500 font-bold tracking-wider font-mono">Profil & Langue</h3>
                  <button
                    onClick={() => {
                      setProfileModalPlayerId(userProfile.id);
                      setShowProfileModal(true);
                    }}
                    className="w-full flex items-center justify-between p-3 bg-[#181818] border border-gray-800/50 rounded-xl hover:border-amber-500/50 transition-all cursor-pointer text-left"
                  >
                    <div className="flex items-center gap-2">
                      <Globe className="text-amber-500 w-4 h-4" />
                      <div>
                        <span className="text-xs font-bold text-white block">Modifier mes préférences</span>
                        <span className="text-[10px] text-gray-500">Langue, Pays, Fuseau horaire, Invitations</span>
                      </div>
                    </div>
                    <ChevronLeft size={16} className="rotate-180 text-gray-500" />
                  </button>
                </div>
              )}
            </div>

            {/* Bottom Nav spacer */}
            <div className="h-16 shrink-0 bg-[#0c0c0c] border-t border-gray-800/80 flex justify-around items-center mt-auto">
              <button onClick={() => setCurrentScreen("home")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
                <Gamepad2 size={20} />
                <span className="text-[10px] font-medium tracking-wider">{t("menu.play")}</span>
              </button>
              <button onClick={() => setCurrentScreen("leaderboard")} className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-500 gap-1 cursor-pointer">
                <Trophy size={20} />
                <span className="text-[10px] font-medium tracking-wider">{t("menu.scores")}</span>
              </button>
              <button onClick={() => setCurrentScreen("settings")} className="flex flex-col items-center justify-center w-1/3 text-amber-500 gap-1 cursor-pointer">
                <Settings size={22} />
                <span className="text-[10px] font-bold tracking-wider">{t("menu.settings")}</span>
              </button>
            </div>
          </div>
        )}

      </div>
      {/* Smart PWA install prompt — shown on mobile only, hidden if already installed */}
      <InstallPrompt />
      {userProfile && userProfile.onboarding_completed !== true && (
        <OnboardingWizard profile={userProfile} onComplete={(updatedProfile) => setUserProfile(updatedProfile)} />
      )}
    </div>
  );
}
