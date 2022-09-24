package jdbc_maven;

import java.util.Scanner;

public class MobileDriver {
public static void main(String[] args) {
	MobileDAO dao = new MobileDAO();
	Mobile m = new Mobile();
	
	m.setId(1);
	m.setName("iphone");
	m.setBrand("Apple");
	m.setColour("pink");
	m.setPrice(69900);
	m.setRam("260gb");
	m.setManufacturer("Apple");
	System.out.println(m);
	dao.saveMobile(m);
	System.out.println("Saved");
	
}
}
