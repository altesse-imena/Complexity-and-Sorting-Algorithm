package utilities.sorting;

import shapes.Shape3D;

public class HeapSort {
    public static void sort(Shape3D[] shapes) {
        int n = shapes.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(shapes, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            Shape3D temp = shapes[0];
            shapes[0] = shapes[i];
            shapes[i] = temp;

            heapify(shapes, i, 0);
        }
    }

    private static void heapify(Shape3D[] shapes, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && shapes[left].compareTo(shapes[largest]) > 0) {
            largest = left;
        }

        if (right < n && shapes[right].compareTo(shapes[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            Shape3D swap = shapes[i];
            shapes[i] = shapes[largest];
            shapes[largest] = swap;

            heapify(shapes, n, largest);
        }
    }
}
