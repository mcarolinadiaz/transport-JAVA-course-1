package Transport;

import java.util.Objects;

public class Submarine extends WaterVehicle {
    private int depth;
    private boolean isSubmerge;
    private static final int MAXDEPTH = 40000;
    public Submarine() {
        super();
        this.depth = 0;
        this.isSubmerge = false;
    }
    public Submarine(String model, int year, String propulsion, int length, int depth) {
        super(model, year, propulsion, length);
        this.setDepth(depth);
        this.isSubmerge = false;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        if (MAXDEPTH > depth) {
            this.depth = depth;
        }
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

    public boolean isSubmerge() {
        return this.isSubmerge;
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if ((o == null) || (o.getClass().equals(this.getClass()))) {
            return false;
        }
        Submarine s = (Submarine) o;
        return this.getDepth() == s.getDepth() && this.getLength() == s.getLength() &&
                this.getModel().equals(s.getModel()) && this.getYear() == s.getYear() &&
                this.getPropulsion().equals(s.getPropulsion()) && this.isSubmerge() == s.isSubmerge();

    }

    @Override
    public String toString() {
        return "Submarine{" + '\'' +
                "model=" + this.getModel() + '\'' +
                "year=" + this.getYear() + '\'' +
                "propulsion=" + this.getPropulsion() + '\'' +
                "depth=" + this.getDepth() + '\'' +
                "length=" + this.getLength() + '\'' +
                "isSubmerge=" + this.isSubmerge() + '\'' +
                "}";
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.getLength(), this.getDepth(), this.getYear(), this.getModel(),
                this.getYear(), this.getPropulsion(), this.isSubmerge(), MAXDEPTH);
    }
}
