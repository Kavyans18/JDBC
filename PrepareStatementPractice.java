package jdbcpractice;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrepareStatementPractice {
	public static void main(String[] args) throws IOException {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name: ");
			String name = sc.nextLine();
			System.out.println("Enter the manufacturer: ");
			String manufacturer = sc.nextLine();
			System.out.println("Enter the milage: ");
			String milage = sc.nextLine();
			System.out.println("Enter the address: ");
			String address = sc.nextLine();
			System.out.println("Enter the model: ");
			String model = sc.nextLine();
		try {
			// Importing javaProperties file
			Properties properties = new Properties();
			InputStream inputstream = new FileInputStream("jdbcProperties.properties");
			//1. Loading and Registering
			properties.load(inputstream);
			Class.forName(properties.getProperty("path"));
			//2. Establishing connection
			Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
			//3. Creating statement
			//Statement statement = connection.createStatement();
			String query = "INSERT INTO bike VALUES(? , ? , ? , ? , ? , ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			//4.Execute Statement
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, manufacturer);
			ps.setString(4, milage);
			ps.setString(5, address);
			ps.setString(6, model);
			ps.execute();
			connection.close();
			System.out.println("Data Saved");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	}