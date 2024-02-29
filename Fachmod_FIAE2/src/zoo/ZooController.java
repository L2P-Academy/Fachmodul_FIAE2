package zoo;

import java.util.Date;
import java.util.List;
import java.lang.Math;

public class ZooController {
	private List<String> ticketType;
	private Double ticketPrice;
	private Date ticketDate;
	private Zoo zoo;				//Variable zoo initialisieren
	private ZooView zooView; 		//Variable zooView initialisieren
	
	
	
	public void zooController(Zoo zoo,ZooView zooView) {
		this.zoo = zoo; 
		this.zooView = zooView;
		
			
	}

	public void addAnimal(String name, int age, String species, List<String> type) {
			Animal animal = new Animal(name, age, species, type); //initialisieren eines neuen Objekts animal
			zoo.addAnimal(animal);
			zooView.displayAnimals();
	}
	
	public void sellTicket(List<String> ticketType, Double ticketPrice, Date ticketDate) {
		
	}
}
