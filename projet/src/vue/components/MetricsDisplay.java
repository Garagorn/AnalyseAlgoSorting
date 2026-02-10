package vue.components;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import modele.SortingModel;
import modele.event.EcouteurModele;

/**
 * Panneau d'affichage des métriques en temps réel
 * Affiche : Comparaisons, Accès, Swaps, Temps
 */
public class MetricsDisplay extends JPanel implements EcouteurModele {
    
    private SortingModel model;
    
    // Labels pour afficher les valeurs
    private JLabel comparisonsValue;
    private JLabel accessesValue;
    private JLabel swapsValue;
    private JLabel timeValue;
    private JLabel algorithmName;
    
    // Panneaux pour chaque métrique
    private JPanel comparisonsPanel;
    private JPanel accessesPanel;
    private JPanel swapsPanel;
    private JPanel timePanel;
    
    public MetricsDisplay(SortingModel model) {
        this.model = model;
        model.ajouterEcouteur(this);
        
        initializeComponents();
        setupLayout();
        updateMetrics();
    }
    
    private void initializeComponents() {
        // Nom de l'algorithme
        algorithmName = new JLabel("Aucun algorithme sélectionné");
        algorithmName.setFont(new Font("Arial", Font.BOLD, 16));
        algorithmName.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Labels pour les valeurs
        comparisonsValue = new JLabel("0");
        accessesValue = new JLabel("0");
        swapsValue = new JLabel("0");
        timeValue = new JLabel("0 ms");
        
        // Style pour les valeurs
        Font valueFont = new Font("Arial", Font.BOLD, 24);
        comparisonsValue.setFont(valueFont);
        accessesValue.setFont(valueFont);
        swapsValue.setFont(valueFont);
        timeValue.setFont(valueFont);
        
        // Créer les panneaux pour chaque métrique
        comparisonsPanel = createMetricPanel("Comparaisons", comparisonsValue, new Color(255, 152, 0));
        accessesPanel = createMetricPanel("Accès", accessesValue, new Color(33, 150, 243));
        swapsPanel = createMetricPanel("Échanges", swapsValue, new Color(76, 175, 80));
        timePanel = createMetricPanel("Temps", timeValue, new Color(156, 39, 176));
    }
    
    /**
     * Crée un panneau pour une métrique spécifique
     */
    private JPanel createMetricPanel(String title, JLabel valueLabel, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);
        panel.setBorder(new CompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        
        // Titre
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(color);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Valeur
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setForeground(color);
        
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        setBorder(new CompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                "Métriques en Temps Réel"
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        // Panneau du haut : nom de l'algorithme
        add(algorithmName, BorderLayout.NORTH);
        
        // Panneau central : grille de métriques
        JPanel metricsGrid = new JPanel(new GridLayout(1, 4, 10, 10));
        metricsGrid.setOpaque(false);
        metricsGrid.add(comparisonsPanel);
        metricsGrid.add(accessesPanel);
        metricsGrid.add(swapsPanel);
        metricsGrid.add(timePanel);
        
        add(metricsGrid, BorderLayout.CENTER);
    }
    
    /**
     * Met à jour l'affichage des métriques
     */
    private void updateMetrics() {
        // Nom de l'algorithme
        if (model.getCurrentSort() != null) {
            algorithmName.setText(model.getCurrentSort().getName());
        } else {
            algorithmName.setText("Aucun algorithme sélectionné");
        }
        
        // Valeurs des métriques
        comparisonsValue.setText(formatNumber(model.getCurrentComparisons()));
        accessesValue.setText(formatNumber(model.getCurrentAccesses()));
        swapsValue.setText(formatNumber(model.getCurrentSwaps()));
        
        // Temps en millisecondes
        double timeMs = model.getCurrentTime() / 1_000_000.0;
        timeValue.setText(String.format("%.2f ms", timeMs));
    }
    
    /**
     * Formate un nombre avec des séparateurs de milliers
     */
    private String formatNumber(long number) {
        return String.format("%,d", number);
    }
    
    @Override
    public void modeleMiseAJour(Object source) {
        //System.out.println(model.getCurrentTime()+"secoffdfbg");
        updateMetrics();
    }
}