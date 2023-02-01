import java.util.ArrayList;

/**
 * The class Parcel represents a simple parcel object.
 *
 *
 * @author Rey Delima, Nilo Jatico
 * @version 1.00 2019/6/30
 */
abstract class Parcel
{
	
	/**This constructor initalizes the attributes of the Parcel object. 
	 * 
	 *@param nItems represets the number of the items that the customer may input
	 */
	public Parcel(int nItems, String region, String recipient)
	{
		//3D ARRAY THAT PERTAINS TO THE DIMENSION OF THE PARCEL
		this.strReceipient = recipient;
		nNumItems = nItems;
		this.dCurrWeight = 0;
		items = new ArrayList <Item> ();
		findRegion(region);
	}
	
	/** This method finds the region in the available list
	 *  of places it can be delivered. User will have to retype
	 *  if location is invalid. (Static because it can be called from the driver
	 *  before initializing an instance)
	 * 
	 *  @param thisRegion a String name of the region
	 *  @return bDetect a boolean that detects if the input is valid
	 */
	
	public boolean findRegion (String thisRegion)
	{
		String region = thisRegion;
		boolean bDetect = false;
		while(!bDetect)
		if(region.equalsIgnoreCase("Metro Manila"))
		{
			nRegionIndex = 0;
			bDetect = true;
		}
		else if(region.equalsIgnoreCase("Luzon"))
		{
			nRegionIndex = 1;
			bDetect = true;
		}
		else if(region.equalsIgnoreCase("Visayas"))
		{
			nRegionIndex = 2;
			bDetect = true;
		}
		else if(region.equalsIgnoreCase("Mindanao"))
		{
			nRegionIndex = 3;
			bDetect = true;
		}
		return bDetect;
	
	}
	
	/**This function inputs the item in to the Parcel
	 * 
	 *@param item represents the item that is to be inputed
	 *@return bValid boolean that indicates if the insertion of item is successful
	 */
	public boolean inputItem(Item item)
	{	//TO BE REVISED, IT IS 3D
		boolean bValid = true;
		String sRotate = "NONE"; //orientation of rotation
		if(items.size() < nNumItems)
		{
			if(!(item.getWidth() <= this.dWidth && item.getLength() <= this.dLength && item.getHeight() <= this.dHeight)) //LWH
			{
				if(!(item.getWidth() <= this.dLength && item.getLength() <= this.dWidth && item.getHeight() <= this.dHeight)) //WLH
				{
					if(!(item.getHeight() <= this.dLength && item.getWidth() <= this.dWidth && item.getLength() <= this.dHeight)) //HWL
					{
						if(!(item.getWidth() <= this.dLength && item.getHeight() <= this.dWidth && item.getLength() <= this.dHeight)) //WHL
						{
							if(!(item.getHeight() <= this.dLength && item.getLength() <= this.dWidth && item.getWidth() <= this.dHeight)) //HLW
							{
								if(!(item.getLength() <= this.dLength && item.getHeight() <= this.dWidth && item.getWidth() <= this.dHeight)) //LHW
								{
									bValid = false;
								}
							}
							else
							{
								sRotate = "HLW";
							}
									
						}
						else
						{
							sRotate = "WHL";
						}
					}
					else
					{
						sRotate = "HWL";
					}

				}
				else
				{
					sRotate = "WLH";
				}

			}
			else
			{
				sRotate = "LWH";
			}
				
		}
		else
			bValid = false;
		
		if(bValid)
		{
			
			int i, j, k;
			int iOccupied = 0;
			int jOccupied = 0;
			int kOccupied = 0;
			for(i=0; i < (int) this.dLength; i++)
				for(j=0; j < (int) this.dWidth; j++)
					for(k=0; k < (int) this.dHeight; k++)
					{
						if(size[i][j][k] != 0)
						iOccupied = i +1;
						jOccupied = j +1;
						kOccupied = k +1;
					}
			if(!(iOccupied > this.dLength && jOccupied > this.dWidth && kOccupied > this.dHeight))
				switch (sRotate)
				{
				//whether an item would fit is solved outside of this class..
				case "LWH":
					for(i= iOccupied; i < (int) item.getLength() ; i++)
						for(j= jOccupied; j < (int) item.getWidth(); j++)
							for(k= kOccupied; k < (int) item.getHeight(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				
				case "WLH":
					for(i= iOccupied; i < (int) item.getWidth(); i++)
						for(j= jOccupied; j < (int) item.getLength(); j++)
							for(k= kOccupied; k < (int) item.getHeight(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				case "HWL":
					for(i= iOccupied; i < (int) item.getHeight(); i++)
						for(j= jOccupied; j < (int) item.getWidth(); j++)
							for(k= kOccupied; k < (int) item.getLength(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				case "WHL":
					for(i= iOccupied ; i < (int) item.getWidth(); i++)
						for(j= jOccupied ; j < (int) item.getHeight(); j++)
							for(k= kOccupied ; k < (int) item.getLength(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				case "HLW":
					for(i= iOccupied ; i < (int) item.getHeight(); i++)
						for(j= jOccupied; j < (int) item.getLength(); j++)
							for(k= kOccupied; k < (int) item.getWidth(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				case "LHW":
					for(i= iOccupied; i < (int) item.getLength(); i++)
						for(j= jOccupied ; j < (int) item.getHeight(); j++)
							for(k= kOccupied ; k < (int) item.getWidth(); k++)
								if(size[i][j][k] == 0)
									size[i][j][k] = 1;
					break;
				}
			else
				bValid = false;

		}
		if(bValid)
		{
			dCurrWeight += item.getWeight();
			items.add(item);
		}
		return bValid;
	}
	
	
	/**This function sets the size and attributes of the Parcel object. 
	 * 
	 *@param size represents the string (choice) corresponding to the desired change
	 */
	abstract boolean setSize(String size);
	
	/**This function gets the size of the Parcel object.
	 * 
	 * @return string that represents the size of the Parcel object.
	 */
	abstract String getSize();
	
	/** This method returns the region of what the customer selected.
	 * 
	 * @return region of where the shipment will be delivered
	 */
	public String getRegion ()
	{
		return strRegion[nRegionIndex];
	}
	
	/** This method returns the name of the recipient.
	 * 
	 * @return String name of the parcel's recipient
	 */
	public String getRecipient()
	{
		return this.strReceipient;
	}
	/** This method gets the region index
	 * 
	 *  @return the integer region index
	 */
	public int getRegionIndex()
	{
		return nRegionIndex;
	}
	
	/**This function gets the current weight of the Parcel
	 * 
	 *@return the current weight of the Parcel
	 */
	public double getCurrWeight()
	{
		return this.dCurrWeight;
	}
	
	/**This function gets the number of items in the parcel
	 * 
	 *@return the int value representing the (current) number of items in the parcel 
	 */
	public int getCurrItems()
	{
		return items.size();
	}
	
	/**This function gets a specific item in an index
	 * 
	 *@param n an integer that represents the index
	 *@return the Item that is specifically asked  
	 */
	public Item getItem(int n)
	{
		return items.get(n);
	}
	
	/**This function gets the height of the parcel
	 * 
	 *@return the double that represents the height of the parcel 
	 */
	public double getHeight()
	{
		return this.dHeight;
	}
	
	/**This function gets the width of the parcel
	 * 
	 *@return the double that represents the width of the parcel 
	 */
	public double getWidth()
	{
		return this.dWidth;
	}
	
	/**This function gets the length of the parcel
	 * 
	 *@return the double that represents the length of the parcel 
	 */
	public double getLength()
	{
		return this.dLength;
	}
	
	/**This function sets the boolean value of the parcel insurance (whether the parcel is insured)
	 * 
	 *@param bDecide a boolean that would dictate whether the parcel is insured
	 */
	public void setInsured(boolean bDecide)
	{
		this.bIsInsured = bDecide;
	}
	
	/** This function returns the boolean value that determines whether the parcel is insured
	 * 
	 * @return the boolean value that determines whether the parcel is insured
	 */
	public boolean isInsured()
	{
		return bIsInsured;
	}
	
	/** This function returns the number of items that the parcel can hold
	 * 
	 * @return the int value that represents the number of items that the parcel can hold
	 */
	public int getNumItems()
	{
		return nNumItems;
	}
	/* attributes */ 
	protected String strReceipient;
	protected double dCurrWeight;
	protected boolean bIsInsured;
	protected double dLength;
	protected double dWidth;
	protected double dHeight;
	protected final int nNumItems;
	protected int nRegionIndex;           //Index of the location
	protected static final String[] strRegion = { "Metro Manila", "Luzon", "Visayas", "Mindanao" };
	protected int[][][] size;
	protected ArrayList <Item> items;
	
}