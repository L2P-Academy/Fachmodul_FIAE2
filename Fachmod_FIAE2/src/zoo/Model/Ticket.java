package zoo.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ticket {
	private static int ticketID = 1;
	private double price;
	private String ticketType;
	private Date date;
	
	
	public Ticket (String ticketType, Double ticketPrice, Date ticketDate) {
		this.ticketType = ticketType;
		this.price = ticketPrice;
		this.date = Calendar.getInstance().getTime();
		}
	
	public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getType() {
        return ticketType;
    }

    public void setType(String type) {
        this.ticketType = type;
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
