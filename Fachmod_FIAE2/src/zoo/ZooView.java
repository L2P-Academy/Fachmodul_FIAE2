package zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZooView extends JFrame implements ActionListener {

    private JLabel lblBegruessung;
    private JButton btnEintritt;
    private JPanel pnlHaupt;

    public ZooView() {
        // Fenster initialisieren
        setTitle("Zoo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hauptpanel erstellen
        pnlHaupt = new JPanel();
        pnlHaupt.setLayout(new BorderLayout());

        // Begrüßungslabel erstellen
        lblBegruessung = new JLabel("Herzlich willkommen im Zoo!");
        lblBegruessung.setHorizontalAlignment(SwingConstants.CENTER);

        // Button für den Eintritt erstellen
        btnEintritt = new JButton("Eintritt");
        btnEintritt.addActionListener(this);

        // Panel und Button zum Hauptpanel hinzufügen
        pnlHaupt.add(lblBegruessung, BorderLayout.NORTH);
        pnlHaupt.add(btnEintritt, BorderLayout.CENTER);

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

    public static void main(String[] args) {
        // ZooView-Instanz erstellen und starten
        new ZooView();
    }


	public void displayAnimals() {
	}
}