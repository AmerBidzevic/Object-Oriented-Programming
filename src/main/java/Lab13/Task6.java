package Lab13;
import java.util.*;

class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(String type, String size, List<String> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee [type=" + type + ", size=" + size + ", toppings=" + toppings + "]";
    }
}

interface CoffeeBuilder {
    void buildType();
    void buildSize();
    void buildToppings();
    Coffee getCoffee();
}

class EspressoBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings = new ArrayList<>();

    public void buildType() {
        this.type = "Espresso";
    }

    public void buildSize() {
        this.size = "Small";
    }

    public void buildToppings() {
        toppings.add("None");
    }

    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class LatteBuilder implements CoffeeBuilder {
    private String type;
    private String size;
    private List<String> toppings = new ArrayList<>();

    public void buildType() {
        this.type = "Latte";
    }

    public void buildSize() {
        this.size = "Medium";
    }

    public void buildToppings() {
        toppings.add("Milk Foam");
    }

    public Coffee getCoffee() {
        return new Coffee(type, size, toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder) {
        builder.buildType();
        builder.buildSize();
        builder.buildToppings();
        return builder.getCoffee();
    }
}

class Main6{
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();
        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder);
        System.out.println(espresso);

        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder);
        System.out.println(latte);
    }
}

