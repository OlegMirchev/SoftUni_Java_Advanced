package Tasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] elements = scanner.nextLine().split("\\s+");
        int removeCount = Integer.parseInt(scanner.nextLine());

        printAdd(elements, addCollection);
        printAdd(elements, addRemoveCollection);
        printAdd(elements, myList);
        printRemove(removeCount, addRemoveCollection);
        printRemove(removeCount, myList);
    }

    private static void printAdd(String[] elements, Addable collection) {
        for (String tokens : elements) {
            System.out.print(collection.add(tokens) + " ");
        }
        System.out.println();
    }

    private static void printRemove(int removeCount, AddRemovable collection) {
        for (int i = 0; i < removeCount; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
