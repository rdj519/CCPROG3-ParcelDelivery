
public class Product extends Item {

	public Product(String name, double length, double width, double height, double weight) {
		super(name, length, width);
		this.dHeight = height;
		this.dWeight = weight;
	}

}
