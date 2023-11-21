package com.solvd.transport;

// Abstract class representing a generic air vehicle that is kind of a vehicle in the Transport hierarchy.
// This class encapsulates common behaviors shared by all kind of air vehicles.
abstract class AirVehicle extends Vehicle {
    //Default constructor

    public AirVehicle() {
        super();
    }
    //Custom constructor
    public AirVehicle(String model, int year, String propulsion) {
        super(model, year, propulsion);
    }

    public abstract void takeOff();
    public abstract void land();

    // Getters and Setters
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

    public abstract void startUp();


}
