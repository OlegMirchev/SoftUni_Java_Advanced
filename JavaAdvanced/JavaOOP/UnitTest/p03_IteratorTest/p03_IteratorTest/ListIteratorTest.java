package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private  ListIterator listIterator;

    @Before
    public void SetUp() throws OperationNotSupportedException {
       this.listIterator = new ListIterator("A", "B", "C");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorOnListIteratorThrowsExceptionForEqualsNull() throws OperationNotSupportedException {
      this.listIterator = new ListIterator(null);
    }

    @Test
    public void testMethodMoveHasNextElementsTrue() {
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void testMethodMoveHasNextElementsFalse() {
        this.listIterator.move();
        this.listIterator.move();

        Assert.assertFalse(this.listIterator.move());
    }

    @Test
    public void testMethodHasNextElementsTrue() {
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void testMethodHasNextElementsFalse() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("A");

        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testMethodPrintThrowsExceptionForEmptyListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void testMethodPrintReturnCurrentIndexSuccess() {
        String actual = this.listIterator.print();

        Assert.assertEquals("A", actual);
    }
}