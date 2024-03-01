package zoo.Model;

import java.util.ArrayList;
import java.util.List;

public class Ticketsystem {
	    private List<Ticket> ticketList;

	    public Ticketsystem() {
	        this.ticketList = new ArrayList<>();
	        initializeTickets();
	    }

	    private void initializeTickets() {
	        ticketList.add(new Ticket(1, "Kind", 5.0));
	        ticketList.add(new Ticket(2, "Student", 10.0));
	        ticketList.add(new Ticket(3, "Erwachsene", 20.0));
	        ticketList.add(new Ticket(4, "Gruppe", 50.0));
	    }

	    public List<Ticket> getTickets() {
	        return ticketList;
	    }

	    public void addTicket(Ticket ticket) {
	        ticketList.add(ticket);
	    }
}
