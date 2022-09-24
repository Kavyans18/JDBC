package jdbc_maven;

import java.sql.ResultSet;
import java.util.Scanner;

public class DAODriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		DAO d = new DAO();
		System.out.println("1. Save Person");
		System.out.println("2. Update Person");
		System.out.println("3. Delete Person");
		System.out.println("4. Display person");
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: System.out.println("Enter the id of the person");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the name of the person");
				String name = sc.nextLine();
				System.out.println("Enter the address: ");
				String address = sc.nextLine();
				System.out.println("Enter the phone number: ");
				Long phone = sc.nextLong();
				System.out.println("Enter the pin: ");
				int pincode = sc.nextInt();
				p.setId(id);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);
				p.setPincode(pincode);
				d.savePerson(p);
				break;
		case 2: System.out.println("Enter the id of the data to be updated : ");
				int uid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the name of the person");
				String uname = sc.nextLine();
				System.out.println("Enter the address: ");
				String uaddress = sc.nextLine();
				System.out.println("Enter the phone number: ");
				Long uphone = sc.nextLong();
				System.out.println("Enter the pin: ");
				int upincode = sc.nextInt();
				p.setName(uname);
				p.setAddress(uaddress);
				p.setPhone(uphone);
				p.setPincode(upincode);
				d.updatePerson(p);
				break;
		case 3: System.out.println("Enter the id of the data to be deleted: ");
				int did = sc.nextInt();
				d.deletePerson(did);
				break;
		case 4: System.out.println("Enter the id of the data to be displayed: ");
				int gid = sc.nextInt();
				Person pe = d.getPerson(gid);
				System.out.println(pe);
				break;
		default : System.out.println("Enter valid choice");
		}
	}
}
