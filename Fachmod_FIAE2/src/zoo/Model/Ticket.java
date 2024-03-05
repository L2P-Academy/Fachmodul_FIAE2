package zoo.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ticket {
	private int ticketID;
	private double price;
	private List<String> type;
	private Date date;
	
	public Ticket (List<String> ticketType, Double ticketPrice, Date ticketDate) {
		//TODO: TicketID beschaffen
		this.ticketID = getTicketID();
		this.type = ticketType;
		this.price = ticketPrice;
		this.date = Calendar.getInstance().getTime();
		}
	
	public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
