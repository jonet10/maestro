import { RoomManager } from './RoomManager';
import {
  BoardSide,
  BoardTile,
  DrawTileResult,
  PlayTileResult,
  Player,
  Room,
  Tile,
} from './types';

/**
 * DominoGame contains the complete in-memory rules engine.
 * It mutates the RoomManager rooms directly and does not touch MySQL.
 */
export class DominoGame {
  constructor(private readonly roomManager: RoomManager) {}

  generateTiles(): Tile[] {
    const tiles: Tile[] = [];

    for (let left = 0; left <= 6; left += 1) {
      for (let right = left; right <= 6; right += 1) {
        tiles.push([left, right]);
      }
    }

    return tiles;
  }

  distributeTiles(players: Player[]): { players: Player[]; boneyard: Tile[] } {
    const shuffledTiles = this.shuffle(this.generateTiles());
    const tilesPerPlayer = 7;

    players.forEach((player, index) => {
      const start = index * tilesPerPlayer;
      player.hand = shuffledTiles.slice(start, start + tilesPerPlayer);
    });

    return {
      players,
      boneyard: shuffledTiles.slice(players.length * tilesPerPlayer),
    };
  }

  validateMove(tile: Tile, boardEnd: number): boolean {
    return tile[0] === boardEnd || tile[1] === boardEnd;
  }

  startGame(roomId: string): Room {
    const room = this.roomManager.getRoomOrThrow(roomId);

    if (room.status !== 'waiting') {
      throw new Error('La partie ne peut etre demarree que depuis une room en attente.');
    }

    if (room.players.length < 2) {
      throw new Error('Au moins deux joueurs sont requis.');
    }

    const distribution = this.distributeTiles(room.players);
    room.players = distribution.players;
    room.status = 'playing';
    room.gameState = {
      board: [],
      boneyard: distribution.boneyard,
      currentTurnIndex: this.findStartingPlayerIndex(room.players),
      startedAt: new Date().toISOString(),
      endedAt: null,
      winnerId: null,
      scores: Object.fromEntries(room.players.map((player) => [player.id, player.score])),
    };

    return room;
  }

  playTile(roomId: string, playerId: string, tile: Tile, side: BoardSide): PlayTileResult {
    const room = this.roomManager.getRoomOrThrow(roomId);
    const playerIndex = this.getActivePlayerIndex(room, playerId);
    const player = room.players[playerIndex];

    if (room.status !== 'playing') {
      throw new Error('Aucune partie active dans cette room.');
    }

    if (room.gameState.currentTurnIndex !== playerIndex) {
      throw new Error("Ce n'est pas le tour de ce joueur.");
    }

    const handTileIndex = this.findTileIndex(player.hand, tile);
    if (handTileIndex === -1) {
      throw new Error("Cette tuile n'est pas dans la main du joueur.");
    }

    const boardSide = room.gameState.board.length === 0 ? 'first' : side;
    const boardEnd = this.getBoardEnd(room.gameState.board, side);

    if (boardEnd !== null && !this.validateMove(tile, boardEnd)) {
      throw new Error("Coup invalide: la tuile ne correspond pas a l'extremite choisie.");
    }

    const playedTile = player.hand.splice(handTileIndex, 1)[0];
    room.gameState.board = this.placeTile(room.gameState.board, playedTile, side);

    const winner = this.checkWinner(roomId);
    if (!winner) {
      this.nextTurn(roomId);
    }

    return {
      room,
      player,
      tile: playedTile,
      side: boardSide,
      scores: room.gameState.scores,
      winner,
    };
  }

  drawTile(roomId: string, playerId: string): DrawTileResult {
    const room = this.roomManager.getRoomOrThrow(roomId);
    const playerIndex = this.getActivePlayerIndex(room, playerId);
    const player = room.players[playerIndex];

    if (room.status !== 'playing') {
      throw new Error('Aucune partie active dans cette room.');
    }

    if (room.gameState.currentTurnIndex !== playerIndex) {
      throw new Error("Ce n'est pas le tour de ce joueur.");
    }

    const tile = room.gameState.boneyard.shift() ?? null;
    if (tile) {
      player.hand.push(tile);
    }

    return { room, player, tile };
  }

  checkWinner(roomId: string): Player | null {
    const room = this.roomManager.getRoomOrThrow(roomId);
    const winner = room.players.find((player) => player.hand.length === 0) ?? null;

    if (!winner) {
      return null;
    }

    const roundScore = room.players
      .filter((player) => player.id !== winner.id)
      .reduce((total, player) => total + this.sumHand(player.hand), 0);

    winner.score += roundScore;
    room.gameState.scores[winner.id] = winner.score;
    room.gameState.winnerId = winner.id;
    room.gameState.endedAt = new Date().toISOString();
    room.status = 'finished';

    return winner;
  }

  nextTurn(roomId: string): number {
    const room = this.roomManager.getRoomOrThrow(roomId);
    const totalPlayers = room.players.length;

    if (totalPlayers === 0) {
      throw new Error('Impossible de changer de tour sans joueur.');
    }

    room.gameState.currentTurnIndex = (room.gameState.currentTurnIndex + 1) % totalPlayers;
    return room.gameState.currentTurnIndex;
  }

  private placeTile(board: BoardTile[], tile: Tile, side: BoardSide): BoardTile[] {
    if (board.length === 0) {
      return [{ tile, side: 'first' }];
    }

    const boardEnd = this.getBoardEnd(board, side);
    if (boardEnd === null) {
      throw new Error('Impossible de lire les extremites du plateau.');
    }

    const orientedTile = this.orientTile(tile, boardEnd, side);
    const boardTile: BoardTile = { tile: orientedTile, side };

    return side === 'left' ? [boardTile, ...board] : [...board, boardTile];
  }

  private getBoardEnd(board: BoardTile[], side: BoardSide): number | null {
    if (board.length === 0) {
      return null;
    }

    const edgeTile = side === 'left' ? board[0].tile : board[board.length - 1].tile;
    return side === 'left' ? edgeTile[0] : edgeTile[1];
  }

  private orientTile(tile: Tile, boardEnd: number, side: BoardSide): Tile {
    if (side === 'left') {
      return tile[1] === boardEnd ? tile : [tile[1], tile[0]];
    }

    return tile[0] === boardEnd ? tile : [tile[1], tile[0]];
  }

  private findStartingPlayerIndex(players: Player[]): number {
    let bestPlayerIndex = 0;
    let bestTileValue = -1;

    players.forEach((player, playerIndex) => {
      player.hand.forEach((tile) => {
        const isDouble = tile[0] === tile[1];
        const value = isDouble ? tile[0] + 100 : tile[0] + tile[1];

        if (value > bestTileValue) {
          bestTileValue = value;
          bestPlayerIndex = playerIndex;
        }
      });
    });

    return bestPlayerIndex;
  }

  private getActivePlayerIndex(room: Room, playerId: string): number {
    const playerIndex = room.players.findIndex((player) => player.id === playerId);

    if (playerIndex === -1) {
      throw new Error('Joueur introuvable dans cette room.');
    }

    return playerIndex;
  }

  private findTileIndex(hand: Tile[], tile: Tile): number {
    return hand.findIndex(
      (candidate) =>
        (candidate[0] === tile[0] && candidate[1] === tile[1]) ||
        (candidate[0] === tile[1] && candidate[1] === tile[0]),
    );
  }

  private sumHand(hand: Tile[]): number {
    return hand.reduce((total, tile) => total + tile[0] + tile[1], 0);
  }

  private shuffle<T>(items: T[]): T[] {
    const shuffled = [...items];

    for (let index = shuffled.length - 1; index > 0; index -= 1) {
      const swapIndex = Math.floor(Math.random() * (index + 1));
      [shuffled[index], shuffled[swapIndex]] = [shuffled[swapIndex], shuffled[index]];
    }

    return shuffled;
  }
}
