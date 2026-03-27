# Analyse des algorithmes de tri

## Présentation

Implémentation en Java d'une plateforme d'analyse comparative des algorithmes de tri, accompagnée d'un générateur de données paramétrables et d'un module d'expérimentation automatisée.
Le projet est structuré en trois modules :

- Visualisation interactive : interface graphique temps réel des algorithmes
- Expérimentation : génération automatique de données de performance
- Analyse : interprétation comparative des résultats

Le projet utilise Apache Ant pour la compilation et l'exécution, et des scripts Bash pour l'expérimentation.

Ce projet est centré sur la question scientifique suivante : **Comment les paramètres d'un tableau (taille, degré et zone de désordre) influencent les performances des algorithmes de tri ? **

---

# Aperçu du projet
Ce projet permet :

- de visualiser en temps réel l'exécution des algorithmes de tri
- d'expérimenter sur différents paramètres (taille, désordre, localisation)
- de générer automatiquement des données de performance
- d'analyser comparativement l'efficacité des algorithmes

---

# Technologies utilisées

- Java – implémentation et interface graphique
- Apache Ant – compilation et exécution
- Bash – orchestration des expérimentations
- CSV – export et analyse des données
- JavaDoc – documentation du code
- Python Matplotlib - génération des courbes

---

# Structure du projet

```
.
├── src/                    # Code source Java (MVC)
│   ├── modele/            # Algorithmes et logique métier
│   ├── vue/               # Interface graphique Swing
│   └── controleur/        # Contrôleur MVC
├── experimentation/        # Scripts d'expérimentation
│   ├── Lanceur.sh         # Orchestrateur principal
│   ├── experimentation.sh # Script par taille
│   ├── Aggregation.sh     # Agrégation par algorithme
│   └── resultats/         # Données CSV générées
├── build.xml              # Configuration Ant
└── README.md
```

---

# Prérequis

- **Java**
- **Apache Ant**
- **Bash**

---

# Installation et exécution

## Lancer la visualisation
Depuis la racine du projet :


```bash
cd thomas-siaghi-marie-tellier/projet
ant run
```
Cette commande permet de :

1. Compiler le projet
2. Générer la documentation JavaDoc
3. Lancer l'interface graphique

---

## Compilation
```bash
cd thomas-siaghi-marie-tellier/projet
ant compile
```

---

## Compilation
### Interface graphique
```bash
cd thomas-siaghi-marie-tellier/projet
ant compile
```

---

## Execution
### Interface graphique

```bash
cd thomas-siaghi-marie-tellier/projet
ant run
```

---

### Nettoyer le projet
```bash
cd thomas-siaghi-marie-tellier/projet
ant clean
```

---
## Expérimentation automatisée
Le projet inclut un système d'expérimentation automatisée permettant de générer des données de performance sur différentes configurations de tableaux.
---

## Lancement de l'expérimentation
1. Se placer dans le dossier :
```bash
cd thomas-siaghi-marie-tellier/projet/experimentation
```

2. Lancer l'éxpérimentation complète :
```bash
bash Lanceur.sh resultats/Mon_Experience tout
```

3. Les résultats sont générés dans :
```bash
experimentation/resultats/Mon_Experience/
```

---

## Modes d'expérimentation
### Expérimentaion seule
```bash
bash Lanceur.sh resultats/Mon_Experience expe
```

### Agrégation seule
```bash
bash Lanceur.sh resultats/Mon_Experience aggr
```
### Les deu à la suite :
```bash
bash Lanceur.sh resultats/Mon_Experience tout
```

---

# Organisation des résultats
- Fichiers par taille : size_100.csv, size_500.csv, etc.
- Fichiers par algorithme : QuickSort.csv, BubbleSort.csv, etc.
- Métriques : comparaisons, accès, échanges, temps d'exécution
- Paramètres : taille, désordre, type de localisation

---

# Analyse

Les fichiers CSV générés peuvent être analysés avec :
- Python/matplotlib : génération de graphiques

---

# Architecture logicielle
Le projet suit le patron MVC avec les patterns Observer, Template Method, Strategy et Facade. L'instrumentation des algorithmes via AbstractSort permet une mesure précise et uniforme des métriques de performance.

---

# Documentation du projet
Le rapport détaillé du projet est disponible ici :
```source
Rapport.pdf
```

La JavaDoc est générée automatiquement :
```bash
ant javadoc
# Consultable dans dist/docs/api/
```

---

# Auteurs
- Vianney MARIE
- Matthieu **THOMAS**
- Massinissa **SIAGHI** (https://github.com/siaghi2250)
- Basile **TELLIER** (https://github.com/Garagorn)
