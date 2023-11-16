import Transport.*;
import Transport.Lorry;
import Transport.Car;
import Transport.Plane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;


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
        list.add(dos);
        list.add(uno);
        list.add(2);
        list.add(3,0);
        list.add(6,7);
        list.add(8,1);

        list.sort();

        /*
        list.removeByElement(1);
        list.removeByElement(3);
        list.removeByElement(0);
        list.removeByElement(6);*/


        LOGGER.info(lorry.getPropulsion());
        LOGGER.info(plane.toString());





    }
}