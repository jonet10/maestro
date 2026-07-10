# Maestro Domino Engine

Ce dossier contient le cœur de la logique métier de Maestro Domino.
Afin de garantir une scalabilité, une testabilité et une synchronisation réseau parfaite, l'architecture respecte le principe de la séparation de la logique et de la vue.

## Structure
- `/config` : Contient la configuration globale du jeu (délais, durées, paramètres). Aucune "valeur magique" ne doit se trouver hors de ce dossier.
- `/core` : Contient l'orchestration du jeu, à savoir la Machine à États Générique (`GameStateMachine`) et la File d'Événements (`EventQueue`).
- `/rules` : Contient toutes les règles du jeu (qui commence, victoire, blocage, score). Chaque règle est une fonction pure, isolée et testable.

## Principes
1. **Source de Vérité** : Le moteur est agnostique vis-à-vis de l'interface graphique (React). Il gère un état interne et émet des événements.
2. **Indépendance** : Ne jamais importer d'éléments React (hooks, composants) dans ce dossier.
3. **Traçabilité** : Toute modification d'état importante est historisée via `EventQueue` avec un UUID et un Timestamp.
