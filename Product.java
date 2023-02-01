/** The class Product is a subclass of Item.
 * 
 * 	@author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Product extends Item
{
	/* Constructor */
	
	/** This constructor receives the name of the product and the length, width, height and weight
	 *  of the product.
	 * 
	 * 	@param name a String name of the product
	 *  @param length a double value of the length of the product
	 *  @param width a double value of the width of the product
	 *  @param height a double value of the height of the product
	 *  @param weight a double weight of the product
	 */
	
	public Product(String name, double length, double width, double height, double weight)
	{
		super(name, length, width);
		this.dHeight = height;
		this.dWeight = weight;
	}
}
