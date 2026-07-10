/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React from "react";
import { GameMode, Difficulty, MatchStatus } from "../types";
import { Play, RotateCcw, HelpCircle, LayoutDashboard, BrainCircuit } from "lucide-react";

interface ControlPanelProps {
  scoreUser: number;
  scoreAi: number;
  round: number;
  boneyardCount: number;
  currentTurn: "user" | "ai";
  gameMode: GameMode;
  difficulty: Difficulty;
  matchStatus: MatchStatus;
  showAnalysis: boolean;
  onSetGameMode: (mode: GameMode) => void;
  onSetDifficulty: (diff: Difficulty) => void;
  onStartGame: () => void;
  onChangeAnalysis: (show: boolean) => void;
  onDraw: () => void;
  onPass: () => void;
  userCanPlay: boolean;
}

/**
 * Game dashboard and scoring panel. Lays out rule configurations, deals, 
 * draws, passes, and triggers for tactical AI settings.
 */
export const ControlPanel: React.FC<ControlPanelProps> = ({
  scoreUser,
  scoreAi,
  round,
  boneyardCount,
  currentTurn,
  gameMode,
  difficulty,
  matchStatus,
  showAnalysis,
  onSetGameMode,
  onSetDifficulty,
  onStartGame,
  onChangeAnalysis,
  onDraw,
  onPass,
  userCanPlay,
}) => {
  return (
    <div className="w-full bg-[#181a1e] border border-gray-800/80 rounded-2xl p-5 shadow-lg space-y-5">
      
      {/* 1. SCOREBOARD ROW */}
      <div className="flex flex-col sm:flex-row justify-between items-stretch gap-4 border-b border-gray-800/40 pb-4">
        {/* User Score Card */}
        <div className="flex-1 bg-gradient-to-br from-amber-950/20 to-amber-900/10 border border-amber-950/40 rounded-xl p-3 flex justify-between items-center">
          <div className="space-y-0.5">
            <span className="text-[10px] uppercase font-mono tracking-wider text-amber-500 font-bold">You (Player)</span>
            <span className="text-[11px] text-gray-400 block font-sans">
              {currentTurn === "user" && matchStatus === "ongoing" ? "● Your Turn" : "IDLE"}
            </span>
          </div>
          <span className="text-3xl font-black font-mono tracking-tight text-white pr-2">{scoreUser}</span>
        </div>

        {/* Round Counter Card */}
        <div className="shrink-0 flex flex-col justify-center items-center px-4 py-2 border border-gray-800 rounded-xl font-mono text-[11px]">
          <span className="text-gray-500 uppercase font-bold tracking-wider text-[9px] mb-0.5">Round</span>
          <span className="text-sm font-bold text-gray-200">{round}</span>
          <span className="text-[9px] text-gray-500 mt-1 uppercase font-semibold">
            {gameMode === "all-fives" ? "Fives (To 150)" : "Block / Draw"}
          </span>
        </div>

        {/* AI Score Card */}
        <div className="flex-1 bg-gradient-to-br from-[#151515] to-[#101010] border border-gray-800 rounded-xl p-3 flex justify-between items-center">
          <div className="space-y-0.5">
            <span className="text-[10px] uppercase font-mono tracking-wider text-gray-400 font-bold">Tactical AI</span>
            <span className="text-[11px] text-gray-500 block font-sans">
              {currentTurn === "ai" && matchStatus === "ongoing" ? "● Thinking..." : "IDLE"}
            </span>
          </div>
          <span className="text-3xl font-black font-mono tracking-tight text-white pr-2">{scoreAi}</span>
        </div>
      </div>

      {/* 2. GAME ACTION STATS AND TRIGGERS */}
      <div className="flex flex-wrap items-center justify-between gap-4">
        {/* Hand Action Statuses */}
        <div className="flex items-center gap-4 text-xs font-mono">
          <div className="bg-[#101114] border border-gray-800/40 px-3 py-1.5 rounded-lg">
            <span className="text-gray-500 mr-2">Boneyard:</span>
            <span className="font-bold text-amber-500">{boneyardCount} tiles</span>
          </div>
        </div>

        {/* Primary Draw / Pass / Deal buttons */}
        <div className="flex items-center gap-3">
          {matchStatus === "not-started" ? (
            <button
              onClick={onStartGame}
              className="px-5 py-2 w-full sm:w-auto bg-gradient-to-r from-amber-400 to-amber-600 hover:from-amber-300 hover:to-amber-500 active:scale-95 text-black font-bold text-xs rounded-xl shadow-lg flex items-center justify-center gap-2 cursor-pointer transition-all uppercase tracking-wider"
            >
              <Play size={14} fill="currentColor" /> Deal Dominoes
            </button>
          ) : (
            <>
              {/* Draw Pile Button */}
              {gameMode === "draw" && (
                <button
                  disabled={boneyardCount === 0 || currentTurn !== "user" || userCanPlay}
                  onClick={onDraw}
                  className={`px-4 py-2 text-xs font-medium rounded-xl border flex items-center gap-1.5 transition-all outline-none ${
                    currentTurn === "user" && !userCanPlay && boneyardCount > 0
                      ? "bg-amber-600 hover:bg-amber-500 text-white border-amber-500 cursor-pointer shadow-[0_4px_10px_rgba(217,119,6,0.3)] animate-pulse"
                      : "text-gray-500 border-gray-850 bg-gray-900 cursor-not-allowed"
                  }`}
                  title="Draw from boneyard if you have no playable tiles"
                >
                  Draw Tile ({boneyardCount})
                </button>
              )}

              {/* Pass Turn Button */}
              <button
                disabled={currentTurn !== "user" || userCanPlay || (gameMode === "draw" && boneyardCount > 0)}
                onClick={onPass}
                className={`px-4 py-2 text-xs font-medium rounded-xl border flex items-center gap-1.5 transition-all outline-none ${
                  currentTurn === "user" && !userCanPlay && (gameMode !== "draw" || boneyardCount === 0)
                    ? "bg-red-600 hover:bg-red-500 text-white border-red-500 cursor-pointer shadow-[0_4px_10px_rgba(220,38,38,0.3)] animate-bounce"
                    : "text-gray-500 border-gray-850 bg-gray-900 cursor-not-allowed"
                }`}
                title="Pass your turn if blank of legal moves and no boneyard matches remain"
              >
                Pass Turn
              </button>

              {/* Start New Round Retry button */}
              <button
                onClick={onStartGame}
                className="px-3.5 py-2 border border-gray-800 bg-gray-850 hover:bg-gray-800 hover:text-white text-gray-300 font-medium text-xs rounded-xl transition-all cursor-pointer flex items-center gap-1.5"
                title="Reshuffle & start a new game round"
              >
                <RotateCcw size={13} />
                <span>Re-Deal</span>
              </button>
            </>
          )}
        </div>
      </div>

      {/* 3. SETTINGS: MODE / SKILLS / ANALYSIS ENGINE TOGGLES */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4 pt-3 border-t border-gray-800/40">
        
        {/* Game Mode Picker */}
        <div className="space-y-1.5 p-1">
          <label className="text-[10px] uppercase font-mono font-bold tracking-wider text-gray-500 block">Rules Mode</label>
          <div className="grid grid-cols-3 gap-1 bg-[#101114] p-1 border border-gray-800/60 rounded-xl">
            {(["draw", "block", "all-fives"] as GameMode[]).map(mode => (
              <button
                key={mode}
                disabled={matchStatus === "ongoing"}
                onClick={() => onSetGameMode(mode)}
                className={`py-1.5 text-[10px] font-medium tracking-wide uppercase rounded-lg transition-all ${
                  matchStatus === "ongoing" ? "opacity-50 cursor-not-allowed" : "cursor-pointer"
                } ${
                  gameMode === mode
                    ? "bg-gray-800 text-amber-400 font-bold"
                    : "text-gray-400 hover:text-gray-200"
                }`}
              >
                {mode === "all-fives" ? "Fives" : mode}
              </button>
            ))}
          </div>
        </div>

        {/* AI IQ / Skillpicker */}
        <div className="space-y-1.5 p-1">
          <label className="text-[10px] uppercase font-mono font-bold tracking-wider text-gray-500 block">AI Tactical IQ</label>
          <div className="grid grid-cols-3 gap-1 bg-[#101114] p-1 border border-gray-800/60 rounded-xl">
            {(["easy", "medium", "hard"] as Difficulty[]).map(diff => (
              <button
                key={diff}
                onClick={() => onSetDifficulty(diff)}
                className={`py-1.5 text-[10px] font-medium tracking-wide uppercase rounded-lg transition-all cursor-pointer ${
                  difficulty === diff
                    ? "bg-gray-800 text-indigo-400 font-bold"
                    : "text-gray-400 hover:text-gray-200"
                }`}
              >
                {diff}
              </button>
            ))}
          </div>
        </div>

        {/* Analysis HUD Trigger */}
        <div className="space-y-1.5 p-1 flex flex-col justify-end">
          <button
            onClick={() => onChangeAnalysis(!showAnalysis)}
            className={`w-full py-2 px-3 text-xs font-semibold rounded-xl border flex items-center justify-center gap-1.5 transition-all cursor-pointer shadow-md ${
              showAnalysis
                ? "bg-gradient-to-r from-amber-500/10 to-amber-600/10 border-amber-500/50 text-amber-400 hover:brightness-110"
                : "bg-gray-850 hover:bg-gray-800 border-gray-800 text-gray-400 hover:text-gray-200"
            }`}
          >
            <BrainCircuit size={14} />
            <span>Tactical Analysis HUD</span>
            <span className={`h-1.5 w-1.5 rounded-full ${showAnalysis ? "bg-amber-400 animate-ping" : "bg-gray-600"}`} />
          </button>
        </div>

      </div>

    </div>
  );
};
