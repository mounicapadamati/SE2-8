package AcmeUI;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import java.awt.MenuBar;
import javax.swing.JLabel;

public class HomeScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomeScreen(JFrame f) {
		setLayout(null);
		
		JLabel lblAcmeCourierService = new JLabel("ACME COURIER SERVICE");
		lblAcmeCourierService.setBounds(137, 126, 172, 35);
		add(lblAcmeCourierService);
		

	}
}
