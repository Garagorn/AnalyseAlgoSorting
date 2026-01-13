package generateur;

import java.util.Random;

public class generator{
    private int taille;
    private int[] tab;
    private int pourcentagealeatoire;
    private int desordre;

    public generator(int taille, int pourcentagealeatoire){
        this.taille= taille;
        this.pourcentagealeatoire = pourcentagealeatoire;
    }
    public int getnombrealeatoire(int taille, int pourcentagealeatoire){
        if(pourcentagealeatoire==0){
            return 0;
        }
        if(pourcentagealeatoire>100){
            return 0;
        }
        int res =taille*(1-pourcentagealeatoire/100);
        return res;
    }
    public static int[] tabgenerersimple(int taille,int nombrealeatoire,int desordre){
        int[] tab =new int[taille];
        Random rand = new Random();
        for(int i=0;i<taille;i++){
            tab[i]=i;
        }
        if(desordre==1){
            for( int i=0; i<nombrealeatoire;i++){
                int ind1 = rand.nextInt(taille);
                int ind2 = rand.nextInt(taille);
                echange(tab,ind1,ind2);
            }

        }
        if(desordre==2){
            int zonedebut=nombrealeatoire;
            for( int i=0; i<nombrealeatoire;i++){
                int ind1 = rand.nextInt(nombrealeatoire);
                int ind2 = rand.nextInt(nombrealeatoire);
                echange(tab,ind1,ind2);
            }
            
        }
        if(desordre==3){
            int debut=Math.max(0,(taille/2)-(nombrealeatoire/2));
            int fin=Math.min(taille,debut+nombrealeatoire);
            for( int i=0; i<nombrealeatoire;i++){
                int ind1 = debut+rand.nextInt(fin-debut);
                int ind2 = debut+rand.nextInt(fin-debut);
                echange(tab,ind1,ind2);
            }
            
        }
        if(desordre==4){
            int zonefin=nombrealeatoire;
            int startfin= taille-zonefin;
            for( int i=0; i<nombrealeatoire;i++){
                int ind1 = startfin+rand.nextInt(zonefin);
                int ind2 = startfin+rand.nextInt(zonefin);
                echange(tab,ind1,ind2);
            }
            
        }
        return tab;

    }
    public static void echange(int[] tab, int i, int j){
        int temp= tab[i];
        tab[i]=tab[j];
        tab[j]=temp;
    }
    private static void afficher(int[] tab){
        for(int val:tab){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println("désordre aleatoire (1) :");
        afficher(tabgenerersimple(150,50,1));

        System.out.println("désordre début (2) :");
        afficher(tabgenerersimple(150,50,2));

        System.out.println("désordre milieu (3) :");
        afficher(tabgenerersimple(150,50,3));

        System.out.println("désordre fin (4) :");
        afficher(tabgenerersimple(150,50,4));
    }

}