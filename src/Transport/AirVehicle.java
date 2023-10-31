package Transport;

public class AirVehicle extends Vehicle {
    private boolean flying;
    public AirVehicle() {
        super();
        this.flying = false;
    }
    public AirVehicle(String model, int year, String propulsion, boolean flying) {
        super(model, year, propulsion);
        this.flying = flying;
    }
    public void takeOff() {
        this.flying = true;
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
}
