package Transport;

public class Boat extends WaterVehicle {
    private int anchors;
    public Boat() {
        super();
        this.anchors = 4;
    }
    public Boat(String model, int year, String propulsion, int length, int anchors) {
        super(model, year, propulsion, length);
        this.anchors = anchors;
    }

    public int getAnchors() {
        return anchors;
    }

    public void setAnchors(int anchors) {
        this.anchors = anchors;
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
}
