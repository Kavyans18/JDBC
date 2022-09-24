package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Establish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc" , "root", "root");
		//3. Create the statement
		Statement statement = connection.createStatement();
		//4. Execute the statement
		statement.execute("INSERT INTO student VALUES(1, 'Ram', 9880290466 , 'Ayodhya', 100000)");
		statement.execute("INSERT INTO student VALUES(2, 'Sita', 984560466, 'Mithila', 200000)");
		statement.execute("INSERT INTO student VALUES(3, 'Lakshman', 7657989954, 'Ayodhya', 300000)");
		statement.execute("INSERT INTO student VALUES(4, 'Ravan', 7879853998, 'Lanka', 400000)");
		statement.execute("INSERT INTO student VALUES(5, 'Shurpanaki', 6484963467, 'Lanka', 500000)");
		//5.close
		connection.close();
		System.out.println("Saved");
	}
}
