package modele;

import javax.swing.*;
import modele.SortingModel;
import controleur.SortingController;
import vue.MainFrame;

/**
 * Point d'entrée de l'application d'analyse d'algorithmes de tri
 */
public class Main {
    
    public static void main(String[] args) {
        // Utiliser le Look and Feel du système
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si échec, utiliser le Look and Feel par défaut
            e.printStackTrace();
        }
        
        // Lancer l'interface sur l'Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Créer le modèle
            SortingModel model = new SortingModel();
            
            // Créer le contrôleur
            SortingController controller = new SortingController(model);
            
            // Créer et afficher la fenêtre principale
            MainFrame frame = new MainFrame(model, controller);
            frame.setVisible(true);
            
            System.out.println("Application démarrée avec succès!");
        });
    }
}