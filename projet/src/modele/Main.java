package modele;
import modele.sorting.*;

public class Main{


    public static void main(String[] args){
        int[] tab = {16,8,-7,9,3,1,23,4};

        System.out.println("avant le trie");

        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }

        Sort s = new QuickSort();
        s.sort(tab);
        System.out.println("==================================");
        System.out.println("après le tri");
        for(int i = 0 ; i < tab.length; i++){
            System.out.println("tab["+i+"] : " + tab[i]);
        }
        System.out.println("nombre d'accès : "+s.getNbrAccesses());
        System.out.println("nombre de comparaison : "+s.getNbrComparisons());
        System.out.println("nombre de swaps : "+s.getNbrSwaps());
        System.out.println("temps passé : "+s.getTimeNano()+" ns");
    }
}
