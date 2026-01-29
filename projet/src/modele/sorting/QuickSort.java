package sorting;
import java.util.Random;

public class QuickSort extends AbstractSort{
    private Random random;
    
    @Override
    public String getName() {
        return "QuickSort";
    }

    public QuickSort(){
        super();
        this.random = new Random();
    }

    @Override
    public void sortImpl(int[] array){
        quicksort(array,0,array.length-1);
    }

    /**
     * Algorithme  de partionnement 
     * @param data Tableau à partitionner
     * @param premier Premier element du tableau
     * @param dernier Dernier element du tableau
     * @return int Nouvelle place du pivot
     */
    public int partitionner(int[] data,int premier,int dernier){
        int pivotIndex = premier + random.nextInt(dernier - premier + 1);
        swap(data, pivotIndex, dernier);
        int pivot = read(data, dernier);
        int i = premier - 1;

        for(int j=premier; j<=dernier-1;j++){
            int val = read(data, j);
            if (isLessEqual(val, pivot) && !isLessEqual(pivot, val)){
                i++;
                swap(data, i, j);
            }
        }
        swap(data,i+1,dernier);
        return i+1;
    }

    /**
     * Execution de quicksort
     * @param data Tableau à trier
     * @param premier Premier element du tableau
     * @param dernier Dernier element du tableau
     */
    public void quicksort(int[] data, int premier,int dernier){
        if(premier<dernier){
            int pivot = partitionner(data,premier,dernier);
        
            quicksort(data,premier,pivot-1);
            quicksort(data,pivot+1,dernier);
        }
    }
    
    protected boolean isLessEqual(int a, int b) {
        this.nbrComparisons++;
        return a <= b;
    }
}