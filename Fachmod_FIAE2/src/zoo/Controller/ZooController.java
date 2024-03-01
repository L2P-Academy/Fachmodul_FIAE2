package zoo.Controller;

import java.util.Date;
import java.util.List;

import zoo.Model.Animal;
import zoo.Model.ZooModel;
import zoo.View.ZooView;

import java.lang.Math;

public class ZooController {
	private List<String> ticketType;
	private Double ticketPrice;
	private Date ticketDate;
	private ZooModel zooModel;				//Variable zoo initialisieren
	private ZooView zooView; 		//Variable zooView initialisieren
	
	SalesController salesController = new SalesController();
	
	public void zooController(ZooModel zooModel,ZooView zooView) {
		this.zooModel = zooModel; 
		this.zooView = zooView;
		
			
	}

	public void addAnimal(String name, int age, String species, List<String> type) {
			Animal animal = new Animal(name, age, species, type); //initialisieren eines neuen Objekts animal
			zooModel.addAnimal(animal);
			zooView.displayAnimals();
	}
	
	public void sellTicket(List<String> ticketType, Double ticketPrice, Date ticketDate) {
		salesController.sellTicket(ticketType, ticketPrice, ticketDate);
	}
}
