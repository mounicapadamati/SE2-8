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

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.DefaultTableModel;

public class CourierInfo extends JPanel {

	private JFrame frame;
	private Connection cn;
	private Statement st;
	private	PreparedStatement ps;
 	private String addedit;
 	private JTextField txtAddress;
    private JTextField txtEmail;
 	private JTextField txtName;
 	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnExit;
	private Panel panelinfo;
	private String pname;
	private Panel panel;
	private JTextField txtSearch;
	private DefaultTableModel tblModel;
	JTable tblList;
	/**
	 * Create the panel.
	 */
	public CourierInfo(JFrame f) {
		this.frame =  f;
		init();
	}
	
	private void init(){
		
		 btnAdd = new JButton("Add");
			
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
			panelinfo.setBounds(10, 76,  329, 135);
			add(panelinfo);
			panelinfo.setLayout(null);
			
			txtAddress = new JTextField();
			txtAddress.setColumns(10);
			txtAddress.setBounds(93, 59, 206, 20);
			panelinfo.add(txtAddress);
	                
	                txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(93, 90, 206, 20);
			panelinfo.add(txtEmail);
			
			txtName = new JTextField();
			txtName.setColumns(10);
			txtName.setBounds(93, 28, 206, 20);
			panelinfo.add(txtName);
			
			JLabel label = new JLabel("Name :");
			label.setBounds(10, 34, 46, 14);
			panelinfo.add(label);
			
			JLabel label_2 = new JLabel("Phone No :");
			label_2.setBounds(10, 59, 73, 14);
			panelinfo.add(label_2);
			
	                JLabel label_3 = new JLabel("Email ID :");
			label_3.setBounds(10, 94, 73, 14);
			panelinfo.add(label_3);
	                
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
			
			
			String[] columnNames = {"Name",
	                "Role",
	                "Phone No","Email ID"
	                };


	 
	        
		//	tblList = new JTable();
		//	tblList.setBorder(new LineBorder(new Color(0, 0, 0)));
			//tblList.setBounds(55, 314, 496, 116);
			//tblList.setEnabled(false);
			 tblList = new JTable(new DefaultTableModel(null, new Object[]{"Name", "Role","Phone No","Email ID"}));
		//	DefaultTableModel model = new DefaultTableModel(data,columnNames);
			
			 tblModel = (DefaultTableModel) tblList.getModel();
			
		
			
		//	model.addRow(new Object[]{"Column 1", "Column 2"});
			
			tblList = new JTable(tblModel){
			  public boolean isCellEditable(int rowIndex, int colIndex) {
			  return false; //Disallow the editing of any cell
			  }
			  };
				tblList.setBorder(new LineBorder(new Color(0, 0, 0)));
				tblList.setBounds(55, 314, 496, 116);
				
				
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
			scrollPane.setPreferredSize(new Dimension(452, 150));
		//	scrollPane.setBounds(55, 314, 496, 116);
			//add(scrollPane);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(49, 263, 523, 159);
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
			
			 displayList();
			 
			btnAdd.addMouseListener(new MouseAdapter() {
			
			
				public void mouseClicked(MouseEvent arg0) {
					
					if(btnAdd.getText().equalsIgnoreCase("Add")){
					
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
						
					
								if (addedit.equals("Add")){
								ps=cn.prepareStatement("INSERT INTO driver_info values('" + txtName.getText() + "','" + txtAddress.getText() + "','" + txtEmail.getText() + "')");
								}else{
									ps=cn.prepareStatement("UPDATE driverinfo set driver_name='" + txtName.getText() + "',contact ='" + txtAddress.getText() + "',email='"+txtEmail.getText()+"' where driver_name ='" + txtSearch.getText() + "'");	
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
				 	search();

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
							
							
							ps = cn.prepareStatement("delete from driverinfo where driver_name ='" + txtSearch.getText() + "'");
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
				 		System.exit(0);
				 	}
				 });
			
		}
		
		void clear(){
			txtName.setText("");
			txtAddress.setText("");
	                txtEmail.setText("");
			
		}
		
		void defautview(){
			btnAdd.setText("Add");
			btnEdit.setText("Edit");
			btnDelete.setEnabled(true);
			btnExit.setEnabled(true);
			txtSearch.setEnabled(true);
			tblList.setEnabled(true);
			Component[] com = panelinfo.getComponents();  
			//Inside you action event where you want to disable everything  
			//Do the following  
			for (int a = 0; a < com.length; a++) {  
			     com[a].setEnabled(false);  
			}  
			clear();
		}
		
		void displayList(){
			try {
				st = cn.createStatement();
				
				ResultSet rs = st.executeQuery("select * from driverinfo");
				tblModel.getDataVector().removeAllElements();
				while(rs.next()){
					
					tblModel.addRow(new Object[]{rs.getString("driver_name"),rs.getString("contact"),rs.getString("email")});
				}
				
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		
		void search(){
			try {
				st = cn.createStatement();

			 ResultSet rs=st.executeQuery("SELECT * FROM driverinfo WHERE driver_name='"+ txtSearch.getText() + "'");
			 
			// while(rs.next()){
			 	//strUser=rs.getString(1);
			 	//strPass=rs.getString(2);
				if(rs.next()){
	txtName.setText(rs.getString("driver_name").toString());
	


	txtAddress.setText(rs.getString("contact").toString());
	txtEmail.setText(rs.getString("email").toString());
		}else{

			JOptionPane.showMessageDialog(null,"Not Found",null, JOptionPane.INFORMATION_MESSAGE, null);	
		}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	//frame.
}
