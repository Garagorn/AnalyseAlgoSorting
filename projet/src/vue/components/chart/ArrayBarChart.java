 package vue.components.chart;

import javax.swing.*;
import java.awt.*;
import modele.SortingModel;
import modele.event.EcouteurModele;

public class ArrayBarChart extends JPanel implements EcouteurModele {

    private final SortingModel model;
    private final BarLayoutCalculator layout = new BarLayoutCalculator();
    private final BarColorResolver colors = new BarColorResolver();
    private final ChartAxesPainter axes = new ChartAxesPainter();
    private final OperationOverlayPainter overlay = new OperationOverlayPainter();

    public ArrayBarChart(SortingModel model) {
        this.model = model;
        model.ajouterEcouteur(this);
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] array = model.getCurrentArray();
        if (array == null) return;

        Graphics2D g2d = (Graphics2D) g;
        int max = java.util.Arrays.stream(array).max().orElse(1);

        for (int i = 0; i < array.length; i++) {
            Rectangle r = layout.compute(i, array[i], max, getSize(), array.length);
            g2d.setColor(colors.resolve(i, model));
            g2d.fill(r);
        }

        axes.draw(g2d, getSize(), max);
        overlay.draw(g2d, model, getSize());
    }

    @Override
    public void modeleMiseAJour(Object source) {
        repaint();
    }
}
