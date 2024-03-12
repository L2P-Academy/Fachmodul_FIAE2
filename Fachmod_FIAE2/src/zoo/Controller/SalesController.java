package zoo.Controller;

import java.text.DecimalFormat;
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
	
	public Double preisBerechnung(int ticketAnzahl, Double ticketPrice, int dauer) {
		Double dauerFaktor = 0.0;
		Double preis;
				
		switch (dauer) {
		case 2: {
			dauerFaktor = 1.0 / 3;
			break;
		}
		case 4: {
			dauerFaktor = 2.0 / 3;
			break;
		}
		case 6: {
			dauerFaktor = 1.0;
			break;
		}
		}
		
		preis = ticketAnzahl*dauerFaktor*ticketPrice;
		return preis;
						
	}
}
