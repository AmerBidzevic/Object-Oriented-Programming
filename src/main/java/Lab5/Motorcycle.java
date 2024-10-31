package Lab5;

public class Motorcycle extends Vehicle {
    public Motorcycle(String modelName) {
        super(modelName);
    }
    public Motorcycle(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String service() {
        return "Servicing motorcycle: " + getModelName() + ", Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 50000;
    }

    public void race(int raceMiles) {
        setMileage(getMileage() + raceMiles);

        setHealth(getHealth() - (raceMiles / 20));
    }
}
