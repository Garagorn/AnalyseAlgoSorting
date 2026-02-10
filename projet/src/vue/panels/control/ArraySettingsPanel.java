package vue.panels.control;

import javax.swing.*;
import java.awt.*;
import controleur.SortingController;
import modele.SortingModel;

public class ArraySettingsPanel extends JPanel {

    public ArraySettingsPanel(SortingModel model, SortingController controller) {
        setLayout(new GridLayout(2, 2, 5, 5));

        JLabel sizeLabel = new JLabel("Taille: " + model.getArraySize());
        JSlider sizeSlider = new JSlider(10, 500, model.getArraySize());

        sizeSlider.addChangeListener(e -> {
            int v = sizeSlider.getValue();
            sizeLabel.setText("Taille: " + v);
            if (!sizeSlider.getValueIsAdjusting()) {
                controller.setArraySize(v);
            }
        });

        JLabel disorderLabel = new JLabel("Désordre: " + model.getDisorderPercentage() + "%");
        JSlider disorderSlider = new JSlider(0, 100, model.getDisorderPercentage());

        disorderSlider.addChangeListener(e -> {
            int v = disorderSlider.getValue();
            disorderLabel.setText("Désordre: " + v + "%");
            if (!disorderSlider.getValueIsAdjusting()) {
                controller.setDisorderPercentage(v);
            }
        });

        add(sizeLabel);
        add(sizeSlider);
        add(disorderLabel);
        add(disorderSlider);
    }
}
