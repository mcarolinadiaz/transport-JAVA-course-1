package Transport;

import java.util.ArrayList;
import java.util.Objects;

public class Lorry extends LandVehicle implements IShipment {
    private int load;
    public Lorry() {
        super();
        this.load = 0;
    }
    public Lorry(String model, int year, String propulsion, int wheels, ArrayList<String> suitableTerrain, int load) {
        super(model, year, propulsion, wheels, suitableTerrain);
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
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
        System.out.println("The lorry is started up");
    }

    @Override
    public void load() {

    }

    @Override
    public void unload() {

    }
}
