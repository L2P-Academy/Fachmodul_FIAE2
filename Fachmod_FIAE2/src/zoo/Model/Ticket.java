package zoo.Model;

import java.util.Calendar;
import java.util.Date;

public class Ticket {
	private int ticketID;
	private double price;
	private String type;
	private Date date;
	
	public Ticket (int ticketID, String type, double price) {
		this.ticketID = ticketID;
		this.type = type;
		this.price = price;
		this.date = Calendar.getInstance().getTime();
		}
	
	public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
