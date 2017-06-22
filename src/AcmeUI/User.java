package AcmeUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class User extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public User() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Test");
		lblNewLabel.setBounds(52, 77, 56, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 74, 116, 22);
		add(textField);
		textField.setColumns(10);

	}
	
}
