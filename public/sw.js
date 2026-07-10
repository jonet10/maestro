// ─── VERSION — change this string on every deploy to trigger update ───────────
// This is automatically bumped by the build; manual bump also works.
const CACHE_NAME = 'maestro-domino-v5';

// Static shell assets to pre-cache (images, manifest, icons)
const PRECACHE_ASSETS = [
  '/manifest.json',
  '/icons/icon-192.png',
  '/icons/icon-512.png',
  '/Maesto.png',
];

// ─── Message: page asks us to skip waiting and activate now ──────────────────
self.addEventListener('message', (e) => {
  if (e.data && e.data.type === 'SKIP_WAITING') {
    self.skipWaiting();
  }
});

// ─── Install: pre-cache shell — do NOT skipWaiting automatically ─────────────
// We wait for the user to click "Mettre à jour" before activating,
// so the update banner stays visible long enough for them to act.
self.addEventListener('install', (e) => {
  e.waitUntil(
    caches.open(CACHE_NAME)
      .then((cache) => cache.addAll(PRECACHE_ASSETS))
    // ← NO self.skipWaiting() here on purpose
  );
});

// ─── Activate: purge old caches, claim all clients ───────────────────────────
self.addEventListener('activate', (e) => {
  e.waitUntil(
    caches.keys()
      .then((keys) => Promise.all(
        keys.map((key) => key !== CACHE_NAME && caches.delete(key))
      ))
      .then(() => self.clients.claim())
  );
});


// ─── Fetch: smart routing ─────────────────────────────────────────────────────
self.addEventListener('fetch', (e) => {
  const { request } = e;
  const url = new URL(request.url);

  // Skip: non-GET, Supabase, Vite dev, chrome extensions
  if (
    request.method !== 'GET' ||
    url.hostname.includes('supabase.co') ||
    url.pathname.includes('/@vite/') ||
    url.pathname.includes('/src/') ||
    request.url.includes('?t=') ||
    request.url.includes('websocket') ||
    request.url.startsWith('chrome-extension:')
  ) {
    return;
  }

  // ── HTML & navigation → Network First, cache fallback ──────────────────────
  // This ensures users always get the latest version when online,
  // and can still play from cache when offline.
  if (
    request.mode === 'navigate' ||
    url.pathname === '/' ||
    url.pathname.endsWith('.html')
  ) {
    e.respondWith(
      fetch(request)
        .then((networkRes) => {
          if (networkRes && networkRes.ok) {
            const toCache = networkRes.clone();
            caches.open(CACHE_NAME).then((cache) => cache.put(request, toCache));
          }
          return networkRes;
        })
        .catch(() => caches.match(request).then((cached) => cached || caches.match('/')))
    );
    return;
  }

  // ── JS & CSS (Vite hashed bundles) → Cache First, network fallback ─────────
  // Vite produces content-hashed filenames (index-AbCdEf.js), so once cached
  // they never change — Cache First is safe and gives instant loads offline.
  if (
    url.pathname.match(/\/assets\/.*\.(js|css)$/) ||
    url.pathname.endsWith('.js') ||
    url.pathname.endsWith('.css')
  ) {
    e.respondWith(
      caches.match(request).then((cached) => {
        if (cached) return cached;
        return fetch(request).then((networkRes) => {
          if (networkRes && networkRes.ok) {
            const toCache = networkRes.clone();
            caches.open(CACHE_NAME).then((cache) => cache.put(request, toCache));
          }
          return networkRes;
        });
      })
    );
    return;
  }

  // ── Images / fonts / icons → Cache First ───────────────────────────────────
  if (url.pathname.match(/\.(png|jpg|jpeg|svg|gif|webp|woff2?|ico)$/)) {
    e.respondWith(
      caches.match(request).then((cached) => {
        if (cached) return cached;
        return fetch(request).then((networkRes) => {
          if (networkRes && networkRes.ok) {
            const toCache = networkRes.clone();
            caches.open(CACHE_NAME).then((c) => c.put(request, toCache));
          }
          return networkRes;
        });
      })
    );
    return;
  }

  // ── Everything else → Network only (no caching) ────────────────────────────
});
