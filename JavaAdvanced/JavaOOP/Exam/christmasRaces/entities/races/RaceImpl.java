package christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.List;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private List<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, this.name, 5));
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, laps));
        }

        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public List<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        }

        if (driver.getCar() == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName()));
        }

        if (this.drivers.contains(driver)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_ALREADY_ADDED, driver.getName(), this.name));
        }

        this.drivers.add(driver);
    }
}
