package zoo.View;

import java.awt.*;

import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

import zoo.Controller.SalesController;
import zoo.Controller.XMLController;
import zoo.Model.SerializationIDs;
import zoo.Model.Ticketsystem;
import zoo.View.ZooView;




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
	private SalesController salesController;
	private ZooView zooView;
	private Ticketsystem ticketSystem;
	private XMLController xmlController;
	
	private int anzahl;
	private int dauer;
	private double preis;
	private double zeilenPreis;



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
	
	
	
	// Daten für die Tabelle
	xmlController = new XMLController(ticketSystem);
    String[][] data = xmlController.xmlRead();

    // Spaltenüberschriften
    String[] columnNames = {"ID", "Art", "Dauer", "Datum", "Preis"};

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
            {"Erwachsene", "2", "5", ""},
            {"Erwachsene", "4", "3", ""},
            {"Erwachsene", "6", "4", ""},
            {"", "", "", ""},
            {"Kinder", "2", "6", ""},
            {"Kinder", "4", "9", ""},
            {"Kinder", "6", "7", ""},
            {"", "", "", ""},
            {"Senioren", "2", "2", ""},
            {"Senioren", "4", "4", ""},
            {"Senioren", "6", "3", ""},
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
    
//    for (int i = 0; i < auflistung.getRowCount(); i++) {
//    	int gesamtmenge = 0;
//		
//	}
    
    zooView = new ZooView();
    ticketSystem = new Ticketsystem();
    salesController = new SalesController(ticketSystem);
    
    // Berechnung der Ticketanzahl
    // Erwachsene 2h Dauer
    auflistung.setValueAt(calcAmounts("Erwachsene", "2") + "", 0, 2);
    // Erwachsene 4h Dauer
    auflistung.setValueAt(calcAmounts("Erwachsene", "4") + "", 1, 2);
    // Erwachsene 6h Dauer
    auflistung.setValueAt(calcAmounts("Erwachsene", "6") + "", 2, 2);
    
    // Kinder 2h Dauer
    auflistung.setValueAt(calcAmounts("Kinder", "2") + "", 4, 2);
    // Kinder 4h Dauer
    auflistung.setValueAt(calcAmounts("Kinder", "4") + "", 5, 2);
    // Kinder 6h Dauer
    auflistung.setValueAt(calcAmounts("Kinder", "6") + "", 6, 2);
    
    // Senioren 2h Dauer
    auflistung.setValueAt(calcAmounts("Senioren", "2") + "", 8, 2);
    // Senioren 4h Dauer
    auflistung.setValueAt(calcAmounts("Senioren", "4") + "", 9, 2);
    // Senioren 6h Dauer
    auflistung.setValueAt(calcAmounts("Senioren", "6") + "", 10, 2);
	
    // Berechnung der Einzelpreise nach Art und Dauer
    for (int i = 0; i <= 10; i++) {
    	if (i == 3 || i == 7) {
    		continue;
    	}
        anzahl = Integer.parseInt(auflistung.getValueAt(i, 2).toString());
        preis = zooView.getTicketPriceForType(auflistung.getValueAt(i, 0).toString());
        dauer = Integer.parseInt(auflistung.getValueAt(i, 1).toString());
        zeilenPreis = salesController.preisBerechnung(anzahl, preis, dauer);
        auflistung.setValueAt(zeilenPreis + "", i, 3);
	}
    double gesamtpreis = 0;
    // Berechnung des Gesamtpreises unten rechts
    for (int i = 0; i <= 10; i++) {
    	
    	if (i == 3 || i == 7) {
    		continue;
    	}
    	gesamtpreis = gesamtpreis + Double.parseDouble((auflistung.getValueAt(i, 3).toString()));
	}
    auflistung.setValueAt(gesamtpreis + "", 12, 3);

   
    pnlNorth.add(scrollPane, BorderLayout.CENTER);
    pnlSouth.add(scrollPaneAuflistung, BorderLayout.CENTER);
    pnlMain.add(pnlSouth, BorderLayout.SOUTH);
	pnlMain.add(pnlNorth, BorderLayout.NORTH);	
	
	getContentPane().add(pnlMain);		
	setVisible(true);    
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// Mengenberechnung der Tickets
	public int calcAmounts(String ticketType, String dauer) {
		int gesamtMenge = 0;
	    // Schleife Mengenberechnung nach Art und Dauer
	    for (int i = 0; i < ticketTable.getRowCount(); i++) {
	    	String tempType = (ticketTable.getValueAt(i, 1)).toString();
	    	String tempDauer = (ticketTable.getValueAt(i, 2)).toString();
	    	if (tempType.equals(ticketType)) {
				if (tempDauer.equals(dauer)) {
					gesamtMenge = gesamtMenge + 1;
				}
			}
		}
		return gesamtMenge;		
	}
}