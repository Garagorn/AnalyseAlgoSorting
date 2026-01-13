package modele.sorting;


public interface Sort {

    void sort(int[] array);

    String getName();
    int getNbrComparisons();
    int getNbrAccesses();
    int gatNbrSwaps();
    double getTimeNano();
}