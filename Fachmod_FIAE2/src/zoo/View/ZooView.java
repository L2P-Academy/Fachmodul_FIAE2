package zoo.View;

import javax.swing.*;

import zoo.Controller.SalesController;
import zoo.Controller.XMLController;
import zoo.Model.Ticket;
import zoo.Model.Ticketsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class ZooView extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu startMenu, ansichtMenu, zooverwaltungMenu;
	private JMenuItem beendenMenuItem, minimierenMenuItem, maximierenMenuItem, standardMenuItem, listeTiereMenuItem, verkaufteTicketsMenuItem;
	private JButton btnEintritt;
	private JRadioButton kinderButton, erwachseneButton, seniorenButton;
	private JPanel pnlHaupt;
	private ImageIcon imageIcon;
	private String imgLogoPath;
	private JLabel lblImageWelcome;
	private int scaledWidth, scaledHeight;
	private JComboBox<String> dauerComboBox;
	private JComboBox<Integer> anzahlComboBox;
	private SalesController salesController;
	private XMLController xmlController;
	private Date date;
	private int ticketAnzahl;
	private String besuchsdauer;
	private Ticketsystem ticketsystem;

	public ZooView() {
		ticketsystem = new Ticketsystem();
		salesController = new SalesController(ticketsystem);
		xmlController = new XMLController(ticketsystem);
		
		
		// Fenster initialisieren
		setTitle("Zoo Eintritt");
		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imgLogoPath = "res/img/Zoo_Logo.png";

		// Menubar erstellen
		menubar = new JMenuBar();
		startMenu = new JMenu("Start");
		ansichtMenu = new JMenu("Ansicht");
		zooverwaltungMenu = new JMenu("Zooverwaltung");
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
		

		// Hauptpanel erstellen
		pnlHaupt = new JPanel();
		pnlHaupt.setLayout(new FlowLayout());

		// Bild einbinden
		imageIcon = new ImageIcon(imgLogoPath);
		Image originalImage = imageIcon.getImage();

		// Bild skalieren
		scaledWidth = 1080;
		scaledHeight = 520;
		Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblImageWelcome = new JLabel(scaledIcon);

		// Radiobuttons für Ticketverkauf deklarieren
		kinderButton = new JRadioButton("Kinder - 5,00 €");
		erwachseneButton = new JRadioButton("Erwachsene - 20,00 €");
		seniorenButton = new JRadioButton("Senioren - 15,00 €");
		
		erwachseneButton.setSelected(true);

		// RadioButtons der ButtonsGroup hinzufügen
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(kinderButton);
		buttonGroup.add(erwachseneButton);
		buttonGroup.add(seniorenButton);

		// Panel für Radiobuttons erstellen
		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(3, 1));
		radioPanel.add(kinderButton);
		radioPanel.add(erwachseneButton);
		radioPanel.add(seniorenButton);

		// Label für "Ticketart"
		JLabel lblTicketart = new JLabel("Ticketart: ");

		// Panel für Label und Radiobuttons erstellen
		JPanel labelRadioPanel = new JPanel();
		labelRadioPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelRadioPanel.add(lblTicketart);
		labelRadioPanel.add(radioPanel);
		labelRadioPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));

		// Label für die Anzahl der Tickets
		JLabel lblAnzahlTickets = new JLabel("Anzahl der Tickets: ");

		// Panel für das Label und das Eingabefeld erstellen
		JPanel anzahlPanel = new JPanel(new BorderLayout());
		anzahlComboBox = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			anzahlComboBox.addItem(i);
		}
		anzahlPanel.add(anzahlComboBox);
		anzahlPanel.add(lblAnzahlTickets, BorderLayout.WEST);
		anzahlPanel.add(anzahlComboBox, BorderLayout.CENTER);
		anzahlPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));
		
		//Dropdownmenu für Dauer des Aufenthalts
		String dauerStunden = " Std.";
		JPanel dauerPanel = new JPanel(new BorderLayout());
		dauerComboBox = new JComboBox<>();
		for (int i = 2; i <= 6; i+=2) {
			dauerComboBox.addItem(i + dauerStunden);
			}
		
		JLabel lblDauer = new JLabel("Dauer des Aufenthalts:");
		dauerPanel.add(lblDauer, BorderLayout.CENTER);
		dauerPanel.add(dauerComboBox, BorderLayout.CENTER);
		dauerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 150));
		
		// Button für den Eintritt erstellen -> Anpassen der Größe, Hintergrund,
		// Vordergrund, Schriftfarbe, Art usw.
		btnEintritt = new JButton("Eintritt");
		btnEintritt.setMaximumSize(new Dimension(200, Integer.MAX_VALUE));
		btnEintritt.addActionListener(this);
		btnEintritt.setBackground(Color.GREEN.darker());
		btnEintritt.setFont(new Font("Monospaced", Font.BOLD, 20));

		// Panel und Button zum Hauptpanel hinzufügen
		pnlHaupt.add(lblImageWelcome, BorderLayout.NORTH);
		pnlHaupt.add(labelRadioPanel, BorderLayout.WEST);
		pnlHaupt.add(lblDauer, BorderLayout.CENTER);
		pnlHaupt.add(dauerPanel,BorderLayout.CENTER);
		pnlHaupt.add(anzahlPanel, BorderLayout.EAST);
		pnlHaupt.add(btnEintritt, BorderLayout.SOUTH);

		// Hauptpanel zum Fenster hinzufügen
		getContentPane().add(pnlHaupt);

		// Fenster sichtbar machen
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		salesController.sellTicket(getSelectedTicketType(), getTicketPriceForType(getSelectedTicketType()),
//				Calendar.getInstance().getTime());
		ticketAnzahl = (int) anzahlComboBox.getSelectedItem();
		besuchsdauer = (String) dauerComboBox.getSelectedItem();
		
		// Umwandlung der Besuchsdauer zurück in Integer für spätere Berechnung
		besuchsdauer = besuchsdauer.replace(" Std.", "");
		int dauer = Integer.parseInt(besuchsdauer);
		
		Date date = new Date();
		ticketsystem.addTicket(getSelectedTicketType(),getTicketPriceForType(getSelectedTicketType()),date);
		for (int i = 0; i < ticketAnzahl; i++) {
			xmlController.xmlWrite(dauer);
		}
		xmlController.xmlRead();
		JOptionPane.showMessageDialog(this, salesController.preisBerechnung(ticketAnzahl, getTicketPriceForType(getSelectedTicketType()), dauer) );
	}
		
	public String getSelectedTicketType() {

		if (kinderButton.isSelected()) {
			return "Kinder"; 
		} else if (erwachseneButton.isSelected()) { 
			return "Erwachsene";
		} else if (seniorenButton.isSelected()) {
			return "Senioren";
		}
		return "";
	}

	public Double getTicketPriceForType(String ticketType) {
		switch (ticketType) {
		case "Kinder":
			return 5.0;
		case "Erwachsene":
			return 20.0;
		case "Senioren":
			return 15.0;
		default:
			return 0.0; // Rückgabe von 0.0, wenn der Tickettyp nicht erkannt wird
		}
	}

	public void displayAnimals() {
	}

}
