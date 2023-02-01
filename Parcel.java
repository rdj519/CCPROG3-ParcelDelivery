import java.util.ArrayList;

/** The class Parcel represents a Parcel object that will hold many Item objects.
 * 
 *   @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *   @version 1.00
 */

public abstract class Parcel
{
	/* Constructor */
	
	/** This constructor receives the number of items to be placed in the parcel object,
	 *  the intended location of the parcel and the name of the recipient. Also,
	 *  some of the variables are initialized in order for the Parcel object to work.
	 *  
	 *  @param nItems a whole number of the number of items in a given Parcel object
	 *  @param region a String for the intended location for a given Parcel object
	 *  @param recipient a String for the intended person to be given the Parcel object
	 */
	
	public Parcel(int nItems, String region, String recipient)
	{
		this.strReceipient = recipient;
		nNumItems = nItems;
		this.dCurrWeight = 0;
		items = new ArrayList <Item> ();          /* Note: Concept of ArrayList is used instead of Arrays */
		findRegion(region);
	}
	
	/* Methods */
	
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
	
	/** This function inputs the item in to the Parcel
	 *  This method is responsible for the input of the item in to the Parcel.
	 *  In addition, this method is responsible for the rotation of the objects in order
	 *  to successfully fit into many of the Parcel options. The result will return boolean
	 *  whether the item is placed into the Parcel object or not.
	 *  
	 *  @param item an Item object to be placed in a Parcel object
	 *  @return boolean answer if the item is successfully inserted in the Parcel object
	 */
	
	public boolean inputItem(Item item)
	{	
		boolean bValid = true;        /* Note: This boolean is defaulted to true. It will trigger false if it is unable to fit the item. */
		String sRotate = "NONE";      /* Note: This will trigger other String information if there is a rotation. */
		if(items.size() < nNumItems)
		{
			if(!(item.getWidth() <= this.dWidth && item.getLength() <= this.dLength && item.getHeight() <= this.dHeight))						/* Note: Length, Width and Height */
			{
				if(!(item.getWidth() <= this.dLength && item.getLength() <= this.dWidth && item.getHeight() <= this.dHeight))					/* Note: Width, Length and Height */
				{
					if(!(item.getHeight() <= this.dLength && item.getWidth() <= this.dWidth && item.getLength() <= this.dHeight))				/* Note: Height, Width and Length */
					{
						if(!(item.getWidth() <= this.dLength && item.getHeight() <= this.dWidth && item.getLength() <= this.dHeight))			/* Note: Width, Height and Length */
						{
							if(!(item.getHeight() <= this.dLength && item.getLength() <= this.dWidth && item.getWidth() <= this.dHeight))		/* Note: Height, Width and Length */
							{
								if(!(item.getLength() <= this.dLength && item.getHeight() <= this.dWidth && item.getWidth() <= this.dHeight))	/* Note: Length, Height and Width */
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
		
		if(bValid)             		/* Note: If item is managed to be placed in the Parcel object */
		{
			
			int i, j, k;
			int iOccupied = 0;
			int jOccupied = 0;
			int kOccupied = 0;
			
			/* Note: This is assumed that the parcel is a 3-dimension array, and it will be determined occupied if element is labelled, 1. */
			
			for(i=0; i < (int) this.dLength; i++)
				for(j=0; j < (int) this.dWidth; j++)
					for(k=0; k < (int) this.dHeight; k++)
					{
						if(size[i][j][k] != 0)
						iOccupied = i +1;
						jOccupied = j +1;
						kOccupied = k +1;
					}
			/* Note: This is to determine to add an item that can be fit by rotating. */
			if(!(iOccupied > this.dLength && jOccupied > this.dWidth && kOccupied > this.dHeight))
				switch (sRotate)
				{
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
		if(bValid) /* Note: If everything is a success, then item will be logged into the Parcel object */
		{
			dCurrWeight += item.getWeight();
			items.add(item);
		}
		return bValid;
	}
	
	/** This abstract method sets the size and attributes of the Parcel object.
	 *  
	 *  @param size represents the string (choice) corresponding to the desired change
	 */
	
	abstract boolean setSize(String size);
	
	/** This abstract method gets the size of the Parcel object.
	 * 
	 */
	
	abstract String getSize();
	
	/** This method returns the region of what the customer selected.
	 * 
	 *  @return region of where the shipment will be delivered
	 */
	
	public String getRegion ()
	{
		return strRegion[nRegionIndex];
	}
	
	/** This method returns the name of the recipient.
	 * 
	 *  @return String name of the parcel's recipient
	 */
	
	public String getRecipient()
	{
		return this.strReceipient;
	}
	
	/** This method returns the region index.
	 * 
	 *  @return the index of the region
	 */
	
	public int getRegionIndex()
	{
		return nRegionIndex;
	}
	
	/** This method returns the current weight of the Parcel object.
	 * 
	 *  @return the current weight of the Parcel
	 */
	
	public double getCurrWeight()
	{
		return this.dCurrWeight;
	}
	
	/** This method returns the number of items in the parcel.
	 *  
	 *  @return the number of items in a given parcel. (whole number) 
	 */
	
	public int getCurrItems()
	{
		return items.size();
	}
	
	/** This method returns a specific item in a parcel.
	 * 
	 *  @param n an integer that represents the index of the item in a parcel.
	 *  @return the Item object that is specifically asked for
	 */
	
	public Item getItem(int n)
	{
		return items.get(n);
	}
	
	/** This method returns the height of the parcel.
	 * 
	 *  @return the height of the parcel 
	 */
	
	public double getHeight()
	{
		return this.dHeight;
	}
	
	/** This method returns the width of the parcel.
	 * 
	 *  @return the width of the parcel 
	 */
	
	public double getWidth()
	{
		return this.dWidth;
	}
	
	/** This method returns the length of the parcel
	 * 
	 *  @return length of a parcel 
	 */
	
	public double getLength()
	{
		return this.dLength;
	}
	
	/** This method sets if the parcel will be insured or not.
	 *  
	 *  @param bDecide a boolean that would dictate whether the parcel is insured
	 */
	
	public void setInsured(boolean bDecide)
	{
		this.bIsInsured = bDecide;
	}
	
	/** This method returns the boolean value that determines whether the parcel is insured
	 * 
	 *  @return the boolean value that determines whether the parcel is insured
	 */
	
	public boolean isInsured()
	{
		return bIsInsured;
	}
	
	/** This method returns the number of items that the parcel can hold
	 * 
	 * @return the int value that represents the number of items that the parcel can hold
	 */
	
	public int getNumItems()
	{
		return nNumItems;
	}
	
	/* Attributes */
	
	protected String strReceipient;     /* String: Recipient of the Parcel */
	protected double dCurrWeight;		/* double: Current weight of the Parcel */
	protected boolean bIsInsured;		/* boolean: If Parcel is insured */
	protected double dLength;			/* double: Length of Parcel */
	protected double dWidth;			/* double: Width of Parcel */
	protected double dHeight;			/* double: Height of Parcel */
	protected final int nNumItems;		/* Final int: the number of items in a Parcel */
	protected int nRegionIndex;         /* int: Region index of array of region */
	protected static final String[] strRegion = { "Metro Manila", "Luzon", "Visayas", "Mindanao" }; /* String: Static since there are definitely four intended locations */
	protected int[][][] size;           /* int: 3-D array of the size of the parcel */
	protected ArrayList <Item> items;   /* ArrayList of Items: To place in the items in the ArrayList */
}