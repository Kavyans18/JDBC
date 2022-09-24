package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BottleDAO {
String path = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/jdbcprc";
String user = "root";
String password = "root";
Connection con = null;
	
	public Bottle insertBottle(Bottle b) {
		String query = "INSERT INTO bottle VALUES(?, ?)";
		try {
			//Loading and registering driver
			Class.forName(path);
			
			
			//establishing connection
			con = DriverManager.getConnection(url, user, password);
			
			
			//Creating statement
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, b.getId());
			ps.setString(2, b.getColour());
			
			
			//executing query
			int result = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
	}
	public List<Bottle> getAllBottle() {
		String query = "SELECT * FROM bottle" ;
		//Loading and registering the Driver
		try {
			Class.forName(path);
			//Establilshing the connection
			con = DriverManager.getConnection(url, user, password);
			//Creating statement
			PreparedStatement pr = con.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
			List<Bottle> list = new ArrayList();
			while(rs.next()) {
				Bottle b = new Bottle();
				b.setId(rs.getInt(1));
				b.setColour(rs.getString(2));
				list.add(b);
			}
			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
