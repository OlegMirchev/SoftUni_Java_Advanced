package JavaAdvanced2021.JavaAdvanced.SetsAndMapsAdvancedLAB2109;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regNumb = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!regNumb.equals("END")) {
            String[] command = regNumb.split(", ");
            if (command[0].equals("IN")){
                cars.add(command[1]);
            }else if (command[0].equals("OUT")) {
                cars.remove(command[1]);
            }
            regNumb = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }else {
            for (String resultCar : cars) {
                System.out.println(resultCar);
            }
        }
    }
}
