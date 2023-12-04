package com.solvd.transport;

import com.solvd.transport.enums.BusBrand;
import com.solvd.transport.enums.Propulsion;
import com.solvd.transport.enums.Roads;
import com.solvd.transport.interfaces.ICalculateFee;
import com.solvd.transport.interfaces.IEmbark;
import com.solvd.transport.interfaces.IPublicTransport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
/**
 * Class representing a Bus, a type of LandVehicle used for public transportation.
 * Implements the IPublicTransport and IEmbark interfaces.
 */
public class Bus extends LandVehicle implements IPublicTransport, IEmbark {
    private static final Logger LOGGER = LogManager.getLogger(Bus.class);
    private int availableSeats;
    private List<String> passengers;
    private static final int MAX_SEATS = 40;
    private BusBrand busBrand;
    private ICalculateFee<Integer> iCalculateFee = (x) -> {
      return this.passengers.size() * x;
    };
    /**
     * Default constructor initializes default values for a bus.
     */
    public Bus() {
        super();
        this.availableSeats = 40;
        this.passengers = new ArrayList<>();
    }
    /**
     * Custom constructor to set values for a Bus.
     */
    public Bus(String model, int year, Propulsion propulsion, int wheels,
               List<Roads> suitableTerrain, int availableSeats) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.availableSeats = availableSeats;
        this.passengers = new ArrayList<>();
    }
    // Getters & Setters
    /**
     * Get the number of available seats on the bus.
     * @return The number of available seats.
     */
    public int getAvailableSeats() {
        return availableSeats;
    }
    /**
     * Set the number of available seats on the bus.
     */
    public void setAvailableSeats(int availableSeats) throws InvalidValueException {
        try {
            if (availableSeats <= MAX_SEATS) {
                this.availableSeats = availableSeats;
            } else {
                throw new InvalidValueException("The value of available seats is invalid.");
            }
        } catch (InvalidValueException e) {
            LOGGER.warn("Invalid value for available seats: " + e.getMessage());
        }
    }

    public int getWheels() {
        return super.getWheels();
    }

    public void setWheels(int wheels) {
        super.setWheels(wheels);
    }

    public ArrayList<Roads> getSuitableTerrain() {
        return super.getSuitableTerrain();
    }

    public void setSuitableTerrain(List<Roads> suitableTerrain) {
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

    public List<Propulsion> getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(Propulsion propulsion) {
        super.setPropulsion(propulsion);
    }

    public BusBrand getBusBrand() {
        return busBrand;
    }

    public void setBusBrand(BusBrand busBrand) {
        this.busBrand = busBrand;
    }

    /**
     * Start up the bus and log the event.
     */
    @Override
    public void startUp() {
        LOGGER.info("The bus is started up");
    }
    /**
     * Custom toString method to provide a string representation of the Bus object.
     */
    @Override
    public String toString() {
        return "Bus{" +
                "model='" + this.getModel() + '\'' +
                ", year=" + this.getYear() +
                ", propulsion='" + this.getPropulsion() + '\'' +
                ", availableSeats=" + this.getAvailableSeats() +
                "}";
    }
    /**
     * Collect fees from passengers.
     * Log the event.
     */
    @Override
    public int collectFees(int fee) {
        LOGGER.info("Collecting fees...");
        return iCalculateFee.calculateFee(fee);
    }
    // Private method to set passengers

    /**
     * Set the list of passengers on the bus.
     */
    private void setPassengers(List<String> passengers) {
        this.passengers.addAll(passengers);
    }
    /**
     * Embarks passengers onto the bus.
     * This method checks the number of available seats.
     * If conditions are met, passengers are added to the bus, and the available seats are updated.
     *
     */
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
    /**
     * Disembarks passengers onto the bus.
     * This method checks the number of available seats.
     * If conditions are met, passengers and the available seats are updated to the bus.
     *
     */
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

    public int getCountPassengers(String name) {
        return Long.valueOf(this.passengers.stream()
                .filter(passenger -> passenger.startsWith(name))
                .count()).intValue();
    }
}
