import { computeTileLayouts } from "../src/utils/dominoLogic";
import { PlacedTile } from "../src/types";

const placedTiles: PlacedTile[] = [
  { id: "start", tile: [5, 5], connectedAs: [5, 5], isDouble: true, playedAt: "start" },
  // Left branch
  { id: "l1", tile: [5, 2], connectedAs: [5, 2], isDouble: false, playedAt: "left" },
  { id: "l2", tile: [2, 6], connectedAs: [2, 6], isDouble: false, playedAt: "left" },
  { id: "l3", tile: [6, 1], connectedAs: [6, 1], isDouble: false, playedAt: "left" },
  { id: "l4", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "left" },
  { id: "l5", tile: [3, 2], connectedAs: [3, 2], isDouble: false, playedAt: "left" }, // Wait, connects 3, exposes 2
  { id: "l6", tile: [2, 4], connectedAs: [4, 2], isDouble: false, playedAt: "left" }, // Connects 4 to 2? No, connects 2 to 2? Wait!
  { id: "l7", tile: [2, 2], connectedAs: [2, 2], isDouble: true, playedAt: "left" },
  { id: "l8", tile: [2, 6], connectedAs: [2, 6], isDouble: false, playedAt: "left" },
  { id: "l9", tile: [6, 3], connectedAs: [6, 3], isDouble: false, playedAt: "left" },
];

console.log("=== Computing layouts ===");
try {
  const layouts = computeTileLayouts(placedTiles);
  placedTiles.forEach(pt => {
    const lay = layouts[pt.id];
    if (lay) {
      console.log(`Tile [${pt.tile[0]}|${pt.tile[1]}] (${pt.id}): x=${lay.gridX}, y=${lay.gridY}, rot=${lay.rotation}`);
    } else {
      console.log(`Tile ${pt.id} has no layout!`);
    }
  });
} catch (e: any) {
  console.error("Error:", e.message);
}
