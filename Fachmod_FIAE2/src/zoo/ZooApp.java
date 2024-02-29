package zoo;

import javax.swing.UIManager;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

import zoo.Controller.ZooController;
import zoo.Model.ZooModel;
import zoo.View.ZooView;

public class ZooApp {

	public static void main(String[] args) {
		
		try {
			// setze auf ein wunderschönes Aussehen
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ZooModel zooModel = new ZooModel();
		ZooView zooView = new ZooView();
		ZooController zooController = new ZooController();
		
		// Intialisierung
		// Start: Anzeige + Startmethoden
	}
}
