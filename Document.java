/** The class Document is a subclass of Item.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Document extends Item
{
	/* Constructor */
	
	/** This constructor receives the name of the document, the
	 *  length and width of the document and the number of pages.
	 *  
	 *  @param name a String name
	 *  @param length a number with or without decimals on the length of the document
	 *  @param width a number with or without decimals on the width of the document
	 *  @param nPages a whole number on the number of pages
	 * 
	 */
	
	public Document (String name, double length, double width, int nPages)
	{
		super(name, length, width);
		
		double dPages;
		this.nPages = nPages;
		dPages = this.nPages;
		
		this.dWeight = Math.ceil(200 * (dPages / 25));   /* Calculating the weight */
		this.dHeight = Math.ceil(1 * (dPages/25));       /* Calculating the thickness */
	}
	
	/* Methods */
	
    /** This method returns the number of pages in the Document object.
     * 
     *  @return the number of pages in the Document object
     */
	
	public int getPages ()
	{
		return nPages;
	}
	
	/* Attributes */
	
	private int nPages;  /* Integer value holding the number of pages of the Document object */
}
