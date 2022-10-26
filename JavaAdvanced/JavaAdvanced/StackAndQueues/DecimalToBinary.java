package JavaAdvanced2021.JavaAdvanced.StackAndQueuesLAB1509;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumb = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stackNumber = new ArrayDeque<>();

        if (decimalNumb == 0) {
            System.out.println(0);
        }

        while (decimalNumb != 0) {
            stackNumber.push(decimalNumb % 2);
            decimalNumb /= 2;
        }
        while (!stackNumber.isEmpty()) {
            System.out.print(stackNumber.pop());
        }
    }
}
