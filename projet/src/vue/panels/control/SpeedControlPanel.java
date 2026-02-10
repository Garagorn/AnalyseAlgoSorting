package vue.panels.control;

import javax.swing.*;
import java.awt.*;
import controleur.SortingController;
import modele.SortingModel;

public class SpeedControlPanel extends JPanel {

    public SpeedControlPanel(SortingModel model, SortingController controller) {
        setLayout(new BorderLayout(5, 5));

        JLabel label = new JLabel("Vitesse: " + model.getVisualizationSpeed() + " ms");
        JSlider slider = new JSlider(10, 500, model.getVisualizationSpeed());

        slider.addChangeListener(e -> {
            int v = slider.getValue();
            label.setText("Vitesse: " + v + " ms");
            controller.setVisualizationSpeed(v);
        });

        add(label, BorderLayout.WEST);
        add(slider, BorderLayout.CENTER);
    }
}
