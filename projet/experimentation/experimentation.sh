#!/bin/bash

#Parametres d'experimentation
TAILLES=(100 500 1000 10000 25000 50000 75000 100000) # + grand
DESORDRES=(0 25 50 75 100) # + de desordres
TYPES=(1 2 3 4)
#Modifier les params avec generateur V2

#seed

#Placement dans build
cd ..
ant compile


cd experimentation/
#Dossiers de résultat
mkdir -p resultats
cd resultats/
#Suppression des txts
rm -f size_*.csv
cd ..

echo "Debut experimentaion"

#Bouclage imbriqué pour le lancement de l'experimentation
for size in "${TAILLES[@]}"; do

	#Creation du fichier csv
	fichier="resultats/size_${size}.csv"
	#creation du header
	if [ ! -f "$fichier" ]; then
        echo "taille,desordre,typeDesordre,algo,accesses,comparisons,swaps,timeNano" > "$fichier"
    fi
	
    for disorder in "${DESORDRES[@]}"; do
        for type in "${TYPES[@]}"; do

            echo "[run] taille=$size pourcentage=$disorder desordre=$type"
            
			java -cp ../build Experimentation "$size" "$disorder" "$type" > test.txt || exit 1

            # Recupération sortie java
            grep '^\[csv\]' test.txt | while read -r line; do
                # Apres la balise [csv]
                data=$(echo "$line" | cut -d ' ' -f 2-)
                
                # Ajouter taille, pourcentage et typeDesordre au fichier
                echo "${size},${disorder},${type},${data}" >> "$fichier"
            done
        done
    done
done
echo "Fin experimentaion"
rm test.txt

