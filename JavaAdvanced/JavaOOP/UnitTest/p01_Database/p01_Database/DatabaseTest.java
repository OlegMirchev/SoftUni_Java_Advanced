package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private Integer[] integers;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        this.integers = new Integer[]{1, 2, 3, 4};
        this.database = new Database(this.integers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetElementsMethodThrowExceptionMore16() throws OperationNotSupportedException {
        Integer[] integer = new Integer[17];
        this.database = new Database(integer);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetElementsMethodThrowExceptionLess1() throws OperationNotSupportedException {
        Integer[] integer = new Integer[0];
        this.database = new Database(integer);
    }

    @Test
    public void testSetElementsMethodSuccessLength() {
        Integer[] actual = this.database.getElements();

        Assert.assertEquals(this.integers.length, actual.length);
        Assert.assertArrayEquals(actual, this.integers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodElementsEqualsNull() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddMethodElementsExists() throws OperationNotSupportedException {
        this.database.add(5);
        int actual = this.database.getElements()[4];

        Assert.assertEquals(this.integers.length + 1, this.database.getElements().length);
        Assert.assertEquals(5, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodIsOutOfBounds() throws OperationNotSupportedException {
//        for (int i = 0; i < this.integers.length; i++) {
//            this.database.remove();
//        }
//        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void testRemoveMethodElementsExists() throws OperationNotSupportedException {
       this.database.remove();
       Integer[] actual = this.database.getElements();

        Assert.assertEquals(this.integers.length - 1, this.database.getElements().length);
        Assert.assertEquals(Integer.valueOf(3), actual[actual.length - 1]);
    }


}