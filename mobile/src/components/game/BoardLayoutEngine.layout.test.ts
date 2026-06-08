/**
 * Tests limites du terrain, serpentin et non-chevauchement.
 * Run: npx tsx src/components/game/BoardLayoutEngine.layout.test.ts
 */
import { calculateBoardPositions, TILE_LG, TILE_SW } from './BoardLayoutEngine';
import { computePlayfield, TILE_GAP } from './chainLayoutCore';
import type { BoardTile } from '../../engine/types';

function makeTile(
  v0: number,
  v1: number,
  side: BoardTile['side'],
  oriented?: [number, number],
): BoardTile {
  const isDouble = v0 === v1;
  return {
    tile: [v0, v1],
    orientedTile: oriented ?? [v0, v1],
    side,
    isDouble,
    isSpinner: side === 'first' && isDouble,
  };
}

function tileBounds(p: { x: number; y: number; orientation: string }) {
  const w = p.orientation === 'horizontal' ? TILE_LG : TILE_SW;
  const h = p.orientation === 'horizontal' ? TILE_SW : TILE_LG;
  return { left: p.x, right: p.x + w, top: p.y, bottom: p.y + h };
}

function assertFitsViewport(
  label: string,
  vw: number,
  vh: number,
  board: BoardTile[],
) {
  const result = calculateBoardPositions(board, { viewportWidth: vw, viewportHeight: vh });
  const pad = 2;

  if (result.fitScale > 1.001) {
    throw new Error(`${label}: fitScale > 1 (${result.fitScale})`);
  }

  for (let i = 0; i < result.positions.length; i++) {
    const p = result.positions[i];
    if (!p) continue;
    const b = tileBounds(p);
    const s = result.fitScale;
    const screenLeft = b.left * s + vw / 2;
    const screenRight = b.right * s + vw / 2;
    const screenTop = b.top * s + vh / 2;
    const screenBottom = b.bottom * s + vh / 2;

    if (screenRight > vw - pad || screenLeft < pad) {
      throw new Error(`${label}: tuile ${i} déborde horizontalement (L=${screenLeft.toFixed(0)} R=${screenRight.toFixed(0)})`);
    }
    if (screenBottom > vh - pad || screenTop < pad) {
      throw new Error(`${label}: tuile ${i} déborde verticalement`);
    }
  }
}

function assertNoOverlap(label: string, board: BoardTile[], vw: number, vh: number) {
  const result = calculateBoardPositions(board, { viewportWidth: vw, viewportHeight: vh });
  const boxes = result.positions
    .filter(Boolean)
    .map((p) => tileBounds(p!));

  // Tolérance aux jonctions de coin (les bbox se touchent sans pénétration visuelle)
  const inset = 10;
  for (let i = 0; i < boxes.length; i++) {
    for (let j = i + 1; j < boxes.length; j++) {
      const a = boxes[i];
      const b = boxes[j];
      const overlapX = a.left + inset < b.right - inset && a.right - inset > b.left + inset;
      const overlapY = a.top + inset < b.bottom - inset && a.bottom - inset > b.top + inset;
      if (overlapX && overlapY) {
        throw new Error(`${label}: chevauchement tuiles ${i} et ${j}`);
      }
    }
  }
}

// --- Écrans étroits 320px portrait ---
{
  const board: BoardTile[] = [makeTile(6, 6, 'first')];
  let open = 6;
  for (let i = 0; i < 14; i++) {
    const next = (i + 1) % 7;
    board.push(makeTile(open, next, 'right', [open, next]));
    open = next;
  }
  assertFitsViewport('chaîne longue 320px', 320, 260, board);
  assertNoOverlap('chaîne longue 320px', board, 320, 260);
}

// --- Portrait 390×500 ---
{
  const board: BoardTile[] = [makeTile(3, 3, 'first')];
  let open = 3;
  for (let i = 0; i < 10; i++) {
    const next = (i + 4) % 7;
    board.push(makeTile(open, next, 'right', [open, next]));
    open = next;
  }
  for (let i = 0; i < 6; i++) {
    const next = (i + 2) % 7;
    board.push(makeTile(open, next, 'left', [next, open]));
    open = next;
  }
  assertFitsViewport('spinner + branches 390px', 390, 340, board);
  assertNoOverlap('spinner + branches 390px', board, 390, 340);
}

// --- Paysage 480×320 ---
{
  const board: BoardTile[] = [makeTile(5, 2, 'first')];
  let open = 2;
  for (let i = 0; i < 12; i++) {
    const next = (i + 3) % 7;
    board.push(makeTile(open, next, 'right', [open, next]));
    open = next;
  }
  assertFitsViewport('paysage 480px', 480, 280, board);
}

// --- Nombreux doubles ---
{
  const board: BoardTile[] = [makeTile(6, 6, 'first')];
  const seq: [number, number][] = [[6, 4], [4, 4], [4, 2], [2, 2], [2, 0], [0, 0], [0, 3], [3, 3], [3, 5], [5, 5]];
  seq.forEach(([a, b]) => board.push(makeTile(a, b, 'right', [a, b])));
  assertFitsViewport('doubles multiples 360px', 360, 300, board);
}

// --- Premier virage à droite ---
{
  const board: BoardTile[] = [makeTile(1, 1, 'first')];
  for (let i = 0; i < 8; i++) {
    board.push(makeTile(1, 2, 'right', [1, 2]));
  }
  const r = calculateBoardPositions(board, { viewportWidth: 340, viewportHeight: 280 });
  const dirs = r.positions.filter(Boolean).map((p) => p!.chainDir);
  if (!dirs.includes('U') && !dirs.includes('L')) {
    throw new Error('premier virage droite: aucune direction U/L détectée');
  }
  assertFitsViewport('premier virage droite', 340, 280, board);
}

// --- Premier virage à gauche ---
{
  const board: BoardTile[] = [makeTile(2, 2, 'first')];
  for (let i = 0; i < 8; i++) {
    board.push(makeTile(2, 3, 'left', [3, 2]));
  }
  const r = calculateBoardPositions(board, { viewportWidth: 340, viewportHeight: 280 });
  const dirs = r.positions.filter(Boolean).map((p) => p!.chainDir);
  if (!dirs.includes('D') && !dirs.includes('R')) {
    throw new Error('premier virage gauche: aucune direction D/R détectée');
  }
  assertFitsViewport('premier virage gauche', 340, 280, board);
}

// --- Playfield marges ---
{
  const f320 = computePlayfield({ width: 320, height: 260 });
  if (f320.maxX >= 160) throw new Error('marge droite insuffisante');
  if (f320.minX <= -160) throw new Error('marge gauche insuffisante');
}

// --- Espacement segment horizontal ---
{
  const board: BoardTile[] = [makeTile(1, 1, 'first'), makeTile(1, 2, 'right', [1, 2]), makeTile(2, 3, 'right', [2, 3])];
  const r = calculateBoardPositions(board, { viewportWidth: 360, viewportHeight: 300 });
  const p0 = r.positions[0]!;
  const p1 = r.positions[1]!;
  const gap = p1.x - (p0.x + TILE_SW);
  if (gap < TILE_GAP - 1) throw new Error(`espacement insuffisant: ${gap}px`);
}

// --- Desktop large ---
{
  const board: BoardTile[] = [makeTile(6, 6, 'first')];
  let open = 6;
  for (let i = 0; i < 20; i++) {
    const next = (i + 2) % 7;
    board.push(makeTile(open, next, 'right', [open, next]));
    open = next;
  }
  assertFitsViewport('desktop 1024px', 1024, 700, board);
}

console.log('All layout boundary tests passed.');
