package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.*;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> mapEngine = new LinkedHashMap<>();
        List<CarS> listCars = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = null;
            if (input.length == 2) {
                engine = new Engine(model, power);
            } else if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (input.length == 3) {
                try {
                    int displacement = Integer.parseInt(input[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = input[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            mapEngine.put(model, engine);
        }
        int j = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= j; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engineModel = input[1];
            Engine carEngine = mapEngine.get(engineModel);
            CarS car = null;

            if (input.length == 2) {
                car = new CarS(model, carEngine);
            } else if (input.length == 4) {
                int weight = Integer.parseInt(input[2]);
                String color = input[3];
                car = new CarS(model, carEngine, weight, color);
            } else if (input.length == 3) {
                try {
                    int weight = Integer.parseInt(input[2]);
                    car = new CarS(model, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = input[2];
                    car = new CarS(model, carEngine, color);
                }
            }
            listCars.add(car);
        }
        listCars.forEach(System.out::println);
    }

    public static class CarS {
        private String model;
        private Engine engine;
        private int weight;
        private String color;

        public CarS(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            this.weight = 0;
            this.color = "n/a";
        }

        public CarS(String model, Engine engine, int weight, String color) {
            this(model, engine);
            this.weight = weight;
            this.color = color;
        }

        public CarS(String model, Engine engine, int weight) {
            this(model, engine);
            this.weight = weight;
        }

        public CarS(String model, Engine engine, String color) {
            this(model, engine);
            this.color = color;
        }

        @Override
        public String toString() {
            String printWeight = "";
            if (weight == 0) {
                printWeight = "n/a";
            } else {
                printWeight = weight + "";
            }
            return String.format("%s:%n" +
                    "%s%n" +
                    "Weight: %s%n" +
                    "Color: %s", this.model, this.engine, printWeight, this.color);
        }
    }

    public static class Engine {
        private String model;
        private int power;
        private int displacement;
        private String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
            this.displacement = 0;
            this.efficiency = "n/a";
        }

        public Engine(String model, int power, int displacement, String efficiency) {
            this(model, power);
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public Engine(String model, int power, int displacement) {
            this(model, power);
            this.displacement = displacement;
        }

        public Engine(String model, int power, String efficiency) {
            this(model, power);
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            String printDisplacement = "";
            if (displacement == 0) {
                printDisplacement = "n/a";
            } else {
                printDisplacement = displacement + "";
            }
            return String.format("%s:%n" +
                    "Power: %d%n" +
                    "Displacement: %s%n" +
                    "Efficiency: %s", this.model, this.power, printDisplacement, this.efficiency);
        }
    }
}
