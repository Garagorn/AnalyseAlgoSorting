package modele.sorting;

import modele.SortingModel;

public abstract class AbstractSort implements Sort{

    protected long nbrComparisons;
    protected long nbrAccesses;
    protected long nbrSwaps;
    protected long timeNano;
    protected long startTime;

    protected int lastCompareIndex1 = -1;
    protected int lastCompareIndex2 = -1; 

    protected SortingModel model;



    public AbstractSort(SortingModel model){
        this.model = model;
        this.nbrComparisons = 0;
        this.nbrAccesses = 0;
        this.nbrSwaps = 0;
        this.timeNano = 0;
        this.startTime = 0;

    }

    @Override
    public final void sort(int[] array) {
        resetMetrics();
        this.startTime = System.nanoTime();
        sortImpl(array);
        this.timeNano = System.nanoTime() - this.startTime;
        
        
    }

    protected abstract void sortImpl(int[] array);

    protected void resetMetrics() {
        this.nbrComparisons = 0;
        this.nbrAccesses = 0;
        this.nbrSwaps = 0;
        this.timeNano = 0;
    }

    protected int read(int[] array, int index) {
        updateTime();
        model.updateVisualization(index, -1, "read");
        this.nbrAccesses++;
        return array[index];
    }

    protected void write(int[] array, int index, int value) {
        updateTime();
        model.updateVisualization(index, -1, "write");
        this.nbrAccesses++;
        array[index] = value;
    }

    protected boolean isLess(int a, int b) {
        updateTime();
        this.nbrComparisons++;

        if (lastCompareIndex1 != -1 && lastCompareIndex2 != -1) {
            model.updateVisualization(
                lastCompareIndex1,
                lastCompareIndex2,
                "compare"
            );
        }
        return a < b;

    }

    protected void swap(int[] array, int i, int j) {
        updateTime();
        model.updateVisualization(i, j, "swap");
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

    protected void updateTime() {
    timeNano = System.nanoTime() - startTime;
    }

    protected void setCompareIndices(int i, int j) {
        this.lastCompareIndex1 = i;
        this.lastCompareIndex2 = j;
    }
}

