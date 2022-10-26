package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> stackURL = new ArrayDeque<>();
        ArrayDeque<String> stackSite = new ArrayDeque<>();
        String currentPage = "";
        String currentForward = "";

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (stackURL.size() < 2) {
                    System.out.println("no previous URLs");
                }else {
                    currentPage = stackURL.pop();
                    stackSite.push(currentPage);
                    System.out.println(stackURL.peek());
                }
            }else if (command.equals("forward")) {
                if (stackSite.isEmpty()) {
                    System.out.println("no next URLs");
                }else {
                    currentForward = stackSite.pop();
                    System.out.println(currentForward);
                    stackURL.push(currentForward);
                }
            }else {
                stackURL.push(command);
                System.out.println(command);
                stackSite.clear();
            }
            command = scanner.nextLine();
        }
    }
}
