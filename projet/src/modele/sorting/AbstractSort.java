package modele.sorting;


public abstract class AbstractSort implements Sort{

    protected int nbrComparisons;
    protected int nbrAccesses;
    protected int nbrSwaps;
    protected double timeNano;


    public AbstractSort(){

        this.nbrComparisons = 0;
        this.nbrAccesses = 0;
        this.nbrSwaps = 0;
        this.timeNano = 0;

    }

    @Override
    public final void sort(int[] array) {
        resetMetrics();
        long start = System.nanoTime();
        sortImpl(array);
        timeNano = System.nanoTime() - start;
    }

    protected abstract void sortImpl(int[] array);

    protected void resetMetrics() {
        this.nbrComparisons = 0;
        this.nbrAccesses = 0;
        this.nbrSwaps = 0;
        this.timeNano = 0;
    }

    protected int read(int[] array, int index) {
        this.nbrAccesses++;
        return array[index];
    }

    protected void write(int[] array, int index, int value) {
        this.nbrAccesses++;
        array[index] = value;
    }

    protected boolean isLess(int a, int b) {
        comparisons++;
        return a < b;
    }

    protected void swap(int[] array, int i, int j) {
        swaps++;
        int tmp = read(array, i);
        write(array, i, read(array, j));
        write(array, j, tmp);
    }

    //les getters et les setters
    @Override
    public abstract String getName();

    @Override
    public int getNbrComparisons(){
        return this.nbrComparisons;
    }

    @Override
    public int getNbrAccesses(){
        return this.getNbrAccesses;
    }

    @Override
    public int gatNbrSwaps(){
        return this.nbrSwaps;
    }

    @Override
    public double getTimeNano(){
        return this.timeNano;
    }






}