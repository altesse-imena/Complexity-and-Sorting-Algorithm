package shapes;

public class Cylinder extends Shape3D {
    private double radius;

    
    public Cylinder(double height, double radius) {
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
        return Math.PI * Math.pow(radius, 2) * height;
    }

    @Override
    public String toString() {
        return "Cylinder - " + super.toString() + ", Radius: " + radius;
    }
}
