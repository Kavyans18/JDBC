package com.ty.controller;
import com.ty.dao.CartDAO;
import com.ty.dto.Cart;


public class UpdateCart {
	public static void main(String[] args) {
		CartDAO dao = new CartDAO();
		Cart c = new Cart(01, "user@111", "111", "user", "Delhi");
		dao.updateCart(c);
	}
}
