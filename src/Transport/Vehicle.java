package Transport;

abstract class Vehicle {
    protected String model;
    protected int year;
    protected String propulsion;
    public Vehicle() {
        this.model = "";
        this.year = 2023;
        this.propulsion = "petrol";
    }
    public Vehicle(String model, int year, String propulsion) {
        this.model = model;
        this.year = year;
        this.propulsion = propulsion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(String propulsion) {
        this.propulsion = propulsion;
    }

    public abstract void startUp();

}
