public class Vehicle {

    private int passengers;
    private double fuelCap;
    private double mpg;

    public Vehicle(int passengers, double fuelCap, double mpg) {
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.mpg = mpg;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(double fuelCap) {
        this.fuelCap = fuelCap;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "passengers: " + passengers +
               ", fuelCap: " + fuelCap +
               ", mpg: " + mpg;
    }
}