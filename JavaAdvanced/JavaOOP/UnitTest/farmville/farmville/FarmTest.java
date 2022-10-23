package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FarmTest {

    private Farm farm;
    private Animal animal;

    @Before
    public void SetUp() {
        this.farm = new Farm("NashVille", 3);
        this.animal = new Animal("Dog", 10.00);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsNullThrowsException() {
        this.farm = new Farm(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsWhiteSpaceThrowsException() {
        this.farm = new Farm("  ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetCapacityEqualsBelowThanZeroThrowsException() {
        this.farm = new Farm("NashVille", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddSizeEqualsCapacityThrowsException() {
        this.farm.add(this.animal);
        Animal animal1 = new Animal("Cow", 40.00);
        this.farm.add(animal1);
        Animal animal2 = new Animal("Horse", 60.00);
        this.farm.add(animal2);
        Animal animal3 = new Animal("Duck", 5.00);
        this.farm.add(animal3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddAnimalAlreadyExistsThrowsException() {
        this.farm.add(this.animal);
        this.farm.add(this.animal);
    }

    @Test
    public void testMethodAddAnimalSuccessful() {
        this.farm.add(this.animal);

        Assert.assertEquals(1, this.farm.getCount());
    }

    @Test
    public void testMethodRemoveAnimalSuccessfulTrue() {
        this.farm.add(this.animal);
        boolean isRemove = this.farm.remove(this.animal.getType());

        Assert.assertTrue(isRemove);
    }

    @Test
    public void testMethodRemoveAnimalNullFalse() {
        boolean isRemove = this.farm.remove(this.animal.getType());

        Assert.assertFalse(isRemove);
    }

    @Test
    public void testMethodGetNameFarm() {
        Assert.assertEquals("NashVille", this.farm.getName());
    }

    @Test
    public void testMethodGetEnergyAnimal() {
        Animal animal1 = new Animal("Cat", 2.00);

        assertEquals(2.00, animal1.getEnergy(), 0.0);
    }

}