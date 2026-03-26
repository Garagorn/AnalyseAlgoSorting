package modele;

import modele.generateur.Generator;
import modele.sorting.*;

/**
 * Outil de benchmarking hors interface graphique.
 *
 * Lance chaque algorithme sur plusieurs tailles de tableau et affiche
 * les métriques (comparaisons, accès, échanges, temps) dans la console.
 * Utilise un SortingModel sans visualisation (vitesse = 0, pas de vues abonnées).
 */
public class Experimentation {

    private static final int[] SIZES           = {100, 500, 1000, 5000};
    private static final int   DISORDER_PCT    = 50;
    private static final int   DISORDER_MODE   = 1;

    /**
     * Point d'entrée de l'application de benchmark.
     *
     * Pour chaque algorithme, génère des tableaux d'entiers de tailles différentes,
     * exécute le tri, et affiche les métriques dans la console.
     *
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        SortingModel benchModel = new SortingModel();
        benchModel.setVisualizationSpeed(0);

        AbstractSort[] algorithms = {
            new BubbleSort(benchModel),
            new InsertionSort(benchModel),
            new QuickSort(benchModel),
            new MergeSort(benchModel),
            new CountingSort(benchModel)
        };

        System.out.printf("%-16s %8s %12s %12s %12s %12s%n",
            "Algorithme", "Taille", "Comparaisons", "Accès", "Échanges", "Temps (ms)");
        System.out.println("-".repeat(76));

        for (AbstractSort algorithm : algorithms) {
            for (int size : SIZES) {
                int[] array = Generator.generate(size, DISORDER_PCT, DISORDER_MODE);
                benchModel.setCurrentSort(algorithm);

                algorithm.sort(array);

                double timeMs = algorithm.getTimeNano() / 1_000_000.0;
                System.out.printf("%-16s %8d %12d %12d %12d %12.2f%n",
                    algorithm.getName(),
                    size,
                    algorithm.getNbrComparisons(),
                    algorithm.getNbrAccesses(),
                    algorithm.getNbrSwaps(),
                    timeMs
                );
            }
            System.out.println();
        }
    }
}