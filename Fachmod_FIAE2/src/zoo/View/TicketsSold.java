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
	private JTable auflistung;



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
	
	JSeparator trennLinie = new JSeparator();
	
	
	
	// Daten für die Tabelle
    String[][] data = {
            {"1", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"2", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"3", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"4", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"5", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"6", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"7", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"8", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"9", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"10", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"11", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"12", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"13", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"14", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"15", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"16", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"17", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"18", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"19", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"20", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"21", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"22", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"23", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"24", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"25", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"26", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"27", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"28", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"29", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"30", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"31", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"32", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"33", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"34", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"35", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"36", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"37", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"38", "Kind", "4", "5", "22.03.2024", "75.0"},
            {"39", "Senioren", "6", "10", "15.03.2024", "100.0"},
            {"40", "Erwachsen", "2", "3", "02.03.2024", "50.0"},
            {"41", "Kind", "4", "5", "22.03.2024", "75.0"}
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
    
 // Daten für die Tabelle
    String[][] daten = {
            {"Erwachsen", "2", "", ""},
            {"Erwachsen", "4", "", ""},
            {"Erwachsen", "6", "", ""},
            {"", "", "", ""},
            {"Kind", "2", "", ""},
            {"Kind", "4", "", ""},
            {"Kind", "6", "", ""},
            {"", "", "", ""},
            {"Senioren", "2", "", ""},
            {"Senioren", "4", "", ""},
            {"Senioren", "6", "", ""},
            {"", "", "", ""},
            {"Gesamt nach Dauer", "2", "", ""},
            {"Gesamt nach Dauer", "4", "", ""},
            {"Gesamt nach Dauer", "6", "", ""},
            {"", "", "", ""},
            {"Gesamt", "", "", ""}
    };

    // Spaltenüberschriften
    String[] ueberschrift = {"Art", "Dauer", "Menge", "Einnahmen"};

    // JTable erstellen und speeren der änderung in Zeilen
    auflistung = new JTable(daten, ueberschrift) {

		public boolean isCellEditable(int x, int y) {
            return false;
        }
    };
    
    // JTable zu JScrollPane hinzufügen
    JScrollPane scrollPaneAuflistung = new JScrollPane(auflistung);
	
   
    pnlNorth.add(scrollPane, BorderLayout.CENTER);
    pnlSouth.add(scrollPaneAuflistung, BorderLayout.CENTER);
    pnlMain.add(pnlSouth, BorderLayout.SOUTH);
	pnlMain.add(pnlNorth, BorderLayout.NORTH);
	pnlMain.add(trennLinie);
	
	
	
	getContentPane().add(pnlMain);		
	setVisible(true);    
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}