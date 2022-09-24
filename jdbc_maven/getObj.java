package jdbc_maven;

import java.util.Scanner;

public class getObj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO ();
		System.out.println("Enter the id to be displayed");
		Person pe = dao.getPerson(3);
		System.out.println(pe.getId());
		System.out.println(pe.getName());
		System.out.println(pe.getAddress());
		System.out.println(pe.getPhone());
		System.out.println(pe.getPincode());
	}
}
