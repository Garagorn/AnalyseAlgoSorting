package vue.components.chart;

import java.awt.*;
import modele.SortingModel;

public class OperationOverlayPainter {

    public void draw(Graphics2D g, SortingModel model, Dimension size) {
        String op = model.getCurrentOperation();
        if (op == null || op.isEmpty()) return;

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString(op.toUpperCase(), size.width - 150, 25);
    }
}
