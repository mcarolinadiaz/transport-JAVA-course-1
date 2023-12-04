package com.solvd.transport;

import com.solvd.transport.enums.Propulsion;
import com.solvd.transport.enums.Roads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Abstract class representing a generic land vehicle that is kind of
 * a vehicle in the Transport hierarchy.
 * This class encapsulates common properties and behaviors shared by
 * all kind of land vehicles.
 */
abstract class LandVehicle extends Vehicle {
    protected int wheels;                       // Wheels of the land vehicle
    private List<Roads> suitableTerrain;  // List of suitable terrain for the land vehicle
    // Default constructor
    public LandVehicle() {
        super();
        this.wheels = 4;
        this.suitableTerrain = new ArrayList<>();
    }
    // Custom constructor
    public LandVehicle(String model, int year, Propulsion propulsion,
                       int wheels, List<Roads> suitableTerrain) {
        super(model, year, propulsion);
        this.wheels = wheels;
        this.suitableTerrain = new ArrayList<>();
        this.setSuitableTerrain(suitableTerrain);
    }
    // Getters and setters
    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) throws InvalidValueException {
        if (wheels < 1) {
            throw new InvalidValueException("The value of wheels is invalid.");
        }
        else {
            this.wheels = wheels;
        }
    }

    public ArrayList<Roads> getSuitableTerrain() {
        return new ArrayList<>(this.suitableTerrain);
    }

    public void setSuitableTerrain(List<Roads>  suitableTerrain) {
        for (Roads r : Roads.values()) {
            this.suitableTerrain.add(r);
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

    public List<Propulsion> getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(Propulsion propulsion) {
        super.setPropulsion(propulsion);
    }

    public abstract void startUp();
    /**
     * Gets the road condition of the terrain at the specified index.
     * @param roadNumber The index of the road.
     * @return The road condition of the terrain.
     */
    public Roads.RoadCondition getRoadConditionByNumber(int roadNumber) {
        return this.suitableTerrain.get(roadNumber).getRoadCondition();
    }

    /**
     * Gets a list of roads with the specified road condition.
     * @param roadC The road condition to filter by.
     * @return List of roads with the specified road condition.
     */
    public List<Roads> getAllRoadsByCondition(Roads.RoadCondition roadC) {
        return this.suitableTerrain.stream()
                .filter(road -> road.getRoadCondition().getCondition().equals(roadC.getCondition()))
                .collect(Collectors.toList());
    }

    /**
     * Gets a list of terrain names(names of Roads) with the specified road condition.
     * @param roadC The road condition to filter by.
     * @return List of roads names with the specified road condition.
     */
    public List<String> getAllRoadsNameByCondition(Roads.RoadCondition roadC) {
        return this.suitableTerrain.stream()
                .filter(road -> road.getRoadCondition().equals(roadC))
                .map(road -> road.getRoad())
                .collect(Collectors.toList());
    }
    /**
     * Gets a list of terrains(Roads) with durability greater than or equal to the specified value.
     * @param durability The minimum durability.
     * @return List of terrains with durability above the param number.
     */
    public List<Roads> getAllMaxDurability(int durability) {
        return this.suitableTerrain.stream()
                .filter(r -> r.getDurability() >= durability)
                .collect(Collectors.toList());
    }

}
