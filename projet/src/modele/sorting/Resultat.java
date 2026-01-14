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
     * 
     * @param nomAlgo
     * @param tailleTab
     * @param desordre
     * @param typeDesordre
     * @param nbComparaisons
     * @param nbAcces
     * @param nbSwap
     * @param temps 
     */
    public Resultat(String nomAlgo, int tailleTab, int desordre, int typeDesordre, int nbComparaisons, int nbAcces, int nbSwap, long temps) {
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
    
    
}
