package modele;

import modele.event.AbstractModeleEcoutable;
import modele.sorting.Sort;
import modele.generateur.Generator;
import java.util.Arrays;

/**
 * Modèle principal pour la visualisation et l'analyse des algorithmes de tri
 * Utilise le pattern Observer pour notifier les vues des changements
 */
public class SortingModel extends AbstractModeleEcoutable {
    
     

    // État du tableau
    private int[] currentArray;
    private int[] originalArray;
    
    // Paramètres de génération
    private int arraySize;
    private int disorderPercentage;
    private int disorderType; // 1-4 selon Generator
    
    // Algorithme en cours
    private Sort currentSort;
    private boolean isSorting;
    private boolean isPaused;
    
    // Vitesse de visualisation (ms entre chaque opération)
    private int visualizationSpeed;
    
    // Indices pour la visualisation
    private int highlightedIndex1 = -1;
    private int highlightedIndex2 = -1;
    private String currentOperation = ""; // "compare", "swap", "access", "write"
    
    // Métriques en temps réel
    private long currentComparisons;
    private long currentAccesses;
    private long currentSwaps;
    private long currentTime;
    
    public SortingModel() {
        this.arraySize = 50;
        this.disorderPercentage = 50;
        this.disorderType = 1;
        this.visualizationSpeed = 400; // ms
        this.isSorting = false;
        this.isPaused = false;
        generateNewArray();
    }
    
    /**
     * Génère un nouveau tableau selon les paramètres actuels
     */
    public void generateNewArray() {
        this.originalArray = Generator.generateurTab(arraySize, disorderPercentage, disorderType);
        this.currentArray = Arrays.copyOf(originalArray, originalArray.length);
        resetMetrics();
        fireChangement();
    }
    
    /**
     * Réinitialise le tableau à son état original
     */
    public void resetArray() {
        this.currentArray = Arrays.copyOf(originalArray, originalArray.length);
        resetMetrics();
        clearHighlights();
        fireChangement();
    }
    
    /**
     * Réinitialise les métriques
     */
    private void resetMetrics() {
        this.currentComparisons = 0;
        this.currentAccesses = 0;
        this.currentSwaps = 0;
        this.currentTime = 0;
    }
    
    /**
     * Efface les highlights
     */
    public void clearHighlights() {
        this.highlightedIndex1 = -1;
        this.highlightedIndex2 = -1;
        this.currentOperation = "";
    }
    
    /**
     * Met à jour la visualisation lors d'une opération
     */
    public void updateVisualization(int index1, int index2, String operation) {
        this.highlightedIndex1 = index1;
        this.highlightedIndex2 = index2;
        this.currentOperation = operation;

        if (currentSort != null) {
            this.currentComparisons = currentSort.getNbrComparisons();
            this.currentAccesses = currentSort.getNbrAccesses();
            this.currentSwaps = currentSort.getNbrSwaps();
            this.currentTime = currentSort.getTimeNano();
        }

        fireChangement();

        while (isPaused) {
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        if (isSorting) {
            try {
                Thread.sleep(visualizationSpeed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    
    // ==================== GETTERS & SETTERS ====================
    
    public int[] getCurrentArray() {
        return currentArray;
    }
    
    public int[] getOriginalArray() {
        return originalArray;
    }
    
    public int getArraySize() {
        return arraySize;
    }
    
    public void setArraySize(int size) {
        this.arraySize = size;
        generateNewArray();
    }
    
    public int getDisorderPercentage() {
        return disorderPercentage;
    }
    
    public void setDisorderPercentage(int percentage) {
        this.disorderPercentage = percentage;
        generateNewArray();
    }
    
    public int getDisorderType() {
        return disorderType;
    }
    
    public void setDisorderType(int type) {
        this.disorderType = type;
        generateNewArray();
    }
    
    public int getVisualizationSpeed() {
        return visualizationSpeed;
    }
    
    public void setVisualizationSpeed(int speed) {
        this.visualizationSpeed = speed;
    }
    
    public Sort getCurrentSort() {
        return currentSort;
    }
    
    public void setCurrentSort(Sort sort) {
        this.currentSort = sort;
    }
    
    public boolean isSorting() {
        return isSorting;
    }
    
    public void setIsSorting(boolean sorting) {
        this.isSorting = sorting;
    }
    
    public boolean isPaused() {
        return isPaused;
    }
    
    public void setPaused(boolean paused) {
        this.isPaused = paused;
    }
    
    public int getHighlightedIndex1() {
        return highlightedIndex1;
    }
    
    public int getHighlightedIndex2() {
        return highlightedIndex2;
    }
    
    public String getCurrentOperation() {
        return currentOperation;
    }
    
    public long getCurrentComparisons() {
        return currentComparisons;
    }
    
    public long getCurrentAccesses() {
        return currentAccesses;
    }
    
    public long getCurrentSwaps() {
        return currentSwaps;
    }
    
    public long getCurrentTime() {
        return currentTime;
    }
    
    public void setCurrentTime(long time) {
        this.currentTime = time;
    }
}