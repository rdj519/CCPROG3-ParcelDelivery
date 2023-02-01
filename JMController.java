/** The class JMController is responsible for the manipulation of orders and
 *  commands from the customer. Ideally, this is the brains of the program.
 *  
 *  @author Reynaldo K. Delima and Nilo Cantil K. Jatico II S11A
 *  @version 1.00
 */

import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JOptionPane;


public class JMController extends TimerTask implements ActionListener 
{
	/* Attributes */
	
	private JMGUI gui;
	private Customer customer;
	
	/*
	 * to be used in inner program:
	 * 
	private itemOpen itemO;
	private parcelOpen parcelO;
	*/
	private Parcel oneParcel; //placeholder parcel
	private int itemCount; //counts the number of items currently placed
	private int parcelCount; //counts the number of parcels currently placed
	private String strPass; //password for admin
	
	private LocalDate dDate;
	private Timer time;
	private int nDelay, nInterval; //timer var
	
	/* placeholder for data */
	private ArrayList <Item> items;
	private ArrayList <Tracker> trackers;
	private ArrayList <String> receipts;
	
	private String oneReceipt; // placeholder for receipt 
								//of one transaction (the reason for having a placeholder for this is 
								//because pwedeng i-cancel/edit ng user yung transaction niya)
	
	private boolean bOkClicked; //tells if the user clicked 'OK' again.
	
	/* Subwindows */
	private AdminOpen adWindow;
	private ItemOpen itemWindow;
	private DeleteOpen deleteWindow;
	private AdminReport adReport;
	
	/* Constructor */
	
	/** This constructor receives the GUI and the information of the customer
	 *  to initialize the controller.
	 * 
	 *  @param gui JMGUI variable
	 *  @param customer Customer variable for the information of the customer
	 */
	
    public JMController(JMGUI gui, Customer customer) {
    	
    	dDate = LocalDate.now();
    	time = new Timer();    	
    	
    	this.gui = gui;
    	this.customer = customer;
    	    	
    	gui.addListeners (this);
    	itemCount = 0;
    	parcelCount = 0;
    	strPass = "1234";
    	
    	items = new ArrayList <Item> ();
    	trackers = new ArrayList <Tracker>();
    	receipts = new ArrayList <String> ();
    	adReport = new AdminReport();
    	
    	adWindow = new AdminOpen(); 
    	deleteWindow = new DeleteOpen();
    	itemWindow = new ItemOpen();
    	
    }
    
    /* Methods */
    
    /** This method determines what the program will do
     *  when the user performs an action.
     *  
     *  @param e ActionEvent variable that is coming from the action of customer
     * 
     */
    
    public void actionPerformed (ActionEvent e)
    {
    	if(e.getActionCommand().equals("Add"))
    	{

   			itemWindow.open(this);
 
    	}
    	else if(e.getActionCommand().contentEquals("Ok"))
    	{
    		if(bOkClicked)
    		{
        		bOkClicked = false;
        		parcelCount--;
    		}
    			
    		ParcelOpen parcelO = new ParcelOpen(this);
    	}
    	else if(e.getActionCommand().contentEquals("Delete"))
    	{
    		deleteWindow.open(this);
    	}
    	else if(e.getActionCommand().equals("Confirm"))
    	{
    	       
    		try {
        		addParcel(this.oneParcel);
        		
        		int i;
        		for(i=0; i < items.size(); i++)
        			items.remove(i);
        		itemCount = 0;
        		this.gui.resetItemContent();
        		this.gui.resetPriceContent();
        		receipts.add(this.oneReceipt);
        		this.oneParcel = null;
        		this.oneReceipt = null;
        		bOkClicked = false;
        		
    		}
    		catch(Exception exc)
    		{
    			JOptionPane.showMessageDialog(null, "Error!\nNo parcel yet.");
    		} 

    	}
    	else if(e.getActionCommand().equals("Change Parcel"))
    	{
    		if(this.oneParcel != null)
    		{
        		parcelCount--;
        		
        		ParcelOpen parcelO = new ParcelOpen(this);
    		}

    	}
    	else if(e.getActionCommand().equals("Track"))
    	{
    		displayStatus(gui.getTrack());
    	}
    	else if(e.getActionCommand().equals("Report"))
    	{
    		adWindow.open(this, "report");
    	}
    	else if(e.getActionCommand().equals("Exit"))
    	{
    		adWindow.open(this, "exit");
    	}
    	
    }
    
    /** This method returns the GUI.
     * 
     *  @return GUI
     */
    
    public JMGUI getGui()
    {
    	return this.gui;
    }
    
    /** This method returns the number of items.
     * 
     *  @return number of items
     * 
     */
    
    public int getCount()
    {
    	return this.itemCount;
    }
    
    /** This method adds the number of items.
     * 
     */
    
    public void addItemCount()
    {
    	itemCount++;
    }
    
    /** This method adds the number of parcels.
     * 
     */
    
    public void addParcelCount()
    {
    	parcelCount++;
    }
    
    /** This method sets the parcel information.
     * 
     *  @param parcel Parcel object ready to be set
     */
    
    public void setParcel(Parcel parcel)
    {
    	this.oneParcel = parcel;
    }
    
    /** This method sets the receipt of the parcel.
     * 
     * 	@param s String variable of the receipt
     */
    
    public void setOneReceipt(String s)
    {
    	this.oneReceipt = s;
    }
    
    /** This method finalizes the process by adding the parcel itself to the customer's
     *  orders. Will also add the trackers because the moment the order is done, the tracking
     *  starts from preparing up to delivered.
     * 
     * 	@param parcel Parcel object ready to be added
     */
    
    //finalizes the process by adding the parcel itself to the customer's orders
    //also adds the trackers because the moment the order is done, the tracking starts (starting from preparing..etc)
    public void addParcel(Parcel parcel)
    {
    	this.customer.addParcel(parcel);
    	trackers.add(new Tracker(parcel, parcel.getRegionIndex(), parcelCount, this.getDate()));
    	time.schedule(trackers.get(parcelCount-1), nDelay, nInterval);
    	String strSequence = String.format("%03d", parcelCount);
    	gui.addStatusContent("Parcel "+ strSequence + ": " + trackers.get(parcelCount-1).toString() + "\n");
    }
    
    /** This method sets the timer delay and interval to be
     *  essentially used for the trackers.
     * 
     */
    
    public void setTimer(int nDelay, int nInterval)
    {
    	this.nDelay = nDelay;
    	this.nInterval = nInterval;
    }
    
    /* This method displays the status of the parcel through trackin number.
     * 
     * @param track String variable inputted by the customer to track the parcel
     */
    
    public void displayStatus(String track)
    {
    	int i;
    	for(i=0; i < trackers.size(); i++)
    	{
    		if(track.equals(trackers.get(i).toString()))
    				gui.displayStatus(trackers.get(i).getStatus());
    	}
    }
    
    /** This method is responsible for the removal of parcels
     *  if the customer wishes to remove a parcel from the
     *  transaction.
     *  
     *  @param i an integer variable of the index of the ArrayList of parcels
     * 
     */
    
    public void removeParcel(int i)
    {
    	this.customer.removeParcel(i);
    }
    
    /** This method returs ArrayList of Item objects.
     * 
     *  @return ArrayList of Item objects
     */
    
    public ArrayList<Item> getItems()
    {
    	return items;
    }
   
    /** This method returns the chosen Item objects from the ArrayList of Item objects.
     * 
     *  @param i an integer variable of the index from the ArrayList
     *  @return Item object
     */
    
    public Item getItem(int i)
    {
    	return items.get(i);
    }
    
    /** This method adds an Item object to the ArrayList of Item objects.
     * 
     *  @param item an Item object ready to be added to the ArrayList of Item objects
     */
    
    public void addItem(Item item)
    {
    	items.add(item);
    }
    
    /** This method deletes an Item object from the list.
     * 
     * 	@param n an integer variable that will act as an index
     * 	@return boolean variable if it is successful or not
     */
    
    public boolean deleteItem(int n)
    {
    	boolean bDeleted = false;
    	int i;
    	for(i=0; i < items.size(); i++)
    		if(i == n-1)
    		{
    			items.remove(i);
    			itemCount--; //deletes the itemcount because one of the items in the placeholder var is deleted
    			updateItemContent(true);
    			bDeleted = true;
    		}  	
    	return bDeleted;
    }
    
    /** This method updates the Item list from the left side of the display.
     * 
     * 	@param isReset a boolean variable to reset the text area
     * 
     */
    
    public void updateItemContent(boolean isReset)
    {
    	int i, n;
    	String strItem;
    	if(isReset == true)
    	{
    		n = 0;
    		gui.resetItemContent();
    	}
    	else
    		n = itemCount-1;
    	for(i=n; i < items.size(); i++)
    	{
			strItem = "Item #" + Integer.toString(i + 1) +"\n";
			
			if(items.get(i) instanceof Document)
				strItem += "Type: DOCUMENT";
			else if(items.get(i) instanceof Irregular)
				strItem += "Type: IRREGULAR";
			else if(items.get(i) instanceof Product)
				strItem += "Type: PRODUCT";
		
			strItem +=  "\nName: " + items.get(i).getName()+"\nL: " + Double.toString(items.get(i).getLength()) + "\nW: " + Double.toString(items.get(i).getWidth()) + "\nH: " + Double.toString(items.get(i).getHeight()) + "\nWght: " + Double.toString(items.get(i).getWeight()) + " grams\n\n";
			
			gui.addItemContent(strItem);
    	}
    }
    
    /** This method returns the passkey inputted by the admin.
     * 
     *  @return passkey
     */
    
    public String getPassKey()
    {
    	return this.strPass;
    }
    
    /** This method makes sure the button click will make it true;
     * 
     */
    
    public void okClicked()
    {
    	bOkClicked = true;
    }
    
    /** This method will exit the program.
     * 
     */
    
    public void exitProgram()
    {
    	gui.dispatchEvent(new WindowEvent(gui, WindowEvent.WINDOW_CLOSING));
    }
    
    /** This method will return the date of the simulation.
     * 
     * 	@return date of simulation
     */
    
    public LocalDate getDate ()
    {
        return dDate;
    }
    
    /** This method returns the Admin Report if the admin wishes to see the report.
     * 
     * 	@return variable of AdminReport
     */
    
    public AdminReport getAdminReport()
    {
    	return adReport;
    }
    
    /** This method overrides the run method.
     * 
     */
    
	@Override
	public void run() 
	{
		dDate = dDate.plusDays(1);
		gui.setDate(dDate.toString());
		/* Admin report update */
		int i;
		String s, sMan, sL, sV, sMin;
		if(parcelCount > 0)
		{
			sMan = "";
			sL = "";
			sV = "";
			sMin = "";
			
			for(i=0; i < customer.parcels.size(); i++)
			{
				s = "Parcel " + String.format("%03d", i + 1) + ": ";
				s += trackers.get(i).toString() + " (" + trackers.get(i).getStatus() + ")\n";
				if(customer.getParcel(i).getRegion().equalsIgnoreCase("Metro Manila"))
				{
					sMan += s;
					
				}
				else if(customer.getParcel(i).getRegion().equalsIgnoreCase("Luzon"))
				{
					sL += s;
					
				}
				else if(customer.getParcel(i).getRegion().equalsIgnoreCase("Visayas"))
				{
					sV += s;
					
				}
				else if(customer.getParcel(i).getRegion().equalsIgnoreCase("Mindanao"))
				{
					sMin += s;
					this.adReport.addMindanaoContent(s);
				}
			}
			this.adReport.addMetroManilaContent(sMan);
			this.adReport.addLuzonContent(sL);
			this.adReport.addVisayasContent(sV);
			this.adReport.addMindanaoContent(sMin);
			for(i=parcelCount-1; i < receipts.size(); i++)
			{
				this.adReport.addReceipt(receipts.get(i));
				this.adReport.addTrackNum(trackers.get(i).toString());
			}
				
		}
		
	}
}
    