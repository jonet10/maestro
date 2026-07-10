import { dealDominoes, getOpenEnds2D, evaluatePlayability2D, getPlayedTileRotation2D } from '../src/utils/dominoLogic';
import * as ScoreEngine from '../src/utils/scoreEngine';
import { PlacedTile, Tile } from '../src/types';

console.log("=========================================================");
console.log("RUNNING 100 ROUND SIMULATION FOR SCORING VALIDATION");
console.log("=========================================================");

let totalMoves = 0;
let totalMatches = 0;
let totalMismatches = 0;

for (let gameIdx = 1; gameIdx <= 100; gameIdx++) {
  // Deal hands
  let { userHand, aiHand } = dealDominoes();
  let placedTiles: PlacedTile[] = [];
  let turn: 'user' | 'ai' = 'user';
  let passesInARow = 0;

  while (userHand.length > 0 && aiHand.length > 0 && passesInARow < 2) {
    const currentHand = turn === 'user' ? userHand : aiHand;
    const openEnds = ScoreEngine.calculateOpenEnds(placedTiles);
    const openEnds2D = getOpenEnds2D(placedTiles);

    // Find playable moves
    const playableOptions: { tile: Tile; side: 'left' | 'right' | 'top' | 'bottom' }[] = [];
    currentHand.forEach(tile => {
      const play = evaluatePlayability2D(tile, openEnds2D);
      if (placedTiles.length === 0) {
        playableOptions.push({ tile, side: 'start' });
      } else {
        if (play.left) playableOptions.push({ tile, side: 'left' });
        if (play.right) playableOptions.push({ tile, side: 'right' });
        if (play.top) playableOptions.push({ tile, side: 'top' });
        if (play.bottom) playableOptions.push({ tile, side: 'bottom' });
      }
    });

    if (playableOptions.length === 0) {
      passesInARow++;
      turn = turn === 'user' ? 'ai' : 'user';
      continue;
    }

    passesInARow = 0;
    // Pick a random playable move
    const choice = playableOptions[Math.floor(Math.random() * playableOptions.length)];
    const { tile, side } = choice;

    // Remove from hand
    if (turn === 'user') {
      userHand = userHand.filter(t => !(t[0] === tile[0] && t[1] === tile[1]));
    } else {
      aiHand = aiHand.filter(t => !(t[0] === tile[0] && t[1] === tile[1]));
    }

    // Play tile
    const rotation = getPlayedTileRotation2D(tile, side, openEnds2D);
    const newPlaced: PlacedTile = {
      id: `tile-${placedTiles.length}`,
      tile,
      connectedAs: rotation,
      isDouble: tile[0] === tile[1],
      playedAt: side,
    };

    placedTiles.push(newPlaced);
    totalMoves++;

    // Calculate sum using both engines
    const legacySum = calculateAllFivesSum2D_Legacy(placedTiles);
    const newSum = ScoreEngine.calculateBoardScore(placedTiles);

    const legacyPoints = legacySum > 0 && legacySum % 5 === 0 ? legacySum : 0;
    const newPoints = newSum > 0 && newSum % 5 === 0 ? newSum : 0;

    if (legacyPoints === newPoints) {
      totalMatches++;
    } else {
      totalMismatches++;
      console.log(`\n[MISMATCH] Game ${gameIdx}, Move ${placedTiles.length}`);
      console.log(`Play: ${turn} played [${tile[0]}|${tile[1]}] on ${side}`);
      console.log(`Legacy Sum: ${legacySum} (Points: ${legacyPoints})`);
      console.log(`New Sum: ${newSum} (Points: ${newPoints})`);
      console.log("Current Open Ends:", ScoreEngine.calculateOpenEnds(placedTiles));
      console.log("Board Layout:", placedTiles.map(pt => `${pt.playedAt}: [${pt.tile[0]}|${pt.tile[1]}]`));
    }

    turn = turn === 'user' ? 'ai' : 'user';
  }
}

console.log("\n=========================================================");
console.log(`SIMULATION COMPLETED`);
console.log(`Total Moves Simulated: ${totalMoves}`);
console.log(`Matches: ${totalMatches}`);
console.log(`Mismatches (legacy bugs detected): ${totalMismatches}`);
console.log("=========================================================");

// Replicate legacy scoring logic for comparison
function calculateAllFivesSum2D_Legacy(placedTiles: PlacedTile[]): number {
  if (placedTiles.length === 0) return 0;
  
  if (placedTiles.length === 1) {
    const tile = placedTiles[0].tile;
    return tile[0] + tile[1];
  }

  const startTile = placedTiles.find(pt => pt.playedAt === "start");
  if (!startTile) return 0;

  const leftBranch = placedTiles.filter(pt => pt.playedAt === "left");
  const rightBranch = placedTiles.filter(pt => pt.playedAt === "right");
  const topBranch = placedTiles.filter(pt => pt.playedAt === "top");
  const bottomBranch = placedTiles.filter(pt => pt.playedAt === "bottom");

  const openEnds = getOpenEnds2D(placedTiles);

  let sum = 0;

  // Left extreme:
  if (leftBranch.length > 0) {
    const last = leftBranch[leftBranch.length - 1];
    sum += last.isDouble ? (last.tile[0] + last.tile[1]) : openEnds.left!;
  } else {
    sum += startTile.isDouble ? (startTile.tile[0] + startTile.tile[1]) : openEnds.left!;
  }

  // Right extreme:
  if (rightBranch.length > 0) {
    const last = rightBranch[rightBranch.length - 1];
    sum += last.isDouble ? (last.tile[0] + last.tile[1]) : openEnds.right!;
  } else {
    sum += startTile.isDouble ? (startTile.tile[0] + startTile.tile[1]) : openEnds.right!;
  }

  // Top extreme:
  if (openEnds.top !== null) {
    if (topBranch.length > 0) {
      const last = topBranch[topBranch.length - 1];
      sum += last.isDouble ? (last.tile[0] + last.tile[1]) : openEnds.top;
    } else {
      sum += openEnds.top;
    }
  }

  // Bottom extreme:
  if (openEnds.bottom !== null) {
    if (bottomBranch.length > 0) {
      const last = bottomBranch[bottomBranch.length - 1];
      sum += last.isDouble ? (last.tile[0] + last.tile[1]) : openEnds.bottom;
    } else {
      sum += openEnds.bottom;
    }
  }

  return sum;
}
