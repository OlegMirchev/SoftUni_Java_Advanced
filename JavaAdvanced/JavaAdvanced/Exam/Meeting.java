package JavaAdvancedExam;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
    public static int match;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackMales = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(stackMales::push);

        ArrayDeque<Integer> queueFemales = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(queueFemales::offer);

        stackMales.removeIf(n -> n <= 0);
        queueFemales.removeIf(n -> n <= 0);

        List<Integer> listMales = new ArrayList<>();
        List<Integer> listFemales = new ArrayList<>();

        while (!stackMales.isEmpty() && !queueFemales.isEmpty()) {
            if (stackMales.peek() % 25 == 0) {
                stackMales.pop();
                stackMales.pop();
                continue;
            }
            if (queueFemales.peek() % 25 == 0) {
                queueFemales.poll();
                queueFemales.poll();
                continue;
            }

            int male = stackMales.pop();
            int female = queueFemales.poll();

            if (male == female) {
                match++;
            }else {
                if (male > 2) {
                    male -= 2;
                    stackMales.push(male);
                }
            }
        }

        while (!stackMales.isEmpty()) {
            listMales.add(stackMales.pop());
        }
        while (!queueFemales.isEmpty()){
            listFemales.add(queueFemales.poll());
        }

        System.out.println("Matches: " + match);

        if (listMales.isEmpty()) {
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: " + listMales.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (listFemales.isEmpty()) {
            System.out.println("Females left: none");
        }else {
            System.out.println("Females left: " + listFemales.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
