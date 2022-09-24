package jdbcpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;

import com.mysql.cj.jdbc.Driver;

public class LoadReg {
	public static void main(String[] args) {
		/*
		 * String url = "jdbc:mysql://localhost:3306/jdbcprc"; String user_name =
		 * "root"; String password = "root";
		 */
		String query = "SELECT * FROM emp";
		try {
			Properties properties = new Properties();
			InputStream inputstream = new FileInputStream("jdbcProperties.properties");
			// com.mysql.cj.jdbc.Driver d = new Driver();
			// DriverManager.registerDriver(d);
			properties.load(inputstream);
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			Class.forName(properties.getProperty("path"));
			System.out.println("Driver loaded");
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
			//Connection connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),properties.getProperty("jdbc.user_name"), properties.getProperty("jdbc.password"));
			/*
			 * Statement statement = connection.createStatement(); ResultSet resultSet =
			 * statement.executeQuery(query); while (resultSet.next()) {
			 * System.out.println(resultSet.getInt(1));
			 * System.out.println(resultSet.getString(2));
			 * System.out.println(resultSet.getLong(3));
			 * System.out.println(resultSet.getString(4));
			 * System.out.println(resultSet.getString(5));
			 * System.out.println("=========================="); } statement.close();
			 * connection.close();
			 */
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}