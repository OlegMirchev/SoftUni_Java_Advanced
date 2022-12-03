package JavaAdvancedExam;

import java.util.*;

public class OSPlanning {
    public static int threadKillTask = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(stackTasks::push);

        ArrayDeque<Integer> queueThreads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(queueThreads::offer);

        int valueTask = Integer.parseInt(scanner.nextLine());

        List<Integer> listThreads = new ArrayList<>();

        while (!stackTasks.isEmpty() && !queueThreads.isEmpty()) {
            int task = stackTasks.peek();
            int thread = queueThreads.peek();

            if (task == valueTask || thread == valueTask) {
                threadKillTask = thread;
                break;
            }

            if (thread >= task) {
                stackTasks.pop();
            }

            queueThreads.poll();
        }

        while (!queueThreads.isEmpty()) {
            listThreads.add(queueThreads.poll());
        }

        System.out.printf("Thread with value %d killed task %d%n", threadKillTask, valueTask);

        listThreads.forEach(e -> System.out.print(e + " "));
    }
}
