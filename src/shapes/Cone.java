package shapes;

public class Cone extends Shape3D {
    private double radius;

    
    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    
    @Override
    protected double calculateBaseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double calculateVolume() {
        return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return "Cone - " + super.toString() + ", Radius: " + radius;
    }
}
