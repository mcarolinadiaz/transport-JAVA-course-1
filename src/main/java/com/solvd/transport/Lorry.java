package com.solvd.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lorry extends LandVehicle implements IShipment {
    private static final Logger LOGGER = LogManager.getLogger(Lorry.class);
    private int load;
    private int capacity;
    private boolean driving;

    /**
     * Default constructor
     */
    public Lorry() {
        super();
        this.load = 0;
        this.capacity = 40;
        this.driving = false;
    }

    /**
     * Custom constructor
     */
    public Lorry(String model, int year, String propulsion, int wheels,
                 List<String> suitableTerrain, int load, int capacity) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.load = load;
        this.capacity = capacity;
        this.driving = false;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
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

    public void setSuitableTerrain(List<String> suitableTerrain) {
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

    @Override
    public void startUp() {
        this.driving = true;
        LOGGER.info("The lorry is started up");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lorry)) return false;
        Lorry lorry = (Lorry) o;
        return this.getLoad() == lorry.getLoad() && capacity == lorry.capacity && driving == lorry.driving;
    }
    /**
     * Custom hashCode method to generate a hash code for Lorry objects.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getLoad(), capacity, driving);
    }
    /**
     * Custom toString method to provide a string representation of the Lorry object.
     */
    @Override
    public String toString() {
        return "Lorry{" +
                "load=" + load +
                ", capacity=" + capacity +
                ", driving=" + driving +
                ", wheels=" + wheels +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", propulsion='" + propulsion + '\'' +
                '}';
    }

    public void brake() {
        this.driving = false;
    }

    @Override
    public void load() {
        if (this.driving) {
            LOGGER.warn("The lorry is driving now!");
        } else {
            LOGGER.info("Loading...");
        }
    }

    @Override
    public void unload() {
        if (this.driving) {
            LOGGER.warn("The lorry is driving now!");
        } else {
            LOGGER.info("Unloading...");
        }
    }
}
