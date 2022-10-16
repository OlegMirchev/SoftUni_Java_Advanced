package JavaAdvanced2021.JavaOPP.InterfacesAndAbstractionExercises0811.FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> listBuyer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Buyer buyer = null;
            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }else if (tokens.length == 3){
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }else {
                throw new IllegalArgumentException("Wrong input");
            }
            listBuyer.add(buyer);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            for (Buyer buyer : listBuyer) {
                if (command.equals(buyer.getName())) {
                    buyer.buyFood();
                    break;
                }
            }
            command = scanner.nextLine();
        }
        int totalFood = 0;

        for (Buyer buyer : listBuyer) {
            totalFood += buyer.getFood();
        }
        System.out.println(totalFood);
    }
}
