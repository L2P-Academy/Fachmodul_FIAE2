package zoo.Controller;

import java.util.Date;
import java.util.List;

import zoo.Model.ZooModel;

public class SalesController {
	
	private ZooModel zooModel;
	
	
	
	
	public void salesController(ZooModel zooModel) {
		this.zooModel = zooModel;
	}
	
	public void sellTicket(List<String> ticketType, Double ticketPrice, Date ticketDate) {
		
	}
}
