package zoo.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TicketsSold extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu startMenu, ansichtMenu, zooverwaltungMenu;
	private JMenuItem verkaufsuebersichtMenuItem, beendenMenuItem, minimierenMenuItem, maximierenMenuItem, standardMenuItem, listeTiereMenuItem, verkaufteTicketsMenuItem;
	private JPanel pnlNorth;
	private JPanel pnlSouth;
	private JLabel lblNorth;
	private JLabel lblSouth;
	private JPanel pnlVerkaufteTickets;
	private JTable ticketTable;
	

	public TicketsSold() {
		setTitle("Verkaufte Tickets");
		setSize(1200, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnlVerkaufteTickets = new JPanel();
		pnlVerkaufteTickets.setLayout(new BorderLayout());
		
	
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
	
	//ActinListener für die Menübar
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
		public void actionPerformed(ActionEvent l) {

			TicketsSold ticketsSold = new TicketsSold();
		}
	});
	
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
	
	// Panels innen erstellen und ins Hauptpanel fügen
	pnlNorth = new JPanel();
	pnlNorth.setLayout(new BorderLayout());
	
	pnlSouth = new JPanel();
	pnlSouth.setLayout(new BorderLayout());
	
	lblSouth = new JLabel("Hier gibt es bald verkaufte Tickets!");
	lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
	
	pnlSouth.add(lblSouth);
	getContentPane().add(pnlSouth);		
	setVisible(true);
	
	pnlVerkaufteTickets.add(pnlNorth);
	pnlVerkaufteTickets.add(pnlSouth);
	

	
	  // Daten für die Tabelle
    Object[][] data = {
            {1, "Erwachsen", 10, 100, 50.0},
            {2, "Kind", 15, 150, 75.0},
            {3, "Senioren", 20, 200, 100.0}
    };

    // Spaltenüberschriften
    String[] columnNames = {"ID", "Art", "Dauer", "Menge", "Preis"};

    // DefaultTableModel erstellen
    DefaultTableModel model = new DefaultTableModel(data, columnNames);

    // JTable erstellen
    ticketTable = new JTable(model);

    // Optional: JTable zu JScrollPane hinzufügen
    JScrollPane scrollPane = new JScrollPane(ticketTable);

    
    pnlNorth.add(ticketTable);
    
}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}