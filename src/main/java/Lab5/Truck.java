package Lab5;

public class Truck extends Vehicle implements Repairable {
    public Truck(String modelName) {
        super(modelName);
    }

    public Truck(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
    }

    @Override
    public String repair() {
        return "Engine overhauled and tires replaced for " + getModelName();
    }

    @Override
    public String service() {
        return "Servicing truck: " + getModelName() + ", Mileage: " + getMileage() + ", Health: " + getHealth();
    }

    @Override
    public int expectedLifespan() {
        return 300000;
    }

    public void haul(int loadWeight) {
        int currentHealth = getHealth();
        int newMileage = getMileage() + 50;
        int newHealth = currentHealth;

        if (loadWeight > 5000) {
            newHealth -= 10;
        }

        setMileage(newMileage);
        setHealth(newHealth);

        if (newHealth < 70) {
            expectedLifespan();
        }
    }
}
