package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.CardRank;

public class main3 {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");

        for (Ranks value : Ranks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }
}
