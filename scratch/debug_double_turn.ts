import { computeTileLayouts, PlacedTile, getBoundingBox, intersectBoxes } from "../src/utils/dominoLogic";

const placedTiles: PlacedTile[] = [
  { id: "start", tile: [5, 5], connectedAs: [5, 5], isDouble: true, playedAt: "start" },
  { id: "l1", tile: [5, 2], connectedAs: [5, 2], isDouble: false, playedAt: "left" },
  { id: "l2", tile: [2, 1], connectedAs: [2, 1], isDouble: false, playedAt: "left" },
  { id: "l3", tile: [1, 1], connectedAs: [1, 1], isDouble: true, playedAt: "left" },
  { id: "l4", tile: [1, 4], connectedAs: [1, 4], isDouble: false, playedAt: "left" }
];

console.log("=== Bounding Boxes of Placed Tiles ===");
const layouts = computeTileLayouts(placedTiles);
placedTiles.forEach(t => {
  const lay = layouts[t.id];
  const box = getBoundingBox(lay.gridX, lay.gridY, lay.rotation);
  console.log(`Tile ${t.tile[0]}:${t.tile[1]} (${t.id}): x=${lay?.gridX}, y=${lay?.gridY}, rot=${lay?.rotation} | box: minX=${box.minX}, maxX=${box.maxX}, minY=${box.minY}, maxY=${box.maxY}`);
});

// Let's test collision manually
const l3_box = getBoundingBox(-5.0, 0.0, 0); // l3 is at x=-5, y=0, rot=0
const l4_left_box = getBoundingBox(-6.5, 0.0, 90); // if l4 went left, center is at x=-6.5, y=0, rot=90
const l4_down_box = getBoundingBox(-6.0, -0.5, 0); // l4 went up/down (turns up since left branch turns up now)

console.log("Collision l4(left) with l3 (epsilon=0.05):", intersectBoxes(l4_left_box, l3_box, 0.05));
console.log("Collision l4(left) with l2 (epsilon=-0.25):", intersectBoxes(l4_left_box, getBoundingBox(-3.5, 0, 90), -0.25));


