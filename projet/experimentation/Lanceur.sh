#!/bin/bash

expe=1   # 1 = lancer les expérimentations, 0 = ne rien faire

# Placement dans build
cd ..
ant compile
cd experimentation/

# Dossiers de résultat
mkdir -p resultats
cd resultats 
rm -f size_*.csv
cd ..

echo "Lancement de l'experimentation"

if [ "$expe" -eq 1 ]; then
    bash experimentation_1.sh || exit 1
    bash experimentation_2.sh || exit 1
    bash experimentation_3.sh || exit 1
    bash experimentation_4.sh || exit 1
    bash experimentation_5.sh || exit 1

    wait
    echo "Toutes les expérimentations sont terminées"
fi
