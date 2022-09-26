package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> stackProgram = new ArrayDeque<>();
        String currentPage = "";

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (stackProgram.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }else {
                    currentPage = stackProgram.pop();
                }
            }else {
                if (!currentPage.equals("")) {
                    stackProgram.push(currentPage);
                }
                currentPage = command;
            }
            System.out.println(currentPage);

            command = scanner.nextLine();
        }
    }
}
