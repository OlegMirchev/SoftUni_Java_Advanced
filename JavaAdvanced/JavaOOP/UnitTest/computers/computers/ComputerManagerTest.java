package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTest {
    private Computer computer;
    private ComputerManager listComputers;

    @Before
    public void SetUp() {
        this.computer = new Computer("Laptop", "Acer", 1000);
        this.listComputers = new ComputerManager();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodValidateNullValueFromAddComputerMethodThrowError() {
        this.listComputers.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddComputerThrowErrorAlreadyExist() {
        this.listComputers.addComputer(this.computer);
        this.listComputers.addComputer(this.computer);
    }

    @Test
    public void testMethodAddComputerSuccessfully() {
        this.listComputers.addComputer(this.computer);

        Assert.assertEquals(1, this.listComputers.getCount());
    }

    @Test
    public void testMethodRemoveComputerSuccessfullyReturnComputer() {
        this.listComputers.addComputer(this.computer);
        this.listComputers.removeComputer("Laptop", "Acer");

        Assert.assertEquals(0, this.listComputers.getComputers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodValidateNullValueFromGetComputerMethodThrowErrorManufacturer() {
        this.listComputers.getComputer(null, "Acer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodValidateNullValueFromGetComputerMethodThrowErrorModel() {
        this.listComputers.getComputer("Laptop", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodGetComputerThrowError() {
        this.listComputers.getComputer("Laptop", "Acer");
    }

    @Test
    public void testMethodGetComputerSuccessfullyReturnComputer() {
        this.listComputers.addComputer(this.computer);
        Computer actual = this.listComputers.getComputer("Laptop", "Acer");

        Assert.assertEquals(this.computer, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodValidateNullValueFromGetComputersByManufacturerMethodThrowErrorManufacturer() {
        this.listComputers.getComputer(null, "Acer");
    }

    @Test
    public void testMethodGetComputersByManufacturerSuccessfullyReturnComputers() {
        Computer computer1 = new Computer("Laptop", "Asus", 1000);
        Computer computer2 = new Computer("DeskComputer", "Toshiba", 400);
        this.listComputers.addComputer(this.computer);
        this.listComputers.addComputer(computer1);
        this.listComputers.addComputer(computer2);

        List<Computer> computersByManufacturer = this.listComputers.getComputersByManufacturer("Laptop");
        int actual = computersByManufacturer.size();

        Assert.assertEquals(2, actual);
    }
}