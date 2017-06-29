package AcmeUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AcmeUtility.GraphUtility;
import AcmeUtility.Vertex;

public class DeliveryTicket extends JPanel {
	private Connection cn;
	private Statement st;
	private String cusid;
	String address = "";
	String source = "";
	private	PreparedStatement ps;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private GraphUtility graph = new GraphUtility();
	private LinkedList<Vertex> path = null;
	private Integer blocks =0;
	private Integer time = 0;
	//path = graph.populateAndFind();
	
	
	/**
	 * Create the panel.
	 */
	public DeliveryTicket(JFrame f) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Date");
		lblNewLabel.setBounds(10, 47, 114, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Order Time");
		lblNewLabel_1.setBounds(10, 84, 151, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pickup Details ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 121, 114, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order Taken By");
		lblNewLabel_3.setBounds(293, 47, 114, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Package ID");
		lblNewLabel_4.setBounds(10, 263, 114, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Customer ID");
		lblNewLabel_5.setBounds(10, 159, 114, 14);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Customer ID");
		lblNewLabel_6.setBounds(293, 159, 104, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Customer Name");
		lblNewLabel_7.setBounds(10, 194, 151, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Ticket Info ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 227, 151, 14);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Customer Name");
		lblNewLabel_9.setBounds(293, 194, 114, 14);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Delivery Info");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(293, 121, 161, 14);
		add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Courier No");
		lblNewLabel_11.setBounds(293, 227, 109, 14);
		add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Estimated Delivery Time");
		lblNewLabel_12.setBounds(10, 298, 130, 14);
		add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Assigned Time");
		lblNewLabel_13.setBounds(292, 263, 124, 14);
		add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Estimated Blocks");
		lblNewLabel_14.setBounds(10, 342, 86, 14);
		add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Actual Pickup Time");
		lblNewLabel_15.setBounds(293, 298, 89, 14);
		add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Actual Delivered Time");
		lblNewLabel_16.setBounds(293, 342, 141, 14);
		add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Estimated Price ");
		lblNewLabel_17.setBounds(10, 397, 114, 14);
		add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Bonus");
		lblNewLabel_18.setBounds(306, 397, 46, 14);
		add(lblNewLabel_18);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
		}
			
		});
		btnNewButton.setBounds(86, 488, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Generate Directions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().removeAll();
				f.getContentPane().add(new Directions(f,path));
				f.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(211, 488, 141, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(376, 488, 89, 23);
		add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(104, 44, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 81, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 191, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String name = "";
				
				List <String> customer ;
				cusid = textField_3.getText();
				System.out.println("in thetxt_3 event, the id value:"+textField_3.getText()+"the cusid is :"+cusid);
				//name = getCusName(cusid);
				customer = getCustomer(cusid);
				name = customer.get(0);
				source = customer.get(1);
				System.out.println("the source from ticket"+source);
				
				
				//System.out.println("in thetxt_5 event,name: "+name+" address:"+address);
				
				if(name!=null && !(name.equals(""))){
					textField_2.setText(name);
				}
			}
		});
		textField_3.setBounds(104, 146, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(403, 191, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String name = "";
				String address = "";
				List <String> customer ;
				cusid = textField_5.getText();
				System.out.println("in thetxt_5 event, the id value:"+textField_5.getText()+"the cusid is :"+cusid);
				//name = getCusName(cusid);
				customer = getCustomer(cusid);
				name = customer.get(0);
				address = customer.get(1);
				
				
				System.out.println("in thetxt_5 event,name: "+name+" destination:"+address);
				
				if(name!=null && !(name.equals(""))){
					textField_4.setText(name);
				}
				path = graph.populateAndFind(source,address);
				if(path.size() >0){
					blocks = path.size();
					time =  path.size();
					textField_13.setText(blocks.toString());
					textField_8.setText(time.toString());
					String price = "";
					int edge_count = path.size()-1;
					Integer total_price = 10 +(edge_count*2);
					price = total_price.toString();
					textField_14.setText(price);
				}
			}
		});
		
		
		textField_5.setBounds(403, 156, 86, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(403, 232, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
	
		
		textField_7 = new JTextField();
		textField_7.setBounds(104, 260, 86, 20);
		add(textField_7);
		textField_7.setColumns(10);
		String package_id = "";
		//package_id =getPackage_Id();
		if(package_id!= null && !(package_id!="")){
			textField_7.setText(package_id);
		}
		else{
			package_id = "0";
			textField_7.setText(package_id);
		}
		
		textField_8 = new JTextField();
		textField_8.setBounds(150, 295, 86, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
//		path = graph.populateAndFind();
//		if(path.size() >0){
//			blocks = path.size();
//			time =  path.size();
//		}
		
		textField_9 = new JTextField();
		textField_9.setBounds(403, 263, 86, 20);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(403, 298, 86, 20);
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(413, 339, 86, 20);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(403, 394, 86, 20);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(116, 339, 86, 20);
		add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(104, 394, 86, 20);
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(387, 44, 86, 20);
		add(textField_15);
		textField_15.setColumns(10);
		
		//test connection for data population
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sri", "mounica", "Chat@123");
		//	JOptionPane.showMessageDialog(null,"Connected",null, JOptionPane.INFORMATION_MESSAGE, null);

		}catch(ClassNotFoundException a){
			a.printStackTrace();
		//	JOptionPane.showMessageDialog(null,"err1",null, JOptionPane.INFORMATION_MESSAGE, null);
		}catch(SQLException b){
			b.printStackTrace();
		//	JOptionPane.showMessageDialog(null,"err2",null, JOptionPane.INFORMATION_MESSAGE, null);
		}
		

	}
	
	public void save(){
		try {
			st=cn.createStatement();
	
//			ps=cn.prepareStatement("INSERT INTO delivery_info"
//					+ "(Package_Id,est_delivery_time,Act_pickup_time,Act_delivery_time,No_of_blocks,est_price,Bonus,"
//					+ "order_date,order_time,order_taken_by,driver_id,delivery_customer_id,pickup_customer_id) values('" + 
//					textField_7.getText() + "','" + textField_8.getText() +  "','" + textField_10.getText() + "','" + 
//					textField_11.getText() + "','" + textField_13.getText() + "','" +textField_14.getText() + "','" +
//					textField_12.getText()+ "','" +textField.getText()+ "','" +textField_1.getText()+ "','"+
//					textField_15.getText()+"','" +textField_6.getText()+ "','"+textField_5.getText()+ "','"+
//					textField_3.getText()+"'" );
			String Package_id =textField_7.getText();
			String est_delivery_time ="4";
			String Act_pickup_time ="8:00:01";
			String Act_delivery_time ="8:15:05";
			String No_of_blocks ="4";
			String est_price ="10";
			String Bonus ="0";
			String order_date ="2017-06-27";
			String order_time ="7:28:15";
			String order_taken_by ="Noah";
			String driver_id ="2";
			String delivery_customer_id ="1002";
			String pickup_customer_id ="1001";
//			Date od = new Date(order_date);
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
			
			


			/*ps = cn.prepareStatement("INSERT INTO delivery_info"
					+"(Package_Id,est_delivery_time,Act_pickup_time,Act_delivery_time,No_of_blocks,est_price,Bonus,"
					+ "order_date,order_time,order_taken_by,driver_id,delivery_customer_id,pickup_customer_id) values('"
					+ Package_id+"','"+	est_delivery_time+"','"+Act_pickup_time+"','"+Act_delivery_time+"','"
					+ No_of_blocks+"','"+est_price+"','"+Bonus+"','"+order_date+"','"+order_time+"','"
					+ order_taken_by+"','"+driver_id+"','"+delivery_customer_id+"','"+pickup_customer_id+"'"	
					);*/
			
			String varname1 = ""
					+ "INSERT INTO delivery_info (Package_Id,est_delivery_time,Act_pickup_time,Act_delivery_time,No_of_blocks,est_price,Bonus,order_date,order_time,order_taken_by,driver_id,delivery_customer_id,pickup_customer_id) values('5','4 ','8:00:01','8:15:05','4','10','0','2017-06-27','7:28:15','Noah','2','1002','1001')";
			
//			ps=cn.prepareStatement( "INSERT INTO delivery_info (Package_Id,est_delivery_time,Act_pickup_time,Act_delivery_time,No_of_blocks,est_price,Bonus,      order_date,order_time,order_taken_by,driver_id,delivery_customer_id,pickup_customer_id) values"
//					+ "('"+ Package_id+"','"+	est_delivery_time+" ','"+Act_pickup_time+"','"+Act_delivery_time+"',"
//							+ "'"+ No_of_blocks+"','"+est_price+"','"+Bonus+"','"+order_date+"','"+order_time+"','"+ order_taken_by+"','"+driver_id+"','"+delivery_customer_id+"','"+pickup_customer_id+"'"
//					 );
			String q = "INSERT INTO delivery_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
			ps = cn.prepareStatement(q);
			
			ps.setString(1, Package_id);
			ps.setString(3, est_delivery_time);
			ps.setString(4, Act_pickup_time);
			ps.setString(5, Act_delivery_time);
			ps.setString(6, No_of_blocks);
			ps.setString(7, est_price);
			ps.setString(8, Bonus);
			ps.setString(9, order_date);
			ps.setString(10, order_time);
			ps.setString(11, order_taken_by);
			ps.setInt(13,Integer.parseInt(driver_id));
			ps.setInt(12,Integer.parseInt(delivery_customer_id));
			ps.setInt(2,Integer.parseInt(pickup_customer_id));













//			ps=cn.prepareStatement("INSERT INTO delivery_info"
//					+ " (Package_Id,est_delivery_time,Act_pickup_time,Act_delivery_time,No_of_blocks,est_price,Bonus,"
//					+ "order_date,order_time,order_taken_by,driver_id,delivery_customer_id,pickup_customer_id) values('" + 
//					2+"', '4', '8:00:01', '8:15:05', '4', '10', '0', '2017-06-27', '7:28:15','Noah','2', '1002', '1001'");
//			
			int r = ps.executeUpdate();
			//put a joption window to display a message saying your record is saved
			System.out.println("the transaction result:"+r);

	
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public List getCustomer(String id){
		
		List<String> customer = new ArrayList<String>();
		//String [] customer  ;
		String name = "";
		String address ="";
		try {
			st=cn.createStatement();
			ResultSet rs = st.executeQuery("select * from cusinfo where customer_id ='"+cusid+"'");
			while(rs.next()){
				name = rs.getString("customer_name");
				address = rs.getString("address");
				 customer.add(name);
				 customer.add(address);
				System.out.println("the name :"+ customer.toString());
			}
			
	
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return customer;
		
	}
	
	public String getPackage_Id(){
		String id ="";
		try {
			System.out.println("cnnctn obj : "+cn);
			st=cn.createStatement();
			ResultSet rs = st.executeQuery("select max(package_id) from Delivery_info ");
			while(rs.next()){
				id = rs.getString("package_id");
				System.out.println("the package id :"+ id);
			}
			
	
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return id;
	}
}
