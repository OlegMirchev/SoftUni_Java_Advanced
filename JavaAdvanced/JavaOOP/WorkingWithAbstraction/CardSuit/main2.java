package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.CardSuit;

public class main2 {
    public static void main(String[] args) {
        System.out.println("Card Suits:");

        for (Cards value : Cards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }
}
