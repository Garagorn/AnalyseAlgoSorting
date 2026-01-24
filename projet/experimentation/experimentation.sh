#!/bin/bash

TAILLES=(5 10)
DESORDRES=(0 50 100)
TYPES=(1 2 3 4)
REPETITIONS=2

cd ..
ant compile
cd build/

for size in "${TAILLES[@]}"; do
    for disorder in "${DESORDRES[@]}"; do
        for type in "${TYPES[@]}"; do
            for ((i=1; i<=REPETITIONS; i++)); do
                echo "Run $i | Taille=$size Desordre=$disorder Type=$type"
                java MainTest "$size" "$disorder" "$type"
            done
        done
    done
done

