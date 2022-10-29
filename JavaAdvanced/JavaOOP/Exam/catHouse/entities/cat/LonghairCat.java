package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int KILOGRAMS = 9;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    public void setKilograms(int kilograms) {
        super.setKilograms(KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(KILOGRAMS + 3);
    }
}
