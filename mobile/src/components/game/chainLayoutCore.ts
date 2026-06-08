import type { ChainDir } from './tileDisplayOrientation';

export const TILE_SW = 40;
export const TILE_LG = 80;
/** Espacement constant entre dominos (réf. Flyclops / modeles/). */
export const TILE_GAP = 4;
/** Distance entre centres de rangées (≥ hauteur tuile horizontale + gap). */
export const ROW_PITCH = TILE_LG + TILE_GAP;

export interface Playfield {
  minX: number;
  maxX: number;
  minY: number;
  maxY: number;
}

export interface LayoutViewport {
  width: number;
  height: number;
}

/**
 * Terrain de jeu en coordonnées layout (px à scale 1).
 * Marges proportionnelles : 8 % horizontal, 9 % vertical (min 12 px).
 */
export function computePlayfield(viewport: LayoutViewport): Playfield {
  const { width: vw, height: vh } = viewport;
  const marginX = Math.max(12, vw * 0.08);
  const marginY = Math.max(12, vh * 0.09);
  return {
    minX: -vw / 2 + marginX,
    maxX: vw / 2 - marginX,
    minY: -vh / 2 + marginY,
    maxY: vh / 2 - marginY,
  };
}

/**
 * Chaque branche (gauche / droite) occupe sa moitié du terrain pour éviter
 * que deux serpentins combinés dépassent la largeur visible.
 */
export function branchPlayfield(field: Playfield, side: 'left' | 'right' | 'up' | 'down'): Playfield {
  const centerGap = TILE_GAP;
  if (side === 'left') return { ...field, maxX: centerGap };
  if (side === 'right') return { ...field, minX: -centerGap };
  if (side === 'up') return { ...field, maxY: centerGap };
  return { ...field, minY: -centerGap };
}

export function tileDimensions(isDouble: boolean, dir: ChainDir): { w: number; h: number } {
  const horizontal = dir === 'R' || dir === 'L';
  if (horizontal) {
    return isDouble ? { w: TILE_SW, h: TILE_LG } : { w: TILE_LG, h: TILE_SW };
  }
  return isDouble ? { w: TILE_LG, h: TILE_SW } : { w: TILE_SW, h: TILE_LG };
}

export function isHorizontalDir(dir: ChainDir): boolean {
  return dir === 'R' || dir === 'L';
}

/** Y du centre d'une rangée horizontale (0 = ancre, alternance haut/bas). */
export function rowCenterY(rowIndex: number): number {
  if (rowIndex <= 0) return 0;
  const tier = Math.ceil(rowIndex / 2);
  return rowIndex % 2 === 1 ? -tier * ROW_PITCH : tier * ROW_PITCH;
}

/**
 * Place une tuile horizontale sur une rangée fixe (évite le chevauchement des retours).
 */
export function placeHorizontalOnRow(
  prev: ChainCursor,
  isDouble: boolean,
  dir: ChainDir,
  rowY: number,
): ChainCursor {
  const { w: nw, h: nh } = tileDimensions(isDouble, dir);

  if (isHorizontalDir(prev.dir)) {
    const ex = prev.dir === 'R' ? prev.cx + prev.w / 2 : prev.cx - prev.w / 2;
    const ncx = dir === 'R' ? ex + TILE_GAP + nw / 2 : ex - TILE_GAP - nw / 2;
    return new ChainCursor(ncx, rowY, dir, nw, nh);
  }

  // Depuis une tuile de virage verticale vers une nouvelle rangée
  const ncx = dir === 'L' ? prev.cx - TILE_GAP - nw / 2 : prev.cx + TILE_GAP + nw / 2;
  return new ChainCursor(ncx, rowY, dir, nw, nh);
}

export class ChainCursor {
  cx: number;
  cy: number;
  dir: ChainDir;
  w: number;
  h: number;

  constructor(cx: number, cy: number, dir: ChainDir, w: number, h: number) {
    this.cx = cx;
    this.cy = cy;
    this.dir = dir;
    this.w = w;
    this.h = h;
  }

  bounds(): { left: number; right: number; top: number; bottom: number } {
    return {
      left: this.cx - this.w / 2,
      right: this.cx + this.w / 2,
      top: this.cy - this.h / 2,
      bottom: this.cy + this.h / 2,
    };
  }
}

/**
 * Place la tuile suivante avec espacement TILE_GAP constant.
 * Virages calqués sur le serpentin Flyclops (modeles/).
 */
export function placeNextTile(
  prev: ChainCursor,
  isDouble: boolean,
  newDir: ChainDir,
): ChainCursor {
  const { cx, cy, w: pw, h: ph, dir: prevDir } = prev;
  const { w: nw, h: nh } = tileDimensions(isDouble, newDir);

  let ex = cx;
  let ey = cy;
  if (prevDir === 'R') ex = cx + pw / 2;
  else if (prevDir === 'L') ex = cx - pw / 2;
  else if (prevDir === 'D') ey = cy + ph / 2;
  else if (prevDir === 'U') ey = cy - ph / 2;

  let ncx = cx;
  let ncy = cy;

  if (newDir === prevDir) {
    if (newDir === 'R') { ncx = ex + TILE_GAP + nw / 2; ncy = ey; }
    else if (newDir === 'L') { ncx = ex - TILE_GAP - nw / 2; ncy = ey; }
    else if (newDir === 'D') { ncx = ex; ncy = ey + TILE_GAP + nh / 2; }
    else { ncx = ex; ncy = ey - TILE_GAP - nh / 2; }
  } else if (isHorizontalDir(prevDir) && !isHorizontalDir(newDir)) {
    // H → V : tuile de virage au coin, décalée pour éviter tout chevauchement
    if (prevDir === 'R') {
      ncx = ex + TILE_GAP + nw / 2;
    } else {
      ncx = ex - TILE_GAP - nw / 2;
    }
    if (isDouble) {
      ncy = ey;
    } else if (newDir === 'U') {
      ncy = ey - ph / 2 - TILE_GAP - nh / 2;
    } else {
      ncy = ey + ph / 2 + TILE_GAP + nh / 2;
    }
  } else if (!isHorizontalDir(prevDir) && isHorizontalDir(newDir)) {
    // V → H : nouvelle rangée au-delà de l'extrémité de la tuile verticale
    const tipY = prevDir === 'U' ? cy - ph / 2 : cy + ph / 2;
    if (prevDir === 'U') {
      ncy = tipY - TILE_GAP - nh / 2;
    } else {
      ncy = tipY + TILE_GAP + nh / 2;
    }
    if (isDouble) {
      ncx = cx;
    } else if (newDir === 'R') {
      ncx = cx + TILE_GAP + nw / 2;
    } else {
      ncx = cx - TILE_GAP - nw / 2;
    }
  } else {
    if (newDir === 'R') { ncx = ex + TILE_GAP + nw / 2; ncy = ey; }
    else if (newDir === 'L') { ncx = ex - TILE_GAP - nw / 2; ncy = ey; }
    else if (newDir === 'D') { ncx = ex; ncy = ey + TILE_GAP + nh / 2; }
    else { ncx = ex; ncy = ey - TILE_GAP - nh / 2; }
  }

  return new ChainCursor(ncx, ncy, newDir, nw, nh);
}

/** Anticipe débordement horizontal sur une rangée fixe. */
export function wouldExceedHorizontalRow(
  cursor: ChainCursor,
  isDouble: boolean,
  dir: ChainDir,
  rowY: number,
  field: Playfield,
): boolean {
  const next = placeHorizontalOnRow(cursor, isDouble, dir, rowY);
  const b = next.bounds();
  if (dir === 'R') return b.right > field.maxX;
  if (dir === 'L') return b.left < field.minX;
  return false;
}

/**
 * Anticipe si la prochaine tuile dépasserait le terrain sur l'axe de déplacement.
 * Seul l'axe du mouvement est testé (virage horizontal) ; le scale final adapte la hauteur.
 */
export function wouldExceedPlayfield(
  cursor: ChainCursor,
  isDouble: boolean,
  dir: ChainDir,
  field: Playfield,
): boolean {
  const next = placeNextTile(cursor, isDouble, dir);
  const b = next.bounds();
  if (dir === 'R') return b.right > field.maxX;
  if (dir === 'L') return b.left < field.minX;
  if (dir === 'D') return b.bottom > field.maxY;
  if (dir === 'U') return b.top < field.minY;
  return false;
}

export interface SnakeBranchConfig {
  startHDir: ChainDir;
  turnAtRight: ChainDir;
  turnAtLeft: ChainDir;
}

export const RIGHT_BRANCH: SnakeBranchConfig = {
  startHDir: 'R',
  turnAtRight: 'U',
  turnAtLeft: 'D',
};

export const LEFT_BRANCH: SnakeBranchConfig = {
  startHDir: 'L',
  turnAtRight: 'U',
  turnAtLeft: 'D',
};

export interface Bounds {
  minX: number;
  maxX: number;
  minY: number;
  maxY: number;
}

export function mergeBounds(a: Bounds, b: Bounds): Bounds {
  return {
    minX: Math.min(a.minX, b.minX),
    maxX: Math.max(a.maxX, b.maxX),
    minY: Math.min(a.minY, b.minY),
    maxY: Math.max(a.maxY, b.maxY),
  };
}

export function boundsFromCursor(c: ChainCursor): Bounds {
  const b = c.bounds();
  return { minX: b.left, maxX: b.right, minY: b.top, maxY: b.bottom };
}

/** Échelle pour que la bbox tienne dans le viewport (jamais > 1). */
export function computeFitScale(bb: Bounds, viewport: LayoutViewport, pad = 24): number {
  const bw = Math.max(bb.maxX - bb.minX + pad * 2, TILE_LG);
  const bh = Math.max(bb.maxY - bb.minY + pad * 2, TILE_LG);
  return Math.min(viewport.width / bw, viewport.height / bh, 1);
}
