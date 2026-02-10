package vue.components.chart;

import java.awt.*;
import modele.SortingModel;

public class BarColorResolver {

    public Color resolve(int index, SortingModel model) {
        if (index == model.getHighlightedIndex1()
         || index == model.getHighlightedIndex2()) {

            return switch (model.getCurrentOperation()) {
                case "compare" -> Color.ORANGE;
                case "swap" -> Color.GREEN;
                case "read", "access" -> Color.BLUE;
                case "sorted" -> Color.MAGENTA;
                default -> Color.GRAY;
            };
        }
        return Color.GRAY;
    }
}
