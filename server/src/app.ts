import express from 'express';
import { createServer, Server as HttpServer } from 'http';
import { Server as SocketIOServer } from 'socket.io';
import cors from 'cors';
import { gameSocket } from './socket/gameSocket';

/**
 * Application factory.
 * Creates the Express app, HTTP server, and Socket.io server.
 * Does NOT modify existing Express routes — only adds new ones.
 */
export function createApp(): { app: express.Application; server: HttpServer; io: SocketIOServer } {
  const app = express();

  // ── Middleware ──
  app.use(cors({
    origin: process.env.CLIENT_URL || '*',
    methods: ['GET', 'POST'],
  }));
  app.use(express.json());

  // ── Health check (new, does not touch existing routes) ──
  app.get('/api/health', (_req, res) => {
    res.json({ status: 'ok', uptime: process.uptime() });
  });

  // ── HTTP server ──
  const server = createServer(app);

  // ── Socket.io ──
  const io = new SocketIOServer(server, {
    cors: {
      origin: process.env.CLIENT_URL || '*',
      methods: ['GET', 'POST'],
    },
    pingInterval: 10000,
    pingTimeout: 5000,
  });

  // ── Game system ──
  gameSocket(io);

  return { app, server, io };
}
