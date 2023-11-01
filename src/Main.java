import Transport.*;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Submarine submarine = new Submarine();
        Plane plane = new Plane();
        Lorry lorry = new Lorry();
        Car car = new Car();
        Bus bus = new Bus();
        Boat boat = new Boat();

        Submarine customSubmarine = new Submarine("0C", 2022, "petrol", 5000, 50000);
        Plane customPlane = new Plane("0A", 2020, "Jet fuels", 20, false);
        Lorry customLorry = new Lorry();
        Car customCar = new Car("0U", 2020, "gas oil", 4, new ArrayList<String>(), 5);
        Bus customBus = new Bus("0Y", 2021, "petrol", 4, new ArrayList<String>(), 10);
        Boat customBoat = new Boat("0R", 2023, "petrol", 5500, 2);

        System.out.println(car.getPropulsion());
        System.out.println(customPlane.getPropulsion());
        System.out.println(customPlane.toString());
        System.out.println(customSubmarine.toString());
        System.out.println(customBoat.equals(boat));
        System.out.println(customPlane.hashCode());

    }
}