package com.ty.controller;
import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class InsertCart {
	
	public static void main(String[] args) {
		CartDAO dao = new CartDAO();
		Cart c = new Cart();
		Cart c1 = new Cart(01, "abcd@123", "1234", "abcd", "Blr");
		dao.insertCart(c1);
	}
}
