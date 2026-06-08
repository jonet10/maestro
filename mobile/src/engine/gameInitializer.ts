import { EngineGameState, GameMode, PlayerId, Tile } from './types';
import { generateTileSet, shuffleTiles, tileValue } from './tileUtils';
import { getTargetScore } from './dominoRules';

const highestDoubleValue = (hand: Tile[]): number => {
  let max = -1;
  for (const [a, b] of hand) {
    if (a === b && a > max) max = a;
  }
  return max;
};

const highestTileValue = (hand: Tile[]): number => {
  return hand.reduce((max, t) => Math.max(max, tileValue(t)), -1);
};

const determineStartingPlayer = (
  player1Id: PlayerId,
  player2Id: PlayerId,
  p1Hand: Tile[],
  p2Hand: Tile[],
): PlayerId => {
  const p1Double = highestDoubleValue(p1Hand);
  const p2Double = highestDoubleValue(p2Hand);
  if (p1Double !== p2Double) return p1Double > p2Double ? player1Id : player2Id;

  const p1High = highestTileValue(p1Hand);
  const p2High = highestTileValue(p2Hand);
  if (p1High !== p2High) return p1High > p2High ? player1Id : player2Id;

  return player1Id;
};

export const initializeGame = (
  matchId: string, 
  player1Id: PlayerId, 
  player2Id: PlayerId, 
  seed?: number,
  gameMode: GameMode = 'fives',
): EngineGameState => {
  const deck = shuffleTiles(generateTileSet(), seed);
  
  // Deal 7 tiles to each player
  const p1Hand = deck.slice(0, 7);
  const p2Hand = deck.slice(7, 14);
  const boneyard = deck.slice(14);

  const currentTurn = determineStartingPlayer(player1Id, player2Id, p1Hand, p2Hand);
  
  return {
    id: `game_${Date.now()}`,
    match_id: matchId,
    board_state: [],
    player1_id: player1Id,
    player2_id: player2Id,
    player1_hand: p1Hand,
    player2_hand: p2Hand,
    boneyard: boneyard,
    current_turn: currentTurn,
    round_number: 1,
    player1_score: 0,
    player2_score: 0,
    game_mode: gameMode,
    target_score: getTargetScore(gameMode),
    last_player_id: null,
    match_status: 'in_progress',
    last_action_timestamp: Date.now(),
    consecutive_passes: 0,
  };
};
