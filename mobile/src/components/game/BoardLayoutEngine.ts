import { BoardTile } from '../../engine/types';
import {
  ChainDir,
  TileOrientation,
  resolveTileDisplay,
  getDisplayHalves,
  resolveTileOrientation,
} from './tileDisplayOrientation';
import {
  TILE_SW,
  TILE_LG,
  TILE_GAP,
  Playfield,
  LayoutViewport,
  ChainCursor,
  computePlayfield,
  placeNextTile,
  placeHorizontalOnRow,
  wouldExceedPlayfield,
  wouldExceedHorizontalRow,
  isHorizontalDir,
  tileDimensions,
  rowCenterY,
  SnakeBranchConfig,
  RIGHT_BRANCH,
  LEFT_BRANCH,
  Bounds,
  mergeBounds,
  computeFitScale,
} from './chainLayoutCore';

export type { ChainDir, TileOrientation };
export { getDisplayHalves, resolveTileDisplay, resolveTileOrientation };
export { TILE_SW, TILE_LG, TILE_GAP, computePlayfield };

export interface TilePosition {
  x: number;
  y: number;
  rotation: number;
  zIndex: number;
  orientation: TileOrientation;
  chainDir: ChainDir;
  displayA: number;
  displayB: number;
}

export interface BoundingBox {
  minX: number;
  maxX: number;
  minY: number;
  maxY: number;
}

export interface BoardLayoutResult {
  positions: TilePosition[];
  leftEnd: TilePosition | null;
  rightEnd: TilePosition | null;
  upEnd: TilePosition | null;
  downEnd: TilePosition | null;
  boundingBox: BoundingBox;
  playfield: Playfield;
  fitScale: number;
}

export interface BoardLayoutOptions {
  viewportWidth?: number;
  viewportHeight?: number;
}

/** @deprecated Utiliser computePlayfield */
export function computeWrapLimits(viewportWidth: number, viewportHeight: number) {
  const f = computePlayfield({ width: viewportWidth, height: viewportHeight });
  return { maxX: f.maxX, maxY: f.maxY };
}

function isDouble(bt: BoardTile): boolean {
  return bt.isDouble ?? (bt.tile && bt.tile[0] === bt.tile[1]);
}

type SetPosFn = (idx: number, cursor: ChainCursor, bt: BoardTile) => void;

/**
 * Serpentin horizontal multi-rangées (réf. Flyclops).
 * R → U → L → D → R → …  (ou  L → D → R → U → L …)
 */
function layoutHorizontalSnake(
  tiles: BoardTile[],
  indices: number[],
  startCursor: ChainCursor,
  field: Playfield,
  config: SnakeBranchConfig,
  setPos: SetPosFn,
  onSpinner?: (cx: number, cy: number, w: number, h: number) => void,
) {
  let cursor = startCursor;
  let dir: ChainDir = config.startHDir;
  let rowIndex = 0;

  for (let i = 0; i < tiles.length; i++) {
    const bt = tiles[i];
    const idx = indices[i];
    const isDbl = isDouble(bt);
    const rowY = rowCenterY(rowIndex);

    if (isHorizontalDir(dir) && wouldExceedHorizontalRow(cursor, isDbl, dir, rowY, field)) {
      const vTurn: ChainDir = dir === 'R' ? config.turnAtRight : config.turnAtLeft;
      cursor = placeNextTile(cursor, isDbl, vTurn);
      setPos(idx, cursor, bt);
      rowIndex += 1;
      dir = dir === 'R' ? 'L' : 'R';
    } else if (isHorizontalDir(dir)) {
      cursor = placeHorizontalOnRow(cursor, isDbl, dir, rowY);
      setPos(idx, cursor, bt);
    } else {
      cursor = placeNextTile(cursor, isDbl, dir);
      setPos(idx, cursor, bt);
    }

    if (bt.isSpinner && onSpinner) {
      onSpinner(cursor.cx, cursor.cy, cursor.w, cursor.h);
    }
  }
}

/**
 * Serpentin vertical (branches up / down depuis le spinner).
 */
function layoutVerticalSnake(
  tiles: BoardTile[],
  indices: number[],
  startCursor: ChainCursor,
  field: Playfield,
  startDir: 'U' | 'D',
  setPos: SetPosFn,
) {
  let cursor = startCursor;
  let dir: ChainDir = startDir;

  for (let i = 0; i < tiles.length; i++) {
    const bt = tiles[i];
    const idx = indices[i];
    const isDbl = isDouble(bt);

    if (wouldExceedPlayfield(cursor, isDbl, dir, field)) {
      let turnDir: ChainDir;
      let nextDir: ChainDir;
      if (dir === 'U') { turnDir = 'L'; nextDir = 'L'; }
      else if (dir === 'D') { turnDir = 'R'; nextDir = 'R'; }
      else if (dir === 'L') { turnDir = 'D'; nextDir = 'D'; }
      else { turnDir = 'U'; nextDir = 'U'; }

      cursor = placeNextTile(cursor, isDbl, turnDir);
      setPos(idx, cursor, bt);
      dir = nextDir;
    } else {
      cursor = placeNextTile(cursor, isDbl, dir);
      setPos(idx, cursor, bt);
    }
  }
}

function centerPositions(
  positions: (TilePosition | undefined)[],
  bounds: BoundingBox,
): BoundingBox {
  const cx = (bounds.minX + bounds.maxX) / 2;
  const cy = (bounds.minY + bounds.maxY) / 2;
  for (const p of positions) {
    if (!p) continue;
    p.x -= cx;
    p.y -= cy;
  }
  return {
    minX: bounds.minX - cx,
    maxX: bounds.maxX - cx,
    minY: bounds.minY - cy,
    maxY: bounds.maxY - cy,
  };
}

export const calculateBoardPositions = (
  boardState: BoardTile[],
  options?: BoardLayoutOptions,
): BoardLayoutResult => {
  const viewport: LayoutViewport = {
    width: options?.viewportWidth ?? 340,
    height: options?.viewportHeight ?? 280,
  };

  const empty: BoardLayoutResult = {
    positions: [], leftEnd: null, rightEnd: null, upEnd: null, downEnd: null,
    boundingBox: { minX: 0, maxX: 0, minY: 0, maxY: 0 },
    playfield: computePlayfield(viewport),
    fitScale: 1,
  };

  if (!boardState?.length) return empty;

  const anchorIdx = boardState.findIndex(bt => bt?.tile && bt.side === 'first');
  if (anchorIdx === -1) return empty;

  const field = computePlayfield(viewport);
  const positions: (TilePosition | undefined)[] = new Array(boardState.length);
  const bounds: BoundingBox = { minX: Infinity, maxX: -Infinity, minY: Infinity, maxY: -Infinity };
  let zIndexCount = 1;

  const updateBounds = (cx: number, cy: number, w: number, h: number) => {
    bounds.minX = Math.min(bounds.minX, cx - w / 2);
    bounds.maxX = Math.max(bounds.maxX, cx + w / 2);
    bounds.minY = Math.min(bounds.minY, cy - h / 2);
    bounds.maxY = Math.max(bounds.maxY, cy + h / 2);
  };

  const setPos: SetPosFn = (idx, cursor, bt) => {
    const isDbl = isDouble(bt);
    const oriented = bt.orientedTile ?? bt.tile;
    const display = resolveTileDisplay(oriented, bt.side, cursor.dir, isDbl);
    positions[idx] = {
      x: cursor.cx - cursor.w / 2,
      y: cursor.cy - cursor.h / 2,
      rotation: display.rotation,
      zIndex: zIndexCount++,
      orientation: display.orientation,
      chainDir: cursor.dir,
      displayA: display.displayA,
      displayB: display.displayB,
    };
    updateBounds(cursor.cx, cursor.cy, cursor.w, cursor.h);
  };

  const anchor = boardState[anchorIdx];
  const anchorDbl = isDouble(anchor);
  const anchorDim = tileDimensions(anchorDbl, 'R');
  const anchorCursor = new ChainCursor(0, 0, 'R', anchorDim.w, anchorDim.h);
  setPos(anchorIdx, anchorCursor, anchor);

  let spinnerPos: { cx: number; cy: number; w: number; h: number } | null = null;
  if (anchor.isSpinner) {
    spinnerPos = { cx: 0, cy: 0, w: anchorDim.w, h: anchorDim.h };
  }

  const trackSpinner = (cx: number, cy: number, w: number, h: number) => {
    spinnerPos = { cx, cy, w, h };
  };

  const leftTiles: BoardTile[] = [];
  const leftIndices: number[] = [];
  for (let i = anchorIdx - 1; i >= 0; i--) {
    if (boardState[i]?.side === 'left') {
      leftTiles.push(boardState[i]);
      leftIndices.push(i);
    }
  }

  const rightTiles: BoardTile[] = [];
  const rightIndices: number[] = [];
  for (let i = anchorIdx + 1; i < boardState.length; i++) {
    if (boardState[i]?.side === 'right') {
      rightTiles.push(boardState[i]);
      rightIndices.push(i);
    }
  }

  if (leftTiles.length > 0) {
    const startLeft = new ChainCursor(0, 0, 'L', anchorDim.w, anchorDim.h);
    layoutHorizontalSnake(leftTiles, leftIndices, startLeft, field, LEFT_BRANCH, setPos, trackSpinner);
  }

  if (rightTiles.length > 0) {
    layoutHorizontalSnake(rightTiles, rightIndices, anchorCursor, field, RIGHT_BRANCH, setPos, trackSpinner);
  }

  const upTiles: BoardTile[] = [];
  const upIndices: number[] = [];
  for (let i = anchorIdx + 1; i < boardState.length; i++) {
    if (boardState[i]?.side === 'up') upTiles.push(boardState[i]), upIndices.push(i);
  }
  if (upTiles.length > 0 && spinnerPos) {
    const sp = spinnerPos;
    const startUp = new ChainCursor(sp.cx, sp.cy, 'U', sp.w, sp.h);
    layoutVerticalSnake(upTiles, upIndices, startUp, field, 'U', setPos);
  }

  const downTiles: BoardTile[] = [];
  const downIndices: number[] = [];
  for (let i = anchorIdx + 1; i < boardState.length; i++) {
    if (boardState[i]?.side === 'down') downTiles.push(boardState[i]), downIndices.push(i);
  }
  if (downTiles.length > 0 && spinnerPos) {
    const sp = spinnerPos;
    const startDown = new ChainCursor(sp.cx, sp.cy, 'D', sp.w, sp.h);
    layoutVerticalSnake(downTiles, downIndices, startDown, field, 'D', setPos);
  }

  const centeredBounds = centerPositions(positions, bounds);
  const typedPositions = positions as TilePosition[];
  const fitScale = computeFitScale(centeredBounds, viewport);

  return {
    positions: typedPositions,
    leftEnd: leftTiles.length > 0 ? typedPositions[leftIndices[leftIndices.length - 1]] : typedPositions[anchorIdx],
    rightEnd: rightTiles.length > 0 ? typedPositions[rightIndices[rightIndices.length - 1]] : typedPositions[anchorIdx],
    upEnd: upTiles.length > 0 ? typedPositions[upIndices[upIndices.length - 1]] : null,
    downEnd: downTiles.length > 0 ? typedPositions[downIndices[downIndices.length - 1]] : null,
    boundingBox: centeredBounds,
    playfield: field,
    fitScale,
  };
};
