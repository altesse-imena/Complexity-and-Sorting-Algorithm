package shapes;

public class OctagonalPrism extends Shape3D {
    private double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    @Override
    protected double calculateBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return baseArea * height;
    }

    @Override
    public String toString() {
        return "Octagonal Prism - " + super.toString() + ", Edge Length: " + edgeLength;
    }
}
