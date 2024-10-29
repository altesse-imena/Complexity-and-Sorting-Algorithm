package utilities.sorting;

import shapes.Shape3D;

public class InsertionSort {
    public static void sort(Shape3D[] shapes) {
        for (int i = 1; i < shapes.length; i++) {
            Shape3D key = shapes[i];
            int j = i - 1;
            while (j >= 0 && shapes[j].compareTo(key) > 0) {
                shapes[j + 1] = shapes[j];
                j--;
            }
            shapes[j + 1] = key;
        }
    }
}
