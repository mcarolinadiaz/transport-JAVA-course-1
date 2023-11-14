package Transport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Plane extends AirVehicle implements IEmbark {
    private static final Logger LOGGER = LogManager.getLogger(Plane.class);
    private int availableSeats;
    private boolean flying;
    private List<String> passengers;
    private static final int MAXSEATS = 40;
    public Plane() {
        super();
        this.availableSeats = 40;
        this.flying = false;
        this.passengers = new ArrayList<>();
    }
    public Plane(String model, int year, String propulsion, int availableSeats, boolean flying) {
        super(model, year, propulsion, flying);
        this.availableSeats = availableSeats;
        this.flying = true;
        this.passengers = new ArrayList<>();
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) throws InvalidValueException {
        if (availableSeats <= MAXSEATS) {
            this.availableSeats = availableSeats;
        }
        LOGGER.warn("The value of available seats is invalid.");
        throw new InvalidValueException("The value of available seats is invalid.");
    }

    public void takeOff() {
        this.startUp();
        this.flying = true;
        LOGGER.info("The plane is flying");
    }
    public void land() {
        this.flying = false;
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

    private void setPassengers(ArrayList<String> passengers) {
        this.passengers.addAll(passengers);
    }

    @Override
    public void startUp() {
        if (!this.flying) {
            LOGGER.info("The plane is started up");
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
        if ((o == null) || (o.getClass().equals(this.getClass()))) {
            return false;
        }
        Plane p = (Plane) o;
        return this.getAvailableSeats() == p.getAvailableSeats() && this.flying == p.isFlying() &&
                this.getModel().equals(p.getModel()) && this.getYear() == p.getYear() &&
                this.propulsion.equals(p.getPropulsion());

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
        return Objects.hash(this.getAvailableSeats(), this.isFlying(), this.getYear(), this.getModel(),
                this.getYear(), this.getPropulsion());
    }


    @Override
    public void embarkPassengers(ArrayList<String> passengers) throws NegativeValueException, InvalidValueException, InvalidOperationException {
        if (passengers.size() < 0) {
            LOGGER.error("The number of passengers is negative.");
            throw new NegativeValueException("The number of passengers is negative.");
        } else if (MAXSEATS < passengers.size()) {
                LOGGER.error("It doesn't have enough available seats for " + passengers + "people");
                throw new InvalidValueException("It doesn't have enough available seats for " + passengers + "people");
            } else if (this.getAvailableSeats() >= passengers.size()) {
                try {
                    if (isFlying()) {
                        throw new InvalidOperationException("The plane is flying now!");
                    } else {
                        LOGGER.info("Embarking...");
                        this.setAvailableSeats(this.getAvailableSeats() - passengers.size());
                        this.setPassengers(passengers);
                    }
                }
                catch (InvalidOperationException e) {
                    LOGGER.error("Error: " + e.getMessage());
                }
            } else {
            LOGGER.warn("It doesn't have enough available seats for "+ (passengers.size() - 1) + "people");
        }
    }

    @Override
    public void disembarkPassengers(ArrayList<String> passengers) throws InvalidOperationException {
        try {
            if (isFlying()) {
                throw new InvalidOperationException("The plane is flying now and it is not possible to disembark!");
            } else
                try {
                    if (passengers.size() <= MAXSEATS && !(this.passengers.isEmpty()) && passengers.size() <= this.passengers.size()) {
                        LOGGER.info("Disembarking...");
                        int newCountSeats = passengers.size();
                        if (newCountSeats + this.passengers.size() > MAXSEATS) {
                            newCountSeats = MAXSEATS;
                        }
                        this.setAvailableSeats(newCountSeats);
                    }
                } catch(NullPointerException e) {
                    LOGGER.error("Error" + e.getMessage());
                }
        }
        catch (InvalidOperationException e) {
            LOGGER.error("Error: " + e.getMessage());
        }
    }
}
