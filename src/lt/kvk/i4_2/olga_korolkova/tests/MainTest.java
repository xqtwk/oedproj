package lt.kvk.i4_2.olga_korolkova.tests;

import org.junit.*;

import lt.kvk.i4_2.olga_korolkova.Main;
import lt.kvk.i4_2.olga_korolkova.main.Animal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class MainTest {
    private Main main;

    @Before
    public void setUp() {
        main = new Main();
    }


    @Test
    public void addNewAnimal_invalidData_skipsInvalidEntry() {
        main.addNewAnimal("Dog;Lucy", "test-data/dogs.txt");

        List<Animal> animals = main.getAnimals();
        assertTrue(animals.isEmpty());
    }

    @Test
    public void checkSort_validSort_returnsTrue() {
        assertTrue(main.checkSort("name"));
        assertTrue(main.checkSort("name+age"));
        assertTrue(main.checkSort("age"));
        assertTrue(main.checkSort("n"));
    }

    @Test
    public void checkSort_invalidSort_returnsFalse() {
        assertFalse(main.checkSort("abc"));
        assertFalse(main.checkSort("xyz"));
    }

    // Add more test cases for the remaining methods...

}
