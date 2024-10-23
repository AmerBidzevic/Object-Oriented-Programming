package Lab4.Shape;

public class Main {
    public static void main(String[] args) {
        Circle myCircle = new Circle("Blue", Shape.FillType.FILLED, 5.0);

        Rectangle myRectangle = new Rectangle("Green", Shape.FillType.NOT_FILLED, 4.0, 6.0);

        System.out.println("Circle Information:");
        myCircle.displayInfo();

        System.out.println("\nRectangle Information:");
        myRectangle.displayInfo();
    }
}

