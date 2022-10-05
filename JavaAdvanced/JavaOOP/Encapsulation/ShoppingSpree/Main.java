package Tasks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPerson = scanner.nextLine().split(";");

        Map<String, Person> mapPeople = new LinkedHashMap<>();
        Map<String, Product> mapProducts = new LinkedHashMap<>();

        if (readPeople(inputPerson, mapPeople)) {
            return;
        }

        String[] inputProduct = scanner.nextLine().split(";");

        if (readProducts(mapProducts, inputProduct)) {
            return;
        }

        String command = scanner.nextLine();

        readCommandAndBuyProducts(scanner, mapPeople, mapProducts, command);

        for (Person person : mapPeople.values()) {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(Product::getName).collect(Collectors.joining(", ")));
            }
        }
    }

    private static void readCommandAndBuyProducts(Scanner scanner, Map<String, Person> mapPeople, Map<String, Product> mapProducts, String command) {
        while (!command.equals("END")) {
            String[] newCommand = command.split("\\s+");
            String namePerson = newCommand[0];
            String nameProduct = newCommand[1];

            try {
                Person person = mapPeople.get(namePerson);
                Product product = mapProducts.get(nameProduct);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }
    }

    private static boolean readProducts(Map<String, Product> mapProducts, String[] inputProduct) {
        for (String product : inputProduct) {
            String[] productsParts = product.split("=");
            String nameProduct = productsParts[0];
            double costProduct = Double.parseDouble(productsParts[1]);

            try {
                Product products = new Product(nameProduct, costProduct);
                mapProducts.put(nameProduct, products);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    private static boolean readPeople(String[] inputPerson, Map<String, Person> mapPeople) {
        for (String person : inputPerson) {
            String[] personParts = person.split("=");
            String namePerson = personParts[0];
            double moneyPerson = Double.parseDouble(personParts[1]);

            try {
                Person people = new Person(namePerson, moneyPerson);
                mapPeople.put(namePerson, people);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
}
