# Intégration post-analyse DEX — Maestro Domino

## Résumé

Les fichiers DEX analysés ne contiennent **pas** de logique domino réutilisable (shell Flutter/Unity + SDK Android). Les améliorations ont été implémentées en s'appuyant sur :

1. Les **règles professionnelles** standard (All Fives, Draw, Block)
2. Les **références visuelles** Flyclops dans `modeles/`
3. L'**architecture existante** de Maestro Domino

---

## Fonctionnalités ajoutées / améliorées

| Fonctionnalité | Module | Description |
|----------------|--------|-------------|
| Multi-manches | `matchManager.ts` | Enchaînement automatique jusqu'au score cible |
| Ouverture forcée | `dominoRules.ts` + `moveValidator.ts` | Plus haut double ou plus haute tuile obligatoire |
| IA 4 niveaux | `aiPlayer.ts` | easy / medium / hard / expert |
| Bot solo intelligent | `match.tsx` | Remplace le bot naïf par `getAIAction()` |
| Façade moteur | `gameEngine.ts` + `index.ts` | API publique unifiée |
| Scores alignés | `dominoRules.ts` | Fives=150, Draw/Block=250 |

---

## Fichiers créés

- `docs/DEX_ANALYSIS_REPORT.md`
- `docs/INTEGRATION_SUMMARY.md`
- `mobile/src/engine/dominoRules.ts`
- `mobile/src/engine/matchManager.ts`
- `mobile/src/engine/scoreManager.ts`
- `mobile/src/engine/aiPlayer.ts`
- `mobile/src/engine/gameEngine.ts`
- `mobile/src/engine/index.ts`
- `mobile/src/engine/engine.test.ts`
- `tools/dex_strings.mjs`
- `modeles/dex_analysis/*` (rapports strings)

## Fichiers modifiés

- `mobile/src/engine/dominoEngine.ts` — multi-manches via `finalizeRound`
- `mobile/src/engine/moveValidator.ts` — validation ouverture
- `mobile/src/engine/botLogic.ts` — respect tuile d'ouverture
- `mobile/src/engine/gameInitializer.ts` — `getTargetScore()`
- `mobile/src/engine/types.ts` — side `'first'` dans payload
- `mobile/src/app/match.tsx` — IA intelligente
- `mobile/src/store/matchStore.ts` — `aiDifficulty` (défaut: medium)

---

## Architecture moteur

```
gameEngine.ts (façade)
    ├── dominoEngine.ts     → reducer PLAY/DRAW/PASS
    ├── matchManager.ts     → manches, fin de match
    ├── dominoRules.ts      → constantes, ouverture
    ├── moveValidator.ts    → validation coups
    ├── scoreManager.ts     → points, victoire match
    ├── aiPlayer.ts         → IA multi-niveaux
    └── gameInitializer.ts  → distribution
```

**UI inchangée** : couleurs, écrans, assets, composants visuels.

---

## Tests

```bash
npx tsx src/engine/engine.test.ts
npx tsx src/components/game/BoardLayoutEngine.layout.test.ts
```

---

## Prochaines étapes recommandées

1. Extraire `libil2cpp.so` de l'APK Flyclops pour analyse Unity réelle
2. Sélecteur difficulté IA dans `settings.tsx` (store déjà prêt)
3. Synchroniser `supabase/functions/_shared/engine/` avec le moteur mobile
4. Connecter le matchmaking online depuis l'écran d'accueil
