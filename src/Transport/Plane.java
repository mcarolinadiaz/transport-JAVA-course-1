package Transport;

public class Plane extends AirVehicle {
    private int availableSeats;
    private String[] passengers;
    private boolean flying;
    public Plane() {
        super();
        this.availableSeats = 40;
        this.passengers = new String[this.availableSeats];
        this.flying = false;
    }
    public Plane(String model, int year, String propulsion, int availableSeats, boolean flying) {
        super(model, year, propulsion, flying);
        this.availableSeats = availableSeats;
        this.passengers = new String[this.availableSeats];
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

    @Override
    public void startUp() {
        if (!this.flying) {
            System.out.println("The plane is started up");
        }
        else {
            System.out.println("The plane has already took off and is flying!");
        }
    }


}
