package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTest {

    private House house;
    private Cat cat;

    @Before
    public void SetUp() {
        this.house = new House("ShortHouse", 5);
        this.cat = new Cat("Max");
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsNullThrowsException() {
        this.house = new House(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testMethodSetNameEqualsWhiteSpaceThrowsException() {
        this.house = new House("  ", 2);
    }

    @Test
    public void testMethodSetNameSuccessfulName() {
        this.house = new House("ShortHouse", 5);

        Assert.assertEquals("ShortHouse", this.house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodSetCapacityBelowThanZeroThrowsException() {
        this.house = new House("ShortHouse", -1);
    }

    @Test
    public void testMethodSetCapacitySuccessfulCapacity() {
        this.house = new House("ShortHouse", 5);

        Assert.assertEquals(5, this.house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddCatIfSizeEqualsCapacityThrowsException() {
        this.house.addCat(this.cat);
        this.house.addCat(this.cat);
        this.house.addCat(this.cat);
        this.house.addCat(this.cat);
        this.house.addCat(this.cat);
        this.house.addCat(this.cat);
    }

    @Test
    public void testMethodAddCatSuccessfulCat() {
        this.house.addCat(this.cat);

        Assert.assertEquals(1, this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodRemoveCatEqualsNullThrowsException() {
        this.house.removeCat("Mike");
    }

    @Test
    public void testMethodRemoveCatEqualsNameSuccess() {
        this.house.addCat(this.cat);

        Assert.assertEquals(1, this.house.getCount());

        this.house.removeCat(this.cat.getName());

        Assert.assertEquals(0, this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodCatForSaleEqualsNullThrowsException() {
        this.house.catForSale("Mike");
    }

    @Test
    public void testMethodCatForSaleEqualsNameSuccess() {
        this.house.addCat(this.cat);
        Cat cat = this.house.catForSale(this.cat.getName());

        Assert.assertFalse(this.cat.isHungry());

        Assert.assertEquals(this.cat.getName(), cat.getName());
    }

    @Test
    public void testMethodStatisticsReturnString() {
        Cat cat2 = new Cat("Fox");
        this.house.addCat(this.cat);
        this.house.addCat(cat2);
        String actual = this.house.statistics();
        String expected = "The cat Max, Fox is in the house ShortHouse!";

        Assert.assertEquals(expected, actual);
    }
}