package zoo.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZooView extends JFrame implements ActionListener {

    private JButton btnEintritt;
    private JPanel pnlHaupt;
    private ImageIcon imageIcon;
    private String imgLogoPath;
    private JLabel lblImageWelcome;
    private int scaledWidth, scaledHeight;

    public ZooView() {
        // Fenster initialisieren
        setTitle("Zoo Eintritt");
        setSize(1400, 1100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgLogoPath = "res/img/Zoo_Logo.png";        

        // Hauptpanel erstellen
        pnlHaupt = new JPanel();
        pnlHaupt.setLayout(new BorderLayout());
        
        // Bild einbinden
        imageIcon = new ImageIcon(imgLogoPath);
        Image originalImage = imageIcon.getImage();
        
        // Bild skalieren
        scaledWidth = 1400;
        scaledHeight = 600;
        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        lblImageWelcome = new JLabel(scaledIcon);
        
        // Trennlinie einfügen
        JSeparator separator = new JSeparator();

        // Button für den Eintritt erstellen -> Anpassen der Größe, Hintergrund, Vordergrund, Schriftfarbe, Art usw.
        btnEintritt = new JButton("Eintritt");
        btnEintritt.addActionListener(this);

        // Panel und Button zum Hauptpanel hinzufügen
        pnlHaupt.add(lblImageWelcome, BorderLayout.NORTH);
        pnlHaupt.add(btnEintritt, BorderLayout.SOUTH);
        pnlHaupt.add(separator);

        // Hauptpanel zum Fenster hinzufügen
        getContentPane().add(pnlHaupt);

        // Fenster sichtbar machen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Aktion beim Klicken auf den Button "Eintritt"
        JOptionPane.showMessageDialog(this, "Viel Spaß im Zoo!");
    }


	public void displayAnimals() {
	}
}