package zoo;

import javax.swing.UIManager;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

public class ZooApp {

	public static void main(String[] args) {
		
		try {
			// setze auf ein wunderschönes Aussehen
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Zoo zoo = new Zoo();
		ZooView zooView = new ZooView();
		ZooController zooController = new ZooController();
		
		// Intialisierung
		// Start: Anzeige + Startmethoden
	}
}
