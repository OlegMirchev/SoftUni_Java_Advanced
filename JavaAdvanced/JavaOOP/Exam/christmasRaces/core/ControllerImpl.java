package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.CarRepository;
import christmasRaces.repositories.interfaces.DriverRepository;
import christmasRaces.repositories.interfaces.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DriverRepository driverRepository;
    private CarRepository carRepository;
    private RaceRepository raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository , Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = (DriverRepository) driverRepository;
        this.carRepository = (CarRepository) carRepository;
        this.raceRepository = (RaceRepository) raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driver1 = new DriverImpl(driver);

        for (Driver d : this.driverRepository.getAll()) {
            if (d.getName().equals(driver1.getName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
            }
        }

        this.driverRepository.add(driver1);

        return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = type.equals("Muscle")
                ? new MuscleCar(model, horsePower)
                : new SportsCar(model, horsePower);

        for (Car c : this.carRepository.getAll()) {
            if (c.getModel().equals(car.getModel())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, model));
            }
        }

        this.carRepository.add(car);

        return String.format(OutputMessages.CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver byNameDriver = this.driverRepository.getByName(driverName);
        Car byNameCar = this.carRepository.getByName(carModel);

        if (!this.driverRepository.getAll().contains(byNameDriver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        if (!this.carRepository.getAll().contains(byNameCar)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }

        byNameDriver.addCar(byNameCar);

        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race byNameRace = this.raceRepository.getByName(raceName);
        Driver byNameDriver = this.driverRepository.getByName(driverName);

        if (!this.raceRepository.getAll().contains(byNameRace)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (!this.driverRepository.getAll().contains(byNameDriver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }

        byNameRace.addDriver(byNameDriver);

        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race byNameRace = this.raceRepository.getByName(raceName);
        int participants = this.driverRepository.getAll().size();

        if (!this.raceRepository.getAll().contains(byNameRace)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        if (participants < 3) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, 3));
        }

        List<Driver> collect = this.driverRepository.getAll().stream()
                .sorted(Comparator.comparing(d -> d.getCar().calculateRacePoints(byNameRace.getLaps()))).collect(Collectors.toList());

        Collections.reverse(collect);

        this.raceRepository.remove(byNameRace);

        StringBuilder output = new StringBuilder();
        output.append(String.format(OutputMessages.DRIVER_FIRST_POSITION, collect.get(0).getName(), raceName)).append(System.lineSeparator());
        output.append(String.format(OutputMessages.DRIVER_SECOND_POSITION, collect.get(1).getName(), raceName)).append(System.lineSeparator());
        output.append(String.format(OutputMessages.DRIVER_THIRD_POSITION, collect.get(2).getName(), raceName)).append(System.lineSeparator());

        return output.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (this.raceRepository.getAll().contains(race)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }

        this.raceRepository.add(race);

        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
