package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal {
    public static final double KG = 2.50;
    public static final double increasesKG = 7.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, KG, price);
    }

    @Override
    public void eat() {
        super.setKg(getKg() + increasesKG);
    }
}
