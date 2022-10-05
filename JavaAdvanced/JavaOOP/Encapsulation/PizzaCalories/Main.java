package Tasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPizza = scanner.nextLine().split("\\s+");
        try {
            String namePizza = inputPizza[1];
            int numberPizza = Integer.parseInt(inputPizza[2]);
            Pizza pizza = new Pizza(namePizza, numberPizza);

            String input = scanner.nextLine();

            while (!input.equals("END")) {
                String[] tokens = input.split("\\s+");
                String nameOrder = tokens[0];

                switch (nameOrder) {
                    case "Dough":
                        String nameDough = tokens[1];
                        String baker = tokens[2];
                        int numberDough = Integer.parseInt(tokens[3]);
                        Dough dough = new Dough(nameDough, baker, numberDough);
                        pizza.setDough(dough);
                        break;
                    case "Topping":
                        String nameTopping = tokens[1];
                        int numberTopping = Integer.parseInt(tokens[2]);
                        Topping topping = new Topping(nameTopping, numberTopping);
                        pizza.addTopping(topping);
                        break;
                }

                input = scanner.nextLine();
            }
            System.out.println(pizza);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
