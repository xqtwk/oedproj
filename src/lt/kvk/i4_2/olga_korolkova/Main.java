package lt.kvk.i4_2.olga_korolkova;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import lt.kvk.i4_2.olga_korolkova.main.Animal;
import lt.kvk.i4_2.olga_korolkova.main.Gender;
import lt.kvk.i4_2.olga_korolkova.main.animals.*;
import lt.kvk.i4_2.olga_korolkova.util.FileReaderWriter;

public class Main {
    private List<Animal> animals;
    // Paths to animals data
    private static final String CATS_FILE_PATH = ".\\src\\lt\\kvk\\i4_2\\olga_korolkova\\main\\data\\cats.txt";
    private static final String DOGS_FILE_PATH = ".\\src\\lt\\kvk\\i4_2\\olga_korolkova\\main\\data\\dogs.txt";
    private static final String OUTPUT_FILE_PATH = ".\\src\\lt\\kvk\\i4_2\\olga_korolkova\\main\\data\\output.txt";
    private static final int MIN_ANIMAL_AGE = 1;

    public Main() {
        animals = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        String choice;
        try {
            loadAnimalsFromFile(CATS_FILE_PATH);
            loadAnimalsFromFile(DOGS_FILE_PATH);
            displayAnimals();
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Do you want to add a new dog or cat? (Y/N)");
                choice = scanner.nextLine().toUpperCase();

                if (choice.equals("Y")) {
                    System.out.println("Enter 'D' for dog or 'C' for cat:");
                    String animalType = scanner.nextLine().toUpperCase();

                    if (animalType.equals("D")) {
                        addNewAnimal(scanner, DOGS_FILE_PATH);
                    } else if (animalType.equals("C")) {
                        addNewAnimal(scanner, CATS_FILE_PATH);
                    } else {
                        System.out.println("Invalid animal type. Skipping entry.");
                    }
                } else if (!choice.equals("N")) {
                    System.out.println("Invalid choice. Please enter Y or N.");
                }
            } while (!choice.equals("N"));
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        try {
            animals.clear();
            loadAnimalsFromFile(CATS_FILE_PATH);
            loadAnimalsFromFile(DOGS_FILE_PATH);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Want to filter the output by gender? (Y/N)");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("type m or f");
                choice = scanner.nextLine();
                if (choice.equals("m")) {
                    choice = "Male";
                } else if (choice.equals("f")) {
                    choice = "Female";
                }
                System.out.println("Sort? (type name;name+age;age;n;  where n is no sort)");
                String dec = scanner.nextLine();
                if (checkSort(dec)) {
                    writeOlderAnimalsToFile(MIN_ANIMAL_AGE, choice, OUTPUT_FILE_PATH, dec);
                } else {
                System.out.println("Sort? (type name;name+age;age;n;  where n is no sort)");
                writeOlderAnimalsToFile(MIN_ANIMAL_AGE, choice, OUTPUT_FILE_PATH, "n");
                }
            } else {
                System.out.println("Sort? (type name;name+age;age;n;  where n is no sort)");
                choice = scanner.nextLine();
                if (checkSort(choice)) {
                    writeOlderAnimalsToFile(MIN_ANIMAL_AGE, OUTPUT_FILE_PATH, choice); // set minimal age
                } else {
                System.out.println("Wrong choice, not using sorting");
                writeOlderAnimalsToFile(MIN_ANIMAL_AGE, OUTPUT_FILE_PATH, "n");
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    public boolean checkSort(String s) {
        if (!s.equals("name") && !s.equals("name+age") && !s.equals("age") && !s.equals("n")) {
            return false;
        }
        return true;
    }
    
    public void loadAnimalsFromFile(String filePath) throws IOException {
        List<String> lines = FileReaderWriter.readLinesFromFile(filePath);
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 4) {
                String animalType = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String gender = parts[3];
                if (animalType.equals("Cat")) {
                    addAnimal(new Cat(name, age, gender));
                } else if (animalType.equals("Dog")) {
                    addAnimal(new Dog(name, age, gender));
                }
            } else {
                System.out.println("Invalid input format. Skipping entry.");
            }
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addNewAnimal(Scanner scanner, String filePath) {
        System.out.println("Enter the animal data (name;age;gender):");
        String animalData = scanner.nextLine();
        String[] parts = animalData.split(";");

        if (parts.length == 3) {
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String genderInput = parts[2];

            Gender gender;
            if (genderInput.equalsIgnoreCase("male")) {
                gender = Gender.MALE;
            } else if (genderInput.equalsIgnoreCase("female")) {
                gender = Gender.FEMALE;
            } else {
                System.out.println("Invalid gender. Skipping entry.");
                return;
            }

            String animalType;
            if (filePath.equals(DOGS_FILE_PATH)) {
                animalType = "Dog";
            } else if (filePath.equals(CATS_FILE_PATH)) {
                animalType = "Cat";
            } else {
                System.out.println("Invalid file path. Skipping entry.");
                return;
            }

            String formattedAnimalData = String.format("%s;%s;%d;%s", animalType, name, age, gender.getDisplayName());

            try {
                FileReaderWriter.appendLineToFile(filePath, formattedAnimalData);
                System.out.println("Animal added successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while adding the animal: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid input format. Skipping entry.");
        }
    }

    public void displayAnimals() {
        System.out.println("Animals:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
        System.out.println();
    }

    /*public void writeOlderAnimalsToFile(int minAge, String filePath) throws IOException {
        List<String> lines = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && (animal instanceof Cat || animal instanceof Dog))
                .map(animal -> {
                    String animalType = animal instanceof Cat ? "Cat" : "Dog";
                    return animalType + ";" + animal.getName() + ";" + animal.getAge() + ";" + animal.getGender();
                })
                .collect(Collectors.toList());

        if (lines.isEmpty()) {
            lines.add("No animals with age of " + minAge);
        }

        FileReaderWriter.writeLinesToFile(filePath, lines);
        System.out.println("Older animals have been written to the file: " + filePath);
    }

    public void writeOlderAnimalsToFile(int minAge, String gender, String filePath) throws IOException {
        List<String> lines = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getGender().equalsIgnoreCase(gender))
                .map(animal -> {
                    String animalType = animal instanceof Cat ? "Cat" : "Dog";
                    return animalType + ";" + animal.getName() + ";" + animal.getAge() + ";" + animal.getGender();
                })
                .collect(Collectors.toList());

        if (lines.isEmpty()) {
            lines.add("No animals with age of " + minAge + " and gender " + gender);
        }

        FileReaderWriter.writeLinesToFile(filePath, lines);
        System.out.println("Older animals have been written to the file: " + filePath);
    }*/

    public void writeOlderAnimalsToFile(int minAge, String gender, String filePath, String sortingOption) throws IOException {
        List<String> lines = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getGender().equalsIgnoreCase(gender))
                .map(animal -> {
                    String animalType = animal instanceof Cat ? "Cat" : "Dog";
                    return animalType + ";" + animal.getName() + ";" + animal.getAge() + ";" + animal.getGender();
                })
                .map(Object::toString) // Convert stream elements to strings
                .collect(Collectors.toList());

        if (lines.isEmpty()) {
            lines.add("No animals with age of " + minAge + " and gender " + gender);
        }

        sortLines(lines, sortingOption); // Sort the lines based on the sorting option

        FileReaderWriter.writeLinesToFile(filePath, lines);
        System.out.println("Older animals have been written to the file: " + filePath);
    }

    public void writeOlderAnimalsToFile(int minAge, String filePath, String sortingOption) throws IOException {
        List<String> lines = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && (animal instanceof Cat || animal instanceof Dog))
                .map(animal -> {
                    String animalType = animal instanceof Cat ? "Cat" : "Dog";
                    return animalType + ";" + animal.getName() + ";" + animal.getAge() + ";" + animal.getGender();
                })
                .map(Object::toString) // Convert stream elements to strings
                .collect(Collectors.toList());
    
        if (lines.isEmpty()) {
            lines.add("No animals with age of " + minAge);
        }
    
        sortLines(lines, sortingOption); // Sort the lines based on the sorting option
    
        FileReaderWriter.writeLinesToFile(filePath, lines);
        FileReaderWriter.appendLineToFile(filePath, sortingOption);
        System.out.println("Older animals have been written to the file: " + filePath);
    }
    
    
    private void sortLines(List<String> lines, String sortingOption) {
        switch (sortingOption.toLowerCase()) {
            case "name":
                Collections.sort(lines, Comparator.comparing(line -> {
                    String[] parts = ((String) line).split(";");
                    return parts[1]; // Sort by name
                }));
                break;
            case "name+age":
                Collections.sort(lines, Comparator.comparing(line -> {
                    String[] parts = ((String) line).split(";");
                    return parts[1]; // Sort by name
                }).thenComparing(line -> {
                    String[] parts = ((String) line).split(";");
                    return Integer.parseInt(parts[2]); // Then sort by age
                }));
                break;
            case "age":
                Collections.sort(lines, Comparator.comparingInt(line -> {
                    String[] parts = ((String) line).split(";");
                    return Integer.parseInt(parts[2]); // Sort by age
                }));
                break;
            case "none":
                // No sorting, do nothing
                break;
            default:
                System.out.println("Invalid sorting option. Defaulting to 'none'.");
                break;
        }
    }
    
    
}
