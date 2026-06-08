/**
 * Vérification des règles d'orientation (référence Flyclops).
 * Run: npx tsx src/components/game/BoardLayoutEngine.display.test.ts
 */
import {
  getDisplayHalves,
  resolveTileDisplay,
  resolveTileOrientation,
  ChainDir,
} from './tileDisplayOrientation';
import type { BoardTile } from '../../engine/types';

type Side = BoardTile['side'];

const INNER = 3;
const OUTER = 5;

function orientedForSide(side: Side): [number, number] {
  const innerIdx =
    side === 'right' || side === 'down' || side === 'first' ? 0 : 1;
  const tile: [number, number] = [0, 0];
  tile[innerIdx] = INNER;
  tile[1 - innerIdx] = OUTER;
  return tile;
}

function expectedHalves(chainDir: ChainDir): [number, number] {
  const innerOnStart = chainDir === 'R' || chainDir === 'D';
  return innerOnStart ? [INNER, OUTER] : [OUTER, INNER];
}

function expectHalves(label: string, side: Side, chainDir: ChainDir) {
  const oriented = orientedForSide(side);
  const expected = expectedHalves(chainDir);
  const result = getDisplayHalves(oriented, side, chainDir);
  if (result[0] !== expected[0] || result[1] !== expected[1]) {
    throw new Error(`${label}: expected [${expected}], got [${result}]`);
  }
}

// --- Orientations physiques (Flyclops) ---
function expectOrient(chainDir: ChainDir, isDouble: boolean, expected: 'horizontal' | 'vertical', label: string) {
  const o = resolveTileOrientation(chainDir, isDouble);
  if (o !== expected) throw new Error(`${label}: expected ${expected}, got ${o}`);
}

expectOrient('R', false, 'horizontal', 'non-double horizontal R');
expectOrient('L', false, 'horizontal', 'non-double horizontal L');
expectOrient('U', false, 'vertical', 'non-double vertical U');
expectOrient('D', false, 'vertical', 'non-double vertical D');
expectOrient('R', true, 'vertical', 'double sur chaîne horizontale');
expectOrient('U', true, 'horizontal', 'double sur chaîne verticale');

// --- Toutes les combinaisons côté × direction ---
expectHalves('right + R', 'right', 'R');
expectHalves('right + L (fin de ligne droite)', 'right', 'L');
expectHalves('right + U (virage à droite)', 'right', 'U');
expectHalves('right + D', 'right', 'D');
expectHalves('left + L', 'left', 'L');
expectHalves('left + R (fin de ligne gauche)', 'left', 'R');
expectHalves('left + D (virage à gauche)', 'left', 'D');
expectHalves('left + U', 'left', 'U');
expectHalves('up + U', 'up', 'U');
expectHalves('up + D', 'up', 'D');
expectHalves('up + L', 'up', 'L');
expectHalves('up + R', 'up', 'R');
expectHalves('down + D', 'down', 'D');
expectHalves('down + U', 'down', 'U');
expectHalves('down + L', 'down', 'L');
expectHalves('down + R', 'down', 'R');
expectHalves('first + R (début de ligne)', 'first', 'R');

// --- Scénario virage H→V→H (branche droite) ---
{
  const turnOriented: [number, number] = [INNER, OUTER]; // right side: inner=3, outer=5
  const turn = resolveTileDisplay(turnOriented, 'right', 'U', false);
  if (turn.orientation !== 'vertical') throw new Error('turn tile should be vertical');
  if (turn.displayA !== OUTER || turn.displayB !== INNER) {
    throw new Error(`turn U: expected [${OUTER},${INNER}], got [${turn.displayA},${turn.displayB}]`);
  }

  const returnOriented: [number, number] = [INNER, OUTER];
  const ret = resolveTileDisplay(returnOriented, 'right', 'L', false);
  if (ret.orientation !== 'horizontal') throw new Error('return tile should be horizontal');
  if (ret.displayA !== OUTER || ret.displayB !== INNER) {
    throw new Error(`return L: expected [${OUTER},${INNER}], got [${ret.displayA},${ret.displayB}]`);
  }
}

// --- Scénarios extraits des modèles (modeles/reference-*.png) ---
function expectDisplay(
  label: string,
  oriented: [number, number],
  side: Side,
  chainDir: ChainDir,
  isDouble: boolean,
  expected: { orientation: 'horizontal' | 'vertical'; a: number; b: number },
) {
  const r = resolveTileDisplay(oriented, side, chainDir, isDouble);
  if (r.orientation !== expected.orientation || r.displayA !== expected.a || r.displayB !== expected.b) {
    throw new Error(
      `${label}: expected orient=${expected.orientation} [${expected.a},${expected.b}], ` +
      `got orient=${r.orientation} [${r.displayA},${r.displayB}]`,
    );
  }
}

// reference-spinner-6-6.png : branche droite horizontale depuis le 6:6
expectDisplay('[6:3] branche droite R', [6, 3], 'right', 'R', false, { orientation: 'horizontal', a: 6, b: 3 });

// reference-branches-virages.png : virage H→V à droite ([0:2] → [2:6], 2 en bas)
expectDisplay('[2:6] virage droite U', [2, 6], 'right', 'U', false, { orientation: 'vertical', a: 6, b: 2 });

// reference-spinner-6-6.png : virage H→V ([0:5] → [5:6], 5 en bas)
expectDisplay('[5:6] virage droite U', [5, 6], 'right', 'U', false, { orientation: 'vertical', a: 6, b: 5 });

// reference-branches-virages.png : branche haute puis virage V→H ([2:3] → [3:1], 3 à droite)
expectDisplay('[3:1] virage haut L', [1, 3], 'up', 'L', false, { orientation: 'horizontal', a: 1, b: 3 });

// reference-branches-virages.png : branche basse virage V→H ([1:4] → [4:5], 4 à gauche)
expectDisplay('[4:5] virage bas R', [5, 4], 'left', 'R', false, { orientation: 'horizontal', a: 4, b: 5 });

// reference-branches-virages.png : branche gauche virage H→V ([4:5] → [4:1], 4 en haut)
expectDisplay('[4:1] virage gauche D', [1, 4], 'left', 'D', false, { orientation: 'vertical', a: 4, b: 1 });

// reference-spinner-6-6.png : branche haute depuis spinner ([6:1], 6 en bas)
expectDisplay('[6:1] branche haut U', [1, 6], 'up', 'U', false, { orientation: 'vertical', a: 1, b: 6 });

// reference-spinner-6-6.png : branche basse depuis spinner ([6:2], 6 en haut)
expectDisplay('[6:2] branche bas D', [6, 2], 'down', 'D', false, { orientation: 'vertical', a: 6, b: 2 });

// doubles : spinner vertical, double en branche verticale horizontal
expectDisplay('[6:6] spinner R', [6, 6], 'first', 'R', true, { orientation: 'vertical', a: 6, b: 6 });
expectDisplay('[1:1] double branche verticale D', [1, 1], 'left', 'D', true, { orientation: 'horizontal', a: 1, b: 1 });

// --- Doubles : valeurs inchangées quelle que soit la direction ---
const dbl: [number, number] = [4, 4];
for (const side of ['right', 'left', 'up', 'down', 'first'] as Side[]) {
  for (const dir of ['R', 'L', 'U', 'D'] as ChainDir[]) {
    const r = resolveTileDisplay(dbl, side, dir, true);
    if (r.displayA !== 4 || r.displayB !== 4) {
      throw new Error(`double ${side}+${dir}: expected [4,4], got [${r.displayA},${r.displayB}]`);
    }
  }
}

console.log('All display orientation cases passed.');
