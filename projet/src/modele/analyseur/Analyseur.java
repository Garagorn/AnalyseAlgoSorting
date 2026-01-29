package analyseur;
import java.util.*;
import sorting.Resultat;

/**
 * Classe pour comparer  les résultats de tri
 * @author tellier212
 */
public class Analyseur{
    private List<Resultat> resultats;
    
    /**
     * Constructeur de la classe
     * @param resultats 
     */
    public Analyseur(List<Resultat> resultats){
        this.resultats = resultats != null ? resultats : new ArrayList<>();
    }

    /**
     * Getter de la liste de résultat
     * @return List<Resultat>
     */
    public List<Resultat> getResultats() {
        return resultats;
    }

    /**
     * @author siaghi231
     * Ajoute un résultat à la liste.
     * 
     * @param resultat résultat à ajouter
     */
    public void ajouterResultat(Resultat resultat) {
        this.resultats.add(resultat);
    }

    /**
     * 
     * @param resultats 
     */
    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }
    
    /**
     * @return
     */
    @Override
    public String toString() {
        if (resultats == null || resultats.isEmpty()) {
            return "Aucun resultat";
        }
        
        Resultat infos= resultats.get(0);
         
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
