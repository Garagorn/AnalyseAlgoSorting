 package modele.sorting;

public class CountingSort extends AbstractSort {

    @Override
    public String getName() {
        return "CountingSort";
    }

    @Override
    protected void sortImpl(int[] array) {
        countingSort(array);
    }

    /**
     * Implémentation complète de Counting Sort.
     * Tous les accès à "array" passent par read/write pour instrumenter les métriques.
     */
    private void countingSort(int[] array) {
        if (array.length <= 1) return;

        // Trouver min et max
        int min = read(array, 0);
        int max = read(array, 0);
        for (int i = 1; i < array.length; i++) {
            int val = read(array, i);
            if (val > max) max = val;
            if (val < min) min = val;
        }

        int range = max - min + 1; // taille du tableau de comptes
        int[] count = new int[range];

        // Compter les occurrences
        for (int i = 0; i < array.length; i++) {
            int val = read(array, i);
            count[val - min] = count[val - min] + 1; // Décalage
        }

        // Reconstituer le tableau trié
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            for (int j = 0; j < c; j++) {
                write(array, index++, i + min); // On inverse le décalage
            }
        }
    }

}
