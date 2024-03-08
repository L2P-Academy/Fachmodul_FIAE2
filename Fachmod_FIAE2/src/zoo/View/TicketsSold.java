package zoo.View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import zoo.Model.SerializationIDs;


public class TicketsSold extends JFrame implements ActionListener {
	

	private static final long serialVersionUID = SerializationIDs.TICKETS_SOLD_UID ;
	private JMenuBar menubar;
	private JMenu startMenu, ansichtMenu, zooverwaltungMenu;
	private JMenuItem verkaufsuebersichtMenuItem, beendenMenuItem, minimierenMenuItem, maximierenMenuItem, standardMenuItem, listeTiereMenuItem, verkaufteTicketsMenuItem;
	private JPanel pnlNorth;
	private JPanel pnlSouth;
	private JPanel pnlMain;
	private JLabel lblNorth;
	private JLabel lblSouth;
	private JTable ticketTable;
	private JPanel pnlAuflistung;
	private JPanel pnlBerechnung;
	private JLabel lblErwachsen;
	private JLabel lblKinder;
	private JLabel lblSenioren;
	private JLabel lblBrechnung;
	private JLabel lblUeberschrift;
	private JLabel lblSumme;
	private JLabel lblMenge;

	public TicketsSold() {
		setTitle("Verkaufte Tickets");
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
	
	// Panels erstellen
	pnlMain = new JPanel();
	pnlMain.setLayout(new BorderLayout());
	
	pnlNorth = new JPanel();
	pnlNorth.setLayout(new BorderLayout());
	
	pnlSouth = new JPanel();
	pnlSouth.setLayout(new BorderLayout());
	
	pnlAuflistung = new JPanel();
	pnlAuflistung.setLayout(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	gbc.anchor = GridBagConstraints.NORTHWEST;
    
	pnlBerechnung = new JPanel();
	pnlBerechnung.setLayout(new BorderLayout()); 
	
	
	lblUeberschrift = new JLabel("Auflistung und Rechnung");
	
	lblErwachsen = new JLabel("Erwachsene ");
	
	lblKinder = new JLabel("Kinder ");
	
	lblSenioren = new JLabel("Senioren ");
	
	lblSumme = new JLabel("Summe");
	
	lblMenge = new JLabel("Menge");
	
	
	
	// Daten für die Tabelle
    String[][] data = {
            {"1", "Erwachsen", "10", "100", "25.03.2024", "50.0"},
            {"2", "Kind", "15", "150", "25.03.2024", "75.0"},
            {"3", "Senioren", "20", "200", "25.03.2024", "100.0"}
    };

    // Spaltenüberschriften
    String[] columnNames = {"ID", "Art", "Dauer", "Menge", "Datum", "Preis"};

    // JTable erstellen und speeren der änderung in Zeilen
    ticketTable = new JTable(data, columnNames) {
        public boolean isCellEditable(int x, int y) {
            return false;
        }
    };

    // JTable zu JScrollPane hinzufügen
    JScrollPane scrollPane = new JScrollPane(ticketTable);
	
    pnlAuflistung.add((lblUeberschrift), gbc);
    pnlAuflistung.add((lblErwachsen), gbc);
    pnlAuflistung.add((lblKinder), gbc);
    pnlAuflistung.add((lblSenioren), gbc);
    pnlAuflistung.add((lblSumme), gbc);
    pnlNorth.add(scrollPane, BorderLayout.CENTER);
	pnlSouth.add(pnlAuflistung, BorderLayout.WEST);
	pnlSouth.add(pnlBerechnung, BorderLayout.EAST);
	pnlMain.add(pnlNorth, BorderLayout.NORTH);
	pnlMain.add(pnlSouth, BorderLayout.SOUTH);
	
	
	
	getContentPane().add(pnlMain);		
	setVisible(true);    
}

	private Component createLabel(JLabel lblUeberschrift2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}