package jdbc_maven;

public class Bottle {
private int id ;
private String colour;
Bottle() {
}
Bottle(int id, String colour) {
	this.id = id;
	this.colour = colour;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
@Override
public String toString() {
	return "Bottle [id=" + id + ", colour=" + colour + "]";
}

}
