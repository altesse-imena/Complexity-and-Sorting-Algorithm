package shapes;

public class TriangularPrism extends Shape3D {
    private double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    @Override
    protected double calculateBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(edgeLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return baseArea * height;
    }

    @Override
    public String toString() {
        return "Triangular Prism - " + super.toString() + ", Edge Length: " + edgeLength;
    }
}
