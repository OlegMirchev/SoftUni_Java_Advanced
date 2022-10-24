package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GarageTest {

    private Garage garage;
    private Car car;

    @Before
    public void SetUp() {
        this.garage = new Garage();
        this.car = new Car("Lamborgini", 350, 300000);
        this.garage.addCar(this.car);
        Car car1 = new Car("BMW", 250, 100000);
        this.garage.addCar(car1);
        Car car2 = new Car("Honda", 150, 20000);
        this.garage.addCar(car2);
        Car car3 = new Car("Nissan", 200, 70000);
        this.garage.addCar(car3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddCarEqualsNullThrowsException() {
        this.garage.addCar(null);
    }

    @Test
    public void testMethodAddCarSuccessAddCar() {
        this.garage.addCar(this.car);
    }

    @Test
    public void testMethodFindAllCarsWithMaxSpeedAboveSpeed() {
        List<Car> actual = this.garage.findAllCarsWithMaxSpeedAbove(220);

        List<Car> expectedCars = this.garage.getCars().stream().filter(c -> c.getMaxSpeed() > 220).collect(Collectors.toList());

        Assert.assertEquals(expectedCars.size(), actual.size());
    }

    @Test
    public void testMethodGetTheMostExpensiveCarSuccessFull() {
        Car theMostExpensiveCar = this.garage.getTheMostExpensiveCar();

        Car expectedCar = this.garage.getCars().stream()
                .sorted((c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice())).findFirst().get();

        Assert.assertEquals(expectedCar.getBrand(), theMostExpensiveCar.getBrand());
    }

    @Test
    public void testMethodFindAllCarsByBrandEqualsBrandSuccess() {
        List<Car> actualCar = this.garage.findAllCarsByBrand("Nissan");

        Car expectedCar = this.garage.getCars().stream().filter(c -> c.getBrand().equals("Nissan")).findFirst().get();

        Assert.assertEquals(expectedCar, actualCar.get(0));
    }
    @Test
    public void testMethodGetCount() {
        Assert.assertEquals(4, this.garage.getCount());
    }
}