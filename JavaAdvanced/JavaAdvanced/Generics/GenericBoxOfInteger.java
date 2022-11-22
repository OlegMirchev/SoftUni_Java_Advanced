package JavaAdvanced2021.JavaAdvanced.GenericsExercises1110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericBoxOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            box.add(number);
        }
        System.out.println(box);
    }

    public static class Box<T> {
        List<T> list;

        public Box() {
            this.list = new ArrayList<>();
        }

        public void add(T element) {
            this.list.add(element);
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            for (T result : list) {
                output.append(String.format("java.lang.Integer: %s%n", result));
            }
            return output.toString();
        }
    }
}
