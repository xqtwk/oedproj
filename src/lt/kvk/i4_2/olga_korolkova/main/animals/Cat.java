package lt.kvk.i4_2.olga_korolkova.main.animals;

import lt.kvk.i4_2.olga_korolkova.main.Animal;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
