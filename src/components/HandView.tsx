/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React, { useState } from "react";
import { Tile, TileAnalysis } from "../types";
import { DominoTile } from "./DominoTile";
import { ArrowUpDown, HelpCircle, AlertCircle, Play } from "lucide-react";

interface HandViewProps {
  hand: Tile[];
  playableEnds: [number | null, number | null];
  selectedTile: Tile | null;
  onSelectTile: (tile: Tile) => void;
  analysisRecommendations?: TileAnalysis[];
  showAnalysis: boolean;
  disabled: boolean;
}

type SortOption = "none" | "pips-desc" | "pips-asc" | "doubles-first";

/**
 * Hand panel displaying user's current domino hand.
 * Integrates handy sorting modes and live strategy insights (e.g., best/safe/risky badges) when Analysis is active.
 */
export const HandView: React.FC<HandViewProps> = ({
  hand,
  playableEnds,
  selectedTile,
  onSelectTile,
  analysisRecommendations = [],
  showAnalysis,
  disabled,
}) => {
  const [sortBy, setSortBy] = useState<SortOption>("none");

  // Helper to check if a tile is selected
  const isSelected = (tile: Tile) => {
    return selectedTile !== null && selectedTile[0] === tile[0] && selectedTile[1] === tile[1];
  };

  // Sort logic
  const getSortedHand = () => {
    const list = [...hand];
    if (sortBy === "pips-desc") {
      return list.sort((a, b) => (b[0] + b[1]) - (a[0] + a[1]));
    }
    if (sortBy === "pips-asc") {
      return list.sort((a, b) => (a[0] + a[1]) - (b[0] + b[1]));
    }
    if (sortBy === "doubles-first") {
      return list.sort((a, b) => {
        const aIsDouble = a[0] === a[1] ? 1 : 0;
        const bIsDouble = b[0] === b[1] ? 1 : 0;
        if (aIsDouble !== bIsDouble) {
          return bIsDouble - aIsDouble; // Doubles first
        }
        return (b[0] + b[1]) - (a[0] + a[1]); // Then by pip size descending
      });
    }
    return list; // None
  };

  const sortedHand = getSortedHand();

  // Find recommendation info for a tile
  const getTileAnalysis = (tile: Tile): TileAnalysis | undefined => {
    return analysisRecommendations.find(
      r => (r.tile[0] === tile[0] && r.tile[1] === tile[1]) || (r.tile[1] === tile[0] && r.tile[0] === tile[1])
    );
  };

  return (
    <div className="w-full bg-[#101010] border border-gray-800 rounded-2xl p-5 shadow-lg space-y-4">
      {/* Title & Sorting Toolbar */}
      <div className="flex flex-col sm:flex-row justify-between items-start sm:items-center gap-3">
        <div>
          <h2 className="font-sans font-semibold text-gray-100 text-base flex items-center gap-2">
            <span>Your Domino Hand</span>
            <span className="bg-amber-500/10 text-amber-400 border border-amber-500/20 text-xs px-2 py-0.5 rounded-full font-mono">
              {hand.length} {hand.length <= 1 ? "tile" : "tiles"}
            </span>
          </h2>
          <p className="text-xs text-gray-400">
            {disabled 
              ? "It's the opponent's turn. Study the board values." 
              : "Select a tile to see valid placement zones on the board."}
          </p>
        </div>

        {/* Sort triggers */}
        <div className="flex items-center gap-1.5 shrink-0 self-end">
          <span className="text-[10px] font-mono uppercase text-gray-500 mr-1 flex items-center gap-1">
            <ArrowUpDown size={10} /> Sort Hand:
          </span>
          <button
            onClick={() => setSortBy("none")}
            className={`px-2 py-1 text-xs rounded border transition-all cursor-pointer ${
              sortBy === "none"
                ? "bg-gray-800/80 text-white border-gray-700 font-medium"
                : "text-gray-400 border-transparent hover:text-gray-200"
            }`}
          >
            Deal Order
          </button>
          <button
            onClick={() => setSortBy("pips-desc")}
            className={`px-2 py-1 text-xs rounded border transition-all cursor-pointer ${
              sortBy === "pips-desc"
                ? "bg-gray-800/80 text-white border-gray-700 font-medium"
                : "text-gray-400 border-transparent hover:text-gray-200"
            }`}
          >
            Pips (High)
          </button>
          <button
            onClick={() => setSortBy("doubles-first")}
            className={`px-2 py-1 text-xs rounded border transition-all cursor-pointer ${
              sortBy === "doubles-first"
                ? "bg-gray-800/80 text-white border-gray-700 font-medium"
                : "text-gray-400 border-transparent hover:text-gray-200"
            }`}
          >
            Doubles
          </button>
        </div>
      </div>

      {hand.length === 0 ? (
        // Out of tiles state
        <div className="py-10 border border-dashed border-gray-800 rounded-xl flex flex-col items-center justify-center text-gray-500">
          <span className="text-3xl">🎉</span>
          <p className="text-sm font-medium mt-2">Domino! Your hand is clear.</p>
          <p className="text-xs text-gray-600">Waiting for round score tallies...</p>
        </div>
      ) : (
        // Hand Grid
        <div className="flex flex-wrap items-center justify-center gap-4 py-3 min-h-[120px]">
          {sortedHand.map((tile, idx) => {
            const tileAnalysis = getTileAnalysis(tile);
            const isPlayable = tileAnalysis ? tileAnalysis.isPlayable : true;
            const chosen = isSelected(tile);

            // Determine if the tile's recommended status should display a badge
            let recommendationBadge: React.ReactNode = null;
            if (showAnalysis && tileAnalysis && isPlayable) {
              const rec = tileAnalysis.playRecommendation;
              if (rec === "best") {
                recommendationBadge = (
                  <span className="absolute -bottom-2 inset-x-0 mx-auto w-max bg-yellow-600 text-yellow-50 text-[9px] font-bold uppercase tracking-wider px-1.5 py-0.5 rounded shadow-md z-1">
                    ★ Best Play
                  </span>
                );
              } else if (rec === "good") {
                recommendationBadge = (
                  <span className="absolute -bottom-2 inset-x-0 mx-auto w-max bg-amber-600 text-amber-50 text-[9px] font-bold uppercase tracking-wider px-1.5 py-0.5 rounded shadow-md z-1">
                    ✓ Recommended
                  </span>
                );
              } else if (rec === "risky") {
                recommendationBadge = (
                  <span className="absolute -bottom-2 inset-x-0 mx-auto w-max bg-red-600 text-red-50 text-[9px] font-bold uppercase tracking-wider px-1.5 py-0.5 rounded shadow-md z-1">
                    ⚠ Risky
                  </span>
                );
              }
            }

            return (
              <div key={`${tile[0]}-${tile[1]}`} className="relative p-1">
                <DominoTile
                  tile={tile}
                  isVertical={true}
                  highlighted={chosen}
                  disabled={disabled || (!isPlayable && !showAnalysis)} // In analysis mode, let them select unplayable just to inspect why
                  onClick={() => onSelectTile(tile)}
                  showRecommendation={showAnalysis && isPlayable && tileAnalysis?.playRecommendation !== "unplayable" ? (tileAnalysis?.playRecommendation as "best" | "good" | "neutral" | "risky") : null}
                />
                
                {/* Custom badges */}
                {recommendationBadge}

                {/* Overlays for Playable vs Unplayable */}
                {!isPlayable && !disabled && (
                  <div className="absolute inset-0 bg-[#0c0d0e]/65 rounded-lg flex items-center justify-center pointer-events-none border border-[#0d0e10]/30">
                    <span className="text-[10px] uppercase font-mono font-bold tracking-widest text-red-400">Locked</span>
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}

      {/* Selected Tile Mini Strategy Detail Overlay (In analysis mode or not) */}
      {selectedTile && (
        <div className="p-3.5 rounded-xl bg-[#111] border border-gray-800 flex items-start gap-3">
          <div className="h-6 w-6 mt-0.5 rounded-full bg-amber-950 text-amber-400 flex items-center justify-center shrink-0">
            <HelpCircle size={14} />
          </div>
          <div className="flex-1 space-y-1">
            <div className="flex items-center gap-1.5 text-xs text-gray-200">
              <span className="font-semibold text-gray-100 font-mono">Selected Tile: [{selectedTile[0]}|{selectedTile[1]}]</span>
              <span className="text-gray-400">({selectedTile[0] + selectedTile[1]} pips)</span>
            </div>
            <p className="text-xs text-gray-400">
              {(() => {
                const spec = getTileAnalysis(selectedTile);
                if (!spec) return "Click highlighted spots on the game board boundaries to play this tile.";
                if (!spec.isPlayable) return "No matches available: Neither end of this tile matches the board's open pips.";
                return spec.playDescription;
              })()}
            </p>
          </div>
        </div>
      )}
    </div>
  );
};
