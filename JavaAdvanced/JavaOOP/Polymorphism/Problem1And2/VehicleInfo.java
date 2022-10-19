package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem1And2;

import java.text.DecimalFormat;

public abstract class VehicleInfo implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleInfo(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String drive(double distance) {
        double neededFuel = this.getFuelConsumption() * distance;
        if (neededFuel > this.fuelQuantity) {
            return getClass().getSimpleName() + " needs refueling";
        }
        this.fuelQuantity -= neededFuel;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", getClass().getSimpleName(), format.format(distance));
    }

    @Override
    public void refuel(double litres) {
        if (litres <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double newFuel = this.fuelQuantity + litres;
        if (newFuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += litres;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.fuelQuantity);
    }
}
