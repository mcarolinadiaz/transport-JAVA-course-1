package com.solvd.transport;

import com.solvd.transport.enums.CarBrand;
import com.solvd.transport.enums.Roads;
import com.solvd.transport.interfaces.IDoors;
import com.solvd.transport.interfaces.IElectricTransport;
import com.solvd.transport.interfaces.IStartUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class can be created to model different cars with varying
 *  * models, years, propulsion mechanisms, and door configurations.
 */
public final class Car extends LandVehicle implements IElectricTransport, AutoCloseable {
    // properties
    private static final Logger LOGGER = LogManager.getLogger(Car.class);
    private final int doors;
    private List<Boolean> doorsClosed;
    private boolean lowBattery;
    private CarBrand carBrand;
    private IStartUp<Car> iSU = (x) -> {
        if (this.areDoorsClosed()) {
            LOGGER.info("The car "+x+" has started up successfully.");
        } else {
            this.closeDoors();
            LOGGER.info("Doors were closed and the car "+x+" has started up successfully.");
        }
    };

    private IDoors<Boolean> iDoors;
    /**
     * Default constructor
     */
    public Car() {
        super();
        this.doors = 4;
        this.lowBattery = true;
        this.doorsClosed = new ArrayList<Boolean>();
        this.initDoorsClosed();
        iDoors = (x) -> {
            for (int i=0; i < this.doors; i++) {
                if (i >= this.doorsClosed.size()) {
                    this.doorsClosed.add(x);
                } else {
                    this.doorsClosed.set(i, x);
                }
            }
        };
    }
    public Car(String model, int year, String propulsion, int wheels, List<Roads> suitableTerrain, int doors) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.doors = doors;
        this.doorsClosed = new ArrayList<Boolean>();
        this.initDoorsClosed();
        this.lowBattery = true;
        iDoors = (x) -> {
            for (int i=0; i < this.doors; i++) {
                if (i >= this.doorsClosed.size()) {
                    this.doorsClosed.add(x);
                } else {
                    this.doorsClosed.set(i, x);
                }
            }
        };
    }
    private void initDoorsClosed() {
        for (int i=0; i< this.doors; i++) {
            this.doorsClosed.add(true);
        }
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

    public ArrayList<Roads> getSuitableTerrain() {
        return super.getSuitableTerrain();
    }

    public void setSuitableTerrain(ArrayList<Roads> suitableTerrain) {
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

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    /**
     * Opens the doors of the car.
     * If the number of doors exceeds the current configuration, additional doors are added.
     * Existing doors are set to the open state (true).
     */
    public void openDoors() {
        if (this.iDoors != null) {
            this.iDoors.openClose(true);
        }
    }
    /**
     * Closes the doors of the car.
     * If the number of doors exceeds the current configuration, additional doors are added.
     * Existing doors are set to the closed state (false).
     */
    public void closeDoors() {
        if (this.iDoors != null) {
            this.iDoors.openClose(false);
        }
    }

    public boolean areDoorsClosed() {
        return !(this.doorsClosed.contains(false));
    }
    /**
     * Starts up the car.
     * If the doors are already closed, the car is started up, and an information log is generated.
     * If any doors are open, they are automatically closed before starting up, and a corresponding log is generated.
     */
    @Override
    public void startUp() {
        this.iSU.run(this);
    }


    @Override
    public void chargeEnergy() {
        this.lowBattery = false;
    }
    /**
     * Closes the car as an AutoCloseable resource.
     * The usage of this exception may need to be revisited for better design and consistency.
     *
     */
    @Override
    public void close() throws NotClosedException {
        throw new NotClosedException("Car was closed");
    }

    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                ", doorsClosed=" + doorsClosed +
                ", lowBattery=" + lowBattery +
                ", wheels=" + wheels +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", propulsion='" + propulsion + '\'' +
                '}';
    }
}
