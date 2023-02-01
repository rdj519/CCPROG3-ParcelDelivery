
public class Flat extends Parcel {

	public Flat(int nItems, String region, String recipient) {
		super(nItems, region, recipient);
		this.dMaxWeight = 3000; 
	}
	
	public boolean setSize(String size)
	{
		boolean bValid = false;
		if(size.equalsIgnoreCase("small"))
		{
			//initialize it to 9 x 14
			this.dLength = 9;
			this.dWidth = 14;
			this.dHeight = 1;
			bValid = true;
		}
		else if(size.equalsIgnoreCase("large"))
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
						this.size[i][j][k] = 0; //empty flat pouch
		}
		return bValid;
	}
	
	public String getSize()
	{
		String strSize ="";
		if(this.dLength == 9)
			strSize = "Small";
		else if(this.dLength == 12)
			strSize = "Large";
		return strSize;
	}
	/**This function gets the maximum weight that the flat Parcel can hold
	 * 
	 *@return the maximum weight that the Parcel can hold
	 */
	public double getMaxWeight()
	{
		return this.dMaxWeight;
	}
	
	
	private double dMaxWeight;
}
