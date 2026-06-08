import { Tile, BoardTile } from './types';
import { tileValue } from './tileUtils';

export const calculateHandValue = (hand: Tile[]): number => {
  return hand.reduce((sum, tile) => sum + tileValue(tile), 0);
};

export const checkBlockWinner = (p1Hand: Tile[], p2Hand: Tile[]): { winner: 'p1' | 'p2' | 'tie', p1Value: number, p2Value: number } => {
  const p1Value = calculateHandValue(p1Hand);
  const p2Value = calculateHandValue(p2Hand);

  if (p1Value < p2Value) return { winner: 'p1', p1Value, p2Value };
  if (p2Value < p1Value) return { winner: 'p2', p1Value, p2Value };
  return { winner: 'tie', p1Value, p2Value };
};

export const calculateRoundScore = (winnerHand: Tile[], loserHand: Tile[]): number => {
  return calculateHandValue(loserHand);
};

const nearestMultipleOfFive = (value: number): number => {
  const lower = Math.floor(value / 5) * 5;
  const upper = lower + 5;
  return value - lower <= upper - value ? lower : upper;
};

const getExposedLeft = (tile: BoardTile): number => {
  const oriented = tile.orientedTile ?? tile.tile;
  const isDouble = oriented[0] === oriented[1];
  return isDouble ? oriented[0] + oriented[1] : oriented[0];
};

const getExposedRight = (tile: BoardTile): number => {
  const oriented = tile.orientedTile ?? tile.tile;
  const isDouble = oriented[0] === oriented[1];
  return isDouble ? oriented[0] + oriented[1] : oriented[1];
};

export const calculateFivesScore = (board: BoardTile[]): number => {
  if (board.length === 0) return 0;

  const spinner = board.find((bt) => bt.isSpinner);

  // Without a spinner: only 2 open ends (classic left/right)
  if (!spinner) {
    const mainChain = board.filter((bt) => bt.side !== 'up' && bt.side !== 'down');
    const total =
      getExposedLeft(mainChain[0]) + getExposedRight(mainChain[mainChain.length - 1]);
    return total % 5 === 0 ? total : 0;
  }

  // With spinner: up to 4 open ends
  const mainChain = board.filter((bt) => bt.side !== 'up' && bt.side !== 'down');
  const upChain = board.filter((bt) => bt.side === 'up');
  const downChain = board.filter((bt) => bt.side === 'down');

  const spinnerVal = spinner.tile[0]; // both halves equal for a double

  let total = 0;

  // Left end of main chain
  total += getExposedLeft(mainChain[0]);

  // Right end of main chain
  total += getExposedRight(mainChain[mainChain.length - 1]);

  // Up branch: if no tile yet, the spinner end is still open → add spinnerVal
  // If tiles are there, the tip is exposed
  if (upChain.length === 0) {
    total += spinnerVal;
  } else {
    total += getExposedLeft(upChain[upChain.length - 1]);
  }

  // Down branch: same logic
  if (downChain.length === 0) {
    total += spinnerVal;
  } else {
    total += getExposedLeft(downChain[downChain.length - 1]);
  }

  return total % 5 === 0 ? total : 0;
};

export const calculateFivesRoundEndScore = (opponentHands: Tile[][]): number => {
  const total = opponentHands.flat().reduce((sum, t) => sum + tileValue(t), 0);
  return nearestMultipleOfFive(total);
};

export const isCapot = (winnerHand: Tile[], loserHand: Tile[]): boolean => {
  return loserHand.length === 7 && winnerHand.length === 0;
};

export const calculateCapotScore = (loserHand: Tile[]): number => {
  return calculateHandValue(loserHand) * 2;
};

export const calculateBlockEndScore = (p1Hand: Tile[], p2Hand: Tile[]): { winnerId: 'p1' | 'p2' | 'tie', points: number } => {
  const p1Value = calculateHandValue(p1Hand);
  const p2Value = calculateHandValue(p2Hand);
  const diff = Math.abs(p1Value - p2Value);

  if (p1Value < p2Value) {
    const capot = p2Hand.length === 7 && p1Hand.length === 0;
    return { winnerId: 'p1', points: capot ? diff * 2 : diff };
  }
  if (p2Value < p1Value) {
    const capot = p1Hand.length === 7 && p2Hand.length === 0;
    return { winnerId: 'p2', points: capot ? diff * 2 : diff };
  }
  return { winnerId: 'tie', points: 0 };
};
