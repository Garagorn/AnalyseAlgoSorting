import generateur.generator;
import modele.sorting.*;
import java.util.*;
/**
 *
 * @author tellier212
 */
public class MainTest {
    
    private static boolean isSorted(int[] tab){
        for(int i = 0; i < tab.length - 1; i++){
            if(tab[i] > tab[i + 1]){
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args){
    //Arguments : Taille Desordre typeDesordre
    
        if(args.length > 3){
            System.out.println("Il y a trop d'arguments");
            
        }
        if(args.length < 3){
            System.out.println("Il manque des arguements");
        }

        int taille = Integer.parseInt(args[0]);
        int pourcentage = Integer.parseInt(args[1]);
        int typeDesordre = Integer.parseInt(args[2]);

        int[] tab = generator.tabgenererPourcentage(taille,pourcentage,typeDesordre);
        
        // - - - Tris du tableau - - -
        /**
         * CountingSort
         */
        int[] tabCopie1 = Arrays.copyOf(tab, tab.length);
        Sort s = new CountingSort();
        s.sort(tabCopie1);
        if(isSorted(tabCopie1)){ 
            System.out.println("[csv] "+s.getName()+","+s.getNbrAccesses()+","+s.getNbrComparisons()+","+s.getNbrSwaps()+","+s.getTimeNano());
        }
            
        /**
         * QuickSort
         */
        int[] tabCopie2 = Arrays.copyOf(tab, tab.length);
        Sort q = new QuickSort();
        q.sort(tabCopie2);
        if(isSorted(tabCopie2)){
            System.out.println("[csv] "+q.getName()+","+q.getNbrAccesses()+","+q.getNbrComparisons()+","+q.getNbrSwaps()+","+q.getTimeNano());
        }

        /**
         * InsertionSort
         */
        int[] tabCopie3 = Arrays.copyOf(tab, tab.length);
        Sort in = new InsertionSort();
        in.sort(tabCopie3);
        if(isSorted(tabCopie3)){
            System.out.println("[csv] "+in.getName()+","+in.getNbrAccesses()+","+in.getNbrComparisons()+","+in.getNbrSwaps()+","+in.getTimeNano());
        }

        /**
         * BubbleSort
         */
        int[] tabCopie4 = Arrays.copyOf(tab, tab.length);
        Sort b = new BubbleSort();
        b.sort(tabCopie4);
        if(isSorted(tabCopie4)){
            System.out.println("[csv] "+b.getName()+","+b.getNbrAccesses()+","+b.getNbrComparisons()+","+b.getNbrSwaps()+","+b.getTimeNano());
        }
            
        /**
         * MergeSort
         */
        int[] tabCopie5 = Arrays.copyOf(tab, tab.length);
        Sort m = new MergeSort();
        m.sort(tabCopie5);
        if(isSorted(tabCopie5)){
            System.out.println("[csv] "+m.getName()+","+m.getNbrAccesses()+","+m.getNbrComparisons()+","+m.getNbrSwaps()+","+m.getTimeNano());
        }
    }
}
