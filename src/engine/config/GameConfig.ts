/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

export const GAME_CONFIG = {
  // Durée par défaut du chronomètre de tour (en secondes)
  // Peut être écrasée pour des modes spécifiques (classique, rapide, etc.)
  turnTimerDuration: 10,
  
  // Durée pour chaque phase d'animation (en millisecondes)
  durations: {
    noPlayHandShow: 1500,        // Présentation de la main bloquée
    noPlayPassToast: 1500,       // Toast de passe de tour
    roundEndDominoHighlight: 2000, // Observation du dernier domino joué
    scoreCountTick: 60,          // Intervalle par tick d'incrémentation de pips
    scoreRoundingReveal: 1500,    // Présentation du score arrondi de la manche
    scoreWinnerIncrement: 1500,   // Incrémentation animée du score final du vainqueur
  },
  
  // Désactive ou accélère fortement les animations (utile pour les tests automatiques / debug)
  disableAnimations: false,
};
