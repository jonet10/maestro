import { computeTileLayouts, PlacedTile } from "../src/utils/dominoLogic";

const cases = [
  // 1. start = 1:1, left = 6:1, right = 1:3, right = 3:6
  {
    name: "1:1 start, 6:1 left, 1:3 right, 3:6 right",
    tiles: [
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "start" },
      { id: "6:1", tile: [6, 1], connectedAs: [1, 6], isDouble: false, playedAt: "left" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "right" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "right" }
    ]
  },
  // 2. start = 1:1, left = 6:1, bottom = 1:3, bottom = 3:6
  {
    name: "1:1 start, 6:1 left, 1:3 bottom, 3:6 bottom",
    tiles: [
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "start" },
      { id: "6:1", tile: [6, 1], connectedAs: [1, 6], isDouble: false, playedAt: "left" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "bottom" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "bottom" }
    ]
  },
  // 3. start = 1:1, left = 6:1, top = 1:3, top = 3:6
  {
    name: "1:1 start, 6:1 left, 1:3 top, 3:6 top",
    tiles: [
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "start" },
      { id: "6:1", tile: [6, 1], connectedAs: [1, 6], isDouble: false, playedAt: "left" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "top" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "top" }
    ]
  },
  // 4. start = 6:1, right = 1:1, right = 1:3, right = 3:6
  {
    name: "6:1 start, 1:1 right, 1:3 right, 3:6 right",
    tiles: [
      { id: "6:1", tile: [6, 1], connectedAs: [6, 1], isDouble: false, playedAt: "start" },
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "right" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "right" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "right" }
    ]
  },
  // 5. start = 6:1, right = 1:1, bottom = 1:3, bottom = 3:6
  {
    name: "6:1 start, 1:1 right, 1:3 bottom, 3:6 bottom",
    tiles: [
      { id: "6:1", tile: [6, 1], connectedAs: [6, 1], isDouble: false, playedAt: "start" },
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "right" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "bottom" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "bottom" }
    ]
  },
  // 6. start = 6:1, right = 1:1, top = 1:3, top = 3:6
  {
    name: "6:1 start, 1:1 right, 1:3 top, 3:6 top",
    tiles: [
      { id: "6:1", tile: [6, 1], connectedAs: [6, 1], isDouble: false, playedAt: "start" },
      { id: "1:1", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "right" },
      { id: "1:3", tile: [1, 3], connectedAs: [1, 3], isDouble: false, playedAt: "top" },
      { id: "3:6", tile: [3, 6], connectedAs: [3, 6], isDouble: false, playedAt: "top" }
    ]
  }
];

cases.forEach(c => {
  console.log(`\n=== CASE: ${c.name} ===`);
  const layouts = computeTileLayouts(c.tiles as PlacedTile[]);
  c.tiles.forEach(t => {
    const lay = layouts[t.id];
    console.log(`  Tile ${t.id}: gridX=${lay?.gridX}, gridY=${lay?.gridY}, rotation=${lay?.rotation} (${lay?.rotation === 0 || lay?.rotation === 180 ? 'vertical' : 'horizontal'})`);
  });
});
