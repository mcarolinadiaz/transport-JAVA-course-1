package Transport;

import java.util.Objects;

public class Plane extends AirVehicle {
    private int availableSeats;
    private boolean flying;
    public Plane() {
        super();
        this.availableSeats = 40;
        this.flying = false;
    }
    public Plane(String model, int year, String propulsion, int availableSeats, boolean flying) {
        super(model, year, propulsion, flying);
        this.availableSeats = availableSeats;
        this.flying = true;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void takeOff() {
        this.startUp();
        this.flying = true;
        System.out.println("The plane is flying");
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

    @Override
    public void startUp() {
        if (!this.flying) {
            System.out.println("The plane is started up");
        }
        else {
            System.out.println("The plane has already took off and is flying!");
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
    public int hashCode() {
        return Objects.hash(this.getAvailableSeats(), this.isFlying(), this.getYear(), this.getModel(),
                this.getYear(), this.getPropulsion());
    }


}
