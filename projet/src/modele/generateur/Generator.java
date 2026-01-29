package generateur;

import java.util.*;
import java.util.Collections;
import java.util.Random;
import java.util.HashSet;

public class Generator{
    private int taille;
    private int[] tab;
    private int pourcentageAleatoire;
    private int desordre;

    public Generator(int taille, int pourcentageAleatoire){
        this.taille= taille;
        this.pourcentageAleatoire = pourcentageAleatoire;
    }
    public static int getNombreAleatoire(int taille, int pourcentageAleatoire){
        if(pourcentageAleatoire>100 || pourcentageAleatoire<=0){
            throw new IllegalArgumentException("illegal pourcentage");
        }
        int res =taille* pourcentageAleatoire/100;
        return res;
    }
    public static int[] generateurTab(int taille,int pourcentageAleatoire,int desordre){
        int nombreAleatoire=getNombreAleatoire(taille,pourcentageAleatoire);
        int[] tab =new int[taille];
        Random rand = new Random();

        for(int i=0;i<taille;i++){
            tab[i]=i;
        }
        if(desordre==1){
            List<Integer> tabChangement=new ArrayList<>();
            List<Integer> indices=new ArrayList<>();
            for(int i=0;i<nombreAleatoire;i++){
                int aleatoire= rand.nextInt(taille);
                while(indices.contains(aleatoire)){
                    aleatoire= rand.nextInt(taille);
                }
                indices.add(aleatoire);
                tabChangement.add(tab[aleatoire]);
            }
            MelangeurShuffle(tabChangement);
            for(int i=0;i<nombreAleatoire;i++){
                tab[indices.get(i)]=tabChangement.get(i);
            }
        }
        if(desordre==2){
            List<Integer> tabChangement=new ArrayList<>();
            for(int i=0;i<nombreAleatoire;i++){
                tabChangement.add(tab[i]);
            }
            MelangeurShuffle(tabChangement);
            for(int i=0;i<nombreAleatoire;i++){
                tab[i]=tabChangement.get(i);
            }
            
        }
        if(desordre==3){
            int debut = Math.max(0, (taille / 2) - (nombreAleatoire / 2));
            int j=0;
            List<Integer> tabChangement=new ArrayList<>();
            for(int i=0;i<nombreAleatoire;i++){
                j=debut+i;
                tabChangement.add(tab[j]);
            }
            MelangeurShuffle(tabChangement);
            for(int i=0;i<nombreAleatoire;i++){
                j=debut+i;
                tab[j]=tabChangement.get(i);
            }
            
        }
        if(desordre==4){
            int zonefin = nombreAleatoire;
            int startfin = taille - zonefin;
            int j=0;
            List<Integer> tabChangement=new ArrayList<>();
            for(int i=0;i<nombreAleatoire;i++){
                j=startfin+i;
                tabChangement.add(tab[j]);
            }
            MelangeurShuffle(tabChangement);
            for(int i=0;i<nombreAleatoire;i++){
                j=startfin+i;
                tab[j]=tabChangement.get(i);
            }
        }
        return tab;

    }
    public static void MelangeurShuffle(List tab){
        Collections.shuffle(tab);
    }
    
    private static void afficher(int[] tab){
        for(int val:tab){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println("désordre aleatoire (1) :");
        afficher(generateurTab(150,50,1));

        System.out.println("désordre début (2) :");
        afficher(generateurTab(150,50,2));

        System.out.println("désordre milieu (3) :");
        afficher(generateurTab(150,50,3));

        System.out.println("désordre fin (4) :");
        afficher(generateurTab(150,50,4));
    }

}