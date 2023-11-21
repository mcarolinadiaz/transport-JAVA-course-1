package com.solvd.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class can be created to model different cars with varying
 *  * models, years, propulsion mechanisms, and door configurations.
 */
public final class Car extends LandVehicle implements IElectricTransport, AutoCloseable {
    // properties
    private static final Logger LOGGER = LogManager.getLogger(Car.class);
    private final int doors;
    private List<Boolean> doorsClosed;
    private boolean lowBattery;
    // Default constructor
    public Car() {
        super();
        this.doors = 4;
        this.lowBattery = true;
        this.doorsClosed = new ArrayList<Boolean>();
        this.closeDoors();
    }
    public Car(String model, int year, String propulsion, int wheels, List<String> suitableTerrain, int doors) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.doors = doors;
        this.doorsClosed = new ArrayList<Boolean>();
        this.closeDoors();
        this.lowBattery = true;
    }

    // Getters & Setters
    public boolean getLowBattery() {
        return this.lowBattery;
    }

    public int getDoors() {
        return doors;
    }

    public int getWheels() {
        return super.getWheels();
    }

    public void setWheels(int wheels) {
        super.setWheels(wheels);
    }

    public ArrayList<String> getSuitableTerrain() {
        return super.getSuitableTerrain();
    }

    public void setSuitableTerrain(ArrayList<String> suitableTerrain) {
        super.setSuitableTerrain(suitableTerrain);
    }

    public String getModel() {
        return super.getModel();
    }

    public void setModel(String model) {
        super.setModel(model);
    }

    public int getYear() {
        return super.getYear();
    }

    public void setYear(int year) {
        super.setYear(year);
    }

    public String getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(String propulsion) {
        super.setPropulsion(propulsion);
    }
    /**
     * Opens the doors of the car.
     * If the number of doors exceeds the current configuration, additional doors are added.
     * Existing doors are set to the open state (true).
     */
    public void openDoors() {
        for (int i=0; i < this.doors; i++) {
            if (i >= this.doorsClosed.size()) {
                this.doorsClosed.add(true);
            } else {
                this.doorsClosed.set(i, true);
            }
        }
    }
    /**
     * Closes the doors of the car.
     * If the number of doors exceeds the current configuration, additional doors are added.
     * Existing doors are set to the closed state (false).
     */
    public void closeDoors() {
        for (int i=0; i < this.doors; i++) {
            if (i >= this.doorsClosed.size()) {
                this.doorsClosed.add(false);
            } else {
                this.doorsClosed.set(i, false);
            }
        }
    }

    public boolean areDoorsClosed() {
        return !(this.doorsClosed.contains(false));
    }
    /**
     * Starts up the car.
     * If the doors are already closed, the car is started up, and an information log is generated.
     * If any doors are open, they are automatically closed before starting up, and a corresponding log is generated.
     */
    @Override
    public void startUp() {
        if (this.areDoorsClosed()) {
            LOGGER.info("The car has started up successfully.");
        }
        else {
            this.closeDoors();
            LOGGER.info("Doors were closed and the car has started up successfully.");
        }
    }


    @Override
    public void chargeEnergy() {
        this.lowBattery = false;
    }
    /**
     * Closes the car as an AutoCloseable resource.
     * The usage of this exception may need to be revisited for better design and consistency.
     *
     */
    @Override
    public void close() throws NotClosedException {
        throw new NotClosedException("Car was closed");
    }
}
