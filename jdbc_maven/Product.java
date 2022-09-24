package jdbc_maven;

public class Product {
 private int id;
 private String name;
 private double price;
 private String manufacturer;
 private String discount;
 private String warrenty;
 private String dom;
 private String gst;
 Product() {
 }
 Product(int id, String name, double price, String manufacturer, String discount, String warrenty, String dom, String gst) {
	 this.id = id;
	 this.name = name;
	 this.price = price;
	 this.manufacturer = manufacturer;
	 this.discount = discount;
	 this.warrenty = warrenty;
	 this.dom = dom;
	 this.gst = gst;
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
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public String getWarrenty() {
	return warrenty;
}
public void setWarrenty(String warrenty) {
	this.warrenty = warrenty;
}
public String getDom() {
	return dom;
}
public void setDom(String dom) {
	this.dom = dom;
}
public String getGst() {
	return gst;
}
public void setGst(String gst) {
	this.gst = gst;
}
 
}
