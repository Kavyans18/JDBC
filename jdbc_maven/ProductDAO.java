package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String user = "root";
	String password = "root";
	Connection connection = null;
	
	//to insert into the table 
	public Product insertProduct(Product p) {
		String query = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pr = connection.prepareStatement(query);
				pr.setInt(1, p.getId());
				pr.setString(2, p.getName());
				pr.setDouble(3, p.getPrice());
				pr.setString(4, p.getManufacturer());
				pr.setString(5, p.getDiscount());
				pr.setString(6, p.getWarrenty());
				pr.setString(7, p.getDom());
				pr.setString(8, p.getGst());
				//adding 
				//pr.addBatch();
				//Executing
			pr.executeUpdate();
			int result = pr.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return p;
		}
	}
	
	public Product updateProduct(Product p) {
		String query = "UPDATE product SET name = ?, price = ?, manufacturer = ?, discount = ?, warrenty = ?, dom = ?, gst = ? WHERE id = ?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setInt(8, p.getId());
			pr.setString(1,p.getName());
			pr.setString(2, p.getManufacturer());
			pr.setDouble(3, p.getPrice());
			pr.setString(4, p.getDiscount());
			pr.setString(5, p.getWarrenty());
			pr.setString(6, p.getDom());
			pr.setString(7, p.getGst());
			//Executing
		   pr.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return p;
		}
	}
	
	public Product deleteProduct(int pid) {
		Product p = new Product();
		String query = "DELETE FROM product WHERE ID = ?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setInt(1,p.getId());
			int pro = pr.executeUpdate();
		return p;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		}
	}
	
	public Product getProduct(int a) {
		Product p = new Product();
		String query = "SELECT * FROM product WHERE ID = ?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pr = connection.prepareStatement(query);
			pr.setInt(1,p.getId());
			ResultSet rs = pr.executeQuery();
			if (pr != null) {
				Product product = new Product();
				while(rs.next()) {
					pr.setInt(1, p.getId());
					pr.setString(2, p.getName());
					pr.setDouble(3, p.getPrice());
					pr.setString(4, p.getManufacturer());
					pr.setString(5, p.getDiscount());
					pr.setString(6, p.getWarrenty());
					pr.setString(7, p.getDom());
					pr.setString(8, p.getGst());
				}
				return product;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		return null;
		}
	}
	
}


