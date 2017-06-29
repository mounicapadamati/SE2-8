package AcmeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

public class DeliveryTicketsReport extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	private DefaultTableModel tblModel;
	JTable tblList;
	private Connection cn;
	private Statement st;
	private	PreparedStatement ps;
	
	private String addedit;
    private JTextField txtPhone;
	private JTextField txtName;
	private JComboBox cboGender;
	private JButton btnAdd;
private JButton btnEdit;
private JButton btnDelete;
private JButton btnExit;
private Panel panelinfo;
private String pname;
private Panel panel;
private JTextField txtSearch;
	
	
	public DeliveryTicketsReport(JFrame f) {
		setLayout(null);
		
btnAdd = new JButton("Print");
		
		btnAdd.setBounds(10, 222, 73, 30);
		add(btnAdd);
		
		 btnEdit = new JButton("Edit");
		
		btnEdit.setBounds(100, 222, 73, 30);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		
		btnDelete.setBounds(190, 222, 73, 30);
		add(btnDelete);
		
	 btnExit = new JButton("Exit");

		btnExit.setBounds(280, 222, 73, 30);
		add(btnExit);
		
		panelinfo = new Panel();
		//panelinfo.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//panelinfo.setBounds(243, 76, 329, 135);
		panelinfo.setBounds(10, 26,  359, 175);
		add(panelinfo);
		panelinfo.setLayout(null);
        
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(113, 60, 210, 17);
		panelinfo.add(txtPhone);
		
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(113, 28, 206, 20);
		panelinfo.add(txtName);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(10, 34, 113, 14);
		panelinfo.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date :");
		lblEndDate.setBounds(10, 62, 73, 14);
		panelinfo.add(lblEndDate);
                
		panel = new Panel();
		//panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 76, 230, 86);
		//add(panel);
		panel.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 26, 210, 20);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JList list = new JList();
		list.setBounds(49, 184, 128, -103);
		panel.add(list);
		
		//JButton btnsearch = new JButton("Search");
		
		//btnsearch.setBounds(126, 57, 94, 18);
		//panel.add(btnsearch);
		
		
		

 
        
	//	tblList = new JTable();
	//	tblList.setBorder(new LineBorder(new Color(0, 0, 0)));
		//tblList.setBounds(55, 314, 496, 116);
		//tblList.setEnabled(false);
		 tblList = new JTable(new DefaultTableModel(null, new Object[]{"Package_id", "pickup_customer_id","delivery_customer_id","driver_id","order_time","est_price"}));
	//	DefaultTableModel model = new DefaultTableModel(data,columnNames);
		
		 tblModel = (DefaultTableModel) tblList.getModel();
		
	
		
	//	model.addRow(new Object[]{"Column 1", "Column 2"});
		
		tblList = new JTable(tblModel){
		  public boolean isCellEditable(int rowIndex, int colIndex) {
		  return false; //Disallow the editing of any cell
		  }
		  };
			tblList.setBorder(new LineBorder(new Color(0, 0, 0)));
			tblList.setBounds(55, 314, 496, 316);
			
			
		//	tblList.getColumnModel().getColumn(1).setMaxWidth(0);
		//	tblList.getColumnModel().getColumn(1).setMinWidth(0);
		//	tblList.getColumnModel().getColumn(1).setPreferredWidth(0);
			
		//DefaultTableModel tableModel = new DefaultTableModel() {

		 //   @Override
		  //  public boolean isCellEditable(int row, int column) {
		       //all cells false
		 //      return false;
		 //   }
	//	};

	//	tblList.setModel(tableModel);
		//tblList.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//tblList.setFillsViewportHeight(true);
		

	
		//JScrollPane scrollPane = new JScrollPane(tblList);
		//add(scrollPane);
		
		
		//add(tblList);
		
		JScrollPane scrollPane = new JScrollPane(tblList);
		scrollPane.setPreferredSize(new Dimension(552, 150));
	//	scrollPane.setBounds(55, 314, 496, 116);
		//add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 263, 623, 359);
		panel_1.add(scrollPane);
		
		add(panel_1);
		
		Component[] com = panelinfo.getComponents();  
		//Inside you action event where you want to disable everything  
		//Do the following  
		for (int a = 0; a < com.length; a++) {  
		     com[a].setEnabled(false);  
		}  
		
		
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
		
		defautview();
		 //displayList1();
		 
		btnAdd.addMouseListener(new MouseAdapter() {
		
		
			public void mouseClicked(MouseEvent arg0) {
				
				if(btnAdd.getText().equalsIgnoreCase("Print")){
				
				btnAdd.setText("Save");
				btnEdit.setText("Cancel");
				btnDelete.setEnabled(false);
				btnExit.setEnabled(false);
				txtSearch.setEnabled(false);
				tblList.setEnabled(false);
				addedit = "Add";
				Component[] com = panelinfo.getComponents();  
				//Inside you action event where you want to disable everything  
				//Do the following  
				for (int a = 0; a < com.length; a++) {  
				     com[a].setEnabled(true);  
				}  
				clear();
				txtName.requestFocus();
				}else{
				
				int a =	JOptionPane.showConfirmDialog(null, "Do you want to save this record?", "Message",  JOptionPane.YES_NO_OPTION);
				
				if(a==0){
				
					//try{
						try {
							st=cn.createStatement();
					//String role;
							//if( cboGender.getSelectedIndex() == 1 ){
								//role = "Order-Taker";
							//}else{
								//role = "Manager";
							//}
				
							if (addedit.equals("Add")){
							//ps=cn.prepareStatement("INSERT INTO cusinfo(Customer_id,address,contact_number,email) values('" + txtName.getText() + "','" + txtAddress.getText() +  "','" + txtPhone.getText() + "','" + txtEmail.getText() + "','" + txtCusName.getText() + "')");
							}else{
								//ps=cn.prepareStatement("UPDATE cusinfo set customer_name='" + txtName.getText() + "',address ='" + txtAddress.getText() +  "',contact_number ='" + txtPhone.getText() + "',email='"+txtEmail.getText()+"',custperson='"+txtCusName.getText()+"' where Customer_id ='" + txtSearch.getText() + "'");	
							}
							ps.executeUpdate();
			
						// while(rs.next()){
						// 	strUser=rs.getString(1);
					//	 	strPass=rs.getString(2);
				//	}
					
					
					//JOptionPane.showMessageDialog(null,"save",null, JOptionPane.INFORMATION_MESSAGE, null);	
					defautview();
					displayList();
					
					
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
					
				
				}
				
				
			}
		});
		
		
		 tblList.addMouseListener(new MouseAdapter() {
			 
			 	public void mouseClicked(MouseEvent arg0) {
			 		int selectedRowIndex = tblList.getSelectedRow();
			 		//int selectedColumnIndex = tblList.getSelectedColumn();
			 		String selectedObject = (String) tblList.getModel().getValueAt(selectedRowIndex, 0);
			 		
			 	txtSearch.setText(selectedObject);
			 	//search();

			 	}
			 });
		
		
		 btnEdit.addMouseListener(new MouseAdapter() {
			 
			 	public void mouseClicked(MouseEvent arg0) {
			 		if(btnEdit.getText().equalsIgnoreCase("Edit")){
						
						btnAdd.setText("Save");
						btnEdit.setText("Cancel");
						btnDelete.setEnabled(false);
						btnExit.setEnabled(false);
						txtSearch.setEnabled(false);
						tblList.setEnabled(false);
						addedit = "Edit";
						Component[] com = panelinfo.getComponents();  
						//Inside you action event where you want to disable everything  
						//Do the following  
						for (int a = 0; a < com.length; a++) {  
						     com[a].setEnabled(true);  
						}  
					
						txtName.requestFocus();
						}else{
							 defautview();
						}
			 	}
			 });
		 
		 
		// btnsearch.addMouseListener(new MouseAdapter() {
			
				//public void mouseClicked(MouseEvent e) {
					
				//	search();
				//}
			//});
		 
		 btnDelete.addMouseListener(new MouseAdapter() {
		
				public void mouseClicked(MouseEvent e) {
					int a =	JOptionPane.showConfirmDialog(null, "Do you want to delete this record?", "Message",  JOptionPane.YES_NO_OPTION);
					
					if(a==0){
					
					try {
						st = cn.createStatement();
						
						
						ps = cn.prepareStatement("delete from cusinfo where customer_id ='" + txtSearch.getText() + "'");
						ps.executeUpdate();
						displayList();
						clear();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					
				}
			});
		 
		 btnExit.addMouseListener(new MouseAdapter() {
			 
			 	public void mouseClicked(MouseEvent e) {
			 		//System.exit(0);
			 		System.out.println("dates from exit :"+ txtName.getText()+" "+txtPhone.getText());
			 		displayList1();
			 	}
			 });
		
	}
	

	

	

void defautview(){
	btnAdd.setText("Add");
	btnAdd.setVisible(false);
	btnEdit.setVisible(false);
	btnDelete.setVisible(false);
	btnEdit.setText("Edit");
	btnDelete.setEnabled(true);
	btnExit.setText("Print");
	btnExit.setEnabled(true);
	txtSearch.setEnabled(true);
	tblList.setEnabled(true);
	Component[] com = panelinfo.getComponents();  
	//Inside you action event where you want to disable everything  
	//Do the following  
	for (int a = 0; a < com.length; a++) {  
	     com[a].setEnabled(true);  
	}  
	clear();
}
void clear(){
	txtName.setText("");
            txtPhone.setText("");
	//cboGender.setSelectedIndex(0);
	
}
	void displayList1(){
		try {
			st = cn.createStatement();
//			 query = "select Package_Id,pickup_customer_id,delivery_customer_id,order_date from Delivery_info where order_date between '"
//					+textField.getText()+"' and '"+textField_1.getText()+"'";
			 String query = "select Package_Id,pickup_customer_id,delivery_customer_id,driver_id,order_date,est_price from delivery_info where order_date between '"+ txtName.getText()+"' and '"+txtPhone.getText()+"'";
			System.out.println("dates from display:"+txtName.getText()+", "+txtPhone.getText());
			ResultSet rs = st.executeQuery(query);
			tblModel.getDataVector().removeAllElements();
			while(rs.next()){
				System.out.println("in next");
				tblModel.addRow(new Object[]{rs.getString("Package_Id"),rs.getString("pickup_customer_id"),rs.getString("delivery_customer_id"),rs.getInt("driver_id"),rs.getDate("order_date"),rs.getString("est_price")});
			}
			System.out.println("the count:"+tblModel.getRowCount());
			System.out.println("the data from table"+tblModel.getValueAt(0, 0));
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
	void displayList(){
		try {
			st = cn.createStatement();
			
			ResultSet rs = st.executeQuery("select * from cusinfo");
			tblModel.getDataVector().removeAllElements();
			while(rs.next()){
				
				tblModel.addRow(new Object[]{rs.getString("customer_id"),rs.getString("customer_name"),rs.getString("address"),rs.getString("contact_number"),rs.getString("email")});
			}
			
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
}
	