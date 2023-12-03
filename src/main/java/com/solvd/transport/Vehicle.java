package com.solvd.transport;

import com.solvd.transport.enums.Propulsion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class representing a generic vehicle in the Transport hierarchy.
 * This class encapsulates common properties and behaviors shared by all vehicles.
 */
abstract class Vehicle {
    protected String model;         // Model of the vehicle
    protected int year;             // Year of the vehicle
    protected List<Propulsion> propulsions;
    /**
     * Default constructor initializes instance variables with default values.
     */
    public Vehicle() {
        this.model = "";
        this.year = 2023;
        this.propulsions = new ArrayList<>();
        this.propulsions.add(Propulsion.GASOLINE);
    }
    /**
     * Custom constructor allows setting initial values for model, year, and propulsion.
     */
    public Vehicle(String model, int year, Propulsion propulsion) {
        this.model = model;
        this.year = year;
        this.setPropulsion(propulsion);
    }

    // Getters & Setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws InvalidModelException {
        if (model == null) {
            throw new InvalidModelException("Model name is null.");
        }
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Propulsion> getPropulsion() {
        return this.propulsions;
    }

    /**
     * @param propulsion
     * @throws InvalidPropulsion
     */
    public void setPropulsion(Propulsion propulsion) throws InvalidPropulsion {
        int count = Long.valueOf(Arrays.stream(Propulsion.values())
                .filter(prop -> prop.getPropulsion().equals(propulsion.getPropulsion()))
                .count()).intValue();
        if (count > 0) {
                this.propulsions.add(propulsion);
        } else {
            throw new InvalidPropulsion("It's invalid propulsion");
        }
    }

    /**
     * Abstract method representing the startup behavior of the vehicle.
     * Subclasses must provide their own implementation.
     */
    public abstract void startUp();

    /**
     * @param fuelType kind of fueld
     * @return a list of propulsion
     */
    public List<String> getKindOfPropulsion(String fuelType) {
        return this.propulsions.stream()
                .filter(prop -> prop.getFuelType().getType().equals(fuelType))
                .map(prop -> prop.getPropulsion())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getAllByPropulsionName(String propulsion) {
        return this.propulsions.stream()
                .map(prop -> prop.getPropulsion())
                .filter(propPropulsion -> propPropulsion.equals(propulsion))
                .distinct()
                .collect(Collectors.toList());
    }


}
