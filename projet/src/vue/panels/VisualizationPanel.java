package vue.panels;

import javax.swing.*;
import java.awt.*;
import modele.SortingModel;
import modele.event.EcouteurModele;
import controleur.SortingController;
import vue.components.*;
import vue.components.chart.ArrayBarChart;
import vue.panels.control.ControlPanel;

/**
 * Panel de visualisation du tri en temps réel
 * Layout : BorderLayout
 * - NORTH : ControlPanel (contrôles et paramètres)
 * - CENTER : ArrayBarChart (visualisation des barres)
 * - SOUTH : MetricsDisplay (métriques en temps réel)
 */
public class VisualizationPanel extends JPanel implements EcouteurModele {
    
    private SortingModel model;
    private SortingController controller;
    
    // Composants
    private ControlPanel controlPanel;
    private ArrayBarChart barChart;
    private MetricsDisplay metricsDisplay;
    
    public VisualizationPanel(SortingModel model, SortingController controller) {
        this.model = model;
        this.controller = controller;
        
        model.ajouterEcouteur(this);
        
        initializeComponents();
        setupLayout();
    }
    
    private void initializeComponents() {
        controlPanel = new ControlPanel(model, controller);
        barChart = new ArrayBarChart(model);
        metricsDisplay = new MetricsDisplay(model);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel du haut : contrôles
        add(controlPanel, BorderLayout.NORTH);
        
        // Panel central : visualisation des barres
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), 
            "Visualisation du Tableau"
        ));
        centerPanel.add(barChart, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        
        // Panel du bas : métriques
        add(metricsDisplay, BorderLayout.SOUTH);
    }
    
    @Override
    public void modeleMiseAJour(Object source) {
        // Le barChart et metricsDisplay se mettront à jour automatiquement
        // car ils sont aussi écouteurs du modèle
        repaint();
    }
}