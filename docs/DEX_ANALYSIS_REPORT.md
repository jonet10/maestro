# Rapport d'analyse DEX — Flyclops / Maestro Domino

**Date :** 7 juin 2026  
**Fichiers analysés :**
| Fichier | Taille | Contenu principal |
|---------|--------|-------------------|
| `modeles/classes.dex` | 7,7 Mo | AndroidX, ConstraintLayout, Leanback, framework Android |
| `modeles/classes2.dex` | 475 Ko | Bibliothèque de desugaring Java (`j$/time`, `j$/util`) |
| `modeles/classes3.dex` | 5,2 Mo | Shell Flutter + Unity, Firebase, Google Ads, Material Design |

**Méthode :** extraction du pool de strings DEX (92 803 chaînes uniques), recherche sémantique, corrélation avec packages Java/Kotlin.

---

## Conclusion principale

**Les fichiers DEX ne contiennent pas la logique métier du jeu de domino.**

Ils proviennent du **conteneur Android** d'une application hybride **Flutter + Unity**, pas du moteur de jeu lui-même. La logique domino (règles, IA, scores, placement) réside très probablement dans :

- **`libil2cpp.so`** / assemblies Unity (C# compilé en natif), ou
- **`libapp.so`** / snapshot Dart (Flutter),

qui ne sont **pas** présents dans le dossier `modeles/`.

---

## Preuves techniques

### Stack détectée (classes3.dex)

```
Development platform is: Flutter
Flutter
Unity
Unity Editor version is:
com.google.firebase.crashlytics.unity_version
flutter_assets/NOTICES.Z
```

### Dépendances identifiées

| Domaine | Packages / composants |
|---------|----------------------|
| UI Android | Material Components, AppCompat, ConstraintLayout |
| Analytics | Firebase Crashlytics, Google Measurement |
| Publicité | Google Mobile Ads (`ad_exposure`, `adunit_exposure`) |
| Média | YouTube Player (`com/pierfrancescosoffritti/androidyoutubeplayer`) |
| Images | SubsamplingScaleImageView |
| Auth | Google Sign-In (GMS) |

### Recherche ciblée — résultats négatifs

Aucune occurrence significative de :

- `flyclops`, `Flyclops`, `Domino`, `domino`, `boneyard`, `Boneyard`
- `GameEngine`, `BoardManager`, `ScoreManager`, `AIPlayer`
- Classes métier `com/flyclops/*` ou similaires
- Algorithmes de chaîne, validation de coups, distribution de tuiles

Les seuls « spinner » trouvés sont des widgets Android (`AppCompatTheme_spinnerStyle`), pas le domino-spinner.

### classes.dex et classes2.dex

- **classes.dex** : bibliothèques système et AndroidX (~56 708 strings) — layout, media, emoji, leanback TV.
- **classes2.dex** : runtime Java 8+ desugared pour API < 26.
- **classes3.dex** : couche Flutter/Unity + SDK tiers.

---

## Ce que l'on peut inférer (références visuelles + stack)

Sans code DEX exploitable, le comportement attendu provient des **captures** dans `modeles/` (`reference-branches-virages.png`, `reference-spinner-6-6.png`) et des conventions des jeux professionnels :

| Mécanisme | Comportement attendu |
|-----------|---------------------|
| Distribution | Jeu double-6, 7 tuiles/joueur, 14 au boneyard |
| Ouverture | Plus haut double, sinon plus haute tuile |
| Spinner | Premier double joué → branches up/down |
| Modes | All Fives, Draw, Block |
| Scoring Fives | Somme des extrémités ouvertes multiple de 5 |
| Layout | Serpentin multi-rangées, virages anticipés |
| IA | Heuristiques : points, flexibilité main, blocage adversaire |

---

## Comparaison avec Maestro Domino

| Fonctionnalité | Maestro Domino (avant intégration) | Flyclops (inféré) | Action |
|----------------|-----------------------------------|-------------------|--------|
| Moteur reducer | `dominoEngine.ts` ✅ | N/A dans DEX | Conserver |
| 3 modes (fives/draw/block) | ✅ | ✅ (standard) | Conserver |
| Spinner + branches | ✅ | ✅ (captures) | Conserver |
| Layout serpentin | ✅ (refactorisé) | ✅ | Conserver |
| Scoring capot/block/fives | ✅ | ✅ (standard) | Conserver |
| Multi-manches → target score | ❌ (1 manche) | ✅ | **Implémenté** |
| Ouverture forcée (double max) | ❌ | ✅ | **Implémenté** |
| IA heuristique | ✅ `botLogic.ts` | ✅ (supposé) | Amélioré |
| IA niveaux difficulté | ❌ | ✅ (supposé) | **Implémenté** |
| Bot solo naïf | ❌ `match.tsx` | — | **Corrigé** |
| Multijoueur online | Infra ✅, UI ❌ | ✅ | Hors scope DEX |
| Animations gameplay | React Native Reanimated ✅ | Unity | Conserver UI Maestro |

---

## Classes / modules Maestro Domino (architecture cible)

Maestro utilise un **pattern fonctionnel** (pas de classes Java). Modules créés / enrichis :

```
mobile/src/engine/
├── gameEngine.ts      # Façade publique (dispatch, init, état)
├── dominoRules.ts     # Constantes, règles, tuile d'ouverture
├── dominoEngine.ts    # Reducer principal (existant)
├── moveValidator.ts   # Validation coups (existant + ouverture)
├── scoring.ts         # Calcul points (existant)
├── scoreManager.ts    # Façade scoring
├── matchManager.ts    # Multi-manches, fin de match
├── gameInitializer.ts # Distribution (existant)
├── aiPlayer.ts        # IA multi-niveaux
├── botLogic.ts        # Heuristiques de base (existant)
└── types.ts           # Types partagés
```

---

## Plan d'intégration appliqué

1. **Analyse DEX** — documentée (ce rapport) ; aucune copie de code obfusqué.
2. **Règles professionnelles** — ouverture forcée, multi-manches jusqu'au score cible.
3. **IA** — 4 niveaux (easy/medium/hard/expert) réécrits proprement.
4. **Solo** — remplacement du bot naïf par `AIPlayer`.
5. **UI** — inchangée (couleurs, écrans, assets).

---

## Recommandations futures

Pour une analyse plus profonde de Flyclops, extraire depuis l'APK :

- `lib/arm64-v8a/libil2cpp.so` + `global-metadata.dat` (Il2CppDumper)
- ou `lib/arm64-v8a/libapp.so` (Flutter reversing)

Les fichiers `.dex` seuls ne suffisent pas pour récupérer la logique domino.

---

## Fichiers d'analyse générés

- `modeles/dex_analysis/STRING_REPORT.md`
- `modeles/dex_analysis/classes_strings.txt`
- `modeles/dex_analysis/classes2_strings.txt`
- `modeles/dex_analysis/classes3_strings.txt`
- `tools/dex_strings.mjs` — extracteur réutilisable
