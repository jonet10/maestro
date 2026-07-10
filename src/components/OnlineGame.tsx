import React, { useState, useEffect, useRef } from "react";
import { supabase } from "../utils/supabaseClient";
import { Tile, PlacedTile, OnlineRoom } from "../types";
import { GAME_CONFIG } from "../engine/config/GameConfig";
import { getBestMoveForHand } from "../utils/aiStrategy";
import { GameBoard } from "./GameBoard";
import { DominoTile } from "./DominoTile";
import { BoneyardView } from "./BoneyardView";
import { OpponentHand } from "./OpponentHand";
import { calculateBoardScore } from "../utils/scoreEngine";
import { 
  getOpenEnds2D, 
  evaluatePlayability2D, 
  getPlayedTileRotation2D,
  computeTileLayouts
} from "../utils/dominoLogic";
import { 
  MoreVertical, 
  ChevronLeft, 
  Crown, 
  Gamepad2, 
  ArrowRight, 
  ShieldAlert, 
  AlertCircle,
  Clock,
  LogOut,
  RefreshCw,
  Share2,
  RotateCcw,
  X,
  UserPlus
} from "lucide-react";
import { motion, AnimatePresence } from "motion/react";
import { playTilePlacementSound } from "../utils/audioEngine";
import { InviteFriendModal } from "./InviteFriendModal";
import { GameChat } from "./GameChat";

interface OnlineGameProps {
  roomId: string;
  currentUser: any;
  onBackToLobby: () => void;
  onNavigateToGame?: (roomId: string) => void;
}

export function OnlineGame({ roomId, currentUser, onBackToLobby, onNavigateToGame }: OnlineGameProps) {
  const [room, setRoom] = useState<OnlineRoom | null>(null);
  const [hand, setHand] = useState<Tile[]>([]);
  const [selectedTile, setSelectedTile] = useState<Tile | null>(null);
  const [loading, setLoading] = useState(false);
  const isProcessingPlayRef = useRef(false);
  const [errorMsg, setErrorMsg] = useState<string | null>(null);
  const [isOpponentOnline, setIsOpponentOnline] = useState(true);
  const [disconnectTimer, setDisconnectTimer] = useState<number | null>(null); // in seconds
  const [claimingForfeit, setClaimingForfeit] = useState(false);
  const [showInviteModal, setShowInviteModal] = useState(false);

  // Turn timer state (Chronomètre par tour en ligne)
  const [turnTimeLeft, setTurnTimeLeft] = useState<number>(GAME_CONFIG.turnTimerDuration);
  
  // Scoring popup state
  const [scorePopup, setScorePopup] = useState<{ points: number; gridX: number; gridY: number } | null>(null);

  // Rematch & Round automatic countdown states
  const [roundCountdown, setRoundCountdown] = useState<number | null>(null);
  const [matchCountdown, setMatchCountdown] = useState<number | null>(null);

  // Match round wins state
  const [roundsWonCreator, setRoundsWonCreator] = useState<number>(() => {
    return Number(localStorage.getItem(`rounds_won_${roomId}_creator`) || "0");
  });
  const [roundsWonOpponent, setRoundsWonOpponent] = useState<number>(() => {
    return Number(localStorage.getItem(`rounds_won_${roomId}_opponent`) || "0");
  });

  useEffect(() => {
    if (!room) return;

    const creatorId = room.creator_id;
    const opponentId = room.opponent_id;
    const currentRound = room.game_state.round;
    const revealData = room.game_state.revealData;
    const scoreCreator = room.game_state.score_creator;
    const scoreOpponent = room.game_state.score_opponent;

    // 1. Reset check: if scores and round are reset to initial state, reset round wins
    if (currentRound === 1 && scoreCreator === 0 && scoreOpponent === 0) {
      setRoundsWonCreator(0);
      setRoundsWonOpponent(0);
      localStorage.setItem(`rounds_won_${roomId}_creator`, "0");
      localStorage.setItem(`rounds_won_${roomId}_opponent`, "0");
      localStorage.setItem(`last_counted_round_${roomId}`, "0");
      return;
    }

    // 2. Count new round wins if revealData is present and indicates a winner
    if (revealData && revealData.roundWinner) {
      const lastCounted = Number(localStorage.getItem(`last_counted_round_${roomId}`) || "0");
      if (currentRound > lastCounted) {
        let nextCreatorWins = roundsWonCreator;
        let nextOpponentWins = roundsWonOpponent;

        if (revealData.roundWinner === creatorId) {
          nextCreatorWins += 1;
          setRoundsWonCreator(nextCreatorWins);
          localStorage.setItem(`rounds_won_${roomId}_creator`, String(nextCreatorWins));
        } else if (revealData.roundWinner === opponentId) {
          nextOpponentWins += 1;
          setRoundsWonOpponent(nextOpponentWins);
          localStorage.setItem(`rounds_won_${roomId}_opponent`, String(nextOpponentWins));
        }

        localStorage.setItem(`last_counted_round_${roomId}`, String(currentRound));
      }
    }
  }, [room, roomId, roundsWonCreator, roundsWonOpponent]);

  // Drag and drop states
  const [draggedTile, setDraggedTile] = useState<Tile | null>(null);
  const [dragStartOffset, setDragStartOffset] = useState<{ x: number; y: number } | null>(null);
  const [hoveredSlotSide, setHoveredSlotSide] = useState<"left" | "right" | "top" | "bottom" | null>(null);
  const [hoveredSlotIsVertical, setHoveredSlotIsVertical] = useState<boolean>(true);
  const [snappedTileValues, setSnappedTileValues] = useState<Tile | null>(null);

  const dragRafRef = useRef<number | null>(null);
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

  const fetchGameData = async () => {
    if (!supabase) return;
    try {
      // 1. Fetch room
      const { data: roomData, error: roomError } = await supabase
        .from("rooms")
        .select(`
          *,
          creator:creator_id ( username, win_rate ),
          opponent:opponent_id ( username, win_rate )
        `)
        .eq("id", roomId)
        .single();

      if (roomError) {
        setErrorMsg("Impossible de récupérer les détails de la partie.");
        console.error(roomError);
        return;
      }
      
      const onlineRoom = roomData as OnlineRoom;
      setRoom(onlineRoom);

      // 2. Fetch Hand
      const { data: handData, error: handError } = await supabase
        .from("room_hands")
        .select("hand")
        .eq("room_id", roomId)
        .eq("player_id", currentUser.id)
        .maybeSingle();

      if (handError) {
        // If not dealed yet, hand will be empty
        setHand([]);
      } else {
        const rawHand = handData?.hand || [];
        // Filter out corrupted 1D arrays from old bug
        const validHand = rawHand.filter((t: any) => Array.isArray(t) && t.length === 2);
        setHand(validHand);
      }
    } catch (err: any) {
      console.error("Error fetching online game details:", err);
    }
  };

  // Reconnection hook & Realtime Subscriptions
  useEffect(() => {
    fetchGameData();

    if (!supabase) return;

    // Report reconnection
    supabase.rpc("register_reconnect", { p_room_id: roomId });

    // Subscriptions
    const roomSub = supabase
      .channel(`room_game_${roomId}`)
      .on(
        "postgres_changes",
        { event: "*", schema: "public", table: "rooms", filter: `id=eq.${roomId}` },
        (payload: any) => {
          const updatedRoom = payload.new as OnlineRoom;
          // Re-fetch to get creator/opponent join profiles details
          fetchGameData();
        }
      )
      .on(
        "postgres_changes",
        { event: "*", schema: "public", table: "room_hands", filter: `room_id=eq.${roomId}` },
        () => {
          // Re-fetch hand
          fetchGameData();
        }
      )
      .subscribe();

    // Track presence for disconnect timer
    // We can monitor presence using presence channels
    const presenceChannel = supabase.channel(`presence_room_${roomId}`);

    presenceChannel
      .on("presence", { event: "sync" }, () => {
        const state = presenceChannel.presenceState();
        const connectedIds = Object.values(state)
          .flat()
          .map((p: any) => p.user_id);

        if (room) {
          const opponentId = currentUser.id === room.creator_id ? room.opponent_id : room.creator_id;
          if (opponentId) {
            const isOnline = connectedIds.includes(opponentId);
            setIsOpponentOnline(isOnline);
          }
        }
      })
      .subscribe(async (status) => {
        if (status === "SUBSCRIBED") {
          await presenceChannel.track({ user_id: currentUser.id, online_at: new Date().toISOString() });
        }
      });

    return () => {
      supabase.removeChannel(roomSub);
      supabase.removeChannel(presenceChannel);
      if (dragRafRef.current) cancelAnimationFrame(dragRafRef.current);
    };
  }, [roomId, currentUser.id]);

  // Handle disconnect timer incrementation
  useEffect(() => {
    let interval: any = null;
    
    if (room && room.status === "active") {
      const isCreator = currentUser.id === room.creator_id;
      const oppDisconnectedAtStr = isCreator ? room.opponent_disconnected_at : room.creator_disconnected_at;
      
      if (oppDisconnectedAtStr) {
        const disconnectedAt = new Date(oppDisconnectedAtStr).getTime();
        
        interval = setInterval(() => {
          const now = new Date().getTime();
          const diffSeconds = Math.floor((now - disconnectedAt) / 1000);
          setDisconnectTimer(diffSeconds);
        }, 1000);
      } else {
        setDisconnectTimer(null);
      }
    } else {
      setDisconnectTimer(null);
    }

    return () => {
      if (interval) clearInterval(interval);
    };
  }, [room, currentUser.id]);

  // Handle opponent disconnection trigger (reports to db if local client detects opponent is offline)
  useEffect(() => {
    if (!isOpponentOnline && room && room.status === "active" && supabase) {
      const oppId = currentUser.id === room.creator_id ? room.opponent_id : room.creator_id;
      if (oppId) {
        // Mark player disconnected in database
        supabase.rpc("mark_player_disconnected", { p_room_id: roomId, p_player_id: oppId });
      }
    }
  }, [isOpponentOnline, room, currentUser.id, roomId]);

  const isCreator = room ? currentUser.id === room.creator_id : false;
  const opponentId = room ? (isCreator ? room.opponent_id : room.creator_id) : undefined;
  const opponentProfile = room ? (isCreator ? room.opponent : room.creator) : undefined;
  const myProfile = room ? (isCreator ? room.creator : room.opponent) : undefined;

  const isMyTurn = room ? room.game_state.currentPlayer === currentUser.id : false;
  const placedTiles = room?.game_state?.placedTiles || [];
  const boneyardCount = room?.game_state?.boneyard_count ?? 14;

  const myScore = room ? (isCreator ? room.game_state.score_creator : room.game_state.score_opponent) : 0;
  const oppScore = room ? (isCreator ? room.game_state.score_opponent : room.game_state.score_creator) : 0;

  const myHandCount = hand.length;
  const oppHandCount = room ? (isCreator 
    ? (room.game_state as any).opponent_hand_count ?? 7
    : (room.game_state as any).creator_hand_count ?? 7) : 7;

  const openEnds2D = getOpenEnds2D(placedTiles);
  const userCanPlay = hand.some(tile => {
    const play = evaluatePlayability2D(tile, openEnds2D);
    return play.left || play.right || play.top || play.bottom || placedTiles.length === 0;
  });

  const handleStartRound = async () => {
    if (!supabase) return;
    setLoading(true);
    setErrorMsg(null);
    try {
      const { error } = await supabase.from("moves").insert([
        {
          room_id: roomId,
          player_id: currentUser.id,
          action_type: "START_ROUND",
          payload: {}
        }
      ]);
      if (error) setErrorMsg(error.message);
    } catch (err: any) {
      setErrorMsg(err.message || "Une erreur est survenue.");
    } finally {
      setLoading(false);
    }
  };

  const handleCreatorAutoRematch = async () => {
    if (!supabase || !room) return;
    try {
      const { data: newRoomId, error } = await supabase.rpc("create_room", {
        p_name: `Rematch ${room.name}`,
        p_creator_id: currentUser.id,
        p_target_score: room.target_score,
        p_visibility: room.visibility,
        p_deal_option: room.deal_option
      });
      
      if (error || !newRoomId) {
        console.error("Failed to create rematch room:", error);
        return;
      }
      
      await supabase
        .from("rooms")
        .update({
          game_state: {
            ...room.game_state,
            rematch_room_id: newRoomId
          }
        })
        .eq("id", roomId);
        
      if (onNavigateToGame) {
        onNavigateToGame(newRoomId);
      }
    } catch (err) {
      console.error("Error creating rematch:", err);
    }
  };

  const playTileOnline = async (tile: Tile, side: "left" | "right" | "top" | "bottom") => {
    if (!supabase || !isMyTurn || room?.status !== "active" || isProcessingPlayRef.current) return;
    isProcessingPlayRef.current = true;
    setErrorMsg(null);
    try {
      const { error } = await supabase.from("moves").insert([
        {
          room_id: roomId,
          player_id: currentUser.id,
          action_type: "PLAY_TILE",
          payload: { tile, side }
        }
      ]);
      if (error) {
        setErrorMsg(error.message);
      } else {
        setSelectedTile(null);
        // Animate scoring popup if Fives scored
        const nextPlaced = [...placedTiles, {
          id: "temp",
          tile,
          connectedAs: getPlayedTileRotation2D(tile, placedTiles.length === 0 ? "start" : side, openEnds2D),
          isDouble: tile[0] === tile[1],
          playedAt: placedTiles.length === 0 ? "start" : side
        } as PlacedTile];
        
        const sum = calculateBoardScore(nextPlaced);
        if (sum % 5 === 0 && sum > 0) {
          const layouts = computeTileLayouts(nextPlaced);
          const lastLayout = layouts["temp"];
          if (lastLayout) {
            setScorePopup({ points: sum, gridX: lastLayout.gridX, gridY: lastLayout.gridY });
            setTimeout(() => setScorePopup(null), 1500);
          }
        }
      }
    } catch (err: any) {
      setErrorMsg(err.message);
    } finally {
      isProcessingPlayRef.current = false;
    }
  };

  const handlePlayTile = (side: "left" | "right" | "top" | "bottom") => {
    if (!selectedTile) return;
    playTileOnline(selectedTile, side);
  };

  const handleDrawTile = async () => {
    if (!supabase || !isMyTurn || boneyardCount === 0 || userCanPlay) return;
    setErrorMsg(null);
    try {
      const { error } = await supabase.from("moves").insert([
        {
          room_id: roomId,
          player_id: currentUser.id,
          action_type: "DRAW_TILE",
          payload: {}
        }
      ]);
      if (error) setErrorMsg(error.message);
    } catch (err: any) {
      setErrorMsg(err.message);
    }
  };

  const handlePass = async () => {
    if (!supabase || !isMyTurn || userCanPlay || boneyardCount > 0) return;
    setErrorMsg(null);
    try {
      const { error } = await supabase.from("moves").insert([
        {
          room_id: roomId,
          player_id: currentUser.id,
          action_type: "PASS",
          payload: {}
        }
      ]);
      if (error) setErrorMsg(error.message);
    } catch (err: any) {
      setErrorMsg(err.message);
    }
  };

  // Turn timer effect for Online Game
  useEffect(() => {
    if (!room || room.status !== "active") return;

    setTurnTimeLeft(GAME_CONFIG.turnTimerDuration);

    const interval = setInterval(() => {
      setTurnTimeLeft((prev) => {
        if (prev <= 1) {
          return 0; // Trigger autoplay
        }
        return prev - 1;
      });
    }, 1000);

    return () => clearInterval(interval);
  }, [room?.game_state?.currentPlayer, room?.status]);

  // Autoplay trigger on timeout
  useEffect(() => {
    if (turnTimeLeft === 0 && room && room.status === "active" && room.game_state.currentPlayer === currentUser.id) {
      const placedTiles = room.game_state.placedTiles || [];
      const bestMove = getBestMoveForHand(hand, placedTiles, "all-fives", "medium");

      if (bestMove) {
        playTileOnline(bestMove.tile, bestMove.side as any);
      } else {
        const boneyardCount = room.game_state.boneyard_count ?? 14;
        const openEnds2D = getOpenEnds2D(placedTiles);
        const userCanPlay = hand.some(tile => {
          const play = evaluatePlayability2D(tile, openEnds2D);
          return play.left || play.right || play.top || play.bottom || placedTiles.length === 0;
        });

        if (boneyardCount > 0 && !userCanPlay) {
          handleDrawTile();
        } else {
          handlePass();
        }
      }
    }
  }, [turnTimeLeft, room?.game_state?.currentPlayer, room?.status, currentUser.id, hand]);

  const handleClaimForfeit = async () => {
    if (!supabase) return;
    setClaimingForfeit(true);
    setErrorMsg(null);
    try {
      const { error } = await supabase.rpc("claim_forfeit", { p_room_id: roomId });
      if (error) setErrorMsg(error.message);
    } catch (err: any) {
      setErrorMsg(err.message || "Erreur réseau.");
    } finally {
      setClaimingForfeit(false);
    }
  };

  const updateDragVisuals = () => {
    if (!dragStartPointerRef.current || !latestPointerPosRef.current) {
      dragRafRef.current = null;
      return;
    }

    const { x: startX, y: startY } = dragStartPointerRef.current;
    const { x: curX, y: curY } = latestPointerPosRef.current;

    if (!dragActiveRef.current) {
      const dx = curX - startX;
      const dy = curY - startY;
      const dist = Math.sqrt(dx * dx + dy * dy);
      if (dist >= 8) {
        dragActiveRef.current = true;
        setDraggedTile(activeDragTileRef.current);
        setSelectedTile(activeDragTileRef.current);
        // Set dragStartOffset state so floating tile becomes visible
        setDragStartOffset(dragStartOffsetRef.current);
      }
    }

    if (dragActiveRef.current && floatingTileRef.current && dragStartOffsetRef.current) {
      // Center the floating tile under the pointer (better UX, especially on mobile)
      const TILE_W = 44;
      const TILE_H = 88;
      const rawLeft = curX - TILE_W / 2;
      const rawTop  = curY - TILE_H / 2 - 10; // slightly above finger so target is visible

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
      let finalLeft = rawLeft;
      let finalTop = rawTop;
      let nextHoverSide: "left" | "right" | "top" | "bottom" | null = null;
      let nextHoverIsVertical = true;
      let nextSnappedTileValues: Tile | null = null;

      if (closestSlot && minDistance < snapThreshold && closestRect) {
        const side = closestSlot.getAttribute("data-slot-side") as "left" | "right" | "top" | "bottom";
        nextHoverSide = side;

        const isVert = closestSlot.getAttribute("data-slot-vertical") === "true";
        nextHoverIsVertical = isVert;

        const val1Str = closestSlot.getAttribute("data-slot-val1");
        const val2Str = closestSlot.getAttribute("data-slot-val2");
        if (val1Str !== null && val2Str !== null) {
          nextSnappedTileValues = [parseInt(val1Str, 10), parseInt(val2Str, 10)];
        }

        const cx = closestRect.left + closestRect.width / 2;
        const cy = closestRect.top + closestRect.height / 2;

        const currentTileW = isVert ? 44 : 88;
        const currentTileH = isVert ? 88 : 44;

        const snapLeft = cx - currentTileW / 2;
        const snapTop  = cy - currentTileH / 2;

        // 98% pull — very strong, crisp magnetic snap
        const snapStrength = 0.98;
        finalLeft = rawLeft + (snapLeft - rawLeft) * snapStrength;
        finalTop  = rawTop  + (snapTop  - rawTop)  * snapStrength;
      }

      hoveredSlotSideRef.current = nextHoverSide;
      setHoveredSlotSide(nextHoverSide);

      hoveredSlotIsVerticalRef.current = nextHoverIsVertical;
      setHoveredSlotIsVertical(nextHoverIsVertical);

      snappedTileValuesRef.current = nextSnappedTileValues;
      setSnappedTileValues(nextSnappedTileValues);

      floatingTileRef.current.style.left = `${finalLeft}px`;
      floatingTileRef.current.style.top = `${finalTop}px`;
    }

    if (dragStartPointerRef.current) {
      dragRafRef.current = requestAnimationFrame(updateDragVisuals);
    } else {
      dragRafRef.current = null;
    }
  };

  const handlePointerDown = (e: React.PointerEvent<HTMLButtonElement>, tile: Tile) => {
    if (!isMyTurn || room.status !== "active") return;

    e.preventDefault();
    e.currentTarget.setPointerCapture(e.pointerId);
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
    setDraggedTile(null);
    setDragStartOffset(null);
    setHoveredSlotSide(null);
    setHoveredSlotIsVertical(true);
    setSnappedTileValues(null);

    if (dragRafRef.current) cancelAnimationFrame(dragRafRef.current);
    dragRafRef.current = requestAnimationFrame(updateDragVisuals);
  };

  const handlePointerMove = (e: React.PointerEvent<HTMLButtonElement>, tile: Tile) => {
    if (dragStartPointerRef.current === null) return;
    latestPointerPosRef.current = { x: e.clientX, y: e.clientY };
    if (!dragRafRef.current) {
      dragRafRef.current = requestAnimationFrame(updateDragVisuals);
    }
  };

  const playTileOnlineRef = useRef(playTileOnline);
  useEffect(() => {
    playTileOnlineRef.current = playTileOnline;
  }, [playTileOnline]);

  const handlePointerUp = (e: React.PointerEvent<HTMLButtonElement>, tile: Tile) => {
    if (dragStartPointerRef.current === null) return;
    e.currentTarget.releasePointerCapture(e.pointerId);

    if (dragRafRef.current) {
      cancelAnimationFrame(dragRafRef.current);
      dragRafRef.current = null;
    }

    const finalSide = hoveredSlotSideRef.current;
    const wasActiveDrag = dragActiveRef.current;

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

    if (wasActiveDrag) {
      draggedHappenedRef.current = true;
      if (finalSide) {
        playTileOnlineRef.current(tile, finalSide);
      }
      setSelectedTile(null);
    }
  };

  const handlePointerCancel = (_e: React.PointerEvent<HTMLButtonElement>, _tile: Tile) => {
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

  const selectUserTile = (tile: Tile) => {
    if (!isMyTurn || room?.status !== "active") return;
    if (selectedTile && selectedTile[0] === tile[0] && selectedTile[1] === tile[1]) {
      setSelectedTile(null);
      return;
    }
    setSelectedTile(tile);
  };

  const revealData = room?.game_state?.revealData;
  const revealPhase = room?.game_state?.revealPhase || "none";

  // Handle round and match automatic countdowns
  useEffect(() => {
    if (revealPhase === "scoring" && room?.status === "active") {
      setRoundCountdown(10);
    } else {
      setRoundCountdown(null);
    }
  }, [revealPhase, room?.status]);

  useEffect(() => {
    if (roundCountdown === null) return;
    if (roundCountdown <= 0) {
      if (isCreator && room?.status === "active") {
        handleStartRound();
      }
      setRoundCountdown(null);
      return;
    }

    const timer = setTimeout(() => {
      setRoundCountdown(prev => (prev !== null ? prev - 1 : null));
    }, 1000);

    return () => clearTimeout(timer);
  }, [roundCountdown, isCreator, room?.status]);

  useEffect(() => {
    if (room?.status === "finished") {
      setMatchCountdown(10);
    } else {
      setMatchCountdown(null);
    }
  }, [room?.status]);

  useEffect(() => {
    if (matchCountdown === null) return;

    if (!isOpponentOnline) {
      setMatchCountdown(null);
      return;
    }

    if (matchCountdown <= 0) {
      if (isCreator) {
        handleCreatorAutoRematch();
      }
      setMatchCountdown(null);
      return;
    }

    const timer = setTimeout(() => {
      setMatchCountdown(prev => (prev !== null ? prev - 1 : null));
    }, 1000);

    return () => clearTimeout(timer);
  }, [matchCountdown, isOpponentOnline, isCreator]);

  // Opponent auto-join rematch
  useEffect(() => {
    if (!isCreator && (room?.game_state as any)?.rematch_room_id && supabase && onNavigateToGame) {
      const newRoomId = (room.game_state as any).rematch_room_id;
      
      const autoJoin = async () => {
        try {
          const { error } = await supabase.rpc("join_room", {
            p_room_id: newRoomId,
            p_player_id: currentUser.id
          });
          
          if (!error) {
            onNavigateToGame(newRoomId);
          } else {
            console.error("Failed to auto-join rematch room:", error);
          }
        } catch (err) {
          console.error("Error auto-joining rematch:", err);
        }
      };
      
      autoJoin();
    }
  }, [(room?.game_state as any)?.rematch_room_id, isCreator, currentUser.id, supabase, onNavigateToGame]);



  if (!room) {
    return (
      <div className="flex flex-col h-full bg-[#0a0a0a] items-center justify-center font-sans">
        <RefreshCw className="animate-spin text-amber-500 mb-2" size={32} />
        <span className="text-sm text-gray-500 font-mono">Chargement de la partie...</span>
      </div>
    );
  }

  return (
    <div className="flex flex-col h-full bg-[#1e0a02] overflow-hidden relative">
      {/* Top Header split 50/50 creator/opponent */}
      <header className="relative grid grid-cols-2 bg-gradient-to-b from-[#3a1506] to-[#1e0a02] border-b border-[#d4af37]/35 shadow-lg shrink-0 overflow-hidden font-sans">
        {/* User Side (Left) */}
        <div className="flex items-center gap-3 p-2.5 pl-4 relative border-r border-[#d4af37]/25">
          <div className={`w-11 h-11 rounded overflow-hidden shadow bg-[#1e0a02] flex items-center justify-center shrink-0 transition-all duration-300
            ${isMyTurn && room.status === "active" 
              ? "ring-2 ring-amber-400 shadow-[0_0_12px_rgba(212,175,55,0.85)] scale-105" 
              : "border border-[#d4af37]/30"
            }
          `}>
            <span className="text-2xl">😎</span>
          </div>
          <div className="flex flex-col min-w-0">
            <span className="text-amber-400 text-[10px] font-black tracking-wider uppercase truncate">
              {myProfile?.username || "Moi"}
            </span>
            <div className="flex items-center gap-1.5 mt-0.5 relative">
              <span className="text-amber-400 text-2xl font-black font-mono leading-none">{myScore} <span className="text-sm font-bold opacity-85">({isCreator ? roundsWonCreator : roundsWonOpponent})</span></span>
            </div>
          </div>
        </div>

        {/* Opponent Side (Right) */}
        <div className="flex items-center justify-end gap-3 p-2.5 pr-4 pl-4 relative bg-black/10">
          <div className="flex flex-col items-end min-w-0 text-right">
            <div className="flex items-center gap-1 justify-end">
              <span className={`h-1.5 w-1.5 rounded-full ${isOpponentOnline ? "bg-green-500" : "bg-red-500"}`}></span>
              <span className="text-zinc-300 text-[10px] font-black tracking-wider uppercase truncate max-w-[80px]">
                {opponentProfile?.username || "Attente..."}
              </span>
            </div>
            <div className="flex items-center gap-1.5 mt-0.5 relative justify-end">
              <span className="text-white text-2xl font-black font-mono leading-none">{oppScore} <span className="text-sm font-bold opacity-85">({isCreator ? roundsWonOpponent : roundsWonCreator})</span></span>
            </div>
          </div>
          <div className="flex items-center gap-1 shrink-0">
            <div className={`w-11 h-11 rounded overflow-hidden shadow bg-[#1e0a02] flex items-center justify-center transition-all duration-300
              ${!isMyTurn && room.status === "active" 
                ? "ring-2 ring-amber-400 shadow-[0_0_12px_rgba(212,175,55,0.85)] scale-105" 
                : "border border-zinc-700/50"
              }
            `}>
              <span className="text-2xl">👤</span>
            </div>
            <button 
              onClick={onBackToLobby}
              className="p-1 text-white hover:text-amber-400 cursor-pointer"
            >
              <MoreVertical size={18} />
            </button>
          </div>
        </div>

        {/* Room Header Info row */}
        <div className="col-span-2 text-center pb-2 pt-1 border-t border-[#d4af37]/15 flex justify-center items-center gap-4 px-3">
          <span className="text-white text-[11px] font-black tracking-[0.2em] uppercase drop-shadow-[0_1.5px_2px_rgba(0,0,0,0.85)]">
            FIVES to {room.target_score}
          </span>
          {room.room_code && (
            <span className="text-[10px] text-amber-500/80 font-mono font-bold tracking-wider uppercase">
              CODE: {room.room_code}
            </span>
          )}
        </div>

        <div className="absolute top-0 bottom-[28px] left-1/2 -translate-x-1/2 w-[1px] bg-gradient-to-b from-[#d4af37] via-[#d4af37]/45 to-transparent pointer-events-none" />

        {/* Turn timer badge */}
        {room.status === "active" && revealPhase === "none" && (
          <div className="absolute top-[18px] left-1/2 -translate-x-1/2 z-20 flex items-center justify-center pointer-events-none">
            <div className="w-8 h-8 rounded-full bg-zinc-950/95 border border-amber-400/80 flex items-center justify-center text-amber-400 font-mono font-bold text-xs shadow-lg shadow-black/85 animate-pulse">
              {turnTimeLeft}s
            </div>
          </div>
        )}
      </header>

      {/* Score Progress Bar */}
      <div className="w-full bg-zinc-950 h-1 flex border-b border-white/5 shrink-0">
        <div 
          className="bg-gradient-to-r from-red-500 to-amber-500 transition-all duration-500" 
          style={{ width: `${Math.min(100, (myScore / room.target_score) * 100)}%` }}
        />
        <div className="flex-1 bg-transparent" />
        <div 
          className="bg-gradient-to-l from-blue-500 to-amber-400 transition-all duration-500" 
          style={{ width: `${Math.min(100, (oppScore / room.target_score) * 100)}%` }}
        />
      </div>

      {/* Game Boardfelt stage area */}
      <div className="flex-1 flex flex-col min-h-0 relative overflow-hidden bg-gradient-to-b from-[#1b4d22] to-[#113516] shadow-[inset_0_0_80px_rgba(0,0,0,0.55)]">
        
        {/* Connection banner */}
        {!isOpponentOnline && (
          <div className="absolute top-4 left-1/2 -translate-x-1/2 z-35 bg-red-950/90 border border-red-500/40 px-3.5 py-1.5 rounded-full flex items-center gap-2 shadow-lg max-w-[90%] whitespace-nowrap">
            <Clock size={14} className="text-red-400 animate-pulse" />
            <span className="text-[10px] font-mono text-red-400 font-bold uppercase tracking-wider">
              {disconnectTimer !== null ? `Adversaire hors ligne (${180 - disconnectTimer}s)` : "Adversaire déconnecté"}
            </span>
            {disconnectTimer !== null && disconnectTimer >= 180 && (
              <button
                disabled={claimingForfeit}
                onClick={handleClaimForfeit}
                className="ml-2 px-2.5 py-1 bg-red-600 hover:bg-red-500 text-white rounded text-[9px] font-black uppercase tracking-wider"
              >
                {claimingForfeit ? "Validation..." : "Réclamer Forfait"}
              </button>
            )}
          </div>
        )}

        {/* Error / Alert Bar */}
        {errorMsg && (
          <div className="absolute top-12 left-1/2 -translate-x-1/2 z-35 bg-red-950/90 border border-red-500/30 px-3.5 py-2 rounded-xl flex items-center gap-2 shadow-lg max-w-[90%]">
            <AlertCircle size={14} className="text-red-400 shrink-0" />
            <span className="text-[10px] text-red-300 font-semibold">{errorMsg}</span>
          </div>
        )}

        {/* Opponent Hand (Top Center) */}
        <OpponentHand 
          count={oppHandCount} 
          revealedTiles={(room.status === "finished" || revealPhase === "revealing" || revealPhase === "scoring") && revealData ? (isCreator ? revealData.opponentHand : revealData.creatorHand) : undefined}
        />

        {/* Waiting for Opponent Lobby State overlay */}
        {room.status === "waiting" && (
          <div className="absolute inset-0 bg-black/75 z-40 flex flex-col justify-center items-center p-6 text-center space-y-6">
            <div className="p-4 rounded-full bg-amber-500/10 text-amber-500 animate-pulse border border-amber-500/20">
              <Gamepad2 size={40} />
            </div>
            {room.opponent_id ? (
              <>
                <div className="space-y-1">
                  <h3 className="text-lg font-black text-white uppercase tracking-wider">Adversaire trouvé !</h3>
                  <p className="text-sm font-bold text-amber-400">
                    {opponentProfile?.username || "Un joueur"} a rejoint le salon.
                  </p>
                </div>
                
                {isCreator ? (
                  <button
                    onClick={handleStartRound}
                    disabled={loading}
                    className="flex items-center justify-center gap-2 px-8 py-4 w-full max-w-[280px] bg-gradient-to-b from-green-500 to-green-700 text-white font-black uppercase text-base rounded-xl cursor-pointer hover:brightness-110 active:scale-95 transition-all shadow-[0_0_20px_rgba(34,197,94,0.4)]"
                  >
                    {loading ? "Chargement..." : "Démarrer la partie"}
                  </button>
                ) : (
                  <span className="text-xs font-mono text-gray-300 animate-pulse block bg-stone-900/50 px-4 py-2 rounded-lg border border-stone-800">
                    Attente du lancement par l'hôte...
                  </span>
                )}
              </>
            ) : (
              <>
                <div className="space-y-1">
                  <h3 className="text-lg font-black text-white uppercase tracking-wider">En attente d'adversaire</h3>
                  <p className="text-xs text-gray-400 max-w-[240px] leading-relaxed">
                    {room.visibility === "private" 
                      ? `Invitez un ami ou partagez le code privé.` 
                      : "Votre salon est visible publiquement dans le lobby. Attente d'un joueur..."}
                  </p>
                </div>
                
                {room.visibility === "private" && isCreator && (
                  <button
                    onClick={() => setShowInviteModal(true)}
                    className="flex items-center justify-center gap-2 px-6 py-3 w-full max-w-[240px] bg-gradient-to-b from-amber-400 to-amber-600 text-stone-950 font-black uppercase text-sm rounded-xl cursor-pointer hover:brightness-105 active:scale-95 transition-all shadow-[0_0_15px_rgba(245,158,11,0.3)]"
                  >
                    <UserPlus size={18} />
                    Inviter un ami
                  </button>
                )}

                <button
                  onClick={onBackToLobby}
                  className="px-6 py-2.5 bg-[#181818] border border-gray-800 text-gray-400 hover:text-white rounded-xl text-xs font-bold uppercase tracking-wider transition-all"
                >
                  {isCreator ? "Annuler et Fermer le salon" : "Quitter le salon"}
                </button>
              </>
            )}
            
            <AnimatePresence>
              {showInviteModal && (
                <InviteFriendModal
                  currentUserId={currentUser.id}
                  roomId={roomId}
                  roomCode={room.room_code || ""}
                  onClose={() => setShowInviteModal(false)}
                />
              )}
            </AnimatePresence>
          </div>
        )}

        {/* Removed Start Game Round Overlay */}
        
        {/* Rescue button for corrupted games */}
        {room.status === "active" && hand.length === 0 && placedTiles.length === 0 && (
          <div className="absolute inset-0 z-50 flex flex-col justify-center items-center bg-black/80 p-6">
            <h2 className="text-xl font-bold text-white mb-4 text-center">Partie corrompue détectée</h2>
            <p className="text-sm text-gray-400 mb-6 text-center">Cette partie contient d'anciennes données corrompues. Vous devez la quitter pour en relancer une nouvelle avec votre ami.</p>
            <button 
              onClick={() => {
                localStorage.removeItem("active_online_room_id");
                window.location.reload();
              }}
              className="px-6 py-3 bg-red-600 hover:bg-red-500 text-white font-bold rounded-lg shadow-lg"
            >
              Forcer le retour au menu
            </button>
          </div>
        )}

        {/* Round End Reveal Overlay */}
        {revealPhase === "revealing" && revealData && (() => {
          const isBlocked = revealData.result === "blocked";
          const roundWinnerId = revealData.roundWinner;
          const isMeWin = roundWinnerId === currentUser.id;
          
          const creatorHand = revealData.creatorHand || [];
          const opponentHand = revealData.opponentHand || [];
          
          const myRevHand = isCreator ? creatorHand : opponentHand;
          const oppRevHand = isCreator ? opponentHand : creatorHand;
          
          const myPipsSum = isCreator ? revealData.creatorPipsSum : revealData.opponentPipsSum;
          const oppPipsSum = isCreator ? revealData.opponentPipsSum : revealData.creatorPipsSum;

          return (
            <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-40 bg-zinc-950/90 border border-amber-500/30 backdrop-blur-md rounded-2xl p-6 text-center space-y-4 shadow-2xl w-[90%] max-w-[420px]">
              <div className="flex justify-center text-amber-500">
                <Gamepad2 size={36} className="animate-spin duration-[4000ms] ease-linear" />
              </div>
              
              <h4 className="font-sans font-extrabold text-base text-white uppercase tracking-wider">
                {isBlocked ? "⚠️ MANCHE BLOQUÉE !" : isMeWin ? "🎉 DOMINO ! VOUS GAGNEZ !" : "👤 L'ADVERSAIRE FAIT DOMINO !"}
              </h4>
              
              <p className="text-xs text-amber-200/80">
                {isBlocked 
                  ? "Aucun coup n'est possible. Révélation des mains..."
                  : isMeWin 
                    ? "Vous avez vidé votre main ! Révélation de la main adverse..."
                    : "L'adversaire a vidé sa main ! Révélation de votre main..."}
              </p>

              {/* Table display area for dominoes */}
              <div className="bg-emerald-950/65 border border-emerald-800/40 rounded-xl p-4 min-h-[120px] flex flex-col justify-center items-center gap-4 shadow-inner">
                <div className="w-full space-y-3">
                  <div>
                    <div className="text-[10px] uppercase text-amber-400/70 font-semibold tracking-wider mb-1.5 flex justify-between px-1">
                      <span>Main de l'adversaire</span>
                      <span>Total: {oppPipsSum} pips</span>
                    </div>
                    <div className="flex flex-wrap gap-1.5 justify-center">
                      {oppRevHand.map((tile, idx) => (
                        <motion.div
                          key={`opp-reveal-${idx}`}
                          initial={{ opacity: 0, scale: 0, y: -40, rotate: -30 }}
                          animate={{ opacity: 1, scale: 1, y: 0, rotate: 0 }}
                          transition={{ type: "spring", stiffness: 180, damping: 15, delay: idx * 0.15 }}
                          className="relative shrink-0"
                        >
                          <DominoTile tile={tile} size="sm" isVertical={true} disabled={true} />
                        </motion.div>
                      ))}
                    </div>
                  </div>
                  <div className="border-t border-emerald-800/25 my-1.5"></div>
                  <div>
                    <div className="text-[10px] uppercase text-amber-400/70 font-semibold tracking-wider mb-1.5 flex justify-between px-1">
                      <span>Votre main</span>
                      <span>Total: {myPipsSum} pips</span>
                    </div>
                    <div className="flex flex-wrap gap-1.5 justify-center">
                      {myRevHand.map((tile, idx) => (
                        <motion.div
                          key={`my-reveal-${idx}`}
                          initial={{ opacity: 0, scale: 0, y: 40, rotate: 30 }}
                          animate={{ opacity: 1, scale: 1, y: 0, rotate: 0 }}
                          transition={{ type: "spring", stiffness: 180, damping: 15, delay: idx * 0.15 }}
                          className="relative shrink-0"
                        >
                          <DominoTile tile={tile} size="sm" isVertical={true} disabled={true} />
                        </motion.div>
                      ))}
                    </div>
                  </div>
                  {revealData.tieBreakExplained && (
                    <div className="text-[10px] bg-black/40 border border-emerald-800/30 rounded-lg p-2 font-mono text-amber-300 leading-relaxed text-center mt-2">
                      {revealData.tieBreakExplained}
                    </div>
                  )}
                </div>
              </div>

              {/* Progress Countdown Bar */}
              <div className="w-full pt-1">
                <div className="flex justify-between text-[9px] uppercase tracking-widest text-zinc-500 font-mono">
                  <span>Inspection des mains restantes</span>
                  <span>Transition...</span>
                </div>
                <div className="w-full bg-zinc-800 h-1.5 rounded-full overflow-hidden mt-1.5">
                  <motion.div 
                    initial={{ width: "100%" }} 
                    animate={{ width: "0%" }} 
                    transition={{ duration: 3, ease: "linear" }} 
                    className="h-full bg-amber-500 rounded-full" 
                  />
                </div>
              </div>
            </div>
          );
        })()}

        {/* Round Score display overlay (Scoring Phase) */}
        {revealPhase === "scoring" && revealData && (() => {
          const isBlocked = revealData.result === "blocked";
          const roundWinnerId = revealData.roundWinner;
          const isMeWin = roundWinnerId === currentUser.id;
          const gained = revealData.scoreGained;

          return (
            <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-50 bg-[#151515] border border-amber-900/40 rounded-xl p-4 text-center space-y-3 shadow-2xl w-[90%] max-w-[340px]">
              <div className="flex justify-center text-amber-500">
                <Crown size={28} className="animate-bounce" />
              </div>
              <h4 className="font-sans font-bold text-sm text-white uppercase tracking-wider">
                {isMeWin ? "Manche remportée ! 🏆" : "Manche perdue 👤"}
              </h4>
              
              <div className="text-[11px] bg-black/60 border border-amber-900/35 rounded-lg p-3.5 font-mono text-center text-amber-300 space-y-1">
                <div className="text-gray-400 text-[10px]">
                  {isBlocked ? "Calcul sur jeu bloqué" : "Points de la main adverse"}
                </div>
                {revealData.tieBreakExplained && (
                  <div className="text-[9px] text-amber-400/90 py-1 leading-normal border-b border-amber-900/20">
                    {revealData.tieBreakExplained}
                  </div>
                )}
                <div className="text-xs font-bold text-white pt-1">
                  Points marqués : +{gained} Fives
                </div>
              </div>

              {room.status === "active" && (
                <div className="text-center py-1.5 font-bold text-xs text-amber-500 uppercase tracking-widest animate-pulse font-sans">
                  Manche suivante dans
                  <div className="text-2xl font-black font-mono mt-1 text-white">{roundCountdown ?? 0}</div>
                </div>
              )}
            </div>
          );
        })()}

        {/* Match Winner Popup Overlay */}
        {room.status === "finished" && (() => {
          const isUserWinner = room.winner_id === currentUser.id;
          const scoreDiff = Math.abs(myScore - oppScore);
          const username = myProfile?.username || "maestro10";
          const opponentName = opponentProfile?.username || "bot_op";

          // Share message
          const shareMessage = `🏆 Maestro Domino En Ligne : ${isUserWinner ? "Victoire !" : "Défaite"} 🀰\n🎯 Score : ${myScore} - ${oppScore}\nDifférence : ${scoreDiff} pts ! Rejoignez-moi sur maestro-sooty.vercel.app`;

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
              // Fallback: Copy to clipboard
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
                        {isUserWinner ? `Vous avez gagné de ${scoreDiff}` : `Vous avez perdu de ${scoreDiff}`}
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
                            {myScore}
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
                            {oppScore}
                          </span>
                        </div>
                      </div>

                      {/* Share button nested inside the V shape of the shield */}
                      <button 
                        onClick={handleShareClick}
                        className="w-9 h-9 rounded-full bg-stone-700 hover:bg-stone-600 flex items-center justify-center text-white cursor-pointer active:scale-95 transition-all shadow-md mt-4 relative z-20"
                      >
                        <Share2 size={14} />
                      </button>
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
                    {isUserWinner ? "VICTORY!" : "DEFEAT"}
                  </span>
                </div>

                {/* Action Buttons Section */}
                <div className="flex flex-col items-center mt-5 w-full space-y-3.5 font-sans">
                  {matchCountdown !== null ? (
                    <div className="flex flex-col items-center gap-2">
                      <div className="text-center font-bold text-[10px] text-amber-400 uppercase tracking-[0.25em] animate-pulse">
                        Revanche dans
                        <div className="text-3xl font-black font-mono mt-1 text-white">{matchCountdown}</div>
                      </div>
                      <button
                        onClick={onBackToLobby}
                        className="mt-2.5 flex items-center justify-center gap-1.5 py-2.5 px-6 bg-stone-600 hover:bg-stone-500 text-white font-bold tracking-widest uppercase rounded-xl border-b-4 border-stone-850 active:scale-95 active:border-b-0 transition-all cursor-pointer shadow-md text-[9px]"
                      >
                        <ChevronLeft size={12} /> Quitter
                      </button>
                    </div>
                  ) : (
                    <div className="flex flex-col items-center gap-2">
                      {!isOpponentOnline && (
                        <div className="text-center text-xs text-red-400 font-bold px-4 py-1.5 bg-red-950/45 border border-red-500/20 rounded-lg">
                          Adversaire déconnecté.
                        </div>
                      )}
                      <button
                        onClick={onBackToLobby}
                        className="flex items-center justify-center gap-1.5 py-3.5 px-8 bg-[#3b5998] text-white font-bold tracking-widest uppercase rounded-xl border-b-4 border-[#2d4373] hover:bg-[#4c70ba] active:scale-95 active:border-b-0 transition-all cursor-pointer shadow-md text-[10px] w-[280px]"
                      >
                        <ChevronLeft size={14} /> Retour au Lobby
                      </button>
                    </div>
                  )}
                </div>
              </div>
            </div>
          );
        })()}

        {/* Scaled Game Board */}
        <div className="flex-1 relative w-full pb-8 min-h-0">
          <GameBoard 
            placedTiles={placedTiles}
            selectedTile={selectedTile}
            onPlayTile={handlePlayTile}
            currentPlayer={isMyTurn ? "user" : "ai"}
            onDropTile={playTileOnline}
            scorePopup={scorePopup}
            hoveredSlotSide={hoveredSlotSide}
          />
        </div>

        {/* Floating Pass Button (Overlay near bottom of game board) */}
        {isMyTurn && !userCanPlay && boneyardCount === 0 && room.status === "active" && (
          <div className="absolute bottom-14 right-4 z-30">
            <button
              onClick={handlePass}
              className="px-4 py-2.5 bg-red-600 hover:bg-red-700 text-white font-bold text-xs uppercase tracking-widest rounded-xl shadow-lg border border-red-500 animate-pulse cursor-pointer transition-all active:scale-95"
            >
              Passer mon tour
            </button>
          </div>
        )}

        {/* Thin Info Bar */}
        <div className="absolute bottom-0 w-full bg-zinc-950 border-t border-white/5 text-center py-2.5 z-20 flex justify-center items-center">
          <span className="text-white text-[11px] font-black uppercase tracking-[0.15em] flex gap-4">
            <span>Extrémités {placedTiles.length > 0 ? calculateBoardScore(placedTiles) : 0}</span>
            <span className="text-white/20">|</span>
            <span>Pioche {boneyardCount}</span>
          </span>
        </div>
      </div>

      {/* Bottom Player Hand Area */}
      <div 
        className={`relative bg-gradient-to-b from-[#2e1308] to-[#170803] border-t border-[#d4af37]/25 py-2.5 px-4 h-[130px] flex items-center overflow-x-auto no-scrollbar shadow-[inset_0_4px_15px_rgba(0,0,0,0.6)] shrink-0 ${hand.length > 5 ? "justify-start" : "justify-center"}`}
        style={{ justifyContent: "safe center" }}
      >
        <div className="flex gap-1.5 sm:gap-2">
          <AnimatePresence mode="popLayout">
            {hand.map((tile) => {
              const playability = evaluatePlayability2D(tile, openEnds2D);
              const isPlayable = playability.left || playability.right || playability.top || playability.bottom || placedTiles.length === 0;
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
                    draggable={isMyTurn && room.status === "active" && isPlayable}
                    highlighted={selectedTile !== null && selectedTile[0] === tile[0] && selectedTile[1] === tile[1]}
                    disabled={!isMyTurn || room.status !== "active" || !isPlayable}
                  />
                </motion.div>
              );
            })}
          </AnimatePresence>
        </div>
      </div>

      {/* Draw from Boneyard Overlay */}
      {isMyTurn && !userCanPlay && boneyardCount > 0 && room.status === "active" && (
        <BoneyardView 
          boneyard={Array(boneyardCount).fill([0,0])} 
          onDrawTile={handleDrawTile} 
        />
      )}

      {/* Dragged tile floating visual preview */}
      {draggedTile && dragStartOffset && (
        <div
          ref={floatingTileRef}
          className="fixed pointer-events-none z-[9999]"
          style={{
            left: `-9999px`,
            top: `-9999px`,
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
          <DominoTile
            tile={snappedTileValues || draggedTile}
            isVertical={hoveredSlotSide ? hoveredSlotIsVertical : true}
            size="md"
          />
        </div>
      )}

      {/* Real-time In-game Chat */}
      {room.status !== "waiting" && (
        <GameChat roomId={roomId} currentUserId={currentUser.id} />
      )}
    </div>
  );
}
