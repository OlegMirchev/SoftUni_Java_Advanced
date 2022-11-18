package JavaAdvanced2021.JavaAdvanced.DefiningClassesLAB0110;

import java.util.Scanner;

public class CarInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            Car car = new Car(brand, model, horsePower);
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower());
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

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }
    }
}

