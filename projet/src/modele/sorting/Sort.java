package sorting;


public interface Sort {

    void sort(int[] array);

    String getName();
    long getNbrComparisons();
    long getNbrAccesses();
    long getNbrSwaps();
    long getTimeNano();
}