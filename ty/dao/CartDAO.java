package com.ty.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.dto.Cart;

public class CartDAO {
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/jdbcprc";
	String user = "root";
	String password = "root";
	Connection connection = null;
	
	public Cart insertCart(Cart c) {
		String query = "INSERT INTO cart VALUES(?, ?, ?, ?, ?)";
		//Load and register Driver
		try {
			Class.forName(path);
			//Establish connection
			connection= DriverManager.getConnection(url, user, password) ;
			//Create Statement
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,c.getId());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getAddress());
			int result = ps.executeUpdate();
			System.out.println("Data Saved");
				return c;
			
			//
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	public Cart updateCart(Cart c) {
		String query ="UPDATE cart SET email = ?, password = ?, username = ?, address = ? WHERE id = ?";
		//Load and register Driver
		try {
			Class.forName(path);
			//Establish connection
			connection= DriverManager.getConnection(url, user, password) ;
			//Create Statement
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(5,c.getId());
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getUsername());
			ps.setString(4, c.getAddress());
			int result = ps.executeUpdate();
			System.out.println("Data Updated");
		}
			 catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return c;
		}
	
	public Cart getCart(int id) {
		String query = "SELECT * FROM cart WHERE id = ?";
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(ps != null) {
				Cart c = new Cart();
				while(rs.next()) {
					c.setId(rs.getInt(1));
					c.setEmail(rs.getString(2));
					c.setPassword(rs.getString(3));
					c.setUsername(rs.getString(4));
					c.setAddress(rs.getString(5));
					return c;
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
		
	}
	
	public Cart deleteCart(int id) {
		
		return null;
		
	}
		}