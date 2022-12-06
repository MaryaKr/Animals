import animals.AbsAnimals;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import data.AnimalTypeData;
import data.CommandsData;
import factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<AbsAnimals> arrayAnimals = new ArrayList<>();
        while (true) {
            System.out.println("Введите команду (Add/List/Exit):");
            String answerCommand = scanner.next().trim().toUpperCase();
            while (!(answerCommand.contains("ADD") || answerCommand.contains("LIST") || answerCommand.contains("EXIT"))) {
                System.out.println("Вы неправильно ввели команду");
                System.out.println("Введите команду (Add/List/Exit):");
                answerCommand = scanner.next().trim().toUpperCase();
            }
            CommandsData commandsData = CommandsData.valueOf(answerCommand);

            switch (commandsData) {
                case ADD: {
                    System.out.println("Введите название животного (Cat/Dog/Duck):");
                    String answerAnimal = scanner.next().trim().toUpperCase();
                    while (!(answerAnimal.contains("CAT") || answerAnimal.contains("DOG") || answerAnimal.contains("DUCK"))) {
                        System.out.println("Вы неправильно ввели имя животного");
                        System.out.println("Введите название животного (Cat/Dog/Duck):");
                        answerAnimal = scanner.next().trim().toUpperCase();
                    }

                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(answerAnimal);
                    arrayAnimals.add(fillAnimalData(animalTypeData));

                    break;
                }

                case LIST: {
                    for (AbsAnimals arrayAnimal : arrayAnimals) {
                        System.out.println(arrayAnimal.toString());

                    }
                    break;
                }
                case EXIT: {
                    System.exit(0);
                }

            }


        }
    }

    public static AbsAnimals fillAnimalData(AnimalTypeData animalTypeData) {

        AnimalFactory factory = new AnimalFactory();
        AbsAnimals animal = factory.create(animalTypeData);
        System.out.println("Введите имя животного:");
        animal.setName(scanner.next());
        System.out.println("Введите возраст животного:");
        String ageStr = scanner.next();
        while (!isNumber(ageStr)) {
            System.out.println("Неправильно ввели возраст животного");
            System.out.println("Введите возраст животного");
            ageStr = scanner.next();
        }
        animal.setAge(Integer.parseInt(ageStr));
        System.out.println("Введите вес животного:");

        String ageWeight = scanner.next();
        while (!isNumber(ageWeight)) {
            System.out.println("Неправильно ввели вес животного");
            System.out.println("Введите вес животного");
            ageWeight = scanner.next();
        }
        animal.setWeight(Integer.parseInt(ageWeight));
        System.out.println("Введите цвет животного:");
        animal.setColor(scanner.next());
        animal.say();
        return animal;

    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ignoring) {
            return false;
        }
    }
}