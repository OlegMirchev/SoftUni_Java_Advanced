package JavaAdvanced2021.JavaOPP.WorkingWithAbstractionExercise2810.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lights[] color = Arrays.stream(scanner.nextLine().split("\\s+")).map(Lights::valueOf)
                .toArray(Lights[]::new);
        int number = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLightList = new ArrayList<>();

        for (Lights lights : color) {
            TrafficLight trafficLight = new TrafficLight(lights);
            trafficLightList.add(trafficLight);
        }
        for (int i = 1; i <= number; i++) {
            for (TrafficLight trafficLightResult : trafficLightList) {
                trafficLightResult.changeLight();
                System.out.print(trafficLightResult + " ");
            }
            System.out.println();
        }
    }
}
