package Transport;

abstract class AirVehicle extends Vehicle {
    public AirVehicle() {
        super();
    }
    public AirVehicle(String model, int year, String propulsion, boolean flying) {
        super(model, year, propulsion);
    }
    public abstract void takeOff();
    public abstract void land();

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

    public abstract void startUp();

    @Override
    public String toString() {
        return "AirVehicle{";
    }
}
