package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem1And2;

public class Car extends VehicleInfo {
    private static final double CONSUMPTIONS_INCREASED = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + CONSUMPTIONS_INCREASED);
    }
}
