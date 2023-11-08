package Transport;

import java.util.ArrayList;
import java.util.Objects;

public final class Car extends LandVehicle implements IElectricTransport {
    // properties
    private final int doors;
    private boolean doorsClosed;
    private boolean lowBattery;
    // Default constructor
    public Car() {
        super();
        this.doors = 4;
        this.doorsClosed = false;
        this.lowBattery = true;
    }
    public Car(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain, int doors) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.doors = doors;
        this.doorsClosed = false;
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


    @Override
    public void chargeEnergy() {
        this.lowBattery = false;
    }
}
