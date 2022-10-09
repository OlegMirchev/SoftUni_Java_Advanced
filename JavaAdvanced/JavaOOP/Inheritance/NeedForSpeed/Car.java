package JavaAdvanced2021.JavaOPP.InheritanceExercises0411.NeedForSpeed;

public class Car extends Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 3;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
