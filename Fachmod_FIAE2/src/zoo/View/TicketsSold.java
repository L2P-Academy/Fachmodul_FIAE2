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
	private JPanel pnlMenge;
	private JTable auflistung;
	private JTable gesammtGeld;
	private JTable gesammtMenge;


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
	pnlAuflistung.setLayout(new BorderLayout()); 
	
	pnlBerechnung = new JPanel();
	pnlBerechnung.setLayout(new BorderLayout()); 
	
	pnlMenge = new JPanel();
	pnlMenge.setLayout(new BorderLayout());
	
	
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
    
 // Daten für die Tabelle
    String[][] daten = {
            {"Erwachsen"},
            {"Kind"},
            {"Senioren"},
            {"Gesammt"}
    };

    // Spaltenüberschriften
    String[] ueberschriftWest = {"Art"};

    // JTable erstellen und speeren der änderung in Zeilen
    auflistung = new JTable(daten, ueberschriftWest) {

		public boolean isCellEditable(int x, int y) {
            return false;
        }
    };
    
    // JTable zu JScrollPane hinzufügen
    JScrollPane scrollPaneAuflistung = new JScrollPane(auflistung);
	
    // Daten für die Tabelle
    String[][] menge = {
            {"230 Stk",},
            {"170 Stk"},
            {"50 Stk"},
            {"450 Stk"}
    };

    // Spaltenüberschriften
    String[] ueberschriftCenter = {"Menge"};

    // JTable erstellen und speeren der änderung in Zeilen
    gesammtMenge = new JTable(menge, ueberschriftCenter) {

		public boolean isCellEditable(int x, int y) {
            return false;
        }
    };
    
    // JTable zu JScrollPane hinzufügen
    JScrollPane scrollPaneMenge = new JScrollPane(gesammtMenge);
	
    
    // Daten für die Tabelle
    String[][] geld = {
            {"250 €",},
            {"150 €"},
            {"50 €"},
            {"450 €"}
    };

    // Spaltenüberschriften
    String[] ueberschriftEast = {"Euro"};

    // JTable erstellen und speeren der änderung in Zeilen
    gesammtGeld = new JTable(geld, ueberschriftEast) {

		public boolean isCellEditable(int x, int y) {
            return false;
        }
    };

    // JTable zu JScrollPane hinzufügen
    JScrollPane scrollPaneGeld = new JScrollPane(gesammtGeld);
    
    
    pnlNorth.add(scrollPane, BorderLayout.CENTER);
    pnlAuflistung.add(scrollPaneAuflistung, BorderLayout.CENTER);
    pnlMenge.add(scrollPaneMenge, BorderLayout.CENTER);
    pnlBerechnung.add(scrollPaneGeld, BorderLayout.CENTER);
	pnlSouth.add(pnlAuflistung, BorderLayout.WEST);
	pnlSouth.add(pnlBerechnung, BorderLayout.EAST);
	pnlSouth.add(pnlMenge, BorderLayout.CENTER);
	pnlMain.add(pnlNorth, BorderLayout.NORTH);
	pnlMain.add(pnlSouth, BorderLayout.SOUTH);
	
	
	
	getContentPane().add(pnlMain);		
	setVisible(true);    
}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}