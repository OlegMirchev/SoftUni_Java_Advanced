package JavaAdvanced2021.JavaOPP.PolymorphismLAB1011.Animals;

public class main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar", "Whiskas");
        Animal dog = new Dog("Rocky", "Meat");
        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());

    }
}
