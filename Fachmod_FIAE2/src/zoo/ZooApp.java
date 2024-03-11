package zoo;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

import zoo.Controller.XMLController;
import zoo.Controller.ZooController;
import zoo.Model.Ticketsystem;
import zoo.Model.ZooModel;
import zoo.View.*;

public class ZooApp {

	public static void main(String[] args) {
		
//		SwingUtilities.invokeLater(()-> new TicketsSold());
		
		try {
			// setze auf ein wunderschönes Aussehen
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ZooModel zooModel = new ZooModel();
		ZooView zooView = new ZooView();
		
		// Hier kann zum Testen die View angepasst werden, die bei Start angezeigt wird - dazu die ZooView auskommentieren:
		
		// AnimalView animalView = new AnimalView();
		
		ZooController zooController = new ZooController(zooModel, zooView);
		
		// Intialisierung
		// Start: Anzeige + Startmethoden
	}
}
