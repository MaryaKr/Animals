package factory;

import animals.AbsAnimals;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;

public class AnimalFactory {
    public AbsAnimals create(AnimalTypeData type) {
        switch (type) {
            case CAT: {
                return new Cat();
            }
            case DOG: {
                return new Dog();
            }
            case DUCK: {
                return new Duck();
            }
        }
        return null;
    }
}
