package com.solvd.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Bus extends LandVehicle implements IPublicTransport, IEmbark {
    private static final Logger LOGGER = LogManager.getLogger(Bus.class);
    private int availableSeats;
    private List<String> passengers;
    private static final int MAX_SEATS = 40;
    public Bus() {
        super();
        this.availableSeats = 40;
        this.passengers = new ArrayList<>();
    }
    public Bus(String model, int year, String propulsion, int wheels,
               List<String> suitableTerrain, int availableSeats) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.availableSeats = availableSeats;
        this.passengers = new ArrayList<>();
    }
    // Getters & Setters
    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) throws InvalidValueException {
        if (availableSeats <= MAX_SEATS) {
            this.availableSeats = availableSeats;
        }
        LOGGER.warn("The value of available seats is invalid.");
        throw new InvalidValueException("The value of available seats is invalid.");
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
        LOGGER.info("The bus is started up");
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
        LOGGER.info("Collecting fees...");
    }

    private void setPassengers(List<String> passengers) {
        this.passengers.addAll(passengers);
    }

    @Override
    public void embarkPassengers(List<String> passengers) throws InvalidValueException,
            InvalidOperationException {
        if (MAX_SEATS < passengers.size()) {
            LOGGER.error("It doesn't have enough available seats for " +
                    passengers + "people");
            throw new InvalidValueException("It doesn't have enough available seats for " +
                    passengers + "people");
        } else {
            if (this.getAvailableSeats() > passengers.size()) {
                LOGGER.info("Embarking...");
                this.setAvailableSeats(this.getAvailableSeats() - passengers.size());
                this.setPassengers(passengers);
            } else {
                LOGGER.warn("It doesn't have enough available seats for " +
                        (passengers.size() - 1) + "people");
            }
        }

    }

    @Override
    public void disembarkPassengers(List<String> passengers) {
        if (passengers.size() <= MAX_SEATS && passengers.size() <= this.passengers.size()) {
            LOGGER.info("Disembarking...");
            int newCountSeats = passengers.size();
            if (newCountSeats + this.passengers.size() > MAX_SEATS) {
                newCountSeats = MAX_SEATS;
            }
            this.setAvailableSeats(newCountSeats);
        }
    }
}
