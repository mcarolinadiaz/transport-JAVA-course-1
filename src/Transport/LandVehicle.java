package Transport;

import java.util.ArrayList;

// Abstract class representing a generic land vehicle that is kind of a vehicle in the Transport hierarchy.
// This class encapsulates common properties and behaviors shared by all kind of land vehicles.
abstract class LandVehicle extends Vehicle{
    protected int wheels;                       // Wheels of the land vehicle
    private ArrayList<String> suitableTerrain;  // List of suitable terrain for the land vehicle
    // Default constructor
    public LandVehicle() {
        super();
        this.wheels = 4;
    }
    // Custom constructor
    public LandVehicle(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain) {
        super(model, year, propulsion);
        this.wheels = wheels;
        this.suitableTerrain = new ArrayList<String>();
        this.setSuitableTerrain(suitableTerrain);
    }
    // Getters and setters

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public ArrayList<String> getSuitableTerrain() {
        ArrayList<String> result = new ArrayList<>();
        for (String s : this.suitableTerrain) {
            result.add(s);
        }
        return result;
    }
/*
    public ArrayList<String> getSuitableTerrain() {
        return new ArrayList<>(this.suitableTerrain);
    }
*/
    public void setSuitableTerrain(ArrayList<String>  suitableTerrain) {
        for (String s : suitableTerrain) {
            this.suitableTerrain.add(s);
        }
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

    public abstract void startUp();
}
