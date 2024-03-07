package zoo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
	
	// Ernährungspräferenzen
	public enum NutritionType {
		Fleischfresser, Pflanzenfresser, Allesfresser
	}

    private String name;
    private int age;
    private String species;
    private List<NutritionType> nutritionTypes;

    public Animal(String name, int age, String species, List<NutritionType> nutritionTypes) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.nutritionTypes = nutritionTypes;
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

    public List<NutritionType> getType() {
        return nutritionTypes;
    }

    public void setType(List<NutritionType> type) {
        this.nutritionTypes = type;
    }

    public void addType(NutritionType preference) {
        this.nutritionTypes.add(preference);
    }

    public static List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Simba", 5, "Löwe", Arrays.asList(NutritionType.Fleischfresser)));
        animals.add(new Animal("Jumbo", 10, "Elefant", Arrays.asList(NutritionType.Pflanzenfresser)));
        animals.add(new Animal("Giselle", 8, "Giraffe", Arrays.asList(NutritionType.Pflanzenfresser)));
        animals.add(new Animal("Donkey Kong", 4, "Affe", Arrays.asList(NutritionType.Allesfresser)));
        animals.add(new Animal("Zara", 3, "Zebra", Arrays.asList(NutritionType.Pflanzenfresser)));
        animals.add(new Animal("Harald", 7, "Hyäne", Arrays.asList(NutritionType.Allesfresser)));
        return animals;
    }
}