import React, { useState } from 'react';
import { Play, RotateCcw, Info, Gamepad2, Trophy, Settings, Users, Crown, LogOut } from "lucide-react";
import { AppScreen } from "../types";
import { motion, AnimatePresence } from 'framer-motion';
import { FriendsList } from './FriendsList';
import { NotificationCenter } from './NotificationCenter';

interface HomeMenuProps {
  onStartNewGame: () => void;
  onNavigate: (screen: AppScreen) => void;
  canContinue: boolean;
  onContinueGame: () => void;
  onPlayOnline: () => void;
  onPlayTournaments: () => void;
  isAdmin?: boolean;
  onNavigateToAdmin?: () => void;
  onSignOut?: () => void;
  currentUser?: any;
  onNavigateToGame?: (roomId: string) => void;
}

export function HomeMenu({ 
  onStartNewGame, 
  onNavigate, 
  canContinue, 
  onContinueGame, 
  onPlayOnline,
  onPlayTournaments,
  isAdmin = false,
  onNavigateToAdmin,
  onSignOut,
  currentUser,
  onNavigateToGame
}: HomeMenuProps) {
  const [showFriends, setShowFriends] = useState(false);
  return (
    <div className="flex flex-col h-full bg-[#0a0a0a] text-amber-500 overflow-hidden relative font-sans">
      
      {/* Background faint glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full h-1/2 bg-amber-500/5 blur-[120px] rounded-full pointer-events-none"></div>

      {/* Top Bar Actions */}
      <div className="absolute top-4 right-4 z-30 flex items-center gap-2">
        {currentUser && (
          <NotificationCenter 
            currentUser={currentUser} 
            onNavigateToRoom={onNavigateToGame}
          />
        )}
        {onSignOut && (
          <button 
            onClick={onSignOut}
            className="p-2 rounded-full bg-red-500/10 text-red-500 hover:bg-red-500/20 active:scale-95 transition-all border border-red-500/20 shadow-sm"
            title="Déconnexion"
          >
            <LogOut size={20} />
          </button>
        )}
      </div>

      {currentUser && (
        <div className="absolute top-4 left-4 z-30">
          <button 
            onClick={() => setShowFriends(!showFriends)}
            className="p-2 rounded-full bg-amber-500/10 text-amber-500 hover:bg-amber-500/20 transition-all border border-amber-500/20"
          >
            <Users size={20} />
          </button>
          
          <AnimatePresence>
            {showFriends && (
              <>
                <div 
                  className="fixed inset-0 z-35 cursor-default" 
                  onClick={() => setShowFriends(false)}
                />
                <motion.div
                  initial={{ opacity: 0, x: -20 }}
                  animate={{ opacity: 1, x: 0 }}
                  exit={{ opacity: 0, x: -20 }}
                  className="absolute top-12 left-0 w-80 z-40"
                >
                  <FriendsList currentUser={currentUser} onNavigateToGame={onNavigateToGame} />
                </motion.div>
              </>
            )}
          </AnimatePresence>
        </div>
      )}

      {/* Main Content */}
      <div className="flex-1 flex flex-col justify-center items-center px-6 -mt-12 z-10 py-6 overflow-y-auto no-scrollbar">
        
        {/* Title & Logo Section */}
        <div className="text-center mb-10 flex flex-col items-center justify-center">
          <img 
            src="/Maesto.png" 
            alt="Maestro Domino Logo" 
            className="h-28 w-auto object-contain drop-shadow-[0_8px_32px_rgba(245,158,11,0.12)]" 
          />
        </div>

        {/* Action Buttons */}
        <div className="w-full space-y-4 max-w-xs mx-auto pb-4">
          <button
            onClick={onStartNewGame}
            disabled={canContinue}
            className={`w-full flex items-center justify-center gap-3 py-4 rounded-xl font-bold text-lg shadow-lg transition-all ${
              canContinue 
                ? "bg-gray-800 text-gray-500 cursor-not-allowed opacity-70" 
                : "bg-gradient-to-b from-amber-400 to-amber-600 text-black shadow-amber-900/30 hover:brightness-110 active:scale-95 cursor-pointer"
            }`}
          >
            <Play fill="currentColor" size={20} />
            <span>Nouvelle Partie</span>
          </button>

          <button
            onClick={onPlayOnline}
            className="w-full flex items-center justify-center gap-3 py-4 rounded-xl font-bold text-sm bg-gradient-to-b from-[#d4af37]/20 to-[#d4af37]/10 border border-[#d4af37]/45 text-[#d4af37] shadow-lg hover:brightness-115 active:scale-95 transition-all cursor-pointer"
          >
            <Users size={18} />
            <span>Multijoueur en ligne</span>
          </button>

          <button
            onClick={onPlayTournaments}
            className="w-full flex items-center justify-center gap-3 py-4 rounded-xl font-bold text-sm bg-gradient-to-b from-[#b38600]/20 to-[#b38600]/10 border border-[#b38600]/45 text-[#ffd700] shadow-lg hover:brightness-115 active:scale-95 transition-all cursor-pointer"
          >
            <Trophy size={18} />
            <span>Tournois & Championnats</span>
          </button>

          {isAdmin && onNavigateToAdmin && (
            <button
              onClick={onNavigateToAdmin}
              className="w-full flex items-center justify-center gap-3 py-4 rounded-xl font-bold text-sm bg-gradient-to-b from-red-950/40 to-red-950/20 border border-red-500/40 text-red-400 shadow-lg hover:brightness-115 active:scale-95 transition-all cursor-pointer font-mono"
            >
              <Crown size={18} />
              <span>Panel Administrateur</span>
            </button>
          )}

          {canContinue && (
            <button
              onClick={onContinueGame}
              className="w-full flex items-center justify-center gap-3 py-4 rounded-xl font-bold text-lg bg-gradient-to-b from-blue-500 to-blue-700 text-white shadow-lg shadow-blue-900/30 hover:brightness-110 active:scale-95 transition-all cursor-pointer border border-blue-400/50 mt-4"
            >
              <RotateCcw size={20} />
              <span>Reprendre la partie</span>
            </button>
          )}


          <button
            onClick={() => { /* Open How to Play Modal or navigate */ }}
            className="w-full flex items-center justify-center gap-3 py-4 rounded-xl font-semibold text-sm bg-[#151515] border border-gray-800 text-gray-300 hover:bg-[#1a1a1a] hover:text-amber-400 hover:border-amber-900/40 active:scale-95 transition-all shadow-md"
          >
            <Info size={18} />
            <span>How to Play</span>
          </button>
        </div>
      </div>

      {/* Bottom Navigation */}
      <div className="absolute bottom-0 w-full border-t border-gray-800/80 bg-[#0c0c0c] pb-safe z-20">
        <div className="flex justify-around items-center h-16">
          <button 
            onClick={() => onNavigate("home")}
            className="flex flex-col items-center justify-center w-1/3 text-amber-500 gap-1 active:scale-90 transition-transform"
          >
            <Gamepad2 size={22} />
            <span className="text-[10px] font-bold tracking-wider">Play</span>
          </button>
          
          <button 
            onClick={() => onNavigate("scores")}
            className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-400 gap-1 active:scale-90 transition-colors"
          >
            <Trophy size={20} />
            <span className="text-[10px] font-medium tracking-wider">Scores</span>
          </button>

          <button 
            onClick={() => onNavigate("settings")}
            className="flex flex-col items-center justify-center w-1/3 text-gray-500 hover:text-amber-400 gap-1 active:scale-90 transition-colors"
          >
            <Settings size={20} />
            <span className="text-[10px] font-medium tracking-wider">Settings</span>
          </button>
        </div>
      </div>
    </div>
  );
}
