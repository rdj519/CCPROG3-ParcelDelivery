 
public class Document extends Item{
	public Document(String name, double length, double width, int nPages)
	{
		super(name, length, width);
		this.nPages = nPages;	 
		this.dWeight = Math.ceil(200 * (nPages / 25));
		this.dHeight = Math.ceil(1 * (nPages/25));
	}
	
    /**This function gets the number of pages in the Document
     * 
     * @return the number of pages in the Document
     */
	public int getPages()
	{
		return nPages;
	}	
	private int nPages;
}
