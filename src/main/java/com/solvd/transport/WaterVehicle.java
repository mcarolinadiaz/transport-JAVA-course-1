package com.solvd.transport;

import com.solvd.transport.enums.Propulsion;

import java.util.List;

/**
 * Abstract class representing a generic water vehicle that is kind of a vehicle in the Transport hierarchy.
 * This class encapsulates common properties and behaviors shared by all kind of water vehicles.
 */
abstract class WaterVehicle extends Vehicle {
    protected int length;   // Length of the waterVehicle
    /**
     * Default constructor; calls Father's default constructor
     */
    public WaterVehicle() {
        super();
        this.length = 20000;
    }
    /**
     * Custom constructor; calls Father's custom constructor
     */
    public WaterVehicle(String model, int year, Propulsion propulsion, int length) {
        super(model, year, propulsion);
        this.length = length;
    }
    /**
     * Getters and setters
     */
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public List<Propulsion> getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(Propulsion propulsion) {
        super.setPropulsion(propulsion);
    }


    public abstract void startUp();
}
