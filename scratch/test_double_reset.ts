// We copy the computeTileLayouts function and modify the straightCount logic to test the result.
import { PlacedTile, TileLayout, BoundingBox } from "../src/types";
import { getOpenEnds2D, getPlayedTileRotation2D, getTileGeometry, getBoundingBox, intersectBoxes } from "../src/utils/dominoLogic";

function computeTileLayoutsCustom(placedTiles: PlacedTile[]): Record<string, TileLayout> {
  const layouts: Record<string, TileLayout> = {};
  if (placedTiles.length === 0) return layouts;

  const startTile = placedTiles.find(pt => pt.playedAt === "start");
  if (!startTile) return layouts;

  const rawPositions: Record<string, TileLayout> = {};
  rawPositions[startTile.id] = { gridX: 0, gridY: 0, rotation: startTile.isDouble ? 0 : 90 };

  const placedBoxes: { id: string; box: BoundingBox }[] = [];
  placedBoxes.push({
    id: startTile.id,
    box: getBoundingBox(0, 0, startTile.isDouble ? 0 : 90)
  });

  const tileBranches: Record<string, string> = {};
  tileBranches[startTile.id] = "start";

  const branchStates: Record<"left" | "right" | "top" | "bottom", any> = {
    left: { cursorX: startTile.isDouble ? -0.5 : -1.0, cursorY: 0, dir: "left", prevDir: "left", lastTileId: startTile.id, initialized: true, straightCount: 1 },
    right: { cursorX: startTile.isDouble ? 0.5 : 1.0, cursorY: 0, dir: "right", prevDir: "right", lastTileId: startTile.id, initialized: true, straightCount: 1 },
    top: { cursorX: 0, cursorY: 0, dir: "up", prevDir: "up", lastTileId: startTile.id, initialized: false, straightCount: 0 },
    bottom: { cursorX: 0, cursorY: 0, dir: "down", prevDir: "down", lastTileId: startTile.id, initialized: false, straightCount: 0 }
  };

  if (startTile.isDouble) {
    branchStates.top = { cursorX: 0, cursorY: -1.0, dir: "up", prevDir: "up", lastTileId: startTile.id, initialized: true, straightCount: 1 };
    branchStates.bottom = { cursorX: 0, cursorY: 1.0, dir: "down", prevDir: "down", lastTileId: startTile.id, initialized: true, straightCount: 1 };
  }

  const tileCount = placedTiles.length;
  const scaleFactor = Math.min(2.0, 1.0 + tileCount * 0.03);
  const MAX_LIMIT_X = Math.round(8.5 * scaleFactor);
  const MIN_LIMIT_X = -Math.round(8.5 * scaleFactor);
  const MAX_LIMIT_Y = Math.round(7.5 * scaleFactor);
  const MIN_LIMIT_Y = -Math.round(7.5 * scaleFactor);

  placedTiles.forEach(pt => {
    if (pt.playedAt === "start") return;

    const branch = pt.playedAt;
    const state = branchStates[branch];
    if (!state) return;

    const predecessorId = state.lastTileId;
    const prevTile = placedTiles.find(t => t.id === predecessorId);
    const prevIsDouble = prevTile ? prevTile.isDouble : false;

    // Reset straightCount on double tiles so the next tile MUST continue straight
    const shouldTurn = state.straightCount >= 4 && !pt.isDouble;

    const priorityDirs: ("left" | "right" | "up" | "down")[] = ["right", "down", "left", "up"];

    const isDirSafe = (dir: "left" | "right" | "up" | "down", useLimits: boolean, margin: number) => {
      if (pt.isDouble && dir !== state.dir) return null;
      if (
        (dir === "left" && state.prevDir === "right") ||
        (dir === "right" && state.prevDir === "left") ||
        (dir === "up" && state.prevDir === "down") ||
        (dir === "down" && state.prevDir === "up")
      ) {
        return null;
      }

      const geom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, dir, pt.isDouble, prevIsDouble);
      const box = getBoundingBox(geom.gridX, geom.gridY, geom.rotation);

      for (const ob of placedBoxes) {
        const isPredecessor = ob.id === predecessorId;
        const epsilon = isPredecessor ? 0.05 : margin;
        if (intersectBoxes(box, ob.box, epsilon)) return null;
      }

      // Parallel touching prevention
      const isVertical = box.maxX - box.minX === 1.0;
      for (const ob of placedBoxes) {
        if (ob.id === predecessorId) continue;
        const obBranch = tileBranches[ob.id] || "start";
        if (obBranch === "start" || obBranch === branch) continue;

        const obVertical = ob.box.maxX - ob.box.minX === 1.0;
        if (isVertical && obVertical) {
          const xDistance = Math.abs((box.minX + box.maxX)/2 - (ob.box.minX + ob.box.maxX)/2);
          if (xDistance < 1.5) {
            const yOverlap = box.minY < ob.box.maxY - 0.05 && box.maxY > ob.box.minY + 0.05;
            if (yOverlap) return null;
          }
        } else if (!isVertical && !obVertical) {
          const yDistance = Math.abs((box.minY + box.maxY)/2 - (ob.box.minY + ob.box.maxY)/2);
          if (yDistance < 1.5) {
            const xOverlap = box.minX < ob.box.maxX - 0.05 && box.maxX > ob.box.minX + 0.05;
            if (xOverlap) return null;
          }
        }
      }

      if (useLimits) {
        if (geom.gridX < MIN_LIMIT_X || geom.gridX > MAX_LIMIT_X || geom.gridY < MIN_LIMIT_Y || geom.gridY > MAX_LIMIT_Y) {
          return null;
        }
      }
      return { geom, box };
    };

    const SAFETY_MARGIN = -0.25;
    let selectedDir = state.dir;
    let selectedGeom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, state.dir, pt.isDouble, prevIsDouble);
    let selectedBox = getBoundingBox(selectedGeom.gridX, selectedGeom.gridY, selectedGeom.rotation);
    let foundSafe = false;

    if (state.straightCount < 4) {
      const res = isDirSafe(state.dir, true, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }

    if (!foundSafe) {
      for (const d of priorityDirs) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, true, SAFETY_MARGIN);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    if (!foundSafe) {
      const res = isDirSafe(state.dir, true, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }

    if (!foundSafe) {
      const res = isDirSafe(state.dir, false, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }
    if (!foundSafe) {
      for (const d of priorityDirs) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, false, SAFETY_MARGIN);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    if (!foundSafe) {
      const res = isDirSafe(state.dir, false, 0.05);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }
    if (!foundSafe) {
      for (const d of priorityDirs) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, false, 0.05);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    if (!foundSafe) {
      let fallbackDir = state.dir;
      for (const d of priorityDirs) {
        const isBackwards = (
          (d === "left" && state.prevDir === "right") ||
          (d === "right" && state.prevDir === "left") ||
          (d === "up" && state.prevDir === "down") ||
          (d === "down" && state.prevDir === "up")
        );
        if (!isBackwards) {
          fallbackDir = d;
          break;
        }
      }
      selectedDir = fallbackDir;
      selectedGeom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, selectedDir, pt.isDouble, prevIsDouble);
      selectedBox = getBoundingBox(selectedGeom.gridX, selectedGeom.gridY, selectedGeom.rotation);
    }

    rawPositions[pt.id] = {
      gridX: selectedGeom.gridX,
      gridY: selectedGeom.gridY,
      rotation: selectedGeom.rotation
    };

    placedBoxes.push({ id: pt.id, box: selectedBox });
    tileBranches[pt.id] = branch;

    state.cursorX = selectedGeom.nextCursorX;
    state.cursorY = selectedGeom.nextCursorY;
    
    // Update straight count - reset if it is a double!
    if (pt.isDouble) {
      state.straightCount = 1;
    } else if (selectedDir === state.dir) {
      state.straightCount += 1;
    } else {
      state.straightCount = 1;
    }
    
    state.prevDir = selectedDir;
    state.dir = selectedDir;
    state.lastTileId = pt.id;

    if (pt.isDouble && !branchStates.top.initialized && !branchStates.bottom.initialized) {
      const isSpinnerVertical = selectedGeom.rotation === 0 || selectedGeom.rotation === 180;
      const offset = isSpinnerVertical ? 1.0 : 0.5;

      branchStates.top = { cursorX: selectedGeom.gridX, cursorY: selectedGeom.gridY - offset, dir: "up", prevDir: "up", lastTileId: pt.id, initialized: true, straightCount: 1 };
      branchStates.bottom = { cursorX: selectedGeom.gridX, cursorY: selectedGeom.gridY + offset, dir: "down", prevDir: "down", lastTileId: pt.id, initialized: true, straightCount: 1 };
    }
  });

  const pivotId = startTile.id;
  const pivotPos = rawPositions[pivotId] || { gridX: 0, gridY: 0 };
  Object.keys(rawPositions).forEach(id => {
    layouts[id] = {
      gridX: rawPositions[id].gridX - pivotPos.gridX,
      gridY: rawPositions[id].gridY - pivotPos.gridY,
      rotation: rawPositions[id].rotation
    };
  });
  return layouts;
}

// Test Case: l4 after double l3
const placedTiles: PlacedTile[] = [
  { id: "start", tile: [5, 5], connectedAs: [5, 5], isDouble: true, playedAt: "start" },
  { id: "l1", tile: [5, 2], connectedAs: [5, 2], isDouble: false, playedAt: "left" },
  { id: "l2", tile: [2, 1], connectedAs: [2, 1], isDouble: false, playedAt: "left" },
  { id: "l3", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "left" },
  { id: "l4", tile: [1, 4], connectedAs: [1, 4], isDouble: false, playedAt: "left" }
];

console.log("=== Testing Custom computeTileLayouts with double straightCount reset ===");
const layouts = computeTileLayoutsCustom(placedTiles);
placedTiles.forEach(t => {
  const lay = layouts[t.id];
  console.log(`Tile ${t.tile[0]}:${t.tile[1]} (${t.id}): gridX=${lay?.gridX}, gridY=${lay?.gridY}, rotation=${lay?.rotation} (${lay?.rotation === 0 || lay?.rotation === 180 ? 'vertical' : 'horizontal'})`);
});
