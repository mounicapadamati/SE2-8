package AcmeUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void start(UserInfo u) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome(u);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcome(UserInfo u) {
		JFrame f = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setVisible(false);
		
		JMenu mnNewMenu = new JMenu("User");
		mnNewMenu.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new UserInfoScreen(f));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Delivery Tickets");
		mnNewMenu_1.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Customer");
		mnNewMenu_2.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CustomerInfo(f));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Courier");
		mnNewMenu_3.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CourierInfo(f));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Reports");
		mnNewMenu_4.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
			}
		});
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Courier Report");
		mnNewMenu_4.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Delivery Ticket Report");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Invoice Report");
		mnNewMenu_4.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				//System.out.println("in signup action");
				//Login l = new Login();
				getContentPane().add(new SignUp(u,f));
				
				//getContentPane().add(l);
				getContentPane().revalidate();
				
//				dispose();
//				l.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				//Login l = new Login();
				getContentPane().add(new Login(f));
				
				//getContentPane().add(l);
				getContentPane().revalidate();
				
//				dispose();
//				l.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
	}

}
