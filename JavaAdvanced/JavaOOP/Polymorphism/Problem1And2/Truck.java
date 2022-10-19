package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem1And2;

public class Truck extends VehicleInfo {
    private static final double CONSUMPTIONS_INCREASED = 1.6;
    private static final double TANK_REFUELED = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres * TANK_REFUELED);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CONSUMPTIONS_INCREASED);
    }
}
