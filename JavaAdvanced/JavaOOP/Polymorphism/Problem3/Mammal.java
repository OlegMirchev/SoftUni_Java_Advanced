package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem3;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(),
                format.format(this.getAnimalWeight()), this.livingRegion, this.getFoodEaten());
    }
}
