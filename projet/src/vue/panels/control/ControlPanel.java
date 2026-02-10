package vue.panels.control;

import javax.swing.*;
import java.awt.*;
import controleur.SortingController;
import modele.SortingModel;

public class ControlPanel extends JPanel {

    public ControlPanel(SortingModel model, SortingController controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Contrôles"));

        add(new AlgorithmSelectionPanel(controller));
        add(new ArraySettingsPanel(model, controller));
        add(new SpeedControlPanel(model, controller));
        add(new ExecutionControlPanel(model, controller));
    }
}
