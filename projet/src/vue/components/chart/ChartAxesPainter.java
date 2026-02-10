package vue.components.chart;

import java.awt.*;

public class ChartAxesPainter {

    public void draw(Graphics2D g, Dimension size, int max) {
        int margin = 40;

        g.setColor(Color.DARK_GRAY);
        g.drawLine(margin, margin, margin, size.height - margin);
        g.drawLine(margin, size.height - margin, size.width - margin, size.height - margin);
    }
}
