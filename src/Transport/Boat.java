package Transport;

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
}
