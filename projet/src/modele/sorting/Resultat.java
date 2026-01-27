package sorting;

/**
 * Classe pour stocker les informations de la liste et de tri
 * @author tellier212
 */
public class Resultat {
    private String nomAlgo;
    
    //Informations relatives à la liste
    private int tailleTab;
    private int desordre;
    private int typeDesordre;
    
    //Informations relatives au tri
    private int nbComparaisons;
    private int nbAcces;
    private int nbSwap;
    private long temps;

    /**
     * Constructeur de Resultat
     * 
     * @param nomAlgo nom de l'algorithme
     * @param tailleTab taille du tableau trié
     * @param desordre niveau de désordre (0.0 à 1.0)
     * @param typeDesordre type de désordre/pattern
     * @param nbComparaisons nombre de comparaisons effectuées
     * @param nbAcces nombre d'accès mémoire
     * @param nbSwap nombre d'échanges
     * @param temps temps d'exécution en nanosecondes
     */
    public Resultat(String nomAlgo, int tailleTab, int desordre,
                    int typeDesordre, int nbComparaisons, int nbAcces, int nbSwap, long temps) {
        this.nomAlgo = nomAlgo;
        this.tailleTab = tailleTab;
        this.desordre = desordre;
        this.typeDesordre = typeDesordre;
        this.nbComparaisons = nbComparaisons;
        this.nbAcces = nbAcces;
        this.nbSwap = nbSwap;
        this.temps = temps;
    }

    //- - - Getters - - -
    
    /**
     * Obtenir le nom de l'algorithme
     * @return String nom de l'algo
     */
    public String getNomAlgo() {
        return nomAlgo;
    }

    /**
     * Obtenir la taille de la liste
     * @return Int Taille du liste
     */
    public int getTailleTab() {
        return tailleTab;
    }

    /**
     * Obtenir la quantite de desordre de la liste
     * @return Int Desordre de la liste
     */
    public int getDesordre() {
        return desordre;
    }

    /**
     * Obtenir le type de desordre de la liste
     * @return Int Type de desordre
     */
    public int getTypeDesordre() {
        return typeDesordre;
    }

    /**
     * @author siaghi231
     * Retourne le temps en millisecondes.
     * 
     * @return temps en millisecondes
     */
    public double getTempsMs() {
        return temps / 1_000_000.0;
    }
    /**
     * @author siaghi231
     * Retourne le temps en microsecondes.
     * 
     * @return temps en microsecondes
     */
    public double getTempsMicros() {
        return temps / 1_000.0;
    }

    /**
     * Obtenir le nombre de comparaisons de l'algo
     * @return Int NbComparaisons
     */
    public int getNbComparaisons() {
        return nbComparaisons;
    }

    /**
     * Obtenir le nombre d'accces à la liste
     * @return Int NbAcces
     */
    public int getNbAcces() {
        return nbAcces;
    }

    /**
     * Obtenir le nombre de swap dans la liste
     * @return IntNbSwap
     */
    public int getNbSwap() {
        return nbSwap;
    }

    /**
     * Obtenir le temps d'execution
     * @return Long temps d'execition
     */
    public long getTemps() {
        return temps;
    }
    
    /**
     * @author siaghi231
     * Retourne une représentation formatée du résultat.
     * 
     * @return chaîne formatée avec les métriques
     */
    @Override
    public String toString() {
        return String.format(
            "%-15s | Comp: %,10d | Accès: %,10d | Swaps: %,8d | Temps: %,8.3f ms",
            nomAlgo, nbComparaisons, nbAcces, nbSwap, getTempsMs()
        );
    }
    
}
