package sorting;

/**
 * @author siaghi231
 * Implémentation de l'algorithme Merge Sort (Tri Fusion)
 * 
 * Complexité temporelle:
 *   - Meilleur cas: O(n log n)
 *   - Cas moyen: O(n log n)
 *   - Pire cas: O(n log n)
 * 
 * Complexité spatiale: O(n)
 * 
 * Stable: Oui
 * En place: Non (nécessite un tableau auxiliaire)
 * 
 * Avantages:
 *   - Performances prévisibles et constantes O(n log n)
 *   - Stable (conserve l'ordre relatif des éléments égaux)
 *   - Excellent pour les grandes données
 *   - Parallélisable facilement
 * 
 * Inconvénients:
 *   - Nécessite O(n) espace mémoire supplémentaire
 *   - Overhead de gestion de la récursion
 *   - Pas optimal pour petits tableaux
 */
public class MergeSort extends AbstractSort {
    
    @Override
    public String getName() {
        return "MergeSort";
    }
    
    @Override
    protected void sortImpl(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        // Appel de la fonction récursive
        mergeSort(array, 0, array.length - 1);
    }
    
    /**
     * Fonction récursive principale du tri fusion
     * 
     * @param array Le tableau à trier
     * @param left L'indice de début
     * @param right L'indice de fin
     */
    private void mergeSort(int[] array, int left, int right) {
        // Cas de base : un seul élément ou segment vide
        if (left >= right) {
            return;
        }
        
        // Trouver le milieu pour diviser le tableau
        int mid = left + (right - left) / 2;
        
        // Trier récursivement la première moitié
        mergeSort(array, left, mid);
        
        // Trier récursivement la seconde moitié
        mergeSort(array, mid + 1, right);
        
        // Fusionner les deux moitiés triées
        merge(array, left, mid, right);
    }
    
    /**
     * Fusionne deux sous-tableaux triés en un seul tableau trié
     * 
     * @param array Le tableau contenant les deux sous-tableaux
     * @param left L'indice de début du premier sous-tableau
     * @param mid L'indice de fin du premier sous-tableau
     * @param right L'indice de fin du second sous-tableau
     */
    private void merge(int[] array, int left, int mid, int right) {
        // Calculer les tailles des deux sous-tableaux
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Créer des tableaux temporaires
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < n1; i++) {
            leftArray[i] = read(array, left + i);
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = read(array, mid + 1 + j);
        }
        
        // Indices pour parcourir les tableaux
        int i = 0;  // Indice pour leftArray
        int j = 0;  // Indice pour rightArray
        int k = left;  // Indice pour le tableau fusionné
        
        // Fusionner les tableaux temporaires dans array[left..right]
        while (i < n1 && j < n2) {
            // Comparer les éléments et prendre le plus petit
            if (isLess(leftArray[i], rightArray[j]) || leftArray[i] == rightArray[j]) {
                write(array, k, leftArray[i]);
                i++;
            } else {
                write(array, k, rightArray[j]);
                j++;
            }
            k++;
        }
        
        // Copier les éléments restants de leftArray (s'il y en a)
        while (i < n1) {
            write(array, k, leftArray[i]);
            i++;
            k++;
        }
        
        // Copier les éléments restants de rightArray (s'il y en a)
        while (j < n2) {
            write(array, k, rightArray[j]);
            j++;
            k++;
        }
    }
}
