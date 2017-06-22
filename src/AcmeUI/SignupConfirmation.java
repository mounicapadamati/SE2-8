package AcmeUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignupConfirmation extends JPanel {

	/**
	 * Create the panel.
	 */
	public SignupConfirmation(UserInfo u, JFrame f) {
		setLayout(null);
		
		JLabel lblCongratulationYourNew = new JLabel("Congratulation! Your new username is "+ u.getFullName());
		lblCongratulationYourNew.setBounds(48, 131, 303, 24);
		add(lblCongratulationYourNew);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().removeAll();
				//Login l = new Login();
				f.getContentPane().add(new Login(f));
				
				//getContentPane().add(l);
				f.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(317, 243, 89, 23);
		add(btnNewButton);
		

	}

}
