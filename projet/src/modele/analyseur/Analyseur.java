package analyseur;
import java.util.List;
import sorting.Resultat;

/**
 * Classe pour comparer  les résultats de tri
 * @author tellier212
 */
public class Analyseur{
    private List<Resultat> resultats;
    
    /**
     * 
     * @param resultats 
     */
    public Analyseur(List<Resultat> resultats){
        this.resultats= resultats;
    }

    /**
     * 
     * @return 
     */
    public List<Resultat> getResultats() {
        return resultats;
    }

    /**
     * 
     * @param resultats 
     */
    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }
    
    //Meilleur Acces
    
    //Meilleur Comparaisons
    
    //Meilleur Swaps
    
    //Meilleur Temps 

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (resultats == null || resultats.isEmpty()) {
            return "Aucun resultat";
        }
        
        Resultat infos= resultats.get(0);
        System.out.println("Taille du tab : "+infos.getTailleTab());
        System.out.println("Nombre de désordre : "+infos.getDesordre());
        System.out.println("Type de désordre : "+infos.getTypeDesordre());
         
        for(Resultat r : resultats){
            System.out.println("\n");
            System.out.println("Algo : "+r.getNomAlgo()+"\n");
            System.out.println("Acces : "+r.getNbAcces());
            System.out.println("Comparaisons : "+r.getNbComparaisons());
            System.out.println("Swaps : "+r.getNbSwap());
            System.out.println("Temps : "+r.getTemps());
        }
        return "\n";
    }
    
}
