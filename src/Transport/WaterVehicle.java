package Transport;

abstract class WaterVehicle extends Vehicle {
    private int length;
    public WaterVehicle() {
        super();
        this.length = 20000;
    }
    public WaterVehicle(String model, int year, String propulsion, int length) {
        super(model, year, propulsion);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public abstract void startUp();
}
