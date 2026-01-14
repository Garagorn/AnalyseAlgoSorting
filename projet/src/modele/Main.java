package modele;
import modele.sorting.*;

public class Main{


    public static void main(String[] args){
        int[] tab = {16,8,-7,9,3,1,23,4};

        System.out.println("avant le tri");

        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        /**
         * CountingSort
         */
        Sort s = new CountingSort();
        s.sort(tab);
        System.out.println("===============CountingSort===================");
        System.out.println("après le tri");
        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        System.out.println("nombre d'accès : "+s.getNbrAccesses());
        System.out.println("nombre de comparaison : "+s.getNbrComparisons());
        System.out.println("nombre de swaps : "+s.getNbrSwaps());
        System.out.println("temps passé : "+s.getTimeNano()+" ns");
        /**
         * QuickSort
         */
        Sort q = new QuickSort();
        q.sort(tab);
        System.out.println("=================QuickSort=================");
        System.out.println("après le tri");
        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        System.out.println("nombre d'accès : "+q.getNbrAccesses());
        System.out.println("nombre de comparaison : "+q.getNbrComparisons());
        System.out.println("nombre de swaps : "+q.getNbrSwaps());
        System.out.println("temps passé : "+q.getTimeNano()+" ns");
        /**
         * InsertionSort
         */
        Sort in = new InsertionSort();
        in.sort(tab);
        System.out.println("=================InsertionSort=================");
        System.out.println("après le tri");
        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        System.out.println("nombre d'accès : "+in.getNbrAccesses());
        System.out.println("nombre de comparaison : "+in.getNbrComparisons());
        System.out.println("nombre de swaps : "+in.getNbrSwaps());
        System.out.println("temps passé : "+in.getTimeNano()+" ns");
        /**
         * InsertionSort
         */
        Sort b = new InsertionSort();
        b.sort(tab);
        System.out.println("=================BubbleSort=================");
        System.out.println("après le tri");
        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        System.out.println("nombre d'accès : "+b.getNbrAccesses());
        System.out.println("nombre de comparaison : "+b.getNbrComparisons());
        System.out.println("nombre de swaps : "+b.getNbrSwaps());
        System.out.println("temps passé : "+b.getTimeNano()+" ns");
    }
}
