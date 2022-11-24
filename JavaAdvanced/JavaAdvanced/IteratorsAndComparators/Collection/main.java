import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ListyIterator listyIterator = null;

        while (!command.equals("END")) {
            String[] newCommand = command.split("\\s+");
            switch (newCommand[0]) {
                case "Create":
                    if (newCommand.length > 1) {
                        listyIterator = new ListyIterator(Arrays.copyOfRange(newCommand, 1, newCommand.length));
                    } else {
                        listyIterator = new ListyIterator();
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;

            }
            command = scanner.nextLine();
        }
    }
}

