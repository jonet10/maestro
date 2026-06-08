import dotenv from 'dotenv';
dotenv.config();

import { createApp } from './app';

const PORT = parseInt(process.env.PORT || '3000', 10);
const { server } = createApp();

server.listen(PORT, () => {
  console.log(`[Maestro Domino Server] Running on http://localhost:${PORT}`);
  console.log(`[Maestro Domino Server] Socket.io ready`);
});
