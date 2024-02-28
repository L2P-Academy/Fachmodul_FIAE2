package zoo;

import java.util.List;

public class Animal {
    private String name;
    private int age;
    private String species;
    public List<String> type;
    
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
    
    public void addtype(String preference) {
    	this.type.add(preference);
    }
}
