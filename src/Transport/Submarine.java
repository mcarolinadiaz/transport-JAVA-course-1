package Transport;

public class Submarine extends WaterVehicle {
    private int depth;
    private boolean isSubmerge;
    public Submarine() {
        super();
        this.depth = 20000;
        this.isSubmerge = false;
    }
    public Submarine(String model, int year, String propulsion, int length, int depth) {
        super(model, year, propulsion, length);
        this.depth = depth;
        this.isSubmerge = false;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
    public void submerge() {
        this.startUp();
        this.isSubmerge = true;
        System.out.println("The submarine has been submerged");
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
        if (!isSubmerge) {
            System.out.println("The submarine is started up");
        }
        else {
            this.submerge();
            System.out.println("The plane has already submerged and is sailing!");
        }
    }
}
