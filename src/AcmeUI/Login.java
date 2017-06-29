package AcmeUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField username;
	private JPasswordField password;

	/**
	 * Create the panel.
	 */
	public Login(JFrame f) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setBounds(179, 11, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBounds(48, 86, 81, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setBounds(48, 142, 46, 14);
		add(lblNewLabel_2);
		
		username = new JTextField();
		username.setBounds(139, 83, 86, 23);
		add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(139, 139, 89, 23);
		add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//f.getContentPane().remove
				String uname=username.getText();
				String psd=password.getText();
				System.out.println("************"+uname+"**********"+psd);
				try {
					Connection conn= DAO.getConnection();
					PreparedStatement ps=conn.prepareStatement("select * from reg where user_name=? and password=?");
					ps.setString(1, uname);
					ps.setString(2, psd);
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(f, "You are successfully logged in");
						
						f.getContentPane().removeAll();
						f.getContentPane().add(new HomeScreen(f));
						f.getJMenuBar().setVisible(true);
						f.getContentPane().revalidate();
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Invalid username or password");
					}
					
					}
					catch (Exception e1) {
						System.out.println("exception occured while connecting to the db: " + e1);
					}
				
				
				/*if (uname.equals("name")&& psd.equals("password"))
				{
					JOptionPane.showMessageDialog(frame, "You are successfully logged in");
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}*/
				
//			HomeScreen H= new HomeScreen();
//			H.setVisible(true);
				    
			
			}
			
		});
		btnLogin.setBounds(177, 240, 89, 23);
		add(btnLogin);

	}

}
