package JavaAdvancedExam.Parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
      return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
       if (this.data.isEmpty()) {
           return null;
       }

       return this.data.stream().max(Comparator.comparing(Car::getYear)).get();
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
       return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder(String.format("The cars are parked in %s:%n", this.type));

        for (Car car : data) {
            output.append(car).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
