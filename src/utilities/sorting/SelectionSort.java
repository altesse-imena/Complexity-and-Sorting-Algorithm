package utilities.sorting;

import shapes.Shape3D;

public class SelectionSort {
    public static void sort(Shape3D[] shapes) {
        for (int i = 0; i < shapes.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[j].compareTo(shapes[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Shape3D temp = shapes[minIndex];
            shapes[minIndex] = shapes[i];
            shapes[i] = temp;
        }
    }
}
