package Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Car extends LandVehicle {
    private int doors;
    private boolean doorsClosed;
    public Car() {
        super();
        this.doors = 4;
        this.doorsClosed = false;
    }
    public Car(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain, int doors) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.doors = doors;
        this.doorsClosed = false;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
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

    public void openDoors() {
        this.doorsClosed = false;
    }

    public void closeDoors() {
        this.doorsClosed = true;
    }

    public boolean areDoorsClosed() {
        return this.doorsClosed;
    }

    @Override
    public void startUp() {
        if (!this.doorsClosed) {
            System.out.println("The car is started up");
        }
        else {
            this.closeDoors();
            System.out.println("Doors were closed and The car is started up");
        }
    }


}
