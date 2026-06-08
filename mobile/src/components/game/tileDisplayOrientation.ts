import type { BoardTile } from '../../engine/types';

export type ChainDir = 'R' | 'L' | 'U' | 'D';
export type TileOrientation = 'horizontal' | 'vertical';
type BoardSide = BoardTile['side'];

/**
 * Règles d'orientation visuelle (référence : modeles/reference-*.png, Flyclops mobile) :
 *
 * 1. Non-doubles : le grand côté est PARALLÈLE au sens de la chaîne.
 *    - Chaîne horizontale (R/L) → tuile horizontale (80×40)
 *    - Chaîne verticale   (U/D) → tuile verticale   (40×80)
 *
 * 2. Doubles : le grand côté est PERPENDICULAIRE à la chaîne.
 *    - Chaîne horizontale → double vertical   (40×80)
 *    - Chaîne verticale   → double horizontal (80×40)
 *
 * 3. Connexion des pips : la moitié reliée à la chaîne existante (inner)
 *    est toujours sur le bord PHYSIQUE face au domino précédent :
 *    - R : inner à gauche   | L : inner à droite
 *    - D : inner en haut    | U : inner en bas
 *
 * 4. DominoTile dessine a sur le bord « début » (gauche si horizontal, haut si vertical)
 *    et b sur le bord « fin » (droite / bas).
 *
 * orientTileForSide() (moteur de jeu) stocke les pips selon le côté logique
 * (left/right/up/down), pas selon la direction visuelle après un virage.
 * Ce module traduit orientedTile → ordre d'affichage [a, b].
 */

/** Index du pip relié à l'ancre / au reste de la chaîne (convention orientTileForSide). */
function innerPipIndex(side: BoardSide): 0 | 1 {
  if (side === 'right' || side === 'down' || side === 'first') return 0;
  return 1;
}

/**
 * Indique si le pip « inner » doit être dessiné sur le bord début de DominoTile.
 * Le bord début = gauche (horizontal) ou haut (vertical).
 */
function innerOnStartEdge(chainDir: ChainDir, orientation: TileOrientation): boolean {
  if (orientation === 'horizontal') {
    return chainDir === 'R';
  }
  return chainDir === 'D';
}

/** Orientation physique d'une tuile selon la direction de chaîne et le type. */
export function resolveTileOrientation(chainDir: ChainDir, isDouble: boolean): TileOrientation {
  const chainIsHorizontal = chainDir === 'R' || chainDir === 'L';
  if (chainIsHorizontal) {
    return isDouble ? 'vertical' : 'horizontal';
  }
  return isDouble ? 'horizontal' : 'vertical';
}

export interface TileDisplayResult {
  orientation: TileOrientation;
  displayA: number;
  displayB: number;
  rotation: number;
}

/**
 * Résout l'affichage complet d'une tuile posée sur le plateau.
 * rotation reste 0 : l'inversion éventuelle est gérée par l'ordre [a, b].
 */
export function resolveTileDisplay(
  orientedTile: [number, number],
  side: BoardSide,
  chainDir: ChainDir,
  isDouble: boolean,
): TileDisplayResult {
  const orientation = resolveTileOrientation(chainDir, isDouble);

  if (isDouble) {
    return {
      orientation,
      displayA: orientedTile[0],
      displayB: orientedTile[1],
      rotation: 0,
    };
  }

  const [displayA, displayB] = getDisplayHalves(orientedTile, side, chainDir, orientation);
  return { orientation, displayA, displayB, rotation: 0 };
}

/**
 * Convertit orientedTile en ordre [a, b] pour DominoTile.
 * Inverse les moitiés quand la direction visuelle est opposée au sens nominal du côté.
 */
export function getDisplayHalves(
  orientedTile: [number, number],
  side: BoardSide,
  chainDir: ChainDir,
  orientation?: TileOrientation,
): [number, number] {
  const orient = orientation ?? resolveTileOrientation(chainDir, false);
  const inner = innerPipIndex(side);
  const outer = (1 - inner) as 0 | 1;

  if (innerOnStartEdge(chainDir, orient)) {
    return [orientedTile[inner], orientedTile[outer]];
  }
  return [orientedTile[outer], orientedTile[inner]];
}
