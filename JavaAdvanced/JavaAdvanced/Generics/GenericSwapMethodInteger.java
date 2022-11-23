package JavaAdvanced2021.JavaAdvanced.GenericsExercises1110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GenericSwapMethodInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }
        String[] index = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(index[0]);
        int secondIndex = Integer.parseInt(index[1]);
        box.swap(firstIndex, secondIndex);
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

        public void swap(int firstIndex, int secondIndex) {
            T temp = list.get(firstIndex);
            list.set(firstIndex, list.get(secondIndex));
            list.set(secondIndex, temp);
            //Collections.swap(list, firstIndex, secondIndex);
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            for (T result : list) {
                output.append(String.format("%s: %s%n", result.getClass().getName(), result));
            }
            return output.toString();
        }
    }
}
