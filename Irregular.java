/** The class Irregular is a subclass of Product.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Irregular extends Product {
	/* Constructor */
	
	/* Irregular is a type of Product, however it is still an item type */
	
	/** This constructor receives the name of the item, and the length, width, height and weight
	 *  of the item.
	 *  
	 *  @param name String name of item
	 *  @param length double var of length
	 *  @param width double var of width
	 *  @param height double var of height
	 *  @param weight double var of weight
	 */
	
	public Irregular(String name, double length, double width, double height, double weight) {
		super(name, length, width, height, weight);
	}
}
