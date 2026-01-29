package modele.sorting;


public abstract class AbstractSort implements Sort{

    protected long nbrComparisons;
    protected long nbrAccesses;
    protected long nbrSwaps;
    protected long timeNano;


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
        this.nbrComparisons++;
        return a < b;
    }

    protected void swap(int[] array, int i, int j) {
        this.nbrSwaps++;
        int tmp = read(array, i);
        write(array, i, read(array, j));
        write(array, j, tmp);
    }

    //les getters et les setters
    @Override
    public abstract String getName();

    @Override
    public long getNbrComparisons(){
        return this.nbrComparisons;
    }

    @Override
    public long getNbrAccesses(){
        return this.nbrAccesses;
    }

    @Override
    public long getNbrSwaps(){
        return this.nbrSwaps;
    }

    @Override
    public long getTimeNano(){
        return this.timeNano;
    }






}
