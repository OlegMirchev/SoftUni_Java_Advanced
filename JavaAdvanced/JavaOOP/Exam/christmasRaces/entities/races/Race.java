package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.List;

public interface Race {
    String getName();

    int getLaps();

    List<Driver> getDrivers();

    void addDriver(Driver driver);
}
