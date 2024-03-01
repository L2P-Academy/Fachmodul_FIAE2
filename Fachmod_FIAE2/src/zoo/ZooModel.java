package zoo;

import java.util.ArrayList;
import java.util.List;

import zoo.Model.Animal;

public class ZooModel {
    private List<Animal> animals;
    
    public ZooModel() {
        animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
}