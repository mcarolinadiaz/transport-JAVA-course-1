import Transport.*;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        Submarine submarine = new Submarine();
        Plane plane = new Plane();
        Lorry lorry = new Lorry();
        LandVehicle landVehicle = new LandVehicle();
        Car car = new Car();
        Bus bus = new Bus();
        Boat boat = new Boat();
        AirVehicle airVehicle = new AirVehicle();

        Vehicle customVehicle = new Vehicle("0A", 2020, "gas oil");
        WaterVehicle customWaterVehicle = new WaterVehicle("0B", 2019, "petrol", 5000);
        Submarine customSubmarine = new Submarine("0C", 2022, "petrol", 5000, 50000);
        Plane customPlane = new Plane("0A", 2020, "Jet fuels", 20, false);
        Lorry customLorry = new Lorry();
        LandVehicle customLandVehicle = new LandVehicle("0A", 2020, "gas oil", 4, new ArrayList<String>());
        Car customCar = new Car("0U", 2020, "gas oil", 4, new ArrayList<String>(), 5);
        Bus customBus = new Bus("0Y", 2021, "petrol", 4, new ArrayList<String>(), 10);
        Boat customBoat = new Boat("0R", 2023, "petrol", 5500, 2);
        AirVehicle customAirVehicle = new AirVehicle("0A", 2020, "Jet fuels", false);

        System.out.println(vehicle.getPropulsion());
        System.out.println(customVehicle.getPropulsion());
    }
}