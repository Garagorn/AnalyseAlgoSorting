import java.util.*;

import generateur.Generator;
import sorting.*;

public class Main{

    private static boolean isSorted(int[] tab){
        for(int i = 0; i < tab.length - 1; i++){
            if(tab[i] > tab[i + 1]){
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args){

        int[] tabOriginal = Generator.generateurTab(150, 50, 1);
        System.out.println("Resultat | Nom | Acces | Comparaisons | Swaps | Temps");
        /**
         * CountingSort
         */
        int[] tabCopie1 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort s = new CountingSort();
        s.sort(tabCopie1);
        if(isSorted(tabCopie1)){ 
            System.out.println("Resultat : "+s.getName()+","+s.getNbrAccesses()+","+s.getNbrComparisons()+","+s.getNbrSwaps()+","+s.getTimeNano());
        }
        else{
            System.out.println("Tableau non trié"+s.getName());
        }
        
        /**
         * QuickSort
         */
        int[] tabCopie2 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort q = new QuickSort();
        q.sort(tabCopie2);
        if(isSorted(tabCopie2)){ 
            System.out.println("Resultat : "+q.getName()+","+q.getNbrAccesses()+","+q.getNbrComparisons()+","+q.getNbrSwaps()+","+q.getTimeNano());
        }
        else{
            System.out.println("Tableau non trié"+q.getName());
        }

        /**
         * InsertionSort
         */
        int[] tabCopie3 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort in = new InsertionSort();
        in.sort(tabCopie3);
        if(isSorted(tabCopie3)){ 
            System.out.println("Resultat : "+in.getName()+","+in.getNbrAccesses()+","+in.getNbrComparisons()+","+in.getNbrSwaps()+","+in.getTimeNano());
        }
        else{
            System.out.println("Tableau non trié"+in.getName());
        }

        /**
         * BubbleSort
         */
        int[] tabCopie4 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort b = new BubbleSort();
        b.sort(tabCopie4);
        if(isSorted(tabCopie4)){ 
            System.out.println("Resultat : "+b.getName()+","+b.getNbrAccesses()+","+b.getNbrComparisons()+","+b.getNbrSwaps()+","+b.getTimeNano());
        }
        else{
            System.out.println("Tableau non trié"+in.getName());
        }
        /**
         * MergeSort
         */
        int[] tabCopie5 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort m = new InsertionSort();
        m.sort(tabCopie5);
        if(isSorted(tabCopie5)){ 
            System.out.println("Resultat : "+m.getName()+","+m.getNbrAccesses()+","+m.getNbrComparisons()+","+m.getNbrSwaps()+","+m.getTimeNano());
        }
        else{
            System.out.println("Tableau non trié"+m.getName());
        }
    }
}
