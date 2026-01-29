package sorting;

/**
 * Classe pour stocker les informations de la liste et de tri
 * @author tellier212
 */
public class Resultat {
    private String nomAlgo;
    
    //Informations relatives au tri
    private long nbComparaisons;
    private long nbAcces;
    private long nbSwap;
    private long temps;

    /**
     * Constructeur de Resultat
     * 
     * @param nomAlgo nom de l'algorithme
     * @param nbComparaisons nombre de comparaisons effectuées
     * @param nbAcces nombre d'accès mémoire
     * @param nbSwap nombre d'échanges
     * @param temps temps d'exécution en nanosecondes
     */
    public Resultat(String nomAlgo, long nbComparaisons, long nbAcces, long nbSwap, long temps) {
        this.nomAlgo = nomAlgo;
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
    public long getNbComparaisons() {
        return nbComparaisons;
    }

    /**
     * Obtenir le nombre d'accces à la liste
     * @return Int NbAcces
     */
    public long getNbAcces() {
        return nbAcces;
    }

    /**
     * Obtenir le nombre de swap dans la liste
     * @return IntNbSwap
     */
    public long getNbSwap() {
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
