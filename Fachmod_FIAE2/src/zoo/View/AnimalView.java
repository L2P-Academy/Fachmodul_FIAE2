package zoo.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AnimalView extends JFrame implements ActionListener {

	private JPanel pnlTiergehege;
	private JMenuBar menubar;
	private JMenu startMenu, ansichtMenu, zooverwaltungMenu;
	private JMenuItem verkaufsuebersichtMenuItem, beendenMenuItem, minimierenMenuItem, maximierenMenuItem,
			standardMenuItem, listeTiereMenuItem, verkaufteTicketsMenuItem;
	private JButton btnAffe;
	Font font = new Font("Monospaced", Font.BOLD, 28);

	public AnimalView() {
		setTitle("Tiergehege");
		setSize(1200, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Menubar erstellen
		menubar = new JMenuBar();
		startMenu = new JMenu("Start");
		ansichtMenu = new JMenu("Ansicht");
		zooverwaltungMenu = new JMenu("Zooverwaltung");
		verkaufsuebersichtMenuItem = new JMenuItem("Verkaufsübersicht");
		verkaufsuebersichtMenuItem.addActionListener(null);
		beendenMenuItem = new JMenuItem("Beenden");
		minimierenMenuItem = new JMenuItem("Minimieren");
		maximierenMenuItem = new JMenuItem("Maximieren");
		standardMenuItem = new JMenuItem("Standardgröße");
		listeTiereMenuItem = new JMenuItem("Liste der Tiere");
		verkaufteTicketsMenuItem = new JMenuItem("Verkaufte Tickets");

		// ActionListener für die Menübar
		beendenMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		minimierenMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent mi) {

				setState(JFrame.ICONIFIED);
			}
		});

		maximierenMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ma) {

				setExtendedState(JFrame.MAXIMIZED_BOTH);

			}
		});

		standardMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent s) {

				setSize(1200, 900);

			}
		});

		listeTiereMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent l) {

				AnimalView animalView = new AnimalView();
			}
		});

		verkaufteTicketsMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {

				TicketsSold ticketsSold = new TicketsSold();
			}
		});
		
		// Buttons ActionListener
		btnAffe.addActionListener(this);

		// Hinzufügen der Menüitems und Menüs zur Menubar
		startMenu.add(verkaufsuebersichtMenuItem);
		startMenu.add(beendenMenuItem);
		ansichtMenu.add(minimierenMenuItem);
		ansichtMenu.add(maximierenMenuItem);
		ansichtMenu.add(standardMenuItem);
		zooverwaltungMenu.add(listeTiereMenuItem);
		zooverwaltungMenu.add(verkaufteTicketsMenuItem);
		menubar.add(startMenu);
		menubar.add(ansichtMenu);
		menubar.add(zooverwaltungMenu);
		setJMenuBar(menubar);

		// Erstellen des Hauptpanels & Layout anlegen
		pnlTiergehege = new JPanel();
		pnlTiergehege.setLayout(new GridLayout(3, 2));
		
		// Buttons anlegen
		JButton btnAffe = new JButton("Zu den Affen 🐒");
		btnAffe.setFont(font);
		JButton btnElefant = new JButton("Zu den Elefanten 🐘");
		btnElefant.setFont(font);
		JButton btnGiraffe = new JButton("Zu den Giraffen 🦒");
		btnGiraffe.setFont(font);
		JButton btnLöwe = new JButton("Zu den Löwen 🦁");
		btnLöwe.setFont(font);
		JButton btnZebra = new JButton("Zu den Zebras 🦓");
		btnZebra.setFont(font);
		JButton btnHyäne = new JButton("Zu den Hyänen 🐆");
		btnHyäne.setFont(font);
		
		
		// Bilder einfügen & deklarieren
		ImageIcon imgAffe = new ImageIcon("res/img/Affe.jpg");
		ImageIcon imgElefant = new ImageIcon("res/img/Elefant.jpg");
		ImageIcon imgGiraffe = new ImageIcon("res/img/Giraffe.jpg");
		ImageIcon imgLöwe = new ImageIcon("res/img/Löwe.jpg");
		ImageIcon imgZebra = new ImageIcon("res/img/Zebra.jpg");
		ImageIcon imgHyäne = new ImageIcon("res/img/Hyäne.jpg");

		// Bilder dem jeweiligen JPanel zuordnen
		JLabel lblAffe = new JLabel(imgAffe);
		JLabel lblElefant = new JLabel(imgElefant);
		JLabel lblGiraffe = new JLabel(imgGiraffe);
		JLabel lblLöwe = new JLabel(imgLöwe);
		JLabel lblZebra = new JLabel(imgZebra);
		JLabel lblHyäne = new JLabel(imgHyäne);

		// JPanels dem HauptPanel hinzufügen
		getContentPane().add(pnlTiergehege);
		pnlTiergehege.add(btnAffe);
		pnlTiergehege.add(btnElefant);
		pnlTiergehege.add(btnGiraffe);
		pnlTiergehege.add(btnLöwe);
		pnlTiergehege.add(btnZebra);
		pnlTiergehege.add(btnHyäne);

		setVisible(true);
	}
}
