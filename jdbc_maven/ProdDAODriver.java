package jdbc_maven;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdDAODriver {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();
		Product p1 = new Product(1, "Mobile", 50000, "Samsung", "20%", "5 years", "20/9/2022", "12%");
		Product p2 = new Product(2, "Java",200000, "Sun microsystems","20%",  "100 years", "12/4/2000", "20%" );
		Product p3 = new Product(3, "Laptop", 80000, "hp", "10%", "2 years", "18/4/2020", "18%");
		//list.add(p1);
		//list.add(p2);
		//list.add(p3);
		int c = 2;
		ProductDAO pd = new ProductDAO();
		Product p = new Product();
		//pd.insertProduct(p3);
		//Product p4 = new Product(2, "AC", 20000, "Blue Star", "10%", "1 years", "21/1/2022", "21%");
		//pd.updateProduct(p4);
		pd.getProduct(2);
		//pd.deleteProduct(2);
		
	}
	
}
