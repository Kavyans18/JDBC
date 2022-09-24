package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;


public class TestSaveStudent {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root","root" );
			CallableStatement cb = con.prepareCall("call save_student(?, ?, ?, ?, ? )");
			cb.setInt(1,30);
			cb.setString(2, "Ramesh");
			cb.setString(3, "985730948");
			cb.setString(4, "Blr");
			cb.setString(5, "9809");
			
			cb.execute();
			System.out.println("Data Saved");
			// closed
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
