
public class Box extends Parcel {


	public Box(int nItems, String region, String recipient) 
	{
		super(nItems, region, recipient);
		
	}
	
	public boolean setSize(String size)
	{
		boolean bValid = false;
		if(size.equalsIgnoreCase("small"))
		{
			//initialize it to 9 x 14
			this.dLength = 12;
			this.dWidth= 10;
			this.dHeight = 5;
			bValid = true;
		}
		else if(size.equalsIgnoreCase("medium"))
		{
				this.dLength = 14;
				this.dWidth = 11;
				this.dHeight = 7;
				bValid = true;
		}
		else if(size.equalsIgnoreCase("large"))
		{
				this.dLength = 18;
				this.dWidth = 12;
				this.dHeight = 9;
				bValid = true;
		}
		else if(size.equalsIgnoreCase("enormous"))
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
						this.size[i][j][k] = 0; //empty box
		}
		return bValid;
	}
	
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