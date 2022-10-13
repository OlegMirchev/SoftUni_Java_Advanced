package Tasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameDriver = scanner.nextLine();

        Car car = new Ferrari(nameDriver);

        System.out.println(car);
    }
}
