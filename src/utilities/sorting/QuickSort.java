package utilities.sorting;
import java.util.Comparator;
import shapes.Shape3D;

public class QuickSort {

    
    public static void sort(Shape3D[] shapes) {
        quickSort(shapes, 0, shapes.length - 1);
    }

    
    public static void sort(Shape3D[] shapes, Comparator<Shape3D> comparator) {
        quickSort(shapes, 0, shapes.length - 1, comparator);
    }

    
    private static void quickSort(Shape3D[] shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);
            quickSort(shapes, low, pi - 1);
            quickSort(shapes, pi + 1, high);
        }
    }

    
    private static void quickSort(Shape3D[] shapes, int low, int high, Comparator<Shape3D> comparator) {
        if (low < high) {
            int pi = partition(shapes, low, high, comparator);
            quickSort(shapes, low, pi - 1, comparator);
            quickSort(shapes, pi + 1, high, comparator);
        }
    }

    
    private static int partition(Shape3D[] shapes, int low, int high) {
        Shape3D pivot = shapes[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (shapes[j].compareTo(pivot) <= 0) {
                i++;
                Shape3D temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
            }
        }
        Shape3D temp = shapes[i + 1];
        shapes[i + 1] = shapes[high];
        shapes[high] = temp;
        return i + 1;
    }

    
    private static int partition(Shape3D[] shapes, int low, int high, Comparator<Shape3D> comparator) {
        Shape3D pivot = shapes[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(shapes[j], pivot) <= 0) {
                i++;
                Shape3D temp = shapes[i];
                shapes[i] = shapes[j];
                shapes[j] = temp;
            }
        }
        Shape3D temp = shapes[i + 1];
        shapes[i + 1] = shapes[high];
        shapes[high] = temp;
        return i + 1;
    }
}
