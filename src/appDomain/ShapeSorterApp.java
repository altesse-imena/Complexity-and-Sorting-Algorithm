package appDomain;
import shapes.*;
import utilities.sorting.*;
import utilities.sorting.ShapeComparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeSorterApp {

    public static void main(String[] args) {
        String fileName = "";
        char sortType = 'h'; // Default sort by height
        char sortAlgorithm = 'b'; // Default Bubble Sort

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i].toLowerCase()) {
                case "-f":
                    fileName = args[++i];
                    break;
                case "-t":
                    sortType = args[++i].toLowerCase().charAt(0);
                    break;
                case "-s":
                    sortAlgorithm = args[++i].toLowerCase().charAt(0);
                    break;
            }
        }

        // Load shapes from the file
        Shape3D[] shapes = loadShapesFromFile(fileName);
        if (shapes == null) {
            System.out.println("Error loading shapes from file.");
            return;
        }

        // Start sorting and timing
        long startTime = System.nanoTime();
        sortShapes(shapes, sortType, sortAlgorithm);
        long endTime = System.nanoTime();

        // Display the time taken for sorting
        System.out.println("Time taken for sorting: " + (endTime - startTime) / 1_000_000 + " ms");
        
        // Display sorted shapes
        displaySortedOutput(shapes);
    }

    private static Shape3D[] loadShapesFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int numShapes = scanner.nextInt();
            Shape3D[] shapes = new Shape3D[numShapes];
            for (int i = 0; i < numShapes; i++) {
                String shapeType = scanner.next();
                double height = scanner.nextDouble();
                double edgeOrRadius = scanner.nextDouble();

                switch (shapeType.toLowerCase()) {
                    case "cylinder":
                        shapes[i] = new Cylinder(height, edgeOrRadius);
                        break;
                    case "cone":
                        shapes[i] = new Cone(height, edgeOrRadius);
                        break;
                    case "pyramid":
                        shapes[i] = new Pyramid(height, edgeOrRadius);
                        break;
                    case "squareprism":
                        shapes[i] = new SquarePrism(height, edgeOrRadius);
                        break;
                    case "triangularprism":
                        shapes[i] = new TriangularPrism(height, edgeOrRadius);
                        break;
                    case "pentagonalprism":
                        shapes[i] = new PentagonalPrism(height, edgeOrRadius);
                        break;
                    case "octagonalprism":
                        shapes[i] = new OctagonalPrism(height, edgeOrRadius);
                        break;
                }
            }
            return shapes;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return null;
    }

    private static void sortShapes(Shape3D[] shapes, char sortType, char sortAlgorithm) {
        ShapeComparator comparator = null;

        // Set the comparison type based on sortType
        if (sortType == 'v') {
            comparator = new ShapeComparator("volume");
        } else if (sortType == 'a') {
            comparator = new ShapeComparator("baseArea");
        }

        // Choose sorting algorithm
        switch (sortAlgorithm) {
            case 'b':
                BubbleSort.sort(shapes);
                break;
            case 'i':
                InsertionSort.sort(shapes);
                break;
            case 's':
                SelectionSort.sort(shapes);
                break;
            case 'm':
                if (comparator != null) {
                    MergeSort.sort(shapes, comparator); // Use comparator if sorting by volume or base area
                } else {
                    MergeSort.sort(shapes); // Default to height
                }
                break;
            case 'q':
                if (comparator != null) {
                    QuickSort.sort(shapes, comparator);
                } else {
                    QuickSort.sort(shapes);
                }
                break;
            case 'z':
                HeapSort.sort(shapes); // Custom algorithm
                break;
            default:
                System.out.println("Invalid sorting algorithm.");
                break;
        }
    }

    private static void displaySortedOutput(Shape3D[] shapes) {
        System.out.println("First shape: " + shapes[0]);
        System.out.println("Last shape: " + shapes[shapes.length - 1]);
        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Shape at index " + i + ": " + shapes[i]);
        }
    }
}
