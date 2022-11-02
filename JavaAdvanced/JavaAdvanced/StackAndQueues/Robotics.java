package JavaAdvanced2021.JavaAdvanced.StacksAndQueuesExercises1609;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
        String[] nameRobots = new String[robots.size()];
        int[] processingTime = new int[robots.size()];
        int count = 0;

        for (String splitNameTime : robots) {
            String[] splitNameTime1 = splitNameTime.split("-");
            String name = splitNameTime1[0];
            nameRobots[count] = name;
            int timeRobots = Integer.parseInt(splitNameTime1[1]);
            processingTime[count] = timeRobots;
            count++;
        }
        String startTime = scanner.nextLine();
        String input = scanner.nextLine();
        ArrayDeque<String> queueProducts = new ArrayDeque<>();

        while (!input.equals("End")) {
            queueProducts.offer(input);

            input = scanner.nextLine();
        }
        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int allTimeInSeconds = hours * 3600 + minutes * 60 + seconds;
        int [] robotsWorking = new int[robots.size()];

        while (!queueProducts.isEmpty()) {
            allTimeInSeconds++;
            String product = queueProducts.poll();
            int index = -1;

            for (int i = 0; i < robotsWorking.length; i++) {
                if (robotsWorking[i] > 0) {
                    robotsWorking[i]--;
                }
                if (robotsWorking[i] == 0 && index == -1) {
                    index = i;
                }
            }

            if (index != -1) {
                robotsWorking[index] = processingTime[index];
                System.out.println(printRobotData(nameRobots[index], product, allTimeInSeconds));
            }else {
                queueProducts.offer(product);
            }
        }
    }

    private static String printRobotData(String nameRobot, String product, int allTimeInSeconds) {
        int hours = allTimeInSeconds / 3600 % 24;
        int minutes = allTimeInSeconds / 60 % 60;
        int seconds = allTimeInSeconds % 60;
       return String.format("%s - %s [%02d:%02d:%02d]", nameRobot, product, hours, minutes, seconds);
    }
}
