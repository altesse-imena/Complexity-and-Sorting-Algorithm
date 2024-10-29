package utilities.sorting;

import shapes.Shape3D;

public class BubbleSort {
    public static void sort(Shape3D[] shapes) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shapes[j].compareTo(shapes[j + 1]) > 0) {
                    Shape3D temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }
    }
}
