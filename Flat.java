/** The class Flat is a subclass of Parcel.
 * 
 * 	@author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Flat extends Parcel
{
	/* Constructor */
	
	/** This constructor receives the number of items, the intended
	 *  region of the parcel and the recipient of the parcel. Also,
	 *  there are some variables that will be initialized depending
	 *  on the type of flat parcel that will be chosen if available
	 *  to the user.
	 *  
	 *  @param nItems a whole number on the number of items in a flat parcel
	 *  @param region a String variable on the location of the flat parcel
	 *  @param recipient a String variable on who will be given of the flat parcel
	 */
	
	public Flat(int nItems, String region, String recipient)
	{
		super(nItems, region, recipient);
		this.dMaxWeight = 3000; 
	}
	
	/* Methods */
	
	/** This method sets the size of the flat parcel. It
	 *  will return a boolean answer if the method successfully
	 *  manages to set the flat parcel.
	 *  
	 *  @param size a String variable on the size of the flat parcel
	 *  @return if method runs successfully
	 */
	
	public boolean setSize(String size)
	{
		boolean bValid = false;
		if(size.equalsIgnoreCase("small"))       /* Note: 9 x 14 x 1 */
		{
			this.dLength = 9;
			this.dWidth= 14;
			this.dHeight = 1;
			bValid = true;
		}
		else if(size.equalsIgnoreCase("large"))	  /* Note: 12 x 18 x 3 */
		{
				this.dLength = 12;
				this.dWidth = 18;
				this.dHeight = 3;
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
						this.size[i][j][k] = 0;    /* Note: Empty flat parcel */
		}
		return bValid;
	}
	
	/** This method returns the size of the flat parcel.
	 * 
	 *  @return the String size of the flat parcel
	 */
	
	public String getSize()
	{
		String strSize ="";
		if(this.dLength == 9)
			strSize = "Small";
		else if(this.dLength == 12)
			strSize = "Large";
		return strSize;
	}
	
	/** This method returns the maximum weight that the flat Parcel can hold.
	 * 
	 *  @return the maximum weight that the Parcel can hold
	 */
	public double getMaxWeight()
	{
		return this.dMaxWeight;
	}
	
	private double dMaxWeight;             /* double: Holds the information on the maximum weight of a flat parcel. */
}
