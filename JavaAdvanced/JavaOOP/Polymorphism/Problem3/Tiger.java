package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem3;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void Eat(Food food) {
        if (food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.Eat(food);
    }
}
