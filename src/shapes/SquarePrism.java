package shapes;

public class SquarePrism extends Shape3D {
    private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    @Override
    protected double calculateBaseArea() {
        return Math.pow(edgeLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return baseArea * height;
    }

    @Override
    public String toString() {
        return "Square Prism - " + super.toString() + ", Edge Length: " + edgeLength;
    }
}
