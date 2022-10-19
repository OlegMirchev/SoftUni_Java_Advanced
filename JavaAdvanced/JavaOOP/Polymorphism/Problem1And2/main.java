package JavaAdvanced2021.JavaOPP.PolymorphismExercises1111.Problem1And2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] infoCar = scanner.nextLine().split("\\s+");
        String[] infoTruck = scanner.nextLine().split("\\s+");
        String[] infoBus = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(infoCar[1]), Double.parseDouble(infoCar[2]), Double.parseDouble(infoCar[3]));
        Vehicle truck = new Truck(Double.parseDouble(infoTruck[1]), Double.parseDouble(infoTruck[2]), Double.parseDouble(infoTruck[3]));
        Vehicle bus = new Bus(Double.parseDouble(infoBus[1]), Double.parseDouble(infoBus[2]), Double.parseDouble(infoBus[3]));

        Map<String, Vehicle> mapVehicles = new LinkedHashMap<>();
        mapVehicles.put("Car", car);
        mapVehicles.put("Truck", truck);
        mapVehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicleType = input[1];
            double litresOrDistance = Double.parseDouble(input[2]);
            Vehicle vehicle = mapVehicles.get(vehicleType);

            switch (command) {
                case "Drive":
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(false);
                    }
                    System.out.println(vehicle.drive(litresOrDistance));
                    break;
                case "Refuel":
                    try {
                        vehicle.refuel(litresOrDistance);
                    }catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setEmpty(true);
                    }
                    System.out.println(vehicle.drive(litresOrDistance));
                    break;
            }
        }
        mapVehicles.values().forEach(System.out::println);
    }
}
