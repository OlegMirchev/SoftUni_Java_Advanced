package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class DatabaseTestAndPerson {

    private p02_ExtendedDatabase.Database database;
    private Person[] person;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        this.person = new Person[]{new Person(10, "Sasho"), new Person(20, "Pesho")};
        this.database = new p02_ExtendedDatabase.Database(this.person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetElementsMethodThrowExceptionMore16() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        this.database = new p02_ExtendedDatabase.Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetElementsMethodThrowExceptionLess1() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        this.database = new Database(people);
    }

    @Test
    public void testSetElementsMethodSuccessLength() {
        Person[] actual = this.database.getElements();

        Assert.assertEquals(this.person.length, actual.length);
        Assert.assertArrayEquals(actual, this.person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodElementsEqualsNull() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddMethodElementsExists() throws OperationNotSupportedException {
        this.database.add(new Person(30, "Toshko"));
        Person[] people = this.database.getElements();
        String actual = null;
        for (Person p : people) {
            if (p.getUsername().equals("Toshko")) {
                actual = p.getUsername();
            }
        }

        Assert.assertEquals(this.person.length + 1, this.database.getElements().length);
        Assert.assertEquals("Toshko", actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodIsOutOfBounds() throws OperationNotSupportedException {
        for (int i = 0; i < this.person.length; i++) {
            this.database.remove();
        }
        this.database.remove();
    }

    @Test
    public void testRemoveMethodElementsExists() throws OperationNotSupportedException {
        this.database.remove();
        Person[] people = this.database.getElements();
        String actual = null;
        for (Person p : people) {
            if (p.getUsername().equals("Sasho")) {
                actual = p.getUsername();
            }
        }

        Assert.assertEquals(this.person.length - 1, this.database.getElements().length);
        Assert.assertEquals("Sasho", actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByUsernameThrowsExceptionsForEqualsNull() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByUsernameThrowsExceptionsForSizeListDifferent1() throws OperationNotSupportedException {
        this.database.findByUsername("Pepi");
        this.database.findByUsername("Georgi");
    }

    @Test
    public void testMethodFindByUsernameEqualsByNameAndAddToSuccess() throws OperationNotSupportedException {
        this.database.findByUsername("Sasho");
        Person person = Arrays.stream(this.database.getElements()).findFirst().get();
        String actual = person.getUsername();

        Assert.assertEquals("Sasho", actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMethodFindByIdThrowsExceptionsForSizeListDifferent1() throws OperationNotSupportedException {
        this.database.findById(145);
        this.database.findById(1567);
    }

    @Test
    public void testMethodFindByIdEqualsByIdAndAddToSuccess() throws OperationNotSupportedException {
        this.database.findById(10);
        Person person = Arrays.stream(this.database.getElements()).findFirst().get();
        int actual = person.getId();

        Assert.assertEquals(10, actual);
    }
}