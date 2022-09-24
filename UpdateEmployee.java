package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		//3. Create Statement
		Statement statement = connection.createStatement();
		//4. Process Result/ execute query
		statement.execute("UPDATE emp SET name = 'radha' where name = 'Bheem'");
		//5. close
		connection.close();
	}
}
