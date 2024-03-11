package zoo.View;

import zoo.Model.Animal;

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
	private JButton btnDialogAffe, btnDialogElefant, btnDialogLöwe, btnDialogHyäne, btnDialogZebra, btnDialogGiraffe;
	public Font font = new Font("Monospaced", Font.BOLD, 28);
	public Font font2 = new Font("Monospaced", Font.BOLD, 14);
	public Color color=new Color(224,224,224);

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
		
		// Hinzufügen der Menüitems und Menüs zur Menubar
		//startMenu.add(verkaufsuebersichtMenuItem);
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
		
		// Deklaration btnDialog
		btnDialogAffe = new JButton();
		btnDialogAffe.setPreferredSize(new Dimension(50, 20));
		btnDialogAffe.setMaximumSize(new Dimension(50, 30));
		btnDialogAffe.setMinimumSize(new Dimension(50, 10));
		btnDialogAffe.setText("Zum nächsten Gehege");
		
		// JOptionPane Deklarationen
		JOptionPane PaneAffe = new JOptionPane(); 
		JOptionPane PaneElefant = new JOptionPane();
		
		// Nächstes Gehege Button
		btnDialogAffe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				PaneAffe.setValue(JOptionPane.CLOSED_OPTION);
				JOptionPane PaneAffe = new JOptionPane(); 
				JOptionPane PaneElefant = new JOptionPane();
				JTextArea txtElefant = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(1).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(1).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(1).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(1).getType().toString().replace("[", "").replace("]", ""));
				
				txtElefant.setBackground(color);
				txtElefant.setFont(font2);
				
				PaneAffe.setVisible(false);
				
				PaneElefant.showMessageDialog(null, new Object[]{txtElefant, lblElefant} , "Affengehege", JOptionPane.INFORMATION_MESSAGE);
				PaneElefant.setVisible(true);

				}
		});

		
		// Buttons ActionListener
		
		btnAffe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtAffe = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(3).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(3).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(3).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(3).getType().toString().replace("[", "").replace("]", ""));
				
				txtAffe.setBackground(color);
				txtAffe.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtAffe, lblAffe, btnDialogAffe} , "Affengehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnElefant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtElefant = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(1).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(1).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(1).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(1).getType().toString().replace("[", "").replace("]", ""));
				
				txtElefant.setBackground(color);
				txtElefant.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtElefant, lblElefant} , "Elefantengehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnGiraffe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtGiraffe = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(2).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(2).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(2).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(2).getType().toString().replace("[", "").replace("]", ""));
				
				txtGiraffe.setBackground(color);
				txtGiraffe.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtGiraffe, lblGiraffe} , "Giraffengehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnLöwe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtLöwe = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(0).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(0).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(0).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(0).getType().toString().replace("[", "").replace("]", ""));
				
				txtLöwe.setBackground(color);
				txtLöwe.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtLöwe, lblLöwe} , "Löwengehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnZebra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtZebra = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(4).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(4).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(4).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(4).getType().toString().replace("[", "").replace("]", ""));
				
				txtZebra.setBackground(color);
				txtZebra.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtZebra, lblZebra} , "Zebragehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnHyäne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent v) {
				JTextArea txtHyäne = new JTextArea(
						"Tierart: " + Animal.createAnimals().get(5).getSpecies() 
						+ "\nName: " + Animal.createAnimals().get(5).getName() 
						+ "\nAlter: " + Animal.createAnimals().get(5).getAge() + " Jahre"
						+ "\nErnährungstyp: " + Animal.createAnimals().get(5).getType().toString().replace("[", "").replace("]", ""));
				
				txtHyäne.setBackground(color);
				txtHyäne.setFont(font2);
				
				JOptionPane.showMessageDialog(null, new Object[]{txtHyäne, lblHyäne} , "Hyänengehege", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
