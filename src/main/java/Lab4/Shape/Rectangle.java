package Lab4.Shape;

public class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(String color, FillType fillType,double width, double height) {
        super(color,fillType);
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("width: " + width);
        System.out.println("height: " + height);
    }
    public double getArea() {
        return width * height;
    }


}
