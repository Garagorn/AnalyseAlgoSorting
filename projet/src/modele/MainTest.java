import generateur.generator;
/**
 *
 * @author tellier212
 */
public class MainTest {
    
    
    public static void main(String[] args){
    //Arguments : Taille Desordre typeDesordre ?CSV?
    
        if(args.length > 3){
            System.out.println("Il y a trop d'arguments");
        }
        if(3 == args.length){
            int taille = Integer.parseInt(args[0]);
            int desordre = Integer.parseInt(args[1]);
            int typeDesordre = Integer.parseInt(args[2]);
            //String fichier = args[3];
            System.out.println("Taille : "+ taille);
            System.out.println("Desordre  : "+ desordre);
            System.out.println("Type de desordre : "+ typeDesordre);
            //System.out.println("Fchier : "+ fichier);
            int[] tab = generator.tabgenerersimple(taille,desordre,typeDesordre);
            for(int i=0;i<tab.length;i++){
                System.out.println(tab[i]);
            }
        }
        if(args.length < 3){
            System.out.println("Il manque des arguements");
        }
    }
}
