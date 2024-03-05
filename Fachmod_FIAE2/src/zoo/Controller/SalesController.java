package zoo.Controller;

import java.util.Date;
import java.util.List;

import zoo.Model.Ticketsystem;

public class SalesController {

	private Ticketsystem ticketsystem;

	public SalesController(Ticketsystem ticketsystem) {
		this.ticketsystem = ticketsystem;
	}

	public void sellTicket(String ticketType, Double ticketPrice, Date ticketDate) {
		ticketsystem.addTicket(ticketType, ticketPrice, ticketDate);
	}
}
