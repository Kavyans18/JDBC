package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileDAO {
	
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";

	public Mobile saveMobile(Mobile m){
		String query = "INSERT INTO mobile VALUES(?, ?, ?, ?, ?, ?, ?)";
			//load and register driver
			try {
				Class.forName(path);
				//Establish connection
				connection = DriverManager.getConnection(url , username, password);
				//Creating Statement
				PreparedStatement preparestatement = connection.prepareStatement(query);
				preparestatement.setInt(1, m.getId());
				preparestatement.setString(2, m.getName());
				preparestatement.setString(3, m.getBrand());
				preparestatement.setString(4, m.getColour());
				preparestatement.setDouble(5, m.getPrice());
				preparestatement.setString(6, m.getRam());
				preparestatement.setString(7, m.getManufacturer());
				int result = preparestatement.executeUpdate();
				preparestatement.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return m;
	}
	public Mobile updateMobile(Mobile m) {
	String query  = "UPDATE person SET name = ?, brand = ? , colour = ?, price = ?, ram = ?, manufacturer = ? where id = ?";
	try {
		Class.forName(path);
		connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		preparedstatement.setInt(7, m.getId());
		preparedstatement.setString(1, m.getName());
		preparedstatement.setString(2, m.getBrand());
		preparedstatement.setString(3, m.getColour());
		preparedstatement.setLong(4, (long) m.getPrice());
		preparedstatement.setString(5, m.getRam());
		preparedstatement.setString(6, m.getManufacturer());
		int result = preparedstatement.executeUpdate();
		if (result ==1) {
			System.out.println("Details updated");
			return m;
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	System.out.println("Details not updated");
	return m;
}
	public Mobile getPerson (int id) {
		String query = "SELECT * FROM mobile WHERE id = ? ";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet != null) {
				Mobile mobile = new Mobile();
				while (resultSet.next()) {
					mobile.setId(resultSet.getInt(1));
					mobile.setName(resultSet.getString(2));
					mobile.setBrand(resultSet.getString(3));
					mobile.setColour(resultSet.getString(4));
					mobile.setPrice(resultSet.getLong(5));
					mobile.setRam(resultSet.getString(6));
					mobile.setManufacturer(resultSet.getString(7));
				}
				return mobile;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String deleteMobile(int id) {
		String query = "DELETE FROM mobile WHERE id = ?";
		try {
			//Load and register connection
			Class.forName(path);
			//Establishing connection
			connection = DriverManager.getConnection(url, username, password);
			//Creating statement
			PreparedStatement preparedstatement = connection.prepareStatement(query);
				preparedstatement.setInt(01, id);
				int result = preparedstatement.executeUpdate();
				if (result == 1) {
					return "Deleted";
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection == null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "Not deleted";
	}
}
