/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React from "react";
import { Tile } from "../types";
import { DominoTile } from "./DominoTile";

interface BoneyardViewProps {
  boneyard: Tile[];
  onDrawTile: (index: number) => void;
  title?: string;
  subtitle?: string;
  isDealingMode?: boolean;
  disabled?: boolean;
}

export const BoneyardView: React.FC<BoneyardViewProps> = ({ 
  boneyard, 
  onDrawTile, 
  title, 
  subtitle,
  isDealingMode = false,
  disabled = false
}) => {
  if (boneyard.length === 0) return null;

  return (
    <div 
      className={`absolute left-0 right-0 top-0 bottom-[130px] z-40 flex items-center justify-center p-4 transition-all duration-300 ${
        isDealingMode 
          ? "bg-black/25 backdrop-blur-[1px]" 
          : "bg-black/70 backdrop-blur-md"
      }`}
    >
      <div className="bg-gradient-to-b from-[#18181b]/95 to-[#09090b]/98 border border-white/10 rounded-2xl w-full max-w-sm overflow-hidden shadow-[0_20px_50px_rgba(0,0,0,0.9),0_0_30px_rgba(212,175,55,0.05)] animate-in zoom-in-95 duration-200">
        <div className="border-b border-white/5 bg-white/[0.02] py-4 text-center relative">
          <h2 className="bg-gradient-to-r from-amber-200 via-amber-400 to-amber-200 bg-clip-text text-transparent font-sans font-black text-2xl tracking-[0.15em] uppercase drop-shadow-sm">
            {title || "The Boneyard"}
          </h2>
          <p className="text-[10px] text-zinc-400 font-semibold tracking-wider uppercase mt-1">
            {subtitle || "Draw to continue playing"}
          </p>
          {isDealingMode && (
            <div className="mt-2.5 inline-flex items-center gap-1.5 px-3 py-1 rounded-full bg-amber-500/10 border border-amber-500/20 text-amber-400 font-mono text-[9px] uppercase tracking-wider font-bold">
              {boneyard.length} tiles in boneyard
            </div>
          )}
        </div>
        
        <div className="p-6">
          <div className="bg-zinc-950/60 rounded-xl p-4 border border-white/5 shadow-inner">
            <div className="grid grid-cols-5 gap-3 justify-items-center">
              {boneyard.map((tile, i) => (
                <div 
                  key={`bone-${i}`} 
                  className={`transform transition-all duration-200 ${
                    disabled 
                      ? "opacity-40 cursor-not-allowed pointer-events-none scale-95" 
                      : "hover:scale-105 hover:-translate-y-0.5 active:scale-95 active:translate-y-0"
                  }`}
                >
                  <DominoTile 
                    tile={tile} 
                    isVertical={true} 
                    faceDown={true} 
                    size="sm" 
                    onClick={() => onDrawTile(i)} 
                    disabled={disabled}
                  />
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
