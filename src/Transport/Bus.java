package Transport;

import java.util.ArrayList;

public class Bus extends LandVehicle implements IPublicTransport, IEmbark {
    private int availableSeats;
    public Bus() {
        super();
        this.availableSeats = 40;
    }
    public Bus(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain, int availableSeats) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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

    @Override
    public void startUp() {
        System.out.println("The bus is started up");
    }

    @Override
    public String toString() {
        return "Bus{" + '\'' +
                "model=" + this.getModel() + '\'' +
                "year=" + this.getYear() + '\'' +
                "propulsion=" + this.getPropulsion() + '\'' +
                "availableSeats=" + this.getAvailableSeats() + '\'' +
                "}";
    }

    @Override
    public void collectFees(int fee) {
        System.out.println("Collecting fees...");
    }

    @Override
    public void embarkPassengers(int passengers) {
        if (this.getAvailableSeats() >= passengers) {
            System.out.println("Embarking...");
            this.setAvailableSeats(this.getAvailableSeats() - passengers);
        } else {
            System.out.println("It doesn't have enough available seats for "+ passengers + "people");
        }

    }

    @Override
    public void disembarkPassengers(int passengers) {
        System.out.println("Disembarking...");
        this.setAvailableSeats(this.getAvailableSeats() + passengers);
    }
}
