/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React from "react";
import { Tile } from "../types";

interface DominoTileProps {
  tile: Tile;
  isVertical?: boolean;
  faceDown?: boolean;
  highlighted?: boolean;
  disabled?: boolean;
  onClick?: () => void;
  size?: "sm" | "md" | "lg" | "xl";
  playableSide?: "left" | "right" | "both" | null;
  showRecommendation?: "best" | "good" | "neutral" | "risky" | null;
  draggable?: boolean;
  onDragStart?: (e: React.DragEvent) => void;
  onDragEnd?: (e: React.DragEvent) => void;
  onPointerDown?: (e: React.PointerEvent<HTMLButtonElement>) => void;
  onPointerMove?: (e: React.PointerEvent<HTMLButtonElement>) => void;
  onPointerUp?: (e: React.PointerEvent<HTMLButtonElement>) => void;
  onPointerCancel?: (e: React.PointerEvent<HTMLButtonElement>) => void;
  isOnBoard?: boolean;
}

/**
 * High-fidelity, beautifully styled Domino tile component.
 * Renders realistic pip arrangements, brass spinner center, and ivory texture.
 */
export const DominoTile: React.FC<DominoTileProps> = ({
  tile,
  isVertical = true,
  faceDown = false,
  highlighted = false,
  disabled = false,
  onClick,
  size = "md",
  playableSide = null,
  showRecommendation = null,
  draggable = false,
  onDragStart,
  onDragEnd,
  onPointerDown,
  onPointerMove,
  onPointerUp,
  onPointerCancel,
  isOnBoard = false,
}) => {
  const [val1, val2] = tile;

  // Determine sizing in pixels
  let width = 44;
  let height = 88;

  if (size === "sm") {
    width = 38;
    height = 76;
  } else if (size === "lg") {
    width = 54;
    height = 108;
  } else if (size === "xl") {
    width = 64;
    height = 128;
  }

  // Adjust dimensions if horizontal
  const dWidth = isVertical ? width : height;
  const dHeight = isVertical ? height : width;

  // Render a single half of a domino (square) containing dots
  const renderSquarePips = (value: number) => {
    if (value === 0) return null;

    // Pip position classes for a 3x3 grid
    // Grids are from:
    // Row 1: TL (top-left), TC (top-center), TR (top-right)
    // Row 2: ML (mid-left),  MC (mid-center),  MR (mid-right)
    // Row 3: BL (bot-left),  BC (bot-center),  BR (bot-right)
    const pipsLayout: { [key: number]: string[] } = {
      1: ["MC"],
      2: isVertical ? ["TL", "BR"] : ["BL", "TR"],
      3: isVertical ? ["TL", "MC", "BR"] : ["BL", "MC", "TR"],
      4: ["TL", "TR", "BL", "BR"],
      5: ["TL", "TR", "MC", "BL", "BR"],
      6: isVertical 
        ? ["TL", "TR", "ML", "MR", "BL", "BR"]
        : ["TL", "TC", "TR", "BL", "BC", "BR"],
    };

    const activePips = pipsLayout[value] || [];

    const getSocketStyle = (pos: string) => {
      let top = "50%";
      let left = "50%";

      switch (pos) {
        case "TL": top = "20%"; left = "20%"; break;
        case "TC": top = "20%"; left = "50%"; break;
        case "TR": top = "20%"; left = "80%"; break;
        case "ML": top = "50%"; left = "20%"; break;
        case "MC": top = "50%"; left = "50%"; break;
        case "MR": top = "50%"; left = "80%"; break;
        case "BL": top = "80%"; left = "20%"; break;
        case "BC": top = "80%"; left = "50%"; break;
        case "BR": top = "80%"; left = "80%"; break;
      }

      const outerSize = size === "sm" ? 7 : size === "md" ? 10 : size === "lg" ? 12 : 14.5;
      const padding = size === "sm" ? 0.75 : size === "md" ? 1 : size === "lg" ? 1.25 : 1.5;

      return {
        top,
        left,
        transform: "translate(-50%, -50%)",
        width: `${outerSize}px`,
        height: `${outerSize}px`,
        padding: `${padding}px`,
      };
    };

    const getPipRadialGradient = (val: number) => {
      switch (val) {
        case 1: // Cyan
          return "radial-gradient(circle at 40% 40%, #00f0f0 0%, #00b3b3 60%, #008080 100%)";
        case 2: // Green
          return "radial-gradient(circle at 40% 40%, #00e600 0%, #00b300 60%, #008000 100%)";
        case 3: // Magenta/Pink
          return "radial-gradient(circle at 40% 40%, #ff1a75 0%, #d80052 60%, #990033 100%)";
        case 4: // Brown
          return "radial-gradient(circle at 40% 40%, #995c33 0%, #734020 60%, #4d2613 100%)";
        case 5: // Blue
          return "radial-gradient(circle at 40% 40%, #1a75ff 0%, #0047b3 60%, #003380 100%)";
        case 6: // Orange/Gold
          return "radial-gradient(circle at 40% 40%, #ffb31a 0%, #e69900 60%, #b37700 100%)";
        default: // Default gray
          return "radial-gradient(circle at 40% 40%, #ffffff 0%, #cccccc 60%, #888888 100%)";
      }
    };

    return (
      <div className="relative w-full h-full p-2">
        {activePips.map((pos, idx) => (
          <span
            key={idx}
            className="absolute rounded-full flex items-center justify-center"
            style={{
              ...getSocketStyle(pos),
              background: getPipRadialGradient(value),
              boxShadow: "inset 1.5px 1.5px 3px rgba(0,0,0,0.6), 0.5px 0.5px 1px rgba(255,255,255,0.7)",
            }}
          >
            {/* Subtle highlight to give it depth */}
            <span className="absolute top-[20%] left-[20%] w-[25%] h-[25%] rounded-full bg-white/40 pointer-events-none" />
          </span>
        ))}
      </div>
    );
  };

  // Recommendations border glows
  const getRecommendationGlow = () => {
    if (!showRecommendation) return "";
    switch (showRecommendation) {
      case "best":
        return "ring-3 ring-emerald-400 shadow-[0_0_15px_rgba(16,185,129,0.6)]";
      case "good":
        return "ring-2 ring-emerald-500/60 shadow-[0_0_8px_rgba(52,211,153,0.3)]";
      case "risky":
        return "ring-2 ring-amber-500 shadow-[0_0_10px_rgba(245,158,11,0.5)]";
      case "neutral":
        return "ring-1 ring-blue-400/50";
    }
  };

  return (
    <button
      onClick={!disabled && onClick ? onClick : undefined}
      disabled={disabled}
      draggable={draggable}
      onDragStart={onDragStart || ((e) => e.preventDefault())}
      onDragEnd={onDragEnd}
      onPointerDown={onPointerDown}
      onPointerMove={onPointerMove}
      onPointerUp={onPointerUp}
      onPointerCancel={onPointerCancel}
      className={`
        relative select-none outline-none transition-all duration-250 cursor-pointer bg-transparent
        ${disabled ? (isOnBoard ? "cursor-default" : "cursor-not-allowed opacity-60") : "hover:-translate-y-1 hover:brightness-105 active:scale-95"}
        ${highlighted ? "ring-2 ring-amber-400 -translate-y-5 scale-105 shadow-[0_12px_24px_rgba(0,0,0,0.6)] z-30" : "shadow-[0_4px_8px_rgba(0,0,0,0.5)]"}
        ${getRecommendationGlow()}
        rounded-lg
        ${isOnBoard ? "p-[1.5px]" : ""}
      `}
      style={{
        width: `${dWidth}px`,
        height: `${dHeight}px`,
        touchAction: (draggable || onPointerDown) ? "pan-x" : "auto",
        userSelect: (draggable || onPointerDown) ? "none" : "auto",
      }}
    >
      {/* Tile Face Design: Off-white/Ivory textured backing with beautiful plastic-molded look */}
      <div
        className={`
          relative w-full h-full rounded-lg overflow-hidden border shadow-md transition-all duration-200
          ${faceDown 
            ? "bg-gradient-to-br from-[#FFFDFC] via-[#F5F2E6] to-[#E2DEC5] border-[#c2b9a7] shadow-[inset_1.5px_1.5px_2px_#fff,inset_-1.5px_-1.5px_2px_rgba(0,0,0,0.15),0_4px_8px_rgba(0,0,0,0.4)]" 
            : `bg-gradient-to-br from-[#FFFDFC] via-[#F5F2E6] to-[#E2DEC5] ${isOnBoard ? "border-[#dcd8cc]" : "border-[#c2b9a7]"} text-gray-900 shadow-[inset_1.5px_1.5px_1.5px_#fff,inset_-1.5px_-1.5px_1.5px_rgba(0,0,0,0.18)]`}
        `}
      >
        {/* Soft overhead spotlight glare for 3D realism on the board */}
        {!faceDown && isOnBoard && (
          <div className="absolute inset-0 bg-gradient-to-b from-white/18 via-white/5 to-transparent pointer-events-none z-10" />
        )}
        {faceDown ? (
          // Clean white back — identical to opponent hand tiles
          <div className="absolute inset-0">
            {/* Subtle glossy sheen — same as OpponentHand DominoBack */}
            <div className="absolute inset-0 bg-gradient-to-tr from-transparent via-white/[0.06] to-transparent pointer-events-none" />
          </div>
        ) : (
          // Playable design of domino face (with dividers & dots!)
          <div className={`flex w-full h-full ${isVertical ? "flex-col" : "flex-row"}`}>
            {/* Top / Left Half */}
            <div className="flex-1 w-full h-full flex items-center justify-center">
              {renderDoubleSixPips(val1)}
            </div>
 
            {/* Brass Center Spinner (Center Pin) & Joint Line Divider */}
            <div
              className={`
                relative shrink-0
                ${isVertical 
                  ? "h-[2px] w-full bg-gradient-to-b from-[#3a362f] to-[#fff]/40 shadow-[inset_0_1px_1px_rgba(0,0,0,0.4)]" 
                  : "w-[2px] h-full bg-gradient-to-r from-[#3a362f] to-[#fff]/40 shadow-[inset_1px_0_1px_rgba(0,0,0,0.4)]"}
              `}
            >
              {/* Spinner Pin */}
              <div 
                className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 rounded-full border border-black/45 shadow-[0_1px_1px_rgba(0,0,0,0.45),inset_0.5px_0.5px_0.5px_#fff]"
                style={{
                  width: size === "sm" ? "4px" : "6px",
                  height: size === "sm" ? "4px" : "6px",
                  background: "radial-gradient(circle at 35% 35%, #fff1a8 0%, #d4af37 40%, #856404 85%, #3c2d00 100%)",
                }}
              />
            </div>

            {/* Bottom / Right Half */}
            <div className="flex-1 w-full h-full flex items-center justify-center">
              {renderDoubleSixPips(val2)}
            </div>
          </div>
        )}
      </div>

      {/* Visual Indicator of helper triggers (Play here) */}
      {playableSide && !disabled && (
        <span className="absolute -top-1 -right-1 flex h-4 w-4">
          <span className="animate-ping absolute inline-flex h-full w-full rounded-full bg-amber-400 opacity-75"></span>
          <span className="relative inline-flex rounded-full h-4 w-4 bg-amber-500 text-[10px] items-center justify-center font-bold text-black shadow-md">
            {playableSide === "left" ? "L" : playableSide === "right" ? "R" : "⇌"}
          </span>
        </span>
      )}
    </button>
  );

  // Fallback map wrapper
  function renderDoubleSixPips(value: number) {
    return renderSquarePips(value);
  }
};
