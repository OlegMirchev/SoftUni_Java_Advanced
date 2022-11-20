package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeedRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> mapCars = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double consumption = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, consumption);

            mapCars.put(model, car);

        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] newCommand = command.split("\\s+");
            String brand = newCommand[1];
            double kmToTravel = Double.parseDouble(newCommand[2]);
            Car car = mapCars.get(brand);
            if (!car.drive(kmToTravel)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        mapCars.values().forEach(System.out::println);
    }

    public static class Car {
        private String model;
        private double fuelAmount;
        private double consumption;
        private double distanceTravel;

        public Car(String model, double fuelAmount, double consumption) {
            this.model = model;
            this.fuelAmount = fuelAmount;
            this.consumption = consumption;
            this.distanceTravel = 0;
        }

        public boolean drive(double kmToDrive) {
            double fuel = kmToDrive * consumption;
            if (fuel > this.fuelAmount) {
                return false;
            } else {
                this.fuelAmount -= fuel;
                this.distanceTravel += kmToDrive;
                return true;
            }
        }

        @Override
        public String toString() {
            return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.distanceTravel);
        }
    }
}
