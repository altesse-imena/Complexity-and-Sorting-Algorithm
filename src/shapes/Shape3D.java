package shapes;


public abstract class Shape3D implements Comparable<Shape3D> {

    protected double height;
    protected double baseArea;
    protected double volume;

    
    public Shape3D(double height) {
        this.height = height;
        this.baseArea = calculateBaseArea();
        this.volume = calculateVolume();
    }

    
    protected abstract double calculateBaseArea();
    protected abstract double calculateVolume();

    
    public double getHeight() {
        return height;
    }

    
    public double getBaseArea() {
        return baseArea;
    }

    
    public double getVolume() {
        return volume;
    }

    
    @Override
    public int compareTo(Shape3D otherShape) {
        return Double.compare(this.height, otherShape.height);
    }

    @Override
    public String toString() {
        return "Height: " + height + ", Base Area: " + baseArea + ", Volume: " + volume;
    }
}
