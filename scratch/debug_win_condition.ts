import fs from 'fs';

const app = fs.readFileSync('src/App.tsx', 'utf-8');

const handleRoundEndIdx = app.indexOf('if (nextHand.length === 0)');
console.log('Found nextHand.length === 0 check:', handleRoundEndIdx !== -1);
