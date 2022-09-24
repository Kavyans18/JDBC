package jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpRet {
public static void main(String[] args) {
		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbcprc";
		String user_id = "root";
		String password = "root";
		String query = "SELECT * FROM EMP where floor = '6th'";
	try {
		Class.forName(path);
		Connection connection = DriverManager.getConnection(url, user_id, password);
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
		System.out.println(result.getInt(1));
		System.out.println(result.getString(2));
		System.out.println(result.getLong(3));
		System.out.println(result.getString(4));
		System.out.println(result.getString(5));
		System.out.println(result.getString(6));
		System.out.println(result.getString(7));
		System.out.println(result.getString(8));
		}
		statement.close();
		connection.close();
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
}
}
