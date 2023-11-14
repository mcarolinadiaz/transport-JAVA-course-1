import Transport.*;
import Transport.Lorry;
import Transport.Car;
import Transport.Plane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws NotClosedException, InvalidOperationException {
        Submarine submarine = new Submarine();
        Plane plane = new Plane();
        Lorry lorry = new Lorry();
        Boat boat = new Boat();
        try(Car car = new Car()) {
            LOGGER.info("Propulsion of: " + car.getPropulsion());
        } catch (NotClosedException e) {
            LOGGER.error("Exception message: " + e.getMessage());
        }
        boat.load();
        boat.raiseAnchors();
        boat.load();
        LOGGER.info("Hello!");
        plane.startUp();
        plane.takeOff();
        ArrayList<String> passengers = new ArrayList<>();
        passengers.add("John");
        passengers.add("Anna");
        passengers.add("Sean");
        plane.land();
        plane.disembarkPassengers(passengers);

        CustomLinkedList<Integer> list = new CustomLinkedList<>();
        Integer uno = 1;
        Integer dos = 2;
        list.add(uno);
        list.add(dos);
        list.add(3,0);
        list.add(6,7);
        list.add(8,1);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);


/*
        Submarine customSubmarine = new Submarine("0C", 2022, "petrol", 5000, 50000);
        Plane customPlane = new Plane("0A", 2020, "Jet fuels", 20, false);
        Lorry customLorry = new Lorry();
        Car customCar = new Car("0U", 2020, "gas oil", 4, new ArrayList<String>(), 5);
        Bus customBus = new Bus("0Y", 2021, "petrol", 4, new ArrayList<String>(), 10);
        Boat customBoat = new Boat("0R", 2023, "petrol", 5500, 2);
*/

        LOGGER.info(lorry.getPropulsion());
        LOGGER.info(plane.toString());





    }
}