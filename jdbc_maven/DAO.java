package jdbc_maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	private static final ResultSet resultset = null;
	String path = "com.mysql.cj.jdbc.Driver";
	Connection connection = null;
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String username = "root";
	String password = "root";
	
	public String savePerson(Person p) {
		String query = "INSERT INTO person VALUES(?, ?, ?, ?, ?)";
		try { 
			//load and register driver
			Class.forName(path);
			//Establish connection
			connection = DriverManager.getConnection(url , username, password);
			//Creating Statement
			PreparedStatement preparestatement = connection.prepareStatement(query);
			preparestatement.setInt(1, p.getId());
			preparestatement.setString(2, p.getName());
			preparestatement.setString(3, p.getAddress());
			preparestatement.setLong(4,p.getPhone());
			preparestatement.setInt(5, p.getPincode());
			int result = preparestatement.executeUpdate();
			if(result == 1) {
				return "Saved";
			}
		}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			 finally {
				// if(connection != null) {
					 try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				// }
			 }
			return "Not saved";
		}
	public String deletePerson(int id) {
		String query = "DELETE FROM person WHERE id = ?";
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
	public String updatePerson(Person p) {
		String query  = "UPDATE person SET name = ?, address = ? , phone = ?, pincode = ? where id = ?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(5, p.getId());
			preparedstatement.setString(1, p.getName());
			preparedstatement.setString(2, p.getAddress());
			preparedstatement.setLong(3, p.getPhone());
			preparedstatement.setInt(4, p.getPincode());
			int result = preparedstatement.executeUpdate();
			if (result ==1) {
				return "Updated";
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
		
		return "Not updated";
	}
	public Person getPerson (int id) {
		String query = "SELECT * FROM person WHERE id = ? ";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, username, password);
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet != null) {
				Person person = new Person();
				while (resultSet.next()) {
					person.setId(resultSet.getInt(1));
					person.setName(resultSet.getString(2));
					person.setAddress(resultSet.getString(3));
					person.setPhone(resultSet.getLong(4));
					person.setPincode(resultSet.getInt(5));
				}
				return person;
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
}
		

