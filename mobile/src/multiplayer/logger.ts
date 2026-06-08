export const mpLogger = {
  log: (module: string, message: string, data?: any) => {
    if (__DEV__) {
      console.log(`[MULTIPLAYER | ${module}] ${message}`, data ? JSON.stringify(data, null, 2) : '');
    }
  },
  warn: (module: string, message: string, data?: any) => {
    if (__DEV__) {
      console.warn(`[MULTIPLAYER | ${module}] WARNING: ${message}`, data ? JSON.stringify(data, null, 2) : '');
    }
  },
  error: (module: string, message: string, error?: any) => {
    if (__DEV__) {
      console.error(`[MULTIPLAYER | ${module}] ERROR: ${message}`, error);
    }
  }
};
