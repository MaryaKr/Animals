import animals.AbsAnimals;
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
            while (!isContainCommand(answerCommand)) {
                System.out.println("Вы неправильно ввели команду");
                System.out.println("Введите команду (Add/List/Exit):");
                answerCommand = scanner.next().trim().toUpperCase();
            }
            CommandsData commandsData = CommandsData.valueOf(answerCommand);

            switch (commandsData) {
                case ADD: {
                    System.out.println("Введите название животного (Cat/Dog/Duck):");
                    String answerAnimal = scanner.next().trim().toUpperCase();
                    while (!isContainAnimal(answerAnimal)) {
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
        int ageStr;
        do {
            System.out.println("Введите возраст животного:");
            while (!scanner.hasNextInt()) {
                System.out.println("Неправильно ввели возраст животного");
                System.out.println("Введите возраст животного:");
                scanner.next();
            }
            ageStr = scanner.nextInt();
            if (ageStr < 0) {
                System.out.println("Неправильно ввели возраст животного");
            }
        }
        while (ageStr <= 0);
        animal.setAge(ageStr);
        int ageWeight;
        do {
            System.out.println("Введите вес животного:");
            while (!scanner.hasNextInt()) {
                System.out.println("Неправильно ввели вес животного");
                System.out.println("Введите вес животного:");
                scanner.next();
            }
            ageWeight = scanner.nextInt();
            if (ageWeight < 0) {
                System.out.println("Неправильно ввели вес животного");
            }
        }
        while (ageWeight <= 0);
        animal.setWeight(ageWeight);
        System.out.println("Введите цвет животного:");
        animal.setColor(scanner.next());
        animal.say();
        return animal;

    }

    private static boolean isContainCommand(String str) {
        try {
            CommandsData.valueOf(str);
            return true;
        } catch (IllegalArgumentException ignoring) {
            return false;
        }
    }

    private static boolean isContainAnimal(String str) {
        try {
            AnimalTypeData.valueOf(str);
            return true;
        } catch (IllegalArgumentException ignoring) {
            return false;
        }
    }
}