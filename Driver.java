package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Load and Register
		Class.forName("com.mysql.jdbc.Driver");
		//2. Establishing connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		System.out.println(connection);
		//3. creating the statement
		Statement statement = connection.createStatement();
		//4.execute the statement
		statement.execute("INSERT INTO emp VALUES(1, 'vinod')");
		//5. close
		connection.close();
		System.out.println("Saved");
	}
}
