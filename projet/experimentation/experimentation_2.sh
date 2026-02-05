#!/bin/bash

#Parametres d'experimentation
TAILLES=(75000) # + grand
DESORDRES=(0 15 25 35 50 65 75 90 100) # + de desordres
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
            
			java -cp ../build MainTest "$size" "$disorder" "$type" > test_2.txt || exit 1
         
            # Recupération sortie java
            grep '^\[csv\]' test_2.txt | while read -r line; do
                # Apres la balise [csv]
                data=$(echo "$line" | cut -d ' ' -f 2-)
                
                # Ajouter taille, pourcentage et typeDesordre au fichier
                echo "${size},${disorder},${type},${data}" >> "$fichier"
            done
        done
    done
done
echo "- - Fin experimentation 2 - - -"
rm test_2.txt

