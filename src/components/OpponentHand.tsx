import React from "react";
import { motion, AnimatePresence } from "motion/react";
import { Tile } from "../types";
import { DominoTile } from "./DominoTile";

interface OpponentHandProps {
  count: number;
  revealedTiles?: Tile[];
  isUnplayable?: boolean;
}

/**
 * 3D Glassy Decorative Pip
 */
/**
 * Face-down Ebony/Resin Domino Back
 * Features a classic premium ebony resin surface with a divider line and central brass spinner/pin.
 */
const DominoBack: React.FC = () => {
  return (
    <div className="
      relative w-full h-full rounded-md md:rounded-lg overflow-hidden border border-[#c2b9a7]
      bg-gradient-to-br from-[#FFFDFC] via-[#F5F2E6] to-[#E2DEC5]
      shadow-[inset_1.5px_1.5px_2px_#fff,inset_-1.5px_-1.5px_2px_rgba(0,0,0,0.15),0_4px_8px_rgba(0,0,0,0.4)]
     font-sans">
      {/* Subtle glossy sheen line across the back */}
      <div className="absolute inset-0 bg-gradient-to-tr from-transparent via-white/[0.06] to-transparent pointer-events-none" />
    </div>
  );
};

/**
 * OpponentHand Component
 * Renders face-down dominoes for the opponent with fluid layout animations.
 * Security: receives count only, preventing any leakage of real domino pips.
 */
export const OpponentHand: React.FC<OpponentHandProps> = React.memo(({ count, revealedTiles, isUnplayable }) => {
  // Generate stable mock array based on count
  const tiles = Array.from({ length: count }, (_, i) => `ai-tile-${i}`);
  const isRevealed = revealedTiles && revealedTiles.length > 0;

  return (
    <div className={`flex justify-center items-center select-none overflow-visible transition-all duration-350 ease-out
      ${isRevealed 
        ? "p-3 mt-0 min-h-[86px]" 
        : "p-0 -mt-6 sm:-mt-8 md:-mt-[36px] min-h-[30px] sm:min-h-[35px] md:min-h-[40px]"
      }
    `}>
      <div className={`flex justify-center items-center overflow-visible ${isRevealed ? "gap-1 sm:gap-2 flex-wrap" : "-space-x-[10px] sm:-space-x-[12px] md:-space-x-[14px]"}`}>
        <AnimatePresence>
          {isRevealed ? (
            revealedTiles.map((tile, index) => (
              <motion.div
                key={`ai-revealed-${tile[0]}-${tile[1]}-${index}`}
                layout
                initial={{ opacity: 0, scale: 0.8, y: -20 }}
                animate={{ 
                  opacity: 1, 
                  scale: 1, 
                  y: 0 
                }}
                exit={{ opacity: 0, scale: 0.5, y: 20 }}
                transition={{ type: "spring", stiffness: 350, damping: 28 }}
                className="relative shrink-0 overflow-visible"
                style={{ zIndex: 10 + index }}
              >
                <div className="
                  w-[38px] h-[76px] 
                  transition-all duration-300
                  relative
                ">
                  <DominoTile tile={tile} isVertical={true} size="sm" disabled={true} />
                  {isUnplayable && (
                    <div className="absolute inset-0 z-10 bg-red-950/45 border border-red-500 rounded-lg flex items-center justify-center animate-pulse pointer-events-none">
                      <span className="text-red-500 text-xs font-bold">✕</span>
                    </div>
                  )}
                </div>
              </motion.div>
            ))
          ) : (
            tiles.map((tileId, index) => (
              <motion.div
                key={tileId}
                layout
                initial={{ opacity: 0, scale: 0.8, y: -20, x: -15, width: 0 }}
                animate={{ 
                  opacity: 1, 
                  scale: 1, 
                  y: 0,
                  x: 0,
                  width: "auto" 
                }}
                exit={{ opacity: 0, scale: 0.5, y: -20, x: 15, width: 0 }}
                transition={{ type: "spring", stiffness: 350, damping: 28 }}
                className="relative shrink-0 overflow-visible"
                style={{ zIndex: 10 + index }}
              >
                <div className="
                  w-[38px] h-[76px] 
                  transition-all duration-300
                ">
                  <DominoBack />
                </div>
              </motion.div>
            ))
          )}
        </AnimatePresence>
      </div>
    </div>
  );
});

OpponentHand.displayName = "OpponentHand";
