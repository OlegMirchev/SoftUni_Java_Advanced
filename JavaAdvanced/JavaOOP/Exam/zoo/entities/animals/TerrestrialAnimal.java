package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal {
    public static final double KG = 5.50;
    public static final double increasesKG = 5.70;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        super.setKg(getKg() + increasesKG);
    }
}
