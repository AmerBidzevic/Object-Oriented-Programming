package Lab5;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("Toyota Camry"),
                new Truck("Ford F-150"),
                new Motorcycle("Yamaha YZF-R3")
        };

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.service());
        }

        for (Vehicle vehicle : vehicles) {
            vehicle.simulateYear();
            System.out.println(vehicle.service());
        }

        for (Vehicle vehicle : vehicles) {
            vehicle.performMaintenance(vehicle);
            System.out.println(vehicle.service());
        }
    }
}
