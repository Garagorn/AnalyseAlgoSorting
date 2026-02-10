package vue.panels.control;

import javax.swing.*;
import java.awt.*;
import controleur.SortingController;
import modele.SortingModel;

public class ExecutionControlPanel extends JPanel {

    public ExecutionControlPanel(SortingModel model, SortingController controller) {
        setLayout(new GridLayout(1, 4, 5, 5));

        JButton start = new JButton("▶ Démarrer");
        JButton pause = new JButton("⏸ Pause");
        JButton reset = new JButton("⟲ Reset");
        JButton generate = new JButton("Nouveau");
        
        pause.setEnabled(false);

        start.addActionListener(e -> {
            controller.startSorting();
            start.setEnabled(false);
            pause.setEnabled(true);
        });

        pause.addActionListener(e -> {
            controller.togglePause();
            pause.setText(model.isPaused() ? "▶ Reprendre" : "⏸ Pause");
        });

        reset.addActionListener(e -> {
            controller.resetArray();
            start.setEnabled(true);
            pause.setEnabled(false);
            pause.setText("⏸ Pause");
        });
        
        generate.addActionListener(e -> controller.generateNewArray());

        add(start);
        add(pause);
        add(reset);
        add(generate);
    }
}
