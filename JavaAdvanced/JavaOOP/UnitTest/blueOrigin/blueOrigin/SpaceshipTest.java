package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTest {

    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void SetUp() {
        this.spaceship = new Spaceship("Falkon99", 3);
        this.astronaut = new Astronaut("Mike", 15.00);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsNullThrowsException() {
        this.spaceship = new Spaceship(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsWhiteSpaceThrowsException() {
        this.spaceship = new Spaceship(" ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetCapacityBelowThanZeroThrowsException() {
        this.spaceship = new Spaceship("Apollo65", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddSizeAstronautEqualsCapacityThrowsException() {
        this.spaceship.add(this.astronaut);
        Astronaut astronaut2 = new Astronaut("Max", 10.00);
        this.spaceship.add(astronaut2);
        Astronaut astronaut3 = new Astronaut("Poly", 5.00);
        this.spaceship.add(astronaut3);
        Astronaut astronaut4 = new Astronaut("Penny", 2.00);
        this.spaceship.add(astronaut4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddAstronautExistsIsTrueThrowsException() {
        this.spaceship.add(this.astronaut);
        this.spaceship.add(this.astronaut);
    }

    @Test
    public void testMethodAddAstronautSuccessFull() {
        this.spaceship.add(this.astronaut);

        Assert.assertEquals(1, this.spaceship.getCount());
    }

    @Test
    public void testMethodRemoveAstronautSuccessFullAndReturnTrue() {
        this.spaceship.add(this.astronaut);
        boolean isRemove = this.spaceship.remove(this.astronaut.getName());

        Assert.assertTrue(isRemove);
    }

    @Test
    public void testMethodRemoveAstronautNotSuccessFullAndReturnFalse() {
        boolean isRemove = this.spaceship.remove(this.astronaut.getName());

        Assert.assertFalse(isRemove);
    }
}