/**
 * The abstract class Item represents a simple Item object.
 *
 *
 * @author Rey Delima, Nilo Jatico
 * @version 1.00 2019/6/30
 */
abstract class Item
{
	/**This constructor initalizes the attributes of the Item object. 
	 * 
	 *@param name a String that represets the name of the item
	 *@param length a double value that represents the length of the item
	 *@param width a double value that represents the width of the item
	 */
	
	/* the user enters the item:
	 * What type of item do you want to put?
	 * 1. Simple item
	 * 2. Document
	 * 3. Product 
	 * What is the name of the item?
	 * enter: */
	public Item(String name, double length, double width) 
	{
		this.strName = name;
		this.dLength = length;
		this.dWidth = width;
	}
	
    /**This function gets the length of the Item
     * 
     * @return the length of the Item
     */
	public double getLength()
	{
		return this.dLength;
	}
	
    /**This function gets the width of the Item
     * 
     * @return the width of the Item
     */
	public double getWidth()
	{
		return this.dWidth;
	}
	
	/**This function returns the String name
	 * 
	 * @return the String representing the name
	 */
	public String getName()
	{
		return this.strName;
	}
    /**This function gets weight of the Item
     * 
     * @return the weight of the Item
     */
	public double getWeight()
	{
		return this.dWeight;
	}
	
    /**This function gets the height of the Item
     * 
     * @return the height of the Item
     */
	public double getHeight()
	{
		return this.dHeight;
	}
	
	/* attributes */
	protected String strName;
	protected double dLength;
	protected double dWidth;
	protected double dHeight;
	protected double dWeight;

}