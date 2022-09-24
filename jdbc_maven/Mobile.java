package jdbc_maven;

public class Mobile {
	private int id;
	private String name;
	private String brand;
	private String colour;
	private double price;
	private String ram;
	private String manufacturer;
	Mobile() {
	}
	Mobile(int id, String name, String brand, String colour, double price, String ram, String manufacturer) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.colour = colour;
		this.price = price;
		this.ram = ram;
		this.manufacturer = manufacturer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", brand=" + brand + ", colour=" + colour + ", price=" + price
				+ ", ram=" + ram + ", manufacturer=" + manufacturer + "]";
	}
	
	
}
