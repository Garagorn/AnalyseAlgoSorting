package vue.components.chart;

import java.awt.*;

public class BarLayoutCalculator {

    public Rectangle compute(
            int index, int value, int max,
            Dimension size, int count) {

        int margin = 40;
        int spacing = 2;

        int width = size.width - 2 * margin;
        int height = size.height - 2 * margin;

        int barWidth = Math.max(1, (width - (count - 1) * spacing) / count);
        int barHeight = (int) ((double) value / max * height);

        int x = margin + index * (barWidth + spacing);
        int y = size.height - margin - barHeight;

        return new Rectangle(x, y, barWidth, barHeight);
    }
}
