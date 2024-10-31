package Lab5;

public abstract class Vehicle {
    private String modelName;
    private int mileage;
    private int health;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
    }

    public Vehicle(String modelName, int mileage, int health) {
        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
    }

    public String getModelName() {
        return modelName;
    }

    public int getMileage() {
        return mileage;
    }

    public int getHealth() {
        return health;
    }

    public void setMileage(int mileage) {
        this.mileage = Math.min(mileage, expectedLifespan());
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, 100));
    }

    public abstract String service();

    public abstract int expectedLifespan();

    public boolean needsMaintenance() {
        return health < 70;
    }

    public int calculateRemainingLifespan() {
        int remainingLifespan = expectedLifespan() - mileage;
        if (health < 50) {
            remainingLifespan -= 10000;
        }
        return Math.max(0, remainingLifespan);
    }

    public void simulateYear() {
        if (mileage > expectedLifespan() / 2) {
            health -= 5;
        }
        calculateRemainingLifespan();
    }

    public void performMaintenance(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            Car car = (Car) vehicle;
            System.out.println(car.repair());
            car.drive(100);
        } else if (vehicle instanceof Truck) {
            Truck truck = (Truck) vehicle;
            System.out.println(truck.repair());
            truck.haul(6000);
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle motorcycle = (Motorcycle) vehicle;
            motorcycle.race(50);
        }
    }
}
