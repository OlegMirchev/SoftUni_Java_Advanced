package JavaAdvanced2021.JavaAdvanced.DefiningClassesLAB0110;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Constructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Car car;
            if (input.length == 1) {
                car = new Car(input[0]);
            }else {
                car = new Car(input[0] ,input[1], Integer.parseInt(input[2]));
            }
            cars.add(car);
        }
        for (Car resultCar : cars) {
            System.out.println(resultCar);
        }
    }
    public static class Car {
        private String brand;
        private String model;
        private int horsePower;

        public Car(String brand, String model, int horsePower) {
            this.brand = brand;
            this.model = model;
            this.horsePower = horsePower;
        }

        public Car(String brand, String model) {
            this(brand, model, -1);
        }

        public Car(String brand, int horsePower) {
            this(brand, "unknown", horsePower);
        }

        public Car(String brand) {
            this(brand, "unknown", -1);
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsePower());
        }
    }
}
