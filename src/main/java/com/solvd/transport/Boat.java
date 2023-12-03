package com.solvd.transport;

import com.solvd.transport.enums.Propulsion;
import com.solvd.transport.interfaces.IShipment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
/**
 * Boat class representing a water vehicle.
 * Inherits from WaterVehicle and implements the IShipment interface.
 */
public class Boat extends WaterVehicle implements IShipment {
    private static final Logger LOGGER = LogManager.getLogger(Boat.class);
    private int anchors;
    private boolean anchored;
    /**
     * Default constructor initializes anchors to 4 and sets the boat as anchored.
     */
    public Boat() {
        super();
        this.anchors = 4;
        this.anchored = true;
    }
    /**
     * Custom constructor with additional parameters for anchors and initializes the boat as anchored.
     */
    public Boat(String model, int year, Propulsion propulsion, int length, int anchors) {
        super(model, year, propulsion, length);
        this.anchors = anchors;
        this.anchored = true;
    }
    /**
     * Getters and Setters
     * Get the number of anchors on the boat.
     */
    public int getAnchors() {
        return anchors;
    }
    /**
     * Set the number of anchors on the boat.
     */
    public void setAnchors(int anchors) {
        this.anchors = anchors;
    }
    /**
     * Raise the anchors on the boat.
     */
    public void raiseAnchors() {
        this.anchored = false;
    }
    /**
     * Anchor the boat.
     */
    public void anchored() {
        this.anchored = true;
    }

    public int getLength() {
        return super.getLength();
    }

    public void setLength(int length) {
        super.setLength(length);
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

    // Override methods from the parent class

    /**
     * Overridden startUp method to raise anchors before starting the boat.
     */
    @Override
    public void startUp() {
        if (this.anchored) {
            this.raiseAnchors();
        }
        LOGGER.info("The anchors have been raised and the boat is underway");
    }
    /**
     * Custom equals method to compare Boat objects based on their attributes.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (o.getClass().equals(this.getClass()))) {
            return false;
        }
        Boat b = (Boat) o;
        return this.getAnchors() == b.getAnchors() && this.getLength() == b.getLength() &&
                this.getModel().equals(b.getModel()) && this.getYear() == b.getYear();

    }
    /**
     * Custom toString method to provide a string representation of the Boat object.
     */
    @Override
    public String toString() {
        return "Boat{" + '\'' +
                "model=" + this.getModel() + '\'' +
                "year=" + this.getYear() + '\'' +
                "propulsion=" + this.getPropulsion() + '\'' +
                "anchors=" + this.getAnchors() + '\'' +
                "length=" + this.getLength() + '\'' +
                "}";
    }
    /**
     * Custom hashCode method to generate a hash code for Boat objects.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(this.getLength(), this.getAnchors(), this.getYear(), this.getModel(),
                this.getYear(), this.getPropulsion());
    }

    // Implement methods from the IShipment interface

    /**
     * Method to load cargo onto the boat. Checks if the boat is anchored before loading.
     */
    @Override
    public void load() {
        if (!this.anchored) {
            LOGGER.warn("The boat needs to anchor!");
        } else {
            LOGGER.info("Loading...");
        }
    }
    /**
     * Method to unload cargo from the boat. Checks if the boat is anchored before unloading.
     */
    @Override
    public void unload() {
        if (!this.anchored) {
            LOGGER.info("The boat needs to anchor!");
        } else {
            LOGGER.info("Unloading...");
        }
    }
}
