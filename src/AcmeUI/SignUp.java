package AcmeUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Panel;
import java.awt.event.ActionEvent;

public class SignUp extends JPanel {
	
	private Panel contentPane;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private JTextField txtAnswer;
	JComboBox comboBox;
	private final JLabel lblSignUp = new JLabel("Sign Up");
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JTextField textField_5;


	/**
	 * Create the panel.
	 */
	public SignUp(UserInfo u, JFrame f) {
		setLayout(null);
		txtFirstname = new JTextField();
		txtFirstname.setText("firstname");
		txtFirstname.setBounds(10, 120, 86, 20);
		add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setText("lastname");
		txtLastname.setBounds(125, 120, 86, 20);
		add(txtLastname);
		txtLastname.setColumns(10);
		
		JLabel lblSignupscreen = new JLabel("SignupScreen");
		lblSignupscreen.setBounds(264, 11, 168, 14);
		add(lblSignupscreen);
		
		/*JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(54, 147, 71, 14);
		add(lblNewLabel_1);
		*/
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		txtPassword.setBounds(10, 192, 201, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setText("confirm password");
		txtConfirmPassword.setBounds(10, 254, 201, 20);
		add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
 comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is the model of your first car?", "What is your nickname?", "Where were you born?"}));
		 String[] list = new String[] {"What is the model of your first car?", "What is your nickname?", "Where were you born?"};
		 for(int i =0;i<list.length;i++)
	        {
	            comboBox.addItem(list[i]);
	        }
		comboBox.setBounds(396, 120, 191, 20);
		add(comboBox);
		
		txtAnswer = new JTextField();
		txtAnswer.setText("answer");
		txtAnswer.setBounds(396, 172, 191, 20);
		add(txtAnswer);
		txtAnswer.setColumns(10);
		
		
		
		JButton btnClickToSignup = new JButton("Click to signup");
		btnClickToSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=txtFirstname.getText();
				String lname=txtLastname.getText();
				u.setFirst_name(fname);
				u.setLast_name(lname);
				System.out.println("the name in signup :"+u.getFullName());
				String password=txtPassword.getText();
				String confirmpassword=txtConfirmPassword.getText();
				System.out.println("*********"+password);
		//	squestion=(String)comboBox.getSelectedItem();
				String squestion = comboBox.getSelectedItem().toString();
				String answer=txtAnswer.getText();
				System.out.println("==========================>>>>>"+fname+lname+password+confirmpassword+answer+squestion);
				try {
				Connection conn=DAO.getConnection();
				PreparedStatement ps=conn.prepareStatement("insert into reg values(?,?,?,?,?,?)");
				ps.setString(1,fname+lname);
				ps.setString(2,password);
				ps.setString(3,fname);
				ps.setString(4,lname);
				ps.setString(5,squestion);
				ps.setString(6,answer);
				ps.executeUpdate();
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
				f.getContentPane().removeAll();
				//System.out.println("in signup action");
				//Login l = new Login();
				f.getContentPane().add(new SignupConfirmation(u,f));
				
				//getContentPane().add(l);
				f.getContentPane().revalidate();
				
				
//				SignupConfirmation S= new SignupConfirmation();
//				S.setVisible(true);
				
			}
		});
		btnClickToSignup.setBounds(416, 298, 154, 23);
		add(btnClickToSignup);
	}		
	
}
		