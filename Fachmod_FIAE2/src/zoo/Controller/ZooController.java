package zoo.Controller;

import java.util.Date;
import java.util.List;

import zoo.Model.Animal;
import zoo.Model.Animal.NutritionType;
import zoo.Model.ZooModel;
import zoo.View.ZooView;

public class ZooController {
	private List<String> ticketType;
	private ZooModel zooModel;				//Variable zoo initialisieren
	private ZooView zooView; 		//Variable zooView initialisieren
	
	
	public ZooController(ZooModel zooModel,ZooView zooView) {
		this.zooModel = zooModel; 
		this.zooView = zooView;
	}

	public void addAnimal(String name, int age, String species, List<NutritionType> nutritionTypes) {
			Animal animal = new Animal(name, age, species, nutritionTypes); //initialisieren eines neuen Objekts animal
			zooModel.addAnimal(animal);
			zooView.displayAnimals();
	}
	

}
