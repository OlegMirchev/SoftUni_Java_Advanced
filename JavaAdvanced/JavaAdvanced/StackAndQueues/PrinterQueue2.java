package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> queuePrint = new ArrayDeque<>();

        while (!command.equals("print")) {
            if (command.equals("cancel")) {
                if (queuePrint.isEmpty()) {
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + queuePrint.poll());
                }
            }else {
               queuePrint.offer(command);
            }
            command = scanner.nextLine();
        }
        while (!queuePrint.isEmpty()) {
            System.out.println(queuePrint.poll());
        }
    }
}
