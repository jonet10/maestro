import * as ScoreEngine from "../src/utils/scoreEngine";
import { PlacedTile, Tile } from "../src/types";

console.log("=========================================================");
console.log("RUNNING REGRESSION TEST SUITE (16 MANDATORY CASES)");
console.log("=========================================================");

function assert(condition: boolean, message: string) {
  if (!condition) {
    throw new Error("Assertion Failed: " + message);
  }
}

// Helper to create normal placed tile
function makeTile(id: string, tile: Tile, inner: number, outer: number, playedAt: "left" | "right" | "top" | "bottom" | "start"): PlacedTile {
  return {
    id,
    tile,
    connectedAs: [inner, outer],
    isDouble: tile[0] === tile[1],
    playedAt,
  };
}

// Helper to create double placed tile
function makeDouble(id: string, value: number, playedAt: "left" | "right" | "top" | "bottom" | "start"): PlacedTile {
  return {
    id,
    tile: [value, value],
    connectedAs: [value, value],
    isDouble: true,
    playedAt,
  };
}

// ---------------------------------------------------------------------
// TEST 1 to 7: Original cases
// ---------------------------------------------------------------------

function runTests1to7() {
  console.log("\n--- Running Tests 1 to 7 ---");

  // Cas 1: 2 + 3 = 5 (5 pts)
  // Board: start [2, 3] (connectedAs [2, 3])
  const board1 = [makeTile("start", [2, 3], 2, 3, "start")];
  const ends1 = ScoreEngine.calculateOpenEnds(board1);
  const sum1 = ScoreEngine.calculateBoardScore(board1);
  const points1 = ScoreEngine.calculateMultipleOfFive(sum1);
  console.log("Cas 1 Ends:", ends1, "Sum:", sum1, "Points:", points1);
  assert(sum1 === 5, "Cas 1 Sum should be 5");
  assert(points1 === 5, "Cas 1 Points should be 5");

  // Cas 2: 4 + 6 = 10 (10 pts)
  // Board: start [4, 6]
  const board2 = [makeTile("start", [4, 6], 4, 6, "start")];
  const sum2 = ScoreEngine.calculateBoardScore(board2);
  const points2 = ScoreEngine.calculateMultipleOfFive(sum2);
  console.log("Cas 2 Sum:", sum2, "Points:", points2);
  assert(sum2 === 10, "Cas 2 Sum should be 10");
  assert(points2 === 10, "Cas 2 Points should be 10");

  // Cas 3 & 6: 4 + 4 + 4 = 12 (0 pts)
  // Start: [2, 2] (spinner, left empty, top/bottom empty, so it acts as end double: 2+2=4)
  // Right: [2, 4] -> [4, 4] (end is double-4, which contributes 4+4=8)
  const board3 = [
    makeDouble("start", 2, "start"),
    makeTile("r1", [2, 4], 2, 4, "right"),
    makeDouble("r2", 4, "right")
  ];
  const ends3 = ScoreEngine.calculateOpenEnds(board3);
  const sum3 = ScoreEngine.calculateBoardScore(board3);
  const points3 = ScoreEngine.calculateMultipleOfFive(sum3);
  console.log("Cas 3 Ends:", ends3, "Sum:", sum3, "Points:", points3);
  assert(ends3.left === 4, "Cas 3 Left should be 4 (2+2)");
  assert(ends3.right === 8, "Cas 3 Right should be 8 (4+4)");
  assert(sum3 === 12, "Cas 3 Sum should be 12");
  assert(points3 === 0, "Cas 3 Points should be 0");

  // Cas 4: 2 + 5 + 4 + 0 = 11 (0 pts)
  // Start: spinner [2, 2]
  // Left: [2, 2] -> [2, 5] (end 5)
  // Right: [2, 2] -> [2, 0] (end 0)
  // Top: [2, 2] -> [2, 4] (end 4)
  // Bottom: [2, 2] -> [2, 2] (wait, empty? No, 2+5+4+0 implies Left=5, Right=0, Top=4, Bottom=2 (which is the empty bottom side value? Wait, if bottom is active and empty, in legacy it counted, but under Flyclops empty branches do not count, so bottom=null. Wait, if bottom has a tile [2, 2], it counts as 2+2=4. If bottom has tile [2, 0], it counts as 0.)
  // Let's mock the exact values 2, 5, 4, 0.
  // Let's play:
  // Left: [2, 5] (end 5)
  // Right: [2, 0] (end 0)
  // Top: [2, 4] (end 4)
  // Bottom is empty, but wait! If bottom is empty, it doesn't count.
  // Wait, how can we get 2? If bottom has a tile ending in 2, e.g. [2, 2] (is double, so 4), or [2, 2] connected as [2, 2]? No, if it's [2, 2] (not double? no, it is double).
  // What if left has [2, 5] (end 5), right is empty (start right side is 2), top has [2, 4] (end 4), bottom has [2, 0] (end 0)?
  // Let's check: Left=5, Right=2 (start tile side), Top=4, Bottom=0.
  // Sum = 5 + 2 + 4 + 0 = 11.
  const board4 = [
    makeDouble("start", 2, "start"),
    makeTile("l1", [2, 5], 2, 5, "left"),
    makeTile("t1", [2, 4], 2, 4, "top"),
    makeTile("b1", [2, 0], 2, 0, "bottom"),
  ];
  const ends4 = ScoreEngine.calculateOpenEnds(board4);
  const sum4 = ScoreEngine.calculateBoardScore(board4);
  const points4 = ScoreEngine.calculateMultipleOfFive(sum4);
  console.log("Cas 4 Ends:", ends4, "Sum:", sum4, "Points:", points4);
  assert(ends4.left === 5, "Cas 4 Left should be 5");
  assert(ends4.right === 2, "Cas 4 Right should be 2");
  assert(ends4.top === 4, "Cas 4 Top should be 4");
  assert(ends4.bottom === 0, "Cas 4 Bottom should be 0");
  assert(sum4 === 11, "Cas 4 Sum should be 11");
  assert(points4 === 0, "Cas 4 Points should be 0");

  // Cas 5: 3 + 2 + 5 = 10 (10 pts)
  // Start: spinner [3, 3]
  // Left: [3, 3] -> [3, 5] (end 5)
  // Right: [3, 3] -> [3, 2] (end 2)
  // Top: empty (does not count)
  // Bottom: empty (does not count)
  // Wait, how do we get 3? If right branch has [3, 2] (end 2), top branch has [3, 5] (end 5), and left branch is empty (start left side is 3).
  // Sum = 3 (left start side) + 2 (right) + 5 (top) = 10.
  const board5 = [
    makeDouble("start", 3, "start"),
    makeTile("r1", [3, 2], 3, 2, "right"),
    makeTile("t1", [3, 5], 3, 5, "top"),
  ];
  const ends5 = ScoreEngine.calculateOpenEnds(board5);
  const sum5 = ScoreEngine.calculateBoardScore(board5);
  const points5 = ScoreEngine.calculateMultipleOfFive(sum5);
  console.log("Cas 5 Ends:", ends5, "Sum:", sum5, "Points:", points5);
  assert(ends5.left === 3, "Cas 5 Left should be 3");
  assert(ends5.right === 2, "Cas 5 Right should be 2");
  assert(ends5.top === 5, "Cas 5 Top should be 5");
  assert(ends5.bottom === null, "Cas 5 Bottom should be null");
  assert(sum5 === 10, "Cas 5 Sum should be 10");
  assert(points5 === 10, "Cas 5 Points should be 10");

  // Cas 7: Spinner with 4 branches (spinner does not count as extra points)
  // Start: spinner [3, 3]
  // Left: [3, 1] (end 1)
  // Right: [3, 2] (end 2)
  // Top: [3, 4] (end 4)
  // Bottom: [3, 5] (end 5)
  // Open ends: 1, 2, 4, 5. Sum = 1 + 2 + 4 + 5 = 12. Spinner [3, 3] is in the middle, closed.
  const board7 = [
    makeDouble("start", 3, "start"),
    makeTile("l1", [3, 1], 3, 1, "left"),
    makeTile("r1", [3, 2], 3, 2, "right"),
    makeTile("t1", [3, 4], 3, 4, "top"),
    makeTile("b1", [3, 5], 3, 5, "bottom"),
  ];
  const ends7 = ScoreEngine.calculateOpenEnds(board7);
  const sum7 = ScoreEngine.calculateBoardScore(board7);
  console.log("Cas 7 Ends:", ends7, "Sum:", sum7);
  assert(ends7.left === 1, "Cas 7 Left should be 1");
  assert(ends7.right === 2, "Cas 7 Right should be 2");
  assert(ends7.top === 4, "Cas 7 Top should be 4");
  assert(ends7.bottom === 5, "Cas 7 Bottom should be 5");
  assert(sum7 === 12, "Cas 7 Sum should be 12");
}

// ---------------------------------------------------------------------
// TEST 8: Only one double tile on board [5|5]
// ---------------------------------------------------------------------
function runTest8() {
  console.log("\n--- Running Test 8: Single Double ---");
  const board = [makeDouble("start", 5, "start")];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  const points = ScoreEngine.calculateMultipleOfFive(sum);
  console.log("Ends:", ends, "Sum:", sum, "Points:", points);
  assert(ends.left === 5, "Left should be 5");
  assert(ends.right === 5, "Right should be 5");
  assert(ends.top === null, "Top should be null");
  assert(ends.bottom === null, "Bottom should be null");
  assert(sum === 10, "Total sum should be 10");
  assert(points === 10, "Award should be 10");
}

// ---------------------------------------------------------------------
// TEST 9: Only one normal domino [5|3]
// ---------------------------------------------------------------------
function runTest9() {
  console.log("\n--- Running Test 9: Single Normal Domino ---");
  const board = [makeTile("start", [5, 3], 5, 3, "start")];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  const points = ScoreEngine.calculateMultipleOfFive(sum);
  console.log("Ends:", ends, "Sum:", sum, "Points:", points);
  assert(ends.left === 5, "Left should be 5");
  assert(ends.right === 3, "Right should be 3");
  assert(ends.top === null, "Top should be null");
  assert(ends.bottom === null, "Bottom should be null");
  assert(sum === 8, "Total sum should be 8");
  assert(points === 0, "Award should be 0");
}

// ---------------------------------------------------------------------
// TEST 10: Spinner connected left and right. Top/Bottom branch empty.
// ---------------------------------------------------------------------
function runTest10() {
  console.log("\n--- Running Test 10: Spinner mainline only, Top/Bottom empty ---");
  const board = [
    makeDouble("start", 6, "start"),
    makeTile("l1", [6, 4], 6, 4, "left"),
    makeTile("r1", [6, 3], 6, 3, "right"),
  ];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  console.log("Ends:", ends, "Sum:", sum);
  assert(ends.left === 4, "Left should be 4");
  assert(ends.right === 3, "Right should be 3");
  assert(ends.top === null, "Top should be null (empty branch does not score)");
  assert(ends.bottom === null, "Bottom should be null (empty branch does not score)");
  assert(sum === 7, "Sum should be 7");
}

// ---------------------------------------------------------------------
// TEST 11: Spinner, one tile played on TOP. Bottom empty.
// ---------------------------------------------------------------------
function runTest11() {
  console.log("\n--- Running Test 11: Spinner, Top has tile, Bottom empty ---");
  const board = [
    makeDouble("start", 6, "start"),
    makeTile("l1", [6, 4], 6, 4, "left"),
    makeTile("r1", [6, 3], 6, 3, "right"),
    makeTile("t1", [6, 2], 6, 2, "top"),
  ];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  console.log("Ends:", ends, "Sum:", sum);
  assert(ends.left === 4, "Left should be 4");
  assert(ends.right === 3, "Right should be 3");
  assert(ends.top === 2, "Top should be 2");
  assert(ends.bottom === null, "Bottom should be null");
  assert(sum === 9, "Sum should be 9");
}

// ---------------------------------------------------------------------
// TEST 12: Spinner, four complete branches
// ---------------------------------------------------------------------
function runTest12() {
  console.log("\n--- Running Test 12: Spinner, four active branches ---");
  const board = [
    makeDouble("start", 6, "start"),
    makeTile("l1", [6, 4], 6, 4, "left"),
    makeTile("r1", [6, 3], 6, 3, "right"),
    makeTile("t1", [6, 2], 6, 2, "top"),
    makeTile("b1", [6, 1], 6, 1, "bottom"),
  ];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  console.log("Ends:", ends, "Sum:", sum);
  assert(ends.left === 4, "Left should be 4");
  assert(ends.right === 3, "Right should be 3");
  assert(ends.top === 2, "Top should be 2");
  assert(ends.bottom === 1, "Bottom should be 1");
  assert(sum === 10, "Sum should be 10");
}

// ---------------------------------------------------------------------
// TEST 13: Blocked game
// ---------------------------------------------------------------------
function runTest13() {
  console.log("\n--- Running Test 13: Blocked Game ---");
  // Board: start [4, 4], left [4, 3], right [4, 2]
  // Ends: 3 and 2. Sum = 5.
  const board = [
    makeDouble("start", 4, "start"),
    makeTile("l1", [4, 3], 4, 3, "left"),
    makeTile("r1", [4, 2], 4, 2, "right"),
  ];
  const ends = ScoreEngine.calculateOpenEnds(board);
  const sum = ScoreEngine.calculateBoardScore(board);
  console.log("Ends:", ends, "Sum:", sum);
  assert(ends.left === 3, "Left should be 3");
  assert(ends.right === 2, "Right should be 2");
  assert(sum === 5, "Sum should be 5");
}

// ---------------------------------------------------------------------
// TEST 14: End of round (Domino)
// ---------------------------------------------------------------------
function runTest14() {
  console.log("\n--- Running Test 14: End of Round (Domino) ---");
  
  const userHand: Tile[] = []; // Winner, went domino
  const aiHand: Tile[] = [[1, 2], [3, 4]]; // Remaining pips: 1+2+3+4 = 10
  
  const pipsSum = ScoreEngine.calculateRemainingTiles(aiHand);
  const scoreGained = ScoreEngine.roundToNearestFive(pipsSum);
  
  console.log("AI hand remaining tiles pips sum:", pipsSum);
  console.log("Score gained (rounded to nearest 5):", scoreGained);
  
  assert(pipsSum === 10, "Pips sum should be 10");
  assert(scoreGained === 10, "Rounded score should be 10");

  const aiHand2: Tile[] = [[1, 2], [3, 3]]; // Pips: 1+2+3+3 = 9
  const pipsSum2 = ScoreEngine.calculateRemainingTiles(aiHand2);
  const scoreGained2 = ScoreEngine.roundToNearestFive(pipsSum2);
  console.log("AI hand remaining pips:", pipsSum2, "Rounded:", scoreGained2);
  assert(pipsSum2 === 9, "Pips sum should be 9");
  assert(scoreGained2 === 10, "9 should round to 10");

  const aiHand3: Tile[] = [[1, 1]]; // Pips: 2
  const pipsSum3 = ScoreEngine.calculateRemainingTiles(aiHand3);
  const scoreGained3 = ScoreEngine.roundToNearestFive(pipsSum3);
  console.log("AI hand remaining pips:", pipsSum3, "Rounded:", scoreGained3);
  assert(pipsSum3 === 2, "Pips sum should be 2");
  assert(scoreGained3 === 0, "2 should round to 0");
}

// ---------------------------------------------------------------------
// TEST 15 & 16: Play entire game simulations
// ---------------------------------------------------------------------
function simulateEntireGame(targetScore: number) {
  console.log(`\n--- Simulating Entire Game to target ${targetScore} ---`);
  let scoreUser = 0;
  let scoreAi = 0;
  let round = 1;

  while (!ScoreEngine.checkVictory(scoreUser, targetScore) && !ScoreEngine.checkVictory(scoreAi, targetScore)) {
    console.log(`Round ${round} Starts | User: ${scoreUser} | AI: ${scoreAi}`);
    // Simulate some scores during the round
    scoreUser = ScoreEngine.addPlayerScore(scoreUser, 15);
    if (ScoreEngine.checkVictory(scoreUser, targetScore)) break;

    scoreAi = ScoreEngine.addPlayerScore(scoreAi, 10);
    if (ScoreEngine.checkVictory(scoreAi, targetScore)) break;

    // Simulate round end points
    scoreUser = ScoreEngine.addPlayerScore(scoreUser, ScoreEngine.roundToNearestFive(12)); // adds 10
    round++;
  }

  const userWon = ScoreEngine.checkVictory(scoreUser, targetScore);
  const aiWon = ScoreEngine.checkVictory(scoreAi, targetScore);
  
  console.log(`Game Finished! User: ${scoreUser} | AI: ${scoreAi} | Winner User? ${userWon} | Winner AI? ${aiWon}`);
  assert(userWon || aiWon, "At least one player must have won");
  assert(!(userWon && aiWon), "Only one player can win");
  assert(scoreUser >= targetScore || scoreAi >= targetScore, "Winning score must be >= target");
}

function runTests15and16() {
  simulateEntireGame(50);
  simulateEntireGame(100);
  simulateEntireGame(150);
  simulateEntireGame(200);
}

function runNewScoringTests() {
  console.log("\n--- Running New Scoring Tests (End doubles, Spinner doubles, Multiple branches, Standard linear chains) ---");

  // 1. End doubles test
  // Board: start [2, 3] (not double), left [2, 4] -> [4, 4] (end double), right [3, 5]
  // Expected: left = 4+4=8, right = 5. Total = 13.
  const boardEndDouble = [
    makeTile("start", [2, 3], 2, 3, "start"),
    makeTile("l1", [2, 4], 2, 4, "left"),
    makeDouble("l2", 4, "left"),
    makeTile("r1", [3, 5], 3, 5, "right")
  ];
  const endsEndDouble = ScoreEngine.calculateOpenEnds(boardEndDouble);
  const sumEndDouble = ScoreEngine.calculateBoardScore(boardEndDouble);
  console.log("End Double Test Ends:", endsEndDouble, "Sum:", sumEndDouble);
  assert(endsEndDouble.left === 8, "End Double: left should be 8 (4+4)");
  assert(endsEndDouble.right === 5, "End Double: right should be 5");
  assert(sumEndDouble === 13, "End Double: sum should be 13");

  // 2. Spinner doubles as end of chain
  // Board: [1|1] (start/spinner) - [1|4] (right) - [4|4] (right) (left branch empty)
  // Expected: left = 1+1=2, right = 4+4=8. Total = 10.
  const boardSpinnerEnd = [
    makeDouble("start", 1, "start"),
    makeTile("r1", [1, 4], 1, 4, "right"),
    makeDouble("r2", 4, "right")
  ];
  const endsSpinnerEnd = ScoreEngine.calculateOpenEnds(boardSpinnerEnd);
  const sumSpinnerEnd = ScoreEngine.calculateBoardScore(boardSpinnerEnd);
  console.log("Spinner End Test Ends:", endsSpinnerEnd, "Sum:", sumSpinnerEnd);
  assert(endsSpinnerEnd.left === 2, "Spinner End: left should be 2 (1+1)");
  assert(endsSpinnerEnd.right === 8, "Spinner End: right should be 8 (4+4)");
  assert(sumSpinnerEnd === 10, "Spinner End: sum should be 10");

  // 3. Multiple branches test
  // Board: start [3, 3] (spinner), left [3, 5], right [3, 4], top [3, 3] (double), bottom [3, 0]
  // Expected: left = 5, right = 4, top = 6, bottom = 0. Total = 15.
  const boardMultipleBranches = [
    makeDouble("start", 3, "start"),
    makeTile("l1", [3, 5], 3, 5, "left"),
    makeTile("r1", [3, 4], 3, 4, "right"),
    makeDouble("t1", 3, "top"),
    makeTile("b1", [3, 0], 3, 0, "bottom")
  ];
  const endsMultipleBranches = ScoreEngine.calculateOpenEnds(boardMultipleBranches);
  const sumMultipleBranches = ScoreEngine.calculateBoardScore(boardMultipleBranches);
  console.log("Multiple Branches Ends:", endsMultipleBranches, "Sum:", sumMultipleBranches);
  assert(endsMultipleBranches.left === 5, "Multiple Branches: left should be 5");
  assert(endsMultipleBranches.right === 4, "Multiple Branches: right should be 4");
  assert(endsMultipleBranches.top === 6, "Multiple Branches: top should be 6 (3+3)");
  assert(endsMultipleBranches.bottom === 0, "Multiple Branches: bottom should be 0");
  assert(sumMultipleBranches === 15, "Multiple Branches: sum should be 15");

  // 4. Standard linear chains
  // Board: start [2, 3], left [2, 5], right [3, 4]
  // Expected: left = 5, right = 4. Total = 9.
  const boardLinear = [
    makeTile("start", [2, 3], 2, 3, "start"),
    makeTile("l1", [2, 5], 2, 5, "left"),
    makeTile("r1", [3, 4], 3, 4, "right")
  ];
  const endsLinear = ScoreEngine.calculateOpenEnds(boardLinear);
  const sumLinear = ScoreEngine.calculateBoardScore(boardLinear);
  console.log("Linear Chain Ends:", endsLinear, "Sum:", sumLinear);
  assert(endsLinear.left === 5, "Linear: left should be 5");
  assert(endsLinear.right === 4, "Linear: right should be 4");
  assert(sumLinear === 9, "Linear: sum should be 9");
}

try {
  runTests1to7();
  runTest8();
  runTest9();
  runTest10();
  runTest11();
  runTest12();
  runTest13();
  runTest14();
  runNewScoringTests();
  runTests15and16();
  console.log("\n=========================================================");
  console.log("ALL REGRESSION & NEW SCORING TESTS PASSED SUCCESSFULLY! ✅");
  console.log("=========================================================");
} catch (e: any) {
  console.error("❌ TEST FAILURE:", e.message);
  process.exit(1);
}
