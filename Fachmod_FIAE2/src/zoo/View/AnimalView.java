package zoo.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AnimalView extends JFrame implements ActionListener{
	
	private JLabel lblTiergehege;
	private JPanel pnlTiergehege;
	
	public AnimalView() {
		setTitle("Tiergehege");
		setSize(1400, 1100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblTiergehege = new JLabel("Hier gibt es bald Tiere!");
		lblTiergehege.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlTiergehege = new JPanel();
		pnlTiergehege.setLayout(new BorderLayout());
		
		pnlTiergehege.add(lblTiergehege);
		getContentPane().add(pnlTiergehege);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
