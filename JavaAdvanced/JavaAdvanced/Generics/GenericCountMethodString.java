package JavaAdvanced2021.JavaAdvanced.GenericsExercises1110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericCountMethodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }
        String compareElement = scanner.nextLine();
        int countElementGreater = box.countGreater(compareElement);

        System.out.println(countElementGreater);
    }

    public static class Box<T extends Comparable<T>> {
        List<T> list;

        public Box() {
            this.list = new ArrayList<>();
        }

        public void add(T elements) {
            this.list.add(elements);
        }

        public int countGreater(T element) {
            return (int) list.stream().filter(p -> p.compareTo(element) > 0).count();
        }
    }
}