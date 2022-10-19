package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem3;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName(), this.breed,
                format.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
