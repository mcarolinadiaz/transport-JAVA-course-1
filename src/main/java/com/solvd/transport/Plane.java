package com.solvd.transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Plane class representing a kind of air vehicle in the Transport hierarchy.
 * This class includes features specific to planes, such as the ability to take off,
 *  * land, embark and disembark passengers, and maintain information about available seats.
 */
public class Plane extends AirVehicle implements IEmbark {
    private static final Logger LOGGER = LogManager.getLogger(Plane.class);
    private int availableSeats;
    private boolean flying;
    private final List<String> passengers;
    private static final int MAX_SEATS = 40;
    public Plane() {
        super();
        this.availableSeats = 40;
        this.flying = false;
        this.passengers = new ArrayList<>();
    }
    public Plane(String model, int year, String propulsion, int availableSeats) {
        super(model, year, propulsion);
        this.availableSeats = availableSeats;
        this.flying = true;
        this.passengers = new ArrayList<>();
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) throws InvalidValueException {
        if (availableSeats <= MAX_SEATS) {
            this.availableSeats = availableSeats;
        } else {
            LOGGER.warn("The value of available seats is invalid.");
            throw new InvalidValueException("The value of available seats is invalid.");
        }
    }
    /**
     * Initiates the takeoff sequence for the plane.
     * The plane must be on the ground to perform takeoff.
     */
    public void takeOff() {
        this.startUp();
        this.flying = true;
        LOGGER.info("The plane has taken off successfully.");
    }
    /**
     * Initiates the landing sequence for the plane.
     * If the plane is currently flying, it will be marked as landed.
     * No further operations are allowed until the plane takes off again.
     */
    public void land() {
        this.flying = false;
        LOGGER.info("The plane has landed successfully.");
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

    public boolean isFlying() {
        return this.flying;
    }

    private void setPassengers(List<String> passengers) {
        this.passengers.addAll(passengers);
    }

    @Override
    public void startUp() {
        if (!this.flying) {
            LOGGER.info("The plane is started up.");
        }
        else {
            LOGGER.error("The plane has already took off and is flying!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Plane p = (Plane) o;
        return this.getAvailableSeats() == p.getAvailableSeats() &&
                this.flying == p.isFlying() &&
                Objects.equals(this.getModel(), p.getModel()) &&
                this.getYear() == p.getYear() &&
                Objects.equals(this.propulsion, p.getPropulsion());

    }

    @Override
    public String toString() {
        return "Plane{" + '\'' +
                "model=" + this.getModel() + '\'' +
                "year=" + this.getYear() + '\'' +
                "propulsion=" + this.getPropulsion() + '\'' +
                "availableSeats=" + this.getAvailableSeats() + '\'' +
                "flying=" + this.isFlying() + '\'' +
                "}";
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.getAvailableSeats(), this.isFlying(), this.getYear(),
                this.getModel(), this.getPropulsion());
    }

    /**
     * Embarks passengers onto the plane.
     *
     * This method checks the number of available seats and the flying status of the plane.
     * If conditions are met, passengers are added to the plane, and the available seats are updated.
     *
     */
    @Override
    public void embarkPassengers(List<String> passengers) throws NegativeValueException,
            InvalidValueException {
        if (passengers.size() < 0) {
            LOGGER.error("The number of passengers is negative.");
            throw new NegativeValueException("The number of passengers is negative.");
        } else if (MAX_SEATS < passengers.size()) {
                LOGGER.error(
                        "It doesn't have enough available seats for " + passengers + "people");
                throw new InvalidValueException("It doesn't have enough available seats for "
                        + passengers.size() + "people");
            } else if (this.getAvailableSeats() >= passengers.size()) {
                try {
                    if (isFlying()) {
                        throw new InvalidOperationException("The plane is flying now!");
                    } else {
                        LOGGER.info("Passengers are being embarked.");
                        this.setAvailableSeats(this.getAvailableSeats() - passengers.size());
                        this.setPassengers(passengers);
                    }
                }
                catch (InvalidOperationException e) {
                    LOGGER.error("Error: " + e.getMessage());
                }
            } else {
            LOGGER.warn("It doesn't have enough available seats for "+
                    (passengers.size() - 1) + "people");
        }
    }
    /**
     * Disembarks passengers onto the plane.
     * This method checks the number of available seats and the flying status of the plane.
     * If conditions are met, passengers and the available seats are updated to the plane.
     *
     */

    @Override
    public void disembarkPassengers(List<String> passengers) throws InvalidOperationException {
        try {
            if (isFlying()) {
                throw new InvalidOperationException(
                        "The plane is flying now and it is not possible to disembark!");
            } else
                if (!this.passengers.isEmpty() && passengers.size() <= this.passengers.size()) {
                    LOGGER.info("Passengers are being disembarked.");
                    int newCountSeats = Math.min(passengers.size(), MAX_SEATS);
                    this.setAvailableSeats(newCountSeats);
                }
        }
        catch (InvalidOperationException e) {
            LOGGER.error("Error: " + e.getMessage());
        }
    }
}
