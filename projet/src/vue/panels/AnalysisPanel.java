package vue.panels;

import javax.swing.*;
import java.awt.*;
import modele.SortingModel;
import modele.event.EcouteurModele;
import controleur.SortingController;
import vue.components.ComparisonChart;

/**
 * Panel d'analyse et de comparaison des algorithmes
 * Permet de lancer des benchmarks et de visualiser les résultats
 */
public class AnalysisPanel extends JPanel implements EcouteurModele {
    
    private SortingModel model;
    private SortingController controller;

    public AnalysisPanel(SortingModel model, SortingController controller) {
        this.model = model;
        this.controller = controller;
        
        model.ajouterEcouteur(this);
        
    }
    @Override
    public void modeleMiseAJour(Object source){
        return;
    }
}