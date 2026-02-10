package vue.panels.control;

import javax.swing.*;
import java.awt.*;
import controleur.SortingController;

public class AlgorithmSelectionPanel extends JPanel {

    public AlgorithmSelectionPanel(SortingController controller) {
        setLayout(new GridLayout(2, 2, 5, 5));

        JComboBox<String> algorithmBox = new JComboBox<>(new String[]{
            "Bubble Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Counting Sort"
        });

        JComboBox<String> disorderBox = new JComboBox<>(new String[]{
            "Aléatoire", "Début", "Milieu", "Fin"
        });

        algorithmBox.addActionListener(e ->
            controller.selectAlgorithm(algorithmBox.getSelectedIndex())
        );

        disorderBox.addActionListener(e ->
            controller.setDisorderType(disorderBox.getSelectedIndex() + 1)
        );

        add(new JLabel("Algorithme :"));
        add(algorithmBox);
        add(new JLabel("Type de désordre :"));
        add(disorderBox);
    }
}
