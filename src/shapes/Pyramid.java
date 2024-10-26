package shapes;

public class Pyramid extends Shape3D {
    private double edgeLength;

    
    public Pyramid(double height, double edgeLength) {
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
        return (1.0 / 3) * Math.pow(edgeLength, 2) * height;
    }

    @Override
    public String toString() {
        return "Pyramid - " + super.toString() + ", Edge Length: " + edgeLength;
    }
}
