package zoo.View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicketsSold extends JFrame implements ActionListener{
	
	private JLabel lblVerkaufteTickets;
	private JPanel pnlVerkaufteTickets;
	
	public TicketsSold() {
		setTitle("Verkaufte Tickets");
		setSize(1200, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblVerkaufteTickets = new JLabel("Hier gibt es bald verkaufte Tickets!");
		lblVerkaufteTickets.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlVerkaufteTickets = new JPanel();
		pnlVerkaufteTickets.setLayout(new BorderLayout());
		
		pnlVerkaufteTickets.add(lblVerkaufteTickets);
		getContentPane().add(pnlVerkaufteTickets);		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
