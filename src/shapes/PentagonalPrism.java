package shapes;

public class PentagonalPrism extends Shape3D {
    private double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    @Override
    protected double calculateBaseArea() {
        return (5 * Math.pow(edgeLength, 2) * Math.tan(Math.toRadians(54))) / 4;
    }

    @Override
    protected double calculateVolume() {
        return baseArea * height;
    }

    @Override
    public String toString() {
        return "Pentagonal Prism - " + super.toString() + ", Edge Length: " + edgeLength;
    }
}
