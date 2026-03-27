package modele.generateur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Génère des tableaux d'entiers [0..n-1] partiellement désordonnés selon quatre modes :
 *   1 = positions aléatoires dans tout le tableau
 *   2 = désordre en début de tableau
 *   3 = désordre au milieu du tableau
 *   4 = désordre en fin de tableau
 */
public class Generator {

    /** Taille du tableau à générer. */
    private int size;

    /** Pourcentage d'éléments à mélanger. */
    private int disorderPercentage;

    /**
     * Construit un générateur avec taille et pourcentage de désordre.
     *
     * @param size taille du tableau
     * @param disorderPercentage pourcentage d'éléments à mélanger
     */
    public Generator(int size, int disorderPercentage) {
        this.size = size;
        this.disorderPercentage = disorderPercentage;
    }

    /**
     * Calcule le nombre d'éléments à mélanger à partir de la taille et du pourcentage.
     * @param size taille du tableau
     * @param disorderPercentage pourcentage d'éléments à mélanger (0-100)
     * @return nombre d'éléments à mélanger
     * @throws IllegalArgumentException si le pourcentage est hors de [0, 100]
     */
    public static int computeShuffleCount(int size, int disorderPercentage) {
        if (disorderPercentage < 0 || disorderPercentage > 100) {
            throw new IllegalArgumentException("Le pourcentage doit être compris entre 0 et 100.");
        }
        return size * disorderPercentage / 100;
    }

    /**
     * Génère un tableau d'entiers [0..size-1] partiellement mélangé.
     *
     * @param size               nombre d'éléments
     * @param disorderPercentage pourcentage d'éléments à mélanger (0-100)
     * @param disorderMode       mode de désordre (1 à 4)
     * @return tableau partiellement désordonné
     */
    public static int[] generate(int size, int disorderPercentage, int disorderMode) {
        int shuffleCount = computeShuffleCount(size, disorderPercentage);
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        switch (disorderMode) {
            case 1 -> shuffleRandomPositions(array, shuffleCount, rand);
            case 2 -> shuffleRange(array, 0, shuffleCount);
            case 3 -> {
                int start = Math.max(0, (size / 2) - (shuffleCount / 2));
                shuffleRange(array, start, shuffleCount);
            }
            case 4 -> shuffleRange(array, size - shuffleCount, shuffleCount);
        }

        return array;
    }

    /** Mélange shuffleCount éléments à des positions aléatoires distinctes dans le tableau. 
     * 
     * @param array tableau
     * @param shuffleCount nombre d'éléments à mélanger
     * @param rand générateur aléatoire
     */
    private static void shuffleRandomPositions(int[] array, int shuffleCount, Random rand) {
        List<Integer> pickedIndices = new ArrayList<>();
        List<Integer> pickedValues  = new ArrayList<>();

        while (pickedIndices.size() < shuffleCount) {
            int idx = rand.nextInt(array.length);
            if (!pickedIndices.contains(idx)) {
                pickedIndices.add(idx);
                pickedValues.add(array[idx]);
            }
        }

        shuffleSubList(pickedValues);
        for (int i = 0; i < shuffleCount; i++) {
            array[pickedIndices.get(i)] = pickedValues.get(i);
        }
    }

    /** Mélange count éléments consécutifs à partir de startIndex. 
     *
     * @param array tableau
     * @param startIndex index de départ
     * @param count nombre d'éléments à mélanger
     */
    private static void shuffleRange(int[] array, int startIndex, int count) {
        List<Integer> segment = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            segment.add(array[startIndex + i]);
        }
        shuffleSubList(segment);
        for (int i = 0; i < count; i++) {
            array[startIndex + i] = segment.get(i);
        }
    }

    /**
     * Mélange aléatoirement une liste en place.
     *
     * @param list liste à mélanger
     */
    public static void shuffleSubList(List<Integer> list) {
        Collections.shuffle(list);
    }

    /* Point d'entrée de démonstration. 
    public static void main(String[] args) {
        for (int mode = 1; mode <= 4; mode++) {
            System.out.println("Mode " + mode + " :");
            int[] result = generate(20, 50, mode);
            for (int v : result) System.out.print(v + " ");
            System.out.println();
        }
    }*/
}