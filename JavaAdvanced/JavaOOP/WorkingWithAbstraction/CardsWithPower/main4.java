package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.CardsWithPower;

import java.util.Scanner;

public class main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ranks rank = Ranks.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, rank.getPowerRank() + suit.getPowerSuit());
    }
}
