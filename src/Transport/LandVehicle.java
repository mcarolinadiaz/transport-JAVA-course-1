package Transport;

import java.util.ArrayList;

public class LandVehicle extends Vehicle{
    private int wheels;
    private ArrayList<String> suitableTerrain;
    public LandVehicle() {
        super();
        this.wheels = 4;
    }
    public LandVehicle(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain) {
        super(model, year, propulsion);
        this.wheels = wheels;
        this.suitableTerrain = new ArrayList<String>();
        this.setSuitableTerrain(suitableTerrain);
    }

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
}
