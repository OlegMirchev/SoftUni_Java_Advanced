package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTest {

    private Animal animal;
    private PetStore petStore;

    @Before
    public void SetUp() {
        this.animal = new Animal("Dog", 10, 5.50);
        this.petStore = new PetStore();
    }

    @Test
    public void testMethodFindAnimalsMaxKG() {
        Animal animal1 = new Animal("Cat", 5, 2.00);
        this.petStore.addAnimal(this.animal);
        this.petStore.addAnimal(animal1);
        List<Animal> actual = this.petStore.findAllAnimalsWithMaxKilograms(2);

        Assert.assertEquals(2, actual.size());
    }

    @Test
    public void testMethodAddAnimalSuccessfully() {
        this.petStore.addAnimal(this.animal);

        Assert.assertEquals(1, this.petStore.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMethodAddAnimalThrowException() {
        this.petStore.addAnimal(null);
    }

    @Test
    public void testMethodGetTheMostExpensiveAnimalSuccessfully() {
        Animal animal1 = new Animal("Cat", 5, 2.00);
        Animal animal2 = new Animal("Turtle", 4, 4.00);
        Animal animal3 = new Animal("Reptile", 10, 10.00);
        Animal animal4 = new Animal("Mouse", 2, 1.00);
        this.petStore.addAnimal(this.animal);
        this.petStore.addAnimal(animal1);
        this.petStore.addAnimal(animal2);
        this.petStore.addAnimal(animal3);
        this.petStore.addAnimal(animal4);

        Animal actual = this.petStore.getTheMostExpensiveAnimal();
        Animal expected = this.petStore.getAnimals().get(3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMethodGetTheMostExpensiveAnimalReturnNull() {
        Animal actual = this.petStore.getTheMostExpensiveAnimal();

        assertNull(actual);
    }

    @Test
    public void testMethodFindAllAnimalBySpecieSuccessfully() {
        Animal animal1 = new Animal("Cat", 5, 2.00);
        Animal animal2 = new Animal("Turtle", 4, 4.00);
        Animal animal3 = new Animal("Reptile", 10, 10.00);
        Animal animal4 = new Animal("Mouse", 2, 1.00);
        this.petStore.addAnimal(this.animal);
        this.petStore.addAnimal(animal1);
        this.petStore.addAnimal(animal2);
        this.petStore.addAnimal(animal3);
        this.petStore.addAnimal(animal4);

        List<Animal> actual = this.petStore.findAllAnimalBySpecie("Dog");

        Assert.assertEquals(1, actual.size());
    }
}