package utilities.sorting;

import java.util.Comparator;
import shapes.Shape3D;

public class MergeSort {

    
    public static void sort(Shape3D[] shapes) {
        if (shapes.length < 2) return;
        int mid = shapes.length / 2;
        Shape3D[] left = new Shape3D[mid];
        Shape3D[] right = new Shape3D[shapes.length - mid];

        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        sort(left);
        sort(right);
        merge(shapes, left, right);
    }

    
    public static void sort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        if (shapes.length < 2) return;
        int mid = shapes.length / 2;
        Shape3D[] left = new Shape3D[mid];
        Shape3D[] right = new Shape3D[shapes.length - mid];

        System.arraycopy(shapes, 0, left, 0, mid);
        System.arraycopy(shapes, mid, right, 0, shapes.length - mid);

        sort(left, comparator);
        sort(right, comparator);
        merge(shapes, left, right, comparator);
    }

    
    private static void merge(Shape3D[] shapes, Shape3D[] left, Shape3D[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                shapes[k++] = left[i++];
            } else {
                shapes[k++] = right[j++];
            }
        }
        while (i < left.length) shapes[k++] = left[i++];
        while (j < right.length) shapes[k++] = right[j++];
    }

    
    private static void merge(Shape3D[] shapes, Shape3D[] left, Shape3D[] right, Comparator<Shape3D> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                shapes[k++] = left[i++];
            } else {
                shapes[k++] = right[j++];
            }
        }
        while (i < left.length) shapes[k++] = left[i++];
        while (j < right.length) shapes[k++] = right[j++];
    }
}
