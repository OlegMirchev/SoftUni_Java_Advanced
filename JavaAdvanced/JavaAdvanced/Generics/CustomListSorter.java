package JavaAdvanced2021.JavaAdvanced.GenericsExercises1110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomListSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> customList = new CustomList<>();

        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            String newCommand = command[0];

            switch (newCommand) {
                case "Add":
                    customList.add(command[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(command[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(command[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "Greater":
                    int count = customList.countGreaterThan(command[1]);
                    System.out.println(count);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public static class CustomList<T extends Comparable<T>> {
        private List<T> list;

        public CustomList() {
            this.list = new ArrayList<>();
        }

        public void add(T element) {
            this.list.add(element);
        }

        public T remove(int index) {
            return this.list.remove(index);
        }

        public boolean contains(T element) {
            return this.list.contains(element);
        }

        public void swap(int firstIndex, int secondIndex) {
            Collections.swap(list, firstIndex, secondIndex);
        }

        public int countGreaterThan(T element) {
            return (int) this.list.stream().filter(p -> p.compareTo(element) > 0).count();
        }

        public T getMin() {
            //return this.list.stream().min((value1, value2) -> value1.compareTo(value2)).get();
            return Collections.min(this.list);
        }

        public T getMax() {
            //return this.list.stream().max((value1, value2) -> value1.compareTo(value2)).get();
            return Collections.max(this.list);
        }

        public int size() {
            return list.size();
        }

        public T get(int index) {
            return list.get(index);
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            for (T result : list) {
                output.append(String.format("%s%n", result));
            }
            return output.toString();
        }
    }

    public static class Sorter {

        public static <T extends Comparable<T>> void sort(CustomList<T> list) {
            for (int i = 0; i < list.size(); i++) {
                T elements = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    T nextElements = list.get(j);

                    if (elements.compareTo(nextElements) > 0) {
                        list.swap(i, j);
                    }
                }
            }
        }
    }
}

