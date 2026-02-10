#!/bin/bash

#Parametres d'experimentation
TAILLES=(100 500 1000 10000 25000 50000) # + grand
DESORDRES=(0 10 20 30 40 50 60 70 80 90 100) # + de desordres
TYPES=(1 2 3 4)
#Modifier les params avec generateur V2

#seed

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
            
			java -cp ../build MainTest "$size" "$disorder" "$type" > test_1.txt || exit 1
         
            # Recupération sortie java
            grep '^\[csv\]' test_1.txt | while read -r line; do
                # Apres la balise [csv]
                data=$(echo "$line" | cut -d ' ' -f 2-)
                
                # Ajouter taille, pourcentage et typeDesordre au fichier
                echo "${size},${disorder},${type},${data}" >> "$fichier"
            done
        done
    done
done
echo "- - Fin experimentation 1 - - -"
rm test_1.txt

