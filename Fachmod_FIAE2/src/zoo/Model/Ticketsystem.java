package zoo.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticketsystem {
		public Ticket newTicket;
	    private List<Ticket> ticketList;

	    public Ticketsystem() {
	        this.ticketList = new ArrayList<>();
	        this.newTicket = new Ticket("StandardType", 0.0, null);
	    }

//	    private void initializeTickets() {
//	        ticketList.add(new Ticket(1, "Kind", 5.0));
//	        ticketList.add(new Ticket(2, "Student", 10.0));
//	        ticketList.add(new Ticket(3, "Erwachsene", 20.0));
//	        ticketList.add(new Ticket(4, "Gruppe", 50.0));
//	    }

	    public List<Ticket> getTickets() {
	        return ticketList;
	    }
	    
	    public Ticket getNewTicket() {
	    	return newTicket;
	    }

	    public void addTicket(String ticketType, Double ticketPrice, Date ticketDate) {
	        newTicket = new Ticket(ticketType, ticketPrice, ticketDate);
	        newTicket.setType(ticketType);
	        newTicket.setPrice(ticketPrice);
	        newTicket.setDate(ticketDate);
	    	ticketList.add(newTicket);
	    }
}
