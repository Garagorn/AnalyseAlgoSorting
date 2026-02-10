package controleur;

import modele.SortingModel;
import modele.sorting.*;
import javax.swing.SwingWorker;

public class SortingController {

    private final SortingModel model;
    private AbstractSort[] algorithms;

    public SortingController(SortingModel model) {
        this.model = model;
        initializeAlgorithms();
    }

    private void initializeAlgorithms() {
        algorithms = new AbstractSort[] {
            new BubbleSort(model),
            new InsertionSort(model),
            new QuickSort(model),
            new MergeSort(model),
            new CountingSort(model)
        };
    }

    public void generateNewArray() {
        model.generateNewArray();
    }

    public void resetArray() {
        model.resetArray();
    }

    public void selectAlgorithm(int index) {
        if (index >= 0 && index < algorithms.length) {
            model.setCurrentSort(algorithms[index]);
        }
    }

    public void setArraySize(int size) {
        model.setArraySize(size);
    }

    public void setDisorderPercentage(int percentage) {
        model.setDisorderPercentage(percentage);
    }

    public void setDisorderType(int type) {
        model.setDisorderType(type);
    }

    public void setVisualizationSpeed(int speed) {
        model.setVisualizationSpeed(speed);
    }

    public void togglePause() {
        model.setPaused(!model.isPaused());
    }

    public void startSorting() {
        AbstractSort sort = (AbstractSort) model.getCurrentSort();
        if (sort == null) {
            System.err.println("Aucun algorithme sélectionné !");
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                model.setIsSorting(true);
                sort.sort(model.getCurrentArray());

                
                return null;
            }

            @Override
            protected void done() {
                model.setIsSorting(false);
                model.setPaused(true);
                model.clearHighlights();
                System.out.println("Tri terminé !");
            }
        };

        worker.execute();
    }
}
