package modele.sorting;
import java.util.Random;

public class QuickSort extends AbstractSort{

    @Override
    public String getName() {
        return "QuickSort";
    }

    public QuickSort(){
        super();
    }

    @Override
    public void sortImpl(int[] array){
        quicksort(array,0,array.length-1);
    }

    public int partitionner(int[] data,int premier,int dernier){
        int pivot=read(data,dernier);
        int i=premier-1;

        for(int j=premier; j<=dernier-1;j++){
            if(isLess(read(data,j),pivot)){
                i++;
                swap(data,i,j);
            }
        }
        swap(data,i+1,dernier);
        return i+1;
    }

    public void quicksort(int[] data, int premier,int dernier){
        if(premier<dernier){
            int pivot = partitionner(data,premier,dernier);
        
            quicksort(data,premier,pivot-1);
            quicksort(data,pivot+1,dernier);
        }
    }
}