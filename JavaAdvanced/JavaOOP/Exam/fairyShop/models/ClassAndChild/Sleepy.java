package fairyShop.models.ClassAndChild;

public class Sleepy extends BaseHelper {
    private static final int ENERGY = 100;

    public Sleepy(String name) {
        super(name, ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(getEnergy() - 5);
    }
}
