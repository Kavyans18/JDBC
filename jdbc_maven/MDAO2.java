package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MDAO2 {
	public static void main(String[] args) {
		List<Mobile> list = new ArrayList<Mobile>();
		Mobile m = new Mobile(10, "Nord", "One Plus", "Black", 25000, "128gb", "One Plus");
		Mobile m1 = new Mobile(12, "Galaxy Fold", "Samsung","Blue", 130000, "267gb", "Samsung" );
		list.add(m);
		list.add(m1);
		System.out.println(list);
	
		
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	String query = "INSERT INTO mobile VALUES(?, ?, ?, ?, ?, ?, ?)";
			//load and register driver
			try {
				Class.forName(path);
				//Establish connection
				connection = DriverManager.getConnection(url , username, password);
				//Creating Statement
				PreparedStatement preparestatement = connection.prepareStatement(query);
				for (Mobile mob : list) {
				preparestatement.setInt(1, mob.getId());
				preparestatement.setString(2, mob.getName());
				preparestatement.setString(3, mob.getBrand());
				preparestatement.setString(4, mob.getColour());
				preparestatement.setDouble(5, mob.getPrice());
				preparestatement.setString(6, mob.getRam());
				preparestatement.setString(7, mob.getManufacturer());
				
				preparestatement.addBatch();
				}
				preparestatement.executeBatch();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
