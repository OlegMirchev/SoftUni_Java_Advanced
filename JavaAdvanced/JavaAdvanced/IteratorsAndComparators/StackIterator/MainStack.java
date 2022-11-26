package IteratorsAndComparators;

import java.util.*;

public class MainStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StackIterator stack = new StackIterator();

        while (!input.equals("END")) {
            String[] command = input.split(" ");
            String newCommand = command[0];

            switch (newCommand) {
                case "Push":
                    int[] ints = Arrays.stream(input.substring(5).trim().split(", ")).mapToInt(Integer::parseInt).toArray();
                    stack.push(ints);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        List<Integer> numbers = new ArrayList<>();

        for (Integer number : stack) {
            numbers.add(number);
        }

        numbers.forEach(System.out::println);
        numbers.forEach(System.out::println);
    }
}
