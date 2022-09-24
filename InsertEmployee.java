package jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//1.Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. Establish Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprc", "root", "root");
		//3. Create Statement
		Statement statement = connection.createStatement();
		//4. Process Result/ execute query
		// Insert
		statement.execute("INSERT INTO emp VALUES(1, 'Krishna', 1097687478, 'President', 'Bangalore', ' ', '7th', 'Delta')");
		statement.execute("INSERT INTO emp VALUES(2, 'Balaram', 768397458, 'Vise President', 'Bangalore', 'President', '6th', 'Delta')");
		statement.execute("INSERT INTO emp VALUES(3, 'Arjun', 0987074823, 'Manager', 'Hyderabad', 'Vise President', '3rd', 'Alpha')");
		statement.execute("INSERT INTO emp VALUES(4, 'Bheem', 787654678, 'Developer', 'Pune', 'Manager', '5th', 'Bravo')");
		statement.execute("INSERT INTO emp VALUES(5, 'Radha', 7684636978, 'Tester', 'Bangalore', 'Manager', '8th', 'Bravo')");
		
		//statement.execute("UPDATE FROM emp where id = 5");
		//5. close
		connection.close();
	}
}
