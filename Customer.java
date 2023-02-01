import java.util.*;
/** The class Customer represents a customer or user with name and
 *  the intended region of the parcel to be delivered.
 * 
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

public class Customer
{	
	/* Constructor */
	/** This constructor receives the name of the user and the
	 *  region of the parcel that will be delivered to.
	 *  
	 *  @param name a String name
	 */
	
	public Customer (String name)
	{
		this.strName = name;
		parcels = new ArrayList <Parcel> ();
	}
	
	/* Methods */
	
	/** Adds a parcel for customerMe
	 * 
	 * @param n number of items
	 * @param type String type of parcel
	 * @param region string region destination of parcel
	 * @param recipient String name of recipient
	 * @return bValid boolean if operation of adding parcel is successful
	 */
	public boolean addParcel(int n, String type, String region, String recipient)
	{
		boolean bValid = true;
		if(type.equalsIgnoreCase("flat"))
			parcels.add(new Flat(n, region, recipient));
		else if (type.equalsIgnoreCase("box"))
			parcels.add(new Box(n, region, recipient));
		else
			bValid = false;
		return bValid;
	}
	
	/** Adds a parcel for customer
	 * 
	 * @param p Parcel
	 * @return bValid boolean if operation was a success
	 */
	public boolean addParcel(Parcel p)
	{
		boolean bValid = false;
		if(p != null)
		{
			parcels.add(p);
			bValid = true;
		}
		return bValid;
	}
	/** Removes a parcel at index i
	 * 
	 * @param i index at which the parcel is to be removed
	 * 
	 */
	public boolean removeParcel(int i)
	{
		boolean bValid = false;
		if(parcels.get(i) != null)
		{
			parcels.remove(i);
			bValid = true;
		}
		return bValid;
	}

	/** This method returns a specific parcel from an index
	 * 
	 * @return a parcel in specific index
	 */
	public Parcel getParcel(int n)
	{
		return parcels.get(n);
	}
	
	/** This method returns the name of the customer.
	 * 
	 *  @return name of the customer
	 */
	
	public String getName()
	{
		return strName;
	}
	
	public ArrayList <Parcel> getParcels()
	{
		return parcels;
	}
	/* Attributes */
	private String strName;             //Name of the recipient
	ArrayList <Parcel> parcels; //ArrayList of parcels
	
}