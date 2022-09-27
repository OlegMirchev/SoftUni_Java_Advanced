package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionLAB2610.Hotel;

import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double price = Double.parseDouble(input[0]);
        int numberDay = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        Discount1 discount = Discount1.getDiscount(input[3]);

        PriceCalculator calculator = new PriceCalculator(price, numberDay, season, discount);

        System.out.printf("%.2f%n", calculator.calculatePrice());

    }
}
