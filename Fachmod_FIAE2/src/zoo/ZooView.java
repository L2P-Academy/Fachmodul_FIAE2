package zoo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ZooView extends JFrame {
	// Zoo zoo;

	private JLabel jLabel1 = new JLabel();

	public ZooView(String title) {
		// Frame-Initialisierung
		super(title); // Super(Haupt)-Klasse aufrufen - Bitte an erster Stelle in der Methode lassen.
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Zum Beenden wichtig!!!!
		int frameWidth = 395; // Frame_Breite
		int frameHeight = 299;// Frame_Höhe
		setSize(frameWidth, frameHeight); // Setzen der Variablen -Das Fenster brauch eine Größe!
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); // Konstrukt zur Fensterposition *x
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y); // x* -bis hier hin
		Container cp = getContentPane(); // Ein Pane einrichten
		cp.setLayout(null); // Fenster-Layout festlegen - z.B.: FlowLayout, BorderLayout, etc. oder keins
		// Anfang Komponenten

		jLabel1.setBounds(16, 16, 44, 16); // 1.Zahl: pos(x) 2.Zahl: pos(y) 3.Zahl: Breite 4.Zahl: Höhe
		jLabel1.setText("Guten Tag!");
		jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13)); // Schriftart festlegen
		cp.add(jLabel1);
		// Ende Komponenten

		setResizable(false); // Fenster hat keinen Maximierungs-Knopf ->bei(false)
		setVisible(true); // Damit bekommst du das Fenster erst zu Gesicht !!!
	}
	
	

	public ZooView() {
	}

	public void displayAnimals() {
	}
}