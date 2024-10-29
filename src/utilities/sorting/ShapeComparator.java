package utilities.sorting;

import shapes.Shape3D;
import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape3D> {
    private String compareBy;

    public ShapeComparator(String compareBy) {
        this.compareBy = compareBy;
    }

    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        if (compareBy.equals("volume")) {
            return Double.compare(shape1.getVolume(), shape2.getVolume());
        } else if (compareBy.equals("baseArea")) {
            return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
        }
        return 0;
    }
}
