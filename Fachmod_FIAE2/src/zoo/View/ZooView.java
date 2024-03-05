package zoo.View;

import javax.swing.*;

import zoo.Controller.SalesController;
import zoo.Model.Ticketsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

public class ZooView extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu dateiMenu;
	private JMenuItem beendenMenuItem;
	private JButton btnEintritt;
	private JPanel pnlHaupt;
	private JPanel anzahlPanel;
	private ImageIcon imageIcon;
	private String imgLogoPath;
	private JLabel lblImageWelcome;
	private int scaledWidth, scaledHeight;
	private JComboBox<Integer> anzahlComboBox;

	private SalesController salesController;
	
	private JRadioButton kinderButton, erwachseneButton, seniorenButton;

	private Date date;
	
	public ZooView() {
		salesController = new SalesController(new Ticketsystem());

		// Fenster initialisieren
		setTitle("Zoo Eintritt");
		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imgLogoPath = "res/img/Zoo_Logo.png";

		// Menubar erstellen
		menubar = new JMenuBar();
		dateiMenu = new JMenu("Datei");
		beendenMenuItem = new JMenuItem("Beenden");
		beendenMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		dateiMenu.add(beendenMenuItem);
		menubar.add(dateiMenu);
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

		// Trennlinie einfügen
		JSeparator separator = new JSeparator();

		// Radiobuttons für Ticketverkauf deklarieren
		kinderButton = new JRadioButton("Kinder");
		erwachseneButton = new JRadioButton("Erwachsene");
		seniorenButton = new JRadioButton("Senioren");

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
		anzahlPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

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
		pnlHaupt.add(anzahlPanel, BorderLayout.EAST);
		pnlHaupt.add(btnEintritt, BorderLayout.SOUTH);
		pnlHaupt.add(separator);

		// Hauptpanel zum Fenster hinzufügen
		getContentPane().add(pnlHaupt);

		// Fenster sichtbar machen
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		salesController.sellTicket(getSelectedTicketType(), getTicketPriceForType(getSelectedTicketType()), Calendar.getInstance().getTime());
		JOptionPane.showMessageDialog(this, "Willkommen im Zoo!");
	}

	public void displayAnimals() {
	}

	private String getSelectedTicketType() {

		if (kinderButton.isSelected()) {
			return "Kinder";
		} else if (erwachseneButton.isSelected()) {
			return "Erwachsene";
		} else if (seniorenButton.isSelected()) {
			return "Senioren";
		}
		return "";
	}

	private Double getTicketPriceForType(String ticketType) {
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

}
