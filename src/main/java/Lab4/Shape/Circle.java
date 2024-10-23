package Lab4.Shape;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, FillType fillType, double radius) {
        super(color, fillType);
        this.radius = radius;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();

        System.out.println("Radius: " + radius);
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double calculateCircumference(double r) {
        return 2 * Math.PI * r;
    }
}
