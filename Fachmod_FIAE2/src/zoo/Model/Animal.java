package zoo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    private String name;
    private int age;
    private String species;
    private List<String> type;

    public Animal(String name, int age, String species, List<String> type) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public void addType(String preference) {
        this.type.add(preference);
    }

    public static List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Löwe", 5, "Löwe", Arrays.asList("Fleischfresser")));
        animals.add(new Animal("Elefant", 10, "Elefant", Arrays.asList("Pflanzenfresser")));
        animals.add(new Animal("Giraffe", 8, "Giraffe", Arrays.asList("Pflanzenfresser")));
        animals.add(new Animal("Affe", 4, "Affe", Arrays.asList("Allesfresser")));
        animals.add(new Animal("Zebra", 3, "Zebra", Arrays.asList("Pflanzenfresser")));
        return animals;
    }
}