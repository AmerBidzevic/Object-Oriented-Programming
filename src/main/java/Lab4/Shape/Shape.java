package Lab4.Shape;

public class Shape {
    private String color;
    private FillType fillType;

    public enum FillType {
        FILLED, NOT_FILLED,
    }

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    public FillType getFillType() {
        return fillType;
    }

    public void displayInfo(){
        System.out.println("Color: " + color + " FillType: " + fillType);
    }

    public static void main(String[] args){
        Shape shape = new Shape("red", FillType.FILLED);
        shape.displayInfo();
    }
}
