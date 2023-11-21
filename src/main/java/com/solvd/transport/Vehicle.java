package com.solvd.transport;

import java.util.List;

// Abstract class representing a generic vehicle in the Transport hierarchy.
// This class encapsulates common properties and behaviors shared by all vehicles.

abstract class Vehicle {
    protected String model;         // Model of the vehicle
    protected int year;             // Year of the vehicle
    protected String propulsion;    // Type of propulsion (e.g., petrol, jet fuel)
    protected static final List<String> PROPULSION = List.of(new String[]{"petrol", "jet fuel", "gas oil"});
    // Default constructor initializes instance variables with default values.
    public Vehicle() {
        this.model = "";
        this.year = 2023;
        this.propulsion = "petrol";
    }
    // Custom constructor allows setting initial values for model, year, and propulsion.
    public Vehicle(String model, int year, String propulsion) {
        this.model = model;
        this.year = year;
        this.propulsion = propulsion;
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

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) throws InvalidPropulsion {
        boolean match = false;
        for (String p : PROPULSION) {
            if (p.contains(propulsion)) {
                match = true;
                break;
            }
        }
        if (!match) {
            throw new InvalidPropulsion("It's invalid propulsion");
        }
        this.propulsion = propulsion;
    }

    // Abstract method representing the startup behavior of the vehicle.
    // Subclasses must provide their own implementation.
    public abstract void startUp();


}