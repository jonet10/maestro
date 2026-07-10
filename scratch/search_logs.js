import fs from 'fs';
import readline from 'readline';

const rl = readline.createInterface({
  input: fs.createReadStream('C:\\Users\\herod\\.gemini\\antigravity\\brain\\40e11387-0de6-4c91-a024-e800ba5d80f1\\.system_generated\\logs\\transcript.jsonl'),
  crlfDelay: Infinity
});

rl.on('line', (line) => {
  const obj = JSON.parse(line);
  const content = obj.content || '';
  if (obj.step_index < 2850 && (content.toLowerCase().includes('5:2') || content.toLowerCase().includes('tourner') || content.toLowerCase().includes('haut') || content.toLowerCase().includes('upward') || content.toLowerCase().includes('coiling'))) {
    console.log(`Step ${obj.step_index} (${obj.type}):`);
    console.log(content);
    console.log('----------------------------------------------------');
  }
});



