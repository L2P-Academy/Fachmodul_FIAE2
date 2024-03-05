package zoo.Controller;

import java.util.Date;
import java.util.List;

import zoo.Model.Ticketsystem;
import zoo.Model.ZooModel;

public class SalesController {
	
	private Ticketsystem ticketsystem;
	
	
	
	
	
	public void salesController(Ticketsystem ticketsystem) {
		this.ticketsystem = ticketsystem;
	}
	
	public void sellTicket(List<String> ticketType, Double ticketPrice, Date ticketDate) {
		ticketsystem.addTicket(ticketType, ticketPrice, ticketDate);
	}
}
