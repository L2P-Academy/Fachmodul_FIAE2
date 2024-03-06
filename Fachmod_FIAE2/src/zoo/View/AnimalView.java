package zoo.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AnimalView extends JFrame implements ActionListener{
	
	private JLabel lblTiergehege;
	private JPanel pnlTiergehege;
	
	public AnimalView() {
		setTitle("Tiergehege");
		setSize(1200, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblTiergehege = new JLabel("Hier gibt es bald Tiere!");
		lblTiergehege.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlTiergehege = new JPanel();
		pnlTiergehege.setLayout(new GridLayout(3, 2));
		
		ImageIcon imgAffe = new ImageIcon("res/img/Affe.jpg");
		ImageIcon imgElefant = new ImageIcon("res/img/Elefant.jpg");
		ImageIcon imgGiraffe = new ImageIcon("res/img/Giraffe.jpg");
		ImageIcon imgLöwe = new ImageIcon("res/img/Löwe.jpg");
		ImageIcon imgZebra = new ImageIcon("res/img/Zebra.jpg");
		
		JLabel lblAffe = new JLabel(imgAffe);
		JLabel lblElefant = new JLabel(imgElefant);
		JLabel lblGiraffe = new JLabel(imgGiraffe);
		JLabel lblLöwe = new JLabel(imgLöwe);
		JLabel lblZebra = new JLabel(imgZebra);
		
		getContentPane().add(pnlTiergehege);
		pnlTiergehege.add(lblAffe);
		pnlTiergehege.add(lblElefant);
		pnlTiergehege.add(lblGiraffe);
		pnlTiergehege.add(lblLöwe);
		pnlTiergehege.add(lblZebra);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
