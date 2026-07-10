import { computeTileLayouts, PlacedTile } from "../src/utils/dominoLogic";

const placedTiles: PlacedTile[] = [
  {
    id: "start_tile",
    tile: [6, 1],
    connectedAs: [6, 1], // horizontal
    isDouble: false,
    playedAt: "start"
  },
  {
    id: "right_1",
    tile: [1, 1],
    connectedAs: [1, 1], // vertical double
    isDouble: true,
    playedAt: "right"
  },
  {
    id: "right_2",
    tile: [1, 3],
    connectedAs: [1, 3], // vertical 1:3?
    isDouble: false,
    playedAt: "right"
  },
  {
    id: "right_3",
    tile: [3, 6],
    connectedAs: [3, 6], // vertical 3:6
    isDouble: false,
    playedAt: "right"
  }
];

console.log("=== Case C (Start tile is 6:1) ===");
const layouts = computeTileLayouts(placedTiles);
placedTiles.forEach(t => {
  const lay = layouts[t.id];
  console.log(`Tile ${t.tile[0]}:${t.tile[1]} (playedAt: ${t.playedAt}):`, lay);
});
