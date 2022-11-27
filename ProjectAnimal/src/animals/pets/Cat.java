package animals.pets;

import animals.AbsAnimals;

public class Cat extends AbsAnimals {
    @Override
    public void say() {
        System.out.println("Мяу");
    }
}
