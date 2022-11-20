package JavaAdvanced2021.JavaAdvanced.DefiningClassesExercises0410;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Cars> listCar = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engines engines = new Engines(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            ArrayList<Tired> listTire = new ArrayList<>();
            Tired tired = new Tired(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age,
                    tire4Pressure, tire4Age);
            listTire.add(tired);

            Cars car = new Cars(model,engines,cargo, listTire);
            listCar.add(car);
        }
        String command = scanner.nextLine();
        List<String> output = new ArrayList<>();

        if (command.equals("fragile")) {
            listCar.forEach(r -> {
                for (Tired tired : r.getTired()) {
                    if (tired.getTire1Pressure() < 1 || tired.getTire2Pressure() < 1 || tired.getTire3Pressure() < 1
                            || tired.getTire4Pressure() < 1) {
                        output.add(r.getModel());
                    }
                }
            });
        }else if (command.equals("flamable")) {
            listCar.forEach(r -> {
                if (r.getEngines().getEnginePower() > 250) {
                    output.add(r.getModel());
                }
            });
        }
        output.forEach(System.out::println);
    }
    public static class Cars {
        private String model;
        private Engines engines;
        private Cargo cargo;
        private ArrayList<Tired> tired;

        public Cars(String model, Engines engines, Cargo cargo, ArrayList<Tired> tired) {
            this.model = model;
            this.engines = engines;
            this.cargo = cargo;
            this.tired = tired;
        }

        public String getModel() {
            return model;
        }

        public Engines getEngines() {
            return engines;
        }

        public ArrayList<Tired> getTired() {
            return tired;
        }
    }
    public static class Engines {
        private int engineSpeed;
        private int enginePower;

        public Engines(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }
    public static class Cargo {
        private int cargoWeight;
        private String CargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            CargoType = cargoType;
        }

        public String getCargoType() {
            return CargoType;
        }
    }
    public static class Tired {
        private double tire1Pressure;
        private int tire1Age;
        private double tire2Pressure;
        private int tire2Age;
        private double tire3Pressure;
        private int tire3Age;
        private double tire4Pressure;
        private int tire4Age;

        public Tired(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
            this.tire1Pressure = tire1Pressure;
            this.tire1Age = tire1Age;
            this.tire2Pressure = tire2Pressure;
            this.tire2Age = tire2Age;
            this.tire3Pressure = tire3Pressure;
            this.tire3Age = tire3Age;
            this.tire4Pressure = tire4Pressure;
            this.tire4Age = tire4Age;
        }

        public double getTire1Pressure() {
            return tire1Pressure;
        }

        public double getTire2Pressure() {
            return tire2Pressure;
        }

        public double getTire3Pressure() {
            return tire3Pressure;
        }

        public double getTire4Pressure() {
            return tire4Pressure;
        }
    }
}
