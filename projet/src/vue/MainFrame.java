package vue;

import javax.swing.*;
import java.awt.*;
import vue.panels.VisualizationPanel; 
import vue.panels.AnalysisPanel;
import vue.panels.control.ControlPanel;
import controleur.SortingController;
import modele.SortingModel;

/**
 * Fenêtre principale de l'application
 * Contient deux onglets : Visualisation et Analyse
 */
public class MainFrame extends JFrame {
    
    private SortingModel model;
    private SortingController controller;
    
    // Panels principaux
    private VisualizationPanel visualizationPanel;
    private AnalysisPanel analysisPanel;
    
    // Onglets
    private JTabbedPane tabbedPane;
    
    public MainFrame(SortingModel model, SortingController controller) {
        this.model = model;
        this.controller = controller;
        
        initializeComponents();
        setupLayout();
        setupFrame();
    }
    
    private void initializeComponents() {
        // Créer les panels
        visualizationPanel = new VisualizationPanel(model, controller);
        analysisPanel = new AnalysisPanel(model, controller);
        
        // Créer le TabbedPane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));
        
        // Ajouter les onglets avec des icônes (optionnel)
        tabbedPane.addTab("Visualisation", visualizationPanel);
        tabbedPane.addTab("Analyse", analysisPanel);
        
        // Tooltip pour chaque onglet
        tabbedPane.setToolTipTextAt(0, "Visualiser le tri en temps réel");
        tabbedPane.setToolTipTextAt(1, "Analyser et comparer les performances");
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void setupFrame() {
        setTitle("Analyseur d'Algorithmes de Tri");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setMinimumSize(new Dimension(1000, 700));
        setLocationRelativeTo(null); // Centrer la fenêtre
        
        // Icône de l'application (optionnel)
        // setIconImage(new ImageIcon("icon.png").getImage());
    }
    
    public VisualizationPanel getVisualizationPanel() {
        return visualizationPanel;
    }
    
    public AnalysisPanel getAnalysisPanel() {
        return analysisPanel;
    }
    
    public void switchToVisualization() {
        tabbedPane.setSelectedIndex(0);
    }
    
    public void switchToAnalysis() {
        tabbedPane.setSelectedIndex(1);
    }
}