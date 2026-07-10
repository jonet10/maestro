# Noyau du Moteur (`src/engine/core`)

Ce module gère l'orchestration globale de la partie via deux composants fondamentaux : la Machine à États et la File d'Événements.

## Composants
- `GameStateMachine.ts` : Contrôleur générique gérant les phases du jeu (Attente, Tour, Passe, Calcul, etc.). Il détermine quelles actions sont autorisées à un instant T.
- `EventQueue.ts` : Système d'enregistrement et de diffusion séquentielle. Chaque événement (animation, calcul, fin de tour) y est poussé avec un UUID et un timestamp, permettant d'assurer la synchronisation réseau et de poser les bases d'un futur système de replay.
