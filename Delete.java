package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//1.Load and register Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	//2. Establish the connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
	//3.create statement
	Statement statement =  connection.createStatement();
	//4.Delete entry
	statement.execute("DELETE FROM student WHERE id = 05");
	//5. close
	connection.close();
	System.out.println("Deleted");
}
}
