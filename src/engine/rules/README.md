# Règles Métier (`src/engine/rules`)

Ce module contient les algorithmes et la logique pure du jeu.
Chaque règle doit être implémentée sous la forme de fonctions pures (qui ne modifient pas directement l'état global mais retournent un résultat) afin d'être unitairement testable.

## Contenu
- `FirstPlayerRule.ts` : Détermination du joueur qui commence une manche (recherche du plus grand double, ou du plus fort domino selon les priorités définies).
- `BlockedGameRule.ts` : Résolution d'une manche où aucun joueur ne peut jouer (calcul des points restants et règles de départage complexes).
- `ScoreRule.ts` : Calcul des points (All-Fives) séparé de toute logique d'animation.
