/** The class Box is a subclass of Parcel.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Box extends Parcel
{
	/* Constructor */
	
	/** This constructor receives the number of items, the intended
	 *  region of the parcel and the recipient of the parcel. Also,
	 *  depending on the size of the box parcel, there are several
	 *  variables that will be initialized in the Box object.
	 *  
	 *  @param nItems a whole number on the number of items in a box parcel
	 *  @param region a String variable on the location of the parcel
	 *  @param recipient a String variable on the name of the recipient
	 */
	
	public Box(int nItems, String region, String recipient) 
	{
		super(nItems, region, recipient);
		
	}
	
	/* Methods */
	
	/** This method sets the size of the box parcel depending on the size availability.
	 * 
	 *  @param size a String variable on the size of the box that was chosen
	 */
	
	public boolean setSize(String size)
	{
		boolean bValid = false;
		if(size.equalsIgnoreCase("small"))          /* Note: 12x10x5 */
		{
			this.dLength = 12;
			this.dWidth= 10;
			this.dHeight = 5;
			bValid = true;
		}
		else if(size.equalsIgnoreCase("medium"))     /* Note: 14x11x7 */
		{
				this.dLength = 14;
				this.dWidth = 11;
				this.dHeight = 7;
				bValid = true;
		}
		else if(size.equalsIgnoreCase("large"))       /* Note: 18x12x9 */
		{
				this.dLength = 18;
				this.dWidth = 12;
				this.dHeight = 9;
				bValid = true;
		}
		else if(size.equalsIgnoreCase("enormous"))	   /* Note: 20x16x12 */
		{
			this.dLength = 20;
			this.dWidth = 16;
			this.dHeight = 12;
			bValid = true;
		}
		if(bValid)
		{
			int nLength = (int) dLength;
			int nWidth = (int) dWidth;
			int nHeight = (int) dHeight;
			int i, j, k;
			this.size = new int[nLength][nWidth][nHeight];
			for(i=0; i < nLength; i++)
				for(j=0; j < nWidth; j++)
					for(k=0; k < nHeight; k++)
						this.size[i][j][k] = 0;         /* Sets to empty box */
		}
		return bValid;
	}
	
	/** This method returns the size of the box.
	 * 
	 *  @return String variable of the size of the box
	 */
	
	public String getSize()
	{
		String strSize ="";
		if(this.dLength == 12)
			strSize = "Small";
		else if(this.dLength == 14)
			strSize = "Medium";
		else if(this.dLength == 18)
			strSize = "Large";
		else if(this.dLength == 20)
			strSize = "Enormous";
		return strSize;
	}
}