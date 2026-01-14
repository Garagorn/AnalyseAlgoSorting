package modele;

import java.util.*;

import generateur.generator;
import modele.sorting.*;
import sorting.Resultat;
import analyseur.Analyseur;

public class Main{


    public static void main(String[] args){
        /*
        Scanner scanner = new Scanner(System.in);        
        
        System.out.println("Taille de la liste à trier : ");
        int taille = scanner.nextInt();
        
        System.out.println("Nombre de desordre : ");
        int desordre = scanner.nextInt();
        
        System.out.println("Type de desordre (1-Aleatoire) (2-Debut) (3-Milieu) (4-Fin) : ");
        int typeDesordre = scanner.nextInt();
        
        int[] tabOriginal = generator.tabgenerersimple(taille, desordre, typeDesordre);
        */
        int taille = 150;
        int desordre = 50;
        int typeDesordre = 1;
        int[] tabOriginal = generator.tabgenerersimple(150, 50, 1);
        List<Resultat> resultats = new ArrayList<>();
        
        /**
         * CountingSort
         */
        int[] tabCopie1 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort s = new CountingSort();
        s.sort(tabCopie1);
        //Verification tri
        resultats.add(new Resultat(s.getName(),taille,desordre,typeDesordre,s.getNbrAccesses(),s.getNbrComparisons(), s.getNbrSwaps(),s.getTimeNano()));
        
        /**
         * QuickSort
         */
        int[] tabCopie2 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort q = new QuickSort();
        q.sort(tabCopie2);
        //Verification tri
        resultats.add(new Resultat(q.getName(),taille,desordre,typeDesordre,q.getNbrAccesses(),q.getNbrComparisons(), q.getNbrSwaps(),q.getTimeNano()));
        /**
         * InsertionSort
         */
        int[] tabCopie3 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort in = new InsertionSort();
        in.sort(tabCopie3);
        //Verification tri
        resultats.add(new Resultat(in.getName(),taille,desordre,typeDesordre,in.getNbrAccesses(),in.getNbrComparisons(), in.getNbrSwaps(),in.getTimeNano()));

        /**
         * BubbleSort
         */
        int[] tabCopie4 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort b = new BubbleSort();
        b.sort(tabCopie4);
        //Verification tri
        resultats.add(new Resultat(b.getName(),taille,desordre,typeDesordre,b.getNbrAccesses(),b.getNbrComparisons(), b.getNbrSwaps(),b.getTimeNano()));
        /**
         * MergeSort
        int[] tabCopie5 = Arrays.copyOf(tabOriginal, tabOriginal.length);
        Sort m = new InsertionSort();
        m.sort(tabCopie5);
        //Verification tri
        resultats.add(new Resultat(m.getName(),taille,desordre,typeDesordre,m.getNbrAccesses(),m.getNbrComparisons(), m.getNbrSwaps(),m.getTimeNano()));
        */
        
        
        Analyseur analyse=new Analyseur(resultats);
        System.out.println(analyse);
    }
}
