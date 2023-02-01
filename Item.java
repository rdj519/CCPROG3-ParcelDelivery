/** The abstract class Item is a superclass. This will be used for other classes
 *  such as Document and the like.
 *
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public abstract class Item
{
	/* Constructor */
	
	/** This constructor receives the name of the item and the length and width
	 *  of the item.
	 * 
	 *  @param name a String that represets the name of the item
	 *  @param length a double value that represents the length of the item
	 *  @param width a double value that represents the width of the item
	 */
	
	public Item (String name, double length, double width) 
	{
		this.strName = name;
		this.dLength = length;
		this.dWidth = width;
	}
	
	/* Methods */
	
    /** This method returns the length of the item.
     * 
     *  @return the length of the Item
     */
	
	public double getLength ()
	{
		return this.dLength;
	}
	
    /** This method returns the width of the item.
     * 
     *  @return the width of the Item
     */
	
	public double getWidth ()
	{
		return this.dWidth;
	}
	
	/** This method returns the name of the item.
	 * 
	 *  @return the name of the Item
	 */
	
	public String getName ()
	{
		return this.strName;
	}
	
    /** This method returns the weight of the item.
     * 
     *  @return the weight of the Item
     */
	
	public double getWeight ()
	{
		return this.dWeight;
	}
	
    /** This method returns the height of the item.
     * 
     *  @return the height of the Item
     */
	
	public double getHeight ()
	{
		return this.dHeight;
	}
	
	/* Attributes */
	
	protected String strName;         /* String variable: name of the item */
	protected double dLength;         /* double variable: length of the item */
	protected double dWidth;          /* double variable: width of the item */
	protected double dHeight;         /* double variable: height of the item */
	protected double dWeight;         /* double variable: weight of the item */
}