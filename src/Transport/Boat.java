package Transport;

import java.util.Objects;

public class Boat extends WaterVehicle {
    private int anchors;
    private boolean anchored;
    public Boat() {
        super();
        this.anchors = 4;
        this.anchored = true;
    }
    public Boat(String model, int year, String propulsion, int length, int anchors) {
        super(model, year, propulsion, length);
        this.anchors = anchors;
        this.anchored = true;
    }

    public int getAnchors() {
        return anchors;
    }

    public void setAnchors(int anchors) {
        this.anchors = anchors;
    }

    public void raiseAnchors() {
        this.anchored = false;
    }

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

    public String getPropulsion() {
        return super.getPropulsion();
    }

    public void setPropulsion(String propulsion) {
        super.setPropulsion(propulsion);
    }

    @Override
    public void startUp() {
        if (this.anchored) {
            this.raiseAnchors();
        }
        System.out.println("The anchors have been raised and the boat is underway");
    }

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
                this.getModel().equals(b.getModel()) && this.getYear() == b.getYear() &&
                this.propulsion.equals(b.getPropulsion());

    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.getLength(), this.getAnchors(), this.getYear(), this.getModel(),
                this.getYear(), this.getPropulsion());
    }
}
