package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Establist Connecton
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		//3. Create Statement
		Statement statement = connection.createStatement();
		//4. Process Result/ Execute query(Update entry)
		statement.execute("UPDATE student SET name = 'Pavan', address = 'Anjani' where id = 4");
		//5. Close
		connection.close();
		System.out.println("Updated");
	}
}
