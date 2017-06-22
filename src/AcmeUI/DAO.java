package AcmeUI;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	ResultSet rsData;
    Statement st ;
    private static Connection con =  null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sri", "mounica", "Chat@123");
        return con;
    }
}
