/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import React, { useRef, useMemo } from "react";
import { PlacedTile, Tile } from "../types";
import { DominoTile } from "./DominoTile";
import { 
  getOpenEnds2D, 
  evaluatePlayability2D, 
  getPlayedTileRotation2D,
  computeTileLayouts,
  generateId,
  TileLayout
} from "../utils/dominoLogic";
import { PlayCircle, ShieldAlert } from "lucide-react";

interface GameBoardProps {
  placedTiles: PlacedTile[];
  selectedTile: Tile | null;
  onPlayTile: (side: "left" | "right" | "top" | "bottom") => void;
  currentPlayer: "user" | "ai";
  onDropTile?: (tile: Tile, side: "left" | "right" | "top" | "bottom") => void;
  scorePopup?: { points: number; gridX: number; gridY: number } | null;
  hoveredSlotSide?: "left" | "right" | "top" | "bottom" | null;
  highlightedTileId?: string | null;
}

export const GameBoard: React.FC<GameBoardProps> = ({
  placedTiles,
  selectedTile,
  onPlayTile,
  currentPlayer,
  onDropTile,
  scorePopup = null,
  hoveredSlotSide = null,
  highlightedTileId = null,
}) => {
  const tableRef = useRef<HTMLDivElement>(null);
  const [tableDimensions, setTableDimensions] = React.useState({ width: 360, height: 400 });

  React.useEffect(() => {
    if (!tableRef.current) return;
    const observer = new ResizeObserver((entries) => {
      for (const entry of entries) {
        setTableDimensions({
          width: entry.contentRect.width || 360,
          height: entry.contentRect.height || 400,
        });
      }
    });
    observer.observe(tableRef.current);
    return () => observer.disconnect();
  }, [placedTiles.length === 0]);

  const { width: tableWidth, height: tableHeight } = tableDimensions;

  const openEnds2D = useMemo(() => getOpenEnds2D(placedTiles), [placedTiles]);

  // Compute layouts for all played tiles
  const layouts = useMemo(() => computeTileLayouts(placedTiles), [placedTiles]);

  // Determine playability of selected tile
  const playability = useMemo(() => {
    if (!selectedTile || currentPlayer !== "user") {
      return { left: false, right: false, top: false, bottom: false };
    }
    return evaluatePlayability2D(selectedTile, openEnds2D);
  }, [selectedTile, openEnds2D, currentPlayer]);

  // Calculate layout coordinates for active play landing slots (preview tiles)
  const landingSlots = useMemo(() => {
    const slots: { 
      side: "left" | "right" | "top" | "bottom"; 
      gridX: number; 
      gridY: number; 
      isVertical: boolean;
      rotation: number;
      tileToDraw: Tile;
    }[] = [];
    
    if (placedTiles.length === 0) {
      const isDouble = selectedTile ? selectedTile[0] === selectedTile[1] : true;
      slots.push({
        side: "left", // plays at start
        gridX: 0,
        gridY: 0,
        isVertical: !isDouble,
        rotation: isDouble ? 0 : 90,
        tileToDraw: selectedTile || [0, 0],
      });
      return slots;
    }

    if (!selectedTile || currentPlayer !== "user") return slots;

    const sides: ("left" | "right" | "top" | "bottom")[] = ["left", "right", "top", "bottom"];
    const isDouble = selectedTile[0] === selectedTile[1];

    sides.forEach(side => {
      if (playability[side]) {
        // Build a temporary dummy tile and compute its layout
        const dummyId = `preview_slot_${side}`;
        const dummyTile: PlacedTile = {
          id: dummyId,
          tile: selectedTile,
          connectedAs: getPlayedTileRotation2D(selectedTile, side, openEnds2D),
          isDouble,
          playedAt: side,
        };

        const tempLayouts = computeTileLayouts([...placedTiles, dummyTile]);
        const slotLayout = tempLayouts[dummyId];

        if (slotLayout) {
          // Let's resolve the exact tileToDraw values for this slot!
          let tileToDraw = dummyTile.connectedAs;
          if (dummyTile.playedAt !== "start") {
            const branchTiles = [...placedTiles, dummyTile].filter(t => t.playedAt === dummyTile.playedAt);
            const indexInBranch = branchTiles.findIndex(t => t.id === dummyTile.id);
            
            let prevTile: PlacedTile | null = null;
            if (indexInBranch > 0) {
              prevTile = branchTiles[indexInBranch - 1];
            } else {
              if (dummyTile.playedAt === "top" || dummyTile.playedAt === "bottom") {
                prevTile = placedTiles.find(t => t.isDouble) || null;
              } else {
                prevTile = placedTiles.find(t => t.playedAt === "start") || null;
              }
            }

            if (prevTile) {
              const prevLay = tempLayouts[prevTile.id];
              if (prevLay) {
                const isVertical = slotLayout.rotation === 0 || slotLayout.rotation === 180;
                if (isVertical) {
                  const dTopSq = Math.pow(slotLayout.gridX - prevLay.gridX, 2) + Math.pow(slotLayout.gridY - 0.5 - prevLay.gridY, 2);
                  const dBottomSq = Math.pow(slotLayout.gridX - prevLay.gridX, 2) + Math.pow(slotLayout.gridY + 0.5 - prevLay.gridY, 2);
                  if (dBottomSq < dTopSq) {
                    tileToDraw = [dummyTile.connectedAs[1], dummyTile.connectedAs[0]];
                  }
                } else {
                  const dLeftSq = Math.pow(slotLayout.gridX - 0.5 - prevLay.gridX, 2) + Math.pow(slotLayout.gridY - prevLay.gridY, 2);
                  const dRightSq = Math.pow(slotLayout.gridX + 0.5 - prevLay.gridX, 2) + Math.pow(slotLayout.gridY - prevLay.gridY, 2);
                  if (dRightSq < dLeftSq) {
                    tileToDraw = [dummyTile.connectedAs[1], dummyTile.connectedAs[0]];
                  }
                }
              }
            }
          }

          slots.push({
            side,
            gridX: slotLayout.gridX,
            gridY: slotLayout.gridY,
            isVertical: slotLayout.rotation === 0 || slotLayout.rotation === 180,
            rotation: slotLayout.rotation,
            tileToDraw,
          });
        }
      }
    });

    return slots;
  }, [selectedTile, playability, placedTiles, openEnds2D, currentPlayer]);

  // Determine auto-scaling and bounding box
  // Let's compute grid boundaries
  const boundaries = useMemo(() => {
    let minX = -1.0;
    let maxX = 1.0;
    let minY = -1.0;
    let maxY = 1.0;

    // Played tiles
    Object.values(layouts).forEach((lay) => {
      const tileLay = lay as TileLayout;
      const isVertical = tileLay.rotation === 0 || tileLay.rotation === 180;
      const hWidth = isVertical ? 0.5 : 1.0;
      const hHeight = isVertical ? 1.0 : 0.5;
      minX = Math.min(minX, tileLay.gridX - hWidth);
      maxX = Math.max(maxX, tileLay.gridX + hWidth);
      minY = Math.min(minY, tileLay.gridY - hHeight);
      maxY = Math.max(maxY, tileLay.gridY + hHeight);
    });

    // Slots
    landingSlots.forEach(slot => {
      const hWidth = slot.isVertical ? 0.5 : 1.0;
      const hHeight = slot.isVertical ? 1.0 : 0.5;
      minX = Math.min(minX, slot.gridX - hWidth);
      maxX = Math.max(maxX, slot.gridX + hWidth);
      minY = Math.min(minY, slot.gridY - hHeight);
      maxY = Math.max(maxY, slot.gridY + hHeight);
    });

    // Add balanced safe margin to fully contain endpoint value badges and outline glow
    minX -= 0.6;
    maxX += 0.6;
    minY -= 0.6;
    maxY += 0.6;

    const gridWidth = maxX - minX;
    const gridHeight = maxY - minY;
    const centerX = (minX + maxX) / 2;
    const centerY = (minY + maxY) / 2;

    return { minX, maxX, minY, maxY, gridWidth, gridHeight, centerX, centerY };
  }, [layouts, landingSlots]);

  const GRID_SIZE = 44; // Coordinate multiplier (using size="md" as base tile size)

  // We set our Grid Scale Unit size: 1 unit = 44px
  // We apply CSS scale transform to fit the entire board inside the observed container bounds
  const scale = useMemo(() => {
    // Deduct static margins for the absolute top-header and bottom-footer overlays.
    // This guarantees the active board fits strictly within the clean, unblocked green center region.
    const usableWidth = Math.max(160, tableWidth - 12); 
    const usableHeight = Math.max(100, tableHeight - 24);

    const boardPixelWidth = boundaries.gridWidth * GRID_SIZE;
    const boardPixelHeight = boundaries.gridHeight * GRID_SIZE;

    const scaleX = usableWidth / boardPixelWidth;
    const scaleY = usableHeight / boardPixelHeight;

    const geoScale = Math.min(scaleX, scaleY);

    // Continuous progressive scale factor based on placed domino count to avoid key jumps
    const n = placedTiles.length;
    let maxScaleByCount = 1.0;
    if (n > 8) {
      maxScaleByCount = Math.max(0.40, 1.0 - (n - 8) * 0.01);
    }

    // Combine geometric fit and count-based progressive guidelines
    const finalScale = Math.min(maxScaleByCount, geoScale);

    // Minimum scale capped at 0.04, maximum at 1.0 (never oversized for small chains)
    return Math.max(0.04, Math.min(1.0, finalScale));
  }, [boundaries, tableWidth, tableHeight, placedTiles.length]);

  // Show center start instruction button if empty
  const isBoardEmpty = placedTiles.length === 0;

  return (
    <div 
      className="relative w-full h-full bg-transparent overflow-hidden cursor-default select-none"
      id="domino-game-table"
    >
      <style dangerouslySetInnerHTML={{__html: `
        @keyframes scorePopup {
          0% {
            transform: translate(-50%, -50%) scale(0.5) translateY(20px) rotate(-5deg);
            opacity: 0;
          }
          15% {
            transform: translate(-50%, -50%) scale(1.25) translateY(-15px) rotate(-7deg);
            opacity: 1;
          }
          35% {
            transform: translate(-50%, -50%) scale(1.0) translateY(0) rotate(-5deg);
            opacity: 1;
          }
          80% {
            transform: translate(-50%, -50%) scale(1.0) translateY(-25px) rotate(-5deg);
            opacity: 1;
          }
          100% {
            transform: translate(-50%, -50%) scale(0.8) translateY(-50px) rotate(-3deg);
            opacity: 0;
          }
        }
        .animate-score-popup {
          animation: scorePopup 1.5s cubic-bezier(0.175, 0.885, 0.32, 1.275) forwards;
        }
      `}} />
      {/* Felt background table textures */}
      <div className="absolute inset-0 opacity-[0.03] bg-[linear-gradient(rgba(255,255,255,0.05)_1px,transparent_1px),linear-gradient(90deg,rgba(255,255,255,0.05)_1px,transparent_1px)] bg-[size:20px_20px] pointer-events-none" />

      {/* No crest needed for this clean design */}

        <div 
          ref={tableRef} 
          className="absolute inset-0 w-full h-full flex items-center justify-center overflow-hidden"
        >

          {/* Scaled Board Stage */}
          <div 
            className="relative transition-transform duration-500 ease-out flex items-center justify-center"
            style={{
              transform: `scale(${scale})`,
              willChange: "transform",
              transformStyle: "preserve-3d",
              backfaceVisibility: "hidden",
              width: "100%",
              height: "100%",
            }}
          >
            {/* Center anchor container: dynamically moved so bounding box center sits at true center of stage */}
            <div 
              className="absolute top-1/2 left-1/2"
              style={{
                transform: `translate(calc(-50% - ${boundaries.centerX * GRID_SIZE}px), calc(-50% - ${boundaries.centerY * GRID_SIZE}px))`,
                transformStyle: "preserve-3d",
                backfaceVisibility: "hidden",
              }}
            >
              
              {/* Draw Played Tiles */}
              {placedTiles.map(pt => {
                const lay = layouts[pt.id];
                if (!lay) return null;
                const isVertical = lay.rotation === 0 || lay.rotation === 180;

                // Spacing in pixels on the absolute stage
                const pxX = lay.gridX * GRID_SIZE;
                const pxY = lay.gridY * GRID_SIZE;

                // Determine if we should flip the visual orientation of the tile
                let tileToDraw = pt.connectedAs;
                if (pt.playedAt !== "start") {
                  const branchTiles = placedTiles.filter(t => t.playedAt === pt.playedAt);
                  const indexInBranch = branchTiles.findIndex(t => t.id === pt.id);
                  
                  let prevTile: PlacedTile | null = null;
                  if (indexInBranch > 0) {
                    prevTile = branchTiles[indexInBranch - 1];
                  } else {
                    if (pt.playedAt === "top" || pt.playedAt === "bottom") {
                      prevTile = placedTiles.find(t => t.isDouble) || null;
                    } else {
                      prevTile = placedTiles.find(t => t.playedAt === "start") || null;
                    }
                  }

                  if (prevTile) {
                    const prevLay = layouts[prevTile.id];
                    if (prevLay) {
                      if (isVertical) {
                        const dTopSq = Math.pow(lay.gridX - prevLay.gridX, 2) + Math.pow(lay.gridY - 0.5 - prevLay.gridY, 2);
                        const dBottomSq = Math.pow(lay.gridX - prevLay.gridX, 2) + Math.pow(lay.gridY + 0.5 - prevLay.gridY, 2);
                        if (dBottomSq < dTopSq) {
                          tileToDraw = [pt.connectedAs[1], pt.connectedAs[0]];
                        }
                      } else {
                        const dLeftSq = Math.pow(lay.gridX - 0.5 - prevLay.gridX, 2) + Math.pow(lay.gridY - prevLay.gridY, 2);
                        const dRightSq = Math.pow(lay.gridX + 0.5 - prevLay.gridX, 2) + Math.pow(lay.gridY - prevLay.gridY, 2);
                        if (dRightSq < dLeftSq) {
                          tileToDraw = [pt.connectedAs[1], pt.connectedAs[0]];
                        }
                      }
                    }
                  }
                }

                const isWinningMove = pt.id === highlightedTileId;
                const isLatestPlaced = pt.id === placedTiles[placedTiles.length - 1]?.id;

                return (
                  <div
                    key={pt.id}
                    className={`absolute transition-all duration-500 hover:z-25 
                      ${isWinningMove ? "z-40 scale-110 ring-4 ring-amber-400 rounded-lg shadow-[0_0_35px_rgba(245,158,11,0.9)] animate-pulse" : ""}
                      ${isLatestPlaced && !isWinningMove ? "animate-board-impact z-30" : ""}
                    `}
                    style={{
                      left: `${pxX}px`,
                      top: `${pxY}px`,
                      width: isVertical ? "44px" : "88px",
                      height: isVertical ? "88px" : "44px",
                      transform: "translate(-50%, -50%)",
                      transformStyle: "preserve-3d",
                      backfaceVisibility: "hidden",
                      willChange: "transform",
                      filter: "drop-shadow(0 6px 8px rgba(0, 0, 0, 0.5))",
                    }}
                  >
                    <DominoTile
                      tile={tileToDraw}
                      isVertical={isVertical}
                      size="md"
                      disabled={true}
                      isOnBoard={true}
                    />
                  </div>
                );
              })}

              {/* Draw Active Play Landing Slots (Preview placements) */}
              {landingSlots.map(slot => {
                const pxX = slot.gridX * GRID_SIZE;
                const pxY = slot.gridY * GRID_SIZE;

                return (
                  <button
                    key={`slot_${slot.side}`}
                    data-slot-side={slot.side}
                    data-slot-rotation={slot.rotation}
                    data-slot-vertical={slot.isVertical ? "true" : "false"}
                    data-slot-val1={slot.tileToDraw[0]}
                    data-slot-val2={slot.tileToDraw[1]}
                    onClick={() => onPlayTile(slot.side)}
                    onDragOver={(e) => e.preventDefault()}
                    onDrop={(e) => {
                      e.preventDefault();
                      try {
                        const tileData = e.dataTransfer.getData("text/plain");
                        if (tileData) {
                          const tile = JSON.parse(tileData);
                          if (onDropTile) onDropTile(tile, slot.side);
                        }
                      } catch (err) {
                        console.error(err);
                      }
                    }}
                    className="absolute z-30 flex items-center justify-center transition-all duration-200 outline-none hover:brightness-125 focus:brightness-125 group cursor-pointer"
                    style={{
                      left: `${pxX}px`,
                      top: `${pxY}px`,
                      width: `${(slot.isVertical ? 44 : 88) + 40}px`,
                      height: `${(slot.isVertical ? 88 : 44) + 40}px`,
                      transform: "translate(-50%, -50%)",
                      transformStyle: "preserve-3d",
                      backfaceVisibility: "hidden",
                      willChange: "transform",
                    }}
                  >
                    {/* Ghost dotted tile outline */}
                    <div 
                      className={`
                        rounded-lg border-2 border-dashed overflow-hidden flex flex-col items-center justify-center transition-all duration-200
                        ${slot.isVertical ? "pt-1" : "pl-1"}
                        ${hoveredSlotSide === slot.side 
                          ? "border-amber-400 bg-amber-400/40 scale-105 shadow-[0_0_40px_rgba(245,158,11,0.95)] ring-2 ring-amber-400/50" 
                          : "border-amber-500 bg-amber-950/30 shadow-[0_0_15px_rgba(245,158,11,0.25)] group-hover:shadow-[0_0_25px_rgba(245,158,11,0.5)]"}
                      `}
                      style={{
                        width: slot.isVertical ? "44px" : "88px",
                        height: slot.isVertical ? "88px" : "44px",
                      }}
                    >
                    </div>
                  </button>
                );
              })}

              {/* Endpoint Value Labels/Badges removed per user request */}

              {/* Draw Center Score Popup */}
              {scorePopup && (
                <div
                  className="animate-score-popup absolute pointer-events-none select-none z-45 font-extrabold italic text-center"
                  style={{
                    left: `${scorePopup.gridX * GRID_SIZE}px`,
                    top: `${scorePopup.gridY * GRID_SIZE}px`,
                    fontSize: "4.5rem",
                    fontFamily: "'Outfit', 'Impact', sans-serif",
                    color: "#ffcc00",
                    WebkitTextStroke: "2.5px #000000",
                    textShadow: "0px 8px 16px rgba(0, 0, 0, 0.6), 0px 4px 4px rgba(0, 0, 0, 0.4)",
                    transform: "translate(-50%, -50%) rotate(-5deg)",
                  }}
                >
                  +{scorePopup.points}
                </div>
              )}
            </div>
          </div>
        </div>

    </div>
  );
};
