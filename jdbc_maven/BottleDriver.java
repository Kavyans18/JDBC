package jdbc_maven;

import java.util.ArrayList;
import java.util.List;

public class BottleDriver {
	public static void main(String[] args) {
		Bottle b = new Bottle(1, "Blue");
		Bottle b1 = new Bottle(2, "Orange");
		Bottle b2 = new Bottle(3, "Red");
		BottleDAO dao = new BottleDAO();
		List<Bottle> list = new ArrayList();
		
		 //Calling insert method
		Bottle br = dao.insertBottle(b2);
		//System.out.println(br);
		
		//Calling get method
		list = dao.getAllBottle();
		System.out.println(list);
		
	}
}
