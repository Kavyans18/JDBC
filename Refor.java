package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class Refor {
	public static void main(String[] args) {
		try {
			com.mysql.cj.jdbc.Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getLong(3));
				System.out.println(resultSet.getString(4));
				System.out.println(resultSet.getString(5));
				System.out.println("==========================");
			}
			statement.close();
			connection.close();
		}
		/*catch(ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
