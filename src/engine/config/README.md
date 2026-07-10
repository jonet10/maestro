# Configuration (`src/engine/config`)

Ce module regroupe l'ensemble des constantes métier et des configurations du jeu Maestro Domino.
Aucune valeur de durée, de limite de score ou de temporisation ne doit être codée en dur (hardcodée) dans les autres modules ou dans l'interface graphique.

## Contenu attendu
- `GameConfig.ts` : Centralise toutes les constantes :
  - **Délais et timers** : durée du tour (10s), durée de l'animation de passe, pause de fin de partie.
  - **Paramètres IA** : temps de réflexion artificiel, niveau de difficulté par défaut.
  - **Règles de jeu** : score limite par défaut, options de piochage.
  - **Réseau** : timeout de reconnexion, intervalles de synchronisation.
