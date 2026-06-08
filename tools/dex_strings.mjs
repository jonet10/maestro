/**
 * Extract readable strings from Android DEX files (string pool only).
 * Usage: node tools/dex_strings.mjs [modelesDir]
 */
import fs from 'fs';
import path from 'path';

function readUleb128(buf, offset) {
  let result = 0;
  let shift = 0;
  let pos = offset;
  while (true) {
    const b = buf[pos++];
    result |= (b & 0x7f) << shift;
    if ((b & 0x80) === 0) break;
    shift += 7;
  }
  return [result, pos];
}

function parseDexStrings(filePath) {
  const data = fs.readFileSync(filePath);
  if (data.slice(0, 4).toString() !== 'dex\n') {
    throw new Error(`Not a DEX file: ${filePath}`);
  }
  const stringIdsSize = data.readUInt32LE(0x38);
  const stringIdsOff = data.readUInt32LE(0x3c);
  const strings = [];

  for (let i = 0; i < stringIdsSize; i++) {
    const off = data.readUInt32LE(stringIdsOff + i * 4);
    const [, pos] = readUleb128(data, off);
    let end = pos;
    while (data[end] !== 0) end++;
    const s = data.slice(pos, end).toString('utf8');
    if (s) strings.push(s);
  }
  return strings;
}

const dominoRe = /domino|tile|bone|pip|spinner|boneyard|draw|pass|score|round|match|turn|player|board|hand|double|block|fives|capot|trick|ai|bot|computer|solo|multi|flyclops|game/i;

function main() {
  const dexDir = process.argv[2] || path.join(process.cwd(), 'modeles');
  const outDir = path.join(dexDir, 'dex_analysis');
  fs.mkdirSync(outDir, { recursive: true });

  const dexFiles = fs.readdirSync(dexDir).filter((f) => /^classes\d*\.dex$/i.test(f)).sort();
  const all = new Set();

  for (const name of dexFiles) {
    const fp = path.join(dexDir, name);
    console.log(`Parsing ${name} (${Math.round(fs.statSync(fp).size / 1024)} KB)...`);
    const strings = parseDexStrings(fp);
    const unique = [...new Set(strings)];
    unique.forEach((s) => all.add(s));
    fs.writeFileSync(path.join(outDir, `${path.basename(name, '.dex')}_strings.txt`), unique.sort().join('\n'));
    console.log(`  ${unique.length} unique strings`);
  }

  const sorted = [...all].sort();
  const gameStrings = sorted.filter((s) => dominoRe.test(s));
  const classes = sorted.filter((s) => s.startsWith('L') && s.includes(';'));
  const typeNames = sorted.filter((s) => s.includes('/') && !s.startsWith('L') && s.length > 5);

  const report = [
    '# DEX String Analysis Report',
    '',
    `Files: ${dexFiles.join(', ')}`,
    `Total unique strings: ${sorted.length}`,
    '',
    '## Domino / Game related strings',
    '',
    ...gameStrings.map((s) => `- ${s}`),
    '',
    '## Class descriptors (first 400)',
    '',
    ...classes.slice(0, 400).map((s) => `- ${s}`),
    '',
    '## Type-like paths',
    '',
    ...typeNames.slice(0, 200).map((s) => `- ${s}`),
  ].join('\n');

  fs.writeFileSync(path.join(outDir, 'STRING_REPORT.md'), report);
  console.log(`Report: ${path.join(outDir, 'STRING_REPORT.md')}`);
  console.log(`Game-related strings: ${gameStrings.length}`);
  console.log(`Class descriptors: ${classes.length}`);
}

main();
