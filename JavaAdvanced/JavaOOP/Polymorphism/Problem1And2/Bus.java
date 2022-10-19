package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem1And2;

public class Bus extends VehicleInfo {
    private static final double AIR_CONDITION = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        isEmpty = false;
    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        if (!this.isEmpty) {
        super.setFuelConsumption(fuelConsumption + AIR_CONDITION);
        }
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
