package JavaAdvanced2021.JavaAdvanced.GenericsExercises1110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }
        System.out.println(box);
    }

    public static class Box<T> {
        List<T> list;

        public Box() {
            this.list = new ArrayList<>();
        }

        public void add(T elements) {
            this.list.add(elements);
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            for (T result : list) {
                output.append(String.format("java.lang.String: %s%n", result));
            }
            return output.toString();
        }
    }
}
