package com.ty.controller;

import com.ty.dao.*;
import com.ty.dto.*;


public class GetCart {
	public static void main(String[] args) {
		CartDAO dao = new CartDAO();
		Cart c = new Cart();
		Cart cr = dao.getCart(1);
		System.out.println(cr.getId());
		System.out.println(cr.getEmail());
		System.out.println(cr.getPassword());
		System.out.println(cr.getUsername());
		System.out.println(cr.getAddress());
	}
}
